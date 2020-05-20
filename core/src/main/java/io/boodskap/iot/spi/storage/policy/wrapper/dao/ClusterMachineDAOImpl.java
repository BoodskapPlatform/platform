package io.boodskap.iot.spi.storage.policy.wrapper.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.ClusterMachineDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IClusterMachine;

public class ClusterMachineDAOImpl implements ClusterMachineDAO<IClusterMachine> {

	private final ClusterMachineDAO<IClusterMachine> impl;

	public ClusterMachineDAOImpl(final ClusterMachineDAO<IClusterMachine> impl) {
		this.impl = impl;
	}

	public IClusterMachine create(String domainKey, String targetDomainKey, String clusterId, String machineId) {
		return impl.create(domainKey, targetDomainKey, clusterId, machineId);
	}

	public Class<? extends IClusterMachine> clazz() {
		return impl.clazz();
	}

	public void createOrUpdate(IClusterMachine e) throws StorageException {
		impl.createOrUpdate(e);
	}

	public EntityIterator<IClusterMachine> load() throws StorageException {
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

	public long countCpuCores() throws StorageException {
		return impl.countCpuCores();
	}

	public long countCpuCores(String domainKey) throws StorageException {
		return impl.countCpuCores(domainKey);
	}

	public long countCpuCores(String domainKey, String targetDomainKey) throws StorageException {
		return impl.countCpuCores(domainKey, targetDomainKey);
	}

	public long countCpuCores(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		return impl.countCpuCores(domainKey, targetDomainKey, clusterId);
	}

	public IClusterMachine get(String domainKey, String targetDomainKey, String clusterId, String machineId)
			throws StorageException {
		return impl.get(domainKey, targetDomainKey, clusterId, machineId);
	}

	public void touch(String domainKey, String targetDomainKey, String clusterId, String machineId)
			throws StorageException {
		impl.touch(domainKey, targetDomainKey, clusterId, machineId);
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

	public void delete(String domainKey, String targetDomainKey, String clusterId, String machineId)
			throws StorageException {
		impl.delete(domainKey, targetDomainKey, clusterId, machineId);
	}

	public Collection<IClusterMachine> list(String domainKey, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, page, pageSize);
	}

	public Collection<IClusterMachine> list(String domainKey, String targetDomainKey, String clusterId, int page, int pageSize) throws StorageException {
		return impl.list(domainKey, targetDomainKey, clusterId, page, pageSize);
	}

	public Collection<IClusterMachine> listNext(String domainKey, String targetDomainKey, String clusterId, String machineId, int page, int pageSize) throws StorageException {
		return impl.listNext(domainKey, targetDomainKey, clusterId, machineId, page, pageSize);
	}

	public Collection<IClusterMachine> search(String domainKey, String query, int pageSize) throws StorageException {
		return impl.search(domainKey, query, pageSize);
	}

	public Collection<IClusterMachine> search(String query, int pageSize) throws StorageException {
		return impl.search(query, pageSize);
	}

	public void delete() throws StorageException {
		impl.delete();
	}

}
