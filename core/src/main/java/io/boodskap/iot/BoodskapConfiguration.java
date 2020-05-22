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
package io.boodskap.iot;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BoodskapConfiguration implements IConfig{
	
	private static final long serialVersionUID = 7078124126063442833L;
	
	private static final BoodskapConfiguration instance = new BoodskapConfiguration();
	
	private String domainKey;
	private String apiKey;
	private String clusterId;
	private String cacheFactory;
	private String gridFactory;
	private String storageFactory;
	private String rawStorageFactory;
	private String dynamicStorageFactory;
	private int logOfferTimeout;
	private boolean idRangeEnabled;
	private int maxDomainId;
	private boolean workerMode;
	private int startPage;
	private int defaultSearchPageSize;
	private boolean autoCreateDevices;
	private List<String> serviceFactories = new ArrayList<>();

	private BoodskapConfiguration() {
		setDefaults();
	}
	
	public static BoodskapConfiguration get() {
		return instance;
	}
	
	@Override
	@JsonIgnore
	public int getStartPriority() {
		return 0;
	}

	@Override
	public void setDefaults() {
		logOfferTimeout = 2;
		idRangeEnabled = false;
		maxDomainId = 9999;
		workerMode = false;
		startPage = 0;
		defaultSearchPageSize = 25;
		autoCreateDevices = true;
	}

	public String getGridFactory() {
		return gridFactory;
	}

	public String getRawStorageFactory() {
		return rawStorageFactory;
	}

	public String getDynamicStorageFactory() {
		return dynamicStorageFactory;
	}

	public void setDynamicStorageFactory(String dynamicStorageFactory) {
		this.dynamicStorageFactory = dynamicStorageFactory;
	}

	public String getStorageFactory() {
		return storageFactory;
	}

	public String getCacheFactory() {
		return cacheFactory;
	}

	public int getLogOfferTimeout() {
		return logOfferTimeout;
	}

	public boolean isIdRangeEnabled() {
		return idRangeEnabled;
	}

	public int getMaxDomainId() {
		return maxDomainId;
	}

	public void setGridFactory(String gridFactory) {
		this.gridFactory = gridFactory;
	}

	public void setRawStorageFactory(String rawStorageFactory) {
		this.rawStorageFactory = rawStorageFactory;
	}

	public void setStorageFactory(String storageFactory) {
		this.storageFactory = storageFactory;
	}

	public void setCacheFactory(String cacheFactory) {
		this.cacheFactory = cacheFactory;
	}

	public void setLogOfferTimeout(int logOfferTimeout) {
		this.logOfferTimeout = logOfferTimeout;
	}

	public void setIdRangeEnabled(boolean idRangeEnabled) {
		this.idRangeEnabled = idRangeEnabled;
	}

	public void setMaxDomainId(int maxDomainId) {
		this.maxDomainId = maxDomainId;
	}

	public List<String> getServiceFactories() {
		return serviceFactories;
	}

	public void setServiceFactories(List<String> serviceFactories) {
		this.serviceFactories = serviceFactories;
	}

	public String getDomainKey() {
		return domainKey;
	}

	public void setDomainKey(String domainKey) {
		this.domainKey = domainKey;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public boolean isWorkerMode() {
		return workerMode;
	}

	public void setWorkerMode(boolean workerMode) {
		this.workerMode = workerMode;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getDefaultSearchPageSize() {
		return defaultSearchPageSize;
	}

	public void setDefaultSearchPageSize(int defaultSearchPageSize) {
		this.defaultSearchPageSize = defaultSearchPageSize;
	}

	public boolean isAutoCreateDevices() {
		return autoCreateDevices;
	}

	public void setAutoCreateDevices(boolean autoCreateDevices) {
		this.autoCreateDevices = autoCreateDevices;
	}

}
