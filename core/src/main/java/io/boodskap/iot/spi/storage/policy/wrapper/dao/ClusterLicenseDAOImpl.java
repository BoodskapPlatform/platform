package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.ClusterLicenseDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IClusterLicense;

public class ClusterLicenseDAOImpl implements ClusterLicenseDAO<IClusterLicense> {
	
	private final ClusterLicenseDAO<IClusterLicense> impl;

	public ClusterLicenseDAOImpl(ClusterLicenseDAO<IClusterLicense> impl) {
		this.impl = impl;
	}

	public IClusterLicense create(String domainKey, String targetDomainKey, String clusterId, String licenseKey) {
		return impl.create(domainKey, targetDomainKey, clusterId, licenseKey);
	}

	public Class<? extends IClusterLicense> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IClusterLicense e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IClusterLicense> load() throws StorageException {
		return impl.load();
	}

	public long count() throws StorageException {
		return impl.count();
	}

	public long count(String domainKey) throws StorageException {
		return impl.count(domainKey);
	}

	public long count(String domainKey, String targetDomainKey) throws StorageException {
		return impl.count(domainKey, targetDomainKey);
	}

	public long count(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		return impl.count(domainKey, targetDomainKey, clusterId);
	}

	public IClusterLicense get(String domainKey, String targetDomainKey, String clusterId, String licenseKey)
			throws StorageException {
		return impl.get(domainKey, targetDomainKey, clusterId, licenseKey);
	}

	public void delete(String domainKey) throws StorageException {
		impl.delete(domainKey);
	}

	public void delete(String domainKey, String targetDomainKey) throws StorageException {
		impl.delete(domainKey, targetDomainKey);
	}

	public void delete(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		impl.delete(domainKey, targetDomainKey, clusterId);
	}

	public void delete(String domainKey, String targetDomainKey, String clusterId, String licenseKey)
			throws StorageException {
		impl.delete(domainKey, targetDomainKey, clusterId, licenseKey);
	}

	public Collection<IClusterLicense> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IClusterLicense> list(String domainKey, String targetDomainKey, String clusterId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, targetDomainKey, clusterId, page, pageSize);
	}

	public Collection<IClusterLicense> listNext(String domainKey, String targetDomainKey, String clusterId, String licenseKey, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, targetDomainKey, clusterId, licenseKey, page, pageSize);
	}

	public Collection<IClusterLicense> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public Collection<IClusterLicense> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
