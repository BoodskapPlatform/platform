package io.boodskap.iot.model.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.boodskap.iot.RuleScriptLanguage;
import io.boodskap.iot.model.IRule;

public abstract class AbstractRule extends AbstractModel implements IRule {

	private static final long serialVersionUID = 1059255536340100723L;

	private String domainKey;
	private RuleScriptLanguage language;
	private String code;
	private boolean compilable;
	private List<String> contexts = new ArrayList<>();
	private List<String> plugins = new ArrayList<>();
	private String loader;
	private String globalLoader;
	
	public AbstractRule() {
	}

	public AbstractRule(String domainKey) {
		this.domainKey = domainKey;
	}

	public final String getDomainKey() {
		return domainKey;
	}

	public final void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
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
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + (compilable ? 1231 : 1237);
		result = prime * result + ((contexts == null) ? 0 : contexts.hashCode());
		result = prime * result + ((globalLoader == null) ? 0 : globalLoader.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((loader == null) ? 0 : loader.hashCode());
		result = prime * result + ((plugins == null) ? 0 : plugins.hashCode());
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
		return true;
	}

}
