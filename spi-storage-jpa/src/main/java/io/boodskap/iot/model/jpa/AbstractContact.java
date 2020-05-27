package io.boodskap.iot.model.jpa;

import java.util.Locale;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IContact;

@MappedSuperclass
public abstract class AbstractContact extends AbstractModel implements IContact {

	private static final long serialVersionUID = -7586976732032821404L;

	@Column(name="email", length=SizeConstants.EMAIL_ID_SIZE)
	private String email = null;
	
	@Column(name="country", length=SizeConstants.COUNTRY_SIZE)
	private String country = null;
	
	@Column(name="state", length=SizeConstants.STATE_SIZE)
	private String state = null;
	
	@Column(name="city", length=SizeConstants.CITY_SIZE)
	private String city = null;
	
	@Column(name="address", length=SizeConstants.ADDRESS_SIZE)
	private String address = null;
	
	@Column(name="zipcode", length=SizeConstants.ZIPCODE_SIZE)
	private String zipcode = null;
	
	@Column(name="password", length=SizeConstants.PASSWORD_SIZE)
	private String password = null;
	
	@Column(name="locale", length=SizeConstants.LOCALE_SIZE)
	private String locale = Locale.getDefault().getISO3Country();
	
	@Column(name="timezone", length=SizeConstants.TIMEZONE_SIZE)
	private String timeZone = TimeZone.getTimeZone("GMT").getID();
	
	@Column(name="primaryphone", length=SizeConstants.PHONE_NO_SIZE)
	private String primaryPhone = null;

	public AbstractContact() {
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final String getCountry() {
		return country;
	}

	public final void setCountry(String country) {
		this.country = country;
	}

	public final String getState() {
		return state;
	}

	public final void setState(String state) {
		this.state = state;
	}

	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		this.city = city;
	}

	public final String getAddress() {
		return address;
	}

	public final void setAddress(String address) {
		this.address = address;
	}

	public final String getZipcode() {
		return zipcode;
	}

	public final void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final String getLocale() {
		return locale;
	}

	public final void setLocale(String locale) {
		this.locale = locale;
	}

	public final String getTimeZone() {
		return timeZone;
	}

	public final void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public final String getPrimaryPhone() {
		return primaryPhone;
	}

	public final void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((primaryPhone == null) ? 0 : primaryPhone.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		AbstractContact other = (AbstractContact) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (primaryPhone == null) {
			if (other.primaryPhone != null)
				return false;
		} else if (!primaryPhone.equals(other.primaryPhone))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (timeZone == null) {
			if (other.timeZone != null)
				return false;
		} else if (!timeZone.equals(other.timeZone))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

}
