package io.boodskap.iot.model;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.ReceivedCommandDAO;

@JsonSerialize(as=IReceivedCommand.class)
public interface IReceivedCommand extends IStorageObject {

	public static enum EncodingFormat {
		BASE64, HEX, TEXT
	}

	public static enum Status {
		QUEUED, PROCESSING, PROCESSED, FAILED
	}

	public static enum CommandType {
		COMMAND, RAW_COMMAND, BROADCAST_COMMAND, BROADCAST_RAW_COMMAND, GROUP_COMMAND, GROUP_RAW_COMMAND, GROUP_BROADCAST_COMMAND, TEMPLATE_COMMAND, TEMPLATE_BROADCAST_COMMAND, GROUP_TEMPLATE_COMMAND, GROUP_TEMPLATE_BROADCAST_COMMAND
	}
	
	public static ReceivedCommandDAO<IReceivedCommand> dao() {
		return ReceivedCommandDAO.get();
	}
	
	public static Class<? extends IReceivedCommand> clazz() {
		return dao().clazz();
	}
	
	public static Class<? extends INameValuePair> nvPairClazz() {
		return dao().nvPairClazz();
	}
	
	public static IReceivedCommand create(String domainKey, String requestId) {
		return dao().create(domainKey, requestId);
	}
	
	public static IReceivedCommand find(String domainKey, String requestId) {
		return dao().get(domainKey, requestId);
	}
	
	public default void save() {
		IReceivedCommand.dao().createOrUpdate(this);
	}
	
	public INameValuePair createPair(String name, String value);

	public String getRequestId();

	public void setRequestId(String requestId);

	public Collection<String> getDeviceIds();

	public void setDeviceIds(Collection<String> deviceIds);

	public Collection<? extends INameValuePair> getData();

	public void setData(Collection<? extends INameValuePair> data);

	public String getRawData();

	public void setRawData(String rawData);

	public EncodingFormat getEncodingFormat();

	public void setEncodingFormat(EncodingFormat encodingFormat);

	public Integer getCommandId();

	public void setCommandId(Integer commandId);

	public String getDeviceId();

	public void setDeviceId(String deviceId);

	public String getGroupId();

	public void setGroupId(String groupId);

	public String getTemplateId();

	public void setTemplateId(String templateId);

	public Boolean getSystem();

	public void setSystem(Boolean system);

	public Collection<? extends INameValuePair> getMergeContent();

	public void setMergeContent(Collection<? extends INameValuePair> mergeContent);

	public String getDeviceModel();

	public void setDeviceModel(String deviceModel);

	public String getDeviceVersion();

	public void setDeviceVersion(String deviceVersion);

	public Integer getTotalCount();

	public void setTotalCount(Integer totalCount);

	public Integer getSentCount();

	public void setSentCount(Integer sentCount);

	public Integer getFailedCount();

	public void setFailedCount(Integer failedCount);

	public Date getQueuedStamp();

	public void setQueuedStamp(Date queuedStamp);

	public Date getCompletedStamp();

	public void setCompletedStamp(Date completedStamp);

	public Status getStatus();

	public void setStatus(Status status);

	public CommandType getCommandType();

	public void setCommandType(CommandType commandType);

}
