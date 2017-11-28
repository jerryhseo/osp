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

package org.kisti.edison.bestsimulation.model.impl;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.kisti.edison.bestsimulation.model.Simulation;
import org.kisti.edison.bestsimulation.model.SimulationModel;
import org.kisti.edison.bestsimulation.model.SimulationSoap;
import org.kisti.edison.bestsimulation.service.persistence.SimulationPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the Simulation service. Represents a row in the &quot;EDSIM_Simulation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.bestsimulation.model.SimulationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SimulationImpl}.
 * </p>
 *
 * @author EDISON
 * @see SimulationImpl
 * @see org.kisti.edison.bestsimulation.model.Simulation
 * @see org.kisti.edison.bestsimulation.model.SimulationModel
 * @generated
 */
@JSON(strict = true)
public class SimulationModelImpl extends BaseModelImpl<Simulation>
	implements SimulationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a simulation model instance should use the {@link org.kisti.edison.bestsimulation.model.Simulation} interface instead.
	 */
	public static final String TABLE_NAME = "EDSIM_Simulation";
	public static final Object[][] TABLE_COLUMNS = {
			{ "simulationUuid", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "simulationTitle", Types.VARCHAR },
			{ "scienceAppId", Types.VARCHAR },
			{ "scienceAppName", Types.VARCHAR },
			{ "simulationCreateDt", Types.TIMESTAMP },
			{ "cluster", Types.VARCHAR },
			{ "classId", Types.BIGINT },
			{ "customId", Types.BIGINT },
			{ "testYn", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table EDSIM_Simulation (simulationUuid VARCHAR(75) not null,groupId LONG not null,userId LONG,simulationTitle STRING null,scienceAppId VARCHAR(75) null,scienceAppName STRING null,simulationCreateDt DATE null,cluster VARCHAR(75) null,classId LONG,customId LONG,testYn BOOLEAN,primary key (simulationUuid, groupId))";
	public static final String TABLE_SQL_DROP = "drop table EDSIM_Simulation";
	public static final String ORDER_BY_JPQL = " ORDER BY simulation.simulationCreateDt DESC";
	public static final String ORDER_BY_SQL = " ORDER BY EDSIM_Simulation.simulationCreateDt DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "true";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.bestsimulation.model.Simulation"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.bestsimulation.model.Simulation"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.org.kisti.edison.bestsimulation.model.Simulation"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long SCIENCEAPPID_COLUMN_BITMASK = 2L;
	public static long SIMULATIONUUID_COLUMN_BITMASK = 4L;
	public static long USERID_COLUMN_BITMASK = 8L;
	public static long SIMULATIONCREATEDT_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Simulation toModel(SimulationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Simulation model = new SimulationImpl();

		model.setSimulationUuid(soapModel.getSimulationUuid());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setSimulationTitle(soapModel.getSimulationTitle());
		model.setScienceAppId(soapModel.getScienceAppId());
		model.setScienceAppName(soapModel.getScienceAppName());
		model.setSimulationCreateDt(soapModel.getSimulationCreateDt());
		model.setCluster(soapModel.getCluster());
		model.setClassId(soapModel.getClassId());
		model.setCustomId(soapModel.getCustomId());
		model.setTestYn(soapModel.getTestYn());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Simulation> toModels(SimulationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Simulation> models = new ArrayList<Simulation>(soapModels.length);

		for (SimulationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.bestsimulation.model.Simulation"));

	public SimulationModelImpl() {
	}

	@Override
	public SimulationPK getPrimaryKey() {
		return new SimulationPK(_simulationUuid, _groupId);
	}

	@Override
	public void setPrimaryKey(SimulationPK primaryKey) {
		setSimulationUuid(primaryKey.simulationUuid);
		setGroupId(primaryKey.groupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SimulationPK(_simulationUuid, _groupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SimulationPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Simulation.class;
	}

	@Override
	public String getModelClassName() {
		return Simulation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("simulationUuid", getSimulationUuid());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("simulationTitle", getSimulationTitle());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("scienceAppName", getScienceAppName());
		attributes.put("simulationCreateDt", getSimulationCreateDt());
		attributes.put("cluster", getCluster());
		attributes.put("classId", getClassId());
		attributes.put("customId", getCustomId());
		attributes.put("testYn", getTestYn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String simulationUuid = (String)attributes.get("simulationUuid");

		if (simulationUuid != null) {
			setSimulationUuid(simulationUuid);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String simulationTitle = (String)attributes.get("simulationTitle");

		if (simulationTitle != null) {
			setSimulationTitle(simulationTitle);
		}

		String scienceAppId = (String)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		String scienceAppName = (String)attributes.get("scienceAppName");

		if (scienceAppName != null) {
			setScienceAppName(scienceAppName);
		}

		Date simulationCreateDt = (Date)attributes.get("simulationCreateDt");

		if (simulationCreateDt != null) {
			setSimulationCreateDt(simulationCreateDt);
		}

		String cluster = (String)attributes.get("cluster");

		if (cluster != null) {
			setCluster(cluster);
		}

		Long classId = (Long)attributes.get("classId");

		if (classId != null) {
			setClassId(classId);
		}

		Long customId = (Long)attributes.get("customId");

		if (customId != null) {
			setCustomId(customId);
		}

		Boolean testYn = (Boolean)attributes.get("testYn");

		if (testYn != null) {
			setTestYn(testYn);
		}
	}

	@JSON
	@Override
	public String getSimulationUuid() {
		if (_simulationUuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _simulationUuid;
		}
	}

	@Override
	public void setSimulationUuid(String simulationUuid) {
		_columnBitmask |= SIMULATIONUUID_COLUMN_BITMASK;

		if (_originalSimulationUuid == null) {
			_originalSimulationUuid = _simulationUuid;
		}

		_simulationUuid = simulationUuid;
	}

	public String getOriginalSimulationUuid() {
		return GetterUtil.getString(_originalSimulationUuid);
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
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getSimulationTitle() {
		if (_simulationTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _simulationTitle;
		}
	}

	@Override
	public String getSimulationTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSimulationTitle(languageId);
	}

	@Override
	public String getSimulationTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSimulationTitle(languageId, useDefault);
	}

	@Override
	public String getSimulationTitle(String languageId) {
		return LocalizationUtil.getLocalization(getSimulationTitle(), languageId);
	}

	@Override
	public String getSimulationTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSimulationTitle(),
			languageId, useDefault);
	}

	@Override
	public String getSimulationTitleCurrentLanguageId() {
		return _simulationTitleCurrentLanguageId;
	}

	@JSON
	@Override
	public String getSimulationTitleCurrentValue() {
		Locale locale = getLocale(_simulationTitleCurrentLanguageId);

		return getSimulationTitle(locale);
	}

	@Override
	public Map<Locale, String> getSimulationTitleMap() {
		return LocalizationUtil.getLocalizationMap(getSimulationTitle());
	}

	@Override
	public void setSimulationTitle(String simulationTitle) {
		_simulationTitle = simulationTitle;
	}

	@Override
	public void setSimulationTitle(String simulationTitle, Locale locale) {
		setSimulationTitle(simulationTitle, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setSimulationTitle(String simulationTitle, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(simulationTitle)) {
			setSimulationTitle(LocalizationUtil.updateLocalization(
					getSimulationTitle(), "SimulationTitle", simulationTitle,
					languageId, defaultLanguageId));
		}
		else {
			setSimulationTitle(LocalizationUtil.removeLocalization(
					getSimulationTitle(), "SimulationTitle", languageId));
		}
	}

	@Override
	public void setSimulationTitleCurrentLanguageId(String languageId) {
		_simulationTitleCurrentLanguageId = languageId;
	}

	@Override
	public void setSimulationTitleMap(Map<Locale, String> simulationTitleMap) {
		setSimulationTitleMap(simulationTitleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSimulationTitleMap(Map<Locale, String> simulationTitleMap,
		Locale defaultLocale) {
		if (simulationTitleMap == null) {
			return;
		}

		setSimulationTitle(LocalizationUtil.updateLocalization(
				simulationTitleMap, getSimulationTitle(), "SimulationTitle",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getScienceAppId() {
		if (_scienceAppId == null) {
			return StringPool.BLANK;
		}
		else {
			return _scienceAppId;
		}
	}

	@Override
	public void setScienceAppId(String scienceAppId) {
		_columnBitmask |= SCIENCEAPPID_COLUMN_BITMASK;

		if (_originalScienceAppId == null) {
			_originalScienceAppId = _scienceAppId;
		}

		_scienceAppId = scienceAppId;
	}

	public String getOriginalScienceAppId() {
		return GetterUtil.getString(_originalScienceAppId);
	}

	@JSON
	@Override
	public String getScienceAppName() {
		if (_scienceAppName == null) {
			return StringPool.BLANK;
		}
		else {
			return _scienceAppName;
		}
	}

	@Override
	public String getScienceAppName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getScienceAppName(languageId);
	}

	@Override
	public String getScienceAppName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getScienceAppName(languageId, useDefault);
	}

	@Override
	public String getScienceAppName(String languageId) {
		return LocalizationUtil.getLocalization(getScienceAppName(), languageId);
	}

	@Override
	public String getScienceAppName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getScienceAppName(),
			languageId, useDefault);
	}

	@Override
	public String getScienceAppNameCurrentLanguageId() {
		return _scienceAppNameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getScienceAppNameCurrentValue() {
		Locale locale = getLocale(_scienceAppNameCurrentLanguageId);

		return getScienceAppName(locale);
	}

	@Override
	public Map<Locale, String> getScienceAppNameMap() {
		return LocalizationUtil.getLocalizationMap(getScienceAppName());
	}

	@Override
	public void setScienceAppName(String scienceAppName) {
		_scienceAppName = scienceAppName;
	}

	@Override
	public void setScienceAppName(String scienceAppName, Locale locale) {
		setScienceAppName(scienceAppName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setScienceAppName(String scienceAppName, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(scienceAppName)) {
			setScienceAppName(LocalizationUtil.updateLocalization(
					getScienceAppName(), "ScienceAppName", scienceAppName,
					languageId, defaultLanguageId));
		}
		else {
			setScienceAppName(LocalizationUtil.removeLocalization(
					getScienceAppName(), "ScienceAppName", languageId));
		}
	}

	@Override
	public void setScienceAppNameCurrentLanguageId(String languageId) {
		_scienceAppNameCurrentLanguageId = languageId;
	}

	@Override
	public void setScienceAppNameMap(Map<Locale, String> scienceAppNameMap) {
		setScienceAppNameMap(scienceAppNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setScienceAppNameMap(Map<Locale, String> scienceAppNameMap,
		Locale defaultLocale) {
		if (scienceAppNameMap == null) {
			return;
		}

		setScienceAppName(LocalizationUtil.updateLocalization(
				scienceAppNameMap, getScienceAppName(), "ScienceAppName",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public Date getSimulationCreateDt() {
		return _simulationCreateDt;
	}

	@Override
	public void setSimulationCreateDt(Date simulationCreateDt) {
		_columnBitmask = -1L;

		_simulationCreateDt = simulationCreateDt;
	}

	@JSON
	@Override
	public String getCluster() {
		if (_cluster == null) {
			return StringPool.BLANK;
		}
		else {
			return _cluster;
		}
	}

	@Override
	public void setCluster(String cluster) {
		_cluster = cluster;
	}

	@JSON
	@Override
	public long getClassId() {
		return _classId;
	}

	@Override
	public void setClassId(long classId) {
		_classId = classId;
	}

	@JSON
	@Override
	public long getCustomId() {
		return _customId;
	}

	@Override
	public void setCustomId(long customId) {
		_customId = customId;
	}

	@JSON
	@Override
	public boolean getTestYn() {
		return _testYn;
	}

	@Override
	public boolean isTestYn() {
		return _testYn;
	}

	@Override
	public void setTestYn(boolean testYn) {
		_testYn = testYn;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> simulationTitleMap = getSimulationTitleMap();

		for (Map.Entry<Locale, String> entry : simulationTitleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> scienceAppNameMap = getScienceAppNameMap();

		for (Map.Entry<Locale, String> entry : scienceAppNameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getSimulationTitle();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String simulationTitle = getSimulationTitle(defaultLocale);

		if (Validator.isNull(simulationTitle)) {
			setSimulationTitle(getSimulationTitle(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setSimulationTitle(getSimulationTitle(defaultLocale),
				defaultLocale, defaultLocale);
		}

		String scienceAppName = getScienceAppName(defaultLocale);

		if (Validator.isNull(scienceAppName)) {
			setScienceAppName(getScienceAppName(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setScienceAppName(getScienceAppName(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public Simulation toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Simulation)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SimulationImpl simulationImpl = new SimulationImpl();

		simulationImpl.setSimulationUuid(getSimulationUuid());
		simulationImpl.setGroupId(getGroupId());
		simulationImpl.setUserId(getUserId());
		simulationImpl.setSimulationTitle(getSimulationTitle());
		simulationImpl.setScienceAppId(getScienceAppId());
		simulationImpl.setScienceAppName(getScienceAppName());
		simulationImpl.setSimulationCreateDt(getSimulationCreateDt());
		simulationImpl.setCluster(getCluster());
		simulationImpl.setClassId(getClassId());
		simulationImpl.setCustomId(getCustomId());
		simulationImpl.setTestYn(getTestYn());

		simulationImpl.resetOriginalValues();

		return simulationImpl;
	}

	@Override
	public int compareTo(Simulation simulation) {
		int value = 0;

		value = DateUtil.compareTo(getSimulationCreateDt(),
				simulation.getSimulationCreateDt());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Simulation)) {
			return false;
		}

		Simulation simulation = (Simulation)obj;

		SimulationPK primaryKey = simulation.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		SimulationModelImpl simulationModelImpl = this;

		simulationModelImpl._originalSimulationUuid = simulationModelImpl._simulationUuid;

		simulationModelImpl._originalGroupId = simulationModelImpl._groupId;

		simulationModelImpl._setOriginalGroupId = false;

		simulationModelImpl._originalUserId = simulationModelImpl._userId;

		simulationModelImpl._setOriginalUserId = false;

		simulationModelImpl._originalScienceAppId = simulationModelImpl._scienceAppId;

		simulationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Simulation> toCacheModel() {
		SimulationCacheModel simulationCacheModel = new SimulationCacheModel();

		simulationCacheModel.simulationUuid = getSimulationUuid();

		String simulationUuid = simulationCacheModel.simulationUuid;

		if ((simulationUuid != null) && (simulationUuid.length() == 0)) {
			simulationCacheModel.simulationUuid = null;
		}

		simulationCacheModel.groupId = getGroupId();

		simulationCacheModel.userId = getUserId();

		simulationCacheModel.simulationTitle = getSimulationTitle();

		String simulationTitle = simulationCacheModel.simulationTitle;

		if ((simulationTitle != null) && (simulationTitle.length() == 0)) {
			simulationCacheModel.simulationTitle = null;
		}

		simulationCacheModel.scienceAppId = getScienceAppId();

		String scienceAppId = simulationCacheModel.scienceAppId;

		if ((scienceAppId != null) && (scienceAppId.length() == 0)) {
			simulationCacheModel.scienceAppId = null;
		}

		simulationCacheModel.scienceAppName = getScienceAppName();

		String scienceAppName = simulationCacheModel.scienceAppName;

		if ((scienceAppName != null) && (scienceAppName.length() == 0)) {
			simulationCacheModel.scienceAppName = null;
		}

		Date simulationCreateDt = getSimulationCreateDt();

		if (simulationCreateDt != null) {
			simulationCacheModel.simulationCreateDt = simulationCreateDt.getTime();
		}
		else {
			simulationCacheModel.simulationCreateDt = Long.MIN_VALUE;
		}

		simulationCacheModel.cluster = getCluster();

		String cluster = simulationCacheModel.cluster;

		if ((cluster != null) && (cluster.length() == 0)) {
			simulationCacheModel.cluster = null;
		}

		simulationCacheModel.classId = getClassId();

		simulationCacheModel.customId = getCustomId();

		simulationCacheModel.testYn = getTestYn();

		return simulationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{simulationUuid=");
		sb.append(getSimulationUuid());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", simulationTitle=");
		sb.append(getSimulationTitle());
		sb.append(", scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", scienceAppName=");
		sb.append(getScienceAppName());
		sb.append(", simulationCreateDt=");
		sb.append(getSimulationCreateDt());
		sb.append(", cluster=");
		sb.append(getCluster());
		sb.append(", classId=");
		sb.append(getClassId());
		sb.append(", customId=");
		sb.append(getCustomId());
		sb.append(", testYn=");
		sb.append(getTestYn());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.bestsimulation.model.Simulation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>simulationUuid</column-name><column-value><![CDATA[");
		sb.append(getSimulationUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulationTitle</column-name><column-value><![CDATA[");
		sb.append(getSimulationTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppName</column-name><column-value><![CDATA[");
		sb.append(getScienceAppName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulationCreateDt</column-name><column-value><![CDATA[");
		sb.append(getSimulationCreateDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cluster</column-name><column-value><![CDATA[");
		sb.append(getCluster());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classId</column-name><column-value><![CDATA[");
		sb.append(getClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customId</column-name><column-value><![CDATA[");
		sb.append(getCustomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testYn</column-name><column-value><![CDATA[");
		sb.append(getTestYn());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Simulation.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Simulation.class
		};
	private String _simulationUuid;
	private String _originalSimulationUuid;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _simulationTitle;
	private String _simulationTitleCurrentLanguageId;
	private String _scienceAppId;
	private String _originalScienceAppId;
	private String _scienceAppName;
	private String _scienceAppNameCurrentLanguageId;
	private Date _simulationCreateDt;
	private String _cluster;
	private long _classId;
	private long _customId;
	private boolean _testYn;
	private long _columnBitmask;
	private Simulation _escapedModel;
}