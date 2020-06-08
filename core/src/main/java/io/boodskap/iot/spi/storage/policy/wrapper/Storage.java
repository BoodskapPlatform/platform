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
package io.boodskap.iot.spi.storage.policy.wrapper;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.*;
import io.boodskap.iot.model.*;
import io.boodskap.iot.spi.storage.IStorage;
import io.boodskap.iot.spi.storage.policy.wrapper.dao.*;

public class Storage implements IStorage {

	private final IStorage impl;

	public Storage(final IStorage impl) {
		this.impl = impl;
	}

	@Override
	public boolean isPaginationSupported() {
		return impl.isPaginationSupported();
	}

	@Override
	public boolean isSearchSupported() {
		return impl.isSearchSupported();
	}

	@Override
	public AlexaDAO<IAlexa> getAlexaDAO() throws StorageException {
		return new AlexaDAOImpl(impl.getAlexaDAO());
	}

	@Override
	public AssetDAO<IAsset> getAssetDAO() throws StorageException {
		return new AssetDAOImpl(impl.getAssetDAO());
	}

	@Override
	public AssetFileDAO<IAssetFile> getAssetFileDAO() throws StorageException {
		return new AssetFileDAOImpl(impl.getAssetFileDAO());
	}

	@Override
	public AssetDeviceDAO<IAssetDevice> getAssetDeviceDAO() throws StorageException {
		return new AssetDeviceDAOImpl(impl.getAssetDeviceDAO());
	}

	@Override
	public AssetGroupDAO<IAssetGroup> getAssetGroupDAO() {
		return new AssetGroupDAOImpl(impl.getAssetGroupDAO());
	}

	@Override
	public AssetGroupMemberDAO<IAssetGroupMember> getAssetGroupMemberDAO() {
		return new AssetGroupMemberDAOImpl(impl.getAssetGroupMemberDAO());
	}

	@Override
	public BinaryRuleDAO<IBinaryRule> getBinaryRuleDAO() {
		return new BinaryRuleDAOImpl(impl.getBinaryRuleDAO());
	}

	@Override
	public CounterDAO<ICounter> getCounterDAO() {
		return new CounterDAOImpl(impl.getCounterDAO());
	}

	@Override
	public DomainCounterDAO<IDomainCounter> getDomainCounterDAO() {
		return new DomainCounterDAOImpl(impl.getDomainCounterDAO());
	}

	@Override
	public DeviceCommandDAO<IDeviceCommand> getDeviceCommandDAO() {
		return new DeviceCommandDAOImpl(impl.getDeviceCommandDAO());
	}

	@Override
	public DeviceCounterDAO<IDeviceCounter> getDeviceCounterDAO() {
		return new DeviceCounterDAOImpl(impl.getDeviceCounterDAO());
	}

	@Override
	public DeviceDAO<IDevice> getDeviceDAO() {
		return new DeviceDAOImpl(impl.getDeviceDAO());
	}

	@Override
	public DeviceFileDAO<IDeviceFile> getDeviceFileDAO() {
		return new DeviceFileDAOImpl(impl.getDeviceFileDAO());
	}

	@Override
	public DeviceFriendDAO<IDeviceFriend> getDeviceFriendDAO() {
		return new DeviceFriendDAOImpl(impl.getDeviceFriendDAO());
	}

	@Override
	public DeviceGroupDAO<IDeviceGroup> getDeviceGroupDAO() {
		return new DeviceGroupDAOImpl(impl.getDeviceGroupDAO());
	}

	@Override
	public DeviceGroupMemberDAO<IDeviceGroupMember> getDeviceGroupMemberDAO() {
		return new DeviceGroupMemberDAOImpl(impl.getDeviceGroupMemberDAO());
	}

	@Override
	public DeviceModelDAO<IDeviceModel> getDeviceModelDAO() {
		return new DeviceModelDAOImpl(impl.getDeviceModelDAO());
	}

	@Override
	public DomainAccessDAO<IDomainAccess> getDomainAccessDAO() {
		return new DomainAccessDAOImpl(impl.getDomainAccessDAO());
	}

	@Override
	public DomainApiKeyDAO<IDomainApiKey> getDomainApiKeyDAO() {
		return new DomainApiKeyDAOImpl(impl.getDomainApiKeyDAO());
	}

	@Override
	public DomainAssetGroupDAO<IDomainAssetGroup> getDomainAssetGroupDAO() {
		return new DomainAssetGroupDAOImpl(impl.getDomainAssetGroupDAO());
	}

	@Override
	public DomainAssetGroupMemberDAO<IDomainAssetGroupMember> getDomainAssetGroupMemberDAO() {
		return new DomainAssetGroupMemberDAOImpl(impl.getDomainAssetGroupMemberDAO());
	}

	@Override
	public DomainDAO<IDomain> getDomainDAO() {
		return new DomainDAOImpl(impl.getDomainDAO());
	}

	@Override
	public DomainDeviceGroupDAO<IDomainDeviceGroup> getDomainDeviceGroupDAO() {
		return new DomainDeviceGroupDAOImpl(impl.getDomainDeviceGroupDAO());
	}

	@Override
	public DomainDeviceGroupMemberDAO<IDomainDeviceGroupMember> getDomainDeviceGroupMemberDAO() {
		return new DomainDeviceGroupMemberDAOImpl(impl.getDomainDeviceGroupMemberDAO());
	}

	@Override
	public DomainFileDAO<IDomainFile> getDomainFileDAO() {
		return new DomainFileDAOImpl(impl.getDomainFileDAO());
	}

	@Override
	public DomainLicenseDAO<IDomainLicense> getDomainLicenseDAO() {
		return new DomainLicenseDAOImpl(impl.getDomainLicenseDAO());
	}

	@Override
	public DomainNodeDAO<IDomainNode> getDomainNodeDAO() {
		return new DomainNodeDAOImpl(impl.getDomainNodeDAO());
	}

	@Override
	public DomainRuleDAO<IDomainRule> getDomainRuleDAO() {
		return new DomainRuleDAOImpl(impl.getDomainRuleDAO());
	}

	@Override
	public DomainUserGroupDAO<IDomainUserGroup> getDomainUserGroupDAO() {
		return new DomainUserGroupDAOImpl(impl.getDomainUserGroupDAO());
	}

	@Override
	public DomainUserGroupMemberDAO<IDomainUserGroupMember> getDomainUserGroupMemberDAO() {
		return new DomainUserGroupMemberDAOImpl(impl.getDomainUserGroupMemberDAO());
	}

	@Override
	public EmailGatewayDAO<IEmailGateway> getEmailGatewayDAO() {
		return new EmailGatewayDAOImpl(impl.getEmailGatewayDAO());
	}

	@Override
	public EventDAO<IEvent> getEventDAO() {
		return new EventDAOImpl(impl.getEventDAO());
	}

	@Override
	public EventRegistrationDAO<IEventRegistration> getEventRegistrationDAO() {
		return new EventRegistrationDAOImpl(impl.getEventRegistrationDAO());
	}

	@Override
	public FCMDeviceDAO<IFCMDevice> getFCMDeviceDAO() {
		return new FCMDeviceDAOImpl(impl.getFCMDeviceDAO());
	}

	@Override
	public FCMGatewayDAO<IFCMGateway> getFCMGatewayDAO() {
		return new FCMGatewayDAOImpl(impl.getFCMGatewayDAO());
	}

	@Override
	public FirmwareDAO<IFirmware> getFirmwareDAO() {
		return new FirmwareDAOImpl(impl.getFirmwareDAO());
	}

	@Override
	public GlobalDataDAO<IGlobalData> getGlobalDataDAO() {
		return new GlobalDataDAOImpl(impl.getGlobalDataDAO());
	}

	@Override
	public LinkedDomainDAO<ILinkedDomain> getLinkedDomainDAO() {
		return new LinkedDomainDAOImpl(impl.getLinkedDomainDAO());
	}

	@Override
	public LookupDAO<ILookup> getLookupDAO() {
		return new LookupDAOImpl(impl.getLookupDAO());
	}

	@Override
	public MessageRuleDAO<IMessageRule> getMessageRuleDAO() {
		return new MessageRuleDAOImpl(impl.getMessageRuleDAO());
	}

	@Override
	public NamedRuleDAO<INamedRule> getNamedRuleDAO() {
		return new NamedRuleDAOImpl(impl.getNamedRuleDAO());
	}

	@Override
	public NodeScheduledRuleDAO<INodeScheduledRule> getNodeScheduledRuleDAO() {
		return new NodeScheduledRuleDAOImpl(impl.getNodeScheduledRuleDAO());
	}

	@Override
	public OfflineSnapDAO<IOfflineSnap> getOfflineSnapDAO() {
		return new OfflineSnapDAOImpl(impl.getOfflineSnapDAO());
	}

	@Override
	public OfflineStreamDAO<IOfflineStream> getOfflineStreamDAO() {
		return new OfflineStreamDAOImpl(impl.getOfflineStreamDAO());
	}

	@Override
	public OrganizationAssetDAO<IOrganizationAsset> getOrganizationAssetDAO() {
		return new OrganizationAssetDAOImpl(impl.getOrganizationAssetDAO());
	}

	@Override
	public OrganizationDAO<IOrganization> getOrganizationDAO() {
		return new OrganizationDAOImpl(impl.getOrganizationDAO());
	}

	@Override
	public OrganizationDeviceDAO<IOrganizationDevice> getOrganizationDeviceDAO() {
		return new OrganizationDeviceDAOImpl(impl.getOrganizationDeviceDAO());
	}

	@Override
	public OTABatchDAO<IOTABatch> getOTABatchDAO() {
		return new OTABatchDAOImpl(impl.getOTABatchDAO());
	}

	@Override
	public OTABatchMemberDAO<IOTABatchMember> getOTABatchMemberDAO() {
		return new OTABatchMemberDAOImpl(impl.getOTABatchMemberDAO());
	}

	@Override
	public OTADeviceBatchDAO<IOTADeviceBatch> getOTADeviceBatchDAO() {
		return new OTADeviceBatchDAOImpl(impl.getOTADeviceBatchDAO());
	}

	@Override
	public OTADeviceBatchMemberDAO<IOTADeviceBatchMember> getOTADeviceBatchMemberDAO() {
		return new OTADeviceBatchMemberDAOImpl(impl.getOTADeviceBatchMemberDAO());
	}

	@Override
	public OTAModelBatchDAO<IOTAModelBatch> getOTAModelBatchDAO() {
		return new OTAModelBatchDAOImpl(impl.getOTAModelBatchDAO());
	}

	@Override
	public OTAModelBatchMemberDAO<IOTAModelBatchMember> getOTAModelBatchMemberDAO() {
		return new OTAModelBatchMemberDAOImpl(impl.getOTAModelBatchMemberDAO());
	}

	@Override
	public OutgoingCommandDAO<IOutgoingCommand> getOutgoingCommandDAO() throws StorageException {
		return new OutgoingCommandDAOImpl(impl.getOutgoingCommandDAO());
	}

	@Override
	public OutgoingEmailDAO<IOutgoingEmail> getOutgoingEmailDAO() {
		return new OutgoingEmailDAOImpl(impl.getOutgoingEmailDAO());
	}

	@Override
	public OutgoingFCMDAO<IOutgoingFCM> getOutgoingFCMDAO() {
		return new OutgoingFCMDAOImpl(impl.getOutgoingFCMDAO());
	}

	@Override
	public OutgoingSmsDAO<IOutgoingSms> getOutgoingSmsDAO() {
		return new OutgoingSmsDAOImpl(impl.getOutgoingSmsDAO());
	}

	@Override
	public OutgoingVoiceDAO<IOutgoingVoice> getOutgoingVoiceDAO() {
		return new OutgoingVoiceDAOImpl(impl.getOutgoingVoiceDAO());
	}

	@Override
	public PluginDAO<IPlugin> getPluginDAO() {
		return new PluginDAOImpl(impl.getPluginDAO());
	}

	@Override
	public PropertyDAO<IProperty> getPropertyDAO() {
		return new PropertyDAOImpl(impl.getPropertyDAO());
	}

	@Override
	public SystemPropertyDAO<ISystemProperty> getSystemPropertyDAO() {
		return new SystemPropertyDAOImpl(impl.getSystemPropertyDAO());
	}

	@Override
	public PublicFileDAO<IPublicFile> getPublicFileDAO() {
		return new PublicFileDAOImpl(impl.getPublicFileDAO());
	}

	@Override
	public RawMessageDAO<IRawMessage> getRawMessageDAO() {
		return new RawMessageDAOImpl(impl.getRawMessageDAO());
	}

	@Override
	public ReportedDeviceDAO<IReportedDevice> getReportedDeviceDAO() {
		return new ReportedDeviceDAOImpl(impl.getReportedDeviceDAO());
	}

	@Override
	public ScheduledRuleDAO<IScheduledRule> getScheduledRuleDAO() {
		return new ScheduledRuleDAOImpl(impl.getScheduledRuleDAO());
	}

	@Override
	public SentEmailDAO<ISentEmail> getSentEmailDAO() {
		return new SentEmailDAOImpl(impl.getSentEmailDAO());
	}

	@Override
	public SentFCMDAO<ISentFCM> getSentFCMDAO() {
		return new SentFCMDAOImpl(impl.getSentFCMDAO());
	}

	@Override
	public SentSmsDAO<ISentSms> getSentSmsDAO() {
		return new SentSmsDAOImpl(impl.getSentSmsDAO());
	}

	@Override
	public SentVoiceDAO<ISentVoice> getSentVoiceDAO() {
		return new SentVoiceDAOImpl(impl.getSentVoiceDAO());
	}

	@Override
	public SystemTemplateDAO<ISystemTemplate> getSystemTemplateDAO() {
		return new SystemTemplateDAOImpl(impl.getSystemTemplateDAO());
	}

	@Override
	public TemplateDAO<ITemplate> getTemplateDAO() {
		return new TemplateDAOImpl(impl.getTemplateDAO());
	}

	@Override
	public TwilioGatewayDAO<ITwilioGateway> getTwilioGatewayDAO() {
		return new TwilioGatewayDAOImpl(impl.getTwilioGatewayDAO());
	}

	@Override
	public UserAssetGroupDAO<IUserAssetGroup> getUserAssetGroupDAO() {
		return new UserAssetGroupDAOImpl(impl.getUserAssetGroupDAO());
	}

	@Override
	public UserAssetGroupMemberDAO<IUserAssetGroupMember> getUserAssetGroupMemberDAO() {
		return new UserAssetGroupMemberDAOImpl(impl.getUserAssetGroupMemberDAO());
	}

	@Override
	public UserDAO<IUser> getUserDAO() {
		return new UserDAOImpl(impl.getUserDAO());
	}

	@Override
	public UserDeviceGroupDAO<IUserDeviceGroup> getUserDeviceGroupDAO() {
		return new UserDeviceGroupDAOImpl(impl.getUserDeviceGroupDAO());
	}

	@Override
	public UserDeviceGroupMemberDAO<IUserDeviceGroupMember> getUserDeviceGroupMemberDAO() {
		return new UserDeviceGroupMemberDAOImpl(impl.getUserDeviceGroupMemberDAO());
	}

	@Override
	public UserGroupDAO<IUserGroup> getUserGroupDAO() {
		return new UserGroupDAOImpl(impl.getUserGroupDAO());
	}

	@Override
	public UserGroupMemberDAO<IUserGroupMember> getUserGroupMemberDAO() {
		return new UserGroupMemberDAOImpl(impl.getUserGroupMemberDAO());
	}

	@Override
	public DatabaseMetaDataDAO<IDatabaseMetaData> getDatabaseMetaDataDAO() {
		return new DatabaseMetaDataDAOImpl(impl.getDatabaseMetaDataDAO());
	}

	@Override
	public LocationDAO<ILocation> getLocationDAO() {
		return new LocationDAOImpl(impl.getLocationDAO());
	}

	@Override
	public LocationHistoryDAO<ILocationHistory> getLocationHistoryDAO() {
		return new LocationHistoryDAOImpl(impl.getLocationHistoryDAO());
	}

	@Override
	public EntityFileDAO<IEntityFile> getEntityFileDAO() {
		return new EntityFileDAOImpl(impl.getEntityFileDAO());
	}

	@Override
	public UserFileDAO<IUserFile> getUserFileDAO() {
		return new UserFileDAOImpl(impl.getUserFileDAO());
	}

	@Override
	public DomainEntityDAO<IDomainEntity> getDomainEntityDAO() {
		return new DomainEntityDAOImpl(impl.getDomainEntityDAO());
	}

	@Override
	public DomainJsonEntityDAO<IDomainJsonEntity> getDomainJsonEntityDAO() {
		return new DomainJsonEntityDAOImpl(impl.getDomainJsonEntityDAO());
	}

	@Override
	public OrganizationFileDAO<IOrganizationFile> getOrganizationFileDAO() {
		return new OrganizationFileDAOImpl(impl.getOrganizationFileDAO());
	}

	@Override
	public OTAModelVersionBatchDAO<IOTAModelVersionBatch> getOTAModelVersionBatchDAO() {
		return new OTAModelVersionBatchDAOImpl(impl.getOTAModelVersionBatchDAO());
	}

	@Override
	public OTAModelVersionBatchMemberDAO<IOTAModelVersionBatchMember> getOTAModelVersionBatchMemberDAO() {
		return new OTAModelVersionBatchMemberDAOImpl(impl.getOTAModelVersionBatchMemberDAO());
	}

	@Override
	public CameraDeviceDAO<ICameraDevice> getCameraDeviceDAO() {
		return new CameraDeviceDAOImpl(impl.getCameraDeviceDAO());
	}

	@Override
	public OfflineStreamSessionDAO<IOfflineStreamSession> getOfflineStreamSessionDAO() {
		return new OfflineStreamSessionDAOImpl(impl.getOfflineStreamSessionDAO());
	}

	@Override
	public DomainRoleDAO<IDomainRole> getDomainRoleDAO() {
		return new DomainRoleDAOImpl(impl.getDomainRoleDAO());
	}

	@Override
	public OrganizationRoleDAO<IOrganizationRole> getOrganizationRoleDAO() {
		return new OrganizationRoleDAOImpl(impl.getOrganizationRoleDAO());
	}

	@Override
	public OrganizationUserRoleDAO<IOrganizationUserRole> getOrganizationUserRoleDAO() {
		return new OrganizationUserRoleDAOImpl(impl.getOrganizationUserRoleDAO());
	}

	@Override
	public UserRoleDAO<IUserRole> getUserRoleDAO() {
		return new UserRoleDAOImpl(impl.getUserRoleDAO());
	}

	@Override
	public OrganizationUserDAO<IOrganizationUser> getOrganizationUserDAO() {
		return new OrganizationUserDAOImpl(impl.getOrganizationUserDAO());
	}

	@Override
	public UserDomainDAO<IUserDomain> getUserDomainDAO() {
		return new UserDomainDAOImpl(impl.getUserDomainDAO());
	}

	@Override
	public String getVendorInfo() {
		return impl.getVendorInfo();
	}

	@Override
	public String getVersion() {
		return impl.getVersion();
	}

	@Override
	public SystemFileDAO<ISystemFile> getSystemFileDAO() {
		return new SystemFileDAOImpl(impl.getSystemFileDAO());
	}

	@Override
	public BillingContactDAO<IBillingContact> getBillingContactDAO() {
		return new BillingContactDAOImpl(impl.getBillingContactDAO());
	}

	@Override
	public BillingInvoiceDAO<IBillingInvoice> getBillingInvoiceDAO() {
		return new BillingInvoiceDAOImpl(getBillingInvoiceDAO());
	}

	@Override
	public BillingScheduleDAO<IBillingSchedule> getBillingScheduleDAO() {
		return new BillingScheduleDAOImpl(impl.getBillingScheduleDAO());
	}

	@Override
	public ClusterDAO<ICluster> getClusterDAO() {
		return new ClusterDAOImpl(impl.getClusterDAO());
	}

	@Override
	public ClusterMachineDAO<IClusterMachine> getClusterMachineDAO() {
		return new ClusterMachineDAOImpl(impl.getClusterMachineDAO());
	}

	@Override
	public ClusterLicenseDAO<IClusterLicense> getClusterLicenseDAO() {
		return new ClusterLicenseDAOImpl(impl.getClusterLicenseDAO());
	}

	@Override
	public MessageCounterDAO<IMessageCounter> getMessageCounterDAO() {
		return new MessageCounterDAOImpl(impl.getMessageCounterDAO());
	}

	@Override
	public DeviceMessageCounterDAO<IDeviceMessageCounter> getDeviceMessageCounterDAO() {
		return new DeviceMessageCounterDAOImpl(impl.getDeviceMessageCounterDAO());
	}

	@Override
	public DatabaseTableDAO<IDatabaseTable> getDatabaseTableDAO() {
		return new DatabaseTableDAOImpl(impl.getDatabaseTableDAO());
	}

	@Override
	public BillingTemplateDAO<IBillingTemplate> getBillingTemplateDAO() {
		return new BillingTemplateDAOImpl(impl.getBillingTemplateDAO());
	}

	@Override
	public ReceivedCommandDAO<IReceivedCommand> getReceivedCommandDAO() {
		return new ReceivedCommandDAOImpl(impl.getReceivedCommandDAO());
	}

	@Override
	public DomainGroovyClassDAO<IDomainGroovyClass> getDomainGroovyClassDAO() {
		return new DomainGroovyClassDAOImpl(impl.getDomainGroovyClassDAO());
	}

	@Override
	public DomainJarClassDAO<IDomainJarClass> getDomainJarClassDAO() {
		return new DomainJarClassDAOImpl(impl.getDomainJarClassDAO());
	}

	@Override
	public DomainJarFileDAO<IDomainJarFile> getDomainJarFileDAO() {
		return new DomainJarFileDAOImpl(impl.getDomainJarFileDAO());
	}

	@Override
	public GroovyClassDAO<IGroovyClass> getGroovyClassDAO() {
		return new GroovyClassDAOImpl(impl.getGroovyClassDAO());
	}

	@Override
	public JarClassDAO<IJarClass> getJarClassDAO() {
		return new JarClassDAOImpl(impl.getJarClassDAO());
	}

	@Override
	public JarFileDAO<IJarFile> getJarFileDAO() {
		return new JarFileDAOImpl(impl.getJarFileDAO());
	}

	@Override
	public ClassLoaderDAO<IClassLoader> getClassLoaderDAO() {
		return new ClassLoaderDAOImpl(impl.getClassLoaderDAO());
	}

	@Override
	public DomainClassLoaderDAO<IDomainClassLoader> getDomainClassLoaderDAO() {
		return new DomainClassLoaderDAOImpl(impl.getDomainClassLoaderDAO());
	}

	@Override
	public GroovyArchiveFileDAO<IGroovyArchiveFile> getGroovyArchiveFileDAO() {
		return new GroovyArchiveFileDAOImpl(impl.getGroovyArchiveFileDAO());
	}

	@Override
	public DomainGroovyArchiveFileDAO<IDomainGroovyArchiveFile> getDomainGroovyArchiveFileDAO() {
		return new DomainGroovyArchiveFileDAOImpl(impl.getDomainGroovyArchiveFileDAO());
	}

	@Override
	public AccessTokenDAO<IAccessToken> getAccessTokenDAO() throws StorageException {
		return new AccessTokenDAOImpl(impl.getAccessTokenDAO());
	}

}
