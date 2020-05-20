package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;
import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.BillingScheduleDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IBillingSchedule;
import io.boodskap.iot.model.jpa.BillingSchedule;
import io.boodskap.iot.model.jpa.BillingScheduleId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class BillingScheduleDAOImpl implements BillingScheduleDAO<BillingSchedule> {
	
	private static final BillingScheduleDAO<BillingSchedule> instance = new BillingScheduleDAOImpl();
	
	protected BillingScheduleDAOImpl() {
	}
	
	public static final BillingScheduleDAO<BillingSchedule> get(){
		return instance;
	}

	@Override
	public BillingSchedule create(String domainKey, String targetDomain, String scheduleId) {
		return new BillingSchedule(new BillingScheduleId(domainKey, targetDomain, scheduleId));
	}

	@Override
	public Class<? extends BillingSchedule> clazz() {
		return BillingSchedule.class;
	}

	@Override
	public void createOrUpdate(BillingSchedule e) throws StorageException {
		
		try {
			
			final IBillingSchedule oe = get(e.getDomainKey(), e.getTargetDomain(), e.getScheduleId());
			IBillingSchedule ne;
			
			if(null == oe) {
				ne = new BillingSchedule(new BillingScheduleId(e.getDomainKey(), e.getTargetDomain(), e.getScheduleId()));
				ne.setCreatedtime(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setEnddate(e.getEnddate());
			
			
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
	public EntityIterator<BillingSchedule> load() throws StorageException {
		try {
			return new EntityIteratorImpl<BillingSchedule>(BillingSchedule.class, "id.domainKey");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<BillingSchedule> load(String domainKey) throws StorageException {
		try {
			return new EntityIteratorImpl<BillingSchedule>(BillingSchedule.class, domainKey, "id.targetDomain");
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(BillingSchedule.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(BillingSchedule.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(BillingSchedule.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String targetDomain) throws StorageException {
		new CommonDAO<>(BillingSchedule.class).delete(domainKey, "targetDomain", targetDomain);
	}

	@Override
	public void delete(String domainKey, String targetDomain, String invoiceId) throws StorageException {
		new CommonDAO<>(BillingSchedule.class).delete(domainKey, "targetDomain", targetDomain, "contactid", invoiceId);
	}

	@Override
	public BillingSchedule get(String domainKey, String targetDomain, String invoiceId) throws StorageException {
		return new CommonDAO<>(BillingSchedule.class).find(new BillingScheduleId(domainKey, targetDomain, invoiceId));
	}

	@Override
	public Collection<BillingSchedule> list(String domainKey, int page, int pageSize) throws StorageException {
		return new CommonDAO<BillingSchedule>(BillingSchedule.class).list(domainKey, page, pageSize, "id.targetDomain");
	}

	@Override
	public Collection<BillingSchedule> listNext(String domainKey, String targetDomain, String invoiceId, int page, int pageSize) throws StorageException {
		return list(domainKey, page, pageSize);
	}

	@Override
	public Collection<BillingSchedule> search(String domainKey, String query, int pageSize) throws StorageException {
		return new CommonDAO<BillingSchedule>(BillingSchedule.class).search(query, domainKey, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(BillingSchedule.class).delete();
	}

}
