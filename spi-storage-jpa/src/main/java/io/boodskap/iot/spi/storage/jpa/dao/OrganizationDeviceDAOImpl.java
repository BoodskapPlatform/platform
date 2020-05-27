package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OrganizationDeviceDAO;
import io.boodskap.iot.model.IOrganizationDevice;
import io.boodskap.iot.model.jpa.OrganizationDevice;
import io.boodskap.iot.model.jpa.OrganizationDeviceId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OrganizationDeviceDAOImpl implements OrganizationDeviceDAO<OrganizationDevice> {
	
	private static final OrganizationDeviceDAO<OrganizationDevice> dao = new OrganizationDeviceDAOImpl();
	
	protected OrganizationDeviceDAOImpl() {
	}
	
	public static final OrganizationDeviceDAO<OrganizationDevice> get() {
		return dao;
	}

	@Override
	public OrganizationDevice create(String domainKey, String orgId, String deviceId) {
		return new OrganizationDevice(new OrganizationDeviceId(domainKey, orgId, deviceId));
	}

	@Override
	public Class<? extends OrganizationDevice> clazz() {
		return OrganizationDevice.class;
	}

	@Override
	public void createOrUpdate(OrganizationDevice e) throws StorageException {
		
		try {
			
			final IOrganizationDevice oe = get(e.getDomainKey(), e.getOrgId(), e.getDeviceId());
			IOrganizationDevice ne;
			
			if(null == oe) {
				ne = new OrganizationDevice(new OrganizationDeviceId(e.getDomainKey(), e.getOrgId(), e.getDeviceId()));
				ne.setRegisteredStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAssetId(e.getAssetId());
			ne.setChannel(e.getChannel());
			ne.setDescription(e.getDescription());
			ne.setModelId(e.getModelId());
			ne.setNodeId(e.getNodeId());
			ne.setNodeUid(e.getNodeUid());
			ne.setName(e.getName());
			ne.setPassword(e.getPassword());
			ne.setReportedIp(e.getReportedIp());
			ne.setReportedPort(e.getReportedPort());
			ne.setVersion(e.getVersion());
			
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
	public EntityIterator<OrganizationDevice> load() throws StorageException {
		return new EntityIteratorImpl<>(OrganizationDevice.class, "id.orgId");
	}

	@Override
	public EntityIterator<OrganizationDevice> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OrganizationDevice.class, domainKey, "id.orgId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OrganizationDevice.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OrganizationDevice.class).count(domainKey);
	}

	@Override
	public long count(String domainKey, String orgId) throws StorageException {
		return new CommonDAO<>(OrganizationDevice.class).count(domainKey, "orgId", orgId);
	}

	@Override
	public OrganizationDevice get(String domainKey, String orgId, String deviceId) throws StorageException {
		return new CommonDAO<>(OrganizationDevice.class).find(new OrganizationDeviceId(domainKey, orgId, deviceId));
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OrganizationDevice.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String orgId) throws StorageException {
		new CommonDAO<>(OrganizationDevice.class).delete(domainKey, "orgId", orgId);
	}

	@Override
	public void delete(String domainKey, String orgId, String deviceId) throws StorageException {
		new CommonDAO<>(OrganizationDevice.class).delete(domainKey, "orgId", orgId, "deviceId", deviceId);
	}

	@Override
	public Collection<OrganizationDevice> list(String domainKey, String orgId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(OrganizationDevice.class).list(domainKey, "orgId", orgId, page, pageSize, "id.deviceId");
	}

	@Override
	public Collection<OrganizationDevice> listNext(String domainKey, String orgId, String deviceId, int page, int pageSize) throws StorageException {
		return list(domainKey, orgId, page, pageSize);
	}

	@Override
	public Collection<OrganizationDevice> search(String domainKey, String orgId, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(OrganizationDevice.class).search(query, domainKey, "orgId", orgId, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OrganizationDevice.class).delete();
	}

}
