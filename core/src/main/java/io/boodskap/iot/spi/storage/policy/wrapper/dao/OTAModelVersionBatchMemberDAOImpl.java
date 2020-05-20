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

import io.boodskap.iot.OTAState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OTAModelVersionBatchMemberDAO;
import io.boodskap.iot.model.IOTAModelVersionBatchMember;

public class OTAModelVersionBatchMemberDAOImpl implements OTAModelVersionBatchMemberDAO<IOTAModelVersionBatchMember> {

	private final OTAModelVersionBatchMemberDAO<IOTAModelVersionBatchMember> impl;

	public OTAModelVersionBatchMemberDAOImpl(final OTAModelVersionBatchMemberDAO<IOTAModelVersionBatchMember> impl) {
		this.impl = impl;
	}

	public IOTAModelVersionBatchMember create(String domainKey, String batchId, String fromModel, String fromVersion, String deviceId) throws StorageException {
		return impl.create(domainKey, batchId, fromModel, fromVersion, deviceId);
	}

	public Class<? extends IOTAModelVersionBatchMember> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOTAModelVersionBatchMember e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOTAModelVersionBatchMember> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOTAModelVersionBatchMember> load(String domainKey) throws StorageException {
		return impl.load(domainKey);
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public IOTAModelVersionBatchMember get(String domainKey, String batchId, String fromModel, String fromVersion, String deviceId) throws StorageException {
		return impl.get(domainKey, batchId, fromModel, fromVersion, deviceId);
	}

	public void delete(String domainKey, String batchId, String deviceId) throws StorageException {
		impl.delete(domainKey, batchId, deviceId);
	}

	public void delete(String domainKey, String batchId) throws StorageException {
		impl.delete(domainKey, batchId);
	}

	public long count(String domainKey, OTAState[] states) throws StorageException {
		return impl.count(domainKey, states);
	}

	public long count(String domainKey, String batchId, OTAState[] states) throws StorageException {
		return impl.count(domainKey, batchId, states);
	}

	public Collection<IOTAModelVersionBatchMember> list(String domainKey, String batchId, OTAState[] states, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, batchId, states, page, pageSize);
	}

	public Collection<IOTAModelVersionBatchMember> listNext(String domainKey, String batchId, OTAState[] states, String deviceId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, batchId, states, deviceId, page, pageSize);
	}

	public Collection<IOTAModelVersionBatchMember> search(String domainKey, String batchId, OTAState[] states, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, batchId, states, query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
