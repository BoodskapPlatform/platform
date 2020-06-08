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

import org.json.JSONObject;
import org.slf4j.MDC;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.model.IDevice;
import io.boodskap.iot.model.IDomain;
import io.boodskap.iot.model.ILinkedDomain;
import io.boodskap.iot.model.IOrganization;
import io.boodskap.iot.model.IOrganizationDevice;
import io.boodskap.iot.model.IOrganizationUser;
import io.boodskap.iot.model.IUser;

@JsonSerialize(as=IAuthToken.class)
public interface IAuthToken extends Serializable {
	
	public static IAuthToken get() {
		return ThreadContext.AUTH.get();
	}
	
	public static void set(IAuthToken token) {
		ThreadContext.AUTH.set(token);
	}
	
	public static void clear() {
		ThreadContext.AUTH.remove();
		MDC.clear();
	}
	
	public static boolean isEngine() {
		IAuthToken token = get();
		return (null != token && token.isSystem());
	}
	
	public default String getDomainKey() {
		return (null != getUser() ? getUser().getDomainKey() : getDevice().getDomainKey());
	}

	public default boolean hasDomainKey(String domainKey) {
		
		if(getDomainKey().equals(domainKey)) return true;
		
		return (ILinkedDomain.count(getDomainKey(), domainKey) > 0);
		
	}

	public default boolean hasOrganizationId(String organizationId) {
		return IOrganization.has(getDomainKey(), organizationId);
	}

	public default boolean isDevice() {
		return null != getDevice();
	}

	public default boolean isUser() {
		return null != getUser() && getUser().isUser();
	}

	public default boolean isOrganizationUser() {
		return null != getUser() && getUser().isOrganizationUser();
	}

	public default boolean isAdmin() {
		return null != getUser() && getUser().isAdmin();
	}

	public default boolean isDomainAdmin() {
		return null != getUser() && getUser().isDomainAdmin();
	}

	public default boolean isOrganizationAdmin() {
		return null != getUser() && getUser().isOrganizationAdmin();
	}

	public default boolean isDeveloper() {
		return null != getUser() && getUser().isDeveloper();
	}

	public default boolean isValid() {
		return !isExpired();
	}
	
	public boolean isExternal();
	
	public boolean isSystem();

	public AuthType getAuthType();
	
	public IDomain getDomain();
	
	public IOrganization getOrganization();
	
	public IUser getUser();
	
	public IDevice getDevice();
	
	public IOrganizationDevice getOrganizationDevice();
	
	public IOrganizationUser getOrganizationUser();
	
	public long getCreatedAt();
	
	public boolean isExpired();
	
	public long getAccessedAt();

	public long getExpireIn();

	public String getIpAddress();
	
	public JSONObject getExtraConfig();
	
	public String getToken();

}
