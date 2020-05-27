package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Date;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.SystemFileDAO;
import io.boodskap.iot.model.ISystemFile;
import io.boodskap.iot.model.jpa.SystemFile;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class SystemFileDAOImpl implements SystemFileDAO<SystemFile> {

	private static final SystemFileDAO<SystemFile> dao = new SystemFileDAOImpl();
	
	protected SystemFileDAOImpl() {
	}
	
	public static final SystemFileDAO<SystemFile> get() {
		return dao;
	}

	@Override
	public SystemFile create(String fileId) {
		return new SystemFile(fileId);
	}

	@Override
	public Class<SystemFile> clazz() {
		return SystemFile.class;
	}

	@Override
	public void createOrUpdate(SystemFile e) throws StorageException {
		try {
			
			final ISystemFile oe = get(e.getFileId());
			ISystemFile ne;
			
			if(null == oe) {
				ne = new SystemFile(e.getFileId());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setUpdatedStamp(new Date());
			ne.setData(e.getData());
			ne.setDescription(e.getDescription());
			
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
	public EntityIterator<SystemFile> load() throws StorageException {
		return new EntityIteratorImpl<>(SystemFile.class, "fileId");
	}

	@Override
	public SystemFile get(String fileId) throws StorageException {
		return new CommonDAO<>(SystemFile.class).find(fileId);
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(SystemFile.class).count();
	}

	@Override
	public void delete(String fileId) throws StorageException {
		new CommonDAO<>(SystemFile.class).delete("fileId", fileId);
	}

}
