package io.boodskap.iot.spi.storage.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.boodskap.iot.IConfig;
import io.boodskap.iot.PlatformException;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.spi.storage.IRawStorage;
import io.boodskap.iot.spi.storage.IRawStorageFactory;
import io.boodskap.iot.spi.storage.jpa.config.HSQLDBConfig;

public class JPARawStorageFactory implements IRawStorageFactory {

	private static final Logger LOG = LoggerFactory.getLogger(JPARawStorageFactory.class);
	
	private Class<? extends IConfig> config = HSQLDBConfig.class;
	private IRawStorage storage;
	
	public JPARawStorageFactory() {
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
				
				LOG.info("Initializing JPA raw storage factory...");
				
				JPA.get().init(cc);
				
				storage = new JPARawStorage();
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

	protected void setRawStorage(IRawStorage storage) {
		this.storage = storage;
	}

	@Override
	public IRawStorage getRawStorage() throws StorageException {
		if(null == storage){
			LOG.error("JPA raw storage not initialied. Did ya called init()?");
		}
		return storage;
	}

}
