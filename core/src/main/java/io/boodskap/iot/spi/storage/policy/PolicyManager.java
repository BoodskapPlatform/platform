package io.boodskap.iot.spi.storage.policy;

import io.boodskap.iot.AuthType;
import io.boodskap.iot.CacheStore;
import io.boodskap.iot.DomainSettings;
import io.boodskap.iot.IAuthToken;
import io.boodskap.iot.StorageException;

public class PolicyManager {
	
	private static boolean enabled = true;

	private PolicyManager() {
	}
	
	public static void setEnabled(boolean enabled) {
		PolicyManager.enabled = enabled;
	}
	
	private static IAuthToken getAuthToken() {
		
		final IAuthToken t = IAuthToken.get();
		
		if(null == t) throw new StorageException("Not authenticated");
		if(t.isExpired()) throw new StorageException("Session expired");
		
		return t;
	}
	
	private static IAuthToken getAdminAuthToken() {
		
		final IAuthToken t = getAuthToken();
		
		if(!t.isAdmin()) throw new StorageException("Need admin access");
		
		return t;
	}
	

	public static void checkReadAccess() {
		if(!enabled || IAuthToken.isEngine()) return;
		checkReadAccess(getAdminAuthToken().getDomainKey(), null);
	}

	public static void checkReadAccess(String domainKey) {
		if(!enabled || IAuthToken.isEngine()) return;
		checkReadAccess(domainKey, null);
	}

	public static void checkReadAccess(String domainKey, String organizationId) {
		
		if(!enabled || IAuthToken.isEngine()) return;
		
		final IAuthToken t = getAuthToken();
		
		if(t.getAuthType() == AuthType.PLATFORM) return; //Grants all permissions
		if(t.getAuthType() == AuthType.DOMAIN && t.hasDomainKey(domainKey)) return; //Grants all domain permissions
		if(null != organizationId && t.getAuthType() == AuthType.ORG && t.hasDomainKey(domainKey) && t.hasOrganizationId(organizationId)) return; //Grants all organization permissions
		
		DomainSettings s = (null == organizationId) ? CacheStore.get().getSettings(domainKey) : CacheStore.get().getOrgSettings(domainKey, organizationId);
		
		if(t.isAdmin() && (s.isCanAdminDelete() || s.isCanAdminWrite() || s.isCanAdminRead())) return; // If admin has delete, write access for this domain
		
		if(!t.hasDomainKey(domainKey)) throw new StorageException(String.format("Domain:%s not authorized", domainKey));
		
		if(null != organizationId && !t.hasOrganizationId(organizationId)) throw new StorageException(String.format("Organization:%s.%s not authorized", domainKey, organizationId));
		
		if(t.isUser() && (s.isCanUserDelete() || s.isCanUserWrite() || s.isCanUserRead())) return;
		
		if(t.isOrganizationUser() && (s.isCanOrgUserDelete() || s.isCanOrgUserWrite() || s.isCanOrgUserRead())) return;
		
		if(t.isOrganizationAdmin() && (s.isCanOrgAdminDelete() || s.isCanOrgAdminWrite() || s.isCanOrgAdminRead())) return;
		
		if(t.isDomainAdmin() && (s.isCanDomainAdminDelete() || s.isCanDomainAdminWrite() || s.isCanDomainAdminRead())) return;
		
		if(t.isDeveloper() && (s.isCanDeveloperDelete() || s.isCanDeveloperWrite() || s.isCanDeveloperRead())) return;
		
		if(null == organizationId) {
			throw new StorageException(String.format("Domain:%s not authorized", domainKey));
		}else {
			throw new StorageException(String.format("Domain:%s Organization:%s not authorized", domainKey, organizationId));
		}

	}

	public static void checkWriteAccess() throws StorageException {
		if(!enabled || IAuthToken.isEngine()) return;
		checkWriteAccess(getAdminAuthToken().getDomainKey(), null);
	}
	
	public static void checkWriteAccess(String domainKey) throws StorageException {
		if(!enabled || IAuthToken.isEngine()) return;
		checkWriteAccess(domainKey, null);
	}
	
	public static void checkWriteAccess(String domainKey, String organizationId) throws StorageException {
		
		if(!enabled || IAuthToken.isEngine()) return;
		
		final IAuthToken t = getAuthToken();
		
		if(t.getAuthType() == AuthType.PLATFORM) return; //Grants all permissions
		if(t.getAuthType() == AuthType.DOMAIN && t.hasDomainKey(domainKey)) return; //Grants all domain permissions
		if(null != organizationId && t.getAuthType() == AuthType.ORG && t.hasDomainKey(domainKey) && t.hasOrganizationId(organizationId)) return; //Grants all organization permissions
		
		DomainSettings s = (null == organizationId) ? CacheStore.get().getSettings(domainKey) : CacheStore.get().getOrgSettings(domainKey, organizationId);
		
		if(t.isAdmin() && (s.isCanAdminDelete() || s.isCanAdminWrite())) return; // If admin has delete, write access for this domain
		
		if(!t.hasDomainKey(domainKey)) throw new StorageException(String.format("Domain:%s not authorized", domainKey));
		
		if(null != organizationId && !t.hasOrganizationId(organizationId)) throw new StorageException(String.format("Organization:%s.%s not authorized", domainKey, organizationId));
		
		if(t.isUser() && (s.isCanUserDelete() || s.isCanUserWrite())) return;
		
		if(t.isOrganizationUser() && (s.isCanOrgUserDelete() || s.isCanOrgUserWrite())) return;
		
		if(t.isOrganizationAdmin() && (s.isCanOrgAdminDelete() || s.isCanOrgAdminWrite())) return;
		
		if(t.isDomainAdmin() && (s.isCanDomainAdminDelete() || s.isCanDomainAdminWrite())) return;
		
		if(t.isDeveloper() && (s.isCanDeveloperDelete() || s.isCanDeveloperWrite())) return;
		
		if(null == organizationId) {
			throw new StorageException(String.format("Domain:%s not authorized", domainKey));
		}else {
			throw new StorageException(String.format("Domain:%s Organization:%s not authorized", domainKey, organizationId));
		}

	}

	public static void checkDeleteAccess() {
		if(!enabled || IAuthToken.isEngine()) return;
		checkDeleteAccess(getAdminAuthToken().getDomainKey(), null);
	}

	public static void checkDeleteAccess(String domainKey) {
		if(!enabled || IAuthToken.isEngine()) return;
		checkDeleteAccess(domainKey, null);
	}

	public static void checkDeleteAccess(String domainKey, String organizationId) {
		
		if(!enabled || IAuthToken.isEngine()) return;
		
		final IAuthToken t = getAuthToken();
		
		if(t.getAuthType() == AuthType.PLATFORM) return; //Grants all permissions
		if(t.getAuthType() == AuthType.DOMAIN && t.hasDomainKey(domainKey)) return; //Grants all domain permissions
		if(null != organizationId && t.getAuthType() == AuthType.ORG && t.hasDomainKey(domainKey) && t.hasOrganizationId(organizationId)) return; //Grants all organization permissions
		
		DomainSettings s = (null == organizationId) ? CacheStore.get().getSettings(domainKey) : CacheStore.get().getOrgSettings(domainKey, organizationId);
		
		if(t.isAdmin() && (s.isCanAdminDelete())) return; // If admin has delete, write access for this domain
		
		if(!t.hasDomainKey(domainKey)) throw new StorageException(String.format("Domain:%s not authorized", domainKey));
		
		if(null != organizationId && !t.hasOrganizationId(organizationId)) throw new StorageException(String.format("Organization:%s.%s not authorized", domainKey, organizationId));
		
		if(t.isUser() && (s.isCanUserDelete())) return;
		
		if(t.isOrganizationUser() && (s.isCanOrgUserDelete())) return;
		
		if(t.isOrganizationAdmin() && (s.isCanOrgAdminDelete())) return;
		
		if(t.isDomainAdmin() && (s.isCanDomainAdminDelete())) return;
		
		if(t.isDeveloper() && (s.isCanDeveloperDelete())) return;
		
		if(null == organizationId) {
			throw new StorageException(String.format("Domain:%s not authorized", domainKey));
		}else {
			throw new StorageException(String.format("Domain:%s Organization:%s not authorized", domainKey, organizationId));
		}

	}

	
}
