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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CommonModule}.
 * </p>
 *
 * @author EDISON
 * @see CommonModule
 * @generated
 */
public class CommonModuleWrapper implements CommonModule,
	ModelWrapper<CommonModule> {
	public CommonModuleWrapper(CommonModule commonModule) {
		_commonModule = commonModule;
	}

	@Override
	public Class<?> getModelClass() {
		return CommonModule.class;
	}

	@Override
	public String getModelClassName() {
		return CommonModule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commonModuleId", getCommonModuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("moduleName", getModuleName());
		attributes.put("moduleVersion", getModuleVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commonModuleId = (Long)attributes.get("commonModuleId");

		if (commonModuleId != null) {
			setCommonModuleId(commonModuleId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		String moduleVersion = (String)attributes.get("moduleVersion");

		if (moduleVersion != null) {
			setModuleVersion(moduleVersion);
		}
	}

	/**
	* Returns the primary key of this common module.
	*
	* @return the primary key of this common module
	*/
	@Override
	public long getPrimaryKey() {
		return _commonModule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this common module.
	*
	* @param primaryKey the primary key of this common module
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_commonModule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the common module ID of this common module.
	*
	* @return the common module ID of this common module
	*/
	@Override
	public long getCommonModuleId() {
		return _commonModule.getCommonModuleId();
	}

	/**
	* Sets the common module ID of this common module.
	*
	* @param commonModuleId the common module ID of this common module
	*/
	@Override
	public void setCommonModuleId(long commonModuleId) {
		_commonModule.setCommonModuleId(commonModuleId);
	}

	/**
	* Returns the group ID of this common module.
	*
	* @return the group ID of this common module
	*/
	@Override
	public long getGroupId() {
		return _commonModule.getGroupId();
	}

	/**
	* Sets the group ID of this common module.
	*
	* @param groupId the group ID of this common module
	*/
	@Override
	public void setGroupId(long groupId) {
		_commonModule.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this common module.
	*
	* @return the company ID of this common module
	*/
	@Override
	public long getCompanyId() {
		return _commonModule.getCompanyId();
	}

	/**
	* Sets the company ID of this common module.
	*
	* @param companyId the company ID of this common module
	*/
	@Override
	public void setCompanyId(long companyId) {
		_commonModule.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this common module.
	*
	* @return the user ID of this common module
	*/
	@Override
	public long getUserId() {
		return _commonModule.getUserId();
	}

	/**
	* Sets the user ID of this common module.
	*
	* @param userId the user ID of this common module
	*/
	@Override
	public void setUserId(long userId) {
		_commonModule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this common module.
	*
	* @return the user uuid of this common module
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonModule.getUserUuid();
	}

	/**
	* Sets the user uuid of this common module.
	*
	* @param userUuid the user uuid of this common module
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_commonModule.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this common module.
	*
	* @return the create date of this common module
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _commonModule.getCreateDate();
	}

	/**
	* Sets the create date of this common module.
	*
	* @param createDate the create date of this common module
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_commonModule.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this common module.
	*
	* @return the modified date of this common module
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _commonModule.getModifiedDate();
	}

	/**
	* Sets the modified date of this common module.
	*
	* @param modifiedDate the modified date of this common module
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_commonModule.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the module name of this common module.
	*
	* @return the module name of this common module
	*/
	@Override
	public java.lang.String getModuleName() {
		return _commonModule.getModuleName();
	}

	/**
	* Sets the module name of this common module.
	*
	* @param moduleName the module name of this common module
	*/
	@Override
	public void setModuleName(java.lang.String moduleName) {
		_commonModule.setModuleName(moduleName);
	}

	/**
	* Returns the module version of this common module.
	*
	* @return the module version of this common module
	*/
	@Override
	public java.lang.String getModuleVersion() {
		return _commonModule.getModuleVersion();
	}

	/**
	* Sets the module version of this common module.
	*
	* @param moduleVersion the module version of this common module
	*/
	@Override
	public void setModuleVersion(java.lang.String moduleVersion) {
		_commonModule.setModuleVersion(moduleVersion);
	}

	@Override
	public boolean isNew() {
		return _commonModule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_commonModule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _commonModule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_commonModule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _commonModule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _commonModule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_commonModule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _commonModule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_commonModule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_commonModule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_commonModule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CommonModuleWrapper((CommonModule)_commonModule.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.science.model.CommonModule commonModule) {
		return _commonModule.compareTo(commonModule);
	}

	@Override
	public int hashCode() {
		return _commonModule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.CommonModule> toCacheModel() {
		return _commonModule.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.CommonModule toEscapedModel() {
		return new CommonModuleWrapper(_commonModule.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.CommonModule toUnescapedModel() {
		return new CommonModuleWrapper(_commonModule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _commonModule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _commonModule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_commonModule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonModuleWrapper)) {
			return false;
		}

		CommonModuleWrapper commonModuleWrapper = (CommonModuleWrapper)obj;

		if (Validator.equals(_commonModule, commonModuleWrapper._commonModule)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CommonModule getWrappedCommonModule() {
		return _commonModule;
	}

	@Override
	public CommonModule getWrappedModel() {
		return _commonModule;
	}

	@Override
	public void resetOriginalValues() {
		_commonModule.resetOriginalValues();
	}

	private CommonModule _commonModule;
}