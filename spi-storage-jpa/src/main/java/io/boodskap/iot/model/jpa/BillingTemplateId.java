package io.boodskap.iot.model.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class BillingTemplateId implements Serializable {
	
	private static final long serialVersionUID = -324504654810304600L;

	@Column(name="templatename", length=120)
	private String templatename;

	@Column(name="itemname", length=120)
	private String itemname;

	public BillingTemplateId() {
	}

	public BillingTemplateId(String templatename, String itemname) {
		super();
		this.templatename = templatename;
		this.itemname = itemname;
	}

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemname == null) ? 0 : itemname.hashCode());
		result = prime * result + ((templatename == null) ? 0 : templatename.hashCode());
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
		BillingTemplateId other = (BillingTemplateId) obj;
		if (itemname == null) {
			if (other.itemname != null)
				return false;
		} else if (!itemname.equals(other.itemname))
			return false;
		if (templatename == null) {
			if (other.templatename != null)
				return false;
		} else if (!templatename.equals(other.templatename))
			return false;
		return true;
	}

}
