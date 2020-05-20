package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.ClusterLicenseDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IClusterLicense;
import io.boodskap.iot.model.jpa.ClusterLicense;
import io.boodskap.iot.model.jpa.ClusterLicenseId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class ClusterLicenseDAOImpl implements ClusterLicenseDAO<ClusterLicense> {
	
	private static final ClusterLicenseDAOImpl instance = new ClusterLicenseDAOImpl();
	
	private ClusterLicenseDAOImpl() {
	}
	
	public static final ClusterLicenseDAOImpl get() {
		return instance;
	}

	@Override
	public ClusterLicense create(String domainKey, String targetDomainKey, String clusterId, String licenseKey) {
		return new ClusterLicense(new ClusterLicenseId(domainKey, targetDomainKey, clusterId, licenseKey));
	}

	@Override
	public Class<? extends ClusterLicense> clazz() {
		return ClusterLicense.class;
	}

	@Override
	public void createOrUpdate(ClusterLicense e) throws StorageException {
		
		try {
			
			final IClusterLicense oe = get(e.getDomainKey(), e.getTargetDomainKey(), e.getClusterId(), e.getLicenseKey());
			IClusterLicense ne;
			
			if(null == oe) {
				ne = new ClusterLicense(new ClusterLicenseId(e.getDomainKey(), e.getTargetDomainKey(), e.getClusterId(), e.getLicenseKey()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();

			ne.setLicenseType(e.getLicenseType());
			ne.setMaxCores(e.getMaxCores());
			ne.setMaxDeviceMessagesPerMinute(e.getMaxDeviceMessagesPerMinute());
			ne.setMaxDevices(e.getMaxDevices());
			ne.setMaxDomains(e.getMaxDomains());
			ne.setMaxMachineCores(e.getMaxMachineCores());
			ne.setMaxMessagesPerMinute(e.getMaxMessagesPerMinute());
			ne.setMaxUsers(e.getMaxUsers());
			ne.setStatus(e.getStatus());
			ne.setValidFrom(e.getValidFrom());
			ne.setValidTo(e.getValidTo());
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
	public EntityIterator<ClusterLicense> load() throws StorageException {
		return new EntityIteratorImpl<>(ClusterLicense.class, "id.targetDomainKey");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(ClusterLicense.class).count();
	}

	@Override
	public ClusterLicense get(String domainKey, String targetDomainKey, String clusterId, String licenseKey) throws StorageException {
		return new CommonDAO<>(ClusterLicense.class).find(new ClusterLicenseId(domainKey, targetDomainKey, clusterId, licenseKey));
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(ClusterLicense.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String targetDomainKey) throws StorageException {
		return new CommonDAO<>(ClusterLicense.class).count(domainKey, "targetDomainKey", targetDomainKey);
	}

	@Override
	public long count(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		return new CommonDAO<>(ClusterLicense.class).count(domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(ClusterLicense.class).delete();
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(ClusterLicense.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String targetDomainKey) throws StorageException {
		new CommonDAO<>(ClusterLicense.class).delete(domainKey, "targetDomainKey", targetDomainKey);
	}

	@Override
	public void delete(String domainKey, String targetDomainKey, String clusterId) throws StorageException {
		new CommonDAO<>(ClusterLicense.class).delete(domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId);		
	}

	@Override
	public void delete(String domainKey, String targetDomainKey, String clusterId, String licenseKey) throws StorageException {
		new CommonDAO<>(ClusterLicense.class).delete(domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId, "licenseKey", licenseKey);		
	}

	@Override
	public Collection<ClusterLicense> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(ClusterLicense.class).list(domainKey, page, pageSize, "id.targetDomainKey");
	}

	@Override
	public Collection<ClusterLicense> list(String domainKey, String targetDomainKey, String clusterId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(ClusterLicense.class).list(domainKey, "targetDomainKey", targetDomainKey, "clusterId", clusterId, page, pageSize, "id.licenseKey");
	}

	@Override
	public Collection<ClusterLicense> listNext(String domainKey, String targetDomainKey, String clusterId, String licenseKey, int page, int pageSize) throws StorageException {
		return list(targetDomainKey, page, pageSize);
	}

	@Override
	public Collection<ClusterLicense> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(ClusterLicense.class).search(query, domainKey, pageSize);
	}

	@Override
	public Collection<ClusterLicense> search(String query, int pageSize) throws StorageException {
		return new CommonDAO<>(ClusterLicense.class).search(query, pageSize);
	}

}
