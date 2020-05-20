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
package io.boodskap.iot.spi.grid;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import io.boodskap.iot.GridException;

public interface INode {
	
	public Object instanceId() throws GridException;

	public Object consistentId() throws GridException;

	public <T> Future<T> submit(Callable<T> task) throws GridException;
	
	public Future<?> submit(Runnable task) throws GridException;
	
	public void run(Runnable task) throws GridException;
}
