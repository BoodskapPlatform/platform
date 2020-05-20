package io.boodskap.iot.spi.ignite.cache;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.apache.ignite.IgniteCache;

public class IgniteCacheMap<K, V> implements Map<K, V> {
	
	private final IgniteCache<K, V> cache;
	
	protected IgniteCacheMap(IgniteCache<K, V> cache) {
		this.cache = cache;
	}

	@Override
	public int size() {
		return cache.size();
	}

	@Override
	public boolean isEmpty() {
		return size() <= 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean containsKey(Object key) {
		return cache.containsKey((K) key);
	}

	@Override
	public boolean containsValue(Object value) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(Object key) {
		return cache.get((K) key);
	}

	@Override
	public V put(K key, V value) {
		return cache.getAndPut(key, value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V remove(Object key) {
		return cache.getAndRemove((K) key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		cache.putAll(m);
	}

	@Override
	public void clear() {
		cache.clear();
	}

	@Override
	public Set<K> keySet() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<V> values() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		throw new UnsupportedOperationException();
	}

}
