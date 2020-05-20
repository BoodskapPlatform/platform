/*******************************************************************************
 * Copyright (C) 2019 Boodskap Inc
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package io.boodskap.iot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;

import io.boodskap.iot.dao.LinkedDomainDAO;
import io.boodskap.iot.dao.UserRoleDAO;

public class AuthToken implements Serializable {

	private static final long serialVersionUID = -5269460630104898930L;

	private String token;
	private String domainKey;
	private String apiKey;
	private String user ;
	private long expireIn;
	private String ipAddress;
	private boolean device;
	private long accessedAt = System.currentTimeMillis();
	
	public static AuthToken get() {
		return ThreadContext.AUTH.get();
	}
	
	protected static AuthToken system() {
		
		AuthToken token = get();
		
		token.setDomainKey(BoodskapSystem.config().getDomainKey());
		token.setApiKey(BoodskapSystem.config().getApiKey());
		token.setToken(String.format("%s:%s", token.getDomainKey(), token.getApiKey()));
		token.setUser("admin");
		token.update();
		
		return token;
	}
	
	public static void clear() {
		ThreadContext.AUTH.remove();
		MDC.clear();
		//org.apache.log4j.MDC.clear();
	}
	
	protected AuthToken(){
		update();
	}
	
	public void update() {
		
		MDC.put("DOMAIN", getDomainKey());
		MDC.put("USER", String.format("%s:%s", isDevice() ? "D" : "U", getUser()));
		MDC.put("IP", getIpAddress());
		//org.apache.log4j.MDC.put("DOMAIN", getDomainKey());
		//org.apache.log4j.MDC.put("USER", getUser());
		//org.apache.log4j.MDC.put("IP", getIpAddress());
		accessedAt = System.currentTimeMillis();
		
		ThreadContext.AUTH.set(this);
		
		if(null != token) {
			CacheStore.get().getAuthCache().put(token, this);
		}
	}
	
	public boolean isExpired() {
		if(expireIn <= 0) return false;
		return (( System.currentTimeMillis() - accessedAt) >= expireIn);
	}
	
	public long getAccessedAt() {
		return accessedAt;
	}

	public String getDomainKey() {
		return (null != domainKey ? domainKey : "nodomain");
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getUser() {
		return (user == null ? "nouser" : user);
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public boolean isValid() {
		
		if(isExpired()) return false;
		if(StringUtils.isBlank(token)) return false;
		if(StringUtils.isBlank(user)) return false;
		if(StringUtils.isBlank(domainKey)) return false;
		if(StringUtils.isBlank(apiKey)) return false;
		
		return true;
	}

	public boolean isAdmin(){
		return hasRole("admin");
	}

	
	public boolean isDomainAdmin(){
		return hasRole("domainadmin") || hasRole("admin");
	}

	public boolean isOrganizationAdmin(){
		return hasRole("orgadmin") || hasRole("domainadmin") || hasRole("admin");
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(long expireIn) {
		this.expireIn = expireIn;
	}
	
	public String getIpAddress() {
		return (ipAddress == null ? "noip" : ipAddress);
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public boolean isDevice() {
		return device;
	}

	public void setDevice(boolean device) {
		this.device = device;
	}

	public boolean hasRole(String name){
		return isValid() && (null != UserRoleDAO.get().get(domainKey, user, name));
	}
	
	public boolean hasDomainKey(String domainKey) {
		if(isValid() && domainKey.equals(domainKey)) return true;
		return LinkedDomainDAO.get().count(this.domainKey, domainKey) > 0;
	}

	public boolean hasAccess(Access access) {
		return isValid() && BoodskapSystem.storage().getDomainAccessDAO().has(domainKey, access);
	}
	
	public List<String> getRoles(){
		List<String> roles = new ArrayList<>();
		UserRoleDAO.get().list(domainKey, user).forEach(r -> {roles.add(r.getName());});
		return roles;
	}

	public Map<String,String> getLinkedTokens() {
		Map<String,String> tokens = new HashMap<>();
		LinkedDomainDAO.get().listLinked(domainKey, 0, 2500).forEach(e -> {
			tokens.put(e.getLinkedDomainKey(), e.getLinkedApiKey());
		});;
		return tokens;
	}
	
	public String getThisOrMyDomainKey(String dkey) {
		if(StringUtils.isNotBlank(dkey)) return dkey;
		return this.domainKey;
	}
	
	public String getThisOrMyOrDefaultDomainKey(String dkey) {
		if(StringUtils.isNotBlank(dkey)) return dkey;
		if(StringUtils.isNotBlank(this.domainKey)) return this.domainKey;
		return BoodskapSystem.config().getDomainKey();
	}
	
	public static void checkAdmin() {
		if(!AuthToken.get().isAdmin()) throw new ApiAccessException("Admin access denied");
	}
	
	public static void checkDomainAccess(String domainKey) {
		if(!AuthToken.get().hasDomainKey(domainKey))throw new ApiAccessException(String.format("Domain:%s not authorized", domainKey));
	}
	
	public static void checkDomainAdminAccess(String domainKey) {
		if(!AuthToken.get().isDomainAdmin())throw new ApiAccessException(String.format("Needs domain admin privilege", domainKey));
		if(!AuthToken.get().hasDomainKey(domainKey))throw new ApiAccessException(String.format("Domain:%s not authorized", domainKey));
	}

}
