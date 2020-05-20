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

}
