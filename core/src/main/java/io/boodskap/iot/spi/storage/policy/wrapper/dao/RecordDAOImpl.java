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

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.RecordDAO;
import io.boodskap.iot.model.IDynamicRecordField;
import io.boodskap.iot.model.IRecord;

public class RecordDAOImpl implements RecordDAO<IRecord> {

	private final RecordDAO<IRecord> impl;

	public RecordDAOImpl(final RecordDAO<IRecord> impl) {
		this.impl = impl;
	}

	public IRecord create(String domainKey, String specId, String recordId) throws StorageException {
		return impl.create(domainKey, specId, recordId);
	}

	public IRecord get(String domainKey, String specId, String recordId) throws StorageException {
		return impl.get(domainKey, specId, recordId);
	}

	public Class<? extends IRecord> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IRecord e) throws StorageException {
		
		if(!BoodskapSystem.isLicensed()) throw new StorageException("license error");
		
		impl.createOrUpdate(e);
	}

	public EntityIterator<IRecord> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IRecord> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
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

	public void delete(String domainKey, String recordSpecId, String id) throws StorageException {
		impl.delete(domainKey, recordSpecId, id);
	}

	public void delete(String domainKey, String recordSpecId) throws StorageException {
		impl.delete(domainKey, recordSpecId);
	}

	public long count(String domainKey, String recordSpecId) throws StorageException {
		return impl.count(domainKey, recordSpecId);
	}

	public Collection<IRecord> list(String domainKey, String recordSpecId, int page, int pageSize)throws StorageException {
		return impl.list(domainKey, recordSpecId, page, pageSize);
	}

	public Collection<IRecord> listNext(String domainKey, String recordSpecId, String recordId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, recordSpecId, recordId, page, pageSize);
	}

	public Collection<IRecord> search(String domainKey, String recordSpecId, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, recordSpecId, query, pageSize);
	}

	public IDynamicRecordField createField() {
		return impl.createField();
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
