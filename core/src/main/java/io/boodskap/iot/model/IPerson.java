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

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=IPerson.class)
public interface IPerson extends IContact {

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public String getPassword();

	public void setPassword(String password);

	public int getWorkHourStart();

	public void setWorkHourStart(int workHourStart);

	public int getWorkHourEnd();

	public void setWorkHourEnd(int workHourEnd);

	public Collection<Integer> getWorkDays();
	
	public void setWorkDays(Collection<Integer> workDays);

	public default String getName() {
		
		StringBuffer sb = new StringBuffer();
		
		if(StringUtils.isNotBlank(getFirstName())) {
			sb.append(getFirstName());
		}
		
		if(StringUtils.isNotBlank(getLastName())) {
			if(sb.length() > 0) sb.append(" ");
			sb.append(getLastName());
		}
		
		return sb.toString();
	}
}
