package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.IAlexa;

public class Alexa extends AbstractDomainObject implements IAlexa {
	
	private static final long serialVersionUID = -6074276558058668653L;
	
	private String alexaId;
	private String ruleType;
	private String ruleName;
	private String intentName;
	private String errorResponse;
	
	public Alexa() {
	}

	@Override
	public String getAlexaId() {
		return alexaId;
	}

	@Override
	public void setAlexaId(String alexaId) {
		this.alexaId = alexaId;
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((alexaId == null) ? 0 : alexaId.hashCode());
		result = prime * result + ((errorResponse == null) ? 0 : errorResponse.hashCode());
		result = prime * result + ((intentName == null) ? 0 : intentName.hashCode());
		result = prime * result + ((ruleName == null) ? 0 : ruleName.hashCode());
		result = prime * result + ((ruleType == null) ? 0 : ruleType.hashCode());
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
		Alexa other = (Alexa) obj;
		if (alexaId == null) {
			if (other.alexaId != null)
				return false;
		} else if (!alexaId.equals(other.alexaId))
			return false;
		if (errorResponse == null) {
			if (other.errorResponse != null)
				return false;
		} else if (!errorResponse.equals(other.errorResponse))
			return false;
		if (intentName == null) {
			if (other.intentName != null)
				return false;
		} else if (!intentName.equals(other.intentName))
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
		return true;
	}

}
