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

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.RuleScriptLanguage;

@JsonSerialize(as=IRule.class)
public interface IRule extends IDomainObject {

	@Override
	public default void copy(Object other) {
		
		IRule o = (IRule) other;
		
		setLanguage(o.getLanguage());
		setCode(o.getCode());
		setContexts(o.getContexts());
		setPlugins(o.getPlugins());
		setCompilable(o.isCompilable());
		setLoader(o.getLoader());
		setGlobalLoader(o.getGlobalLoader());
		
		IDomainObject.super.copy(other);
	}

	public RuleScriptLanguage getLanguage();

	public void setLanguage(RuleScriptLanguage language);

	public String getCode();

	public void setCode(String code);

	public Collection<String> getContexts();
	
	public void setContexts(Collection<String> contexts);
	
	public Collection<String> getPlugins();
	
	public void setPlugins(Collection<String> plugins);
	
	public boolean isCompilable();
	
	public void setCompilable(boolean compilable);
	
	public String getLoader();
	
	public void setLoader(String loader);
	
	public String getGlobalLoader();
	
	public void setGlobalLoader(String globalLoader);
}
