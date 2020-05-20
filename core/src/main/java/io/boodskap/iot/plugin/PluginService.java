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

/**
 * An annotation to declare on plugins of type {@link PluginType#SERVICE}
 * <pre>
 * Service startup/shutdown sequence is not guaranteed
 * Plugins must not perform any action until {@link DomainSettings#isInited()} is returned true
 * </pre>
 * @author Jegan Vincent
 *
 */
public @interface PluginService {
	
	/**
	 * Type of the plugin service
	 * @return {@link ServiceType}
	 */
	ServiceType type();
	
	/**
	 * Minimum number of instances spawned the cluster
	 * <pre>
	 * Ignored if <code>type</code> is not {@link ServiceType#SCALABLE}
	 * </pre>
	 * @return {@link Integer}
	 */
	int min() default 1;
	
	/**
	 * Maximum number of instances spawned the cluster
	 * <pre>
	 * Ignored if <code>type</code> is not {@link ServiceType#SCALABLE}
	 * </pre>
	 * @return {@link Integer}
	 */
	int max() default 1;
}
