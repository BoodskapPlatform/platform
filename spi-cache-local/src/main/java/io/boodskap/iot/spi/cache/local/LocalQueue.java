package io.boodskap.iot.spi.cache.local;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.mapdb.IndexTreeList;

public class LocalQueue<E> implements BlockingQueue<E> {
	
	private final IndexTreeList<E> list;
	private final int limit;

	protected LocalQueue(IndexTreeList<E> list, int limit) {
		this.list = list;
		this.limit = limit;
	}

	@Override
	public E remove() {
		return list.remove(0);
	}

	@Override
	public E poll() {
		if(isEmpty()) return null;
		return list.remove(0);
	}

	@Override
	public E element() {
		return list.get(0);
	}

	@Override
	public E peek() {
		if(isEmpty()) return null;
		return list.get(0);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return list.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return list.retainAll(c);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public boolean add(E e) {
		try {
			return list.add(e);
		}finally {
			synchronized(this) {
				notify();
			}
		}
	}

	@Override
	public boolean offer(E e) {
		return add(e);
	}

	@Override
	public void put(E e) throws InterruptedException {
		add(e);
	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
		
		if(limit <= 0) return add(e);
		
		while(size() >= limit) {
			synchronized(this) {
				wait(unit.toMillis(timeout));
			}
		}
		
		if(size() < limit) {
			return add(e);
		}
		
		return false;
	}

	@Override
	public E take() throws InterruptedException {
		while(isEmpty()) {
			synchronized(this) {
				wait();
			}
		}
		return poll();
	}

	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		while(isEmpty()) {
			synchronized(this) {
				wait(unit.toMillis(timeout));
			}
		}
		return poll();
	}

	@Override
	public int remainingCapacity() {
		
		if(limit > 0) {
			return (limit - size());
		}
		
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean remove(Object o) {
		return list.remove(o);
	}

	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	@Override
	public int drainTo(Collection<? super E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int drainTo(Collection<? super E> c, int maxElements) {
		throw new UnsupportedOperationException();
	}

}
