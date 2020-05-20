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
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.RuleScriptLanguage;

@JsonSerialize(as=IRule.class)
public interface IRule extends IDomainObject {

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
	
	public Date getCreatedStamp();
	
	public void setCreatedStamp(Date createdStamp);
	
	public Date getUpdatedStamp();
	
	public void setUpdatedStamp(Date updatedStamp);
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public String getLoader();
	
	public void setLoader(String loader);
	
	public String getGlobalLoader();
	
	public void setGlobalLoader(String globalLoader);
}