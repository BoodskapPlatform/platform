package io.boodskap.iot.spi.grid.local;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import io.boodskap.iot.GridException;
import io.boodskap.iot.spi.grid.INode;

public class LocalNode implements INode {
	
	private static final UUID id = UUID.randomUUID();
	
	private final LocalGridConfig config;
	private ExecutorService exec;

	protected LocalNode(LocalGridConfig config) {
		this.config = config;
	}
	
	protected void start() {
		
		if(null == exec || exec.isShutdown() || exec.isTerminated()) {
			
			switch(config.getThreadPoolType()) {
			case CACHED:
				exec = Executors.newCachedThreadPool();
				break;
			case FIXED:
				exec = Executors.newFixedThreadPool(config.getThreadPoolSize());
				break;
			case STEAL:
				exec = Executors.newWorkStealingPool(config.getParallelism());
				break;
			}
		}
	}
	
	protected void stop() {
		
		if(null != exec) {
			exec.shutdownNow();
		}
		
		exec = null;
	}
	
	protected boolean isRunning() {
		return (null != exec && !exec.isShutdown() && !exec.isTerminated());
	}

	@Override
	public Object instanceId() throws GridException {
		return id;
	}

	@Override
	public Object consistentId() throws GridException {
		return config.getId();
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) throws GridException {
		return exec.submit(task);
	}

	@Override
	public Future<?> submit(Runnable task) throws GridException {
		return exec.submit(task);
	}

	@Override
	public void run(Runnable task) throws GridException {
		try {
			exec.submit(task).get();
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

}
