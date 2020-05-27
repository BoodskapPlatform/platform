package io.boodskap.iot.spi.storage.jpa.dao;

import java.util.Collection;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.DomainNodeDAO;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.model.IDomainNode;
import io.boodskap.iot.model.jpa.DomainNode;
import io.boodskap.iot.model.jpa.DomainNodeId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class DomainNodeDAOImpl implements DomainNodeDAO<DomainNode> {
	
	private static final DomainNodeDAO<DomainNode> dao = new DomainNodeDAOImpl();
	
	protected DomainNodeDAOImpl() {
	}
	
	public static final DomainNodeDAO<DomainNode> get() {
		return dao;
	}

	@Override
	public DomainNode create(String domainKey, String nodeId) {
		return new DomainNode(new DomainNodeId(domainKey, nodeId));
	}

	@Override
	public Class<? extends DomainNode> clazz() {
		return DomainNode.class;
	}

	@Override
	public void createOrUpdate(DomainNode e) throws StorageException {
		
		try {
			
			final IDomainNode oe = get(e.getDomainKey(), e.getNodeId());
			IDomainNode ne;
			
			if(null == oe) {
				ne = new DomainNode(new DomainNodeId(e.getDomainKey(), e.getNodeId()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
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
	public DomainNode get(String domainKey, String nodeId) throws StorageException{
		return new CommonDAO<>(DomainNode.class).find(new DomainNodeId(domainKey, nodeId));
	}

	@Override
	public EntityIterator<DomainNode> load() throws StorageException {
		return new EntityIteratorImpl<>(DomainNode.class, "id.nodeId");
	}

	@Override
	public EntityIterator<DomainNode> load(String domainKey) throws StorageException {
		return new EntityIteratorImpl<>(DomainNode.class, domainKey, "id.nodeId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(DomainNode.class).count();
	}

	@Override
	public long count(String domainKey) throws StorageException {
		return new CommonDAO<>(DomainNode.class).count(domainKey);
	}

	@Override
	public void delete(String domainKey) throws StorageException {
		new CommonDAO<>(DomainNode.class).delete(domainKey);
	}

	@Override
	public void delete(String domainKey, String nodeId) throws StorageException {
		new CommonDAO<>(DomainNode.class).delete(domainKey, "nodeId", nodeId);
	}

	@Override
	public EntityIterator<DomainNode> loadByNodeId(String nodeId) throws StorageException {
		return new EntityIteratorImpl<>(DomainNode.class, "nodeId", nodeId, "id.domainKey");
	}

	@Override
	public boolean hasDomain(String domainKey) throws StorageException {
		return load(domainKey).hasNext();
	}

	@Override
	public Collection<DomainNode> list(String nodeId, int page, int pageSize) throws StorageException {
		return new CommonDAO<>(DomainNode.class).list("nodeId", nodeId, page, pageSize, "id.domainKey");
	}

	@Override
	public Collection<DomainNode> listNext(String nodeId, String domainKey, int page, int pageSize)throws StorageException {
		return list(nodeId, page, pageSize);
	}

	@Override
	public void delete() throws StorageException {
		new CommonDAO<>(DomainNode.class).delete();
	}

}
