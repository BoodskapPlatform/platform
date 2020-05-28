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
package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.dao.DeviceCounterDAO;

@JsonSerialize(as=IDeviceCounter.class)
public interface IDeviceCounter extends IDomainObject {

	public static DeviceCounterDAO<IDeviceCounter> dao(){
		return DeviceCounterDAO.get();
	}
	
	public static Class<? extends IDeviceCounter> clazz() {
		return dao().clazz();
	}
	
	public static IDeviceCounter create(String domainKey, String deviceId) {
		return dao().create(domainKey, deviceId);
	}
	
	public static IDeviceCounter find(String domainKey, String deviceId) {
		return dao().get(domainKey, deviceId);
	}
	
	public default void save() {
		IDeviceCounter.dao().createOrUpdate(this);
	}

	public default void incrementUdp() {
		dao().incrementUdp(getDomainKey(), getDeviceId());
	}

	public default void incrementLoRa() {
		dao().incrementLoRa(getDomainKey(), getDeviceId());
	}

	public default void incrementMqtt() {
		dao().incrementMqtt(getDomainKey(), getDeviceId());
	}

	public default void incrementHttp() {
		dao().incrementHttp(getDomainKey(), getDeviceId());
	}

	public default void incrementFcm() {
		dao().incrementFcm(getDomainKey(), getDeviceId());
	}

	public default void incrementCoAP() {
		dao().incrementCoAP(getDomainKey(), getDeviceId());
	}

	public default void incrementTcp() {
		dao().incrementTcp(getDomainKey(), getDeviceId());
	}

	public default void incrementCommands() {
		dao().incrementCommands(getDomainKey(), getDeviceId());
	}
	
	public default long countUdp() {
		return dao().countUdp(getDomainKey(), getDeviceId());
	}

	public default long countLoRa() {
		return dao().countLoRa(getDomainKey(), getDeviceId());
	}

	public default long countMqtt() {
		return dao().countMqtt(getDomainKey(), getDeviceId());
	}

	public default long countHttp() {
		return dao().countHttp(getDomainKey(), getDeviceId());
	}

	public default long countFcm() {
		return dao().countFcm(getDomainKey(), getDeviceId());
	}

	public default long countCoAP() {
		return dao().countCoAP(getDomainKey(), getDeviceId());
	}

	public default long countTcp() {
		return dao().countTcp(getDomainKey(), getDeviceId());
	}

	public default long countCommands() {
		return dao().countCommands(getDomainKey(), getDeviceId());
	}
	
	@Override
	public default void copy(Object other) {
		
		IDeviceCounter o = (IDeviceCounter) other;
		
		setDeviceId(o.getDeviceId());
		setUdpMessages(o.getUdpMessages());
		setMqttMessages(o.getMqttMessages());
		setHttpMessages(o.getHttpMessages());
		setFcmMessages(o.getFcmMessages());
		setCommands(o.getCommands());
		setCoapMessages(o.getCoapMessages());
		setTcpMessages(o.getTcpMessages());
		setLoraMessages(o.getLoraMessages());
		
		IDomainObject.super.copy(other);
	}

	public String getDeviceId() ;

	public void setDeviceId(String deviceId);

	public long getUdpMessages();

	public void setUdpMessages(long udpMessages);

	public long getMqttMessages();

	public void setMqttMessages(long mqttMessages);

	public long getHttpMessages();

	public void setHttpMessages(long httpMessages);

	public long getFcmMessages();

	public void setFcmMessages(long fcmMessages);

	public long getCommands();

	public void setCommands(long commands);

	public long getCoapMessages();

	public void setCoapMessages(long coapMessages);

	public long getTcpMessages();

	public void setTcpMessages(long tcpMessages);

	public long getLoraMessages();

	public void setLoraMessages(long loraMessages);
}
