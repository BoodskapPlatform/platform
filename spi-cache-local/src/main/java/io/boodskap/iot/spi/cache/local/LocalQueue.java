package io.boodskap.iot.spi.cache.local;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.mapdb.IndexTreeList;

public class LocalQueue<E> implements BlockingQueue<E> {
	
	private final IndexTreeList<E> list;
	private final int limit;
	
	private final Lock lock = new ReentrantLock(); 
	private final Condition produceCond  = lock.newCondition(); 
	private final Condition consumeCond = lock.newCondition(); 
	
	protected LocalQueue(IndexTreeList<E> list, int limit) {
		this.list = list;
		this.limit = limit <= 0 ? Integer.MAX_VALUE : limit;
	}

	@Override
	public E remove() {
		
		lock.lock();
		
		try {
			return list.remove(0);
		}finally {
			lock.unlock();
		}
	}

	@Override
	public E poll() {
		
		lock.lock();
		
		try {
						
			if(isEmpty()) return null;
			
			return remove();
			
		}finally {
			lock.unlock();
		}
	}

	@Override
	public E element() {
		
		lock.lock();
		
		try {
			return list.get(0);
		}finally {
			lock.unlock();
		}
	}

	@Override
	public E peek() {
		
		lock.lock();
		
		try {
			if(isEmpty()) return null;
			return list.get(0);
		}finally {
			lock.unlock();
		}
	}

	@Override
	public int size() {
		
		lock.lock();
		
		try {
			return list.size();
		}finally {
			lock.unlock();
		}
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
		
		lock.lock();
		
		boolean changed = false;
		
		try {
			return changed = list.addAll(c);
		}finally {
			
			if(changed) {
				consumeCond.signal();
			}
			
			lock.unlock();
		}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		
		lock.lock();
		
		try {
			return list.removeAll(c);
		}finally {
			lock.unlock();
		}
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		
		lock.lock();
		
		try {
			return list.retainAll(c);
		}finally {
			lock.unlock();
		}
	}

	@Override
	public void clear() {
		
		lock.lock();
		
		try {
			list.clear();
		}finally {
			lock.unlock();
		}
	}

	@Override
	public boolean add(E e) {
		
		lock.lock();
		
		try {
			if(size() >= limit) return false;
			
			boolean added = false;
			
			if(added = list.add(e)) {
				consumeCond.signal();
			}
			
			return added;
		}finally {
			lock.unlock();
		}
	}

	@Override
	public boolean offer(E e) {
		return add(e);
	}

	@Override
	public void put(E e) throws InterruptedException {
		
		lock.lock();
		
		try {
			
			while(size() >= limit) {
				synchronized(this) {
					produceCond.await();
				}
			}
			
			if(list.add(e)) {
				consumeCond.signal();
			}

		}finally {
			lock.unlock();
		}

	}

	@Override
	public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
				
		lock.lock();
		
		try {
			
			boolean canAdd = true;
			
			if(size() >= limit) {
				synchronized(this) {
					canAdd = produceCond.await(timeout, unit);
				}
			}
			
			return canAdd ? add(e) : false;
						
		}finally {
			lock.unlock();
		}

	}

	@Override
	public E take() throws InterruptedException {
		
		lock.lock();
		
		try {
			
			while(isEmpty()) {
				consumeCond.await();
			}
			
			return poll();
			
		}finally {
			lock.unlock();
		}
		
	}

	@Override
	public E poll(long timeout, TimeUnit unit) throws InterruptedException {
		
		lock.lock();
		
		try {
			
			if(isEmpty()) {
				consumeCond.await(timeout, unit);
			}
			
			return poll();
			
		}finally {
			lock.unlock();
		}
		
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
		
		lock.lock();
		
		try {
			
			return list.remove(o);
			
		}finally {
			lock.unlock();
		}
		
	}

	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	@Override
	public int drainTo(Collection<? super E> c) {
		return drainTo(c, Integer.MAX_VALUE);
	}

	@Override
	public int drainTo(Collection<? super E> c, int maxElements) {
		
		lock.lock();
		
		try {
			
			int drained = 0;
			
			for(int i=0;i<list.size();i++) {
				
				c.add(list.remove(0));
				
				++drained;
				
				if(drained >= maxElements) {
					break;
				}
			}
			
			return drained;
			
		}finally {
			lock.unlock();
		}
		
	}

}
