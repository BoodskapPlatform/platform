package io.boodskap.iot.model.jpa;

import java.util.Date;

import io.boodskap.iot.model.IBillingTemplate;

public class BillingTemplate implements IBillingTemplate{

	private static final long serialVersionUID = 6575454134158351507L;
	
	private BillingTemplateId id = new BillingTemplateId();
	private String description = null;
	private double unitprice;
	private float tax;
	private String templatecode = null;
	private Date updatedtime = null;
	private Date createdtime = null;
	

	public BillingTemplate() {
	}

	public BillingTemplate(BillingTemplateId id) {
		this.id = id;
	}

	public String getTemplatename() {
		return id.getTemplatename();
	}

	public void setTemplatename(String templatename) {
		id.setTemplatename(templatename);
	}

	public String getItemname() {
		return id.getItemname();
	}

	public void setItemname(String itemname) {
		id.setItemname(itemname);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public String getTemplatecode() {
		return templatecode;
	}

	public void setTemplatecode(String templatecode) {
		this.templatecode = templatecode;
	}

	public Date getUpdatedtime() {
		return updatedtime;
	}

	public void setUpdatedtime(Date updatedtime) {
		this.updatedtime = updatedtime;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdtime == null) ? 0 : createdtime.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(tax);
		result = prime * result + ((templatecode == null) ? 0 : templatecode.hashCode());
		long temp;
		temp = Double.doubleToLongBits(unitprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((updatedtime == null) ? 0 : updatedtime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingTemplate other = (BillingTemplate) obj;
		if (createdtime == null) {
			if (other.createdtime != null)
				return false;
		} else if (!createdtime.equals(other.createdtime))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(tax) != Float.floatToIntBits(other.tax))
			return false;
		if (templatecode == null) {
			if (other.templatecode != null)
				return false;
		} else if (!templatecode.equals(other.templatecode))
			return false;
		if (Double.doubleToLongBits(unitprice) != Double.doubleToLongBits(other.unitprice))
			return false;
		if (updatedtime == null) {
			if (other.updatedtime != null)
				return false;
		} else if (!updatedtime.equals(other.updatedtime))
			return false;
		return true;
	}

}
