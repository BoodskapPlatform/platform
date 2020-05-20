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
package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.FirmwareDAO;
import io.boodskap.iot.model.IFirmware;

public class FirmwareDAOImpl implements FirmwareDAO<IFirmware> {

	private final FirmwareDAO<IFirmware> impl;

	public FirmwareDAOImpl(final FirmwareDAO<IFirmware> impl) {
		this.impl = impl;
	}

	public IFirmware create(String domainKey, String deviceModel, String version) throws StorageException {
		return impl.create(domainKey, deviceModel, version);
	}

	public Class<? extends IFirmware> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IFirmware e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IFirmware> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IFirmware> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public IFirmware get(boolean loadContent, String domainKey, String deviceModel, String version) throws StorageException {
		return impl.get(loadContent, domainKey, deviceModel, version);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String deviceModel) throws StorageException {
		impl.delete(domainKey, deviceModel);
	}

	public void delete(String domainKey, String deviceModel, String version) throws StorageException {
		impl.delete(domainKey, deviceModel, version);
	}

	public long count(String domainKey, String deviceModel) throws StorageException {
		return impl.count(domainKey, deviceModel);
	}

	public Collection<IFirmware> list(boolean loadContent, String domainKey, String deviceModel, int page, int pageSize) throws StorageException {
		return impl.list(loadContent, domainKey, deviceModel, page, pageSize);
	}

	public Collection<IFirmware> listNext(boolean loadContent, String domainKey, String deviceModel, String version, int page, int pageSize) throws StorageException {
		return impl.listNext(loadContent, domainKey, deviceModel, version, page, pageSize);
	}

	public Collection<IFirmware> search(boolean loadContent, String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(loadContent, domainKey, query, pageSize);
	}

	public Collection<IFirmware> search(boolean loadContent, String domainKey, String deviceModel, String query, int pageSize) throws StorageException {
		return impl.search(loadContent, domainKey, deviceModel, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
