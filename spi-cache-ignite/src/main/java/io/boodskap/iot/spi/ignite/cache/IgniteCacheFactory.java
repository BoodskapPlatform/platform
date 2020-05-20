package io.boodskap.iot.spi.ignite.cache;

import java.io.File;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.CacheException;
import io.boodskap.iot.IConfig;
import io.boodskap.iot.PlatformException;
import io.boodskap.iot.spi.cache.ICache;
import io.boodskap.iot.spi.cache.ICacheFactory;
import io.boodskap.iot.spi.ignite.IgniteSession;

public class IgniteCacheFactory implements ICacheFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(IgniteCacheFactory.class);

	private IgniteCache cache;

	public IgniteCacheFactory() {
	}

	@Override
	public void init(IConfig config) throws PlatformException {
		
		if(null != cache) return;
		
		try {
			
			LOG.info("Initializing ignite cache/grid factory...");
			
			IgniteCacheConfiguration cc = (IgniteCacheConfiguration) config;
			
			Ignite ignite = IgniteSession.get().getIgnite();
			
			if(null == ignite) {
				
				File cFile = new File(BoodskapSystem.get().getConfigFolder(), cc.getConfigFile());

				Ignition.setClientMode(cc.isClientMode());
				ignite = Ignition.start(cFile.getAbsolutePath());
				
				if(!ignite.cluster().active()) {
					LOG.warn("Ignite cluster not active, activating....");
					ignite.cluster().active(true);
				}else {
					LOG.info("Ignite cluster is active");
				}
			
				IgniteSession.get().setIgnite(ignite);
				
			}
			
			cache = new IgniteCache(cc, ignite);
			
		}catch(Exception ex) {
			throw new PlatformException(ex);
		}
	}

	@Override
	public void dispose() throws PlatformException {
		
		if(null != cache) {
			try {
				LOG.warn("Closing ignite cache");
				cache.close();
				cache = null;
			}catch(Exception ex) {
				throw new PlatformException(ex);
			}
		}
		
	}

	@Override
	public ICache getCache() throws CacheException {
		if(null == cache) throw new CacheException("Ignite cache factory not initialied. Did ya called init()?");
		return cache;
	}

	@Override
	public String getConfigSectionName() {
		return "icache";
	}

	@Override
	public Class<IgniteCacheConfiguration> getConfigClass() {
		return IgniteCacheConfiguration.class;
	}

}
