package io.boodskap.iot.spi.storage.jpa.dao.util;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.EntityIterator;
import io.boodskap.iot.spi.storage.jpa.UOW;

public class StringFieldEntityIterator implements EntityIterator<String> {
	
	private final TypedQuery<String> query;
	private int page = 0;
	private String found = null;

	public StringFieldEntityIterator(Class<?> entityClass, String field, String orderField) {
		query = UOW.createQuery(String.format("select new java.lang.String(v.%s) from %s v order by v.%s", field, entityClass.getSimpleName(), orderField), String.class);
	}

	public StringFieldEntityIterator(Class<?> entityClass, String field, String pkField, Serializable pkFieldValue, String orderField) {
		query = UOW.createQuery(String.format("select new java.lang.String(v.%s) from %s v where v.id.%s=:pkfval order by v.%s", field, entityClass.getSimpleName(), pkField, orderField), String.class);
		query.setParameter("pkfval", pkFieldValue);
	}

	public StringFieldEntityIterator(Class<?> entityClass, String field, String pkField1, Serializable pkField1Value, String pkField2, Serializable pkField2Value, String orderField) {
		query = UOW.createQuery(String.format("select new java.lang.String(v.%s) from %s v where v.id.%s=:pkf1val and v.id.%s=:pkf2val order by v.%s", field, entityClass.getSimpleName(), pkField1, pkField2, orderField), String.class);
		query.setParameter("pkf1val", pkField1Value);
		query.setParameter("pkf2val", pkField2Value);
	}

	public StringFieldEntityIterator(Class<?> entityClass, String field, String pkField1, Serializable pkField1Value, String pkField2, Serializable pkField2Value, String pkField3, Serializable pkField3Value, String orderField) {
		query = UOW.createQuery(String.format("select new java.lang.String(v.%s) from %s v where v.id.%s=:pkf1val and v.id.%s=:pkf2val and v.id.%s=:pkf3val order by v.%s", field, entityClass.getSimpleName(), pkField1, pkField2, pkField3, orderField), String.class);
		query.setParameter("pkf1val", pkField1Value);
		query.setParameter("pkf2val", pkField2Value);
		query.setParameter("pkf3val", pkField3Value);
	}

	@Override
	public boolean hasNext() throws StorageException {
		query.setFirstResult(page);
		query.setMaxResults(1);
		List<String> list = query.getResultList();
		if(null != list && !list.isEmpty()) {
			found = list.get(0);
		}
		return (found != null);
	}

	@Override
	public String next() throws StorageException {
		if(null == found) hasNext();
		String rasset = found;
		found = null;
		++page;
		return rasset;
	}

}
