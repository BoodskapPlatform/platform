package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class OTADeviceBatchId extends OTABatchId {
	
	private static final long serialVersionUID = 1793377601760086407L;

	@Column(name="dummy")
	private Integer dummy;
	
	public OTADeviceBatchId() {
	}

	public OTADeviceBatchId(String domainKey, String batchId) {
		super(domainKey, batchId);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public Integer getDummy() {
		return dummy;
	}

	public void setDummy(Integer dummy) {
		this.dummy = dummy;
	}

}
