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

import io.boodskap.iot.DataFormat;

/**
 * Annotation to access Boodskap system's Property table
 * 
 * <pre>
 * Boodskap platform will inject the actual property value during runtime if exists
 * </pre>
 * @author Jegan Vincent
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface PropertyResource {
	
	/**
	 * Property name/key
	 * @return {@link String}
	 */
	String name();
	
	/**
	 * False if the property is Domain's property
	 * <pre>
	 * Can't be false if plugin type is {@link PluginType#SERVICE}
	 * </pre>
	 * @return {@link String}
	 */
	boolean system() default false;
	
	/**
	 * Default property value if not configured
	 * @return {@link String}
	 */
	String def() default "";
	
	/**
	 * Default data format
	 * @return {@link DataFormat}
	 */
	DataFormat format() default DataFormat.AS_IS;
}
