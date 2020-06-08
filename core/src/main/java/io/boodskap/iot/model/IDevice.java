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

import io.boodskap.iot.DataChannel;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DeviceDAO;
import io.boodskap.iot.dao.EntityIterator;

@JsonSerialize(as=IDevice.class)
public interface IDevice extends IDomainObject {

	//======================================
	// DAO Methods
	//======================================
	
	public static DeviceDAO<IDevice> dao(){
		return DeviceDAO.get();
	}
	
	public static IDevice create(String domainKey, String deviceId) {
		return dao().create(domainKey, deviceId);
	}

	public static IDevice get(String domainKey, String deviceId) {
		return dao().get(domainKey, deviceId);
	}

	public static void delete(String domainKey, String deviceId) throws StorageException{
		dao().delete(domainKey, deviceId);
	}

	public static String getLinkedAssetId(String domainKey, String deviceId) throws StorageException{
		return dao().getLinkedAssetId(domainKey, deviceId);
	}

	public static Collection<IDevice> list(String domainKey, int page, int pageSize) throws StorageException{
		return dao().list(domainKey, page, pageSize);
	}

	public static Collection<IDevice> listNext(String domainKey, String deviceId, int page, int pageSize) throws StorageException{
		return dao().listNext(domainKey, deviceId, page, pageSize);
	}

	public static Collection<IDevice> search(String domainKey, String query, int pageSize) throws StorageException{
		return dao().search(domainKey, query, pageSize);
	}

	public static Class<? extends IDevice> clazz() {
		return dao().clazz();
	}
		
	public static void createOrUpdate(IDevice e) throws StorageException{
		dao().createOrUpdate(e);
	}

	public static EntityIterator<IDevice> load() throws StorageException{
		return dao().load();
	}
	
	public static EntityIterator<IDevice> load(String domainKey) throws StorageException{
		return dao().load(domainKey);
	}
	
	public static long count() throws StorageException{
		return dao().count();
	}
	
	public static long count(String  domainKey) throws StorageException{
		return dao().count(domainKey);
	}
	
	public static void delete() throws StorageException{
		dao().delete();
	}
	
	public static void delete(String domainKey) throws StorageException{
		dao().delete(domainKey);
	}

	//======================================
	// Default Methods
	//======================================
	
	public default void save() {
		dao().createOrUpdate(this);
	}
	
	@Override
	public default void copy(Object other) {
		
		IDevice o = (IDevice) other;
		
		setDeviceId(o.getDeviceId());
		setModelId(o.getModelId());
		setVersion(o.getVersion());
		setPassword(o.getPassword());
		setAssetId(o.getAssetId());
		setReportedIp(o.getReportedIp());
		setReportedPort(o.getReportedPort());
		setNodeId(o.getNodeId());
		setNodeUid(o.getNodeUid());
		setChannel(o.getChannel());
		
		IDomainObject.super.copy(other);
	}

	//======================================
	// Attriutes
	//======================================
	
	public String getDeviceId() ;

	public void setDeviceId(String deviceId);

	public String getModelId();

	public void setModelId(String modelId);

	public String getVersion();

	public void setVersion(String version);

	public String getPassword();

	public void setPassword(String password);

	public String getAssetId();

	public void setAssetId(String assetId);

	public String getReportedIp();

	public void setReportedIp(String reportedIp);

	public Integer getReportedPort();

	public void setReportedPort(Integer reportedPort);

	public String getNodeId();

	public void setNodeId(String nodeId);

	public String getNodeUid();

	public void setNodeUid(String nodeUid);

	public DataChannel getChannel();

	public void setChannel(DataChannel channel);

}
