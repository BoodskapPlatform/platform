package io.boodskap.iot.model.jpa;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import io.boodskap.iot.CommandType;
import io.boodskap.iot.DeviceCommandTarget;
import io.boodskap.iot.model.IDeviceCommand;

@Entity
@Table(name="devicecommand")
public class DeviceCommand extends AbstractModel implements IDeviceCommand{

	private static final long serialVersionUID = -1976353918687344385L;

	@EmbeddedId
	private DeviceCommandId id = new DeviceCommandId();

	@Column(name="jsondata", length=1024)
	private String jsonData;

	@Column(name="commandid")
	private int commandId = -1;

	@Column(name="includeme")
	private boolean includeMe;

	@Column(name="data", length=1024)
	private byte[] data;

	@Column(name="commandtype", length=12)
	@Enumerated(EnumType.STRING)
	private CommandType commandType;

	@Column(name="target", length=12)
	@Enumerated(EnumType.STRING)
	private DeviceCommandTarget target;

	@ElementCollection(targetClass=String.class)
	@Column(name="models", length=40)
	private Set<String> models = new HashSet<>();

	@ElementCollection(targetClass=String.class)
	@Column(name="versions", length=40)
	private Set<String> versions = new HashSet<>();

	@ElementCollection(targetClass=String.class)
	@Column(name="groups", length=40)
	private Set<String> groups = new HashSet<>();
	
	public DeviceCommand() {
	}

	public DeviceCommand(DeviceCommandId id) {
		this.id = id;
	}

	@Override
	public DeviceCommandTarget getTarget() {
		return target;
	}

	@Override
	public void setTarget(DeviceCommandTarget target) {
		this.target = target;
	}

	@Override
	public boolean isIncludeMe() {
		return includeMe;
	}

	@Override
	public void setIncludeMe(boolean includeMe) {
		this.includeMe = includeMe;
	}

	@Override
	public Collection<String> getGroups() {
		return groups;
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getDeviceId() {
		return id.getDeviceId();
	}

	@Override
	public void setDeviceId(String deviceId) {
		id.setDeviceId(deviceId);
	}

	@Override
	public long getUid() {
		return id.getUid();
	}

	@Override
	public void setUid(long uid) {
		id.setUid(uid);
	}

	@Override
	public CommandType getCommandType() {
		return commandType;
	}

	@Override
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

	@Override
	public int getCommandId() {
		return commandId;
	}

	@Override
	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	@Override
	public byte[] getData() {
		return data;
	}

	@Override
	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String getJsonData() {
		return jsonData;
	}

	@Override
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + commandId;
		result = prime * result + ((commandType == null) ? 0 : commandType.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (includeMe ? 1231 : 1237);
		result = prime * result + ((jsonData == null) ? 0 : jsonData.hashCode());
		result = prime * result + ((models == null) ? 0 : models.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + ((versions == null) ? 0 : versions.hashCode());
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
		DeviceCommand other = (DeviceCommand) obj;
		if (commandId != other.commandId)
			return false;
		if (commandType != other.commandType)
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (versions == null) {
			if (other.versions != null)
				return false;
		} else if (!versions.equals(other.versions))
			return false;
		return true;
	}

}
