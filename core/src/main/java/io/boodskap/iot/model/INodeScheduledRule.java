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
package io.boodskap.iot.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.boodskap.iot.BoodskapSystem;
import io.boodskap.iot.dao.NodeScheduledRuleDAO;

@JsonSerialize(as=INodeScheduledRule.class)
public interface INodeScheduledRule extends IDomainObject{
	
	public static INodeScheduledRule create(String domainKey, String ruleId, String nodeId) {
		return BoodskapSystem.storage().getNodeScheduledRuleDAO().create(domainKey, ruleId, nodeId);
	}

	public String getRuleId();

	public void setRuleId(String ruleId);

	public String getNodeId();

	public void setNodeId(String nodeId);

	public default void save() {
		NodeScheduledRuleDAO.get().createOrUpdate(this);
	}

}
