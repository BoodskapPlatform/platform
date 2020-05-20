package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.OrganizationFileDAO;
import io.boodskap.iot.model.IFileContent;
import io.boodskap.iot.model.IOrganizationFile;
import io.boodskap.iot.model.jpa.FileContent;
import io.boodskap.iot.model.jpa.OrganizationFile;
import io.boodskap.iot.model.jpa.OrganizationFileId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class OrganizationFileDAOImpl implements OrganizationFileDAO<OrganizationFile> {
	
	private static final OrganizationFileDAO<OrganizationFile> dao = new OrganizationFileDAOImpl();

	protected OrganizationFileDAOImpl() {
	}
	
	public static OrganizationFileDAO<OrganizationFile> get() {
		return dao;
	}

	@Override
	public OrganizationFile create(String domainKey, String orgId, String fileId) {
		return new OrganizationFile(new OrganizationFileId(domainKey, orgId, fileId));
	}

	@Override
	public Class<? extends OrganizationFile> clazz() {
		return OrganizationFile.class;
	}

	@Override
	public void createOrUpdate(OrganizationFile e) throws StorageException {
		try {
			
			final IOrganizationFile oe = get(e.getDomainKey(), e.getOrgId(), e.getFileId());
			IOrganizationFile ne;
			
			if(null == oe) {
				ne = new OrganizationFile(new OrganizationFileId(e.getDomainKey(), e.getOrgId(), e.getFileId()));
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
	public void update(String domainKey, String orgId, String fileId, String tags, String description) throws StorageException {
		try {
			
			IOrganizationFile oe = get(domainKey, orgId, fileId);
			
			if(null == oe) {
				throw new StorageException("Org file [%s.%s.%s] not found", domainKey, orgId, fileId);
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
	public void update(String domainKey, String orgId, String fileId, byte[] data, String mediaType)throws StorageException {
		try {
			
			IOrganizationFile oe = get(domainKey, orgId, fileId);
			
			if(null == oe) {
				throw new StorageException("Org file [%s.%s.%s] not found", domainKey, orgId, fileId);
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
	public IFileContent getContent(String domainKey, String orgId, String fileId) throws StorageException{
		try {
			String jql = String.format("SELECT NEW io.boodskap.iot.model.jpa.FileContent(v.data, v.mediaType) FROM %s v WHERE v.id.domainKey=:dkey AND v.id.orgId=:oid AND v.id.fileId=:fid", OrganizationFile.class.getSimpleName());
			Map<String, Serializable> params = new HashMap<>();
			params.put("dkey", domainKey);
			params.put("oid", orgId);
			params.put("fid", fileId);
			return new CommonDAO<>(FileContent.class).select(jql, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	@Override
	public EntityIterator<OrganizationFile> load() throws StorageException {
		return new EntityIteratorImpl<>(OrganizationFile.class, "id.orgId");
	}

	@Override
	public EntityIterator<OrganizationFile> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(OrganizationFile.class, domainKey, "id.orgId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(OrganizationFile.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(OrganizationFile.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(OrganizationFile.class).delete(domainKey);
	}

	@Override
	public OrganizationFile get(String domainKey, String orgId, String fileId) throws StorageException {
		return new CommonDAO<>(OrganizationFile.class).find(new OrganizationFileId(domainKey, orgId, fileId));
	}

	@Override
	public boolean has(String domainKey, String orgId, String fileId) throws StorageException {
		return get(domainKey, orgId, fileId) != null;
	}

	@Override
	public void delete(String domainKey, String orgId, String fileId) throws StorageException {
		new CommonDAO<>(OrganizationFile.class).delete(domainKey, "orgId", orgId, "fileId", fileId);
	}

	@Override
	public Collection<OrganizationFile> list(boolean load, String domainKey, String orgId, int page, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(OrganizationFile.class).list(domainKey, "orgId", orgId, page, pageSize, "id.fileId");
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.OrganizationFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM OrganizationFile v WHERE v.id.domainKey=:dkey AND v.id.orgId=:oid";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("oid", orgId);

		return new CommonDAO<>(OrganizationFile.class).list(jql, params, page, pageSize);
	}

	@Override
	public Collection<OrganizationFile> listNext(boolean load, String domainKey, String orgId, String fileId, int page, int pageSize) throws StorageException {
		return list(load, domainKey, orgId, page, pageSize);
	}

	@Override
	public Collection<OrganizationFile> search(boolean load, String domainKey, String orgId, String query, int pageSize) throws StorageException {
		
		if(load) {
			return new CommonDAO<>(OrganizationFile.class).search(query, domainKey, "orgId", orgId, pageSize);
		}
		
		String jql = "SELECT NEW io.boodskap.iot.model.jpa.OrganizationFile(v.id.fileId, v.description, v.mediaType, v.tags, v.createdStamp, v.updatedStamp) FROM OrganizationFile v WHERE v.id.domainKey=:dkey AND v.id.orgId=:oid";
		
		Map<String, Serializable> params = new HashMap<>();
		params.put("dkey", domainKey);
		params.put("oid", orgId);

		return new CommonDAO<>(OrganizationFile.class).search(jql, params, query, pageSize);	
	
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(OrganizationFile.class).delete();
	}

}
