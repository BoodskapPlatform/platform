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

import io.boodskap.iot.OTABatchState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTABatchDAO;
import io.boodskap.iot.model.IOTABatch;

public class OTABatchDAOImpl implements OTABatchDAO<IOTABatch> {

	private final OTABatchDAO<IOTABatch> impl;

	public OTABatchDAOImpl(final OTABatchDAO<IOTABatch> impl) {
		this.impl = impl;
	}

	public IOTABatch create(String domainKey, String batchId) throws StorageException {
		return impl.create(domainKey, batchId);
	}

	public Class<? extends IOTABatch> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOTABatch e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOTABatch> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOTABatch> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public IOTABatch get(String domainKey, String batchId) throws StorageException {
		return impl.get(domainKey, batchId);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String batchId) throws StorageException {
		impl.delete(domainKey, batchId);
	}

	public long count(String domainKey, OTABatchState[] states) throws StorageException {
		return impl.count(domainKey, states);
	}

	public Collection<IOTABatch> list(String domainKey, OTABatchState[] states, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, states, page, pageSize);
	}

	public Collection<IOTABatch> listNext(String domainKey, OTABatchState[] states, String batchId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, states, batchId, page, pageSize);
	}

	public Collection<IOTABatch> search(String domainKey, OTABatchState[] states, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, states, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
