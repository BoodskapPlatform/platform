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

import io.boodskap.iot.dao.OfflineStreamDAO;

@JsonSerialize(as=IOfflineStream.class)
public interface IOfflineStream extends IDomainObject{
	
	public static IOfflineStream create(String domainKey, String deviceId, String camera, String session, int frame) {
		return OfflineStreamDAO.get().create(domainKey, deviceId, camera, session, frame);
	}
	
	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public String getCamera();

	public void setCamera(String camera);

	public String getSession();

	public void setSession(String session);

	public int getFrame();

	public void setFrame(int frame);
	
	public String getMime();

	public void setMime(String mime);

	public byte[] getData();

	public void setData(byte[] data);

	public default void save() {
		OfflineStreamDAO.get().createOrUpdate(this);
	}

}
