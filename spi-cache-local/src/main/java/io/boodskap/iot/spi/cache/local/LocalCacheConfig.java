package io.boodskap.iot.spi.cache.local;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.boodskap.iot.IConfig;

public class LocalCacheConfig implements IConfig {
	
	private static final long serialVersionUID = 6621123405626354284L;
	
	private int queueMaxSize;

	public LocalCacheConfig() {
	}
	
	@Override
	@JsonIgnore
	public int getStartPriority() {
		return 1;
	}

	@Override
	public void setDefaults() {
		queueMaxSize = 10000;
	}

	public int getQueueMaxSize() {
		return queueMaxSize;
	}

}
