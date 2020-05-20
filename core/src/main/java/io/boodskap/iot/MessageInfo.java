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
import java.util.UUID;

public class MessageInfo implements Serializable {

	private static final long serialVersionUID = 5564346327980002092L;
	
	private String domainKey;
	private long messageId;
	private UUID id;
	private long receivedStamp;
	private long processedStamp;
	
	public MessageInfo() {
	}

	public MessageInfo(String domainKey, long messageId, UUID id, long receivedStamp, long processedStamp) {
		this.domainKey = domainKey;
		this.messageId = messageId;
		this.id = id;
		this.receivedStamp = receivedStamp;
		this.processedStamp = processedStamp;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public long getReceivedStamp() {
		return receivedStamp;
	}

	public void setReceivedStamp(long receivedStamp) {
		this.receivedStamp = receivedStamp;
	}

	public long getProcessedStamp() {
		return processedStamp;
	}

	public void setProcessedStamp(long processedStamp) {
		this.processedStamp = processedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (messageId ^ (messageId >>> 32));
		result = prime * result + (int) (processedStamp ^ (processedStamp >>> 32));
		result = prime * result + (int) (receivedStamp ^ (receivedStamp >>> 32));
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
		MessageInfo other = (MessageInfo) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (messageId != other.messageId)
			return false;
		if (processedStamp != other.processedStamp)
			return false;
		if (receivedStamp != other.receivedStamp)
			return false;
		return true;
	}

}
