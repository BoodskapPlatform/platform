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

public class SizeConstants {
	
	public static final int DOMAIN_SIZE = 16;
	public static final int API_KEY_SIZE = 20;
	public static final int ID_SIZE = 40;
	public static final int EMAIL_ID_SIZE = 120;
	public static final int NAME_SIZE = 120;
	public static final int DESCRIPTION_SIZE = 256;
	public static final int COUNTRY_SIZE = 40;
	public static final int FILE_SIZE = 1024 * 1024 * 25; //25MB
	public static final int JAR_FILE_SIZE = FILE_SIZE * 10; //100MB
	public static final int RAW_DATA_SIZE = 1024 * 1024 * 10; //10MB
	public static final int RECORD_FIELD_VALUE_SIZE = 1024 * 4; //4KB
	public static final int MESSAGE_FIELD_VALUE_SIZE = 1024 * 1; //1KB
	public static final int NOTIFICATION_CONTENT_SIZE = 1024 * 4; //4KB
	public static final int NOTIFICATION_HTML_CONTENT_SIZE = 1024 * 1024 * 1; //1MB
	public static final int TEMPLATE_CODE_SIZE = 1024 * 4; //4KB
	public static final int FIRMWARE_SIZE = 1024 * 1024 * 4; //4MB
	public static final int GLOABL_DATA_SIZE = 1024 * 12; //12KB
	public static final int MESSAGE_HEADER_SIZE = 1024 * 1; //1KB
	public static final int MESSAGE_DATA_SIZE = 1024 * 4; //4KB
	public static final int STATE_SIZE = 40;
	public static final int CITY_SIZE = 80;
	public static final int ADDRESS_SIZE = 256;
	public static final int ZIPCODE_SIZE = 20;
	public static final int LOCALE_SIZE = 4;
	public static final int PASSWORD_SIZE = 20;
	public static final int TIMEZONE_SIZE = 40;
	public static final int PHONE_NO_SIZE = 16;
	public static final int GROUP_ID_SIZE = 40;
	public static final int DEVICE_ID_SIZE = 40;
	public static final int ASSET_ID_SIZE = 40;
	public static final int EXTRA_CONFIG_SIZE = 1024 * 4; //4KB
	public static final int TOKEN_SIZE = 256;

	public SizeConstants() {
	}

}
