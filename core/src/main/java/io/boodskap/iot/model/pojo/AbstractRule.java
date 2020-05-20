package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import io.boodskap.iot.RuleScriptLanguage;
import io.boodskap.iot.model.IRule;

public abstract class AbstractRule implements IRule {

	private static final long serialVersionUID = 1059255536340100723L;

	private RuleScriptLanguage language;
	private String code;
	private boolean compilable;
	private List<String> contexts = new ArrayList<>();
	private List<String> plugins = new ArrayList<>();
	private Date createdStamp;
	private Date updatedStamp;
	private String description;
	private String loader;
	private String globalLoader;
	
	public AbstractRule() {
	}

	public RuleScriptLanguage getLanguage() {
		return language;
	}

	public void setLanguage(RuleScriptLanguage language) {
		this.language = language;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public Collection<String> getContexts() {
		return contexts;
	}

	@Override
	public void setContexts(Collection<String> contexts) {
		this.contexts.clear();
		this.contexts.addAll(contexts);
	}

	@Override
	public Collection<String> getPlugins() {
		return plugins;
	}

	@Override
	public void setPlugins(Collection<String> plugins) {
		this.plugins.clear();
		this.plugins.addAll(plugins);
	}

	@Override
	public boolean isCompilable() {
		return compilable;
	}

	@Override
	public void setCompilable(boolean compilable) {
		this.compilable = compilable;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLoader() {
		return loader;
	}

	public void setLoader(String loader) {
		this.loader = loader;
	}

	public String getGlobalLoader() {
		return globalLoader;
	}

	public void setGlobalLoader(String globalLoader) {
		this.globalLoader = globalLoader;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + (compilable ? 1231 : 1237);
		result = prime * result + ((contexts == null) ? 0 : contexts.hashCode());
		result = prime * result + ((createdStamp == null) ? 0 : createdStamp.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((globalLoader == null) ? 0 : globalLoader.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((loader == null) ? 0 : loader.hashCode());
		result = prime * result + ((plugins == null) ? 0 : plugins.hashCode());
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
		AbstractRule other = (AbstractRule) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (compilable != other.compilable)
			return false;
		if (contexts == null) {
			if (other.contexts != null)
				return false;
		} else if (!contexts.equals(other.contexts))
			return false;
		if (createdStamp == null) {
			if (other.createdStamp != null)
				return false;
		} else if (!createdStamp.equals(other.createdStamp))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (globalLoader == null) {
			if (other.globalLoader != null)
				return false;
		} else if (!globalLoader.equals(other.globalLoader))
			return false;
		if (language != other.language)
			return false;
		if (loader == null) {
			if (other.loader != null)
				return false;
		} else if (!loader.equals(other.loader))
			return false;
		if (plugins == null) {
			if (other.plugins != null)
				return false;
		} else if (!plugins.equals(other.plugins))
			return false;
		if (updatedStamp == null) {
			if (other.updatedStamp != null)
				return false;
		} else if (!updatedStamp.equals(other.updatedStamp))
			return false;
		return true;
	}

}
