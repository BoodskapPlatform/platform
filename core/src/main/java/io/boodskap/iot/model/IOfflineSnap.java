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
import io.boodskap.iot.dao.OfflineSnapDAO;

@JsonSerialize(as=IOfflineSnap.class)
public interface IOfflineSnap extends IDomainObject{
	
	public static IOfflineSnap create(String domainKey, String deviceId, String camera, Date stamp) {
		return BoodskapSystem.storage().getOfflineSnapDAO().create(domainKey, deviceId, camera, stamp);
	}
	
	@Override
	public default void save() {
		OfflineSnapDAO.get().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IOfflineSnap o = (IOfflineSnap) other;
		
		setDeviceId(o.getDeviceId());
		setMime(o.getMime());
		setData(o.getData());
		setCamera(o.getCamera());
		
		IDomainObject.super.copy(other);
	}
	
	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public String getMime();

	public void setMime(String mime);

	public byte[] getData();

	public void setData(byte[] data);

	public String getCamera();

	public void setCamera(String camera);

}
