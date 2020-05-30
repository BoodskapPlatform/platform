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

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.LinkedDomainDAO;

@JsonSerialize(as=ILinkedDomain.class)
public interface ILinkedDomain extends IDomainObject {

	public static ILinkedDomain create(String domainKey, String linkedDomainKey, String linkedApiKey) {
		return BoodskapSystem.storage().getLinkedDomainDAO().create(domainKey, linkedDomainKey, linkedApiKey);
	}	

	public default void save() {
		LinkedDomainDAO.get().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		ILinkedDomain o = (ILinkedDomain) other;
		
		setLinkedDomainKey(o.getLinkedDomainKey());
		setLinkedApiKey(o.getLinkedApiKey());
		setDisabled(o.isDisabled());
		
		IDomainObject.super.copy(other);
	}
	
	public String getLinkedDomainKey();

	public void setLinkedDomainKey(String linkedDomainKey);

	public String getLinkedApiKey();

	public void setLinkedApiKey(String linkedApiKey);

	public boolean isDisabled();
	
	public void setDisabled(boolean disabled);
}
