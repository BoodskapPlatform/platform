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
import io.boodskap.iot.dao.RecordSpecDAO;
import io.boodskap.iot.model.IRecordField;
import io.boodskap.iot.model.IRecordSpecification;

public class RecordSpecDAOImpl implements RecordSpecDAO<IRecordSpecification> {

	private final RecordSpecDAO<IRecordSpecification> impl;

	public RecordSpecDAOImpl(final RecordSpecDAO<IRecordSpecification> impl) {
		this.impl = impl;
	}

	public Class<? extends IRecordSpecification> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IRecordSpecification e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IRecordSpecification> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IRecordSpecification> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

	public Class<? extends IRecordField> fieldClazz() {
		return impl.fieldClazz();
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public boolean canAddField() {
		return impl.canAddField();
	}

	public boolean canDropField() {
		return impl.canDropField();
	}

	public boolean canModifyField() {
		return impl.canModifyField();
	}

	public IRecordSpecification create(String domainKey, String specId) throws StorageException {
		return impl.create(domainKey, specId);
	}

	public IRecordSpecification get(String domainKey, String specId) throws StorageException {
		return impl.get(domainKey, specId);
	}

	public void delete(String domainKey, String specId) throws StorageException {
		impl.delete(domainKey, specId);
	}

	public Collection<IRecordSpecification> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IRecordSpecification> listNext(String domainKey, String specId, int page, int pageSize)
			throws StorageException {
		return impl.listNext(domainKey, specId, page, pageSize);
	}

	public Collection<IRecordSpecification> search(String domainKey, String query, int pageSize)
			throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

}
