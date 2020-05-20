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

@JsonSerialize(as=IOTAModelVersionBatchMember.class)
public interface IOTAModelVersionBatchMember extends IOTAModelBatchMember {

	public static IOTAModelVersionBatchMember create(String domainKey, String batchId, String fromModel, String fromVersion, String deviceId) {
		return BoodskapSystem.storage().getOTAModelVersionBatchMemberDAO().create(domainKey, batchId, fromModel, fromVersion, deviceId);
	}
	
	public String getFromModel();
	
	public void setFromModel(String fromModel);
	
	public String getFromVersion();
	
	public void setFromVersion(String fromVersion);
}
