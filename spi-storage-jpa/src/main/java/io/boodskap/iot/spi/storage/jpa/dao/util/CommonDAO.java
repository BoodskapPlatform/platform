package io.boodskap.iot.spi.storage.jpa.dao.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.spi.storage.jpa.UOW;

public class CommonDAO<T> {

	private static final Logger LOG = LoggerFactory.getLogger(CommonDAO.class);
	
	protected final Class<T> clazz;
	
	public CommonDAO(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T select(String jql, Map<String, Serializable> params) {
		try {
			return UOW.select(clazz, jql, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public T get(String whereCluase, Map<String, Serializable> params) {
		try {
			return UOW.get(clazz, whereCluase, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public T getUnique(String whereCluase, Map<String, Serializable> params) {
		try {
			return UOW.getUnique(clazz, whereCluase, params);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public T find(Serializable pk) {
		try {
			return UOW.find(clazz, pk);
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long countByQuery(String jql) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where %s", clazz.getSimpleName(), jql));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long countByQuery(String jql, Map<String, Serializable> params) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where %s", clazz.getSimpleName(), jql));
			for(Map.Entry<String, Serializable> me : params.entrySet()) {
				query.setParameter(me.getKey(), me.getValue());
			}
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long count() throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v", clazz.getSimpleName()));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long sum(String field) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select sum(v.%s) from %s v", field, clazz.getSimpleName()));
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long sum(String field, String domainKey) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select sum(v.%s) from %s v where v.id.domainKey=:dkey", field, clazz.getSimpleName()));
			query.setParameter("dkey", domainKey);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long sum(String field, String domainKey, String kf1, Serializable kf1v) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select sum(v.%s) from %s v where v.id.domainKey=:dkey and v.id.%s=:kf1v", field, clazz.getSimpleName(), kf1));
			query.setParameter("dkey", domainKey);
			query.setParameter("kf1v", kf1v);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long sum(String field, String domainKey, String kf1, Serializable kf1v, String kf2, Serializable kf2v) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select sum(v.%s) from %s v where v.id.domainKey=:dkey and v.id.%s=:kf1v and v.id.%s=:kf2v", field, clazz.getSimpleName(), kf1, kf2));
			query.setParameter("dkey", domainKey);
			query.setParameter("kf1v", kf1v);
			query.setParameter("kf2v", kf2v);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long count(String domainKey) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.id.domainKey=:dkey", clazz.getSimpleName()));
			query.setParameter("dkey", domainKey);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long count(String field, Serializable fieldValue) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.%s=:fval", clazz.getSimpleName(), field));
			query.setParameter("fval", fieldValue);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long count(String domainKey, String field, Serializable fieldValue) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.id.domainKey=:dkey and v.id.%s=:fval", clazz.getSimpleName(), field));
			query.setParameter("dkey", domainKey);
			query.setParameter("fval", fieldValue);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long count(String field, Serializable fieldValue, String field2, Serializable field2Value) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.%s=:fval and v.%s=:f2val", clazz.getSimpleName(), field, field2));
			query.setParameter("fval", fieldValue);
			query.setParameter("f2val", field2Value);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long count(String field, Serializable fieldValue, String field2, Serializable field2Value, String field3, Serializable field3Value) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.%s=:fval and v.%s=:f2val and v.%s=:f3val", clazz.getSimpleName(), field, field2, field3));
			query.setParameter("fval", fieldValue);
			query.setParameter("f2val", field2Value);
			query.setParameter("f3val", field3Value);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long count(String domainKey, String field1, Serializable field1Value, String field2, Serializable field2Value) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.id.domainKey=:dkey and v.id.%s=:f1val and v.id.%s=:f2val", clazz.getSimpleName(), field1, field2));
			query.setParameter("dkey", domainKey);
			query.setParameter("f1val", field1Value);
			query.setParameter("f2val", field2Value);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public long count(String domainKey, String field1, Serializable field1Value, String field2, Serializable field2Value, String field3, Serializable field3Value) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("select count(v) from %s v where v.id.domainKey=:dkey and v.id.%s=:f1val and v.id.%s=:f2val and v.id.%s=:f3val", clazz.getSimpleName(), field1, field2, field3));
			query.setParameter("dkey", domainKey);
			query.setParameter("f1val", field1Value);
			query.setParameter("f2val", field2Value);
			query.setParameter("f3val", field3Value);
			return DBUtil.toCount(query.getSingleResult());
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}

	public void deleteByQuery(String jql) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where %s", clazz.getSimpleName()));
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss", deleted, clazz.getSimpleName().toLowerCase()));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public void delete(String fname, Serializable fvalue) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.%s=:fval", clazz.getSimpleName(), fname));
			query.setParameter("fval", fvalue);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss", deleted, clazz.getSimpleName().toLowerCase()));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public void delete(String fname, Serializable fvalue, String f2name, Serializable f2value) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.%s=:fval and v.%s=:f2val", clazz.getSimpleName(), fname, f2name));
			query.setParameter("fval", fvalue);
			query.setParameter("f2val", f2value);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss", deleted, clazz.getSimpleName().toLowerCase()));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public void delete(String fname, Serializable fvalue, String f2name, Serializable f2value, String f3name, Serializable f3value) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.%s=:fval and v.%s=:f2val and v.%s=:f3val", clazz.getSimpleName(), fname, f2name, f3name));
			query.setParameter("fval", fvalue);
			query.setParameter("f2val", f2value);
			query.setParameter("f3val", f3value);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss", deleted, clazz.getSimpleName().toLowerCase()));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public void delete() throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s", clazz.getSimpleName()));
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss", deleted, clazz.getSimpleName().toLowerCase()));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public void delete(String domainKey) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.id.domainKey=:dkey", clazz.getSimpleName()));
			query.setParameter("dkey", domainKey);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss from domain %s", deleted, clazz.getSimpleName().toLowerCase(), domainKey));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public void delete(String domainKey, String field, Serializable fieldValue) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.id.domainKey=:dkey and v.id.%s=:fval", clazz.getSimpleName(), field));
			query.setParameter("dkey", domainKey);
			query.setParameter("fval", fieldValue);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss from domain %s where %s=%s", deleted, clazz.getSimpleName().toLowerCase(), domainKey, field, fieldValue));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public void delete(String domainKey, String field1, Serializable field1Value, String field2, Serializable field2Value) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.id.domainKey=:dkey and v.id.%s=:f1val and v.id.%s=:f2val", clazz.getSimpleName(), field1, field2));
			query.setParameter("dkey", domainKey);
			query.setParameter("f1val", field1Value);
			query.setParameter("f2val", field2Value);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss from domain %s where %s=%s and %s=%s", deleted, clazz.getSimpleName().toLowerCase(), domainKey, field1, field1Value, field2, field2Value));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public void delete(String domainKey, String field1, Serializable field1Value, String field2, Serializable field2Value, String field3, Serializable field3Value) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.id.domainKey=:dkey and v.id.%s=:f1val and v.id.%s=:f2val and v.id.%s=:f3val", clazz.getSimpleName(), field1, field2, field3));
			query.setParameter("dkey", domainKey);
			query.setParameter("f1val", field1Value);
			query.setParameter("f2val", field2Value);
			query.setParameter("f3val", field3Value);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss from domain %s where %s=%s and %s=%s and %s=%s", deleted, clazz.getSimpleName().toLowerCase(), domainKey, field1, field1Value, field2, field2Value, field3, field3Value));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public void delete(String domainKey, String field1, Serializable field1Value, String field2, Serializable field2Value, String field3, Serializable field3Value, String field4, Serializable field4Value) throws StorageException {
		try {
			Query query = UOW.createQuery(String.format("delete from %s v where v.id.domainKey=:dkey and v.id.%s=:f1val and v.id.%s=:f2val and v.id.%s=:f3val and v.id.%s=:f4val", clazz.getSimpleName(), field1, field2, field3, field4));
			query.setParameter("dkey", domainKey);
			query.setParameter("f1val", field1Value);
			query.setParameter("f2val", field2Value);
			query.setParameter("f3val", field3Value);
			query.setParameter("f4val", field4Value);
			UOW.begin();
			int deleted = query.executeUpdate();
			UOW.commit();
			LOG.debug(String.format("deleted %d %ss from domain %s where %s=%s and %s=%s and %s=%s", deleted, clazz.getSimpleName().toLowerCase(), domainKey, field1, field1Value, field2, field2Value, field3, field3Value));
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
	}
	
	public static Collection<String> list(int page, int pageSize, String jql, Map<String, Serializable> params){
		
		TypedQuery<String> q = UOW.createQuery(jql, String.class);
		
		params.forEach((k,v) -> {
			q.setParameter(k, v);
		});
		
		q.setFirstResult(page);
		q.setMaxResults(pageSize);
		
		return q.getResultList();
		
	}
	

	public Collection<T> list(String jql, Map<String, Serializable> params) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(jql, clazz);
			
			for(Map.Entry<String, Serializable> me : params.entrySet()) {
				query.setParameter(me.getKey(), me.getValue());
			}
			
			Collection<T> list = query.getResultList();
			
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(String jql, Map<String, Serializable> params, int page, int pageSize) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(jql, clazz);
			
			for(Map.Entry<String, Serializable> me : params.entrySet()) {
				query.setParameter(me.getKey(), me.getValue());
			}
			
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			Collection<T> list = query.getResultList();
			
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(String orderBy) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(String.format("select v from %s v order by v.%s", clazz.getSimpleName(), orderBy), clazz);			
			Collection<T> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(int page, int pageSize, String orderBy) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(String.format("select v from %s v order by v.%s", clazz.getSimpleName(), orderBy), clazz);
			
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			Collection<T> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(String domainKey, String orderBy) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(String.format("select v from %s v where v.id.domainKey=:dkey order by v.%s", clazz.getSimpleName(), orderBy), clazz);
			query.setParameter("dkey", domainKey);
			Collection<T> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(String domainKey, int page, int pageSize, String orderBy) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(String.format("select v from %s v where v.id.domainKey=:dkey order by v.%s", clazz.getSimpleName(), orderBy), clazz);
			query.setParameter("dkey", domainKey);
			
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			Collection<T> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(String domainKey, String idf2, Serializable idf2Value, int page, int pageSize, String orderBy) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(String.format("select v from %s v where v.id.domainKey=:dkey and v.id.%s=:idf2 order by v.%s", clazz.getSimpleName(), idf2, orderBy), clazz);
			query.setParameter("dkey", domainKey);
			query.setParameter("idf2", idf2Value);
			
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			Collection<T> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(String idf, Serializable idfValue, int page, int pageSize, String orderBy) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(String.format("select v from %s v where v.id.%s=:idf order by v.%s", clazz.getSimpleName(), idf, orderBy), clazz);
			query.setParameter("idf", idfValue);
			
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			Collection<T> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(String idf, Serializable idfValue, String idf2, Serializable idf2Value, int page, int pageSize, String orderBy) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(String.format("select v from %s v where v.id.%s=:idf and v.id.%s=:idf2 order by v.%s", clazz.getSimpleName(), idf, idf2, orderBy), clazz);
			query.setParameter("idf", idfValue);
			query.setParameter("idf2", idf2Value);
			
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			Collection<T> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(String domainKey, String idf2, Serializable idf2Value, String idf3, Serializable idf3Value, int page, int pageSize, String orderBy) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(String.format("select v from %s v where v.id.domainKey=:dkey and v.id.%s=:idf2 and v.id.%s=:idf3 order by v.%s", clazz.getSimpleName(), idf2, idf3, orderBy), clazz);
			query.setParameter("dkey", domainKey);
			query.setParameter("idf2", idf2Value);
			query.setParameter("idf3", idf3Value);
			
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			Collection<T> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> list(String domainKey, String idf2, Serializable idf2Value, String idf3, Serializable idf3Value, String idf4, Serializable idf4Value, int page, int pageSize, String orderBy) throws StorageException {
		
		try {
			
			TypedQuery<T> query = UOW.createQuery(String.format("select v from %s v where v.id.domainKey=:dkey and v.id.%s=:idf2 and v.id.%s=:idf3 and v.id.%s=:idf4 order by v.%s", clazz.getSimpleName(), idf2, idf3, idf4, orderBy), clazz);
			query.setParameter("dkey", domainKey);
			query.setParameter("idf2", idf2Value);
			query.setParameter("idf3", idf3Value);
			query.setParameter("idf4", idf4Value);
			
			query.setFirstResult(page);
			query.setMaxResults(pageSize);
			Collection<T> list = query.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> search(String jql, Map<String, Serializable> params, String query, int pageSize) throws StorageException {
		
		try {
			
			String fjql = String.format("%s AND %s", jql, DBUtil.searchToQuery(query));
			LOG.debug(String.format("SEARCH:%s", jql));
			TypedQuery<T> tquery = UOW.createQuery(fjql, clazz);
			
			for(Map.Entry<String, Serializable> me : params.entrySet()) {
				tquery.setParameter(me.getKey(), me.getValue());
			}
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			Collection<T> list = tquery.getResultList();
			
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> search(String query, int pageSize) throws StorageException {
		
		try {
			
			String jql = String.format("select v from %s v where %s", clazz.getSimpleName(), DBUtil.searchToQuery(query));
			LOG.debug(String.format("SEARCH:%s", jql));
			TypedQuery<T> tquery = UOW.createQuery(jql, clazz);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			Collection<T> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> search(String query, String domainKey, int pageSize) throws StorageException {
		
		try {
			
			String jql = String.format("select v from %s v where v.id.domainKey=:dkey and %s", clazz.getSimpleName(), DBUtil.searchToQuery(query));
			LOG.debug(String.format("SEARCH:%s", jql));
			TypedQuery<T> tquery = UOW.createQuery(jql, clazz);
			tquery.setParameter("dkey", domainKey);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			Collection<T> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> search(String query, String idf, Serializable idfValue, int pageSize) throws StorageException {
		
		try {
			
			String jql = String.format("select v from %s v where v.id.%s=:idf and %s", clazz.getSimpleName(), idf, DBUtil.searchToQuery(query));
			LOG.debug(String.format("SEARCH:%s", jql));
			TypedQuery<T> tquery = UOW.createQuery(jql, clazz);
			tquery.setParameter("idf", idfValue);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			Collection<T> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> search(String query, String domainKey, String idf2, Serializable idf2Value, int pageSize) throws StorageException {
		
		try {
			
			String jql = String.format("select v from %s v where v.id.domainKey=:dkey and v.id.%s=:idf2 and %s", clazz.getSimpleName(), idf2, DBUtil.searchToQuery(query));
			LOG.debug(String.format("SEARCH:%s", jql));
			TypedQuery<T> tquery = UOW.createQuery(jql, clazz);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("idf2", idf2Value);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			Collection<T> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> search(String query, String domainKey, String idf2, Serializable idf2Value, String idf3, Serializable idf3Value, int pageSize) throws StorageException {
		
		try {
			
			String jql = String.format("select v from %s v where v.id.domainKey=:dkey and v.id.%s=:idf2 and v.id.%s=:idf3 and %s", clazz.getSimpleName(), idf2, DBUtil.searchToQuery(query));
			LOG.debug(String.format("SEARCH:%s", jql));
			TypedQuery<T> tquery = UOW.createQuery(jql, clazz);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("idf2", idf2Value);
			tquery.setParameter("idf3", idf3Value);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			Collection<T> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> searchData(String query, String domainKey, int pageSize) throws StorageException {
		
		try {
			
			String jql = String.format("select v from %s v where v.id.domainKey=:dkey and %s", clazz.getSimpleName(), DBUtil.searchDataToQuery(query));
			LOG.debug(String.format("SEARCH:%s", jql));
			TypedQuery<T> tquery = UOW.createQuery(jql, clazz);
			tquery.setParameter("dkey", domainKey);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			Collection<T> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
	public Collection<T> searchData(String query, String domainKey, String idf2, Serializable idf2Value, int pageSize) throws StorageException {
		
		try {
			
			String jql = String.format("select v from %s v where v.id.domainKey=:dkey and v.id.%s=:idf2 and %s", clazz.getSimpleName(), idf2, DBUtil.searchDataToQuery(query));
			LOG.debug(String.format("SEARCH:%s", jql));
			TypedQuery<T> tquery = UOW.createQuery(jql, clazz);
			tquery.setParameter("dkey", domainKey);
			tquery.setParameter("idf2", idf2Value);
			
			tquery.setFirstResult(0);
			tquery.setMaxResults(pageSize);
			Collection<T> list = tquery.getResultList();
			return list;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}
	
}
