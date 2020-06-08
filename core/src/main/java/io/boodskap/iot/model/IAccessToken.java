package io.boodskap.iot.model;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.AuthType;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AccessTokenDAO;

@JsonSerialize(as=IAccessToken.class)
public interface IAccessToken extends IStorageObject {
	
	//======================================
	// DAO Methods
	//======================================
	
	public static AccessTokenDAO<IAccessToken> dao(){
		return AccessTokenDAO.get();
	}
	
	public static IAccessToken create(String token) {
		return dao().create(token);
	}
	
	public static void createOrUpdate(IAccessToken e) throws StorageException{
		dao().createOrUpdate(e);
	}

	public static IAccessToken get(String token) throws StorageException{
		return dao().get(token);
	}
	
	public static void delete(String token) throws StorageException{
		dao().delete(token);
	}

	
	//======================================
	// Default Methods
	//======================================
	
	public default void copy(Object other) {
		
		IAccessToken o = (IAccessToken) other;
		
		setToken(o.getToken());
		setExternal(o.isExternal());
		setAuthType(o.getAuthType());
		setUserId(o.getUserId());
		setDeviceId(o.getDeviceId());
		setExpireIn(o.getExpireIn());
		setExtraConfig(o.getExtraConfig());
		
		IStorageObject.super.copy(other);
		
	}

	public default JSONObject extraConfig() {
		return new JSONObject( null != getExtraConfig() ? getExtraConfig() : "{}");
	}
	
	public default void save() throws StorageException {
		dao().createOrUpdate(this);
	}

	//======================================
	// Attributes
	//======================================
	
	public String getToken();
	
	public void setToken(String token);
	
	public boolean isExternal();
	
	public void setExternal(boolean external);
	
	public AuthType getAuthType();
	
	public void setAuthType(AuthType authType);
	
	public String getDomainKey();
	
	public void setDomainKey(String domainKey);
	
	public String getOrgId();
	
	public void setOrgId(String orgId);
	
	public String getUserId();
	
	public void setUserId(String userId);
	
	public String getDeviceId();
	
	public void setDeviceId(String deviceId);
	
	public long getExpireIn();
	
	public void setExpireIn(long expireIn);

	public String getExtraConfig();
	
	public void setExtraConfig(String extraConfig);

}
