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
	
	public <T extends IAssetGroup> AssetGroupDAO<T> getAssetGroupDAO();
	
	public <T extends IAssetGroupMember> AssetGroupMemberDAO<T> getAssetGroupMemberDAO();
	
	public <T extends IBinaryRule> BinaryRuleDAO<T> getBinaryRuleDAO();
	
	public <T extends ICounter> CounterDAO<T> getCounterDAO();
	
	public <T extends IDeviceCommand> DeviceCommandDAO<T> getDeviceCommandDAO();
	
	public <T extends IDevice> DeviceDAO<T> getDeviceDAO();
	
	public <T extends IDeviceFile> DeviceFileDAO<T> getDeviceFileDAO();
	
	public <T extends IDeviceFriend> DeviceFriendDAO<T> getDeviceFriendDAO();
	
	public <T extends IDeviceGroup> DeviceGroupDAO<T> getDeviceGroupDAO();
	
	public <T extends IDeviceGroupMember> DeviceGroupMemberDAO<T> getDeviceGroupMemberDAO();
	
	public <T extends IDeviceModel> DeviceModelDAO<T> getDeviceModelDAO();
	
	public <T extends IDomainAccess> DomainAccessDAO<T> getDomainAccessDAO();
	
	public <T extends IDomainApiKey> DomainApiKeyDAO<T> getDomainApiKeyDAO();
	
	public <T extends IDomainAssetGroup> DomainAssetGroupDAO<T> getDomainAssetGroupDAO();
	
	public <T extends IDomainAssetGroupMember> DomainAssetGroupMemberDAO<T> getDomainAssetGroupMemberDAO();
	
	public <T extends IDomain> DomainDAO<T> getDomainDAO();
	
	public <T extends IDomainDeviceGroup> DomainDeviceGroupDAO<T> getDomainDeviceGroupDAO();
	
	public <T extends IDomainDeviceGroupMember> DomainDeviceGroupMemberDAO<T> getDomainDeviceGroupMemberDAO();
	
	public <T extends IDomainFile> DomainFileDAO<T> getDomainFileDAO();
	
	public <T extends IDomainLicense> DomainLicenseDAO<T> getDomainLicenseDAO();
	
	public <T extends IDomainNode> DomainNodeDAO<T> getDomainNodeDAO();
	
	public <T extends IDomainRule> DomainRuleDAO<T> getDomainRuleDAO();
	
	public <T extends IDomainUserGroup> DomainUserGroupDAO<T> getDomainUserGroupDAO();
	
	public <T extends IDomainUserGroupMember> DomainUserGroupMemberDAO<T> getDomainUserGroupMemberDAO();
	
	public <T extends IEmailGateway> EmailGatewayDAO<T> getEmailGatewayDAO();
	
	public <T extends IEvent> EventDAO<T> getEventDAO();
	
	public <T extends IEventRegistration> EventRegistrationDAO<T> getEventRegistrationDAO();
	
	public <T extends IFCMDevice> FCMDeviceDAO<T> getFCMDeviceDAO();
	
	public <T extends IFCMGateway> FCMGatewayDAO<T> getFCMGatewayDAO();
	
	public <T extends IFirmware> FirmwareDAO<T> getFirmwareDAO();
	
	public <T extends IGlobalData> GlobalDataDAO<T> getGlobalDataDAO();
	
	public <T extends ILinkedDomain> LinkedDomainDAO<T> getLinkedDomainDAO();
	
	public <T extends ILookup> LookupDAO<T> getLookupDAO();
	
	public <T extends IMessageRule> MessageRuleDAO<T> getMessageRuleDAO();
	
	public <T extends INamedRule> NamedRuleDAO<T> getNamedRuleDAO();
	
	public <T extends INodeScheduledRule> NodeScheduledRuleDAO<T> getNodeScheduledRuleDAO();
	
	public <T extends IOfflineSnap> OfflineSnapDAO<T> getOfflineSnapDAO();
	
	public <T extends IOfflineStream> OfflineStreamDAO<T> getOfflineStreamDAO();
	
	public <T extends IOrganizationAsset> OrganizationAssetDAO<T> getOrganizationAssetDAO();
	
	public <T extends IOrganization> OrganizationDAO<T> getOrganizationDAO();
	
	public <T extends IOrganizationDevice> OrganizationDeviceDAO<T> getOrganizationDeviceDAO();
	
	public <T extends IOTABatch> OTABatchDAO<T> getOTABatchDAO();
	
	public <T extends IOTABatchMember> OTABatchMemberDAO<T> getOTABatchMemberDAO();
	
	public <T extends IOTADeviceBatch> OTADeviceBatchDAO<T> getOTADeviceBatchDAO();
	
	public <T extends IOTADeviceBatchMember> OTADeviceBatchMemberDAO<T> getOTADeviceBatchMemberDAO();
	
	public <T extends IOTAModelBatch> OTAModelBatchDAO<T> getOTAModelBatchDAO();
	
	public <T extends IOTAModelBatchMember> OTAModelBatchMemberDAO<T> getOTAModelBatchMemberDAO();
	
	public <T extends IOutgoingCommand> OutgoingCommandDAO<T> getOutgoingCommandDAO() throws StorageException;
	
	public <T extends IOutgoingEmail> OutgoingEmailDAO<T> getOutgoingEmailDAO();
	
	public <T extends IOutgoingFCM> OutgoingFCMDAO<T> getOutgoingFCMDAO();
	
	public <T extends IOutgoingSms> OutgoingSmsDAO<T> getOutgoingSmsDAO();
	
	public <T extends IOutgoingVoice> OutgoingVoiceDAO<T> getOutgoingVoiceDAO();
	
	public <T extends IPlugin> PluginDAO<T> getPluginDAO();
	
	public <T extends IProperty> PropertyDAO<T> getPropertyDAO();
	
	public <T extends ISystemProperty> SystemPropertyDAO<T> getSystemPropertyDAO();
	
	public <T extends IPublicFile> PublicFileDAO<T> getPublicFileDAO();
	
	public <T extends IRawMessage> RawMessageDAO<T> getRawMessageDAO();
	
	public <T extends IReportedDevice> ReportedDeviceDAO<T> getReportedDeviceDAO();
	
	public <T extends IScheduledRule> ScheduledRuleDAO<T> getScheduledRuleDAO();
	
	public <T extends ISentEmail> SentEmailDAO<T> getSentEmailDAO();
	
	public <T extends ISentFCM> SentFCMDAO<T> getSentFCMDAO();
	
	public <T extends ISentSms> SentSmsDAO<T> getSentSmsDAO();
	
	public <T extends ISentVoice> SentVoiceDAO<T> getSentVoiceDAO();
	
	public <T extends ISystemTemplate> SystemTemplateDAO<T> getSystemTemplateDAO();
	
	public <T extends ITemplate> TemplateDAO<T> getTemplateDAO();
	
	public <T extends ITwilioGateway> TwilioGatewayDAO<T> getTwilioGatewayDAO();
	
	public <T extends IUserAssetGroup> UserAssetGroupDAO<T> getUserAssetGroupDAO();
	
	public <T extends IUserAssetGroupMember> UserAssetGroupMemberDAO<T> getUserAssetGroupMemberDAO();
	
	public <T extends IUser> UserDAO<T> getUserDAO();
	
	public <T extends IUserDeviceGroup> UserDeviceGroupDAO<T> getUserDeviceGroupDAO();
	
	public <T extends IUserDeviceGroupMember> UserDeviceGroupMemberDAO<T> getUserDeviceGroupMemberDAO();
	
	public <T extends IUserGroup> UserGroupDAO<T> getUserGroupDAO();
	
	public <T extends IUserGroupMember> UserGroupMemberDAO<T> getUserGroupMemberDAO();
	
	public <T extends IDatabaseMetaData> DatabaseMetaDataDAO<T> getDatabaseMetaDataDAO();

	public <T extends IDatabaseTable> DatabaseTableDAO<T> getDatabaseTableDAO();

	public <T extends ILocation> LocationDAO<T> getLocationDAO();
	
	public <T extends ILocationHistory> LocationHistoryDAO<T> getLocationHistoryDAO();

	public <T extends IEntityFile> EntityFileDAO<T> getEntityFileDAO();

	public <T extends IUserFile> UserFileDAO<T> getUserFileDAO();

	public <T extends IDomainEntity> DomainEntityDAO<T> getDomainEntityDAO();

	public <T extends IDomainJsonEntity> DomainJsonEntityDAO<T> getDomainJsonEntityDAO();

	public <T extends IOrganizationFile> OrganizationFileDAO<T> getOrganizationFileDAO();

	public <T extends IOTAModelVersionBatch> OTAModelVersionBatchDAO<T> getOTAModelVersionBatchDAO();

	public <T extends IOTAModelVersionBatchMember> OTAModelVersionBatchMemberDAO<T> getOTAModelVersionBatchMemberDAO();

	public <T extends ICameraDevice> CameraDeviceDAO<T> getCameraDeviceDAO();

	public <T extends IOfflineStreamSession> OfflineStreamSessionDAO<T> getOfflineStreamSessionDAO();

	public <T extends IDomainRole> DomainRoleDAO<T> getDomainRoleDAO();

	public <T extends IOrganizationRole> OrganizationRoleDAO<T> getOrganizationRoleDAO();

	public <T extends IOrganizationUserRole> OrganizationUserRoleDAO<T> getOrganizationUserRoleDAO();

	public <T extends IUserRole> UserRoleDAO<T> getUserRoleDAO();

	public <T extends IOrganizationUser> OrganizationUserDAO<T> getOrganizationUserDAO();

	public <T extends IUserDomain> UserDomainDAO<T> getUserDomainDAO();

	public <T extends ISystemFile>  SystemFileDAO<T> getSystemFileDAO();

	public <T extends IBillingContact> BillingContactDAO<T> getBillingContactDAO();

	public <T extends IBillingInvoice> BillingInvoiceDAO<T> getBillingInvoiceDAO();

	public <T extends IBillingSchedule> BillingScheduleDAO<T> getBillingScheduleDAO();

	public <T extends IBillingTemplate> BillingTemplateDAO<T> getBillingTemplateDAO();

	public <T extends ICluster>  ClusterDAO<T> getClusterDAO();

	public <T extends IClusterMachine>  ClusterMachineDAO<T> getClusterMachineDAO();

	public <T extends IClusterLicense> ClusterLicenseDAO<T> getClusterLicenseDAO();

	public <T extends IMessageCounter>  MessageCounterDAO<T> getMessageCounterDAO();

	public <T extends IDeviceMessageCounter>  DeviceMessageCounterDAO<T> getDeviceMessageCounterDAO();

	public <T extends IReceivedCommand> ReceivedCommandDAO<T> getReceivedCommandDAO();

	public <T extends IDomainGroovyClass> DomainGroovyClassDAO<T> getDomainGroovyClassDAO();

	public <T extends IDomainJarClass> DomainJarClassDAO<T> getDomainJarClassDAO();

	public <T extends IDomainJarFile> DomainJarFileDAO<T> getDomainJarFileDAO();

	public <T extends IGroovyClass> GroovyClassDAO<T> getGroovyClassDAO();

	public <T extends IJarClass> JarClassDAO<T> getJarClassDAO();

	public <T extends IJarFile> JarFileDAO<T> getJarFileDAO();

	public <T extends IClassLoader>  ClassLoaderDAO<T> getClassLoaderDAO();

	public <T extends IDomainClassLoader>  DomainClassLoaderDAO<T> getDomainClassLoaderDAO();

	public <T extends IGroovyArchiveFile> GroovyArchiveFileDAO<T> getGroovyArchiveFileDAO();

	public <T extends IDomainGroovyArchiveFile> DomainGroovyArchiveFileDAO<T> getDomainGroovyArchiveFileDAO();

}
