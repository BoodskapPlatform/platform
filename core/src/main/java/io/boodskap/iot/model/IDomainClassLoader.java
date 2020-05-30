package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.DomainClassLoaderDAO;

@JsonSerialize(as=IDomainClassLoader.class)
public interface IDomainClassLoader extends IClassLoader{

	public static DomainClassLoaderDAO<IDomainClassLoader> dao(){
		return DomainClassLoaderDAO.get();
	}

	public static Class<? extends IDomainClassLoader> clazz() {
		return dao().clazz();
	}

	public static IDomainClassLoader create(String domainKey, String loader) {
		return dao().create(domainKey, loader);
	}

	public static IDomainClassLoader find(String domainKey, String loader) {
		return dao().get(domainKey, loader);
	}

	public default void save() {
		dao().createOrUpdate(this);
	}
	
	@Override
	public default void copy(Object other) {
		
		IDomainClassLoader o = (IDomainClassLoader) other;
		
		setDomainKey(o.getDomainKey());
		
		IClassLoader.super.copy(other);
	}

	public String getDomainKey();
	
	public void setDomainKey(String domainKey);
}
