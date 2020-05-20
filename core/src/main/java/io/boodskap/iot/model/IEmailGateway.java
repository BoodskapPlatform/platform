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
import io.boodskap.iot.dao.EmailGatewayDAO;

@JsonSerialize(as=IEmailGateway.class)
public interface IEmailGateway extends IDomainObject {

	public static IEmailGateway create(String domainKey) {
		return BoodskapSystem.storage().getEmailGatewayDAO().create(domainKey);
	}	

	public String getHost();

	public void setHost(String host);

	public int getPort();

	public void setPort(int port);

	public String getUser();

	public void setUser(String user);

	public String getPassword();

	public void setPassword(String password);

	public boolean isSsl();

	public void setSsl(boolean ssl);

	public String getPrimaryEmail();

	public void setPrimaryEmail(String primaryEmail);

	public String getBounceEmail();

	public void setBounceEmail(String bounceEmail);

	public boolean isTls();

	public void setTls(boolean tls);

	public boolean isDebug();

	public void setDebug(boolean debug);

	public String getName();

	public void setName(String name);

	public Date getCreatedStamp();
	
	public void setCreatedStamp(Date createdStamp);
	
	public Date getUpdatedStamp();
	
	public void setUpdatedStamp(Date updatedStamp);

	public default void save() {
		EmailGatewayDAO.get().createOrUpdate(this);
	}
}
