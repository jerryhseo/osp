/**
 * Copyright (c) 2016-present EDISON, KISTI. All rights reserved.
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

package org.kisti.edison.science.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.kisti.edison.science.model.ScienceAppCategoryLink;
import org.kisti.edison.science.model.ScienceAppCategoryLinkModel;
import org.kisti.edison.science.model.ScienceAppCategoryLinkSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ScienceAppCategoryLink service. Represents a row in the &quot;EDAPP_ScienceAppCategoryLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.science.model.ScienceAppCategoryLinkModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ScienceAppCategoryLinkImpl}.
 * </p>
 *
 * @author EDISON
 * @see ScienceAppCategoryLinkImpl
 * @see org.kisti.edison.science.model.ScienceAppCategoryLink
 * @see org.kisti.edison.science.model.ScienceAppCategoryLinkModel
 * @generated
 */
@JSON(strict = true)
public class ScienceAppCategoryLinkModelImpl extends BaseModelImpl<ScienceAppCategoryLink>
	implements ScienceAppCategoryLinkModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a science app category link model instance should use the {@link org.kisti.edison.science.model.ScienceAppCategoryLink} interface instead.
	 */
	public static final String TABLE_NAME = "EDAPP_ScienceAppCategoryLink";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "scienceAppCategoryLinkId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "categoryId", Types.BIGINT },
			{ "scienceAppId", Types.BIGINT },
			{ "parentCategoryId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table EDAPP_ScienceAppCategoryLink (uuid_ VARCHAR(75) null,scienceAppCategoryLinkId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,categoryId LONG,scienceAppId LONG,parentCategoryId LONG)";
	public static final String TABLE_SQL_DROP = "drop table EDAPP_ScienceAppCategoryLink";
	public static final String ORDER_BY_JPQL = " ORDER BY scienceAppCategoryLink.scienceAppCategoryLinkId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EDAPP_ScienceAppCategoryLink.scienceAppCategoryLinkId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.science.model.ScienceAppCategoryLink"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.science.model.ScienceAppCategoryLink"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.kisti.edison.science.model.ScienceAppCategoryLink"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long COMPANYID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long PARENTCATEGORYID_COLUMN_BITMASK = 8L;
	public static long SCIENCEAPPID_COLUMN_BITMASK = 16L;
	public static long UUID_COLUMN_BITMASK = 32L;
	public static long SCIENCEAPPCATEGORYLINKID_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ScienceAppCategoryLink toModel(
		ScienceAppCategoryLinkSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ScienceAppCategoryLink model = new ScienceAppCategoryLinkImpl();

		model.setUuid(soapModel.getUuid());
		model.setScienceAppCategoryLinkId(soapModel.getScienceAppCategoryLinkId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCategoryId(soapModel.getCategoryId());
		model.setScienceAppId(soapModel.getScienceAppId());
		model.setParentCategoryId(soapModel.getParentCategoryId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ScienceAppCategoryLink> toModels(
		ScienceAppCategoryLinkSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ScienceAppCategoryLink> models = new ArrayList<ScienceAppCategoryLink>(soapModels.length);

		for (ScienceAppCategoryLinkSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.science.model.ScienceAppCategoryLink"));

	public ScienceAppCategoryLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _scienceAppCategoryLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScienceAppCategoryLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scienceAppCategoryLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppCategoryLink.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppCategoryLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("scienceAppCategoryLinkId", getScienceAppCategoryLinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("parentCategoryId", getParentCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long scienceAppCategoryLinkId = (Long)attributes.get(
				"scienceAppCategoryLinkId");

		if (scienceAppCategoryLinkId != null) {
			setScienceAppCategoryLinkId(scienceAppCategoryLinkId);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long parentCategoryId = (Long)attributes.get("parentCategoryId");

		if (parentCategoryId != null) {
			setParentCategoryId(parentCategoryId);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getScienceAppCategoryLinkId() {
		return _scienceAppCategoryLinkId;
	}

	@Override
	public void setScienceAppCategoryLinkId(long scienceAppCategoryLinkId) {
		_scienceAppCategoryLinkId = scienceAppCategoryLinkId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
	}

	@JSON
	@Override
	public long getScienceAppId() {
		return _scienceAppId;
	}

	@Override
	public void setScienceAppId(long scienceAppId) {
		_columnBitmask |= SCIENCEAPPID_COLUMN_BITMASK;

		if (!_setOriginalScienceAppId) {
			_setOriginalScienceAppId = true;

			_originalScienceAppId = _scienceAppId;
		}

		_scienceAppId = scienceAppId;
	}

	public long getOriginalScienceAppId() {
		return _originalScienceAppId;
	}

	@JSON
	@Override
	public long getParentCategoryId() {
		return _parentCategoryId;
	}

	@Override
	public void setParentCategoryId(long parentCategoryId) {
		_columnBitmask |= PARENTCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalParentCategoryId) {
			_setOriginalParentCategoryId = true;

			_originalParentCategoryId = _parentCategoryId;
		}

		_parentCategoryId = parentCategoryId;
	}

	public long getOriginalParentCategoryId() {
		return _originalParentCategoryId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ScienceAppCategoryLink.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			ScienceAppCategoryLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ScienceAppCategoryLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ScienceAppCategoryLink)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ScienceAppCategoryLinkImpl scienceAppCategoryLinkImpl = new ScienceAppCategoryLinkImpl();

		scienceAppCategoryLinkImpl.setUuid(getUuid());
		scienceAppCategoryLinkImpl.setScienceAppCategoryLinkId(getScienceAppCategoryLinkId());
		scienceAppCategoryLinkImpl.setGroupId(getGroupId());
		scienceAppCategoryLinkImpl.setCompanyId(getCompanyId());
		scienceAppCategoryLinkImpl.setUserId(getUserId());
		scienceAppCategoryLinkImpl.setCreateDate(getCreateDate());
		scienceAppCategoryLinkImpl.setModifiedDate(getModifiedDate());
		scienceAppCategoryLinkImpl.setCategoryId(getCategoryId());
		scienceAppCategoryLinkImpl.setScienceAppId(getScienceAppId());
		scienceAppCategoryLinkImpl.setParentCategoryId(getParentCategoryId());

		scienceAppCategoryLinkImpl.resetOriginalValues();

		return scienceAppCategoryLinkImpl;
	}

	@Override
	public int compareTo(ScienceAppCategoryLink scienceAppCategoryLink) {
		long primaryKey = scienceAppCategoryLink.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScienceAppCategoryLink)) {
			return false;
		}

		ScienceAppCategoryLink scienceAppCategoryLink = (ScienceAppCategoryLink)obj;

		long primaryKey = scienceAppCategoryLink.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ScienceAppCategoryLinkModelImpl scienceAppCategoryLinkModelImpl = this;

		scienceAppCategoryLinkModelImpl._originalUuid = scienceAppCategoryLinkModelImpl._uuid;

		scienceAppCategoryLinkModelImpl._originalGroupId = scienceAppCategoryLinkModelImpl._groupId;

		scienceAppCategoryLinkModelImpl._setOriginalGroupId = false;

		scienceAppCategoryLinkModelImpl._originalCompanyId = scienceAppCategoryLinkModelImpl._companyId;

		scienceAppCategoryLinkModelImpl._setOriginalCompanyId = false;

		scienceAppCategoryLinkModelImpl._originalCategoryId = scienceAppCategoryLinkModelImpl._categoryId;

		scienceAppCategoryLinkModelImpl._setOriginalCategoryId = false;

		scienceAppCategoryLinkModelImpl._originalScienceAppId = scienceAppCategoryLinkModelImpl._scienceAppId;

		scienceAppCategoryLinkModelImpl._setOriginalScienceAppId = false;

		scienceAppCategoryLinkModelImpl._originalParentCategoryId = scienceAppCategoryLinkModelImpl._parentCategoryId;

		scienceAppCategoryLinkModelImpl._setOriginalParentCategoryId = false;

		scienceAppCategoryLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ScienceAppCategoryLink> toCacheModel() {
		ScienceAppCategoryLinkCacheModel scienceAppCategoryLinkCacheModel = new ScienceAppCategoryLinkCacheModel();

		scienceAppCategoryLinkCacheModel.uuid = getUuid();

		String uuid = scienceAppCategoryLinkCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			scienceAppCategoryLinkCacheModel.uuid = null;
		}

		scienceAppCategoryLinkCacheModel.scienceAppCategoryLinkId = getScienceAppCategoryLinkId();

		scienceAppCategoryLinkCacheModel.groupId = getGroupId();

		scienceAppCategoryLinkCacheModel.companyId = getCompanyId();

		scienceAppCategoryLinkCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			scienceAppCategoryLinkCacheModel.createDate = createDate.getTime();
		}
		else {
			scienceAppCategoryLinkCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			scienceAppCategoryLinkCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			scienceAppCategoryLinkCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		scienceAppCategoryLinkCacheModel.categoryId = getCategoryId();

		scienceAppCategoryLinkCacheModel.scienceAppId = getScienceAppId();

		scienceAppCategoryLinkCacheModel.parentCategoryId = getParentCategoryId();

		return scienceAppCategoryLinkCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", scienceAppCategoryLinkId=");
		sb.append(getScienceAppCategoryLinkId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", parentCategoryId=");
		sb.append(getParentCategoryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.ScienceAppCategoryLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppCategoryLinkId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppCategoryLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentCategoryId</column-name><column-value><![CDATA[");
		sb.append(getParentCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ScienceAppCategoryLink.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ScienceAppCategoryLink.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _scienceAppCategoryLinkId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private long _scienceAppId;
	private long _originalScienceAppId;
	private boolean _setOriginalScienceAppId;
	private long _parentCategoryId;
	private long _originalParentCategoryId;
	private boolean _setOriginalParentCategoryId;
	private long _columnBitmask;
	private ScienceAppCategoryLink _escapedModel;
}