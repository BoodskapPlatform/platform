package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.DomainJarClassDAO;

@JsonSerialize(as=IDomainJarClass.class)
public interface IDomainJarClass extends IJarClass {

	public static DomainJarClassDAO<IDomainJarClass> dao(){
		return BoodskapSystem.storage().getDomainJarClassDAO();
	}
	
	public static IDomainJarClass create(String domainKey, String loader, String fileName, String pkg, String name) {
		return dao().create(domainKey, loader, fileName, pkg, name);
	}

	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDomainJarClass o = (IDomainJarClass) other;
		
		setDomainKey(o.getDomainKey());
		
		IJarClass.super.copy(other);
	}
	
	public String getDomainKey();
	
	public void setDomainKey(String domainKey);
}
