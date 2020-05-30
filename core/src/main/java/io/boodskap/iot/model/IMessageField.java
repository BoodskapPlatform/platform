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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as=IMessageField.class)
public interface IMessageField extends IField {

	@JsonIgnore
	public default boolean isNumericField() {
		return getDataType().isNumbericField();
	}

	public default void save() {
		throw new UnsupportedOperationException();
	}

	@Override
	public default void copy(Object other) {
		
		IMessageField o = (IMessageField) other;
		
		setIndexed(o.isIndexed());
		setFulltextIndexed(o.isFulltextIndexed());
		
		IField.super.copy(other);
	}
	
	public boolean isIndexed();

	public void setIndexed(boolean indexed);

	public boolean isFulltextIndexed();

	public void setFulltextIndexed(boolean fulltextIndexed);

}
