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
import io.boodskap.iot.dao.RawDataDAO;
import io.boodskap.iot.model.IRawData;
import io.boodskap.iot.spi.storage.IRawStorage;
import io.boodskap.iot.spi.storage.policy.wrapper.dao.RawDataDAOImpl;

public class RawStorage implements IRawStorage {
	
	private final IRawStorage impl;

	public RawStorage(final IRawStorage impl) {
		this.impl = impl;
	}

	@Override
	public RawDataDAO<IRawData> getRawDataDAO() throws StorageException {
		return new RawDataDAOImpl(impl.getRawDataDAO());
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
