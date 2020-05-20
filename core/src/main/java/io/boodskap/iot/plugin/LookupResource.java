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
package io.boodskap.iot.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.boodskap.iot.DataType;

/**
 * Annotation to access Boodskap system's Lookup table
 * 
 * <pre>
 * Boodskap platform will inject the actual lookup value during runtime if exists
 * </pre>
 * @author Jegan Vincent
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface LookupResource {
	
	/**
	 * Lookup name/key
	 * @return {@link String}
	 */
	String name();
	
	/**
	 * Data Type of the lookup value
	 * @return {@link DataType}
	 */
	DataType type();

	/**
	 * False if the lookup is Domain's value
	 * <pre>
	 * Can't be false if plugin type is {@link PluginType#SERVICE}
	 * </pre>
	 * @return {@link String}
	 */
	boolean system() default false;
	
	/**
	 * Default lookup value if not configured
	 * @return {@link String}
	 */
	String def() default "";
}
