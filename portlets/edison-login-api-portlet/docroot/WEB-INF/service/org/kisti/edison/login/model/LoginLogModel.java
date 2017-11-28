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

package org.kisti.edison.login.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LoginLog service. Represents a row in the &quot;EDLOG_LoginLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.login.model.impl.LoginLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.login.model.impl.LoginLogImpl}.
 * </p>
 *
 * @author yjpark
 * @see LoginLog
 * @see org.kisti.edison.login.model.impl.LoginLogImpl
 * @see org.kisti.edison.login.model.impl.LoginLogModelImpl
 * @generated
 */
public interface LoginLogModel extends BaseModel<LoginLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a login log model instance should use the {@link LoginLog} interface instead.
	 */

	/**
	 * Returns the primary key of this login log.
	 *
	 * @return the primary key of this login log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this login log.
	 *
	 * @param primaryKey the primary key of this login log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this login log.
	 *
	 * @return the ID of this login log
	 */
	public long getId();

	/**
	 * Sets the ID of this login log.
	 *
	 * @param id the ID of this login log
	 */
	public void setId(long id);

	/**
	 * Returns the create date of this login log.
	 *
	 * @return the create date of this login log
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this login log.
	 *
	 * @param createDate the create date of this login log
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the user ID of this login log.
	 *
	 * @return the user ID of this login log
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this login log.
	 *
	 * @param userId the user ID of this login log
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this login log.
	 *
	 * @return the user uuid of this login log
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this login log.
	 *
	 * @param userUuid the user uuid of this login log
	 */
	public void setUserUuid(String userUuid);

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
	public int compareTo(org.kisti.edison.login.model.LoginLog loginLog);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.login.model.LoginLog> toCacheModel();

	@Override
	public org.kisti.edison.login.model.LoginLog toEscapedModel();

	@Override
	public org.kisti.edison.login.model.LoginLog toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}