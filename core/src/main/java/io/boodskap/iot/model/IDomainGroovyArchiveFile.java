package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.DomainGroovyArchiveFileDAO;

@JsonSerialize(as=IDomainGroovyArchiveFile.class)
public interface IDomainGroovyArchiveFile extends IJarFile {

	public static DomainGroovyArchiveFileDAO<IDomainGroovyArchiveFile> dao(){
		return BoodskapSystem.storage().getDomainGroovyArchiveFileDAO();
	}
	
	public static IDomainGroovyArchiveFile create(String domainKey, String loader, String fileName) {
		return dao().create(domainKey, loader, fileName);
	}

	public static IDomainGroovyArchiveFile find(String domainKey, String loader, String fileName, boolean loadContent) {
		return dao().get(domainKey, loader, fileName, loadContent);
	}

	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}
	
	@Override
	public default void copy(Object other) {
		
		IDomainGroovyArchiveFile o = (IDomainGroovyArchiveFile) other;
		
		setDomainKey(o.getDomainKey());
		
		IJarFile.super.copy(other);
	}

	public String getDomainKey();
	
	public void setDomainKey(String domainKey);

}
