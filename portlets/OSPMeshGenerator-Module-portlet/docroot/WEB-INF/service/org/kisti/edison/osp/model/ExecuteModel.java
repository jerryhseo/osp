/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.kisti.edison.osp.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import org.kisti.edison.osp.service.persistence.ExecutePK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Execute service. Represents a row in the &quot;EDMESH_Execute&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.osp.model.impl.ExecuteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.osp.model.impl.ExecuteImpl}.
 * </p>
 *
 * @author edison
 * @see Execute
 * @see org.kisti.edison.osp.model.impl.ExecuteImpl
 * @see org.kisti.edison.osp.model.impl.ExecuteModelImpl
 * @generated
 */
public interface ExecuteModel extends BaseModel<Execute> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a execute model instance should use the {@link Execute} interface instead.
	 */

	/**
	 * Returns the primary key of this execute.
	 *
	 * @return the primary key of this execute
	 */
	public ExecutePK getPrimaryKey();

	/**
	 * Sets the primary key of this execute.
	 *
	 * @param primaryKey the primary key of this execute
	 */
	public void setPrimaryKey(ExecutePK primaryKey);

	/**
	 * Returns the project ID of this execute.
	 *
	 * @return the project ID of this execute
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this execute.
	 *
	 * @param projectId the project ID of this execute
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the execute ID of this execute.
	 *
	 * @return the execute ID of this execute
	 */
	@AutoEscape
	public String getExecuteId();

	/**
	 * Sets the execute ID of this execute.
	 *
	 * @param executeId the execute ID of this execute
	 */
	public void setExecuteId(String executeId);

	/**
	 * Returns the execute data structure of this execute.
	 *
	 * @return the execute data structure of this execute
	 */
	@AutoEscape
	public String getExecuteDataStructure();

	/**
	 * Sets the execute data structure of this execute.
	 *
	 * @param executeDataStructure the execute data structure of this execute
	 */
	public void setExecuteDataStructure(String executeDataStructure);

	/**
	 * Returns the execute date of this execute.
	 *
	 * @return the execute date of this execute
	 */
	public Date getExecuteDate();

	/**
	 * Sets the execute date of this execute.
	 *
	 * @param executeDate the execute date of this execute
	 */
	public void setExecuteDate(Date executeDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(org.kisti.edison.osp.model.Execute execute);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.osp.model.Execute> toCacheModel();

	@Override
	public org.kisti.edison.osp.model.Execute toEscapedModel();

	@Override
	public org.kisti.edison.osp.model.Execute toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}