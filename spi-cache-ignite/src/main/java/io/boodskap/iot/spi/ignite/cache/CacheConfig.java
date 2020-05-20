package io.boodskap.iot.spi.ignite.cache;

import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;

public class CacheConfig {

	private CacheAtomicityMode cacheAtomicity = CacheAtomicityMode.ATOMIC;
	private CacheMode cacheMode = CacheMode.REPLICATED;
	private int cacheBackups = 0;
	
	public CacheConfig() {
	}

	public CacheAtomicityMode getCacheAtomicity() {
		return cacheAtomicity;
	}

	public void setCacheAtomicity(CacheAtomicityMode cacheAtomicity) {
		this.cacheAtomicity = cacheAtomicity;
	}

	public CacheMode getCacheMode() {
		return cacheMode;
	}

	public void setCacheMode(CacheMode cacheMode) {
		this.cacheMode = cacheMode;
	}

	public int getCacheBackups() {
		return cacheBackups;
	}

	public void setCacheBackups(int cacheBackups) {
		this.cacheBackups = cacheBackups;
	}

}
