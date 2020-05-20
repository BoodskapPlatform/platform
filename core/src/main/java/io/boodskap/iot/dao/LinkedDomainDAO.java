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
import io.boodskap.iot.model.ILinkedDomain;

public interface LinkedDomainDAO<T extends ILinkedDomain> extends DAO<T> {
	
	public static LinkedDomainDAO<ILinkedDomain> get() {
		return BoodskapSystem.storage().getLinkedDomainDAO();
	}

	public T create(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException;
	
	public T get(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException;
	
	public long count(String domainKey, String linkedDomainKey) throws StorageException;
	
	public long countLinked(String linkedDomainKey) throws StorageException;

	public void setState(String domainKey, String linkedDomainKey, boolean state) throws StorageException;

	public void setState(String domainKey, String linkedDomainKey, String linkedApiKey, boolean state) throws StorageException;

	public void delete(String domainKey, String linkedDomainKey) throws StorageException;

	public void delete(String domainKey, String linkedDomainKey, String linkedApiKey) throws StorageException;

	public Collection<T> list(String linkedDomainKey, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(String linkedDomainKey, String domainKey, int page, int pageSize) throws StorageException;

	public Collection<T> listLinked(String domainKey, int page, int pageSize) throws StorageException;

	public Collection<T> listLinkedNext(String domainKey, String linkedDomainKey, int page, int pageSize) throws StorageException;

}
