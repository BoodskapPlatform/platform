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

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.OTAState;
import io.boodskap.iot.dao.OTABatchMemberDAO;

@JsonSerialize(as=IOTABatchMember.class)
public interface IOTABatchMember extends IDomainObject {
	
	public static IOTABatchMember create(String domainKey, String batchId, String deviceId) {
		return BoodskapSystem.storage().getOTABatchMemberDAO().create(domainKey, batchId, deviceId);
	}

	public String getBatchId();

	public void setBatchId(String batchId);

	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public OTAState getState();

	public void setState(OTAState state);

	public Date getBeginStamp();

	public void setBeginStamp(Date beginStamp);

	public Date getEndStamp();

	public void setEndStamp(Date endStamp);

	public int getFailureCount();

	public void setFailureCount(int failureCount);

	public Date getUpdatedStamp();

	public void setUpdatedStamp(Date updatedStamp);

	public default void save() {
		OTABatchMemberDAO.get().createOrUpdate(this);
	}

}
