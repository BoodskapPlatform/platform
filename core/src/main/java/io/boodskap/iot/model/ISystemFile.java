package io.boodskap.iot.model;

import java.util.Date;

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
	
	public IFileContent createContent();
	
	public String getFileId();
	
	public void setFileId(String fileId);

	public String getDescription();

	public void setDescription(String description);

	@JsonIgnore
	public byte[] getData();

	public void setData(byte[] data);
	
	public Date getCreatedStamp();
	
	public void setCreatedStamp(Date createdStamp);

	public Date getUpdatedStamp();
	
	public void setUpdatedStamp(Date updatedStamp);
}
