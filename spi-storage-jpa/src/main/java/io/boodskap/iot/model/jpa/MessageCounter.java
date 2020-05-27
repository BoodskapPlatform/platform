package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.boodskap.iot.model.IMessageCounter;

@Entity()
@Table(name="messagecounter")
public class MessageCounter extends AbstractStorageObject implements IMessageCounter {
	
	private static final long serialVersionUID = -5795353107563657636L;
	
	@Id
	@Column(name="id")
	private Date id;
	
	@Column(name="total")
	private long count;

	@Override
	public Date getId() {
		return id;
	}

	@Override
	public void setId(Date id) {
		this.id = id;
	}

	@Override
	public long getCount() {
		return count;
	}

	@Override
	public void setCount(long count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (count ^ (count >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		MessageCounter other = (MessageCounter) obj;
		if (count != other.count)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
