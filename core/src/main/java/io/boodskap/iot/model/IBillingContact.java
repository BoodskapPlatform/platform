package io.boodskap.iot.model;

import java.util.Date;

import io.boodskap.iot.dao.BillingContactDAO;

public interface IBillingContact extends IDomainObject {

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
	
	public String getTargetDomain();

	public void setTargetDomain(String targetDomain);

	public String getContactId();

	public void setContactId(String contactId);

	public String getType();

	public void setType(String type);

	public String getName();

	public void setName(String name);

	public String getEmail();

	public void setEmail(String email);

	public String getContact();

	public void setContact(String contact);

	public String getAddress();

	public void setAddress(String address);

	public String getCity();

	public void setCity(String city);

	public String getState();

	public void setState(String state);

	public String getCountry();

	public void setCountry(String country);

	public String getZipcode();

	public void setZipcode(String zipcode);

	public String getLogo();

	public void setLogo(String logo);

	public Date getUpdatedtime();

	public void setUpdatedtime(Date updatedtime);

	public Date getCreatedtime();

	public void setCreatedtime(Date createdtime);

	public String getObj();

	public void setObj(String obj);

	public String getDepartment();

	public void setDepartment(String department);

	public String getDescription();

	public void setDescription(String description);
}
