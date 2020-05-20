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
import io.boodskap.iot.model.IScheduledRule;

public interface ScheduledRuleDAO<T extends IScheduledRule> extends DAO<T> {
	
	public static <T extends IScheduledRule> ScheduledRuleDAO<T> get() {
		return BoodskapSystem.storage().getScheduledRuleDAO();
	}

	public T create(String domainKey, String ruleId) throws StorageException;

	public T get(String domainKey, String ruleId) throws StorageException;

	public void delete(String domainKey, String ruleId) throws StorageException;

	public Collection<T> list(boolean load, String domainKey, int page, int pageSize) throws StorageException;

	public Collection<T> listNext(boolean load, String domainKey, String ruleId, int page, int pageSize) throws StorageException;

	public Collection<String> listIds(String domainKey, int page, int pageSize) throws StorageException;

	public Collection<String> listIdsNext(String domainKey, String ruleId, int page, int pageSize) throws StorageException;

	public Collection<T> search(boolean load, String domainKey, String query, int pageSize) throws StorageException;

}
