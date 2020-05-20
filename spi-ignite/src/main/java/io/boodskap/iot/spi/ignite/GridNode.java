package io.boodskap.iot.spi.ignite;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.apache.ignite.Ignite;
import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.lang.IgniteFuture;

import io.boodskap.iot.GridException;
import io.boodskap.iot.spi.grid.INode;

public class GridNode implements INode {
	
	private final Ignite ignite;
	private final ClusterNode node;

	public GridNode(Ignite ignite, ClusterNode node) {
		this.ignite = ignite;
		this.node = node;
	}

	@Override
	public Object instanceId() throws GridException {
		try {
			return node.id();
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public Object consistentId() throws GridException {
		try {
			return node.consistentId();
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public <T> Future<T> submit(final Callable<T> task) throws GridException {
		try {
			
			final IgniteFuture<T> future = ignite.compute(ignite.cluster().forNode(node)).callAsync(new GridCallable<>(task));
			return new GridFuture<>(future);
			
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public Future<?> submit(Runnable task) throws GridException {
		try {
			final IgniteFuture<?> future = ignite.compute(ignite.cluster().forNode(node)).runAsync(new GridRunnable(task));
			return new GridFuture<>(future);
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public void run(Runnable task) throws GridException {
		try {
			ignite.compute(ignite.cluster().forNode(node)).run(new GridRunnable(task));
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	public Ignite getIgnite() {
		return ignite;
	}

	public ClusterNode getNode() {
		return node;
	}

}
