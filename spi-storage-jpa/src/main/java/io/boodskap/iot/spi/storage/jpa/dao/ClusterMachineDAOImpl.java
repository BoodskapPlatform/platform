package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.ClusterMachineDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IClusterMachine;
import io.boodskap.iot.model.jpa.ClusterMachine;
import io.boodskap.iot.model.jpa.ClusterMachineId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class ClusterMachineDAOImpl implements ClusterMachineDAO<ClusterMachine>{
	
	private static final ClusterMachineDAOImpl instance = new ClusterMachineDAOImpl();
	
	private ClusterMachineDAOImpl() {
	}

	public static ClusterMachineDAOImpl get() {
		return instance;
	}

	@Override
	public ClusterMachine create(String domainKey, String targetDomainKey, String clusterId, String machineId) {
		return new ClusterMachine(new ClusterMachineId(domainKey, targetDomainKey, clusterId, machineId));
	}

	@Override
	public Class<? extends ClusterMachine> clazz() {
		return ClusterMachine.class;
	}

	@Override
	public void createOrUpdate(ClusterMachine e) throws StorageException {
		
		try {
			
			final IClusterMachine oe = get(e.getDomainKey(), e.getTargetDomainKey(), e.getClusterId(), e.getMachineId());
			IClusterMachine ne;
			
			if(null == oe) {
				ne = new ClusterMachine(new ClusterMachineId(e.getDomainKey(), e.getTargetDomainKey(), e.getClusterId(), e.getMachineId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();

			ne.setCpuCores(e.getCpuCores());
			ne.setCpuSlots(e.getCpuSlots());
			ne.setStatus(e.getStatus());
			ne.setProperties(e.getProperties());
			ne.setUpdatedStamp(new Date());
			
			if(null == oe) {
				UOW.persist(ne);
			}
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
		
	}

	@Override
	public void touch(String domainKey, String targetDomainKey, String clusterId, String machineId) throws StorageException {
		
		try {
			
			final IClusterMachine oe = get(domainKey, targetDomainKey, clusterId, machineId);
			
			UOW.begin();

			oe.setUpdatedStamp(new Date());
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
		
	}

	@Override
	public EntityIterator<ClusterMachine> load() throws StorageException {
		return new EntityIteratorImpl<>(ClusterMachine.class, "id.domainKey");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String targetDomainKey) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).count(domainKey, "targetDomainKey", targetDomainKey);
	}

	@Override
	public long count(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).count(domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId);
	}

	@Override
	public long countCpuCores() throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).sum("cpuCores");
	}

	@Override
	public long countCpuCores(String domainKey) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).sum("cpuCores", domainKey);
	}

	@Override
	public long countCpuCores(String domainKey, String targetDomainKey) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).sum("cpuCores", domainKey, "targetDomainKey", targetDomainKey);
	}

	@Override
	public long countCpuCores(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).sum("cpuCores", domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId);
	}

	@Override
	public ClusterMachine get(String domainKey, String targetDomainKey, String clusterId, String machineId) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).find(new ClusterMachineId(domainKey, targetDomainKey, clusterId, machineId));
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(ClusterMachine.class).delete();
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(ClusterMachine.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String targetDomainKey) throws StorageException {
		new CommonDAO<>(ClusterMachine.class).delete(domainKey, "targetDomainKey", targetDomainKey);
	}

	@Override
	public void delete(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		new CommonDAO<>(ClusterMachine.class).delete(domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId);
	}

	@Override
	public void delete(String domainKey, String targetDomainKey, String clusterId, String machineId) throws StorageException {
		new CommonDAO<>(ClusterMachine.class).delete(domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId, "machineId", machineId);
	}

	@Override
	public Collection<ClusterMachine> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).list(domainKey, page, pageSize, "id.targetDomainKey");
	}

	@Override
	public Collection<ClusterMachine> list(String domainKey, String targetDomainKey, String clusterId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).list(domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId, page, pageSize, "id.machineId");
	}

	@Override
	public Collection<ClusterMachine> listNext(String domainKey, String targetDomainKey, String clusterId, String machineId, int page, int pageSize) throws StorageException {
		return list(targetDomainKey, page, pageSize);
	}

	@Override
	public Collection<ClusterMachine> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).search(query, domainKey, pageSize);
	}

	@Override
	public Collection<ClusterMachine> search(String query, int pageSize) throws StorageException {
		return new CommonDAO<>(ClusterMachine.class).search(query, pageSize);
	}

}
