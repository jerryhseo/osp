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

package org.kisti.edison.science.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ScienceAppInputPorts service. Represents a row in the &quot;EDAPP_ScienceAppInputPorts&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.science.model.impl.ScienceAppInputPortsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.science.model.impl.ScienceAppInputPortsImpl}.
 * </p>
 *
 * @author EDISON
 * @see ScienceAppInputPorts
 * @see org.kisti.edison.science.model.impl.ScienceAppInputPortsImpl
 * @see org.kisti.edison.science.model.impl.ScienceAppInputPortsModelImpl
 * @generated
 */
public interface ScienceAppInputPortsModel extends BaseModel<ScienceAppInputPorts> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a science app input ports model instance should use the {@link ScienceAppInputPorts} interface instead.
	 */

	/**
	 * Returns the primary key of this science app input ports.
	 *
	 * @return the primary key of this science app input ports
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this science app input ports.
	 *
	 * @param primaryKey the primary key of this science app input ports
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the science app ID of this science app input ports.
	 *
	 * @return the science app ID of this science app input ports
	 */
	public long getScienceAppId();

	/**
	 * Sets the science app ID of this science app input ports.
	 *
	 * @param scienceAppId the science app ID of this science app input ports
	 */
	public void setScienceAppId(long scienceAppId);

	/**
	 * Returns the input ports sample file of this science app input ports.
	 *
	 * @return the input ports sample file of this science app input ports
	 */
	@AutoEscape
	public String getInputPortsSampleFile();

	/**
	 * Sets the input ports sample file of this science app input ports.
	 *
	 * @param inputPortsSampleFile the input ports sample file of this science app input ports
	 */
	public void setInputPortsSampleFile(String inputPortsSampleFile);

	/**
	 * Returns the input ports of this science app input ports.
	 *
	 * @return the input ports of this science app input ports
	 */
	@AutoEscape
	public String getInputPorts();

	/**
	 * Sets the input ports of this science app input ports.
	 *
	 * @param inputPorts the input ports of this science app input ports
	 */
	public void setInputPorts(String inputPorts);

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
	public int compareTo(
		org.kisti.edison.science.model.ScienceAppInputPorts scienceAppInputPorts);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.science.model.ScienceAppInputPorts> toCacheModel();

	@Override
	public org.kisti.edison.science.model.ScienceAppInputPorts toEscapedModel();

	@Override
	public org.kisti.edison.science.model.ScienceAppInputPorts toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}