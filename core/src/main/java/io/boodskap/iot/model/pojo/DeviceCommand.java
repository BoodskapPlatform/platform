package io.boodskap.iot.model.pojo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import io.boodskap.iot.CommandType;
import io.boodskap.iot.DeviceCommandTarget;
import io.boodskap.iot.model.IDeviceCommand;

public class DeviceCommand implements IDeviceCommand{

	private static final long serialVersionUID = -1976353918687344385L;

	private String domainKey;
	private String deviceId;
	private long uid;
	private String jsonData;
	private int commandId = -1;
	private boolean includeMe;
	private byte[] data;
	private Date createdStamp;
	private Date updatedStamp;
	private CommandType commandType;
	private DeviceCommandTarget target;
	private Set<String> models = new HashSet<>();
	private Set<String> versions = new HashSet<>();
	private Set<String> groups = new HashSet<>();
	
	public DeviceCommand() {
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public DeviceCommandTarget getTarget() {
		return target;
	}

	public void setTarget(DeviceCommandTarget target) {
		this.target = target;
	}

	public boolean isIncludeMe() {
		return includeMe;
	}

	public void setIncludeMe(boolean includeMe) {
		this.includeMe = includeMe;
	}

	@Override
	public Collection<String> getGroups() {
		return groups;
	}

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public CommandType getCommandType() {
		return commandType;
	}

	public void setCommandType(CommandType commandType) {
		this.commandType = commandType;
	}

	@Override
	public Set<String> getModels() {
		return models;
	}

	@Override
	public Set<String> getVersions() {
		return versions;
	}

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	@Override
	public void setModels(Collection<String> models) {
		this.models.clear();
		this.models.addAll(models);
	}

	@Override
	public void setVersions(Collection<String> versions) {
		this.versions.clear();
		this.versions.addAll(versions);
	}

	@Override
	public void setGroups(Collection<String> groups) {
		this.groups.clear();
		this.groups.addAll(groups);
	}

	@Override
	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	@Override
	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commandId;
		result = prime * result + ((commandType == null) ? 0 : commandType.hashCode());
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + (includeMe ? 1231 : 1237);
		result = prime * result + ((jsonData == null) ? 0 : jsonData.hashCode());
		result = prime * result + ((models == null) ? 0 : models.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + (int) (uid ^ (uid >>> 32));
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
		result = prime * result + ((versions == null) ? 0 : versions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceCommand other = (DeviceCommand) obj;
		if (commandId != other.commandId)
			return false;
		if (commandType != other.commandType)
			return false;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (includeMe != other.includeMe)
			return false;
		if (jsonData == null) {
			if (other.jsonData != null)
				return false;
		} else if (!jsonData.equals(other.jsonData))
			return false;
		if (models == null) {
			if (other.models != null)
				return false;
		} else if (!models.equals(other.models))
			return false;
		if (target != other.target)
			return false;
		if (uid != other.uid)
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		if (versions == null) {
			if (other.versions != null)
				return false;
		} else if (!versions.equals(other.versions))
			return false;
		return true;
	}

}
