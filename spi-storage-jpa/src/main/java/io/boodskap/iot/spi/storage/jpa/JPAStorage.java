package io.boodskap.iot.spi.storage.jpa;

import io.boodskap.iot.StorageException;
import io.boodskap.iot.dao.*;
import io.boodskap.iot.model.jpa.*;
import io.boodskap.iot.model.jpa.ClassLoader;
import io.boodskap.iot.spi.storage.IStorage;
import io.boodskap.iot.spi.storage.jpa.dao.*;

public class JPAStorage implements IStorage {

	protected JPAStorage() {
	}

	@Override
	public boolean isPaginationSupported() {
		return true;
	}

	@Override
	public boolean isSearchSupported() {
		return true;
	}

	@Override
	public String getVendorInfo() {
		return "JPA (Java Persistence Architecture)";
	}

	@Override
	public String getVersion() {
		return "2.1.1";
	}

	@SuppressWarnings("unchecked")
	@Override
	public AlexaDAO<Alexa> getAlexaDAO() throws StorageException {
		return AlexaDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public AssetDAO<Asset> getAssetDAO() throws StorageException {
		return AssetDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public AssetDeviceDAO<AssetDevice> getAssetDeviceDAO() throws StorageException {
		return AssetDeviceDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public AssetGroupDAO<AssetGroup> getAssetGroupDAO() {
		return AssetGroupDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public AssetGroupMemberDAO<AssetGroupMember> getAssetGroupMemberDAO() {
		return AssetGroupMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BinaryRuleDAO<BinaryRule> getBinaryRuleDAO() {
		return BinaryRuleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public CounterDAO<Counter> getCounterDAO() {
		return CounterDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainCounterDAO<DomainCounter> getDomainCounterDAO() {
		return DomainCounterDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceCommandDAO<DeviceCommand> getDeviceCommandDAO() {
		return DeviceCommandDAO.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceCounterDAO<DeviceCounter> getDeviceCounterDAO() {
		return DeviceCounterDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceDAO<Device> getDeviceDAO() {
		return DeviceDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceFriendDAO<DeviceFriend> getDeviceFriendDAO() {
		return DeviceFriendDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceGroupDAO<DeviceGroup> getDeviceGroupDAO() {
		return DeviceGroupDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceGroupMemberDAO<DeviceGroupMember> getDeviceGroupMemberDAO() {
		return DeviceGroupMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceModelDAO<DeviceModel> getDeviceModelDAO() {
		return DeviceModelDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainAccessDAO<DomainAccess> getDomainAccessDAO() {
		return DomainAccessDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainApiKeyDAO<DomainApiKey> getDomainApiKeyDAO() {
		return DomainApiKeyDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainAssetGroupDAO<DomainAssetGroup> getDomainAssetGroupDAO() {
		return DomainAssetGroupDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainAssetGroupMemberDAO<DomainAssetGroupMember> getDomainAssetGroupMemberDAO() {
		return DomainAssetGroupMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainDAO<Domain> getDomainDAO() {
		return DomainDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainDeviceGroupDAO<DomainDeviceGroup> getDomainDeviceGroupDAO() {
		return DomainDeviceGroupDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainDeviceGroupMemberDAO<DomainDeviceGroupMember> getDomainDeviceGroupMemberDAO() {
		return DomainDeviceGroupMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainFileDAO<DomainFile> getDomainFileDAO() {
		return DomainFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainLicenseDAO<DomainLicense> getDomainLicenseDAO() {
		return DomainLicenseDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainNodeDAO<DomainNode> getDomainNodeDAO() {
		return DomainNodeDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainRuleDAO<DomainRule> getDomainRuleDAO() {
		return DomainRuleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainUserGroupDAO<DomainUserGroup> getDomainUserGroupDAO() {
		return DomainUserGroupDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainUserGroupMemberDAO<DomainUserGroupMember> getDomainUserGroupMemberDAO() {
		return DomainUserGroupMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmailGatewayDAO<EmailGateway> getEmailGatewayDAO() {
		return EmailGatewayDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public EventDAO<Event> getEventDAO() {
		return EventDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public EventRegistrationDAO<EventRegistration> getEventRegistrationDAO() {
		return EventRegistrationDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public FCMDeviceDAO<FCMDevice> getFCMDeviceDAO() {
		return FCMDeviceDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public FCMGatewayDAO<FCMGateway> getFCMGatewayDAO() {
		return FCMGatewayDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public FirmwareDAO<Firmware> getFirmwareDAO() {
		return FirmwareDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public GlobalDataDAO<GlobalData> getGlobalDataDAO() {
		return GlobalDataDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedDomainDAO<LinkedDomain> getLinkedDomainDAO() {
		return LinkedDomainDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public LookupDAO<Lookup> getLookupDAO() {
		return LookupDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public MessageRuleDAO<MessageRule> getMessageRuleDAO() {
		return MessageRuleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public NamedRuleDAO<NamedRule> getNamedRuleDAO() {
		return NamedRuleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public NodeScheduledRuleDAO<NodeScheduledRule> getNodeScheduledRuleDAO() {
		return NodeScheduledRuleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OfflineSnapDAO<OfflineSnap> getOfflineSnapDAO() {
		return OfflineSnapDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OfflineStreamDAO<OfflineStream> getOfflineStreamDAO() {
		return OfflineStreamDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrganizationAssetDAO<OrganizationAsset> getOrganizationAssetDAO() {
		return OrganizationAssetDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrganizationDAO<Organization> getOrganizationDAO() {
		return OrganizationDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrganizationDeviceDAO<OrganizationDevice> getOrganizationDeviceDAO() {
		return OrganizationDeviceDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OTABatchDAO<OTABatch> getOTABatchDAO() {
		return OTABatchDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OTABatchMemberDAO<OTABatchMember> getOTABatchMemberDAO() {
		return OTABatchMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OTADeviceBatchDAO<OTADeviceBatch> getOTADeviceBatchDAO() {
		return OTADeviceBatchDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OTADeviceBatchMemberDAO<OTADeviceBatchMember> getOTADeviceBatchMemberDAO() {
		return OTADeviceBatchMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OTAModelBatchDAO<OTAModelBatch> getOTAModelBatchDAO() {
		return OTAModelBatchDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OTAModelBatchMemberDAO<OTAModelBatchMember> getOTAModelBatchMemberDAO() {
		return OTAModelBatchMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OutgoingCommandDAO<OutgoingCommand> getOutgoingCommandDAO() throws StorageException {
		return OutgoingCommandDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OutgoingEmailDAO<OutgoingEmail> getOutgoingEmailDAO() {
		return OutgoingEmailDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OutgoingFCMDAO<OutgoingFCM> getOutgoingFCMDAO() {
		return OutgoingFCMDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OutgoingSmsDAO<OutgoingSms> getOutgoingSmsDAO() {
		return OutgoingSmsDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OutgoingVoiceDAO<OutgoingVoice> getOutgoingVoiceDAO(){
		return OutgoingVoiceDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PluginDAO<Plugin> getPluginDAO() {
		return PluginDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PropertyDAO<Property> getPropertyDAO() {
		return PropertyDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SystemPropertyDAO<SystemProperty> getSystemPropertyDAO() {
		return SystemPropertyDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public PublicFileDAO<PublicFile> getPublicFileDAO() {
		return PublicFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public AssetFileDAO<AssetFile> getAssetFileDAO() {
		return AssetFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceFileDAO<DeviceFile> getDeviceFileDAO() {
		return DeviceFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public EntityFileDAO<EntityFile> getEntityFileDAO() {
		return EntityFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public RawMessageDAO<RawMessage> getRawMessageDAO() {
		return RawMessageDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ReportedDeviceDAO<ReportedDevice> getReportedDeviceDAO() {
		return ReportedDeviceDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ScheduledRuleDAO<ScheduledRule> getScheduledRuleDAO() {
		return ScheduledRuleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SentEmailDAO<SentEmail> getSentEmailDAO() {
		return SentEmailDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SentFCMDAO<SentFCM> getSentFCMDAO() {
		return SentFCMDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SentSmsDAO<SentSms> getSentSmsDAO() {
		return SentSmsDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SentVoiceDAO<SentVoice> getSentVoiceDAO() {
		return SentVoiceDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SystemTemplateDAO<SystemTemplate> getSystemTemplateDAO() {
		return SystemTemplateDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public TemplateDAO<Template> getTemplateDAO() {
		return TemplateDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public TwilioGatewayDAO<TwilioGateway> getTwilioGatewayDAO() {
		return TwilioGatewayDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserAssetGroupDAO<UserAssetGroup> getUserAssetGroupDAO() {
		return UserAssetGroupDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserAssetGroupMemberDAO<UserAssetGroupMember> getUserAssetGroupMemberDAO() {
		return UserAssetGroupMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDAO<User> getUserDAO() {
		return UserDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDeviceGroupDAO<UserDeviceGroup> getUserDeviceGroupDAO() {
		return UserDeviceGroupDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDeviceGroupMemberDAO<UserDeviceGroupMember> getUserDeviceGroupMemberDAO() {
		return UserDeviceGroupMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserGroupDAO<UserGroup> getUserGroupDAO() {
		return UserGroupDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserGroupMemberDAO<UserGroupMember> getUserGroupMemberDAO() {
		return UserGroupMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DatabaseMetaDataDAO<DatabaseMetaData> getDatabaseMetaDataDAO() {
		return DatabaseMetaDataDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public LocationDAO<Location> getLocationDAO() {
		return LocationDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public LocationHistoryDAO<LocationHistory> getLocationHistoryDAO() {
		return LocationHistoryDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserFileDAO<UserFile> getUserFileDAO() {
		return UserFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainEntityDAO<DomainEntity> getDomainEntityDAO() {
		return DomainEntityDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainJsonEntityDAO<DomainJsonEntity> getDomainJsonEntityDAO() {
		return DomainJsonEntityDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrganizationFileDAO<OrganizationFile> getOrganizationFileDAO() {
		return OrganizationFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OTAModelVersionBatchDAO<OTAModelVersionBatch> getOTAModelVersionBatchDAO() {
		return OTAModelVersionBatchDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OTAModelVersionBatchMemberDAO<OTAModelVersionBatchMember> getOTAModelVersionBatchMemberDAO() {
		return OTAModelVersionBatchMemberDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public CameraDeviceDAO<CameraDevice> getCameraDeviceDAO() {
		return CameraDeviceDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OfflineStreamSessionDAO<OfflineStreamSession> getOfflineStreamSessionDAO() {
		return OfflineStreamSessionDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainRoleDAO<DomainRole> getDomainRoleDAO() {
		return DomainRoleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrganizationRoleDAO<OrganizationRole> getOrganizationRoleDAO() {
		return OrganizationRoleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrganizationUserRoleDAO<OrganizationUserRole> getOrganizationUserRoleDAO() {
		return OrganizationUserRoleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserRoleDAO<UserRole> getUserRoleDAO() {
		return UserRoleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public OrganizationUserDAO<OrganizationUser> getOrganizationUserDAO() {
		return OrganizationUserDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDomainDAO<UserDomain> getUserDomainDAO() {
		return UserDomainDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SystemFileDAO<SystemFile> getSystemFileDAO() {
		return SystemFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BillingContactDAO<BillingContact> getBillingContactDAO() {
		return BillingContactDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BillingInvoiceDAO<BillingInvoice> getBillingInvoiceDAO() {
		return BillingInvoiceDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BillingScheduleDAO<BillingSchedule> getBillingScheduleDAO() {
		return BillingScheduleDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClusterDAO<Cluster> getClusterDAO() {
		return ClusterDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClusterMachineDAO<ClusterMachine> getClusterMachineDAO() {
		return ClusterMachineDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClusterLicenseDAO<ClusterLicense> getClusterLicenseDAO() {
		return ClusterLicenseDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public MessageCounterDAO<MessageCounter> getMessageCounterDAO() {
		return MessageCounterDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DeviceMessageCounterDAO<DeviceMessageCounter> getDeviceMessageCounterDAO() {
		return DeviceMessageCounterDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DatabaseTableDAO<DatabaseTable> getDatabaseTableDAO() {
		return DatabaseTableDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public BillingTemplateDAO<BillingTemplate> getBillingTemplateDAO() {
		return BillingTemplateDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ReceivedCommandDAO<ReceivedCommand> getReceivedCommandDAO() {
		return ReceivedCommandDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainGroovyClassDAO<DomainGroovyClass> getDomainGroovyClassDAO() {
		return DomainGroovyClassDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainJarClassDAO<DomainJarClass> getDomainJarClassDAO() {
		return DomainJarClassDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainJarFileDAO<DomainJarFile> getDomainJarFileDAO() {
		return DomainJarFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public GroovyClassDAO<GroovyClass> getGroovyClassDAO() {
		return GroovyClassDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public JarClassDAO<JarClass> getJarClassDAO() {
		return JarClassDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public JarFileDAO<JarFile> getJarFileDAO() {
		return JarFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ClassLoaderDAO<ClassLoader> getClassLoaderDAO() {
		return ClassLoaderDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainClassLoaderDAO<DomainClassLoader> getDomainClassLoaderDAO() {
		return DomainClassLoaderDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public GroovyArchiveFileDAO<GroovyArchiveFile> getGroovyArchiveFileDAO() {
		return GroovyArchiveFileDAOImpl.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DomainGroovyArchiveFileDAO<DomainGroovyArchiveFile> getDomainGroovyArchiveFileDAO() {
		return DomainGroovyArchiveFileDAOImpl.get();
	}

}
