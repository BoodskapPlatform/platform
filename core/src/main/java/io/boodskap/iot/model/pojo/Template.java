package io.boodskap.iot.model.pojo;

import io.boodskap.iot.model.ITemplate;

public class Template extends SystemTemplate  implements ITemplate {

	private static final long serialVersionUID = 4692755922250173262L;

	private String domainKey;
	
	public Template() {
	}

	@Override
	public String getDomainKey() {
		return domainKey;
	}

	@Override
	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((domainKey == null) ? 0 : domainKey.hashCode());
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
		Template other = (Template) obj;
		if (domainKey == null) {
			if (other.domainKey != null)
				return false;
		} else if (!domainKey.equals(other.domainKey))
			return false;
		return true;
	}

}
