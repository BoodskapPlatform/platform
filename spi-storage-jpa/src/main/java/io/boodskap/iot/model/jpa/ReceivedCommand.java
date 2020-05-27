package io.boodskap.iot.model.jpa;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.boodskap.iot.model.INameValuePair;
import io.boodskap.iot.model.IReceivedCommand;

@Entity
@Table(name = "receivedcommand")
public class ReceivedCommand extends AbstractStorable implements IReceivedCommand {

	private static final long serialVersionUID = -1687434685919726866L;

	@EmbeddedId
	private ReceivedCommandId id = new ReceivedCommandId();

	@Lob
	@Column(name="rawdata", length=4096)
	private String rawData;
	
	@Column(name="commandid")
	private Integer commandId;
	
	@Column(name="deviceid", length=40)
	private String deviceId;
	
	@Column(name="groupid", length=40)
	private String groupId;
	
	@Column(name="templateid", length=40)
	private String templateId;

	@Column(name="systemplate")
	private Boolean system;

	@Column(name="devicemodel", length=40)
	private String deviceModel;

	@Column(name="deviceversion", length=40)
	private String deviceVersion;

	@Column(name="totalcount")
	private Integer totalCount;

	@Column(name="sentcount")
	private Integer sentCount;

	@Column(name="failedcount")
	private Integer failedCount;

	@Column(name="queuedstamp")
	private Date queuedStamp;

	@Column(name="completedstamp")
	private Date completedStamp;

	@Column(name="encodingformat", length = 8)
	@Enumerated(EnumType.STRING)
	private EncodingFormat encodingFormat;

	@Column(name="status", length = 12)
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name="commandtype", length = 30)
	@Enumerated(EnumType.STRING)
	private CommandType commandType;

	@ElementCollection(targetClass=String.class)
	@Column(name="deviceids")
	private Set<String> deviceIds = new HashSet<>();

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ReceivedCommandNVP> data = new HashSet<>();
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ReceivedCommandNVP> mergeContent = new HashSet<>();

	public ReceivedCommand() {
	}

	public ReceivedCommand(ReceivedCommandId id) {
		this.id = id;
	}

	@Override
	public INameValuePair createPair(String name, String value) {
		return new ReceivedCommandNVP(this, new ReceivedCommandNVPId(getDomainKey(), getRequestId(), name), value);
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getRequestId() {
		return id.getRequestId();
	}

	public void setRequestId(String requestId) {
		id.setRequestId(requestId);
	}

	public String getRawData() {
		return rawData;
	}

	public void setRawData(String rawData) {
		this.rawData = rawData;
	}

	public Integer getCommandId() {
		return commandId;
	}

	public void setCommandId(Integer commandId) {
		this.commandId = commandId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public Boolean getSystem() {
		return system;
	}

	public void setSystem(Boolean system) {
		this.system = system;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getSentCount() {
		return sentCount;
	}

	public void setSentCount(Integer sentCount) {
		this.sentCount = sentCount;
	}

	public Integer getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(Integer failedCount) {
		this.failedCount = failedCount;
	}

	public Date getQueuedStamp() {
		return queuedStamp;
	}

	public void setQueuedStamp(Date queuedStamp) {
		this.queuedStamp = queuedStamp;
	}

	public Date getCompletedStamp() {
		return completedStamp;
	}

	public void setCompletedStamp(Date completedStamp) {
		this.completedStamp = completedStamp;
	}

	public EncodingFormat getEncodingFormat() {
		return encodingFormat;
	}

	public void setEncodingFormat(EncodingFormat encodingFormat) {
		this.encodingFormat = encodingFormat;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public CommandType getCommandType() {
		return commandType;
	}

	public void setCommandType(CommandType commandType) {
		this.commandType = commandType;
	}

	public Collection<String> getDeviceIds() {
		return deviceIds;
	}

	public void setDeviceIds(Collection<String> deviceIds) {
		this.deviceIds.clear();
		this.deviceIds.addAll(deviceIds);
	}

	public Collection<ReceivedCommandNVP> getData() {
		return data;
	}

	public void setData(Collection<? extends INameValuePair> data) {
		this.data.clear();
		data.forEach(e -> {
			this.data.add((ReceivedCommandNVP) e);
		});
	}

	public Collection<ReceivedCommandNVP> getMergeContent() {
		return mergeContent;
	}

	public void setMergeContent(Collection<? extends INameValuePair> mergeContent) {
		this.mergeContent.clear();
		mergeContent.forEach(e -> {
			this.mergeContent.add((ReceivedCommandNVP) e);
		});
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((commandId == null) ? 0 : commandId.hashCode());
		result = prime * result + ((commandType == null) ? 0 : commandType.hashCode());
		result = prime * result + ((completedStamp == null) ? 0 : completedStamp.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((deviceIds == null) ? 0 : deviceIds.hashCode());
		result = prime * result + ((deviceModel == null) ? 0 : deviceModel.hashCode());
		result = prime * result + ((deviceVersion == null) ? 0 : deviceVersion.hashCode());
		result = prime * result + ((encodingFormat == null) ? 0 : encodingFormat.hashCode());
		result = prime * result + ((failedCount == null) ? 0 : failedCount.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mergeContent == null) ? 0 : mergeContent.hashCode());
		result = prime * result + ((queuedStamp == null) ? 0 : queuedStamp.hashCode());
		result = prime * result + ((rawData == null) ? 0 : rawData.hashCode());
		result = prime * result + ((sentCount == null) ? 0 : sentCount.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((system == null) ? 0 : system.hashCode());
		result = prime * result + ((templateId == null) ? 0 : templateId.hashCode());
		result = prime * result + ((totalCount == null) ? 0 : totalCount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceivedCommand other = (ReceivedCommand) obj;
		if (commandId == null) {
			if (other.commandId != null)
				return false;
		} else if (!commandId.equals(other.commandId))
			return false;
		if (commandType != other.commandType)
			return false;
		if (completedStamp == null) {
			if (other.completedStamp != null)
				return false;
		} else if (!completedStamp.equals(other.completedStamp))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (deviceIds == null) {
			if (other.deviceIds != null)
				return false;
		} else if (!deviceIds.equals(other.deviceIds))
			return false;
		if (deviceModel == null) {
			if (other.deviceModel != null)
				return false;
		} else if (!deviceModel.equals(other.deviceModel))
			return false;
		if (deviceVersion == null) {
			if (other.deviceVersion != null)
				return false;
		} else if (!deviceVersion.equals(other.deviceVersion))
			return false;
		if (encodingFormat != other.encodingFormat)
			return false;
		if (failedCount == null) {
			if (other.failedCount != null)
				return false;
		} else if (!failedCount.equals(other.failedCount))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mergeContent == null) {
			if (other.mergeContent != null)
				return false;
		} else if (!mergeContent.equals(other.mergeContent))
			return false;
		if (queuedStamp == null) {
			if (other.queuedStamp != null)
				return false;
		} else if (!queuedStamp.equals(other.queuedStamp))
			return false;
		if (rawData == null) {
			if (other.rawData != null)
				return false;
		} else if (!rawData.equals(other.rawData))
			return false;
		if (sentCount == null) {
			if (other.sentCount != null)
				return false;
		} else if (!sentCount.equals(other.sentCount))
			return false;
		if (status != other.status)
			return false;
		if (system == null) {
			if (other.system != null)
				return false;
		} else if (!system.equals(other.system))
			return false;
		if (templateId == null) {
			if (other.templateId != null)
				return false;
		} else if (!templateId.equals(other.templateId))
			return false;
		if (totalCount == null) {
			if (other.totalCount != null)
				return false;
		} else if (!totalCount.equals(other.totalCount))
			return false;
		return true;
	}

}
