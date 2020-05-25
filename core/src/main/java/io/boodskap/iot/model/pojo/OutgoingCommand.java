package io.boodskap.iot.model.pojo;

import java.util.Arrays;
import java.util.Date;

import io.boodskap.iot.CommandStatus;
import io.boodskap.iot.CommandType;
import io.boodskap.iot.DataChannel;
import io.boodskap.iot.LoRaTarget;
import io.boodskap.iot.model.IOutgoingCommand;

public class OutgoingCommand extends AbstractDomainObject implements IOutgoingCommand {

	private static final long serialVersionUID = -1996151954437775661L;

	private String requestId;
	private String deviceId;
	private long corrId;
	private String nodeId;
	private String nodeUid;
	private String reportedIp;
	private int reportedPort;
	private int nackCode;
	private int mqttQos;
	private long loraBaseStationId;
	private long loraTransmitterId;
	private long loraReceiverId;
	private long loraTransceiverId;
	private long loraModemId;
	private Date queuedStamp;
	private Date sentStamp;
	private Date ackedStamp;
	private CommandStatus status;
	private CommandType type;
	private DataChannel channel;
	private LoRaTarget loraTarget;
	private byte[] data;
	
	public OutgoingCommand(){
	}

	@Override
	public String getRequestId() {
		return requestId;
	}

	@Override
	public void setRequestId(String requestId) {
		this.requestId = requestId;
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
	public long getCorrId() {
		return corrId;
	}

	@Override
	public void setCorrId(long corrId) {
		this.corrId = corrId;
	}

	@Override
	public int getMqttQos() {
		return mqttQos;
	}

	@Override
	public void setMqttQos(int mqttQos) {
		this.mqttQos = mqttQos;
	}

	@Override
	public Date getQueuedStamp() {
		return queuedStamp;
	}

	@Override
	public void setQueuedStamp(Date queuedStamp) {
		this.queuedStamp = queuedStamp;
	}

	@Override
	public Date getSentStamp() {
		return sentStamp;
	}

	@Override
	public void setSentStamp(Date sentStamp) {
		this.sentStamp = sentStamp;
	}

	@Override
	public Date getAckedStamp() {
		return ackedStamp;
	}

	@Override
	public void setAckedStamp(Date ackedStamp) {
		this.ackedStamp = ackedStamp;
	}

	@Override
	public CommandStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(CommandStatus status) {
		this.status = status;
	}

	@Override
	public CommandType getType() {
		return type;
	}

	@Override
	public void setType(CommandType type) {
		this.type = type;
	}

	@Override
	public byte[] getData() {
		return data;
	}

	@Override
	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public DataChannel getChannel() {
		return channel;
	}

	@Override
	public void setChannel(DataChannel channel) {
		this.channel = channel;
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
	public String getReportedIp() {
		return reportedIp;
	}

	@Override
	public void setReportedIp(String reportedIp) {
		this.reportedIp = reportedIp;
	}

	@Override
	public int getReportedPort() {
		return reportedPort;
	}

	@Override
	public void setReportedPort(int reportedPort) {
		this.reportedPort = reportedPort;
	}

	@Override
	public int getNackCode() {
		return nackCode;
	}

	@Override
	public void setNackCode(int nackCode) {
		this.nackCode = nackCode;
	}

	@Override
	public LoRaTarget getLoraTarget() {
		return loraTarget;
	}

	@Override
	public void setLoraTarget(LoRaTarget loraTarget) {
		this.loraTarget = loraTarget;
	}

	@Override
	public long getLoraBaseStationId() {
		return loraBaseStationId;
	}

	@Override
	public void setLoraBaseStationId(long loraBaseStationId) {
		this.loraBaseStationId = loraBaseStationId;
	}

	@Override
	public long getLoraTransmitterId() {
		return loraTransmitterId;
	}

	@Override
	public void setLoraTransmitterId(long loraTransmitterId) {
		this.loraTransmitterId = loraTransmitterId;
	}

	@Override
	public long getLoraReceiverId() {
		return loraReceiverId;
	}

	@Override
	public void setLoraReceiverId(long loraReceiverId) {
		this.loraReceiverId = loraReceiverId;
	}

	@Override
	public long getLoraTransceiverId() {
		return loraTransceiverId;
	}

	@Override
	public void setLoraTransceiverId(long loraTransceiverId) {
		this.loraTransceiverId = loraTransceiverId;
	}

	@Override
	public long getLoraModemId() {
		return loraModemId;
	}

	@Override
	public void setLoraModemId(long loraModemId) {
		this.loraModemId = loraModemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((ackedStamp == null) ? 0 : ackedStamp.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + (int) (corrId ^ (corrId >>> 32));
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
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
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
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
		if (corrId != other.corrId)
			return false;
		if (!Arrays.equals(data, other.data))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
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
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
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
