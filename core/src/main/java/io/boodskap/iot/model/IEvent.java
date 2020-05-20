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

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.EventDAO;

@JsonSerialize(as=IEvent.class)
public interface IEvent extends IDomainObject {

	public static IEvent create(String domainKey, String eventId) {
		return BoodskapSystem.storage().getEventDAO().create(domainKey, eventId);
	}	

	public String getEventId();

	public void setEventId(String eventId);

	public String getName();

	public void setName(String name);

	public String getContent();

	public void setContent(String content);

	public String getSubject();

	public void setSubject(String subject);

	public String getContentTemplate();

	public void setContentTemplate(String contentTemplate);

	public String getSubjectTemplate();

	public void setSubjectTemplate(String subjectTemplate);

	public Date getCreatedStamp();
	
	public void setCreatedStamp(Date createdStamp);
	
	public Date getUpdatedStamp();
	
	public void setUpdatedStamp(Date updatedStamp);

	public default void save() {
		EventDAO.get().createOrUpdate(this);
	}
	
}
