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

public enum DataType {
	
	BOOLEAN,
	BYTE,
	CHAR,
	SHORT,
	INT,
	LONG,
	FLOAT,
	DOUBLE,
	STRING,
	UUID,
	BLOB,
	JSON,
	_boolean,
	_byte,
	_char,
	_short,
	_int,
	_long,
	_float,
	_double,
	_blob,
	;
	
	public final boolean isNumbericField() {
		switch(this){
		case BYTE:
		case DOUBLE:
		case FLOAT:
		case INT:
		case LONG:
		case SHORT:
		case _byte:
		case _double:
		case _float:
		case _int:
		case _long:
		case _short:
			return true;
		default:
			return false;
		}
	}

}
