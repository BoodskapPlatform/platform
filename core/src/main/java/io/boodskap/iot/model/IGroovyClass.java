package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.GroovyClassDAO;

@JsonSerialize(as=IGroovyClass.class)
public interface IGroovyClass extends IJavaClass{

	public static GroovyClassDAO<IGroovyClass> dao(){
		return BoodskapSystem.storage().getGroovyClassDAO();
	}
	
	public static IGroovyClass find(String loader, String pkg, String name, boolean loadContent) {
		return dao().get(loader, pkg, name, loadContent);
	}
	
	public static IGroovyClass create(String loader, String pkg, String name) {
		return dao().create(loader, pkg, name);
	}

	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}
	
	public String getFileName();
	
	public void setFileName(String fileName);

	public String getCode();
	
	public void setCode(String code);
}
