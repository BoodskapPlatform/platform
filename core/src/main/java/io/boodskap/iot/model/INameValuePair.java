package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=INameValuePair.class)
public interface INameValuePair extends IModel {

	public String getValue();
	
	public void setValue(String value);

	public default void save() {
		throw new UnsupportedOperationException();
	}
}
