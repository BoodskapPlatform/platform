package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=IJavaClass.class)
public interface IJavaClass extends IModel{

	@Override
	public default void copy(Object other) {
		
		IJavaClass o = (IJavaClass) other;

		setLoader(o.getLoader());
		setPkg(o.getPkg());
		
		IModel.super.copy(other);
	}
	
	public String getLoader();
	
	public void setLoader(String loader);
	
	public String getPkg();
	
	public void setPkg(String pkg);

}
