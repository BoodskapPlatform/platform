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
package io.boodskap.iot.spi.storage.policy.wrapper;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.MessageDAO;
import io.boodskap.iot.dao.MessageSpecDAO;
import io.boodskap.iot.dao.RecordDAO;
import io.boodskap.iot.dao.RecordSpecDAO;
import io.boodskap.iot.model.IMessage;
import io.boodskap.iot.model.IMessageSpecification;
import io.boodskap.iot.model.IRecord;
import io.boodskap.iot.model.IRecordSpecification;
import io.boodskap.iot.spi.storage.IDynamicStorage;
import io.boodskap.iot.spi.storage.policy.wrapper.dao.MessageDAOImpl;
import io.boodskap.iot.spi.storage.policy.wrapper.dao.MessageSpecDAOImpl;
import io.boodskap.iot.spi.storage.policy.wrapper.dao.RecordDAOImpl;
import io.boodskap.iot.spi.storage.policy.wrapper.dao.RecordSpecDAOImpl;

public class DynamicStorage implements IDynamicStorage {
	
	private final IDynamicStorage impl;

	public DynamicStorage(final IDynamicStorage impl) {
		this.impl = impl;
	}

	@Override
	public RecordSpecDAO<IRecordSpecification> getRecordSpecDAO() {
		return new RecordSpecDAOImpl(impl.getRecordSpecDAO());
	}

	@Override
	public MessageSpecDAO<IMessageSpecification> getMessageSpecDAO() {
		return new MessageSpecDAOImpl(impl.getMessageSpecDAO());
	}

	@Override
	public MessageDAO<IMessage> getMessageDAO() throws StorageException {
		return new MessageDAOImpl(impl.getMessageDAO());
	}

	@Override
	public RecordDAO<IRecord> getRecordDAO() throws StorageException {
		return new RecordDAOImpl(impl.getRecordDAO());
	}

	@Override
	public boolean isPaginationSupported() {
		return impl.isPaginationSupported();
	}

	@Override
	public boolean isSearchSupported() {
		return impl.isSearchSupported();
	}

	@Override
	public String getVendorInfo() {
		return impl.getVendorInfo();
	}

	@Override
	public String getVersion() {
		return impl.getVersion();
	}
}
