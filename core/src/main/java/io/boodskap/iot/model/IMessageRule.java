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

import io.boodskap.iot.dao.MessageRuleDAO;

@JsonSerialize(as=IMessageRule.class)
public interface IMessageRule extends IRule {
	
	public static MessageRuleDAO<IMessageRule> dao() {
		return MessageRuleDAO.get();
	}
	
	public static Class<? extends IMessageRule> clazz() {
		return dao().clazz();
	}
	
	public static IMessageRule create(String domainKey, String specId) {
		return dao().create(domainKey, specId);
	}

	public static IMessageRule find(String domainKey, String specId) {
		return dao().get(domainKey, specId);
	}

	public default void save() {
		IMessageRule.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IMessageRule o = (IMessageRule) other;
		
		setSpecId(o.getSpecId());
		
		IRule.super.copy(other);
	}
	
	public String getSpecId();

	public void setSpecId(String specId);

}
