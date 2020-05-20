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
package io.boodskap.iot.spi.storage;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.MessageDAO;
import io.boodskap.iot.dao.MessageSpecDAO;
import io.boodskap.iot.dao.RecordDAO;
import io.boodskap.iot.dao.RecordSpecDAO;
import io.boodskap.iot.model.IMessage;
import io.boodskap.iot.model.IMessageSpecification;
import io.boodskap.iot.model.IRecord;
import io.boodskap.iot.model.IRecordSpecification;

public interface IDynamicStorage extends IBaseStorage {
	
	public <T extends IMessageSpecification> MessageSpecDAO<T> getMessageSpecDAO();
	
	public <T extends IRecordSpecification> RecordSpecDAO<T> getRecordSpecDAO();
	
	public <T extends IMessage> MessageDAO<T> getMessageDAO() throws StorageException;

	public <T extends IRecord> RecordDAO<T> getRecordDAO() throws StorageException;
	
}
