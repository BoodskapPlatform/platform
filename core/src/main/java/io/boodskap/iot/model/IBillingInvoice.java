package io.boodskap.iot.model;

import java.util.Date;

import io.boodskap.iot.dao.BillingInvoiceDAO;

public interface IBillingInvoice extends IDomainObject {

	public static BillingInvoiceDAO<IBillingInvoice> dao(){
		return BillingInvoiceDAO.get();
	}

	public static IBillingInvoice create(String domainKey, String targetDomain, String invoiceId) {
		return dao().create(domainKey, targetDomain, invoiceId);
	}

	public static IBillingInvoice find(String domainKey, String targetDomain, String invoiceId) {
		return dao().get(domainKey, targetDomain, invoiceId);
	}

	public static Class<? extends IBillingInvoice> clazz() {
		return dao().clazz();
	}

	public default void save() {
		IBillingInvoice.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IBillingInvoice o = (IBillingInvoice) other;
		
		setTargetDomain(o.getTargetDomain());
		setInvoicename(o.getInvoicename());
		setInvoiceno(o.getInvoiceno());
		setFrequency(o.getFrequency());
		setFile(o.getFile());
		setGrandtotal(o.getGrandtotal());
		setStartdate(o.getStartdate());
		setEnddate(o.getEnddate());
		setObj(o.getObj());
		setInvoicetype(o.getInvoicetype());
		
		IDomainObject.super.copy(other);
	}
	
	public String getTargetDomain();

	public void setTargetDomain(String targetDomain);

	public String getInvoicename();

	public void setInvoicename(String invoicename);

	public String getInvoiceno();

	public void setInvoiceno(String invoiceno);

	public String getFrequency();

	public void setFrequency(String frequency);

	public String getFile();

	public void setFile(String file);

	public double getGrandtotal();

	public void setGrandtotal(double grandtotal);

	public Date getStartdate();

	public void setStartdate(Date startdate);

	public Date getEnddate();

	public void setEnddate(Date enddate);

	public String getObj();

	public void setObj(String obj);

	public String getInvoicetype();

	public void setInvoicetype(String invoicetype);

}
