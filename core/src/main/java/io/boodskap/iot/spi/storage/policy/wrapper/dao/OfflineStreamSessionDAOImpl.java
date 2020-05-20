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
import io.boodskap.iot.dao.OfflineStreamSessionDAO;
import io.boodskap.iot.model.IOfflineStreamSession;

public class OfflineStreamSessionDAOImpl implements OfflineStreamSessionDAO<IOfflineStreamSession> {

	private final OfflineStreamSessionDAO<IOfflineStreamSession> impl;

	public OfflineStreamSessionDAOImpl(final OfflineStreamSessionDAO<IOfflineStreamSession> impl) {
		this.impl = impl;
	}

	public IOfflineStreamSession create(String domainKey, String deviceId, String camera, String session) throws StorageException {
		return impl.create(domainKey, deviceId, camera, session);
	}

	public Class<? extends IOfflineStreamSession> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IOfflineStreamSession e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IOfflineStreamSession> load() throws StorageException {
		return impl.load();
	}

	public EntityIterator<IOfflineStreamSession> load(String domainKey) throws StorageException {
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

	public IOfflineStreamSession get(String domainKey, String deviceId, String camera, String session) throws StorageException {
		return impl.get(domainKey, deviceId, camera, session);
	}

	public long count(String domainKey, String deviceId) throws StorageException {
		return impl.count(domainKey, deviceId);
	}

	public long count(String domainKey, String deviceId, String camera) throws StorageException {
		return impl.count(domainKey, deviceId, camera);
	}

	public void delete(String domainKey, String deviceId) throws StorageException {
		impl.delete(domainKey, deviceId);
	}

	public void delete(String domainKey, String deviceId, String camera) throws StorageException {
		impl.delete(domainKey, deviceId, camera);
	}

	public void delete(String domainKey, String deviceId, String camera, String session) throws StorageException {
		impl.delete(domainKey, deviceId, camera, session);
	}

	public Collection<String> listSessions(String domainKey, String deviceId, String camera, int page, int pageSize) {
		return impl.listSessions(domainKey, deviceId, camera, page, pageSize);
	}

	public Collection<String> listSessionsNext(String domainKey, String deviceId, String camera, String session, int page, int pageSize) {
		return impl.listSessionsNext(domainKey, deviceId, camera, session, page, pageSize);
	}

	public Collection<IOfflineStreamSession> list(String domainKey, String deviceId, String camera, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, deviceId, camera, page, pageSize);
	}

	public Collection<IOfflineStreamSession> listNext(String domainKey, String deviceId, String camera, String session, int frame, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, deviceId, camera, session, frame, page, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
