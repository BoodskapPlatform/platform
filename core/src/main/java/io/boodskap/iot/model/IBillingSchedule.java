package io.boodskap.iot.model;

import java.util.Date;

import io.boodskap.iot.dao.BillingScheduleDAO;

public interface IBillingSchedule extends IDomainObject {

	public static BillingScheduleDAO<IBillingSchedule> dao(){
		return BillingScheduleDAO.get();
	}

	public static IBillingSchedule create(String domainKey, String targetDomain, String scheduleId) {
		return dao().create(domainKey, targetDomain, scheduleId);
	}

	public static IBillingSchedule find(String domainKey, String targetDomain, String scheduleId) {
		return dao().get(domainKey, targetDomain, scheduleId);
	}

	public static Class<? extends IBillingSchedule> clazz() {
		return dao().clazz();
	}

	public default void save() {
		IBillingSchedule.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IBillingSchedule o = (IBillingSchedule) other;
		
		setTargetDomain(o.getTargetDomain());
		setInvoicename(o.getInvoicename());
		setInvoicecode(o.getInvoicecode());
		setFrequency(o.getFrequency());
		setCurrency(o.getCurrency());
		setPayername(o.getPayername());
		setDiscounteditems(o.isDiscounteditems());
		setEnabled(o.isEnabled());
		setObj(o.getObj());
		setStartdate(o.getStartdate());
		setStartevery(o.getStartevery());
		setWeekday(o.getWeekday());
		setBillingtype(o.getBillingtype());
		setExecuted(o.isExecuted());
		
		IDomainObject.super.copy(other);
	}

	public String getTargetDomain();

	public void setTargetDomain(String targetDomain);

	public String getInvoicename();

	public void setInvoicename(String invoicename);

	public String getInvoicecode();

	public void setInvoicecode(String invoicecode);

	public String getFrequency();

	public void setFrequency(String frequency);

	public String getCurrency();

	public void setCurrency(String currency);

	public String getCompanyname();

	public void setCompanyname(String companyname);

	public String getPayername();

	public void setPayername(String payername);

	public boolean isDiscounteditems();

	public void setDiscounteditems(boolean discounteditems);

	public boolean isEnabled();

	public void setEnabled(boolean enabled);

	public String getObj();

	public void setObj(String obj);

	public Date getStartdate();

	public void setStartdate(Date startdate);

	public Date getEnddate();

	public void setEnddate(Date enddate);

	public String getStartevery();

	public void setStartevery(String startevery);

	public int getWeekday();

	public void setWeekday(int weekday);

	public String getBillingtype();

	public void setBillingtype(String billingtype);

	public boolean isExecuted();

	public void setExecuted(boolean executed);

}
