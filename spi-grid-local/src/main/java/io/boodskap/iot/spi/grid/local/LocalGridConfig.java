package io.boodskap.iot.spi.grid.local;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.boodskap.iot.IConfig;

public class LocalGridConfig implements IConfig {
	
	private static final long serialVersionUID = -1862628799139992565L;
	
	private UUID id;
	private ThreadPoolType threadPoolType;
	private int threadPoolSize;
	private int parallelism;

	public LocalGridConfig() {
		setDefaults();
	}

	@Override
	@JsonIgnore
	public int getStartPriority() {
		return 1;
	}

	@Override
	public void setDefaults() {
		id = UUID.randomUUID();
		threadPoolType = ThreadPoolType.CACHED;
		threadPoolSize = 25;
		parallelism = 25;
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

	public ThreadPoolType getThreadPoolType() {
		return threadPoolType;
	}

	public void setThreadPoolType(ThreadPoolType threadPoolType) {
		this.threadPoolType = threadPoolType;
	}

	public int getParallelism() {
		return parallelism;
	}

	public void setParallelism(int parallelism) {
		this.parallelism = parallelism;
	}

}
