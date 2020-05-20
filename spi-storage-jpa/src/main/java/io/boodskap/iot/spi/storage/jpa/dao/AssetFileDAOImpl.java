package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.AssetFileDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IAssetFile;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.jpa.AssetFile;
import io.boodskap.iot.model.jpa.AssetFileId;
import io.boodskap.iot.model.jpa.FileContent;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class AssetFileDAOImpl implements AssetFileDAO<AssetFile> {
	
	private static final AssetFileDAO<AssetFile> dao = new AssetFileDAOImpl();
	
	protected AssetFileDAOImpl() {
	}
	
	public static final AssetFileDAO<AssetFile> get() {
		return dao;
	}

	@Override
	public AssetFile create(String domainKey, String assetId, String fileId) {
		return new AssetFile(new AssetFileId(domainKey, assetId, fileId));
	}

	@Override
	public Class<? extends AssetFile> clazz() {
		return AssetFile.class;
	}

	@Override
	public void createOrUpdate(AssetFile e) throws StorageException {
		try {
			
			final IAssetFile oe = get(e.getDomainKey(), e.getAssetId(), e.getFileId());
			IAssetFile ne;
			
			if(null == oe) {
				ne = new AssetFile(new AssetFileId(e.getDomainKey(), e.getAssetId(), e.getFileId()));
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
	public void update(String domainKey, String assetId, String fileId, String tags, String description) throws StorageException {
		try {
			
			IAssetFile oe = get(domainKey, assetId, fileId);
			
			if(null == oe) {
				throw new StorageException("Asset file [%s.%s.%s] not found", domainKey, assetId, fileId);
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
	public void update(String domainKey, String assetId, String fileId, byte[] data, String mediaType)throws StorageException {
		try {
			
			IAssetFile oe = get(domainKey, assetId, fileId);
			
			if(null == oe) {
				throw new StorageException("Asset file [%s.%s.%s] not found", domainKey, assetId, fileId);
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
	public IFileContent getContent(String domainKey, String assetId, String fileId) throws StorageException{
		try {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.FileContent(v.data, v.mediaType) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.assetId=:aid AND v.id.fileId=:fid", AssetFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("aid", assetId);
			params.put("fid", fileId);
			return new CommonDAO<>(FileContent.class).select(jql, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<AssetFile> load() throws StorageException {
		return new EntityIteratorImpl<>(AssetFile.class, "id.assetId");
	}

	@Override
	public EntityIterator<AssetFile> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(AssetFile.class, domainKey, "id.assetId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(AssetFile.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(AssetFile.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(AssetFile.class).delete(domainKey);
	}

	@Override
	public AssetFile get(String domainKey, String assetId, String fileId) throws StorageException {
		return new CommonDAO<>(AssetFile.class).find(new AssetFileId(domainKey, assetId, fileId));
	}

	@Override
	public boolean has(String domainKey, String assetId, String fileId) throws StorageException {
		return get(domainKey, assetId, fileId) != null;
	}

	@Override
	public void delete(String domainKey, String assetId, String fileId) throws StorageException {
		new CommonDAO<>(AssetFile.class).delete(domainKey, "assetId", assetId, "fileId", fileId);
	}

	@Override
	public Collection<AssetFile> list(boolean load, String domainKey, String assetId, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(AssetFile.class).list(domainKey, "assetId", assetId, page, pageSize, "id.fileId");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.AssetFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM AssetFile v WHERE v.id.domainKey=:dkey AND v.id.assetId=:aid";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("aid", assetId);

		return new CommonDAO<>(AssetFile.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<AssetFile> listNext(boolean load, String domainKey, String assetId, String fileId, int page, int pageSize) throws StorageException {
		return list(load, domainKey, assetId, page, pageSize);
	}

	@Override
	public Collection<AssetFile> search(boolean load, String domainKey, String assetId, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(AssetFile.class).search(query, domainKey, "assetId", assetId, pageSize);
		}

		String jql = "SELECT NEW io.boodskap.iot.model.jpa.AssetFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM AssetFile v WHERE v.id.domainKey=:dkey AND v.id.assetId=:aid";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("aid", assetId);

		return new CommonDAO<>(AssetFile.class).search(jql, params, query, pageSize);

	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(AssetFile.class).delete();
	}

}
