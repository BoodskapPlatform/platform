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
import io.boodskap.iot.dao.FirmwareDAO;

@JsonSerialize(as=IFirmware.class)
public interface IFirmware extends IFileContent, IDomainObject{

	public static IFirmware  create(String domainKey, String deviceModel, String version) {
		return BoodskapSystem.storage().getFirmwareDAO().create(domainKey, deviceModel, version);
	}	

	public String getDeviceModel();
	
	public void setDeviceModel(String deviceModel);

	public String getVersion();

	public void setVersion(String version);

	public String getFileName();

	public void setFileName(String fileName);

	public default void save() {
		FirmwareDAO.get().createOrUpdate(this);
	}

}
