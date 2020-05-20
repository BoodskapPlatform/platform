package io.boodskap.iot.spi.ignite;

import java.util.concurrent.Callable;

import org.apache.ignite.lang.IgniteCallable;

public class GridCallable<T> implements IgniteCallable<T> {
	
	private static final long serialVersionUID = 1944897002304590031L;
	
	private final Callable<T> call;

	public GridCallable(final Callable<T> call) {
		this.call = call;
	}

	@Override
	public T call() throws Exception {
		return call.call();
	}

}
