package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.DomainJarFileDAO;

@JsonSerialize(as=IDomainJarFile.class)
public interface IDomainJarFile extends IJarFile{

	public static DomainJarFileDAO<IDomainJarFile> dao(){
		return BoodskapSystem.storage().getDomainJarFileDAO();
	}
	
	public static IDomainJarFile create(String domainKey, String loader, String fileName) {
		return dao().create(domainKey, loader, fileName);
	}

	public static IDomainJarFile find(String domainKey, String loader, String fileName, boolean loadContent) {
		return dao().get(domainKey, loader, fileName, loadContent);
	}

	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IDomainJarFile o = (IDomainJarFile) other;
		
		setDomainKey(o.getDomainKey());
		
		IJarFile.super.copy(other);
	}

	public String getDomainKey();
	
	public void setDomainKey(String domainKey);

}
