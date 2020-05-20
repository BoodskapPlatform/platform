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

public class ScheduledRuleAction implements Serializable{

	private static final long serialVersionUID = 6265813801064571284L;
	
	public static enum Action{
		ADD,
		REMOVE
	}
	
	private String domainKey;
	private long messageId;
	private Action action; //
	
	public ScheduledRuleAction() {
	}

	public ScheduledRuleAction(String domainKey, long messageId, Action action) {
		this.domainKey = domainKey;
		this.messageId = messageId;
		this.action = action;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public long getMessageId() {
		return messageId;
	}

	public Action getAction() {
		return action;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + (int) (messageId ^ (messageId >>> 32));
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
		ScheduledRuleAction other = (ScheduledRuleAction) obj;
		if (action != other.action)
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (messageId != other.messageId)
			return false;
		return true;
	}


}
