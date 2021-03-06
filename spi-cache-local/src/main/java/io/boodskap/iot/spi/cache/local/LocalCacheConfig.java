package io.boodskap.iot.spi.cache.local;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.boodskap.iot.IConfig;

public class LocalCacheConfig implements IConfig {
	
	private static final long serialVersionUID = 6621123405626354284L;
	
	private int queueMaxSize;
	private boolean fileChannelEnable;
	private boolean fileLockDisable;

	public LocalCacheConfig() {
		setDefaults();
	}
	
	@Override
	@JsonIgnore
	public int getStartPriority() {
		return 1;
	}

	@Override
	public void setDefaults() {
		queueMaxSize = Integer.MAX_VALUE;
		fileChannelEnable = true;
		fileLockDisable = true;
	}

	public int getQueueMaxSize() {
		return queueMaxSize;
	}

	public boolean isFileChannelEnable() {
		return fileChannelEnable;
	}

	public boolean isFileLockDisable() {
		return fileLockDisable;
	}

}
