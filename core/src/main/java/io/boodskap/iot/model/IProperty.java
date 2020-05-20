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
import io.boodskap.iot.PropertyTarget;
import io.boodskap.iot.dao.PropertyDAO;

@JsonSerialize(as=IProperty.class)
public interface IProperty extends ISystemProperty, IDomainObject {
	
	public static PropertyDAO<IProperty> dao() {
		return BoodskapSystem.storage().getPropertyDAO();
	}
	
	public static Class<? extends IProperty> clazz() {
		return dao().clazz();
	}

	public static IProperty create(String domainKey, PropertyTarget target, String targetId, String name) {
		return dao().create(domainKey, target, targetId, name);
	}

	public static IProperty find(String domainKey, PropertyTarget target, String targetId, String name) {
		return dao().get(domainKey, target, targetId, name);
	}

	public default void save() {
		IProperty.dao().createOrUpdate(this);
	}

	public PropertyTarget getTarget();

	public void setTarget(PropertyTarget target);

	public String getTargetId();

	public void setTargetId(String targetId);

}
