package io.boodskap.iot.spi.storage.policy;

import io.boodskap.iot.CacheStore;
import io.boodskap.iot.IAuthToken;
import io.boodskap.iot.StorageException;

public class PolicyManager {
	
	private static boolean enabled = true;

	private PolicyManager() {
	}
	
	public static void setEnabled(boolean enabled) {
		PolicyManager.enabled = enabled;
	}
	
	public static void checkAdmin() {
		if(enabled && !IAuthToken.get().isAdmin()) throw new StorageException("Admin access needed");
	}
	
	public static void checkDomainAdmin() {
		if(enabled && !IAuthToken.get().isDomainAdmin()) throw new StorageException("Domain admin access needed");
	}
	
	public static void checkDomainAccess(String domainKey) {
		if(enabled && !IAuthToken.get().hasDomainKey(domainKey))throw new StorageException(String.format("Domain:%s not authorized", domainKey));
	}
	
	public static void checkDomainAdminAccess(String domainKey) {
		
		if(!enabled) return;		
		
		checkDomainAdmin();
		checkDomainAccess(domainKey);
	}
	
	public static void checkWriteAccess(String domainKey) {
		
		if(!enabled) return;
		
		checkDomainAccess(domainKey);
		
		switch(IAuthToken.get().getROLE()) {
		case ORGUSER:
			if(!CacheStore.get().getSettings(domainKey).isCanOrgUserWrite()) {
				throw new StorageException(String.format("Write access for domain %s denied", domainKey));
			}
		default:
		
		}
	}

	public static void checkDeleteAccess(String domainKey) {
		
		if(!enabled) return;
		
		checkDomainAccess(domainKey);
		
		switch(IAuthToken.get().getROLE()) {
		case ORGUSER:
			if(!CacheStore.get().getSettings(domainKey).isCanOrgUserDelete()) {
				throw new StorageException(String.format("Write access for domain %s denied", domainKey));
			}
		default:
		
		}
	}

	
}
