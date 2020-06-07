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
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IPublicFile;

public interface PublicFileDAO<T extends IPublicFile> extends DAO<T> {
	
	public static <T extends IPublicFile> PublicFileDAO<T> get() {
		return BoodskapSystem.storage().getPublicFileDAO();
	}

	public T create(String fileId) throws StorageException;

	public T get(String fileId) throws StorageException;

	public IFileContent getContent(String fileId) throws StorageException;

	public boolean has(String fileId) throws StorageException;

	public void delete(String fileId) throws StorageException;

	public void update(String fileId, String tags, String description) throws StorageException;
	
	public void update(String fileId, byte[] data, String mediaType)throws StorageException;

	public Collection<T> list(boolean load, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNext(boolean load, String fileId, int page, int pageSize) throws StorageException;
	
	public Collection<T> search(boolean load, String query, int pageSize) throws StorageException;

}
