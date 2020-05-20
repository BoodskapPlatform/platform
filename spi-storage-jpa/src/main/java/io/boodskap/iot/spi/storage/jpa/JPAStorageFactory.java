package io.boodskap.iot.spi.storage.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.IConfig;
import io.boodskap.iot.PlatformException;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.spi.storage.IStorage;
import io.boodskap.iot.spi.storage.IStorageFactory;
import io.boodskap.iot.spi.storage.jpa.config.HSQLDBConfig;

public class JPAStorageFactory implements IStorageFactory {

	private static final Logger LOG = LoggerFactory.getLogger(JPAStorageFactory.class);
	
	private Class<? extends IConfig> config = HSQLDBConfig.class;
	private IStorage storage;
	
	public JPAStorageFactory() {
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
			
			if(null == getStorage()) {
				
				LOG.info("Initializing JPA storage factory...");
				
				JPA.get().init(cc);
				
				setStorage(new JPAStorage());
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
	
	protected void setStorage(IStorage storage) {
		this.storage = storage;
	}

	@Override
	public IStorage getStorage() throws StorageException {
		return storage;
	}

}
