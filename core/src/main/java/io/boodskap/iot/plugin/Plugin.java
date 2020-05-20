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
 * Every plugin must have this annotation declared
 * @author Jegan Vincent
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Plugin {
	
	/**
	 * A unique identifier for this plugin, typically a UUID in string format
	 * @return {@link String}
	 */
	String id();
	
	/**
	 * Type of the plugin
	 * <pre>
	 * If the plugin type is {@link PluginType#SERVICE} then the plugin must 
	 * 	declare {@link PluginType} annotation and
	 * 	implement {@link PluginService} interface
	 * </pre>
	 * @return {@link PluginType}
	 */
	PluginType type();
	
	/**
	 * Plugin version, semver style versioning is strongly recommended
	 * @return {@link String}
	 */
	String version();
	
	/**
	 * If the plugin is a type of {@link PluginType#CONTEXT} then a unique context-id is required
	 * @return {@link String}
	 */
	String contextId() default "";
	
	/**
	 * A short description about the plugin
	 * @return {@link String}
	 */
	String desc() default "";
	
	/**
	 * Author name/email
	 * @return {@link String}
	 */
	String author() default "";
}
