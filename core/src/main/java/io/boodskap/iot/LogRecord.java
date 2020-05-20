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
import java.util.UUID;

public class LogRecord implements Serializable {
	
	private static final long serialVersionUID = 167430695616982566L;

	public static enum RecordType{
		DOMAIN_RULE,
		MESSAGE_RULE,
		NAMED_RULE,
		SCHEDULED_RULE,
		SERVER_LOG,
		BINARY_RULE,
	}
	
	public static enum LogType{
		LOG,
		COMMAND,
		MESSAGE,
		SHELL_SCRIPT,
		BINARY_MESSAGE,
	}
	
	private String domainKey;
	private RecordType recordType;
	private LogType logType = LogType.LOG;
	private long stamp = System.currentTimeMillis();
	private UUID sessionId;
	private Long messageId;
	private Long ruleId;
	private String ruleName;
	private String data;
	private String level = "info";
	private String line;
	private String deviceId;
	private long correlationId;
	private CommandStatus commandStatus;
	private String failureReason;
	private String node = BoodskapSystem.grid().thisNode().instanceId().toString();
	private String binaryRuleType;
	
	public LogRecord() {
	}
	
	public LogRecord(String domainKey) {
		this.domainKey = domainKey;
		this.logType = LogType.SHELL_SCRIPT;
	}

	public LogRecord(String domainKey, String data) {
		this.domainKey = domainKey;
		this.data = data;
		this.logType = LogType.LOG;
		this.recordType = RecordType.DOMAIN_RULE;
	}

	public LogRecord(String domainKey, long messageId, String data) {
		this.domainKey = domainKey;
		this.messageId = messageId;
		this.data = data;
		this.logType = LogType.LOG;
		this.recordType = RecordType.MESSAGE_RULE;
	}

	public LogRecord(String domainKey, String ruleName, String data) {
		this.domainKey = domainKey;
		this.ruleName = ruleName;
		this.data = data;
		this.logType = LogType.LOG;
		this.recordType = RecordType.NAMED_RULE;
	}
	
	public LogRecord(String domainKey, String data, long ruleId) {
		this.domainKey = domainKey;
		this.ruleId = ruleId;
		this.data = data;
		this.logType = LogType.LOG;
		this.recordType = RecordType.SCHEDULED_RULE;
	}
	
	public static LogRecord makeCommandStatus(String domainKey, String deviceId, long corrId, CommandStatus status, String failureReason) {
		LogRecord l = new LogRecord();
		l.setLogType(LogType.COMMAND);
		l.setDomainKey(domainKey);
		l.setDeviceId(deviceId);
		l.setCorrelationId(corrId);
		l.setCommandStatus(status);
		l.setFailureReason(failureReason);
		return l;
	}

	public static LogRecord makeMessageStatus(String domainKey, UUID messageId) {
		LogRecord l = new LogRecord();
		l.setLogType(LogType.MESSAGE);
		l.setDomainKey(domainKey);
		l.setSessionId(messageId);
		return l;
	}

	public static LogRecord makeBinMessageStatus(String domainKey, UUID messageId) {
		LogRecord l = new LogRecord();
		l.setLogType(LogType.BINARY_MESSAGE);
		l.setDomainKey(domainKey);
		l.setSessionId(messageId);
		return l;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public RecordType getRecordType() {
		return recordType;
	}

	public void setRecordType(RecordType type) {
		this.recordType = type;
	}

	public long getStamp() {
		return stamp;
	}

	public void setStamp(long stamp) {
		this.stamp = stamp;
	}

	public UUID getSessionId() {
		return sessionId;
	}

	public void setSessionId(UUID sessionId) {
		this.sessionId = sessionId;
	}

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public Long getRuleId() {
		return ruleId;
	}

	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public long getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(long correlationId) {
		this.correlationId = correlationId;
	}

	public CommandStatus getCommandStatus() {
		return commandStatus;
	}

	public void setCommandStatus(CommandStatus commandStatus) {
		this.commandStatus = commandStatus;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public LogType getLogType() {
		return logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

	public String getNode() {
		return node;
	}

	public String getBinaryRuleType() {
		return binaryRuleType;
	}

	public void setBinaryRuleType(String binaryRuleType) {
		this.binaryRuleType = binaryRuleType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((binaryRuleType == null) ? 0 : binaryRuleType.hashCode());
		result = prime * result + ((commandStatus == null) ? 0 : commandStatus.hashCode());
		result = prime * result + (int) (correlationId ^ (correlationId >>> 32));
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
		result = prime * result + ((failureReason == null) ? 0 : failureReason.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((line == null) ? 0 : line.hashCode());
		result = prime * result + ((logType == null) ? 0 : logType.hashCode());
		result = prime * result + ((messageId == null) ? 0 : messageId.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
		result = prime * result + ((ruleId == null) ? 0 : ruleId.hashCode());
		result = prime * result + ((ruleName == null) ? 0 : ruleName.hashCode());
		result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
		result = prime * result + (int) (stamp ^ (stamp >>> 32));
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
		LogRecord other = (LogRecord) obj;
		if (binaryRuleType == null) {
			if (other.binaryRuleType != null)
				return false;
		} else if (!binaryRuleType.equals(other.binaryRuleType))
			return false;
		if (commandStatus != other.commandStatus)
			return false;
		if (correlationId != other.correlationId)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (deviceId == null) {
			if (other.deviceId != null)
				return false;
		} else if (!deviceId.equals(other.deviceId))
			return false;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		if (failureReason == null) {
			if (other.failureReason != null)
				return false;
		} else if (!failureReason.equals(other.failureReason))
			return false;
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (line == null) {
			if (other.line != null)
				return false;
		} else if (!line.equals(other.line))
			return false;
		if (logType != other.logType)
			return false;
		if (messageId == null) {
			if (other.messageId != null)
				return false;
		} else if (!messageId.equals(other.messageId))
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (recordType != other.recordType)
			return false;
		if (ruleId == null) {
			if (other.ruleId != null)
				return false;
		} else if (!ruleId.equals(other.ruleId))
			return false;
		if (ruleName == null) {
			if (other.ruleName != null)
				return false;
		} else if (!ruleName.equals(other.ruleName))
			return false;
		if (sessionId == null) {
			if (other.sessionId != null)
				return false;
		} else if (!sessionId.equals(other.sessionId))
			return false;
		if (stamp != other.stamp)
			return false;
		return true;
	}

}
