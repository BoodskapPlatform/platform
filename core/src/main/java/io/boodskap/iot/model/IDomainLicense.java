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

import io.boodskap.iot.dao.DomainLicenseDAO;

@JsonSerialize(as=IDomainLicense.class)
public interface IDomainLicense extends IDomainObject {

	public static DomainLicenseDAO<IDomainLicense> dao(){
		return DomainLicenseDAO.get();
	}
	
	public static IDomainLicense  create(String domainKey) {
		return dao().create(domainKey);
	}	

	public static IDomainLicense  find(String domainKey) {
		return dao().get(domainKey);
	}	

	public default void save() {
		IDomainLicense.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDomainLicense o = (IDomainLicense) other;
		
		setLicense(o.getLicense());
		
		IDomainObject.super.copy(other);
	}

	public byte[] getLicense();

	public void setLicense(byte[] license);
	
}
