package io.boodskap.iot.model.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import io.boodskap.iot.RuleScriptLanguage;
import io.boodskap.iot.model.IRule;

@MappedSuperclass
public abstract class AbstractRule extends AbstractModel implements IRule {

	private static final long serialVersionUID = 1059255536340100723L;

	@Column(name="language", length=20)
	@Enumerated(EnumType.STRING)
	private RuleScriptLanguage language;
	
	@Column(name="code", length=4096)
	private String code;
	
	@Column(name="compilable")
	private boolean compilable;
	
	@ElementCollection(targetClass=String.class)
	@Column(name="contexts", length=40)
	private List<String> contexts = new ArrayList<>();
	
	@ElementCollection(targetClass=String.class)
	@Column(name="plugins", length=40)
	private List<String> plugins = new ArrayList<>();
	
	@Column(name="loader", length=40)
	private String loader;
	
	@Column(name="globalloader", length=40)
	private String globalLoader;
	
	public AbstractRule() {
	}

	public final RuleScriptLanguage getLanguage() {
		return language;
	}

	public final void setLanguage(RuleScriptLanguage language) {
		this.language = language;
	}

	public final String getCode() {
		return code;
	}

	public final void setCode(String code) {
		this.code = code;
	}

	@Override
	public final Collection<String> getContexts() {
		return contexts;
	}

	@Override
	public final void setContexts(Collection<String> contexts) {
		this.contexts.clear();
		this.contexts.addAll(contexts);
	}

	@Override
	public final Collection<String> getPlugins() {
		return plugins;
	}

	@Override
	public final void setPlugins(Collection<String> plugins) {
		this.plugins.clear();
		this.plugins.addAll(plugins);
	}

	@Override
	public final boolean isCompilable() {
		return compilable;
	}

	@Override
	public final void setCompilable(boolean compilable) {
		this.compilable = compilable;
	}

	public final String getLoader() {
		return loader;
	}

	public final void setLoader(String loader) {
		this.loader = loader;
	}

	public final String getGlobalLoader() {
		return globalLoader;
	}

	public final void setGlobalLoader(String globalLoader) {
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
