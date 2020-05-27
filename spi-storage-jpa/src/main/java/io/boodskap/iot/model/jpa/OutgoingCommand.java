package io.boodskap.iot.model.jpa;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.CommandStatus;
import io.boodskap.iot.CommandType;
import io.boodskap.iot.DataChannel;
import io.boodskap.iot.LoRaTarget;
import io.boodskap.iot.model.IOutgoingCommand;

@Entity
@Table(name="outgoingcommand")
public class OutgoingCommand extends AbstractModel implements IOutgoingCommand {

	private static final long serialVersionUID = -1996151954437775661L;

	@EmbeddedId
	private OutgoingCommandId id = new OutgoingCommandId();

	@Column(name="nodeid", length=40)
	private String nodeId;

	@Column(name="nodeuid", length=40)
	private String nodeUid;

	@Column(name="reportedip", length=20)
	private String reportedIp;

	@Column(name="reportedport")
	private int reportedPort;

	@Column(name="nackcode")
	private int nackCode;

	@Column(name="mqttqos")
	private int mqttQos;

	@Column(name="lorabsid")
	private long loraBaseStationId;

	@Column(name="loratrid")
	private long loraTransmitterId;

	@Column(name="lorarcvid")
	private long loraReceiverId;

	@Column(name="loratrcvid")
	private long loraTransceiverId;

	@Column(name="loramdmid")
	private long loraModemId;

	@Column(name="queuedstamp")
	private Date queuedStamp;

	@Column(name="sentstamp")
	private Date sentStamp;

	@Column(name="ackedstamp")
	private Date ackedStamp;

	@Enumerated(EnumType.STRING)
	@Column(name="status", length=15)
	private CommandStatus status;

	@Column(name="type", length=15)
	private CommandType type;

	@Enumerated(EnumType.STRING)
	@Column(name="channel", length=10)
	private DataChannel channel;

	@Enumerated(EnumType.STRING)
	@Column(name="loratarget", length=12)
	private LoRaTarget loraTarget;

	@Lob
	@Column(name="data", length=4096)
	private byte[] data;
	
	public OutgoingCommand(){
	}

	public OutgoingCommand(OutgoingCommandId id){
		this.id = id;
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

	public String getDeviceId() {
		return id.getDeviceId();
	}

	public void setDeviceId(String deviceId) {
		id.setDeviceId(deviceId);
	}

	public long getCorrId() {
		return id.getCorrId();
	}

	public void setCorrId(long corrId) {
		id.setCorrId(corrId);
	}

	public Date getQueuedStamp() {
		return queuedStamp;
	}

	public void setQueuedStamp(Date queuedStamp) {
		this.queuedStamp = queuedStamp;
	}

	public Date getSentStamp() {
		return sentStamp;
	}

	public void setSentStamp(Date sentStamp) {
		this.sentStamp = sentStamp;
	}

	public Date getAckedStamp() {
		return ackedStamp;
	}

	public int getMqttQos() {
		return mqttQos;
	}

	public void setMqttQos(int mqttQos) {
		this.mqttQos = mqttQos;
	}

	public void setAckedStamp(Date ackedStamp) {
		this.ackedStamp = ackedStamp;
	}

	public CommandStatus getStatus() {
		return status;
	}

	public void setStatus(CommandStatus status) {
		this.status = status;
	}

	public CommandType getType() {
		return type;
	}

	public void setType(CommandType type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public DataChannel getChannel() {
		return channel;
	}

	public void setChannel(DataChannel channel) {
		this.channel = channel;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeUid() {
		return nodeUid;
	}

	public void setNodeUid(String nodeUid) {
		this.nodeUid = nodeUid;
	}

	public String getReportedIp() {
		return reportedIp;
	}

	public void setReportedIp(String reportedIp) {
		this.reportedIp = reportedIp;
	}

	public int getReportedPort() {
		return reportedPort;
	}

	public void setReportedPort(int reportedPort) {
		this.reportedPort = reportedPort;
	}

	public int getNackCode() {
		return nackCode;
	}

	public void setNackCode(int nackCode) {
		this.nackCode = nackCode;
	}

	public LoRaTarget getLoraTarget() {
		return loraTarget;
	}

	public void setLoraTarget(LoRaTarget loraTarget) {
		this.loraTarget = loraTarget;
	}

	public long getLoraBaseStationId() {
		return loraBaseStationId;
	}

	public void setLoraBaseStationId(long loraBaseStationId) {
		this.loraBaseStationId = loraBaseStationId;
	}

	public long getLoraTransmitterId() {
		return loraTransmitterId;
	}

	public void setLoraTransmitterId(long loraTransmitterId) {
		this.loraTransmitterId = loraTransmitterId;
	}

	public long getLoraReceiverId() {
		return loraReceiverId;
	}

	public void setLoraReceiverId(long loraReceiverId) {
		this.loraReceiverId = loraReceiverId;
	}

	public long getLoraTransceiverId() {
		return loraTransceiverId;
	}

	public void setLoraTransceiverId(long loraTransceiverId) {
		this.loraTransceiverId = loraTransceiverId;
	}

	public long getLoraModemId() {
		return loraModemId;
	}

	public void setLoraModemId(long loraModemId) {
		this.loraModemId = loraModemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ackedStamp == null) ? 0 : ackedStamp.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (loraBaseStationId ^ (loraBaseStationId >>> 32));
		result = prime * result + (int) (loraModemId ^ (loraModemId >>> 32));
		result = prime * result + (int) (loraReceiverId ^ (loraReceiverId >>> 32));
		result = prime * result + ((loraTarget == null) ? 0 : loraTarget.hashCode());
		result = prime * result + (int) (loraTransceiverId ^ (loraTransceiverId >>> 32));
		result = prime * result + (int) (loraTransmitterId ^ (loraTransmitterId >>> 32));
		result = prime * result + mqttQos;
		result = prime * result + nackCode;
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((nodeUid == null) ? 0 : nodeUid.hashCode());
		result = prime * result + ((queuedStamp == null) ? 0 : queuedStamp.hashCode());
		result = prime * result + ((reportedIp == null) ? 0 : reportedIp.hashCode());
		result = prime * result + reportedPort;
		result = prime * result + ((sentStamp == null) ? 0 : sentStamp.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		OutgoingCommand other = (OutgoingCommand) obj;
		if (ackedStamp == null) {
			if (other.ackedStamp != null)
				return false;
		} else if (!ackedStamp.equals(other.ackedStamp))
			return false;
		if (channel != other.channel)
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loraBaseStationId != other.loraBaseStationId)
			return false;
		if (loraModemId != other.loraModemId)
			return false;
		if (loraReceiverId != other.loraReceiverId)
			return false;
		if (loraTarget != other.loraTarget)
			return false;
		if (loraTransceiverId != other.loraTransceiverId)
			return false;
		if (loraTransmitterId != other.loraTransmitterId)
			return false;
		if (mqttQos != other.mqttQos)
			return false;
		if (nackCode != other.nackCode)
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
		if (queuedStamp == null) {
			if (other.queuedStamp != null)
				return false;
		} else if (!queuedStamp.equals(other.queuedStamp))
			return false;
		if (reportedIp == null) {
			if (other.reportedIp != null)
				return false;
		} else if (!reportedIp.equals(other.reportedIp))
			return false;
		if (reportedPort != other.reportedPort)
			return false;
		if (sentStamp == null) {
			if (other.sentStamp != null)
				return false;
		} else if (!sentStamp.equals(other.sentStamp))
			return false;
		if (status != other.status)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
