package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.DomainGroovyClassDAO;

@JsonSerialize(as=IDomainGroovyClass.class)
public interface IDomainGroovyClass extends IGroovyClass, IDomainObject {
	
	public static DomainGroovyClassDAO<IDomainGroovyClass> dao(){
		return BoodskapSystem.storage().getDomainGroovyClassDAO();
	}
	
	public static IDomainGroovyClass find(String domainKey, String loader, String pkg, String name, boolean loadContent) {
		return dao().get(domainKey, loader, pkg, name, loadContent);
	}

	public static IDomainGroovyClass create(String domainKey, String loader, String pkg, String name) {
		return dao().create(domainKey, loader, pkg, name);
	}

	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}

}
