package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.JarClassDAO;

@JsonSerialize(as=IJarClass.class)
public interface IJarClass extends IJavaClass{

	public static JarClassDAO<IJarClass> dao(){
		return BoodskapSystem.storage().getJarClassDAO();
	}
	
	public static IJarClass create(String loader, String fileName, String pkg, String name) {
		return dao().create(loader, fileName, pkg, name);
	}

	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}

	public String getFileName();
	
	public void setFileName(String fileName);
	
}
