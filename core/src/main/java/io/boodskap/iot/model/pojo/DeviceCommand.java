package io.boodskap.iot.model.pojo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import io.boodskap.iot.DeviceCommandTarget;
import io.boodskap.iot.model.IDeviceCommand;

public class DeviceCommand extends AbstractBaseCommand implements IDeviceCommand{

	private static final long serialVersionUID = 3952580324367681547L;
	
	private DeviceCommandTarget target;
	private boolean includeMe;
	private String deviceId;
	private Set<String> groups = new HashSet<>();
	
	public DeviceCommand() {
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
	public String getDeviceId() {
		return deviceId;
	}

	@Override
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public Collection<String> getGroups() {
		return groups;
	}

	@Override
	public void setGroups(Collection<String> groups) {
		this.groups.retainAll(groups);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + (includeMe ? 1231 : 1237);
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (groups == null) {
			if (other.groups != null)
				return false;
		} else if (!groups.equals(other.groups))
			return false;
		if (includeMe != other.includeMe)
			return false;
		if (target != other.target)
			return false;
		return true;
	}
	
}
