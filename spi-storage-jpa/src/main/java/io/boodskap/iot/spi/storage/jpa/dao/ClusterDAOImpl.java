package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.ClusterDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.ICluster;
import io.boodskap.iot.model.jpa.Cluster;
import io.boodskap.iot.model.jpa.ClusterId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class ClusterDAOImpl implements ClusterDAO<Cluster> {
	
	private static final ClusterDAO<Cluster> instance = new ClusterDAOImpl();
	
	private ClusterDAOImpl() {
	}

	public static ClusterDAO<Cluster> get() {
		return instance;
	}

	@Override
	public Cluster create(String domainKey, String targetDomainKey, String clusterId) {
		return new Cluster(new ClusterId(domainKey, targetDomainKey, clusterId));
	}

	@Override
	public Class<? extends Cluster> clazz() {
		return Cluster.class;
	}

	@Override
	public void createOrUpdate(Cluster e) throws StorageException {
		
		try {
			
			final ICluster oe = get(e.getDomainKey(), e.getTargetDomainKey(), e.getClusterId());
			ICluster ne;
			
			if(null == oe) {
				ne = new Cluster(new ClusterId(e.getDomainKey(), e.getTargetDomainKey(), e.getClusterId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();

			ne.setCores(e.getCores());
			ne.setDevices(e.getDevices());
			ne.setMachines(e.getMachines());
			ne.setStatus(e.getStatus());
			ne.setUsers(e.getUsers());
			ne.setOrganizations(e.getOrganizations());
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
	public void touch(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		
		try {
			
			final ICluster oe = get(domainKey, targetDomainKey, clusterId);
			
			UOW.begin();

			oe.setUpdatedStamp(new Date());
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
		
	}

	@Override
	public EntityIterator<Cluster> load() throws StorageException {
		return new EntityIteratorImpl<>(Cluster.class, "id.domainKey");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Cluster.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(Cluster.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String targetDomainKey) throws StorageException {
		return new CommonDAO<>(Cluster.class).count(domainKey, "targetDomainKey", targetDomainKey);
	}

	@Override
	public Cluster get(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		return new CommonDAO<>(Cluster.class).find(new ClusterId(domainKey, targetDomainKey, clusterId));
	}

	@Override
	public void delete() throws StorageException{
		new CommonDAO<>(Cluster.class).delete();
	}
	
	@Override
	public void delete(String domainKey) throws StorageException{
		new CommonDAO<>(Cluster.class).delete(domainKey);
	}
	
	@Override
	public void delete(String domainKey, String targetDomainKey) throws StorageException{
		new CommonDAO<>(Cluster.class).delete(domainKey, "targetDomainKey", targetDomainKey);
	}
	
	@Override
	public void delete(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		new CommonDAO<>(Cluster.class).delete(domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId);
	}

	@Override
	public Collection<Cluster> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Cluster.class).list(page, pageSize, "id.targetDomainKey");
	}

	@Override
	public Collection<Cluster> listNext(String domainKey, String targetDomainKey, String clusterId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<Cluster> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Cluster.class).search(query, domainKey, pageSize);
	}

	@Override
	public Collection<Cluster> search(String query, int pageSize) throws StorageException {
		return new CommonDAO<>(Cluster.class).search(query, pageSize);
	}

}
