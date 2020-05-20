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
import io.boodskap.iot.OTAState;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IOTAModelVersionBatchMember;

public interface OTAModelVersionBatchMemberDAO<T extends IOTAModelVersionBatchMember> extends DAO<T> {
	
	public static <T extends IOTAModelVersionBatchMember> OTAModelVersionBatchMemberDAO<T> get() {
		return BoodskapSystem.storage().getOTAModelVersionBatchMemberDAO();
	}

	public T create(String domainKey, String batchId, String fromModel, String fromVersion, String deviceId) throws StorageException;

	public T get(String domainKey, String batchId, String fromModel, String fromVersion, String deviceId) throws StorageException;

	public void delete(String domainKey, String batchId, String deviceId) throws StorageException;

	public void delete(String domainKey, String batchId) throws StorageException;

	public long count(String domainKey, OTAState[] states) throws StorageException;

	public long count(String domainKey, String batchId, OTAState[] states) throws StorageException;
	
	public Collection<T> list(String domainKey, String batchId, OTAState[] states, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(String domainKey, String batchId, OTAState[] states, String deviceId, int page, int pageSize) throws StorageException;

	public Collection<T> search(String domainKey, String batchId, OTAState[] states, String query, int pageSize) throws StorageException;

	public default long count(String domainKey) throws StorageException{
		return count(domainKey, OTAState.values());
	}

	public default long count(String domainKey, String batchId) throws StorageException{
		return count(domainKey, batchId, OTAState.values());
	}

	public default Collection<? extends IOTAModelVersionBatchMember> list(String domainKey, String batchId, int page, int pageSize) throws StorageException{
		return list(domainKey, batchId, OTAState.values(), page, pageSize);
	}

	public default Collection<? extends IOTAModelVersionBatchMember> listNext(String domainKey, String batchId, String deviceId, int page, int pageSize) throws StorageException{
		return listNext(domainKey, batchId, OTAState.values(), deviceId, page, pageSize);
	}

	public default Collection<? extends IOTAModelVersionBatchMember> search(String domainKey, String batchId, String query, int pageSize) throws StorageException{
		return search(domainKey, batchId, OTAState.values(), query, pageSize);
	}

}
