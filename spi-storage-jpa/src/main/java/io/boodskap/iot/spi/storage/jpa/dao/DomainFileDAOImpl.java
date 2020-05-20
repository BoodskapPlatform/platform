package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainFile;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.jpa.DomainFile;
import io.boodskap.iot.model.jpa.DomainFileId;
import io.boodskap.iot.model.jpa.FileContent;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainFileDAOImpl implements DomainFileDAO<DomainFile> {
	
	private static final DomainFileDAO<DomainFile> dao = new DomainFileDAOImpl();
	
	protected DomainFileDAOImpl() {
	}
	
	public static DomainFileDAO<DomainFile> get() {
		return dao;
	}

	@Override
	public DomainFile create(String domainKey, String fileId) {
		return new DomainFile(new DomainFileId(domainKey, fileId));
	}

	@Override
	public Class<? extends DomainFile> clazz() {
		return DomainFile.class;
	}

	@Override
	public void createOrUpdate(DomainFile e) throws StorageException {
		try {
			
			final IDomainFile oe = get(e.getDomainKey(), e.getFileId());
			IDomainFile ne;
			
			if(null == oe) {
				ne = new DomainFile(new DomainFileId(e.getDomainKey(), e.getFileId()));
				ne.setCreatedStamp(new Date());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setUpdatedStamp(new Date());
			ne.setData(e.getData());
			ne.setDescription(e.getDescription());
			ne.setMediaType(e.getMediaType());
			ne.setTags(e.getTags());
			
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
	public void update(String domainKey, String fileId, String tags, String description) throws StorageException {
		try {
			
			IDomainFile oe = get(domainKey, fileId);
			
			if(null == oe) {
				throw new StorageException("Domain file [%s.%s] not found", domainKey, fileId);
			}
			
			UOW.begin();
			
			oe.setTags(tags);
			oe.setDescription(description);
			oe.setUpdatedStamp(new Date());
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public void update(String domainKey, String fileId, byte[] data, String mediaType)throws StorageException {
		try {
			
			IDomainFile oe = get(domainKey, fileId);
			
			if(null == oe) {
				throw new StorageException("Domain file [%s.%s] not found", domainKey, fileId);
			}
			
			UOW.begin();
			
			oe.setMediaType(mediaType);
			oe.setData(data);
			oe.setUpdatedStamp(new Date());
			
			UOW.commit();
			
		}catch(Exception ex) {
			UOW.rollback();
			throw new StorageException(ex);
		}
	}

	@Override
	public IFileContent getContent(String domainKey, String fileId) throws StorageException{
		try {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.FileContent(v.data, v.mediaType) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.fileId=:fid", DomainFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("fid", fileId);
			return new CommonDAO<>(FileContent.class).select(jql, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<DomainFile> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainFile.class, "id.fileId");
	}

	@Override
	public EntityIterator<DomainFile> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainFile.class, domainKey, "id.fileId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainFile.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainFile.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainFile.class).delete(domainKey);
	}

	@Override
	public DomainFile get(String domainKey, String fileId) throws StorageException {
		return new CommonDAO<>(DomainFile.class).find(new DomainFileId(domainKey, fileId));
	}

	@Override
	public boolean has(String domainKey, String fileId) throws StorageException {
		return get(domainKey, fileId) != null;
	}

	@Override
	public void delete(String domainKey, String fileId) throws StorageException {
		new CommonDAO<>(DomainFile.class).delete(domainKey, "fileId", fileId);
	}

	@Override
	public Collection<DomainFile> list(boolean load, String domainKey, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(DomainFile.class).list(domainKey, page, pageSize, "id.fileId");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.DomainFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM DomainFile v WHERE v.id.domainKey=:dkey";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);

		return new CommonDAO<>(DomainFile.class).list(jql, params, page, pageSize);

	}

	@Override
	public Collection<DomainFile> listNext(boolean load, String domainKey, String fileId, int page, int pageSize) throws StorageException {
		return list(load, domainKey, page, pageSize);
	}

	@Override
	public Collection<DomainFile> search(boolean load, String domainKey, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(DomainFile.class).search(query, domainKey, pageSize);
		}

		String jql = "SELECT NEW io.boodskap.iot.model.jpa.DomainFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM DomainFile v WHERE v.id.domainKey=:dkey";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);

		return new CommonDAO<>(DomainFile.class).search(jql, params, query, pageSize);	
	
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainFile.class).delete();
	}

}
