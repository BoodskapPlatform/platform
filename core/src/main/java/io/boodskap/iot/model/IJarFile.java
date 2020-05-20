package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.JarFileDAO;

@JsonSerialize(as=IJarFile.class)
public interface IJarFile extends IModel{

	public static JarFileDAO<IJarFile> dao(){
		return BoodskapSystem.storage().getJarFileDAO();
	}
	
	public static IJarFile create(String loader, String fileName) {
		return dao().create(loader, fileName);
	}

	public static IJarFile find(String loader, String fileName, boolean loadContent) {
		return dao().get(loader, fileName, loadContent);
	}

	@Override
	public default void save() {
		dao().createOrUpdate(this);
	}

	public String getLoader();
	
	public void setLoader(String loader);
	
	public String getFileName();
	
	public void setFileName(String fileName);
	
	public byte[] getObjectCode();
	
	public void setObjectCode(byte[] objectCode);

}
