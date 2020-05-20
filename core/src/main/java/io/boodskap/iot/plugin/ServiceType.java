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
 * 
 * Different kinds of supported plugin services
 * 
 * @author Jegan Vincent
 *
 */
public enum ServiceType {
	
	/**
	 * Typically used when you want more than once instance serving in a cluster
	 * @see PluginService#min()
	 * @see PluginService#max()
	 */
	SCALABLE,
	
	/**
	 * Single instance of the service will be deployed in a cluster-node
	 */
	NODE_STINGLETON,
	
	/**
	 * Singleton instance cluster-wide
	 */
	CLUSTER_SINGLETON
}
