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
import io.boodskap.iot.dao.PluginDAO;
import io.boodskap.iot.model.IPlugin;

public class PluginDAOImpl implements PluginDAO<IPlugin> {

	private final PluginDAO<IPlugin> impl;

	public PluginDAOImpl(final PluginDAO<IPlugin> impl) {
		this.impl = impl;
	}

	public IPlugin create(String pluginId, String version) {
		return impl.create(pluginId, version);
	}

	public void createOrUpdate(IPlugin e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IPlugin> load() throws StorageException {
		return impl.load();
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String id) throws StorageException {
		return impl.count(id);
	}

	public IPlugin get(String id) throws StorageException {
		return impl.get(id);
	}

	public IPlugin get(String id, String version) throws StorageException {
		return impl.get(id, version);
	}

	public IPlugin getByContextId(String contextId) throws StorageException {
		return impl.getByContextId(contextId);
	}

	public void delete(String id) throws StorageException {
		impl.delete(id);
	}

	public void delete(String id, String version) throws StorageException {
		impl.delete(id, version);
	}

	public Collection<IPlugin> list(int page, int pageSize) throws StorageException {
		return impl.list(page, pageSize);
	}

	public Collection<IPlugin> listNext(String id, String version, int page, int pageSize) throws StorageException {
		return impl.listNext(id, version, page, pageSize);
	}

}
