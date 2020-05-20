package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.UserFileDAO;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IUserFile;
import io.boodskap.iot.model.jpa.FileContent;
import io.boodskap.iot.model.jpa.UserFile;
import io.boodskap.iot.model.jpa.UserFileId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class UserFileDAOImpl implements UserFileDAO<UserFile> {
	
	private static final UserFileDAO<UserFile> dao = new UserFileDAOImpl();
	
	protected UserFileDAOImpl() {
	}
	
	public static final UserFileDAO<UserFile> get() {
		return dao;
	}

	@Override
	public UserFile create(String domainKey, String userId, String fileId) {
		return new UserFile(new UserFileId(domainKey, userId, fileId));
	}

	@Override
	public Class<? extends UserFile> clazz() {
		return UserFile.class;
	}

	@Override
	public void createOrUpdate(UserFile e) throws StorageException {
		try {
			
			final IUserFile oe = get(e.getDomainKey(), e.getUserId(), e.getFileId());
			IUserFile ne;
			
			if(null == oe) {
				ne = new UserFile(new UserFileId(e.getDomainKey(), e.getUserId(), e.getFileId()));
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
	public void update(String domainKey, String userId, String fileId, String tags, String description) throws StorageException {
		try {
			
			IUserFile oe = get(domainKey, userId, fileId);
			
			if(null == oe) {
				throw new StorageException("User file [%s.%s.%s] not found", domainKey, userId, fileId);
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
	public void update(String domainKey, String userId, String fileId, byte[] data, String mediaType)throws StorageException {
		try {
			
			IUserFile oe = get(domainKey, userId, fileId);
			
			if(null == oe) {
				throw new StorageException("User file [%s.%s.%s] not found", domainKey, userId, fileId);
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
	public IFileContent getContent(String domainKey, String userId, String fileId) throws StorageException{
		try {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.FileContent(v.data, v.mediaType) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.userId=:uid AND v.id.fileId=:fid", UserFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("uid", userId);
			params.put("fid", fileId);
			return new CommonDAO<>(FileContent.class).select(jql, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<UserFile> load() throws StorageException {
		return new EntityIteratorImpl<>(UserFile.class, "id.userId");
	}

	@Override
	public EntityIterator<UserFile> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(UserFile.class, domainKey, "id.userId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(UserFile.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(UserFile.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(UserFile.class).delete(domainKey);
	}

	@Override
	public UserFile get(String domainKey, String userId, String fileId) throws StorageException {
		return new CommonDAO<>(UserFile.class).find(new UserFileId(domainKey, userId, fileId));
	}

	@Override
	public boolean has(String domainKey, String userId, String fileId) throws StorageException {
		return get(domainKey, userId, fileId) != null;
	}

	@Override
	public void delete(String domainKey, String userId, String fileId) throws StorageException {
		new CommonDAO<>(UserFile.class).delete(domainKey, "userId", userId, "fileId", fileId);
	}

	@Override
	public Collection<UserFile> list(boolean load, String domainKey, String userId, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(UserFile.class).list(domainKey, "userId", userId, page, pageSize, "id.fileId");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.UserFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM UserFile v WHERE v.id.domainKey=:dkey AND v.id.userId=:uid";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("uid", userId);

		return new CommonDAO<>(UserFile.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<UserFile> listNext(boolean load, String domainKey, String userId, String fileId, int page, int pageSize) throws StorageException {
		return list(load, domainKey, userId, page, pageSize);
	}

	@Override
	public Collection<UserFile> search(boolean load, String domainKey, String userId, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(UserFile.class).search(query, domainKey, "userId", userId, pageSize);
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.UserFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM UserFile v WHERE v.id.domainKey=:dkey AND v.id.userId=:uid";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("uid", userId);

		return new CommonDAO<>(UserFile.class).search(jql, params, query, pageSize);	
	
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(UserFile.class).delete();
	}

}
