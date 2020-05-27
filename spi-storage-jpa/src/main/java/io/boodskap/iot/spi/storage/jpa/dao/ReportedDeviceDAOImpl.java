package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.ReportedDeviceDAO;
import io.boodskap.iot.model.IReportedDevice;
import io.boodskap.iot.model.jpa.ReportedDevice;
import io.boodskap.iot.model.jpa.ReportedDeviceId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class ReportedDeviceDAOImpl implements ReportedDeviceDAO<ReportedDevice> {
	
	private static final ReportedDeviceDAO<ReportedDevice> dao = new ReportedDeviceDAOImpl();
	
	protected ReportedDeviceDAOImpl() {
	}
	
	public static final ReportedDeviceDAO<ReportedDevice> get() {
		return dao;
	}

	@Override
	public ReportedDevice create(String domainKey, String deviceId) {
		return new ReportedDevice(new ReportedDeviceId(domainKey, deviceId));
	}

	@Override
	public Class<? extends ReportedDevice> clazz() {
		return ReportedDevice.class;
	}

	@Override
	public void createOrUpdate(ReportedDevice e) throws StorageException {
		
		try {
			
			final IReportedDevice oe = get(e.getDomainKey(), e.getDeviceId());
			IReportedDevice ne;
			
			if(null == oe) {
				ne = new ReportedDevice(new ReportedDeviceId(e.getDomainKey(), e.getDeviceId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAddress(e.getAddress());
			ne.setChannel(e.getChannel());
			ne.setNodeId(e.getNodeId());
			ne.setNodeUid(e.getNodeUid());
			ne.setPort(e.getPort());
			
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
	public EntityIterator<ReportedDevice> load() throws StorageException {
		return new EntityIteratorImpl<>(ReportedDevice.class, "id.deviceId");
	}

	@Override
	public EntityIterator<ReportedDevice> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(ReportedDevice.class, domainKey, "id.deviceId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(ReportedDevice.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(ReportedDevice.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(ReportedDevice.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String deviceId) throws StorageException {
		new CommonDAO<>(ReportedDevice.class).delete(domainKey, "deviceId", deviceId);
	}

	@Override
	public ReportedDevice get(String domainKey, String deviceId) throws StorageException {
		return new CommonDAO<>(ReportedDevice.class).find(new ReportedDeviceId(domainKey, deviceId));
	}

	@Override
	public Collection<ReportedDevice> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(ReportedDevice.class).list(domainKey, page, pageSize, "id.deviceId");
	}

	@Override
	public Collection<ReportedDevice> listNext(String domainKey, String deviceId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<ReportedDevice> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<>(ReportedDevice.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(ReportedDevice.class).delete();
	}

}
