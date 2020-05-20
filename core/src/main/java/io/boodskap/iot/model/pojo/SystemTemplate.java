package io.boodskap.iot.model.pojo;

import java.util.Date;

import io.boodskap.iot.TemplateScriptLanguage;
import io.boodskap.iot.model.ISystemTemplate;

public class SystemTemplate implements ISystemTemplate {

	private static final long serialVersionUID = -7130221747939431559L;

	private String name = null;
	private TemplateScriptLanguage language = null;
	private String code = null;
	private Date createdStamp;
	private Date updatedStamp;
	
	public SystemTemplate() {
	}

	public SystemTemplate(String name) {
		this.name = name;
	}

	public SystemTemplate(String name, TemplateScriptLanguage language, Date createdStamp, Date updatedStamp) {
		super();
		this.name = name;
		this.language = language;
		this.createdStamp = createdStamp;
		this.updatedStamp = updatedStamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public Date getUpdatedStamp() {
		return updatedStamp;
	}

	public void setUpdatedStamp(Date updatedStamp) {
		this.updatedStamp = updatedStamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SystemTemplate other = (SystemTemplate) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (language != other.language)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
