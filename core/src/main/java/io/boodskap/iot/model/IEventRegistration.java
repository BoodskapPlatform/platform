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

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.NotificationChannel;
import io.boodskap.iot.dao.EventRegistrationDAO;

@JsonSerialize(as=IEventRegistration.class)
public interface IEventRegistration extends IDomainObject {
	
	public static IEventRegistration create(String domainKey, String eventId, NotificationChannel channel, String toAddress) {
		return BoodskapSystem.storage().getEventRegistrationDAO().create(domainKey, eventId, channel, toAddress);
	}	

	public NotificationChannel getChannel();

	public void setChannel(NotificationChannel channel);

	public String getEventId();

	public void setEventId(String eventId);

	public String getToAddress();

	public void setToAddress(String toAddress);

	public default void save() {
		EventRegistrationDAO.get().createOrUpdate(this);
	}
	
}
