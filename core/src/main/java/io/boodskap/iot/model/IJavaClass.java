package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=IJavaClass.class)
public interface IJavaClass extends IEntity{

	@Override
	public default void copy(Object other) {
		
		IJavaClass o = (IJavaClass) other;

		setLoader(o.getLoader());
		setPkg(o.getPkg());
		setName(o.getName());
		
		IEntity.super.copy(other);
	}
	
	public String getLoader();
	
	public void setLoader(String loader);
	
	public String getPkg();
	
	public void setPkg(String pkg);

	public String getName();
	
	public void setName(String name);
}
