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

import io.boodskap.iot.dao.AlexaDAO;

@JsonSerialize(as=IAlexa.class)
public interface IAlexa extends IDomainObject {
	
	public static AlexaDAO<IAlexa> dao(){
		return AlexaDAO.get();
	}
	
	public static Class<? extends IAlexa> clazz() {
		return dao().clazz();
	}

	public static IAlexa create(String domainKey, String alexaId) {
		return dao().create(domainKey, alexaId);
	}

	public static IAlexa find(String domainKey, String alexaId) {
		return dao().get(domainKey, alexaId);
	}

	@Override
	public default void save() {
		IAlexa.dao().createOrUpdate(this);
	}
	
	@Override
	public default void copy(Object other) {
		
		IAlexa o = (IAlexa) other;
		
		setAlexaId(o.getAlexaId());
		setRuleType(o.getRuleType());
		setRuleName(o.getRuleName());
		setIntentName(o.getIntentName());
		setErrorResponse(o.getErrorResponse());
		
		IDomainObject.super.copy(other);
	}
	
	public String getAlexaId();
	
	public void setAlexaId(String alexaId);
	
	public String getRuleType();
	
	public void setRuleType(String ruleType);
	
	public String getRuleName();
	
	public void setRuleName(String ruleName);
	
	public String getIntentName();
	
	public void setIntentName(String intentName);
	
	public String getErrorResponse();
	
	public void setErrorResponse(String errorResponse);

}
