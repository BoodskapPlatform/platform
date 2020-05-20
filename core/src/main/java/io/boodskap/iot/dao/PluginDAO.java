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
package io.boodskap.iot.dao;

import java.util.Collection;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IPlugin;

public interface PluginDAO<T extends IPlugin>{
	
	public static <T extends IPlugin> PluginDAO<T> get() {
		return BoodskapSystem.storage().getPluginDAO();
	}
	
	public T create(String pluginId, String version);
	
	public void createOrUpdate(T e) throws StorageException;

	public EntityIterator<T> load() throws StorageException;
	
	public long count() throws StorageException;

	public long count(String pluginId) throws StorageException;

	public T get(String pluginId) throws StorageException;

	public T get(String pluginId, String version) throws StorageException;

	public T getByContextId(String contextId) throws StorageException;

	public void delete(String pluginId) throws StorageException;

	public void delete(String pluginId, String version) throws StorageException;

	public Collection<T> list(int page, int pageSize) throws StorageException;

	public Collection<T> listNext(String pluginId, String version, int page, int pageSize) throws StorageException;

}
