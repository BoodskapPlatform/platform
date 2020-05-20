package io.boodskap.iot.model.pojo;


import io.boodskap.iot.model.IPlugin;
import io.boodskap.iot.plugin.PluginType;

public class Plugin implements IPlugin {

	private static final long serialVersionUID = 5195867514141380004L;
	
	private String pluginId;
	private String version;
	private String contextId;
	private String systemId;
	private PluginType type;
	private String desc;
	private String author;
	private String clazz;
	private String crc;
	private String readme;
	private String jsonContent;

	public Plugin() {
	}

	public Plugin(String pluginId, String version) {
		this.pluginId = pluginId;
		this.version = version;
	}

	public String getPluginId() {
		return pluginId;
	}

	public void setPluginId(String pluginId) {
		this.pluginId = pluginId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result + ((contextId == null) ? 0 : contextId.hashCode());
		result = prime * result + ((crc == null) ? 0 : crc.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((jsonContent == null) ? 0 : jsonContent.hashCode());
		result = prime * result + ((pluginId == null) ? 0 : pluginId.hashCode());
		result = prime * result + ((readme == null) ? 0 : readme.hashCode());
		result = prime * result + ((systemId == null) ? 0 : systemId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (jsonContent == null) {
			if (other.jsonContent != null)
				return false;
		} else if (!jsonContent.equals(other.jsonContent))
			return false;
		if (pluginId == null) {
			if (other.pluginId != null)
				return false;
		} else if (!pluginId.equals(other.pluginId))
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
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
