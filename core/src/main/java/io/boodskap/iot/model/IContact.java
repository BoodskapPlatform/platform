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
package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=IContact.class)
public interface IContact extends IDomainObject {

	public String getEmail();

	public void setEmail(String email);

	public String getCountry();

	public void setCountry(String country);

	public String getState();

	public void setState(String state);

	public String getCity();

	public void setCity(String city);

	public String getAddress();

	public void setAddress(String address);

	public String getZipcode();

	public void setZipcode(String zipcode);

	public String getLocale();

	public void setLocale(String locale);

	public String getTimeZone();

	public void setTimeZone(String timeZone);

	public String getPrimaryPhone();

	public void setPrimaryPhone(String primaryPhone);

}
