package io.boodskap.iot.spi.grid.local;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.boodskap.iot.IConfig;

public class LocalGridConfig implements IConfig {
	
	private static final long serialVersionUID = -1862628799139992565L;
	
	private UUID id;
	private int threadPoolSize;

	public LocalGridConfig() {
	}

	@Override
	@JsonIgnore
	public int getStartPriority() {
		return 1;
	}

	@Override
	public void setDefaults() {
		id = UUID.randomUUID();
		threadPoolSize = 25;
	}

	public UUID getId() {
		return id;
	}

	public int getThreadPoolSize() {
		return threadPoolSize;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}

}
