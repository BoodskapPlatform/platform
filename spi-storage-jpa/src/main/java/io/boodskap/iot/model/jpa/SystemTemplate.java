package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.TemplateScriptLanguage;
import io.boodskap.iot.model.ISystemTemplate;

@Entity
@Table(name="systemtemplate")
public class SystemTemplate extends AbstractModel implements ISystemTemplate {

	private static final long serialVersionUID = -7130221747939431559L;

	@Id
	@Column(name="name", length=80)
	private String name = null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="language", length=12)
	private TemplateScriptLanguage language = null;
	
	@Lob
	@Column(name="code", length=SizeConstants.TEMPLATE_CODE_SIZE)
	private String code = null;
	
	public SystemTemplate() {
	}

	public SystemTemplate(String name) {
		this.name = name;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
