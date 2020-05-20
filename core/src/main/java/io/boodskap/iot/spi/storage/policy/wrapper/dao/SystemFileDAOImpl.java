package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.SystemFileDAO;
import io.boodskap.iot.model.ISystemFile;

public class SystemFileDAOImpl implements SystemFileDAO<ISystemFile> {

	private final SystemFileDAO<ISystemFile> impl;

	public SystemFileDAOImpl(final SystemFileDAO<ISystemFile> impl) {
		this.impl = impl;
	}

	public ISystemFile create(String fileId) throws StorageException {
		return impl.create(fileId);
	}

	public Class<? extends ISystemFile> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ISystemFile e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<ISystemFile> load() throws StorageException {
		return impl.load();
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public ISystemFile get(String fileId) throws StorageException {
		return impl.get(fileId);
	}

	public void delete(String fileId) throws StorageException {
		impl.delete(fileId);
	}

}
