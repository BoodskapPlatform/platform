package io.boodskap.iot.spi.ignite.grid;

import java.io.File;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.GridException;
import io.boodskap.iot.IConfig;
import io.boodskap.iot.PlatformException;
import io.boodskap.iot.spi.grid.IGrid;
import io.boodskap.iot.spi.grid.IGridFactory;
import io.boodskap.iot.spi.ignite.IgniteSession;

public class IgniteGridFactory implements IGridFactory {
	
	private static final Logger LOG = LoggerFactory.getLogger(IgniteGridFactory.class);

	private IgniteGrid grid;

	public IgniteGridFactory() {
	}

	@Override
	public void init(IConfig config) throws PlatformException {
		
		if(null != grid) return;
		
		try {
			
			LOG.info("Initializing ignite grid factory...");
			
			IgniteGridConfiguration cc = (IgniteGridConfiguration) config;

			Ignite ignite = IgniteSession.get().getIgnite();
			
			if(null == ignite) {
				
				File cFile = new File(BoodskapSystem.get().getConfigFolder(), cc.getConfigFile());

				Ignition.setClientMode(cc.isClientMode());
				ignite = Ignition.start(cFile.getAbsolutePath());
				
				if(!ignite.cluster().active()) {
					LOG.warn("Ignite cluster not active, activating....");
					ignite.cluster().active(true);
				}else {
					LOG.info("Ignite cluster is active");
				}
				
				IgniteSession.get().setIgnite(ignite);
			}
			
			grid = new IgniteGrid(cc, ignite);
			
		}catch(Exception ex) {
			throw new PlatformException(ex);
		}
	}

	@Override
	public void dispose() throws PlatformException {
		
		if(null != grid) {
			try {
				LOG.warn("Closing ignite grid");
				grid.close();
				grid = null;
			}catch(Exception ex) {
				throw new PlatformException(ex);
			}
		}
		
	}

	@Override
	public IGrid getGrid() throws GridException {
		if(null == grid) throw new GridException("Ignite grid factory not initialied. Did ya called init()?");
		return grid;
	}

	@Override
	public String getConfigSectionName() {
		return "igrid";
	}

	@Override
	public Class<IgniteGridConfiguration> getConfigClass() {
		return IgniteGridConfiguration.class;
	}

}
