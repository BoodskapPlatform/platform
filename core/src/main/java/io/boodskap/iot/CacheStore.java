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
import java.util.Date;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.dao.DomainDAO;
import io.boodskap.iot.dao.MessageSpecDAO;
import io.boodskap.iot.model.IDomain;
import io.boodskap.iot.model.IMessage;
import io.boodskap.iot.model.IMessageSpecification;
import io.boodskap.iot.model.IOfflineSnap;
import io.boodskap.iot.model.IOfflineStream;
import io.boodskap.iot.model.IOutgoingCommand;
import io.boodskap.iot.model.IRawData;
import io.boodskap.iot.spi.cache.ICache;
import io.boodskap.iot.util.DateUtil;

public class CacheStore implements Serializable {

	private static final long serialVersionUID = -8860662658126337896L;

	private static final Logger LOG = LoggerFactory.getLogger(CacheStore.class);
	
	private static final CacheStore instance = new CacheStore();
	
	private Map<String, IMessageSpecification> msgSpecCache; // domainKey.msgid
	private Map<String, AuthToken> authCache; //UUID
	private Map<String, Long> deviceUpdateCache; //domainKey.deviceId
	private BlockingQueue<String> incomingMessages;
	private BlockingQueue<CommandKey> routedCommands;
	private BlockingQueue<LogRecord> logs;
	private BlockingQueue<IMessage> rulesMessages;
	private BlockingQueue<String> outgoingEmails;
	private BlockingQueue<String> outgoingSms;
	private BlockingQueue<String> outgoingVoices;
	private BlockingQueue<String> outgoingFcms;
	private BlockingQueue<ShellScript> shellScripts;
	private BlockingQueue<SmsVoiceStatusRequest> smsVoiceStatus;
	private BlockingQueue<MessageInfo> processedMessages;
	private BlockingQueue<String[]> mlService;
	private BlockingQueue<String[]> frService;
	
	private int logOfferTimeout = BoodskapConfiguration.get().getLogOfferTimeout();

	private CacheStore() {
	}
	
	public static CacheStore get() {
		return instance;
	}

	protected synchronized void load() {
		
		ICache cache = BoodskapSystem.cache();
		
		{
			LOG.info("Initing auth cache");
			authCache = cache.getCache("AUTH_CACHE");
		}

		{
			LOG.info("Initing device update cache");
			deviceUpdateCache = cache.getCache("DEVICE_UPDATE_CACHE");
		}

		{
			LOG.info("Initing message spec cache");
			msgSpecCache = cache.getCache("MSG_SPEC_CACHE");
		}

		{
			LOG.info("Initing outgoing emails Q");
			outgoingEmails = cache.getQueue("OUTGOING_EMAILS");
		}

		{
			LOG.info("Initing outgoing sms Q");
			outgoingSms = cache.getQueue("OUTGOING_SMS");
		}

		{
			LOG.info("Initing outgoing voice msgs Q");
			outgoingVoices = cache.getQueue("OUTGOING_VOICES");
		}

		{
			LOG.info("Initing outgoing fcm msgs Q");
			outgoingFcms = cache.getQueue("OUTGOING_FCMS");
		}

		{
			LOG.info("Initing rules messages Q");
			rulesMessages = cache.getQueue("RULES_MESSAGES");
		}

		{
			LOG.info("Initing shell script messages Q");
			shellScripts = cache.getQueue("SCRIPT_MESSAGES");
		}

		{
			LOG.info("Initing SMS/Voice Status Q");
			smsVoiceStatus = cache.getQueue("SMS_VOICE_STATUS");
		}

		{
			LOG.info("Initing Processed Messages Q");
			processedMessages = cache.getQueue("PROCESSED_MESSAGES");
		}

		{
			LOG.info("Initing routed commands Q");
			routedCommands = cache.getQueue("ROUTED_COMMANDS");
		}
		
		{
			LOG.info("Initing ML Service Q");
			mlService = cache.getQueue("ML_SERVICE_Q");
		}

		{
			LOG.info("Initing FR Service Q");
			frService = cache.getQueue("FR_SERVICE_Q");
		}

		{
			LOG.info("Initing log Q");
			logs = cache.getQueue("LOGS");
		}

		{
			LOG.info("Initing incoming messages Q"); // Load this at last after all caches
			incomingMessages = cache.getQueue("INCOMING_MESSAGES");
		}

		LOG.info("Loaded/Initialized all caches successfully");
		
	}
	
	public void processRawData(IRawData body, long started) throws InterruptedException {
		
		body.setReceivedStamp(new Date(started));
		body.save();
		
		switch(body.getRawDataType()) {
		case OFFLINE_STREAM:

			/**
			 * /{$domain-key}/device/{$device-id}/stream/offline/{$camera-id}/{$session-id}/{$frame}/<$mime-type>
			 */
			String args[] = body.getMqttTopic().split("/");
			IOfflineStream stream = IOfflineStream.create(args[1], args[3], args[6], args[7], Integer.valueOf(args[8]));
			if(args.length >= 10) {
				stream.setMime(args[9]);
			}
			stream.setStamp(body.getReceivedStamp());
			stream.setData(body.getData());
			stream.save();
			break;
		case OFFLINE_SNAP:
			
			/**
			 * /{$domain-key}/device/{$device-id}/snap/offline/{$camera-id}/<{$mime-type}>
			 */
			args = body.getMqttTopic().split("/");
			IOfflineSnap snap = IOfflineSnap.create(args[1], args[3], args[6], new Date());
			if(args.length >= 8) {
				snap.setMime(args[7]);
			}
			snap.setStamp(body.getReceivedStamp());
			snap.setData(body.getData());
			snap.save();
			
			break;
		default:
			break;
		}
		
		if(CacheStore.get().getIncomingMessages().offer(body.getId(), 10, TimeUnit.SECONDS)) {
			int queued = CacheStore.get().getIncomingMessages().size();
			LOG.debug(String.format("Pub %s success id:%s in:%s, Q:%d", body.getChannel(), body.getId(), DateUtil.ellapsed(started), queued));
		}else {
			int queued = CacheStore.get().getIncomingMessages().size();
			LOG.error(String.format("Pub %s failure id:%s in:%s, Q:%d", body.getChannel(), body.getId(), DateUtil.ellapsed(started), queued));
		}
		

	}

	public BlockingQueue<ScheduledRuleAction> getScheduledRuleActions(String nodeId) {
		
		final String queueId = String.format("SCHEDULED_RULES_%s", nodeId);
		LOG.info(String.format("Loading %s Q", queueId));
		BlockingQueue<ScheduledRuleAction> queue  = BoodskapSystem.cache().getQueue(queueId);
		
		return queue;
	}
	
	public BlockingQueue<IOutgoingCommand> createOrGetOutgoingCommands(DataChannel channel, String instanceId) {
		
		final String queueId = String.format("%s.%s.out", instanceId, channel);
		LOG.info(String.format("Loading %s Q", queueId));
		BlockingQueue<IOutgoingCommand> queue  = BoodskapSystem.cache().getQueue(queueId);
		
		return queue;
	}
	
	public void set(IMessageSpecification entity) {
		msgSpecCache.put(String.format("%s.%s", entity.getDomainKey(), entity.getSpecId()), entity);
	}

	public boolean log(LogRecord rec) throws InterruptedException {
		return logs.offer(rec, logOfferTimeout, TimeUnit.SECONDS);
	}

	public IMessageSpecification loadOrGetMessageSpec(String domainKey, String messageSpecId) {
		
		String key = String.format("%s.%s", domainKey, messageSpecId);
		IMessageSpecification val = msgSpecCache.get(key);
		
		if(null != val) return val;
		
		IDomain domain = DomainDAO.get().get(domainKey);
		if(null == domain) return null;
		key = String.format("%s.%s", domainKey, messageSpecId);
		val = msgSpecCache.get(key);
		
		if (null == val) {
			
			val = MessageSpecDAO.get().get(domainKey, messageSpecId);
			
			if (null != val) {
				msgSpecCache.put(key, val);
			}
		}
		
		return val;
	}

	public Map<String, IMessageSpecification> getMsgSpecCache() {
		return msgSpecCache;
	}

	public Map<String, AuthToken> getAuthCache() {
		return authCache;
	}

	public Map<String, Long> getDeviceUpdateCache() {
		return deviceUpdateCache;
	}

	public BlockingQueue<String> getIncomingMessages() {
		return incomingMessages;
	}

	public BlockingQueue<CommandKey> getRoutedCommands() {
		return routedCommands;
	}

	public BlockingQueue<LogRecord> getLogs() {
		return logs;
	}

	public BlockingQueue<IMessage> getRulesMessages() {
		return rulesMessages;
	}

	public BlockingQueue<String> getOutgoingEmails() {
		return outgoingEmails;
	}

	public BlockingQueue<String> getOutgoingSms() {
		return outgoingSms;
	}

	public BlockingQueue<String> getOutgoingVoices() {
		return outgoingVoices;
	}

	public BlockingQueue<String> getOutgoingFcms() {
		return outgoingFcms;
	}

	public BlockingQueue<ShellScript> getShellScripts() {
		return shellScripts;
	}

	public BlockingQueue<SmsVoiceStatusRequest> getSmsVoiceStatus() {
		return smsVoiceStatus;
	}

	public BlockingQueue<MessageInfo> getProcessedMessages() {
		return processedMessages;
	}

	public BlockingQueue<String[]> getMlService() {
		return mlService;
	}

	public BlockingQueue<String[]> getFrService() {
		return frService;
	}

	public int getLogOfferTimeout() {
		return logOfferTimeout;
	}
	
}