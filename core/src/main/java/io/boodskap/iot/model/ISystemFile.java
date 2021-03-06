package io.boodskap.iot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.SystemFileDAO;

@JsonSerialize(as=ISystemFile.class)
public interface ISystemFile extends IModel{

	public static ISystemFile create(String fileId) {
		return SystemFileDAO.get().create(fileId);
	}
	
	public static ISystemFile find(String fileId) {
		return SystemFileDAO.get().get(fileId);
	}
	
	public default void save() {
		SystemFileDAO.get().createOrUpdate(this);
	}
	
	@Override
	public default void copy(Object other) {
		
		ISystemFile o = (ISystemFile) other;
		
		setFileId(o.getFileId());
		setMediaType(o.getMediaType());
		setData(o.getData());
		setTags(o.getTags());
		
		IModel.super.copy(other);
	}

	public IFileContent createContent();
	
	public String getFileId();
	
	public void setFileId(String fileId);

	public String getMediaType();

	public void setMediaType(String mediaType);

	@JsonIgnore
	public byte[] getData();

	public void setData(byte[] data);

	public String getTags();

	public void setTags(String tags);

}
