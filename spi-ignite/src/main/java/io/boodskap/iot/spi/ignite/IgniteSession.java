package io.boodskap.iot.spi.ignite;

import org.apache.ignite.Ignite;

public class IgniteSession {
	
	private static final IgniteSession instance = new IgniteSession();
	
	private Ignite ignite;

	private IgniteSession() {
	}

	public static final IgniteSession get() {
		return instance;
	}

	public Ignite getIgnite() {
		return ignite;
	}

	public void setIgnite(Ignite ignite) {
		this.ignite = ignite;
	}

}
