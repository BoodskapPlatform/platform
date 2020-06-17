package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AccessTokenDAO;
import io.boodskap.iot.model.IAccessToken;
import io.boodskap.iot.spi.storage.policy.PolicyManager;

public class AccessTokenDAOImpl implements AccessTokenDAO<IAccessToken> {

	private final AccessTokenDAO<IAccessToken> impl;

	public AccessTokenDAOImpl(final AccessTokenDAO<IAccessToken> impl) {
		this.impl = impl;
	}

	@Override
	public void createOrUpdate(IAccessToken e) throws StorageException {
		PolicyManager.checkEngineAccess();
		impl.createOrUpdate(e);
	}

	@Override
	public IAccessToken create(String token) {
		PolicyManager.checkEngineAccess();
		return impl.create(token);
	}

	@Override
	public IAccessToken get(String token) throws StorageException {
		PolicyManager.checkEngineAccess();
		return impl.get(token);
	}

	@Override
	public void delete(String token) throws StorageException {
		PolicyManager.checkEngineAccess();
		impl.delete(token);
	}

}
