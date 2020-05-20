package io.boodskap.iot.spi.storage.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
	
	private static final JPA instance = new JPA();

	private JPAConfig config;
	private EntityManagerFactory emf = null;
	
	private JPA() {
	}

	public static final JPA get() {
		return instance;
	}
	
	public void init(JPAConfig config) {
		
		if(null == emf) {
			this.config = config;
	        emf = Persistence.createEntityManagerFactory(config.getPersistenceUnit(), config.getProperties());
		}
	}
	
	public DBType getDbType() {
		return config.getDbType();
	}

	protected void dispose() {
		
		if(null != emf) emf.close();
		
		emf = null;
	}
	
	public EntityManager getEM() {
		
		if(null == emf || !emf.isOpen()) {
			init(config);
		}
		
		return emf.createEntityManager();
	}
}
