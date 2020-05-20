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

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import io.boodskap.iot.GridException;

public interface IGrid {
	
	public INode thisNode() throws GridException;
	
	public List<INode> listNodes() throws GridException;
	
	public INode getNode(Object id) throws GridException;

	public <T> Future<T> submit(Callable<T> task) throws GridException;
	
	public Future<?> submit(Runnable task) throws GridException;
	
	public <T> List<Future<T>> broadcast(Callable<T> task, boolean includeThis) throws GridException;
	
	public List<Future<?>> broadcast(Runnable task, boolean includeThis) throws GridException;
	
	public void run(Runnable task) throws GridException;
	
	public <T> T call(Callable<T> task) throws GridException;
	
	public void addListener(INodeListener listener) throws GridException;

	public void removeListener(INodeListener listener) throws GridException;

	public default <T> List<Future<T>> broadcast(Callable<T> task) throws GridException{
		return broadcast(task, true);
	}
	
	public default List<Future<?>> broadcast(Runnable task) throws GridException{
		return broadcast(task, true);
	}
	
}
