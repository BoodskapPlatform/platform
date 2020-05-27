package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.model.IBillingSchedule;

@Entity
@Table(name = "billingschedule")
public class BillingSchedule extends AbstractModel implements IBillingSchedule {

	private static final long serialVersionUID = 5134362610388399477L;

	@EmbeddedId
	private BillingScheduleId id = new BillingScheduleId();

	@Column(name = "invoicename", length = 20)
	private String invoicename = null;

	@Column(name = "invoicecode", length = 20)
	private String invoicecode = null;

	@Column(name = "frequency", length = 20)
	private String frequency = null;

	@Column(name = "currency", length = 20)
	private String currency = null;

	@Column(name = "companyname", length = 255)
	private String companyname = null;

	@Column(name = "payername", length = 180)
	private String payername = null;

	@Column(name = "discounteditems")
	private boolean discounteditems = true;

	@Column(name = "enabled")
	private boolean enabled = true;

	@Lob
	@Column(name = "obj", length = 4096)
	private String obj = null;

	@Column(name = "startdate")
	private Date startdate = null;

	@Column(name = "enddate")
	private Date enddate = null;

	@Column(name = "startevery", length = 20)
	private String startevery = null;

	@Column(name = "weekday")
	private int weekday;

	@Column(name = "billingtype", length = 20)
	private String billingtype = null;

	@Column(name = "executed")
	private boolean executed  = false;

	public BillingSchedule() {
	}

	public BillingSchedule(BillingScheduleId id) {
		super();
		this.id = id;
	}

	public String getDomainKey() {
		return id.getDomainKey();
	}

	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	public String getTargetDomain() {
		return id.getTargetDomain();
	}

	public void setTargetDomain(String targetDomain) {
		id.setTargetDomain(targetDomain);
	}

	public String getScheduleId() {
		return id.getScheduleId();
	}

	public void setScheduleId(String scheduleId) {
		id.setScheduleId(scheduleId);
	}

	public String getInvoicename() {
		return invoicename;
	}

	public void setInvoicename(String invoicename) {
		this.invoicename = invoicename;
	}

	public String getInvoicecode() {
		return invoicecode;
	}

	public void setInvoicecode(String invoicecode) {
		this.invoicecode = invoicecode;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getPayername() {
		return payername;
	}

	public void setPayername(String payername) {
		this.payername = payername;
	}

	public boolean isDiscounteditems() {
		return discounteditems;
	}

	public void setDiscounteditems(boolean discounteditems) {
		this.discounteditems = discounteditems;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getStartevery() {
		return startevery;
	}

	public void setStartevery(String startevery) {
		this.startevery = startevery;
	}

	public int getWeekday() {
		return weekday;
	}

	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}

	public String getBillingtype() {
		return billingtype;
	}

	public void setBillingtype(String billingtype) {
		this.billingtype = billingtype;
	}

	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((billingtype == null) ? 0 : billingtype.hashCode());
		result = prime * result + ((companyname == null) ? 0 : companyname.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + (discounteditems ? 1231 : 1237);
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((enddate == null) ? 0 : enddate.hashCode());
		result = prime * result + (executed ? 1231 : 1237);
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoicecode == null) ? 0 : invoicecode.hashCode());
		result = prime * result + ((invoicename == null) ? 0 : invoicename.hashCode());
		result = prime * result + ((obj == null) ? 0 : obj.hashCode());
		result = prime * result + ((payername == null) ? 0 : payername.hashCode());
		result = prime * result + ((startdate == null) ? 0 : startdate.hashCode());
		result = prime * result + ((startevery == null) ? 0 : startevery.hashCode());
		result = prime * result + weekday;
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
		BillingSchedule other = (BillingSchedule) obj;
		if (billingtype == null) {
			if (other.billingtype != null)
				return false;
		} else if (!billingtype.equals(other.billingtype))
			return false;
		if (companyname == null) {
			if (other.companyname != null)
				return false;
		} else if (!companyname.equals(other.companyname))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (discounteditems != other.discounteditems)
			return false;
		if (enabled != other.enabled)
			return false;
		if (enddate == null) {
			if (other.enddate != null)
				return false;
		} else if (!enddate.equals(other.enddate))
			return false;
		if (executed != other.executed)
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoicecode == null) {
			if (other.invoicecode != null)
				return false;
		} else if (!invoicecode.equals(other.invoicecode))
			return false;
		if (invoicename == null) {
			if (other.invoicename != null)
				return false;
		} else if (!invoicename.equals(other.invoicename))
			return false;
		if (this.obj == null) {
			if (other.obj != null)
				return false;
		} else if (!this.obj.equals(other.obj))
			return false;
		if (payername == null) {
			if (other.payername != null)
				return false;
		} else if (!payername.equals(other.payername))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		if (startevery == null) {
			if (other.startevery != null)
				return false;
		} else if (!startevery.equals(other.startevery))
			return false;
		if (weekday != other.weekday)
			return false;
		return true;
	}

}
