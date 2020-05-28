package io.boodskap.iot.model;

import io.boodskap.iot.dao.BillingContactDAO;

public interface IBillingContact extends IContact {

	public static BillingContactDAO<IBillingContact> dao(){
		return BillingContactDAO.get();
	}
	
	public static Class<? extends IBillingContact> clazz() {
		return dao().clazz();
	}
	
	public static IBillingContact create(String domainKey, String targetDomain, String contactId) {
		return dao().create(domainKey, targetDomain, contactId);
	}

	public static IBillingContact find(String domainKey, String targetDomain, String contactId) {
		return dao().get(domainKey, targetDomain, contactId);
	}

	public default void save() {
		IBillingContact.dao().createOrUpdate(this);
	}
	
	@Override
	public default void copy(Object other) {
		
		IBillingContact o = (IBillingContact) other;
		
		setTargetDomain(o.getTargetDomain());
		setContactId(o.getContactId());
		setType(o.getType());
		setLogo(o.getLogo());
		setObj(o.getObj());
		setDepartment(o.getDepartment());
		
		IContact.super.copy(other);
	}
	
	public String getTargetDomain();

	public void setTargetDomain(String targetDomain);

	public String getContactId();

	public void setContactId(String contactId);

	public String getType();

	public void setType(String type);

	public String getLogo();

	public void setLogo(String logo);

	public String getObj();

	public void setObj(String obj);

	public String getDepartment();

	public void setDepartment(String department);
}
