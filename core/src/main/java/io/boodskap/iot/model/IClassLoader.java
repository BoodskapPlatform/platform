package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.ClassLoaderDAO;

@JsonSerialize(as=IClassLoader.class)
public interface IClassLoader extends IModel {

	public static ClassLoaderDAO<IClassLoader> dao(){
		return ClassLoaderDAO.get();
	}

	public static Class<? extends IClassLoader> clazz() {
		return dao().clazz();
	}

	public static IClassLoader create(String loader) {
		return dao().create(loader);
	}

	public static IClassLoader find(String loader) {
		return dao().get(loader);
	}

	public default void save() {
		dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IClassLoader o = (IClassLoader) other;
		
		setLoader(o.getLoader());
		
		IModel.super.copy(other);
	}
	
	public String getLoader();
	
	public void setLoader(String loader);
}
