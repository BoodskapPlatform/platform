/*******************************************************************************
 * Copyright (C) 2019 Boodskap Inc
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package io.boodskap.iot.plugin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Maven Central Jar dependencies
 * 
 * @author Jegan Vincent
 *
 */
public class PluginDependency implements Serializable {
	
	private static final long serialVersionUID = -8501315489317129479L;
	
	private List<Dependency> deps = new ArrayList<>();
	private List<String> exclusions = new ArrayList<>();
	
	public PluginDependency() {
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public List<Dependency> getDeps() {
		return deps;
	}

	public void setDeps(List<Dependency> deps) {
		this.deps = deps;
	}

	public void add(Dependency... deps) {
		this.deps.addAll(Arrays.asList(deps));
	}
	
	public List<String> getExclusions() {
		return exclusions;
	}

	public void setExclusions(List<String> exclusions) {
		this.exclusions = exclusions;
	}
	
	public void add(String... exclusions) {
		this.exclusions.addAll(Arrays.asList(exclusions));
	}

	/**
	 * Method to convert to JSON String
	 * @return {@link String} in JSON format or null on failure
	 */
	public String toJson() {
		try {
			return JsonUtil.toJSON(this);
		} catch (JsonProcessingException e) {
		}
		return null;
	}
	
	@Override
	public String toString() {
		String json = toJson();
		if(null == json) return super.toString();
		return json;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deps == null) ? 0 : deps.hashCode());
		result = prime * result + ((exclusions == null) ? 0 : exclusions.hashCode());
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
		PluginDependency other = (PluginDependency) obj;
		if (deps == null) {
			if (other.deps != null)
				return false;
		} else if (!deps.equals(other.deps))
			return false;
		if (exclusions == null) {
			if (other.exclusions != null)
				return false;
		} else if (!exclusions.equals(other.exclusions))
			return false;
		return true;
	}

	public static class Builder{
		
		private final PluginDependency deps = new PluginDependency();
		
		private Builder() {
		}
		
		public Builder add(String group, String artifact, String version) {
			deps.add(new Dependency(group, artifact, version));
			return this;
		}
		
		public Builder add(Dependency dep) {
			this.deps.add(dep);
			return this;
		}
		
		public Builder add(String... exclusions) {
			this.deps.add(exclusions);
			return this;
		}
		
		public String build() {
			return deps.toJson();
		}
	}
}
