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

/**
 * An annotation that must be declared on all methods of the plugins that needs to be exposed for usage
 * 
 * @author Jegan Vincent
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invokable {
	
	/**
	 * Signature of the method including return types and arguments
	 * @return {@link String}
	 */
	String signature();
	
	/**
	 * A simple help string
	 * @return {@link String}
	 */
	String help();
	
	/**
	 * List of one or more example code
	 * @return {@link String} array
	 */
	String[] examples() default {};
	
	/**
	 * List of one or more external resources
	 * @return {@link String} array
	 */
	String[] resources() default {};
}
