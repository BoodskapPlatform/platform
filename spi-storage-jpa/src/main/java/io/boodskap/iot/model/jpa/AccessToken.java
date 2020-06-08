package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.AuthType;
import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IAccessToken;

@Entity
@Table(name="accesstoken")
public class AccessToken extends AbstractStorageObject implements IAccessToken {

	private static final long serialVersionUID = -7983470981398356497L;

	@Id
	@Column(name="token", length=SizeConstants.TOKEN_SIZE)
	private String token;

	@Column(name="extracfg", length=SizeConstants.EXTRA_CONFIG_SIZE)
	private String extraConfig;

	@Column(name="expirein")
	private long expireIn;

	@Column(name="dkey", length=SizeConstants.DOMAIN_SIZE)
	private String domainKey;

	@Column(name="orgid", length=SizeConstants.ID_SIZE)
	private String orgId;

	@Column(name="deviceid", length=SizeConstants.ID_SIZE)
	private String deviceId;

	@Column(name="userid", length=SizeConstants.ID_SIZE)
	private String userId;

	@Enumerated(EnumType.STRING)
	@Column(name="authtype")
	private AuthType authType;

	@Column(name="external")
	private boolean external;
	
	public AccessToken() {
	}

	public AccessToken(String token) {
		this.token = token;
	}

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public boolean isExternal() {
		return external;
	}

	@Override
	public void setExternal(boolean external) {
		this.external = external;
	}

	@Override
	public AuthType getAuthType() {
		return authType;
	}

	@Override
	public void setAuthType(AuthType authType) {
		this.authType = authType;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public long getExpireIn() {
		return expireIn;
	}

	@Override
	public void setExpireIn(long expireIn) {
		this.expireIn = expireIn;
	}

	@Override
	public String getExtraConfig() {
		return extraConfig;
	}

	@Override
	public void setExtraConfig(String extraConfig) {
		this.extraConfig = extraConfig;
	}

	@Override
	public String getDomainKey() {
		return domainKey;
	}

	@Override
	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	@Override
	public String getOrgId() {
		return orgId;
	}

	@Override
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

}
