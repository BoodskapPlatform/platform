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
package io.boodskap.iot.spi.storage;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.*;
import io.boodskap.iot.model.*;

public interface IStorage extends IBaseStorage {
	
	public <T extends IDeviceCounter> DeviceCounterDAO<T> getDeviceCounterDAO();
	
	public <T extends IAlexa> AlexaDAO<T> getAlexaDAO() throws StorageException;
	
	public <T extends IAsset> AssetDAO<T> getAssetDAO() throws StorageException;
	
	public <T extends IAssetFile> AssetFileDAO<T> getAssetFileDAO() throws StorageException;
	
	public <T extends IAssetDevice> AssetDeviceDAO<T> getAssetDeviceDAO() throws StorageException;
	
	public <T extends IAssetGroup> AssetGroupDAO<T> getAssetGroupDAO() throws StorageException;
	
	public <T extends IAssetGroupMember> AssetGroupMemberDAO<T> getAssetGroupMemberDAO() throws StorageException;
	
	public <T extends IBinaryRule> BinaryRuleDAO<T> getBinaryRuleDAO() throws StorageException;
	
	public <T extends ICounter> CounterDAO<T> getCounterDAO() throws StorageException;
	
	public <T extends IDomainCounter> DomainCounterDAO<T> getDomainCounterDAO() throws StorageException;
	
	public <T extends IDeviceCommand> DeviceCommandDAO<T> getDeviceCommandDAO() throws StorageException;
	
	public <T extends IDevice> DeviceDAO<T> getDeviceDAO() throws StorageException;
	
	public <T extends IDeviceFile> DeviceFileDAO<T> getDeviceFileDAO() throws StorageException;
	
	public <T extends IDeviceFriend> DeviceFriendDAO<T> getDeviceFriendDAO() throws StorageException;
	
	public <T extends IDeviceGroup> DeviceGroupDAO<T> getDeviceGroupDAO() throws StorageException;
	
	public <T extends IDeviceGroupMember> DeviceGroupMemberDAO<T> getDeviceGroupMemberDAO() throws StorageException;
	
	public <T extends IDeviceModel> DeviceModelDAO<T> getDeviceModelDAO() throws StorageException;
	
	public <T extends IDomainAccess> DomainAccessDAO<T> getDomainAccessDAO() throws StorageException;
	
	public <T extends IDomainApiKey> DomainApiKeyDAO<T> getDomainApiKeyDAO() throws StorageException;
	
	public <T extends IDomainAssetGroup> DomainAssetGroupDAO<T> getDomainAssetGroupDAO() throws StorageException;
	
	public <T extends IDomainAssetGroupMember> DomainAssetGroupMemberDAO<T> getDomainAssetGroupMemberDAO() throws StorageException;
	
	public <T extends IDomain> DomainDAO<T> getDomainDAO() throws StorageException;
	
	public <T extends IDomainDeviceGroup> DomainDeviceGroupDAO<T> getDomainDeviceGroupDAO() throws StorageException;
	
	public <T extends IDomainDeviceGroupMember> DomainDeviceGroupMemberDAO<T> getDomainDeviceGroupMemberDAO() throws StorageException;
	
	public <T extends IDomainFile> DomainFileDAO<T> getDomainFileDAO() throws StorageException;
	
	public <T extends IDomainLicense> DomainLicenseDAO<T> getDomainLicenseDAO() throws StorageException;
	
	public <T extends IDomainNode> DomainNodeDAO<T> getDomainNodeDAO() throws StorageException;
	
	public <T extends IDomainRule> DomainRuleDAO<T> getDomainRuleDAO() throws StorageException;
	
	public <T extends IDomainUserGroup> DomainUserGroupDAO<T> getDomainUserGroupDAO() throws StorageException;
	
	public <T extends IDomainUserGroupMember> DomainUserGroupMemberDAO<T> getDomainUserGroupMemberDAO() throws StorageException;
	
	public <T extends IEmailGateway> EmailGatewayDAO<T> getEmailGatewayDAO() throws StorageException;
	
	public <T extends IEvent> EventDAO<T> getEventDAO() throws StorageException;
	
	public <T extends IEventRegistration> EventRegistrationDAO<T> getEventRegistrationDAO() throws StorageException;
	
	public <T extends IFCMDevice> FCMDeviceDAO<T> getFCMDeviceDAO() throws StorageException;
	
	public <T extends IFCMGateway> FCMGatewayDAO<T> getFCMGatewayDAO() throws StorageException;
	
	public <T extends IFirmware> FirmwareDAO<T> getFirmwareDAO() throws StorageException;
	
	public <T extends IGlobalData> GlobalDataDAO<T> getGlobalDataDAO() throws StorageException;
	
	public <T extends ILinkedDomain> LinkedDomainDAO<T> getLinkedDomainDAO() throws StorageException;
	
	public <T extends ILookup> LookupDAO<T> getLookupDAO() throws StorageException;
	
	public <T extends IMessageRule> MessageRuleDAO<T> getMessageRuleDAO() throws StorageException;
	
	public <T extends INamedRule> NamedRuleDAO<T> getNamedRuleDAO() throws StorageException;
	
	public <T extends INodeScheduledRule> NodeScheduledRuleDAO<T> getNodeScheduledRuleDAO() throws StorageException;
	
	public <T extends IOfflineSnap> OfflineSnapDAO<T> getOfflineSnapDAO() throws StorageException;
	
	public <T extends IOfflineStream> OfflineStreamDAO<T> getOfflineStreamDAO() throws StorageException;
	
	public <T extends IOrganizationAsset> OrganizationAssetDAO<T> getOrganizationAssetDAO() throws StorageException;
	
	public <T extends IOrganization> OrganizationDAO<T> getOrganizationDAO() throws StorageException;
	
	public <T extends IOrganizationDevice> OrganizationDeviceDAO<T> getOrganizationDeviceDAO() throws StorageException;
	
	public <T extends IOTABatch> OTABatchDAO<T> getOTABatchDAO() throws StorageException;
	
	public <T extends IOTABatchMember> OTABatchMemberDAO<T> getOTABatchMemberDAO() throws StorageException;
	
	public <T extends IOTADeviceBatch> OTADeviceBatchDAO<T> getOTADeviceBatchDAO() throws StorageException;
	
	public <T extends IOTADeviceBatchMember> OTADeviceBatchMemberDAO<T> getOTADeviceBatchMemberDAO() throws StorageException;
	
	public <T extends IOTAModelBatch> OTAModelBatchDAO<T> getOTAModelBatchDAO() throws StorageException;
	
	public <T extends IOTAModelBatchMember> OTAModelBatchMemberDAO<T> getOTAModelBatchMemberDAO() throws StorageException;
	
	public <T extends IOutgoingCommand> OutgoingCommandDAO<T> getOutgoingCommandDAO() throws StorageException;
	
	public <T extends IOutgoingEmail> OutgoingEmailDAO<T> getOutgoingEmailDAO() throws StorageException;
	
	public <T extends IOutgoingFCM> OutgoingFCMDAO<T> getOutgoingFCMDAO() throws StorageException;
	
	public <T extends IOutgoingSms> OutgoingSmsDAO<T> getOutgoingSmsDAO() throws StorageException;
	
	public <T extends IOutgoingVoice> OutgoingVoiceDAO<T> getOutgoingVoiceDAO() throws StorageException;
	
	public <T extends IPlugin> PluginDAO<T> getPluginDAO() throws StorageException;
	
	public <T extends IProperty> PropertyDAO<T> getPropertyDAO() throws StorageException;
	
	public <T extends ISystemProperty> SystemPropertyDAO<T> getSystemPropertyDAO() throws StorageException;
	
	public <T extends IPublicFile> PublicFileDAO<T> getPublicFileDAO() throws StorageException;
	
	public <T extends IRawMessage> RawMessageDAO<T> getRawMessageDAO() throws StorageException;
	
	public <T extends IReportedDevice> ReportedDeviceDAO<T> getReportedDeviceDAO() throws StorageException;
	
	public <T extends IScheduledRule> ScheduledRuleDAO<T> getScheduledRuleDAO() throws StorageException;
	
	public <T extends ISentEmail> SentEmailDAO<T> getSentEmailDAO() throws StorageException;
	
	public <T extends ISentFCM> SentFCMDAO<T> getSentFCMDAO() throws StorageException;
	
	public <T extends ISentSms> SentSmsDAO<T> getSentSmsDAO() throws StorageException;
	
	public <T extends ISentVoice> SentVoiceDAO<T> getSentVoiceDAO() throws StorageException;
	
	public <T extends ISystemTemplate> SystemTemplateDAO<T> getSystemTemplateDAO() throws StorageException;
	
	public <T extends ITemplate> TemplateDAO<T> getTemplateDAO() throws StorageException;
	
	public <T extends ITwilioGateway> TwilioGatewayDAO<T> getTwilioGatewayDAO() throws StorageException;
	
	public <T extends IUserAssetGroup> UserAssetGroupDAO<T> getUserAssetGroupDAO() throws StorageException;
	
	public <T extends IUserAssetGroupMember> UserAssetGroupMemberDAO<T> getUserAssetGroupMemberDAO() throws StorageException;
	
	public <T extends IUser> UserDAO<T> getUserDAO() throws StorageException;
	
	public <T extends IUserDeviceGroup> UserDeviceGroupDAO<T> getUserDeviceGroupDAO() throws StorageException;
	
	public <T extends IUserDeviceGroupMember> UserDeviceGroupMemberDAO<T> getUserDeviceGroupMemberDAO() throws StorageException;
	
	public <T extends IUserGroup> UserGroupDAO<T> getUserGroupDAO() throws StorageException;
	
	public <T extends IUserGroupMember> UserGroupMemberDAO<T> getUserGroupMemberDAO() throws StorageException;
	
	public <T extends IDatabaseMetaData> DatabaseMetaDataDAO<T> getDatabaseMetaDataDAO() throws StorageException;

	public <T extends IDatabaseTable> DatabaseTableDAO<T> getDatabaseTableDAO() throws StorageException;

	public <T extends ILocation> LocationDAO<T> getLocationDAO() throws StorageException;
	
	public <T extends ILocationHistory> LocationHistoryDAO<T> getLocationHistoryDAO() throws StorageException;

	public <T extends IEntityFile> EntityFileDAO<T> getEntityFileDAO() throws StorageException;

	public <T extends IUserFile> UserFileDAO<T> getUserFileDAO() throws StorageException;

	public <T extends IDomainEntity> DomainEntityDAO<T> getDomainEntityDAO() throws StorageException;

	public <T extends IDomainJsonEntity> DomainJsonEntityDAO<T> getDomainJsonEntityDAO() throws StorageException;

	public <T extends IOrganizationFile> OrganizationFileDAO<T> getOrganizationFileDAO() throws StorageException;

	public <T extends IOTAModelVersionBatch> OTAModelVersionBatchDAO<T> getOTAModelVersionBatchDAO() throws StorageException;

	public <T extends IOTAModelVersionBatchMember> OTAModelVersionBatchMemberDAO<T> getOTAModelVersionBatchMemberDAO() throws StorageException;

	public <T extends ICameraDevice> CameraDeviceDAO<T> getCameraDeviceDAO() throws StorageException;

	public <T extends IOfflineStreamSession> OfflineStreamSessionDAO<T> getOfflineStreamSessionDAO() throws StorageException;

	public <T extends IDomainRole> DomainRoleDAO<T> getDomainRoleDAO() throws StorageException;

	public <T extends IOrganizationRole> OrganizationRoleDAO<T> getOrganizationRoleDAO() throws StorageException;

	public <T extends IOrganizationUserRole> OrganizationUserRoleDAO<T> getOrganizationUserRoleDAO() throws StorageException;

	public <T extends IUserRole> UserRoleDAO<T> getUserRoleDAO() throws StorageException;

	public <T extends IOrganizationUser> OrganizationUserDAO<T> getOrganizationUserDAO() throws StorageException;

	public <T extends IUserDomain> UserDomainDAO<T> getUserDomainDAO() throws StorageException;

	public <T extends ISystemFile>  SystemFileDAO<T> getSystemFileDAO() throws StorageException;

	public <T extends IBillingContact> BillingContactDAO<T> getBillingContactDAO() throws StorageException;

	public <T extends IBillingInvoice> BillingInvoiceDAO<T> getBillingInvoiceDAO() throws StorageException;

	public <T extends IBillingSchedule> BillingScheduleDAO<T> getBillingScheduleDAO() throws StorageException;

	public <T extends IBillingTemplate> BillingTemplateDAO<T> getBillingTemplateDAO() throws StorageException;

	public <T extends ICluster>  ClusterDAO<T> getClusterDAO() throws StorageException;

	public <T extends IClusterMachine>  ClusterMachineDAO<T> getClusterMachineDAO() throws StorageException;

	public <T extends IClusterLicense> ClusterLicenseDAO<T> getClusterLicenseDAO() throws StorageException;

	public <T extends IMessageCounter>  MessageCounterDAO<T> getMessageCounterDAO() throws StorageException;

	public <T extends IDeviceMessageCounter>  DeviceMessageCounterDAO<T> getDeviceMessageCounterDAO() throws StorageException;

	public <T extends IReceivedCommand> ReceivedCommandDAO<T> getReceivedCommandDAO() throws StorageException;

	public <T extends IDomainGroovyClass> DomainGroovyClassDAO<T> getDomainGroovyClassDAO() throws StorageException;

	public <T extends IDomainJarClass> DomainJarClassDAO<T> getDomainJarClassDAO() throws StorageException;

	public <T extends IDomainJarFile> DomainJarFileDAO<T> getDomainJarFileDAO() throws StorageException;

	public <T extends IGroovyClass> GroovyClassDAO<T> getGroovyClassDAO() throws StorageException;

	public <T extends IJarClass> JarClassDAO<T> getJarClassDAO() throws StorageException;

	public <T extends IJarFile> JarFileDAO<T> getJarFileDAO() throws StorageException;

	public <T extends IClassLoader>  ClassLoaderDAO<T> getClassLoaderDAO() throws StorageException;

	public <T extends IDomainClassLoader>  DomainClassLoaderDAO<T> getDomainClassLoaderDAO() throws StorageException;

	public <T extends IGroovyArchiveFile> GroovyArchiveFileDAO<T> getGroovyArchiveFileDAO() throws StorageException;

	public <T extends IDomainGroovyArchiveFile> DomainGroovyArchiveFileDAO<T> getDomainGroovyArchiveFileDAO() throws StorageException;

}
