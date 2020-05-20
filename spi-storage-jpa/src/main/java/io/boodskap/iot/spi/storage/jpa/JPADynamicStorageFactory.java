package io.boodskap.iot.spi.storage.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.IConfig;
import io.boodskap.iot.PlatformException;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.spi.storage.IDynamicStorage;
import io.boodskap.iot.spi.storage.IDynamicStorageFactory;
import io.boodskap.iot.spi.storage.jpa.config.HSQLDBConfig;

public class JPADynamicStorageFactory implements IDynamicStorageFactory {

	private static final Logger LOG = LoggerFactory.getLogger(JPADynamicStorageFactory.class);
	
	private Class<? extends IConfig> config = HSQLDBConfig.class;
	private IDynamicStorage storage;
	
	public JPADynamicStorageFactory() {
	}

	@Override
	public String getConfigSectionName() {
		return "jpa";
	}

	@Override
	public void setConfigClass(Class<? extends IConfig> config) {
		this.config = config;
	}

	@Override
	public Class<? extends IConfig> getConfigClass() {
		return config;
	}

	@Override
	public void init(IConfig config) throws PlatformException {
		
		try {
			
			JPAConfig cc = (JPAConfig) config;
			
			if(null == storage) {
				
				LOG.info("Initializing JPA dynamic storage factory...");
				
				JPA.get().init(cc);
				
				storage = new JPADynamicStorage();
			}
		}catch(Exception ex) {
			throw new PlatformException(ex);
		}
		
	}

	@Override
	public void dispose() throws PlatformException {
		
		try {			
			JPA.get().dispose();
			storage = null;
		}catch(Exception ex) {
			throw new PlatformException(ex);
		}
		
	}
	
	protected void setDynamicStorage(IDynamicStorage storage) {
		this.storage = storage;
	}

	@Override
	public IDynamicStorage getDynamicStorage() throws StorageException {
		if(null == storage){
			LOG.error("JPA dynamic storage not initialied. Did ya called init()?");
		}
		return storage;
	}

}
