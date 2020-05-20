package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.DomainClassLoaderDAO;

@JsonSerialize(as=IDomainClassLoader.class)
public interface IDomainClassLoader extends IClassLoader, IDomainObject {

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
}
