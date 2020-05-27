package io.boodskap.iot.spi.storage.jpa.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.dao.PluginDAO;
import io.boodskap.iot.model.IPlugin;
import io.boodskap.iot.model.jpa.Plugin;
import io.boodskap.iot.model.jpa.PluginId;
import io.boodskap.iot.spi.storage.jpa.UOW;
import io.boodskap.iot.spi.storage.jpa.dao.util.CommonDAO;
import io.boodskap.iot.spi.storage.jpa.dao.util.EntityIteratorImpl;

public class PluginDAOImpl implements PluginDAO<Plugin> {
	
	private static final PluginDAO<Plugin> dao = new PluginDAOImpl();
	
	protected PluginDAOImpl() {
	}
	
	public static final PluginDAO<Plugin> get() {
		return dao;
	}

	@Override
	public Plugin create(String pluginId, String version) {
		return new Plugin(new PluginId(pluginId, version));
	}

	@Override
	public void createOrUpdate(Plugin e) throws StorageException {
		
		try {
			
			final IPlugin oe = get(e.getPluginId(), e.getVersion());
			IPlugin ne;
			
			if(null == oe) {
				ne = new Plugin(new PluginId(e.getPluginId(), e.getVersion()));
			}else {
				ne = oe;
			}
			
			UOW.begin();
			
			ne.setAuthor(e.getAuthor());
			ne.setClazz(e.getClazz());
			ne.setContextId(e.getContextId());
			ne.setCrc(e.getCrc());
			ne.setDescription(e.getDescription());
			ne.setJsonContent(e.getJsonContent());
			ne.setReadme(e.getReadme());
			ne.setSystemId(e.getSystemId());
			ne.setType(e.getType());
			
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
	public EntityIterator<Plugin> load() throws StorageException {
		return new EntityIteratorImpl<>(Plugin.class, "id.pluginId");
	}

	@Override
	public long count() throws StorageException {
		return new CommonDAO<>(Plugin.class).count();
	}

	@Override
	public long count(String id) throws StorageException {
		return new CommonDAO<>(Plugin.class).count("id.pluginId", id);
	}

	@Override
	public Plugin get(String id) throws StorageException {
		String query = "v.id.pluginId='%s' order by id.version desc";
		Map<String, Serializable> params = new HashMap<>();
		params.put("pid", id);
		return new CommonDAO<>(Plugin.class).get(query, params);
	}

	@Override
	public Plugin get(String id, String version) throws StorageException {
		return new CommonDAO<>(Plugin.class).find(new PluginId(id, version));
	}

	@Override
	public Plugin getByContextId(String contextId) throws StorageException {
		String query = "v.contextId=:cid order by id.pluginId";
		Map<String, Serializable> params = new HashMap<>();
		params.put("cid", contextId);
		return new CommonDAO<>(Plugin.class).get(query, params);
	}

	@Override
	public void delete(String id) throws StorageException {
		new CommonDAO<>(Plugin.class).delete("id.pluginId", id);
	}

	@Override
	public void delete(String id, String version) throws StorageException {
		new CommonDAO<>(Plugin.class).delete("id.pluginId", id, "id.version", version);
	}

	@Override
	public Collection<Plugin> list(int page, int pageSize) throws StorageException {
		return new CommonDAO<>(Plugin.class).list(page, pageSize, "id.pluginId");
	}

	@Override
	public Collection<Plugin> listNext(String id, String version, int page, int pageSize) throws StorageException {
		return list(page, pageSize);
	}

}
