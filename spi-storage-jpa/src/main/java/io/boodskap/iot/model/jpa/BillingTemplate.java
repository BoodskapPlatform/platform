package io.boodskap.iot.model.jpa;

import io.boodskap.iot.model.IBillingTemplate;

public class BillingTemplate extends AbstractModel implements IBillingTemplate{

	private static final long serialVersionUID = 6575454134158351507L;
	
	private BillingTemplateId id = new BillingTemplateId();
	private double unitprice;
	private float tax;
	private String templatecode = null;
	

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(tax);
		result = prime * result + ((templatecode == null) ? 0 : templatecode.hashCode());
		long temp;
		temp = Double.doubleToLongBits(unitprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingTemplate other = (BillingTemplate) obj;
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
		return true;
	}

}
