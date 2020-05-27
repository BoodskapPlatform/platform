package io.boodskap.iot.model.jpa;

import java.util.Arrays;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.DataChannel;
import io.boodskap.iot.RawDataType;
import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.model.IRawData;

@Entity
@Table(name="rawdata", indexes= {@Index(columnList = "domainKey"), @Index(columnList = "receivedStamp")})
public class RawData extends AbstractStorageObject implements IRawData {

	private static final long serialVersionUID = 8770058772346142631L;
	
	@Id
	@Column(name="id", length=40)
	private String id = UUID.randomUUID().toString();
	
	@Column(name="domainkey", length=16)
	private String domainKey;
	
	@Column(name="deviceid", length=40)
	private String deviceId;
	
	@Column(name="nodeid", length=40)
	private String nodeId;
	
	@Column(name="nodeuid", length=40)
	private String nodeUid;
	
	@Column(name="mqtttopic", length=255)
	private String mqttTopic;
	
	@Column(name="mqttserverid", length=40)
	private String mqttServerId;
	
	@Column(name="fwmodel", length=40)
	private String deviceModel;
	
	@Column(name="fwver", length=40)
	private String firmwareVersion;
	
	@Column(name="type", length=40)
	private String type;
	
	@Column(name="properties", length=40)
	private String properties;
	
	@Column(name="contenttype", length=40)
	private String contentType;
	
	@Column(name="filename", length=80)
	private String fileName;

	@Column(name="ipaddress", length=20)
	private String ipAddress;
	
	@Column(name="bintype", length=40)
	private String binaryType;

	@Column(name="port")
	private Integer port;
	
	@Column(name="size")
	private int size;
	
	@Enumerated(EnumType.STRING)
	@Column(name="channel", length=8)
    private DataChannel channel;
	
	@Enumerated(EnumType.STRING)
	@Column(name="rawdatatype", length=15)
	private RawDataType rawDataType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="state", length=15)
	private State state = State.QUEUED;
	
	@Lob
	@Column(name="data", length=SizeConstants.RAW_DATA_SIZE)
	private byte[] data;

	public RawData() {
	}

	public RawData(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMqttServerId() {
		return mqttServerId;
	}

	public void setMqttServerId(String mqttServerId) {
		this.mqttServerId = mqttServerId;
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

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public DataChannel getChannel() {
		return channel;
	}

	public void setChannel(DataChannel channel) {
		this.channel = channel;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getMqttTopic() {
		return mqttTopic;
	}

	public void setMqttTopic(String mqttTopic) {
		this.mqttTopic = mqttTopic;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public RawDataType getRawDataType() {
		return rawDataType;
	}

	public void setRawDataType(RawDataType rawDataType) {
		this.rawDataType = rawDataType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getBinaryType() {
		return binaryType;
	}

	public void setBinaryType(String binaryType) {
		this.binaryType = binaryType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((binaryType == null) ? 0 : binaryType.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((deviceModel == null) ? 0 : deviceModel.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((firmwareVersion == null) ? 0 : firmwareVersion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((mqttServerId == null) ? 0 : mqttServerId.hashCode());
		result = prime * result + ((mqttTopic == null) ? 0 : mqttTopic.hashCode());
		result = prime * result + ((nodeId == null) ? 0 : nodeId.hashCode());
		result = prime * result + ((nodeUid == null) ? 0 : nodeUid.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + ((rawDataType == null) ? 0 : rawDataType.hashCode());
		result = prime * result + size;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		RawData other = (RawData) obj;
		if (binaryType == null) {
			if (other.binaryType != null)
				return false;
		} else if (!binaryType.equals(other.binaryType))
			return false;
		if (channel != other.channel)
			return false;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (!Arrays.equals(data, other.data))
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
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
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
		if (mqttServerId == null) {
			if (other.mqttServerId != null)
				return false;
		} else if (!mqttServerId.equals(other.mqttServerId))
			return false;
		if (mqttTopic == null) {
			if (other.mqttTopic != null)
				return false;
		} else if (!mqttTopic.equals(other.mqttTopic))
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
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (rawDataType != other.rawDataType)
			return false;
		if (size != other.size)
			return false;
		if (state != other.state)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
