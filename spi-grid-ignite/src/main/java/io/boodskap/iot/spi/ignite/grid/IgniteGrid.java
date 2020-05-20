package io.boodskap.iot.spi.ignite.grid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.IgniteEvents;
import org.apache.ignite.cluster.ClusterGroup;
import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.events.DiscoveryEvent;
import org.apache.ignite.events.EventType;
import org.apache.ignite.lang.IgniteFuture;
import org.apache.ignite.lang.IgnitePredicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.GridException;
import io.boodskap.iot.spi.grid.IGrid;
import io.boodskap.iot.spi.grid.INode;
import io.boodskap.iot.spi.grid.INodeListener;
import io.boodskap.iot.spi.ignite.GridCallable;
import io.boodskap.iot.spi.ignite.GridFuture;
import io.boodskap.iot.spi.ignite.GridNode;
import io.boodskap.iot.spi.ignite.GridRunnable;

public class IgniteGrid implements IGrid {
	
	private static final Logger LOG = LoggerFactory.getLogger(IgniteGrid.class);
	
	private final IgniteGridConfiguration config;
	private Ignite ignite;
	private boolean stopped = false;
	private final Set<INodeListener> listeners = new HashSet<>();

	public IgniteGrid(IgniteGridConfiguration config, Ignite ignite) {

		this.config = config;
		this.ignite = ignite;
		
		IgnitePredicate<DiscoveryEvent> locLsnr = evt -> {
			if(evt.type() == EventType.EVT_NODE_JOINED){
				LOG.warn(String.format("Node id:%s iid:%s joined", evt.eventNode().consistentId(), evt.eventNode().id()));
				listeners.forEach(l -> {
					l.nodeJoined(new GridNode(ignite, evt.eventNode()));
				});
			}else  if(evt.type() == EventType.EVT_NODE_LEFT){
				LOG.warn(String.format("Node id:%s iid:%s left", evt.eventNode().consistentId(), evt.eventNode().id()));
				listeners.forEach(l -> {
					l.nodeLeft(new GridNode(ignite, evt.eventNode()));
				});
			}else  if(evt.type() == EventType.EVT_NODE_FAILED){
				LOG.warn(String.format("Node id:%s iid:%s failed", evt.eventNode().consistentId(), evt.eventNode().id()));
				listeners.forEach(l -> {
					l.nodeFailed(new GridNode(ignite, evt.eventNode()));
				});
			}
			return !stopped; // Continue listening.
		};
		
		events().localListen(locLsnr, EventType.EVT_NODE_JOINED, EventType.EVT_NODE_LEFT, EventType.EVT_NODE_FAILED);
		
	}
	
	protected void close() {
		
		stopped = true;
		
		if(null != ignite) {
			ignite.close();
			ignite = null;
		}
		
		listeners.clear();
	}

	@Override
	public void addListener(INodeListener listener) throws GridException {
		listeners.add(listener);
	}

	@Override
	public void removeListener(INodeListener listener) throws GridException {
		listeners.remove(listener);
	}
	
	@Override
	public INode thisNode() throws GridException{
		try {
			return new GridNode(ignite, ignite.cluster().localNode());
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public List<INode> listNodes() throws GridException {
		try {
			final List<INode> nodes = new ArrayList<>();
			ignite.cluster().nodes().forEach(node -> {
				nodes.add(new GridNode(ignite, node));
			});
			return nodes;
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public INode getNode(Object id) throws GridException {
		try {
			ClusterNode node = ignite.cluster().node((UUID) id);
			if(null == node) return null;
			return new GridNode(ignite, node);
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) throws GridException {
		try {
			final IgniteFuture<T> future = compute().callAsync(new GridCallable<>(task));
			return new GridFuture<>(future);
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public Future<?> submit(Runnable task) throws GridException {
		try {
			final IgniteFuture<?> future = compute().runAsync(new GridRunnable(task));
			return new GridFuture<>(future);
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public <T> List<Future<T>> broadcast(Callable<T> task, boolean includeThis) throws GridException {
		
		try {
			final List<Future<T>> futures = new ArrayList<>();
			
			ignite.cluster().nodes().forEach(cn -> {
				if(!includeThis && cn.isLocal()) return;
				IgniteFuture<T> future = compute(ignite.cluster().forNode(cn)).callAsync(new GridCallable<>(task));
				futures.add(new GridFuture<>(future));
			});
			
			return futures;
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public List<Future<?>> broadcast(Runnable task, boolean includeThis) throws GridException {
		
		try {
			final List<Future<?>> futures = new ArrayList<>();
			
			ignite.cluster().nodes().forEach(cn -> {
				if(!includeThis && cn.isLocal()) return;
				IgniteFuture<?> future = compute(ignite.cluster().forNode(cn)).runAsync(new GridRunnable(task));
				futures.add(new GridFuture<>(future));
			});
			
			return futures;
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	@Override
	public void run(Runnable task) throws GridException {
		try {
			 compute().run(new GridRunnable(task));
		} catch (Exception e) {
			throw new GridException(e);
		}
	}
	
	@Override
	public <T> T call(Callable<T> task) throws GridException{
		try {
			return compute().call(new GridCallable<>(task));
		} catch (Exception e) {
			throw new GridException(e);
		}
	}

	public ClusterGroup all(){
		return ignite.cluster()
				.forAttribute(IgniteGridConfiguration.KEY_GRID_NAME, config.getGridName())
				;
	}

	public ClusterGroup local(){
		return ignite.cluster().forLocal()
				.forAttribute(IgniteGridConfiguration.KEY_GRID_NAME, config.getGridName())
				;
	}

	public ClusterGroup server(){
		return ignite.cluster().forServers()
				.forAttribute(IgniteGridConfiguration.KEY_GRID_NAME, config.getGridName())
				;
	}

	public ClusterGroup random(){
		return ignite.cluster().forRandom()
				.forAttribute(IgniteGridConfiguration.KEY_GRID_NAME, config.getGridName())
				;
	}

	public IgniteCompute compute() {
		return ignite.compute(all());
	}

	public IgniteCompute compute(ClusterGroup group) {
		return ignite.compute(group);
	}

	public IgniteEvents events() {
		return ignite.events(all());
	}

}
