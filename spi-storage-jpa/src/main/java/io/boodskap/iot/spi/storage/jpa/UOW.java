package io.boodskap.iot.spi.storage.jpa;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UOW {
	
	private static final Logger LOG = LoggerFactory.getLogger(UOW.class);
	
	private static final ThreadLocal<UOW> TL = new ThreadLocal<>();
	
	private final EntityManager em;

	private EntityTransaction trx;

	private UOW() {
		em = JPA.get().getEM();
	}

	private static UOW get() {
		UOW uow = TL.get();
		if(null == uow || !uow.isOpen()) {
			uow = new UOW();
			TL.set(uow);
		}
		return uow;
	}
	
	public boolean isOpen() {
		return em.isOpen();
	}
	
	public void close() {
		em.close();
	}
	
	public static void begin() {
		UOW uow = get();
		uow.trx = uow.em.getTransaction();
		uow.trx.begin();
	}
	
	public static void rollback() {
		UOW uow = get();
		try{uow.trx.rollback();}catch(Exception ex) {LOG.warn("Rollback Failed", ex);}
	}
	
	public static void commit() {
		UOW uow = get();
		uow.trx.commit();
	}
	
	public static void dispose() {
		UOW uow = TL.get();
		if(null != uow) {
			uow.close();
		}
		TL.remove();
	}
	
	public static void persist(Object entity) {
		UOW uow = get();
		uow.em.persist(entity);
	}

	public static <T> T merge(T entity) {
		UOW uow = get();
		return uow.em.merge(entity);
	}

	public static void remove(Object entity) {
		UOW uow = get();
		uow.em.remove(entity);
	}

	public static <T> T get(Class<T> entityClass, String whereCluase, Map<String, Serializable> params) {
		try {
			UOW uow = get();
			TypedQuery<T> tquery = uow.em.createQuery(String.format("from %s v where %s", entityClass.getSimpleName(), whereCluase), entityClass);
			
			if(null != params) {
				for(Map.Entry<String, Serializable> me : params.entrySet()) {
					tquery.setParameter(me.getKey(), me.getValue());
				}
			}
			tquery.setFirstResult(0);
			tquery.setMaxResults(1);
			List<T> list = tquery.getResultList();
			T v = list.isEmpty() ? null : list.get(0);
			if(null != v) {
				refresh(v);
				//uow.em.detach(v);
			}
			return v;
		} catch (NoResultException nrx) {
			return null;
		}
	}

	public static <T> T select(Class<T> entityClass, String jql, Map<String, Serializable> params) {
		try {
			UOW uow = get();
			TypedQuery<T> tquery = uow.em.createQuery(jql, entityClass);
			
			if(null != params) {
				for(Map.Entry<String, Serializable> me : params.entrySet()) {
					tquery.setParameter(me.getKey(), me.getValue());
				}
			}
			tquery.setFirstResult(0);
			tquery.setMaxResults(1);
			List<T> list = tquery.getResultList();
			T v = list.isEmpty() ? null : list.get(0);
			if(null != v) {
				refresh(v);
				//uow.em.detach(v);
			}
			return v;
		} catch (NoResultException nrx) {
			return null;
		}
	}

	public static <T> T getUnique(Class<T> entityClass, String query, Map<String, Serializable> params) {
		try {
			UOW uow = get();
			TypedQuery<T> tquery = uow.em.createQuery(String.format("from %s v where %s", entityClass.getSimpleName(), query), entityClass);
			if(null != params) {
				for(Map.Entry<String, Serializable> me : params.entrySet()) {
					tquery.setParameter(me.getKey(), me.getValue());
				}
			}
			T v = tquery.getSingleResult();
			if(null != v) {
				refresh(v);
				//uow.em.detach(v);
			}
			return v;
		} catch (NoResultException nrx) {
			return null;
		}
	}

	public static <T> T find(Class<T> entityClass, Serializable primaryKey) {
		UOW uow = get();
		T v = uow.em.find(entityClass, primaryKey);
		if(null != v) {
			refresh(v);
			//uow.em.detach(v);
		}
		return v;
	}

	public static <T> T find(Class<T> entityClass, Serializable primaryKey, Map<String, Object> properties) {
		UOW uow = get();
		T v = uow.em.find(entityClass, primaryKey, properties);
		if(null != v) {
			refresh(v);
			//uow.em.detach(v);
		}
		return v;
	}

	public static <T> T find(Class<T> entityClass, Serializable primaryKey, LockModeType lockMode) {
		UOW uow = get();
		T v = uow.em.find(entityClass, primaryKey, lockMode);
		if(null != v) {
			refresh(v);
			//uow.em.detach(v);
		}
		return v;
	}

	public static <T> T find(Class<T> entityClass, Serializable primaryKey, LockModeType lockMode, Map<String, Object> properties) {
		UOW uow = get();
		T v = uow.em.find(entityClass, primaryKey, lockMode, properties);
		if(null != v) {
			refresh(v);
			//uow.em.detach(v);
		}
		return v;
	}

	public static <T> T getReference(Class<T> entityClass, Serializable primaryKey) {
		UOW uow = get();
		return uow.em.getReference(entityClass, primaryKey);
	}

	public static void flush() {
		UOW uow = get();
		UOW.begin();
		uow.em.flush();
		UOW.commit();
	}

	public static void setFlushMode(FlushModeType flushMode) {
		UOW uow = get();
		uow.em.setFlushMode(flushMode);
	}

	public static FlushModeType getFlushMode() {
		UOW uow = get();
		return uow.em.getFlushMode();
	}

	public static void lock(Object entity, LockModeType lockMode) {
		UOW uow = get();
		uow.em.lock(entity, lockMode);
	}

	public static void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		UOW uow = get();
		uow.em.lock(entity, lockMode, properties);
	}

	public static void refresh(Object entity) {
		UOW uow = get();
		UOW.begin();
		if(uow.em.contains(entity)) {
			uow.em.refresh(entity);
		}
		UOW.commit();
	}

	public static void refresh(Object entity, Map<String, Object> properties) {
		UOW uow = get();
		UOW.begin();
		if(uow.em.contains(entity)) {
			uow.em.refresh(entity, properties);
		}
		UOW.commit();
	}

	public static void refresh(Object entity, LockModeType lockMode) {
		UOW uow = get();
		UOW.begin();
		if(uow.em.contains(entity)) {
			uow.em.refresh(entity, lockMode);
		}
		UOW.commit();
	}

	public static void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		UOW uow = get();
		UOW.begin();
		if(uow.em.contains(entity)) {
			uow.em.refresh(entity, lockMode, properties);
		}
		UOW.commit();
	}

	public static void clear() {
		UOW uow = get();
		uow.em.clear();
	}

	public static void detach(Object entity) {
		UOW uow = get();
		uow.em.detach(entity);
	}

	public static boolean contains(Object entity) {
		UOW uow = get();
		return uow.em.contains(entity);
	}

	public static LockModeType getLockMode(Object entity) {
		UOW uow = get();
		return uow.em.getLockMode(entity);
	}

	public static void setProperty(String propertyName, Object value) {
		UOW uow = get();
		uow.em.setProperty(propertyName, value);
	}

	public static Map<String, Object> getProperties() {
		UOW uow = get();
		return uow.em.getProperties();
	}

	public static Query createQuery(String qlString) {
		UOW uow = get();
		return uow.em.createQuery(qlString);
	}

	public static <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
		UOW uow = get();
		return uow.em.createQuery(criteriaQuery);
	}

	public static Query createQuery(CriteriaUpdate<?> updateQuery) {
		UOW uow = get();
		return uow.em.createQuery(updateQuery);
	}

	public static Query createQuery(CriteriaDelete<?> deleteQuery) {
		UOW uow = get();
		return uow.em.createQuery(deleteQuery);
	}

	public static <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
		UOW uow = get();
		return uow.em.createQuery(qlString, resultClass);
	}

	public static Query createNamedQuery(String name) {
		UOW uow = get();
		return uow.em.createNamedQuery(name);
	}

	public static <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
		UOW uow = get();
		return uow.em.createNamedQuery(name, resultClass);
	}

	public static Query createNativeQuery(String sqlString) {
		UOW uow = get();
		return uow.em.createNativeQuery(sqlString);
	}

	public static Query createNativeQuery(String sqlString, Class<?> resultClass) {
		UOW uow = get();
		return uow.em.createNativeQuery(sqlString, resultClass);
	}

	public static Query createNativeQuery(String sqlString, String resultSetMapping) {
		UOW uow = get();
		return uow.em.createNativeQuery(sqlString, resultSetMapping);
	}

	public static StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
		UOW uow = get();
		return uow.em.createNamedStoredProcedureQuery(name);
	}

	public static StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
		UOW uow = get();
		return uow.em.createStoredProcedureQuery(procedureName);
	}

	public static StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class<?>... resultClasses) {
		UOW uow = get();
		return uow.em.createStoredProcedureQuery(procedureName, resultClasses);
	}

	public static StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
		UOW uow = get();
		return uow.em.createStoredProcedureQuery(procedureName, resultSetMappings);
	}

	public static void joinTransaction() {
		UOW uow = get();
		uow.em.joinTransaction();
	}

	public static boolean isJoinedToTransaction() {
		UOW uow = get();
		return uow.em.isJoinedToTransaction();
	}

	public static <T> T unwrap(Class<T> cls) {
		UOW uow = get();
		return uow.em.unwrap(cls);
	}

	public static Object getDelegate() {
		UOW uow = get();
		return uow.em.getDelegate();
	}

	public static EntityTransaction getTransaction() {
		UOW uow = get();
		return uow.em.getTransaction();
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		UOW uow = get();
		return uow.em.getEntityManagerFactory();
	}

	public static CriteriaBuilder getCriteriaBuilder() {
		UOW uow = get();
		return uow.em.getCriteriaBuilder();
	}

	public static Metamodel getMetamodel() {
		UOW uow = get();
		return uow.em.getMetamodel();
	}

	public static <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {
		UOW uow = get();
		return uow.em.createEntityGraph(rootType);
	}

	public static EntityGraph<?> createEntityGraph(String graphName) {
		UOW uow = get();
		return uow.em.createEntityGraph(graphName);
	}

	public static EntityGraph<?> getEntityGraph(String graphName) {
		UOW uow = get();
		return uow.em.getEntityGraph(graphName);
	}

	public static <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
		UOW uow = get();
		return uow.em.getEntityGraphs(entityClass);
	}

	@Override
	protected void finalize() throws Throwable {
		if(null != em) {
			em.close();
		}
	}

}
