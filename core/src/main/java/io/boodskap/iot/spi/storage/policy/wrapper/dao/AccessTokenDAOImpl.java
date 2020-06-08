package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AccessTokenDAO;
import io.boodskap.iot.model.IAccessToken;

public class AccessTokenDAOImpl implements AccessTokenDAO<IAccessToken> {

	private final AccessTokenDAO<IAccessToken> impl;

	public AccessTokenDAOImpl(final AccessTokenDAO<IAccessToken> impl) {
		this.impl = impl;
	}

	@Override
	public void createOrUpdate(IAccessToken e) throws StorageException {
		impl.createOrUpdate(e);
	}

	@Override
	public IAccessToken create(String token) {
		return impl.create(token);
	}

	@Override
	public IAccessToken get(String token) throws StorageException {
		return impl.get(token);
	}

	@Override
	public void delete(String token) throws StorageException {
		impl.delete(token);
	}

}
