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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.kisti.edison.science.model.ScienceAppCompile;
import org.kisti.edison.science.model.ScienceAppCompileModel;
import org.kisti.edison.science.model.ScienceAppCompileSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ScienceAppCompile service. Represents a row in the &quot;EDAPP_ScienceAppCompile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.science.model.ScienceAppCompileModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ScienceAppCompileImpl}.
 * </p>
 *
 * @author EDISON
 * @see ScienceAppCompileImpl
 * @see org.kisti.edison.science.model.ScienceAppCompile
 * @see org.kisti.edison.science.model.ScienceAppCompileModel
 * @generated
 */
@JSON(strict = true)
public class ScienceAppCompileModelImpl extends BaseModelImpl<ScienceAppCompile>
	implements ScienceAppCompileModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a science app compile model instance should use the {@link org.kisti.edison.science.model.ScienceAppCompile} interface instead.
	 */
	public static final String TABLE_NAME = "EDAPP_ScienceAppCompile";
	public static final Object[][] TABLE_COLUMNS = {
			{ "scienceAppId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "compileUrl", Types.VARCHAR },
			{ "result", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table EDAPP_ScienceAppCompile (scienceAppId LONG not null primary key,userId LONG,compileUrl VARCHAR(75) null,result TEXT null,createDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table EDAPP_ScienceAppCompile";
	public static final String ORDER_BY_JPQL = " ORDER BY scienceAppCompile.scienceAppId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EDAPP_ScienceAppCompile.scienceAppId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.science.model.ScienceAppCompile"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.science.model.ScienceAppCompile"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ScienceAppCompile toModel(ScienceAppCompileSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ScienceAppCompile model = new ScienceAppCompileImpl();

		model.setScienceAppId(soapModel.getScienceAppId());
		model.setUserId(soapModel.getUserId());
		model.setCompileUrl(soapModel.getCompileUrl());
		model.setResult(soapModel.getResult());
		model.setCreateDate(soapModel.getCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ScienceAppCompile> toModels(
		ScienceAppCompileSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ScienceAppCompile> models = new ArrayList<ScienceAppCompile>(soapModels.length);

		for (ScienceAppCompileSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.science.model.ScienceAppCompile"));

	public ScienceAppCompileModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _scienceAppId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScienceAppId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scienceAppId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppCompile.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppCompile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("userId", getUserId());
		attributes.put("compileUrl", getCompileUrl());
		attributes.put("result", getResult());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String compileUrl = (String)attributes.get("compileUrl");

		if (compileUrl != null) {
			setCompileUrl(compileUrl);
		}

		String result = (String)attributes.get("result");

		if (result != null) {
			setResult(result);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@JSON
	@Override
	public long getScienceAppId() {
		return _scienceAppId;
	}

	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;
	}

	@JSON
	@Override
	public Long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(Long userId) {
		_userId = userId;
	}

	@JSON
	@Override
	public String getCompileUrl() {
		if (_compileUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _compileUrl;
		}
	}

	@Override
	public void setCompileUrl(String compileUrl) {
		_compileUrl = compileUrl;
	}

	@JSON
	@Override
	public String getResult() {
		if (_result == null) {
			return StringPool.BLANK;
		}
		else {
			return _result;
		}
	}

	@Override
	public void setResult(String result) {
		_result = result;
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ScienceAppCompile.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ScienceAppCompile toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ScienceAppCompile)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ScienceAppCompileImpl scienceAppCompileImpl = new ScienceAppCompileImpl();

		scienceAppCompileImpl.setScienceAppId(getScienceAppId());
		scienceAppCompileImpl.setUserId(getUserId());
		scienceAppCompileImpl.setCompileUrl(getCompileUrl());
		scienceAppCompileImpl.setResult(getResult());
		scienceAppCompileImpl.setCreateDate(getCreateDate());

		scienceAppCompileImpl.resetOriginalValues();

		return scienceAppCompileImpl;
	}

	@Override
	public int compareTo(ScienceAppCompile scienceAppCompile) {
		long primaryKey = scienceAppCompile.getPrimaryKey();

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

		if (!(obj instanceof ScienceAppCompile)) {
			return false;
		}

		ScienceAppCompile scienceAppCompile = (ScienceAppCompile)obj;

		long primaryKey = scienceAppCompile.getPrimaryKey();

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
	}

	@Override
	public CacheModel<ScienceAppCompile> toCacheModel() {
		ScienceAppCompileCacheModel scienceAppCompileCacheModel = new ScienceAppCompileCacheModel();

		scienceAppCompileCacheModel.scienceAppId = getScienceAppId();

		scienceAppCompileCacheModel.userId = getUserId();

		scienceAppCompileCacheModel.compileUrl = getCompileUrl();

		String compileUrl = scienceAppCompileCacheModel.compileUrl;

		if ((compileUrl != null) && (compileUrl.length() == 0)) {
			scienceAppCompileCacheModel.compileUrl = null;
		}

		scienceAppCompileCacheModel.result = getResult();

		String result = scienceAppCompileCacheModel.result;

		if ((result != null) && (result.length() == 0)) {
			scienceAppCompileCacheModel.result = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			scienceAppCompileCacheModel.createDate = createDate.getTime();
		}
		else {
			scienceAppCompileCacheModel.createDate = Long.MIN_VALUE;
		}

		return scienceAppCompileCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", compileUrl=");
		sb.append(getCompileUrl());
		sb.append(", result=");
		sb.append(getResult());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.ScienceAppCompile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>compileUrl</column-name><column-value><![CDATA[");
		sb.append(getCompileUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>result</column-name><column-value><![CDATA[");
		sb.append(getResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ScienceAppCompile.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ScienceAppCompile.class
		};
	private long _scienceAppId;
	private Long _userId;
	private String _compileUrl;
	private String _result;
	private Date _createDate;
	private ScienceAppCompile _escapedModel;
}