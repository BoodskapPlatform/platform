package io.boodskap.iot.model.pojo;

import io.boodskap.iot.TemplateScriptLanguage;
import io.boodskap.iot.model.ISystemTemplate;

public class SystemTemplate extends AbstractModel implements ISystemTemplate {

	private static final long serialVersionUID = -7130221747939431559L;

	private TemplateScriptLanguage language = null;
	private String code = null;
	
	public SystemTemplate() {
	}

	public TemplateScriptLanguage getLanguage() {
		return language;
	}

	public void setLanguage(TemplateScriptLanguage language) {
		this.language = language;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
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
		SystemTemplate other = (SystemTemplate) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (language != other.language)
			return false;
		return true;
	}

}
