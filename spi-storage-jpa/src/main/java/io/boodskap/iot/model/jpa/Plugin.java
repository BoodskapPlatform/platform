package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.boodskap.iot.model.IPlugin;
import io.boodskap.iot.plugin.PluginType;

@Entity
@Table(name="plugin")
public class Plugin extends AbstractModel implements IPlugin {

	private static final long serialVersionUID = 5195867514141380004L;
	
	@EmbeddedId
	private PluginId id = new PluginId();
	
	@Column(name="contextid", length=20)
	private String contextId;
	
	@Column(name="systemid", length=20)
	private String systemId;
	
	@Column(name="type", length=12)
	private PluginType type;
	
	@Column(name="author", length=80)
	private String author;
	
	@Column(name="clazz", length=400)
	private String clazz;
	
	@Column(name="crc", length=40)
	private String crc;
	
	@Column(name="readme", length=4096)
	private String readme;
	
	@Column(name="jsoncontent", length=8192)
	private String jsonContent;

	public Plugin() {
	}

	public Plugin(PluginId id) {
		this.id = id;
	}

	public String getPluginId() {
		return id.getPluginId();
	}

	public void setPluginId(String pluginId) {
		id.setPluginId(pluginId);
	}

	public String getVersion() {
		return id.getVersion();
	}

	public void setVersion(String version) {
		id.setVersion(version);
	}

	public String getContextId() {
		return contextId;
	}

	public void setContextId(String contextId) {
		this.contextId = contextId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public PluginType getType() {
		return type;
	}

	public void setType(PluginType type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getCrc() {
		return crc;
	}

	public void setCrc(String crc) {
		this.crc = crc;
	}

	public String getReadme() {
		return readme;
	}

	public void setReadme(String readme) {
		this.readme = readme;
	}

	public String getJsonContent() {
		return jsonContent;
	}

	public void setJsonContent(String jsonContent) {
		this.jsonContent = jsonContent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result + ((contextId == null) ? 0 : contextId.hashCode());
		result = prime * result + ((crc == null) ? 0 : crc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((jsonContent == null) ? 0 : jsonContent.hashCode());
		result = prime * result + ((readme == null) ? 0 : readme.hashCode());
		result = prime * result + ((systemId == null) ? 0 : systemId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Plugin other = (Plugin) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		if (contextId == null) {
			if (other.contextId != null)
				return false;
		} else if (!contextId.equals(other.contextId))
			return false;
		if (crc == null) {
			if (other.crc != null)
				return false;
		} else if (!crc.equals(other.crc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (jsonContent == null) {
			if (other.jsonContent != null)
				return false;
		} else if (!jsonContent.equals(other.jsonContent))
			return false;
		if (readme == null) {
			if (other.readme != null)
				return false;
		} else if (!readme.equals(other.readme))
			return false;
		if (systemId == null) {
			if (other.systemId != null)
				return false;
		} else if (!systemId.equals(other.systemId))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
