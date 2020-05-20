package io.boodskap.iot.spi.cache.local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.CacheException;
import io.boodskap.iot.IConfig;
import io.boodskap.iot.PlatformException;
import io.boodskap.iot.spi.cache.ICache;
import io.boodskap.iot.spi.cache.ICacheFactory;

public class LocalCacheFactory implements ICacheFactory{
	
	private static final Logger LOG = LoggerFactory.getLogger(LocalCacheFactory.class);

	private LocalCache cache;

	public LocalCacheFactory() {
	}
	
	@Override
	public void init(IConfig config) throws PlatformException {
		
		try {
			
			if(null != cache) return; 
			
			LOG.info("Initializing local cache factory...");
			
			LocalCacheConfig cc = (LocalCacheConfig) config;
			
			if(null == cache) {
				cache = LocalCache.get();
				cache.init(cc);
			}
			
			
		}catch(Exception ex) {
			throw new PlatformException(ex);
		}
	}

	@Override
	public void dispose() throws PlatformException {
		
		if(null != cache) {
			cache.close();
		}
		
		cache = null;
	}

	@Override
	public ICache getCache() throws CacheException {
		if(null == cache) throw new CacheException("Cache not initialied. Did ya called init()?");
		return cache;
	}

	@Override
	public Class<LocalCacheConfig> getConfigClass() {
		return LocalCacheConfig.class;
	}

	@Override
	public String getConfigSectionName() {
		return "lcache";
	}

}
