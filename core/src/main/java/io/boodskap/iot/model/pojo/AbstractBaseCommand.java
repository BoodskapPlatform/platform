package io.boodskap.iot.model.pojo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import io.boodskap.iot.CommandType;
import io.boodskap.iot.DeviceCommandTarget;
import io.boodskap.iot.model.IBaseCommand;

public abstract class AbstractBaseCommand extends AbstractDomainObject implements IBaseCommand {

	private static final long serialVersionUID = 7109627886383011250L;
	
	private long uid;
	private String jsonData;
	private int commandId = -1;
	private boolean includeMe;
	private byte[] data;
	private CommandType commandType;
	private DeviceCommandTarget target;
	private Set<String> models = new HashSet<>();
	private Set<String> versions = new HashSet<>();

	@Override
	public final long getUid() {
		return uid;
	}

	@Override
	public final void setUid(long uid) {
		this.uid = uid;
	}

	@Override
	public final CommandType getCommandType() {
		return commandType;
	}

	@Override
	public final void setCommandType(CommandType commandType) {
		this.commandType = commandType;
	}

	@Override
	public final Collection<String> getModels() {
		return models;
	}

	@Override
	public final void setModels(Collection<String> models) {
		this.models.retainAll(models);
	}

	@Override
	public final Collection<String> getVersions() {
		return versions;
	}

	@Override
	public final void setVersions(Collection<String> versions) {
		this.versions.retainAll(versions);
	}

	@Override
	public final int getCommandId() {
		return commandId;
	}

	@Override
	public final void setCommandId(int commandId) {
		this.commandId = commandId;
	}

	@Override
	public final byte[] getData() {
		return data;
	}

	@Override
	public final void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public final String getJsonData() {
		return jsonData;
	}

	@Override
	public final void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + commandId;
		result = prime * result + ((commandType == null) ? 0 : commandType.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + (includeMe ? 1231 : 1237);
		result = prime * result + ((jsonData == null) ? 0 : jsonData.hashCode());
		result = prime * result + ((models == null) ? 0 : models.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
		result = prime * result + (int) (uid ^ (uid >>> 32));
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
		AbstractBaseCommand other = (AbstractBaseCommand) obj;
		if (commandId != other.commandId)
			return false;
		if (commandType != other.commandType)
			return false;
		if (!Arrays.equals(data, other.data))
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
		if (versions == null) {
			if (other.versions != null)
				return false;
		} else if (!versions.equals(other.versions))
			return false;
		return true;
	}

}
