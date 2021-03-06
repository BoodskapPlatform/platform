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

@JsonSerialize(as=IGroup.class)
public interface IGroup extends IDomainObject {

	@Override
	public default void copy(Object other) {
		
		IGroup o = (IGroup) other;
		
		setGroupId(o.getGroupId());
		setIndividualBroadcast(o.isIndividualBroadcast());
		setGroupEmail(o.getGroupEmail());
		setGroupPhone(o.getGroupPhone());
		
		IDomainObject.super.copy(other);
	}

	public String getGroupId();

	public void setGroupId(String groupId);

	public void setIndividualBroadcast(boolean individualBroadcast);
	
	public boolean isIndividualBroadcast();

	public String getGroupEmail();
	
	public void setGroupEmail(String groupEmail);

	public String getGroupPhone();
	
	public void setGroupPhone(String groupPhone);
}
