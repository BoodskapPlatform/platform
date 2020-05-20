package io.boodskap.iot.spi.storage.jpa.dao.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.spi.storage.jpa.UOW;

public class EntityIteratorImpl<T> implements EntityIterator<T> {
	
	private final TypedQuery<T> query;
	private int page = 0;
	private T found = null;

	public EntityIteratorImpl(Class<T> clazz, String orderField) {
		query = UOW.createQuery(String.format("select v from %s v order by v.%s", clazz.getSimpleName(), orderField), clazz);
	}

	public EntityIteratorImpl(Class<T> clazz, String domainKey, String orderField) {
		query = UOW.createQuery(String.format("select v from %s v where v.id.domainKey=:dkey order by v.%s", clazz.getSimpleName(), orderField), clazz);
		query.setParameter("dkey", domainKey);
	}

	public EntityIteratorImpl(String idf, String idfVal, String orderField, Class<T> clazz) {
		query = UOW.createQuery(String.format("select v from %s v where v.%s=:idfval order by v.%s", clazz.getSimpleName(), idf, orderField), clazz);
		query.setParameter("idfval", idfVal);
	}

	public EntityIteratorImpl(Class<T> clazz, String idf, Serializable idfValue, String orderField) {
		query = UOW.createQuery(String.format("select v from %s v where v.id.%s=:idf order by v.%s", clazz.getSimpleName(), idf, orderField), clazz);
		query.setParameter("idf", idfValue);
	}

	public EntityIteratorImpl(Class<T> clazz, String domainKey, String idf2, Serializable idf2Value, String orderField) {
		query = UOW.createQuery(String.format("select v from %s v where v.id.domainKey=:dkey and v.id.%s=:idf2 order by v.%s", clazz.getSimpleName(), idf2, orderField), clazz);
		query.setParameter("dkey", domainKey);
		query.setParameter("idf2", idf2Value);
	}

	public EntityIteratorImpl(Class<T> clazz, String domainKey, String idf2, Serializable idf2Value, String idf3, Serializable idf3Value, String orderField) {
		query = UOW.createQuery(String.format("select v from %s v where v.id.domainKey=:dkey and v.id.%s=:idf2 and v.id.%s=:idf3 order by v.%s", clazz.getSimpleName(), idf2, idf3, orderField), clazz);
		query.setParameter("dkey", domainKey);
		query.setParameter("idf2", idf2Value);
		query.setParameter("idf3", idf3Value);
	}

	@Override
	public boolean hasNext() throws StorageException {
		query.setFirstResult(page);
		query.setMaxResults(1);
		List<T> list = query.getResultList();
		if(null != list && !list.isEmpty()) {
			found = list.get(0);
		}
		return (found != null);
	}

	@Override
	public T next() throws StorageException {
		if(null == found) hasNext();
		T rasset = found;
		found = null;
		++page;
		return rasset;
	}

}
