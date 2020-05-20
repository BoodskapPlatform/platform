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

import io.boodskap.iot.dao.CounterDAO;

@JsonSerialize(as=ICounter.class)
public interface ICounter extends IModel {

	public static CounterDAO<ICounter> dao(){
		return CounterDAO.get();
	}
	
	public static Class<? extends ICounter> clazz() {
		return dao().clazz();
	}
	
	public static ICounter create() {
		return dao().create();
	}

	public default void save() {
		throw new UnsupportedOperationException();
	}

	public default void incrementDomains() {
		dao().incrementDomains();
	}

	public default void incrementUsers() {
		dao().incrementUsers();
	}

	public default void incrementDevices() {
		dao().incrementDevices();
	}

	public default void incrementUdp() {
		dao().incrementUdp();
	}

	public default void incrementLoRa() {
		dao().incrementLoRa();
	}

	public default void incrementMqtt() {
		dao().incrementMqtt();
	}

	public default void incrementHttp() {
		dao().incrementHttp();
	}

	public default void incrementFcm() {
		dao().incrementFcm();
	}

	public default void incrementCoAP() {
		dao().incrementCoAP();
	}

	public default void incrementTcp() {
		dao().incrementTcp();
	}

	public default void incrementCommands() {
		dao().incrementCommands();
	}

	public default void incrementRecords() {
		dao().incrementRecords();
	}

	public int getId();

	public void setId(int id);

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

	public long getDomains();

	public void setDomains(long domains);

	public long getLoraMessages();

	public void setLoraMessages(long loraMessages);
	
	public long getRecords();

	public void setRecords(long records);

}
