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
import java.util.Date;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.model.IMessageCounter;

public interface MessageCounterDAO<T extends IMessageCounter> {
	
	public static enum ListType{
		YEAR,
		MONTH,
		DAY,
		HOUR,
		MINUTE,
		SECOND
	}
	
	public static <T extends IMessageCounter> MessageCounterDAO<T> get() {
		return BoodskapSystem.storage().getMessageCounterDAO();
	}
	
	public Class<? extends T> clazz();
	
	public void increment() throws StorageException;
	
	public long countYearly();

	public long countMonthly();

	public long countDaily();

	public long countHourly();

	public long countMinutely();

	public long countSecondly();

	public Collection<T> list(ListType type, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(ListType type, Date id, int page, int pageSize) throws StorageException;

	public Collection<T> search(ListType type, String query, int pageSize) throws StorageException;
}
