package io.boodskap.iot.spi.ignite;

import org.apache.ignite.lang.IgniteRunnable;

public class GridRunnable implements IgniteRunnable {

	private static final long serialVersionUID = -7943998951894097256L;
	
	private final Runnable task;

	public GridRunnable(final Runnable task) {
		this.task = task;
	}

	@Override
	public void run() {
		task.run();
	}

}
