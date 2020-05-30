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

import io.boodskap.iot.dao.DomainNodeDAO;

@JsonSerialize(as=IDomainNode.class)
public interface IDomainNode extends IDomainObject{

	public static DomainNodeDAO<IDomainNode> dao(){
		return DomainNodeDAO.get();
	}
	
	public static Class<? extends IDomainNode> clazz() {
		return dao().clazz();
	}
	
	public static IDomainNode create(String domainKey, String nodeId) {
		return dao().create(domainKey, nodeId);
	}	

	public static IDomainNode find(String domainKey, String nodeId) {
		return dao().get(domainKey, nodeId);
	}	

	public default void save() {
		IDomainNode.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDomainNode o = (IDomainNode) other;
		
		setNodeId(o.getNodeId());
		
		IDomainObject.super.copy(other);
	}

	public String getNodeId();

	public void setNodeId(String nodeId);
	
}
