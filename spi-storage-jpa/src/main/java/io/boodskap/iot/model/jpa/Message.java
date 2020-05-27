package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.boodskap.iot.DataChannel;
import io.boodskap.iot.model.IDynamicMessageField;
import io.boodskap.iot.model.IMessage;

@Entity()
@Table(name="message")
public class Message extends AbstractModel implements IMessage {
	
	private static final long serialVersionUID = -1928207596119374413L;

	@EmbeddedId
	private MessageId id = new MessageId();
	
	@Column(name="createdstamp")
	private Date createdStamp = new Date();
	
	@Column(name="datachannel", length=12)
	private DataChannel dataChannel;

	@Column(name="port")
	private Integer port;

	@Column(name="ipaddress", length=20)
	private String ipAddress;

	@Column(name="nodeuid", length=40)
	private String nodeUid;

	@Column(name="nodeid", length=40)
	private String nodeId;

	@Column(name="deviceId", length=40)
	private String deviceId;

	@Column(name="fwmodel", length=40)
	private String deviceModel;
	
	@Column(name="fwver", length=40)
	private String firmwareVersion;
	
	@Enumerated(EnumType.STRING)
	@Column(name="state", length=15)
	private State state = State.PROCESSING;
	
	@Column(name="trace", length=2048)
	private String trace;
	
	@OneToMany(
			targetEntity=DynamicMessageField.class,
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	 )
	 private List<DynamicMessageField> fields = new ArrayList<>();

	public Message() {
	}

	public Message(MessageId id) {
		this.id = id;
	}

	@Override
	public IDynamicMessageField createField(String name) {
		DynamicMessageField field = new DynamicMessageField(new DynamicMessageFieldId(id.getDomainKey(), id.getSpecId(), id.getMessageId(), name));
		return field;
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getMessageId() {
		return this.id.getMessageId();
	}

	@Override
	public void setMessageId(String messageId) {
		id.setMessageId(messageId);
	}

	@Override
	public String getSpecId() {
		return id.getSpecId();
	}

	@Override
	public void setSpecId(String specId) {
		id.setSpecId(specId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<DynamicMessageField> getFields() {
		return fields;
	}

	@Override
	public void setFields(Collection<? extends IDynamicMessageField> data) {
		this.fields.clear();
		data.forEach(d ->{
			DynamicMessageField f = (DynamicMessageField)d;
			this.fields.add(f);
		});
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
	public String getDeviceModel() {
		return deviceModel;
	}

	@Override
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	@Override
	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	@Override
	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	@Override
	public String getNodeId() {
		return nodeId;
	}

	@Override
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	@Override
	public String getNodeUid() {
		return nodeUid;
	}

	@Override
	public void setNodeUid(String nodeUid) {
		this.nodeUid = nodeUid;
	}

	@Override
	public String getIpAddress() {
		return ipAddress;
	}

	@Override
	public void setIpAddress(String ipAddress) {
		this.ipAddress  = ipAddress;
	}

	@Override
	public Integer getPort() {
		return this.port;
	}

	@Override
	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public DataChannel getDataChannel() {
		return dataChannel;
	}

	@Override
	public void setDataChannel(DataChannel dataChannel) {
		this.dataChannel = dataChannel;
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String getTrace() {
		return trace;
	}

	@Override
	public void setTrace(String trace) {
		this.trace = trace;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((dataChannel == null) ? 0 : dataChannel.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((deviceModel == null) ? 0 : deviceModel.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((firmwareVersion == null) ? 0 : firmwareVersion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((nodeUid == null) ? 0 : nodeUid.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((trace == null) ? 0 : trace.hashCode());
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
		Message other = (Message) obj;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (dataChannel != other.dataChannel)
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (deviceModel == null) {
			if (other.deviceModel != null)
				return false;
		} else if (!deviceModel.equals(other.deviceModel))
			return false;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (firmwareVersion == null) {
			if (other.firmwareVersion != null)
				return false;
		} else if (!firmwareVersion.equals(other.firmwareVersion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (nodeId == null) {
			if (other.nodeId != null)
				return false;
		} else if (!nodeId.equals(other.nodeId))
			return false;
		if (nodeUid == null) {
			if (other.nodeUid != null)
				return false;
		} else if (!nodeUid.equals(other.nodeUid))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (state != other.state)
			return false;
		if (trace == null) {
			if (other.trace != null)
				return false;
		} else if (!trace.equals(other.trace))
			return false;
		return true;
	}

}
