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

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.RawDataDAO;
import io.boodskap.iot.model.IRawData;

public class RawDataDAOImpl implements RawDataDAO<IRawData> {

	private final RawDataDAO<IRawData> impl;

	public RawDataDAOImpl(final RawDataDAO<IRawData> impl) {
		this.impl = impl;
	}

	public IRawData create(String id) throws StorageException {
		return impl.create(id);
	}

	public IRawData get(String id) throws StorageException {
		return impl.get(id);
	}

	public Class<? extends IRawData> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IRawData e) throws StorageException {
		
		if(!BoodskapSystem.isLicensed()) throw new StorageException("license error");
		
		impl.createOrUpdate(e);
	}

	public void update(IRawData e) throws StorageException {
		
		if(!BoodskapSystem.isLicensed()) throw new StorageException("license error");
		
		impl.update(e);
	}

	public void updateState(IRawData e) throws StorageException {
		
		if(!BoodskapSystem.isLicensed()) throw new StorageException("license error");
		
		impl.updateState(e);
	}

	public EntityIterator<IRawData> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IRawData> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete(String id) throws StorageException {
		impl.delete(id);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
