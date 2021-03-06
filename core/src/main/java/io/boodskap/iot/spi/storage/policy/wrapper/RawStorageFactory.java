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

import io.boodskap.iot.IConfig;
import io.boodskap.iot.PlatformException;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.spi.storage.IRawStorage;
import io.boodskap.iot.spi.storage.IRawStorageFactory;

public class RawStorageFactory implements IRawStorageFactory {
	
	private IRawStorageFactory implementation;
	private IRawStorage storage;

	public RawStorageFactory() {
	}

	public IRawStorageFactory getImplementation() {
		return implementation;
	}

	public void setImplementation(IRawStorageFactory implementation) {
		this.implementation = implementation;
		this.storage = new RawStorage(implementation.getRawStorage());
	}

	@Override
	public String getConfigSectionName() {
		return implementation.getConfigSectionName();
	}

	@Override
	public void setConfigClass(Class<? extends IConfig> config) {
		implementation.setConfigClass(config);
	}

	@Override
	public Class<? extends IConfig> getConfigClass() {
		return implementation.getConfigClass();
	}

	@Override
	public void init(IConfig config) throws PlatformException {
		implementation.init(config);
	}

	@Override
	public void dispose() throws PlatformException {
		if(null != implementation) implementation.dispose();
	}

	@Override
	public IRawStorage getRawStorage() throws StorageException {
		return storage;
	}

}
