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

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.NotificationStatus;

@JsonSerialize(as=ISentNotification.class)
public interface ISentNotification extends IStorageObject {
	
	public IProgress createProgress(String content);
	
	public IResponse createResponse(String content);
	
	public String getDomainKey();
	
	public void setDomainKey(String domainKey);

	public String getNotificationId();

	public void setNotificationId(String notificationId);

	public Date getQueuedAt();

	public void setQueuedAt(Date queuedAt);

	public String getReceipent();

	public void setReceipent(String receipent);

	public String getSubject();

	public void setSubject(String subject);

	public String getContent();

	public void setContent(String content);

	public NotificationStatus getStatus();

	public void setStatus(NotificationStatus status);

	public Date getSentAt();

	public void setSentAt(Date sentAt);

	public <T extends IProgress> Collection<T> getProgress();

	public void setProgress(Collection<? extends IProgress> progress);

	public <T extends IResponse> Collection<T> getResponse();

	public void setResponse(Collection<? extends IResponse> response);
}
