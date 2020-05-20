package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.boodskap.iot.model.INameValuePair;

@Entity
@Table(name = "receivedcommandnvp")
public class ReceivedCommandNVP implements INameValuePair{

	private static final long serialVersionUID = -1047376067317054677L;

	@EmbeddedId
	private ReceivedCommandNVPId id = new ReceivedCommandNVPId();
	
	@Column(name="value", length=255)
	private String value;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private ReceivedCommand parent;

	public ReceivedCommandNVP() {
	}

	public ReceivedCommandNVP(ReceivedCommand parent, ReceivedCommandNVPId id, String value) {
		this.id = id;
		this.parent = parent;
		this.value = value;
	}

	public ReceivedCommand getParent() {
		return parent;
	}

	public void setParent(ReceivedCommand parent) {
		this.parent = parent;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getRequestId() {
		return id.getRequestId();
	}

	public void setRequestId(String requestId) {
		id.setRequestId(requestId);
	}

	public String getName() {
		return id.getName();
	}

	public void setName(String name) {
		id.setName(name);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
