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

import java.math.BigInteger;
import java.security.SecureRandom;

import org.apache.commons.lang3.StringUtils;

public class KeyGenerator {
	
	private static final String newRandomString(int length){
		SecureRandom secureRandom = new SecureRandom();
	    byte[] token = new byte[length/2];
	    secureRandom.nextBytes(token);
	    return new BigInteger(1, token).toString(16); //hex encoding
	    //return new String(token);
	}
	
	public static final String newSecretKey(){
		return newRandomString(64).toUpperCase();
	}
	
	public static final String newDomainKey(){
		return newRandomString(16).toUpperCase();
	}
	
	public static final String newApiKey(){
		return newRandomString(32);
	}
	
	public static final String newClusterId(){
		String _1 = StringUtils.leftPad(newRandomString(4), 4, 'X').toUpperCase();
		String _2 = StringUtils.leftPad(newRandomString(4), 4, 'X').toUpperCase();
		String _3 = StringUtils.leftPad(newRandomString(4), 4, 'X').toUpperCase();
		String _4 = StringUtils.leftPad(newRandomString(4), 4, 'X').toUpperCase();
		return String.format("%s-%s-%s-%s", _1, _2, _3, _4);
	}
	
	public static final String newLicenseKey(String licenseType){
		String type = licenseType.length() >= 4 ? licenseType.substring(0, 4) : licenseType;
		String _0 = StringUtils.leftPad(type, 4, 'X').toUpperCase();
		String _1 = StringUtils.leftPad(newRandomString(4), 4, 'X').toUpperCase();
		String _2 = StringUtils.leftPad(newRandomString(4), 4, 'X').toUpperCase();
		String _3 = StringUtils.leftPad(newRandomString(4), 4, 'X').toUpperCase();
		String _4 = StringUtils.leftPad(newRandomString(4), 4, 'X').toUpperCase();
		return String.format("%s-%s-%s-%s-%s", _0, _1, _2, _3, _4);
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			System.out.format("%s\n", KeyGenerator.newSecretKey());
		}
	}
}
