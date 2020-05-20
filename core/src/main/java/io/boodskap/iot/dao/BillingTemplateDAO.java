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
import io.boodskap.iot.model.IBillingTemplate;

public interface BillingTemplateDAO<T extends IBillingTemplate>{
	
	public static BillingTemplateDAO<IBillingTemplate> get() {
		return BoodskapSystem.storage().getBillingTemplateDAO();
	}
	
	public Class<? extends T> clazz();
	
	public IBillingTemplate create(String templatename, String itemname);
	
	public void createOrUpdate(T e) throws StorageException;

	public EntityIterator<T> load() throws StorageException;
	
	public EntityIterator<T> load(String templatename) throws StorageException;
	
	public long count() throws StorageException;
	
	public long count(String templatename) throws StorageException;
	
	public T get(String templateName, String itemname) throws StorageException;

	public void delete() throws StorageException;
	
	public void delete(String templatename) throws StorageException;
	
	public void delete(String templateName, String itemname) throws StorageException;
	
	public Collection<T> list(int page, int pageSize) throws StorageException;
	
	public Collection<T> listNext(String templateName, String itemName, int page, int pageSize) throws StorageException;
	
	public Collection<T> search(String query, int pageSize) throws StorageException;
}
