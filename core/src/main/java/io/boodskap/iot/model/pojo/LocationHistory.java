package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.ILocationHistory;

public class LocationHistory extends Location  implements ILocationHistory {

	private static final long serialVersionUID = 1968767691318484921L;

	private String historyId;

	public LocationHistory() {
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((historyId == null) ? 0 : historyId.hashCode());
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
		LocationHistory other = (LocationHistory) obj;
		if (historyId == null) {
			if (other.historyId != null)
				return false;
		} else if (!historyId.equals(other.historyId))
			return false;
		return true;
	}

}
