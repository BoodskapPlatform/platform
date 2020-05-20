package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=IJavaClass.class)
public interface IJavaClass extends IModel{

	public String getLoader();
	
	public void setLoader(String loader);
	
	public String getPkg();
	
	public void setPkg(String pkg);

	public String getName();
	
	public void setName(String name);
	
}
