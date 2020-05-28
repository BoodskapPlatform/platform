package io.boodskap.iot.model;

import io.boodskap.iot.dao.BillingTemplateDAO;

public interface IBillingTemplate extends IModel {

	public static BillingTemplateDAO<IBillingTemplate> dao(){
		return BillingTemplateDAO.get();
	}
	
	public static Class<? extends IBillingTemplate> clazz() {
		return dao().clazz();
	}

	public static IBillingTemplate create(String templatename, String itemname) {
		return dao().create(templatename, itemname);
	}
	
	public static IBillingTemplate find(String templatename, String itemname) {
		return dao().get(templatename, itemname);
	}
	
	public default void save() {
		IBillingTemplate.dao().createOrUpdate(this);
	}

	@Override
	public default void copy(Object other) {
		
		IBillingTemplate o = (IBillingTemplate) other;
		
		setTemplatecode(o.getTemplatename());
		setItemname(o.getItemname());
		setDescription(o.getDescription());
		setUnitprice(o.getUnitprice());
		setTax(o.getTax());
		setTemplatecode(o.getTemplatecode());
		
		IModel.super.copy(other);
	}

	public String getTemplatename();

	public void setTemplatename(String templatename);

	public String getItemname();

	public void setItemname(String itemname);

	public String getDescription();

	public void setDescription(String description);

	public double getUnitprice();

	public void setUnitprice(double unitprice);

	public float getTax();

	public void setTax(float tax);

	public String getTemplatecode();

	public void setTemplatecode(String templatecode);

}
