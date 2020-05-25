package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IEmailGateway;

public class EmailGateway extends AbstractDomainObject implements IEmailGateway {

	private static final long serialVersionUID = 8909342397880526010L;

	private String host = "smtp.googlemail.com";
	private String user = "";
	private String password = "";
	private String primaryEmail = "";
	private String bounceEmail = "";
	private int port = 587;
	private boolean ssl = false;
	private boolean tls = true;
	private boolean debug = false;
	
	public EmailGateway() {
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getBounceEmail() {
		return bounceEmail;
	}

	public void setBounceEmail(String bounceEmail) {
		this.bounceEmail = bounceEmail;
	}

	public boolean isTls() {
		return tls;
	}

	public void setTls(boolean tls) {
		this.tls = tls;
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
		result = prime * result + ((bounceEmail == null) ? 0 : bounceEmail.hashCode());
		result = prime * result + (debug ? 1231 : 1237);
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + port;
		result = prime * result + ((primaryEmail == null) ? 0 : primaryEmail.hashCode());
		result = prime * result + (ssl ? 1231 : 1237);
		result = prime * result + (tls ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		EmailGateway other = (EmailGateway) obj;
		if (bounceEmail == null) {
			if (other.bounceEmail != null)
				return false;
		} else if (!bounceEmail.equals(other.bounceEmail))
			return false;
		if (debug != other.debug)
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (port != other.port)
			return false;
		if (primaryEmail == null) {
			if (other.primaryEmail != null)
				return false;
		} else if (!primaryEmail.equals(other.primaryEmail))
			return false;
		if (ssl != other.ssl)
			return false;
		if (tls != other.tls)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
