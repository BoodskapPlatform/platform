package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.model.IBillingInvoice;

@Entity
@Table(name="billinginvoice")
public class BillingInvoice extends AbstractModel implements IBillingInvoice {

	private static final long serialVersionUID = 4021060188189620220L;
	
	@EmbeddedId
	private BillingInvoiceId id = new BillingInvoiceId();
	
	@Column(name="invoicename", length=120)
	private String invoicename = null;
	
	@Column(name="invoiceno", length=20)
	private String invoiceno = null;
	
	@Column(name="frequency", length=20)
	private String frequency = null;
	
	@Column(name="invoicetype", length=40)
	private String invoicetype = null;
	
	@Column(name="file", length=40)
	private String file = null;
	
	@Column(name="grandtotal")
	private double grandtotal;
	
	@Column(name="startdate")
	private Date startdate = null;
	
	@Column(name="enddate")
	private Date enddate = null;
	
	@Lob
	@Column(name="obj", length=4096)
	private String obj = null;

	public BillingInvoice() {
	}

	public BillingInvoice(BillingInvoiceId id) {
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

	public String getInvoiceId() {
		return id.getInvoiceId();
	}

	public void setInvoiceId(String invoiceId) {
		id.setInvoiceId(invoiceId);
	}

	public String getInvoicename() {
		return invoicename;
	}

	public void setInvoicename(String invoicename) {
		this.invoicename = invoicename;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public double getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
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

	public String getObj() {
		return obj;
	}

	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getInvoicetype() {
		return invoicetype;
	}

	public void setInvoicetype(String invoicetype) {
		this.invoicetype = invoicetype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((enddate == null) ? 0 : enddate.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		long temp;
		temp = Double.doubleToLongBits(grandtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoicename == null) ? 0 : invoicename.hashCode());
		result = prime * result + ((invoiceno == null) ? 0 : invoiceno.hashCode());
		result = prime * result + ((invoicetype == null) ? 0 : invoicetype.hashCode());
		result = prime * result + ((obj == null) ? 0 : obj.hashCode());
		result = prime * result + ((startdate == null) ? 0 : startdate.hashCode());
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
		BillingInvoice other = (BillingInvoice) obj;
		if (enddate == null) {
			if (other.enddate != null)
				return false;
		} else if (!enddate.equals(other.enddate))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (Double.doubleToLongBits(grandtotal) != Double.doubleToLongBits(other.grandtotal))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoicename == null) {
			if (other.invoicename != null)
				return false;
		} else if (!invoicename.equals(other.invoicename))
			return false;
		if (invoiceno == null) {
			if (other.invoiceno != null)
				return false;
		} else if (!invoiceno.equals(other.invoiceno))
			return false;
		if (invoicetype == null) {
			if (other.invoicetype != null)
				return false;
		} else if (!invoicetype.equals(other.invoicetype))
			return false;
		if (this.obj == null) {
			if (other.obj != null)
				return false;
		} else if (!this.obj.equals(other.obj))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		return true;
	}

}
