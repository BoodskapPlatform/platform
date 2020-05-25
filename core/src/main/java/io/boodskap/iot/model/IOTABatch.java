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
import io.boodskap.iot.OTABatchState;
import io.boodskap.iot.dao.OTABatchDAO;

@JsonSerialize(as=IOTABatch.class)
public interface IOTABatch extends IDomainObject {
	
	public static IOTABatch create(String domainKey, String batchId) {
		return BoodskapSystem.storage().getOTABatchDAO().create(domainKey, batchId);
	}

	public String getBatchId();

	public void setBatchId(String batchId);

	public OTABatchState getState();

	public void setState(OTABatchState state);

	public Date getExpireAt();

	public void setExpireAt(Date expireAt);

	public Date getFinishedAt();

	public void setFinishedAt(Date finishedAt);

	public String getFirmwareModel();
	
	public void setFirmwareModel(String firmwareModel);
	
	public String getFirmwareVersion();
	
	public void setFirmwareVersion(String firmwareVersion);

	public default void save() {
		OTABatchDAO.get().createOrUpdate(this);
	}
}
