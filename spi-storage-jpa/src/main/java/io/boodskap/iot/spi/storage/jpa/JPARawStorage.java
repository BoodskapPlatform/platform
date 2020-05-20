package io.boodskap.iot.spi.storage.jpa;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.RawDataDAO;
import io.boodskap.iot.model.jpa.RawData;
import io.boodskap.iot.spi.storage.IRawStorage;
import io.boodskap.iot.spi.storage.jpa.dao.RawDataDAOImpl;

public class JPARawStorage implements IRawStorage {

	protected JPARawStorage() {
	}

	@Override
	public boolean isPaginationSupported() {
		return true;
	}

	@Override
	public boolean isSearchSupported() {
		return true;
	}

	@Override
	public String getVendorInfo() {
		return "JPA (Java Persistence Architecture)";
	}

	@Override
	public String getVersion() {
		return "2.1.1";
	}

	@SuppressWarnings("unchecked")
	@Override
	public RawDataDAO<RawData> getRawDataDAO() throws StorageException {
		return RawDataDAOImpl.get();
	}

}
