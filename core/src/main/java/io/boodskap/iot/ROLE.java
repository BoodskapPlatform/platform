package io.boodskap.iot;

public enum ROLE{
	
	USER("user"),
	ORGUSER("orguser"),
	DEVICE("device"),
	;
	
	private ROLE(String id) {
		this.id = id;
	}
	
	private String id;
	
	public String id() {
		return id;
	}
}