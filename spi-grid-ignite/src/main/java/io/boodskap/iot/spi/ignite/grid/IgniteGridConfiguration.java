package io.boodskap.iot.spi.ignite.grid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.boodskap.iot.IConfig;

public class IgniteGridConfiguration implements IConfig {
	
	private static final long serialVersionUID = 2736730239181203557L;

	public static final String KEY_GRID_NAME = "grid.name";
	
	private String gridName;
	private String configFile;
	private boolean clientMode;

	public IgniteGridConfiguration() {
	}
	
	@Override
	@JsonIgnore
	public int getStartPriority() {
		return 1;
	}

	@Override
	public void setDefaults() {
		gridName = "boodskap.io";
		configFile = "ignite.xml";
		clientMode = true;
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	public String getConfigFile() {
		return configFile;
	}

	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}

	public boolean isClientMode() {
		return clientMode;
	}

	public void setClientMode(boolean clientMode) {
		this.clientMode = clientMode;
	}

}
