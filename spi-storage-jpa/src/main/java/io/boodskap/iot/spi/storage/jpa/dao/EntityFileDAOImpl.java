package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IEntityFile;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.jpa.EntityFile;
import io.boodskap.iot.model.jpa.EntityFileId;
import io.boodskap.iot.model.jpa.FileContent;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class EntityFileDAOImpl implements EntityFileDAO<EntityFile> {
	
	private static final EntityFileDAO<EntityFile> dao = new EntityFileDAOImpl();
	
	protected EntityFileDAOImpl() {
	}
	
	public static final EntityFileDAO<EntityFile> get() {
		return dao;
	}

	@Override
	public EntityFile create(String domainKey, String entityType, String entityId, String fileId) {
		return new EntityFile(new EntityFileId(domainKey, entityType, entityId, fileId));
	}

	@Override
	public Class<? extends EntityFile> clazz() {
		return EntityFile.class;
	}

	@Override
	public void createOrUpdate(EntityFile e) throws StorageException {
		try {
			
			final IEntityFile oe = get(e.getDomainKey(), e.getEntityType(), e.getEntityId(), e.getFileId());
			IEntityFile ne;
			
			if(null == oe) {
				ne = new EntityFile(new EntityFileId(e.getDomainKey(), e.getEntityType(), e.getEntityId(), e.getFileId()));
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
	public void update(String domainKey, String entityType, String entityId, String fileId, String tags, String description) throws StorageException {
		try {
			
			IEntityFile oe = get(domainKey, entityType, entityId, fileId);
			
			if(null == oe) {
				throw new StorageException("Entity file [%s.%s.%s] not found", domainKey, entityId, fileId);
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
	public void update(String domainKey, String entityType, String entityId, String fileId, byte[] data, String mediaType)throws StorageException {
		try {
			
			IEntityFile oe = get(domainKey, entityType, entityId, fileId);
			
			if(null == oe) {
				throw new StorageException("Entity file [%s.%s.%s] not found", domainKey, entityId, fileId);
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
	public IFileContent getContent(String domainKey, String entityType, String entityId, String fileId) throws StorageException{
		try {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.FileContent(v.data, v.mediaType) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.entityType=:etype AND v.id.entityId=:eid AND v.id.fileId=:fid", EntityFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("etype", entityType);
			params.put("eid", entityId);
			params.put("fid", fileId);
			return new CommonDAO<>(FileContent.class).select(jql, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<EntityFile> load() throws StorageException {
		return new EntityIteratorImpl<>(EntityFile.class, "id.entityId");
	}

	@Override
	public EntityIterator<EntityFile> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(EntityFile.class, domainKey, "id.entityId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(EntityFile.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(EntityFile.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(EntityFile.class).delete(domainKey);
	}

	@Override
	public EntityFile get(String domainKey, String entityType, String entityId, String fileId) throws StorageException {
		return new CommonDAO<>(EntityFile.class).find(new EntityFileId(domainKey, entityType, entityId, fileId));
	}

	@Override
	public boolean has(String domainKey, String entityType, String entityId, String fileId) throws StorageException {
		return get(domainKey, entityType, entityId, fileId) != null;
	}

	@Override
	public void delete(String domainKey, String entityType, String entityId, String fileId) throws StorageException {
		new CommonDAO<>(EntityFile.class).delete(domainKey, "entityType", entityType, "entityId", entityId, "fileId", fileId);
	}

	@Override
	public Collection<EntityFile> list(boolean load, String domainKey, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(EntityFile.class).list(domainKey, page, pageSize, "id.entityType, id.entityId, id.fileId");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.EntityFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM EntityFile v WHERE v.id.domainKey=:dkey";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);

		return new CommonDAO<>(EntityFile.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<EntityFile> list(boolean load, String domainKey, String entityType, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(EntityFile.class).list(domainKey, "entityType", entityType, page, pageSize, "id.fileId");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.EntityFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM EntityFile v WHERE v.id.domainKey=:dkey AND v.id.entityType=:etype";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("etype", entityType);

		return new CommonDAO<>(EntityFile.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<EntityFile> list(boolean load, String domainKey, String entityType, String entityId, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(EntityFile.class).list(domainKey, "entityType", entityType, "entityId", entityId, page, pageSize, "id.fileId");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.EntityFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM EntityFile v WHERE v.id.domainKey=:dkey AND v.id.entityType=:etype AND v.id.entityId=:eid";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("etype", entityType);
		params.put("eid", entityId);

		return new CommonDAO<>(EntityFile.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<EntityFile> listNext(boolean load, String domainKey, String entityType, String entityId, String fileId, int page, int pageSize) throws StorageException {
		return list(load, domainKey, entityType, entityId, page, pageSize);
	}


	@Override
	public Collection<EntityFile> search(boolean load, String domainKey, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(EntityFile.class).search(query, domainKey, pageSize);
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.EntityFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM EntityFile v WHERE v.id.domainKey=:dkey";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);

		return new CommonDAO<>(EntityFile.class).search(jql, params, query, pageSize);	
	
	}
	
	@Override
	public Collection<EntityFile> search(boolean load, String domainKey, String entityType, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(EntityFile.class).search(query, domainKey, "entityType", entityType, pageSize);
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.EntityFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM EntityFile v WHERE v.id.domainKey=:dkey AND v.id.entityType=:etype";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("etype", entityType);

		return new CommonDAO<>(EntityFile.class).search(jql, params, query, pageSize);	
	
	}

	@Override
	public Collection<EntityFile> search(boolean load, String domainKey, String entityType, String entityId, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(EntityFile.class).search(query, domainKey, "entityType", entityType, "entityId", entityId, pageSize);
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.EntityFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM EntityFile v WHERE v.id.domainKey=:dkey AND v.id.entityType=:etype AND v.id.entityId=:eid";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("etype", entityType);
		params.put("eid", entityId);

		return new CommonDAO<>(EntityFile.class).search(jql, params, query, pageSize);	
	
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(EntityFile.class).delete();
	}

	@Override
	public void delete(String domainKey, String entityType) throws StorageException {
		new CommonDAO<>(EntityFile.class).delete(domainKey, "entityType", entityType);
	}

	@Override
	public void delete(String domainKey, String entityType, String entityId) throws StorageException {
		new CommonDAO<>(EntityFile.class).delete(domainKey, "entityType", entityType, "entityId", entityId);
	}

}
