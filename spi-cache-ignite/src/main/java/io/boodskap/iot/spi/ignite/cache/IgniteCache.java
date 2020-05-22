package io.boodskap.iot.spi.ignite.cache;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

import org.apache.ignite.Ignite;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.CollectionConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.CacheException;
import io.boodskap.iot.spi.cache.ICache;

public class IgniteCache implements ICache {
	
	private static final Logger LOG = LoggerFactory.getLogger(IgniteCache.class);
	
	private final IgniteCacheConfiguration config;
	private Ignite ignite;

	public IgniteCache(IgniteCacheConfiguration config, Ignite ignite) {

		this.config = config;
		this.ignite = ignite;
		
		ignite.cacheNames().forEach(cn -> {
			LOG.info(String.format("Cache %s found", cn));
		});
	}
	
	protected void close() {
		if(null != ignite) {
			ignite.close();
			ignite = null;
		}
	}

	@Override
	public <K, V> Map<K, V> createOrGetCache(Class<K> keyClass, Class<V> valueClass,String name) throws CacheException {
		try {
			
			CacheConfig cc = config.getNamedCaches().get(name);
			
			if(null == cc) {
				cc = config.getDefaultCacheConfig();
			}
			
			CacheConfiguration<K,V> cfg = new CacheConfiguration<>();
			cfg.setName(name);
			cfg.setAtomicityMode(cc.getCacheAtomicity());
			cfg.setBackups(cc.getCacheBackups());
			cfg.setCacheMode(cc.getCacheMode());
			return new IgniteCacheMap<K,V>(ignite.getOrCreateCache(cfg));
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

	@Override
	public <K, V> Map<K, V> getCache(Class<K> keyClass, Class<V> valueClass,String name) throws CacheException {
		try {
			return new IgniteCacheMap<K, V>(ignite.getOrCreateCache(name));
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

	@Override
	public <E> BlockingQueue<E> createOrGetQueue(Class<E> valueClass, String name) throws CacheException {
		return createOrGetQueue(valueClass, name, -1);
	}

	@Override
	public <E> BlockingQueue<E> createOrGetQueue(Class<E> valueClass, String name, int capacity) throws CacheException {
		try {
			
			QueueConfig qc = config.getNamedQueues().get(name);
			
			if(null == qc) {
				qc = config.getDefaultQueueConfig();
			}
			
			CollectionConfiguration cfg = new CollectionConfiguration();
			cfg.setAtomicityMode(qc.getQueueAtomicity());
			cfg.setBackups(qc.getQueueBackups());
			cfg.setCacheMode(qc.getQueueCacheMode());
			cfg.setCollocated(qc.isQueueCollocated());
			
			capacity = (capacity <= 0) ? qc.getQueueMaxSize() : capacity;
			
			return ignite.queue(name, capacity, cfg);
			
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

	@Override
	public <E> BlockingQueue<E> getQueue(Class<E> valueClass, String name) throws CacheException {
		try {
			return ignite.queue(name, 0, null);
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

}
