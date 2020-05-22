package io.boodskap.iot.spi.ignite.cache;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.boodskap.iot.IConfig;

public class IgniteCacheConfiguration implements IConfig{
	
	private static final long serialVersionUID = -3139496730177585266L;

	private String gridName;
	private String configFile;
	private boolean clientMode;
	private CacheConfig defaultCacheConfig;
	private QueueConfig defaultQueueConfig;
	private Map<String, CacheConfig> namedCaches;
	private Map<String, QueueConfig> namedQueues;

	public IgniteCacheConfiguration() {
		setDefaults();
	}
	
	@Override
	@JsonIgnore
	public int getStartPriority() {
		return 1;
	}

	@Override
	public void setDefaults() {
		gridName = "boodskap.io";
		configFile = "ignite.xml";
		clientMode = true;
		defaultCacheConfig = new CacheConfig();
		defaultQueueConfig = new QueueConfig();
		namedCaches = new HashMap<>();
		namedQueues = new HashMap<>();
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	public CacheConfig getDefaultCacheConfig() {
		return defaultCacheConfig;
	}

	public void setDefaultCacheConfig(CacheConfig defaultCacheConfig) {
		this.defaultCacheConfig = defaultCacheConfig;
	}

	public QueueConfig getDefaultQueueConfig() {
		return defaultQueueConfig;
	}

	public void setDefaultQueueConfig(QueueConfig defaultQueueConfig) {
		this.defaultQueueConfig = defaultQueueConfig;
	}

	public Map<String, CacheConfig> getNamedCaches() {
		return namedCaches;
	}

	public void setNamedCaches(Map<String, CacheConfig> namedCaches) {
		this.namedCaches = namedCaches;
	}

	public Map<String, QueueConfig> getNamedQueues() {
		return namedQueues;
	}

	public void setNamedQueues(Map<String, QueueConfig> namedQueues) {
		this.namedQueues = namedQueues;
	}

	public boolean isClientMode() {
		return clientMode;
	}

	public void setClientMode(boolean clientMode) {
		this.clientMode = clientMode;
	}

}
