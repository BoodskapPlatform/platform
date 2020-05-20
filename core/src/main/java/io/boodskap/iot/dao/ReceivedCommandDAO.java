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
import io.boodskap.iot.model.INameValuePair;
import io.boodskap.iot.model.IReceivedCommand;

public interface ReceivedCommandDAO<T extends IReceivedCommand> extends DAO<T> {
	
	public static ReceivedCommandDAO<IReceivedCommand> get() {
		return BoodskapSystem.storage().getReceivedCommandDAO();
	}
	
	public Class<? extends INameValuePair> nvPairClazz();

	public T create(String domainKey, String requestId);
	
	public T get(String domainKey, String requestId) throws StorageException;
	
	public void delete(String domainKey, String requestId) throws StorageException;
	
	public Collection<T> list(String domainKey, int page, int pageSize) throws StorageException;
	
	public Collection<T> listNext(String domainKey, String requestId, int page, int pageSize) throws StorageException;
}
