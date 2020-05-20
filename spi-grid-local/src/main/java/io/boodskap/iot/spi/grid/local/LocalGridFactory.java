package io.boodskap.iot.spi.grid.local;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.GridException;
import io.boodskap.iot.IConfig;
import io.boodskap.iot.PlatformException;
import io.boodskap.iot.spi.grid.IGrid;
import io.boodskap.iot.spi.grid.IGridFactory;

public class LocalGridFactory implements IGridFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(LocalGridFactory.class);

	private LocalGrid grid;

	public LocalGridFactory() {
	}

	@Override
	public void init(IConfig config) throws PlatformException {
		
		try {
			
			if(null != grid) return;
			
			LOG.info("Initializing local grid factory...");
			
			LocalGridConfig cc = (LocalGridConfig) config;
			
			grid = LocalGrid.get(cc);
			grid.start();
			
			
		}catch(Exception ex) {
			throw new PlatformException(ex);
		}
	}

	@Override
	public void dispose() throws PlatformException {
		
		if(null != grid) {
			grid.stop();
		}
		
		grid = null;
	}

	@Override
	public IGrid getGrid() throws GridException {
		if(null == grid) throw new GridException("Grid not initialied. Did ya called init()?");
		return grid;
	}

	@Override
	public Class<LocalGridConfig> getConfigClass() {
		return LocalGridConfig.class;
	}

	@Override
	public String getConfigSectionName() {
		return "lgrid";
	}

}
