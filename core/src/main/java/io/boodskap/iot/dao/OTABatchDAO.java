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
import io.boodskap.iot.OTABatchState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IOTABatch;

public interface OTABatchDAO<T extends IOTABatch> extends DAO<T> {
	
	public static <T extends IOTABatch> OTABatchDAO<T> get() {
		return BoodskapSystem.storage().getOTABatchDAO();
	}

	public T create(String domainKey, String batchId) throws StorageException;

	public T get(String domainKey, String batchId) throws StorageException;

	public void delete(String domainKey, String batchId) throws StorageException;

	public long count(String domainKey, OTABatchState[] states) throws StorageException;

	public Collection<T> list(String domainKey, OTABatchState[] states, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(String domainKey, OTABatchState[] states, String batchId, int page, int pageSize) throws StorageException;

	public Collection<T> search(String domainKey, OTABatchState[] states, String query, int pageSize) throws StorageException;

	public default long count(String domainKey) throws StorageException{
		return count(domainKey, OTABatchState.values());
	}

	public default Collection<T> list(String domainKey, int page, int pageSize) throws StorageException{
		return list(domainKey, OTABatchState.values(), page, pageSize);
	}

	public default Collection<T> listNext(String domainKey, String batchId, int page, int pageSize) throws StorageException{
		return listNext(domainKey, OTABatchState.values(), batchId, page, pageSize);
	}

	public default Collection<T> search(String domainKey, String query, int pageSize) throws StorageException{
		return search(domainKey, OTABatchState.values(), query, pageSize);
	}
}
