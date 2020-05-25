package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IFCMGateway;

public class FCMGateway extends AbstractDomainObject implements IFCMGateway {

	private static final long serialVersionUID = -5773509529242921781L;

	private String fcmKey;
	private String url;
	private boolean debug;
	
	public FCMGateway() {
	}

	public String getFcmKey() {
		return fcmKey;
	}

	public void setFcmKey(String fcmKey) {
		this.fcmKey = fcmKey;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (debug ? 1231 : 1237);
		result = prime * result + ((fcmKey == null) ? 0 : fcmKey.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FCMGateway other = (FCMGateway) obj;
		if (debug != other.debug)
			return false;
		if (fcmKey == null) {
			if (other.fcmKey != null)
				return false;
		} else if (!fcmKey.equals(other.fcmKey))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

}
