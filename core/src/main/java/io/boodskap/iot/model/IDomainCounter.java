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

import io.boodskap.iot.dao.DomainCounterDAO;

@JsonSerialize(as=IDomainCounter.class)
public interface IDomainCounter extends IDomainObject {

	public static DomainCounterDAO<IDomainCounter> dao(){
		return DomainCounterDAO.get();
	}
	
	public static Class<? extends IDomainCounter> clazz() {
		return dao().clazz();
	}
	
	public static IDomainCounter create(String domainKey) {
		return dao().create(domainKey);
	}

	public default void save() {
		throw new UnsupportedOperationException();
	}

	public default void incrementUsers(String domainKey) {
		dao().incrementUsers(domainKey);
	}

	public default void incrementDevices(String domainKey) {
		dao().incrementDevices(domainKey);
	}

	public default void incrementUdp(String domainKey) {
		dao().incrementUdp(domainKey);
	}

	public default void incrementLoRa(String domainKey) {
		dao().incrementLoRa(domainKey);
	}

	public default void incrementMqtt(String domainKey) {
		dao().incrementMqtt(domainKey);
	}

	public default void incrementHttp(String domainKey) {
		dao().incrementHttp(domainKey);
	}

	public default void incrementFcm(String domainKey) {
		dao().incrementFcm(domainKey);
	}

	public default void incrementCoAP(String domainKey) {
		dao().incrementCoAP(domainKey);
	}

	public default void incrementTcp(String domainKey) {
		dao().incrementTcp(domainKey);
	}

	public default void incrementCommands(String domainKey) {
		dao().incrementCommands(domainKey);
	}

	public default void incrementRecords(String domainKey) {
		dao().incrementRecords(domainKey);
	}

	@Override
	public default void copy(Object other) {
		
		IDomainCounter o = (IDomainCounter) other;
		
		setUsers(o.getUsers());
		setDevices(o.getDevices());
		setUdpMessages(o.getUdpMessages());
		setMqttMessages(o.getMqttMessages());
		setHttpMessages(o.getHttpMessages());
		setFcmMessages(o.getFcmMessages());
		setCommands(o.getCommands());
		setCoapMessages(o.getCoapMessages());
		setTcpMessages(o.getTcpMessages());
		setLoraMessages(o.getLoraMessages());
		setRecords(o.getRecords());
		
		IDomainObject.super.copy(other);
	}

	public long getUsers();

	public void setUsers(long users);

	public long getDevices();

	public void setDevices(long devices);

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
	
	public long getRecords();

	public void setRecords(long records);

}
