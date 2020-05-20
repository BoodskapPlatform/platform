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
package io.boodskap.iot;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import io.boodskap.iot.model.IClusterLicense;
import io.boodskap.iot.model.IClusterLicense.LicenseStatus;
import io.boodskap.iot.spi.cache.ICache;
import io.boodskap.iot.spi.cache.ICacheFactory;
import io.boodskap.iot.spi.grid.IGrid;
import io.boodskap.iot.spi.grid.IGridFactory;
import io.boodskap.iot.spi.grid.INode;
import io.boodskap.iot.spi.service.IService;
import io.boodskap.iot.spi.storage.IDynamicStorage;
import io.boodskap.iot.spi.storage.IDynamicStorageFactory;
import io.boodskap.iot.spi.storage.IRawStorage;
import io.boodskap.iot.spi.storage.IRawStorageFactory;
import io.boodskap.iot.spi.storage.IStorage;
import io.boodskap.iot.spi.storage.IStorageFactory;
import io.boodskap.iot.spi.storage.policy.wrapper.DynamicStorageFactory;
import io.boodskap.iot.spi.storage.policy.wrapper.RawStorageFactory;
import io.boodskap.iot.spi.storage.policy.wrapper.StorageFactory;

public class BoodskapSystem {

	private static final Logger LOG = LoggerFactory.getLogger(BoodskapSystem.class);
	
	public static final String ID_PUB_KEY = "fe0228fa-9d49-11e9-a2a3-2a2ae2dbcce4";
	public static final String ID_PRI_KEY = "fe022db4-9d49-11e9-a2a3-2a2ae2dbcce4";
	public static final String ID_SALT = "fe022f30-9d49-11e9-a2a3-2a2ae2dbcce4";
	public static final String ID_LIC_PUB_KEY = "a82ce2be-9d51-11e9-a2a3-2a2ae2dbcce4";
	public static final String ID_LICENSE = "f36fc440-9d50-11e9-a2a3-2a2ae2dbcce4";
	public static final String ID_SECRET_KEY = "bdfeb762-adcc-11e9-a2a3-2a2ae2dbcce4";
	public static final String ID_ACCOUNT_DOMAINKEY = "c1db2816-a5d4-11e9-a2a3-2a2ae2dbcce4";
	public static final String ID_LICENSE_KEY = "13982d82-b2b1-11e9-a2a3-2a2ae2dbcce4";
	
	private static final BoodskapSystem instance = new BoodskapSystem();
	private static final ReentrantLock lock = new ReentrantLock(true);
	public static final Map<String, Object> statistics = new HashMap<>();

	private BoodskapConfiguration config;
	private IGridFactory gridManager;
	private ICacheFactory cacheManager;
	private final StorageFactory storageManager = new StorageFactory();
	private final RawStorageFactory rawStorageManager = new RawStorageFactory();
	private final DynamicStorageFactory dynamicStorageManager = new DynamicStorageFactory();
	private final EventBus bus = new EventBus();
	
	private final Set<IService> services = new HashSet<>();
	
	private static INode node;
	
	private File configFolder;
	private File configFile;
	private File homeDir;
	private File dataDir;
	private PublicKey publicKey;
	private PrivateKey privateKey;
	private byte[] publicKeyData;
	private byte[] passwordSalt;
	private IClusterLicense license;
	private boolean stopped;
	
	public static final String LOGO = "\n" + 
			"  ____     ____     ____    _____     _____   _  __             _____             _____           _______ \n" + 
			" |  _ \\   / __ \\   / __ \\  |  __ \\   / ____| | |/ /     /\\     |  __ \\           |_   _|         |__   __|\n" + 
			" | |_) | | |  | | | |  | | | |  | | | (___   | ' /     /  \\    | |__) |  ______    | |     ___      | |   \n" + 
			" |  _ <  | |  | | | |  | | | |  | |  \\___ \\  |  <     / /\\ \\   |  ___/  |______|   | |    / _ \\     | |   \n" + 
			" | |_) | | |__| | | |__| | | |__| |  ____) | | . \\   / ____ \\  | |                _| |_  | (_) |    | |   \n" + 
			" |____/   \\____/   \\____/  |_____/  |_____/  |_|\\_\\ /_/    \\_\\ |_|               |_____|  \\___/     |_|   \n" + 
			"";
	
	private BoodskapSystem() {
	}
	
	public static final BoodskapSystem get() {
		return instance;
	}
	
	public static INode node() {
		if(null == node) {
			node = BoodskapSystem.grid().thisNode();
		}
		return node;
	}

	protected void close() {
		
		if(!stopped && lock.tryLock()) {
			
			try {
				
				LOG.warn("Shutting down...");
				
				try{if(null != gridManager) gridManager.dispose();}catch(Exception ex) {LOG.warn("Error while disposing", ex);}
				try{if(null != cacheManager) cacheManager.dispose();}catch(Exception ex) {LOG.warn("Error while disposing", ex);}
				try{storageManager.dispose();}catch(Exception ex) {LOG.warn("Error while disposing", ex);}
				try{rawStorageManager.dispose();}catch(Exception ex) {LOG.warn("Error while disposing", ex);}
				try{dynamicStorageManager.dispose();}catch(Exception ex) {LOG.warn("Error while disposing", ex);}
				
				for(IService service : services) {
					try{service.stop();}catch(Exception ex) {LOG.warn("Error while disposing", ex);}
				}
				
				services.clear();
				
				gridManager = null;
				cacheManager = null;
				
				LOG.warn("Shutdown complete.");
				
				stopped = true;

			}finally {
				lock.unlock();
			}
			
		}
		
	}
	
	@Subscribe
	public void handleDeadEvent(DeadEvent e) {
	    LOG.warn(String.format("No event subscription for %s[%s], sender:%s", e.getEvent().getClass().getName(), e.getEvent(),  e.getSource().getClass().getName()));
	}
	
	public static String nodeId() {
		return node().instanceId().toString();
	}

	public static String nodeUid() {
		return node().consistentId().toString();
	}

	public BoodskapConfiguration getConfig() {
		return config;
	}
	
	public void setConfig(BoodskapConfiguration config) {
		this.config = config;
	}

	public IGridFactory getGridManager() {
		return gridManager;
	}

	protected void setGridManager(IGridFactory gridManager) {
		this.gridManager = gridManager;
	}

	public ICacheFactory getCacheManager() {
		return cacheManager;
	}

	protected void setCacheManager(ICacheFactory cacheManager) {
		this.cacheManager = cacheManager;
	}

	public IStorageFactory getStorageManager() {
		return storageManager;
	}

	protected void setStorageManager(IStorageFactory storageManager) {
		this.storageManager.setImplementation(storageManager);
	}

	public IRawStorageFactory getRawStorageManager() {
		return rawStorageManager;
	}

	protected void setRawStorageManager(IRawStorageFactory rawStorageManager) {
		this.rawStorageManager.setImplementation(rawStorageManager);
	}
	
	protected void setLicense(IClusterLicense license) {
		this.license = license;
	}
	
	public static IClusterLicense license() {
		return instance.license;
	}
	
	public static boolean isLicensed() {
		IClusterLicense lic = license();
		return (null != lic && lic.getStatus() == LicenseStatus.ACTIVE);
	}

	public static boolean isActivated() {
		IClusterLicense lic = license();
		return (null != lic);
	}

	public IDynamicStorageFactory getDynamicStorageManager() {
		return dynamicStorageManager;
	}

	public void setDynamicStorageManager(IDynamicStorageFactory dynamicStorageManager) {
		this.dynamicStorageManager.setImplementation(dynamicStorageManager);
	}
	
	public static BoodskapConfiguration config() {
		return instance.config;
	}
	
	public static EventBus bus() {
		return instance.bus;
	}

	public static IGrid grid() throws GridException {
		return instance.gridManager.getGrid();
	}

	public static ICache cache() throws CacheException {
		return instance.cacheManager.getCache();
	}

	public static IStorage storage() throws StorageException {
		return instance.storageManager.getStorage();
	}

	public static IRawStorage rawStorage() throws StorageException {
		return instance.rawStorageManager.getRawStorage();
	}
	
	public static IDynamicStorage dynamicStorage() throws StorageException{
		return instance.dynamicStorageManager.getDynamicStorage();
	}
	
	public static void broadcast(final PlatformEvent event) {
		broadcast(event, true);
	}
	
	public static void broadcast(final PlatformEvent event, boolean includeThis) {
		
		LOG.info(String.format("posting event:%s to:%s nodes", event.getClass().getSimpleName(), includeThis ? "all": "other"));
		
		grid().broadcast(new Runnable() {	
			@Override
			public void run() {
				BoodskapSystem.bus().post(event);
			}
		}, includeThis);
	}

	public Set<IService> getServices() {
		return services;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	protected void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	public byte[] getPublicKeyData() {
		return publicKeyData;
	}

	public void setPublicKeyData(byte[] publicKeyData) {
		this.publicKeyData = new byte[publicKeyData.length];
		System.arraycopy(publicKeyData, 0, this.publicKeyData, 0, publicKeyData.length);
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	protected void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public byte[] getPasswordSalt() {
		return passwordSalt;
	}

	protected void setPasswordSalt(byte[] passwordSalt) {
		this.passwordSalt = new byte[passwordSalt.length];
		System.arraycopy(passwordSalt, 0, this.passwordSalt, 0, passwordSalt.length);
	}

	public File getConfigFolder() {
		return configFolder;
	}

	protected void setConfigFolder(File configFolder) {
		this.configFolder = configFolder;
	}

	public File getConfigFile() {
		return configFile;
	}

	protected void setConfigFile(File configFile) {
		this.configFile = configFile;
	}

	public File getHomeDir() {
		return homeDir;
	}

	protected void setHomeDir(File homeDir) {
		this.homeDir = homeDir;
	}

	public File getDataDir() {
		return dataDir;
	}

	protected void setDataDir(File dataDir) {
		this.dataDir = dataDir;
	}

}
