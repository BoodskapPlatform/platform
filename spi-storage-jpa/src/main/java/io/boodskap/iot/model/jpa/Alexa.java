package io.boodskap.iot.model.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IAlexa;

@Entity
@Table(name="alexa")
public class Alexa implements IAlexa {

	private static final long serialVersionUID = -7983470981398356497L;

	@EmbeddedId
	private AlexaId id = new AlexaId();
	
	@Column(name="rtype", length=80)
	private String ruleType;
	
	@Column(name="rdname", length=80)
	private String ruleName;
	
	@Column(name="iname", length=80)
	private String intentName;
	
	@Column(name="eresponse", length=256)
	private String errorResponse;
	
	@Column(name="createdby", length=80)
	private String createdBy;

	@Column(name="rstamp")
	private Date registeredStamp = new Date();
	
	@Column(name="ustamp")
	private Date updatedStamp = new Date();
	
	public Alexa() {
	}

	public Alexa(AlexaId id) {
		this.id = id;
	}

	@Override
	public String getDomainKey() {
		return id.getDomainKey();
	}

	@Override
	public void setDomainKey(String domainKey) {
		id.setDomainKey(domainKey);
	}

	@Override
	public String getAlexaId() {
		return id.getAlexaId();
	}

	@Override
	public void setAlexaId(String alexaId) {
		id.setAlexaId(alexaId);
	}

	@Override
	public String getRuleType() {
		return ruleType;
	}

	@Override
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	@Override
	public String getRuleName() {
		return ruleName;
	}

	@Override
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	@Override
	public String getIntentName() {
		return intentName;
	}

	@Override
	public void setIntentName(String intentName) {
		this.intentName = intentName;
	}

	@Override
	public String getErrorResponse() {
		return errorResponse;
	}

	@Override
	public void setErrorResponse(String errorResponse) {
		this.errorResponse = errorResponse;
	}

	@Override
	public String getCreatedBy() {
		return createdBy;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public Date getRegisteredStamp() {
		return registeredStamp;
	}

	@Override
	public void setRegisteredStamp(Date registeredStamp) {
		this.registeredStamp = registeredStamp;
	}

	@Override
	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	@Override
	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((errorResponse == null) ? 0 : errorResponse.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intentName == null) ? 0 : intentName.hashCode());
		result = prime * result + ((registeredStamp == null) ? 0 : registeredStamp.hashCode());
		result = prime * result + ((ruleName == null) ? 0 : ruleName.hashCode());
		result = prime * result + ((ruleType == null) ? 0 : ruleType.hashCode());
		result = prime * result + ((updatedStamp == null) ? 0 : updatedStamp.hashCode());
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
		Alexa other = (Alexa) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (errorResponse == null) {
			if (other.errorResponse != null)
				return false;
		} else if (!errorResponse.equals(other.errorResponse))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intentName == null) {
			if (other.intentName != null)
				return false;
		} else if (!intentName.equals(other.intentName))
			return false;
		if (registeredStamp == null) {
			if (other.registeredStamp != null)
				return false;
		} else if (!registeredStamp.equals(other.registeredStamp))
			return false;
		if (ruleName == null) {
			if (other.ruleName != null)
				return false;
		} else if (!ruleName.equals(other.ruleName))
			return false;
		if (ruleType == null) {
			if (other.ruleType != null)
				return false;
		} else if (!ruleType.equals(other.ruleType))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
