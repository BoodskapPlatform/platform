package io.boodskap.iot.spi.cache.local;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

import org.mapdb.DB;
import org.mapdb.DBException.DataCorruption;
import org.mapdb.DBMaker;
import org.mapdb.DBMaker.Maker;
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
				
				Maker maker = DBMaker.fileDB(file)
						   .fileMmapEnableIfSupported()
						   .fileMmapPreclearDisable()
						   .cleanerHackEnable()
						   .transactionEnable()
						   .closeOnJvmShutdown();
				
				if(config.isFileChannelEnable()) {
					maker.fileChannelEnable();
				}
				
				if(config.isFileLockDisable()) {
					maker.fileLockDisable();
				}
				
				db = maker.make();
					
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
		if(null == db || db.isClosed()) return;
		db.commit();
		db.close();
	}
	
	private GroupSerializer<?> getSerializer(Class<?> keyOrValue) {
		
		final boolean array = keyOrValue.isArray();
		final Class<?> type = array ? keyOrValue.arrayType() : keyOrValue;
		
		//if(array && type.equals(BigInteger.class)) throw new IllegalArgumentException("BigInteger arrays are not supported");
		//if(array && type.equals(BigDecimal.class)) throw new IllegalArgumentException("BigDecimal arrays are not supported");
		
		if(type.equals(Byte.class)) {
			return  array ? GroupSerializer.BYTE_ARRAY : GroupSerializer.BYTE;
		}else if(type.equals(Short.class)) {
			return  array ? GroupSerializer.SHORT_ARRAY : GroupSerializer.SHORT;
		}else if(type.equals(Integer.class)) {
			return  array ? GroupSerializer.INT_ARRAY : GroupSerializer.INTEGER;
		}else if(type.equals(Long.class)) {
			return  array ? GroupSerializer.LONG_ARRAY : GroupSerializer.LONG;
		}else if(type.equals(Float.class)) {
			return  array ? GroupSerializer.FLOAT_ARRAY : GroupSerializer.FLOAT;
		}else if(type.equals(Double.class)) {
			return  array ? GroupSerializer.DOUBLE_ARRAY : GroupSerializer.DOUBLE;
		}else if(type.equals(Character.class)) {
			return  array ? GroupSerializer.CHAR_ARRAY : GroupSerializer.CHAR;
		}else if(!array && type.equals(String.class)) {
			return  GroupSerializer.STRING;
		}else if(!array && type.equals(Boolean.class)) {
			return  GroupSerializer.BOOLEAN;
		}else if(!array && type.equals(Date.class)) {
			return  GroupSerializer.DATE;
		}else if(!array && type.equals(UUID.class)) {
			return  GroupSerializer.UUID;
		}else if(!array && type.equals(BigInteger.class)) {
			return  GroupSerializer.BIG_INTEGER;
		}else if(!array && type.equals(BigDecimal.class)) {
			return  GroupSerializer.BIG_DECIMAL;
		}
		
		return GroupSerializer.JAVA;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K, V> Map<K, V> createOrGetCache(Class<K> keyClass, Class<V> valueClass, String name) throws CacheException {
		
		final GroupSerializer<?> keySerializer = getSerializer(keyClass);
		final GroupSerializer<?> valueSerializer = getSerializer(valueClass);

		return (Map<K, V>) db.hashMap(String.format("cache_%s", name), keySerializer, valueSerializer).createOrOpen();
	}

	@Override
	public <K, V> Map<K, V> getCache(Class<K> keyClass, Class<V> valueClass, String name) throws CacheException {
		return createOrGetCache(keyClass, valueClass, name);
	}

	@Override
	public <E> BlockingQueue<E> createOrGetQueue(Class<E> valueClass, String name) throws CacheException {
		return createOrGetQueue(valueClass, name, config.getQueueMaxSize());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <E> BlockingQueue<E> createOrGetQueue(Class<E> valueClass, String name, int limit) throws CacheException {
		final GroupSerializer<?> valueSerializer = getSerializer(valueClass);
		IndexTreeList<E> list = (IndexTreeList<E>) db.indexTreeList(String.format("queue_%s", name), valueSerializer).createOrOpen();
		return new LocalQueue<>(list, limit);
	}

	@Override
	public <E> BlockingQueue<E> getQueue(Class<E> valueClass, String name) throws CacheException {
		return createOrGetQueue(valueClass, name, config.getQueueMaxSize());
	}

}
