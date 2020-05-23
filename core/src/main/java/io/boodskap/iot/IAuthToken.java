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
import java.util.List;
import java.util.Map;

import org.slf4j.MDC;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=IAuthToken.class)
public interface IAuthToken extends Serializable {
	
	public static IAuthToken get() {
		return ThreadContext.AUTH.get();
	}
	
	public static void clear() {
		ThreadContext.AUTH.remove();
		MDC.clear();
	}
	
	public void touch();
	
	public boolean isExpired();
	
	public long getAccessedAt();

	public String getDomainKey();

	public String getUser();

	public String getApiKey();
	
	public String getOrganizationId();

	public boolean isValid();

	public boolean isUser();

	public boolean isOrganizationUser();

	public boolean isDeveloper();

	public boolean isOrganizationAdmin();

	public boolean isDomainAdmin();

	public boolean isAdmin();
	
	public String getToken();

	public long getExpireIn();

	public String getIpAddress();

	public boolean hasRole(String role);
	
	public boolean hasDomainKey(String domainkey);
	
	public boolean hasAccess(Access access);
	
	public AuthType getAuthType();
	
	public List<String> getRoles();
	
	public Map<String,String> getLinkedTokens();
	
	public String getThisOrMyDomainKey(String dkey);
	
	public String getThisOrMyOrDefaultDomainKey(String dkey);
	
	public boolean hasOrganizationId(String orgId);
	
}
