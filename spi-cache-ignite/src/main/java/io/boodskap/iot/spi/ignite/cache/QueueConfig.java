package io.boodskap.iot.spi.ignite.cache;

import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;

public class QueueConfig {

	private CacheAtomicityMode queueAtomicity = CacheAtomicityMode.ATOMIC;
	private CacheMode queueCacheMode = CacheMode.REPLICATED;
	private int queueMaxSize = 10000;
	private int queueBackups = 0;
	private boolean queueCollocated = false;
	
	public QueueConfig() {
	}

	public CacheAtomicityMode getQueueAtomicity() {
		return queueAtomicity;
	}

	public void setQueueAtomicity(CacheAtomicityMode queueAtomicity) {
		this.queueAtomicity = queueAtomicity;
	}

	public CacheMode getQueueCacheMode() {
		return queueCacheMode;
	}

	public void setQueueCacheMode(CacheMode queueCacheMode) {
		this.queueCacheMode = queueCacheMode;
	}

	public int getQueueMaxSize() {
		return queueMaxSize;
	}

	public void setQueueMaxSize(int queueMaxSize) {
		this.queueMaxSize = queueMaxSize;
	}

	public int getQueueBackups() {
		return queueBackups;
	}

	public void setQueueBackups(int queueBackups) {
		this.queueBackups = queueBackups;
	}

	public boolean isQueueCollocated() {
		return queueCollocated;
	}

	public void setQueueCollocated(boolean queueCollocated) {
		this.queueCollocated = queueCollocated;
	}

}
