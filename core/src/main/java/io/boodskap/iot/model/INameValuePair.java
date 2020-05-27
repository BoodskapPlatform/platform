package io.boodskap.iot.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=INameValuePair.class)
public interface INameValuePair extends Serializable {
	
	public String getName();
	
	public void setName(String name);

	public String getValue();
	
	public void setValue(String value);

}
