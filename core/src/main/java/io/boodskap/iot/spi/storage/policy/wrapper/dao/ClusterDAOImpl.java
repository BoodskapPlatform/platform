package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.ClusterDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.ICluster;
import io.boodskap.iot.spi.storage.policy.PolicyManager;

public class ClusterDAOImpl implements ClusterDAO<ICluster> {

	private final ClusterDAO<ICluster> impl;

	public ClusterDAOImpl(final ClusterDAO<ICluster> impl) {
		this.impl = impl;
	}

	public ICluster create(String domainKey, String targetDomainKey, String clusterId) {

		PolicyManager.checkWriteAccess(domainKey);
		
		return impl.create(domainKey, targetDomainKey, clusterId);
	}

	public Class<? extends ICluster> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(ICluster e) throws StorageException {
		
		PolicyManager.checkWriteAccess(e.getDomainKey());
		
		impl.createOrUpdate(e);
	}

	public EntityIterator<ICluster> load() throws StorageException {
		
		PolicyManager.checkReadAccess();
		
		return impl.load();
	}

	public long count() throws StorageException {
		
		PolicyManager.checkReadAccess();
		
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {

		PolicyManager.checkReadAccess(domainKey);
		
		return impl.count(domainKey);
	}

	public long count(String domainKey, String targetDomainKey) throws StorageException {

		PolicyManager.checkReadAccess(domainKey);
		
		return impl.count(domainKey, targetDomainKey);
	}

	public ICluster get(String domainKey, String targetDomainKey, String clusterId) throws StorageException {

		PolicyManager.checkReadAccess(domainKey);
		
		return impl.get(domainKey, targetDomainKey, clusterId);
	}

	public void delete(String domainKey, String targetDomainKey, String clusterId) throws StorageException {

		PolicyManager.checkDeleteAccess(domainKey);
		
		impl.delete(domainKey, targetDomainKey, clusterId);
	}

	public void touch(String domainKey, String targetDomainKey, String clusterId) throws StorageException {

		PolicyManager.checkWriteAccess(domainKey);
		
		impl.touch(domainKey, targetDomainKey, clusterId);
	}

	public Collection<ICluster> list(String domainKey, int page, int pageSize) throws StorageException {

		PolicyManager.checkReadAccess(domainKey);
		
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<ICluster> listNext(String domainKey, String targetDomainKey, String clusterId, int page, int pageSize) throws StorageException {

		PolicyManager.checkReadAccess(domainKey);
		
		return impl.listNext(domainKey, targetDomainKey, clusterId, page, pageSize);
	}

	public Collection<ICluster> search(String domainKey, String query, int pageSize) throws StorageException {

		PolicyManager.checkReadAccess(domainKey);
		
		return impl.search(domainKey, query, pageSize);
	}

	public Collection<ICluster> search(String query, int pageSize) throws StorageException {

		PolicyManager.checkReadAccess();
		
		return impl.search(query, pageSize);
	}

	public void delete(String domainKey) throws StorageException {

		PolicyManager.checkDeleteAccess(domainKey);
		
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String targetDomainKey) throws StorageException {

		PolicyManager.checkDeleteAccess(domainKey);
		
		impl.delete(domainKey, targetDomainKey);
	}

	public void delete() throws StorageException {

		PolicyManager.checkDeleteAccess();
		
		impl.delete();
	}

}
