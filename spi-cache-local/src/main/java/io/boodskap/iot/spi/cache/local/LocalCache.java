package io.boodskap.iot.spi.cache.local;

import java.io.File;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import org.mapdb.DB;
import org.mapdb.DBException.DataCorruption;
import org.mapdb.DBMaker;
import org.mapdb.IndexTreeList;
import org.mapdb.serializer.GroupSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.BoodskapConfiguration;
import io.boodskap.iot.CacheException;
import io.boodskap.iot.spi.cache.ICache;

public class LocalCache implements ICache {
	
	private static final Logger LOG = LoggerFactory.getLogger(LocalCache.class);
	
	private static final LocalCache instance = new LocalCache();
	
	private DB db;
	private LocalCacheConfig config;

	private LocalCache() {
	}
	
	protected static final LocalCache get() {
		return instance;
	}
	
	protected void init(LocalCacheConfig config) throws CacheException {
		
		try {
			
			if(null != db && !db.isClosed()) return;
			
			this.config = config;
			
			LOG.info("initializing...");
			
			File folder = new File(BoodskapConfiguration.get().getDataPath(), "lcache");
			folder.mkdirs();
			File file = new File(folder, "mmapfilecache.db");
			
			LOG.info(String.format("%s cache %s...", file.exists() ? "opening existing" : "creating new", file.getAbsolutePath()));
			
			try {
				
				db = DBMaker.fileDB(file)
						   .fileMmapEnableIfSupported()
						   .closeOnJvmShutdown()
						   .transactionEnable()
						   .make();
					
			}catch(DataCorruption dcx) {
				
				LOG.error("Cache Corrupted", dcx);
				LOG.warn("Re-creating cache file");
				
				file.delete();
				
				db = DBMaker.fileDB(file)
						   .fileMmapEnableIfSupported()
						   .closeOnJvmShutdown()
						   .make();
					
			}
			
			LOG.info("initialized.");
			
		}catch(Exception ex) {
			throw new CacheException(ex);
		}
		
	}
	
	protected void commit() {
		db.commit();
	}
	
	protected void close() {
		if(null == db | db.isClosed()) return;
		db.commit();
		db.close();
	}

	@Override
	public <K, V> Map<K, V> createOrGetCache(String name) throws CacheException {
		return getCache(name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K, V> Map<K, V> getCache(String name) throws CacheException {
		return db.hashMap(String.format("cache_", name), GroupSerializer.STRING, GroupSerializer.JAVA).createOrOpen();
	}

	@Override
	public <E> BlockingQueue<E> createOrGetQueue(String name) throws CacheException {
		return getQueue(name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> BlockingQueue<E> getQueue(String name) throws CacheException {
		IndexTreeList<E> list = (IndexTreeList<E>) db.indexTreeList(name, GroupSerializer.JAVA).createOrOpen();
		return new LocalQueue<>(list, config.getQueueMaxSize());
	}

}
