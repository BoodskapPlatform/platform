package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.PublicFileDAO;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IPublicFile;
import io.boodskap.iot.model.jpa.FileContent;
import io.boodskap.iot.model.jpa.PublicFile;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class PublicFileDAOImpl implements PublicFileDAO<PublicFile> {
	
	private static final PublicFileDAO<PublicFile> dao = new PublicFileDAOImpl();
	
	protected PublicFileDAOImpl() {
	}
	
	public static final PublicFileDAO<PublicFile> get() {
		return dao;
	}

	@Override
	public PublicFile create(String fileId) {
		return new PublicFile(fileId);
	}
	
	@Override
	public Class<? extends PublicFile> clazz() {
		return PublicFile.class;
	}

	@Override
	public void createOrUpdate(PublicFile e) throws StorageException {
		try {
			
			final IPublicFile oe = get(e.getFileId());
			IPublicFile ne;
			
			if(null == oe) {
				ne = new PublicFile(e.getFileId());
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setUpdatedStamp(new Date());
			ne.setDomainKey(e.getDomainKey());
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
	public void update(String fileId, String tags, String description) throws StorageException {
		try {
			
			IPublicFile oe = get(fileId);
			
			if(null == oe) {
				throw new StorageException("Public file [%s] not found", fileId);
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
	public void update(String fileId, byte[] data, String mediaType)throws StorageException {
		try {
			
			IPublicFile oe = get(fileId);
			
			if(null == oe) {
				throw new StorageException("Public file [%s] not found", fileId);
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
	public IFileContent getContent(String fileId) throws StorageException{
		try {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.FileContent(v.data, v.mediaType) FROM %s v WHERE v.fileId=:fid", PublicFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("fid", fileId);
			return new CommonDAO<>(FileContent.class).select(jql, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<PublicFile> load() throws StorageException {
		return new EntityIteratorImpl<>(PublicFile.class, "fileId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(PublicFile.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(PublicFile.class).count("domainKey", domainKey);
	}

	@Override
	public PublicFile get(String fileId) throws StorageException {
		return new CommonDAO<>(PublicFile.class).find(fileId);
	}

	@Override
	public boolean has(String fileId) throws StorageException {
		return get(fileId) != null;
	}

	@Override
	public void delete(String fileId) throws StorageException {
		new CommonDAO<>(PublicFile.class).delete("fileId", fileId);
	}

	@Override
	public Collection<PublicFile> list(boolean load, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(PublicFile.class).list(page, pageSize, "fileId");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.PublicFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM PublicFile v";
		
		Map<String, Serializable> params = new HashMap<>();

		return new CommonDAO<>(PublicFile.class).list(jql, params, page, pageSize);

	}

	@Override
	public Collection<PublicFile> listNext(boolean load, String fileId, int page, int pageSize) throws StorageException {
		return list(load, page, pageSize);
	}

	@Override
	public Collection<PublicFile> search(boolean load, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(PublicFile.class).search(query, pageSize);
		}

		String jql = "SELECT NEW io.boodskap.iot.model.jpa.PublicFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM PublicFile v";
		
		Map<String, Serializable> params = new HashMap<>();

		return new CommonDAO<>(PublicFile.class).search(jql, params, query, pageSize);	
	
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(PublicFile.class).delete();
	}

	@Override
	public EntityIterator<PublicFile> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(PublicFile.class, "domainKey", domainKey, "fileId");
	}

}
