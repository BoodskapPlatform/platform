package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IGlobalData;

@Entity
@Table(name="globaldata")
public class GlobalData extends AbstractModel implements IGlobalData {

	private static final long serialVersionUID = -8422610382451734700L;
	
	@EmbeddedId
	private GlobalDataId id = new GlobalDataId();
	
	@Column(name="data", length=SizeConstants.GLOABL_DATA_SIZE)
	private String data;
	
	public GlobalData() {
	}

	public GlobalData(GlobalDataId id) {
		this.id = id;
	}

	public String getDataId() {
		return id.getDataId();
	}

	public void setDataId(String dataId) {
		id.setDataId(dataId);
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		GlobalData other = (GlobalData) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
