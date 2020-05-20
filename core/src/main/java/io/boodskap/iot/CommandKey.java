/*******************************************************************************
 * Copyright (C) 2019 Boodskap Inc
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package io.boodskap.iot;

import java.io.Serializable;

public class CommandKey implements Serializable {

	private static final long serialVersionUID = -5057747181584030257L;
	
	private final String domainKey;
	private final String deviceId;
	private final long correlationId;
	
	public CommandKey(String domainKey, String deviceId, long correlationId) {
		this.domainKey = domainKey;
		this.deviceId = deviceId;
		this.correlationId = correlationId;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public long getCorrelationId() {
		return correlationId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (correlationId ^ (correlationId >>> 32));
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		CommandKey other = (CommandKey) obj;
		if (correlationId != other.correlationId)
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
		return true;
	}

	@Override
	public String toString() {
		return "CommandKey [domainKey=" + domainKey + ", deviceId=" + deviceId + ", correlationId=" + correlationId
				+ "]";
	}

}
