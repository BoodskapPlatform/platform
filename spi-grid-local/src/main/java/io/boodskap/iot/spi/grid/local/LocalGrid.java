package io.boodskap.iot.spi.grid.local;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.GridException;
import io.boodskap.iot.spi.grid.IGrid;
import io.boodskap.iot.spi.grid.INode;
import io.boodskap.iot.spi.grid.INodeListener;

public class LocalGrid implements IGrid {
	
	private static final Logger LOG = LoggerFactory.getLogger(LocalGrid.class);
	
	private static LocalGrid instance;
	
	private final LocalNode node;

	private LocalGrid(LocalGridConfig config) {
		this.node = new LocalNode(config);
	}
	
	protected static LocalGrid get(LocalGridConfig config) {
		if(null == instance) {
			instance = new LocalGrid(config);
		}
		return instance;
	}
	
	protected void start() {
		LOG.info("Starting...");
		node.start();
	}
	
	protected void stop() {
		LOG.info("Stopping...");
		node.stop();
	}
	
	protected boolean isRunning() {
		return node.isRunning();
	}

	@Override
	public INode thisNode() throws GridException {
		return node;
	}

	@Override
	public List<INode> listNodes() throws GridException {
		return Arrays.asList(node);
	}

	@Override
	public INode getNode(Object id) throws GridException {
		
		if(node.instanceId().equals(id)) return node;
		
		return null;
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) throws GridException {
		return node.submit(task);
	}

	@Override
	public Future<?> submit(Runnable task) throws GridException {
		return node.submit(task);
	}

	@Override
	public <T> List<Future<T>> broadcast(Callable<T> task, boolean includeThis) throws GridException {
		 return includeThis ? Arrays.asList(node.submit(task)) : new ArrayList<>();
	}

	@Override
	public List<Future<?>> broadcast(Runnable task, boolean includeThis) throws GridException {
		return includeThis ? Arrays.asList(node.submit(task)) : new ArrayList<>();
	}

	@Override
	public void run(Runnable task) throws GridException {
		node.run(task);
	}

	@Override
	public <T> T call(Callable<T> task) throws GridException {
		try {
			return node.submit(task).get();
		} catch (Exception ex) {
			throw new GridException(ex);
		}
	}

	@Override
	public void addListener(INodeListener listener) throws GridException {
		//do nothing
	}

	@Override
	public void removeListener(INodeListener listener) throws GridException {
		//do nothing
	}

}
