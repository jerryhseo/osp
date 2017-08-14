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

package org.kisti.edison.virtuallaboratory.model.impl;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.kisti.edison.virtuallaboratory.model.Survey;
import org.kisti.edison.virtuallaboratory.model.SurveyModel;
import org.kisti.edison.virtuallaboratory.model.SurveySoap;

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
 * The base model implementation for the Survey service. Represents a row in the &quot;EDVIR_Survey&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.virtuallaboratory.model.SurveyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SurveyImpl}.
 * </p>
 *
 * @author EDISON
 * @see SurveyImpl
 * @see org.kisti.edison.virtuallaboratory.model.Survey
 * @see org.kisti.edison.virtuallaboratory.model.SurveyModel
 * @generated
 */
@JSON(strict = true)
public class SurveyModelImpl extends BaseModelImpl<Survey>
	implements SurveyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a survey model instance should use the {@link org.kisti.edison.virtuallaboratory.model.Survey} interface instead.
	 */
	public static final String TABLE_NAME = "EDVIR_Survey";
	public static final Object[][] TABLE_COLUMNS = {
			{ "surveySeqNo", Types.BIGINT },
			{ "surveyUseYn", Types.VARCHAR },
			{ "surveyTitle", Types.VARCHAR },
			{ "surveyStartDate", Types.VARCHAR },
			{ "surveyEndDate", Types.VARCHAR },
			{ "surveyStatus", Types.VARCHAR },
			{ "surveyCreateDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table EDVIR_Survey (surveySeqNo LONG not null primary key,surveyUseYn VARCHAR(75) null,surveyTitle STRING null,surveyStartDate VARCHAR(75) null,surveyEndDate VARCHAR(75) null,surveyStatus VARCHAR(75) null,surveyCreateDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table EDVIR_Survey";
	public static final String ORDER_BY_JPQL = " ORDER BY survey.surveyCreateDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY EDVIR_Survey.surveyCreateDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.virtuallaboratory.model.Survey"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.virtuallaboratory.model.Survey"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Survey toModel(SurveySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Survey model = new SurveyImpl();

		model.setSurveySeqNo(soapModel.getSurveySeqNo());
		model.setSurveyUseYn(soapModel.getSurveyUseYn());
		model.setSurveyTitle(soapModel.getSurveyTitle());
		model.setSurveyStartDate(soapModel.getSurveyStartDate());
		model.setSurveyEndDate(soapModel.getSurveyEndDate());
		model.setSurveyStatus(soapModel.getSurveyStatus());
		model.setSurveyCreateDate(soapModel.getSurveyCreateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Survey> toModels(SurveySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Survey> models = new ArrayList<Survey>(soapModels.length);

		for (SurveySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String MAPPING_TABLE_EDVIR_VIRTUALLABS_SURVEYS_NAME = "EDVIR_VirtualLabs_Surveys";
	public static final Object[][] MAPPING_TABLE_EDVIR_VIRTUALLABS_SURVEYS_COLUMNS =
		{
			{ "surveySeqNo", Types.BIGINT },
			{ "virtualLabId", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_EDVIR_VIRTUALLABS_SURVEYS_SQL_CREATE =
		"create table EDVIR_VirtualLabs_Surveys (surveySeqNo LONG not null,virtualLabId LONG not null,primary key (surveySeqNo, virtualLabId))";
	public static final boolean FINDER_CACHE_ENABLED_EDVIR_VIRTUALLABS_SURVEYS = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.EDVIR_VirtualLabs_Surveys"),
			true);
	public static final String MAPPING_TABLE_EDVIR_SURVEYS_SURVEYQUESTIONS_NAME = "EDVIR_Surveys_SurveyQuestions";
	public static final Object[][] MAPPING_TABLE_EDVIR_SURVEYS_SURVEYQUESTIONS_COLUMNS =
		{
			{ "surveySeqNo", Types.BIGINT },
			{ "questionSeqNo", Types.BIGINT }
		};
	public static final String MAPPING_TABLE_EDVIR_SURVEYS_SURVEYQUESTIONS_SQL_CREATE =
		"create table EDVIR_Surveys_SurveyQuestions (surveySeqNo LONG not null,questionSeqNo LONG not null,primary key (surveySeqNo, questionSeqNo))";
	public static final boolean FINDER_CACHE_ENABLED_EDVIR_SURVEYS_SURVEYQUESTIONS =
		GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.EDVIR_Surveys_SurveyQuestions"),
			true);
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.virtuallaboratory.model.Survey"));

	public SurveyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _surveySeqNo;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveySeqNo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveySeqNo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Survey.class;
	}

	@Override
	public String getModelClassName() {
		return Survey.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveySeqNo", getSurveySeqNo());
		attributes.put("surveyUseYn", getSurveyUseYn());
		attributes.put("surveyTitle", getSurveyTitle());
		attributes.put("surveyStartDate", getSurveyStartDate());
		attributes.put("surveyEndDate", getSurveyEndDate());
		attributes.put("surveyStatus", getSurveyStatus());
		attributes.put("surveyCreateDate", getSurveyCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveySeqNo = (Long)attributes.get("surveySeqNo");

		if (surveySeqNo != null) {
			setSurveySeqNo(surveySeqNo);
		}

		String surveyUseYn = (String)attributes.get("surveyUseYn");

		if (surveyUseYn != null) {
			setSurveyUseYn(surveyUseYn);
		}

		String surveyTitle = (String)attributes.get("surveyTitle");

		if (surveyTitle != null) {
			setSurveyTitle(surveyTitle);
		}

		String surveyStartDate = (String)attributes.get("surveyStartDate");

		if (surveyStartDate != null) {
			setSurveyStartDate(surveyStartDate);
		}

		String surveyEndDate = (String)attributes.get("surveyEndDate");

		if (surveyEndDate != null) {
			setSurveyEndDate(surveyEndDate);
		}

		String surveyStatus = (String)attributes.get("surveyStatus");

		if (surveyStatus != null) {
			setSurveyStatus(surveyStatus);
		}

		Date surveyCreateDate = (Date)attributes.get("surveyCreateDate");

		if (surveyCreateDate != null) {
			setSurveyCreateDate(surveyCreateDate);
		}
	}

	@JSON
	@Override
	public long getSurveySeqNo() {
		return _surveySeqNo;
	}

	@Override
	public void setSurveySeqNo(long surveySeqNo) {
		_surveySeqNo = surveySeqNo;
	}

	@JSON
	@Override
	public String getSurveyUseYn() {
		if (_surveyUseYn == null) {
			return StringPool.BLANK;
		}
		else {
			return _surveyUseYn;
		}
	}

	@Override
	public void setSurveyUseYn(String surveyUseYn) {
		_surveyUseYn = surveyUseYn;
	}

	@JSON
	@Override
	public String getSurveyTitle() {
		if (_surveyTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _surveyTitle;
		}
	}

	@Override
	public String getSurveyTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSurveyTitle(languageId);
	}

	@Override
	public String getSurveyTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSurveyTitle(languageId, useDefault);
	}

	@Override
	public String getSurveyTitle(String languageId) {
		return LocalizationUtil.getLocalization(getSurveyTitle(), languageId);
	}

	@Override
	public String getSurveyTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSurveyTitle(), languageId,
			useDefault);
	}

	@Override
	public String getSurveyTitleCurrentLanguageId() {
		return _surveyTitleCurrentLanguageId;
	}

	@JSON
	@Override
	public String getSurveyTitleCurrentValue() {
		Locale locale = getLocale(_surveyTitleCurrentLanguageId);

		return getSurveyTitle(locale);
	}

	@Override
	public Map<Locale, String> getSurveyTitleMap() {
		return LocalizationUtil.getLocalizationMap(getSurveyTitle());
	}

	@Override
	public void setSurveyTitle(String surveyTitle) {
		_surveyTitle = surveyTitle;
	}

	@Override
	public void setSurveyTitle(String surveyTitle, Locale locale) {
		setSurveyTitle(surveyTitle, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setSurveyTitle(String surveyTitle, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(surveyTitle)) {
			setSurveyTitle(LocalizationUtil.updateLocalization(
					getSurveyTitle(), "SurveyTitle", surveyTitle, languageId,
					defaultLanguageId));
		}
		else {
			setSurveyTitle(LocalizationUtil.removeLocalization(
					getSurveyTitle(), "SurveyTitle", languageId));
		}
	}

	@Override
	public void setSurveyTitleCurrentLanguageId(String languageId) {
		_surveyTitleCurrentLanguageId = languageId;
	}

	@Override
	public void setSurveyTitleMap(Map<Locale, String> surveyTitleMap) {
		setSurveyTitleMap(surveyTitleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSurveyTitleMap(Map<Locale, String> surveyTitleMap,
		Locale defaultLocale) {
		if (surveyTitleMap == null) {
			return;
		}

		setSurveyTitle(LocalizationUtil.updateLocalization(surveyTitleMap,
				getSurveyTitle(), "SurveyTitle",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getSurveyStartDate() {
		if (_surveyStartDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _surveyStartDate;
		}
	}

	@Override
	public void setSurveyStartDate(String surveyStartDate) {
		_surveyStartDate = surveyStartDate;
	}

	@JSON
	@Override
	public String getSurveyEndDate() {
		if (_surveyEndDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _surveyEndDate;
		}
	}

	@Override
	public void setSurveyEndDate(String surveyEndDate) {
		_surveyEndDate = surveyEndDate;
	}

	@JSON
	@Override
	public String getSurveyStatus() {
		if (_surveyStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _surveyStatus;
		}
	}

	@Override
	public void setSurveyStatus(String surveyStatus) {
		_surveyStatus = surveyStatus;
	}

	@JSON
	@Override
	public Date getSurveyCreateDate() {
		return _surveyCreateDate;
	}

	@Override
	public void setSurveyCreateDate(Date surveyCreateDate) {
		_surveyCreateDate = surveyCreateDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Survey.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> surveyTitleMap = getSurveyTitleMap();

		for (Map.Entry<Locale, String> entry : surveyTitleMap.entrySet()) {
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
		String xml = getSurveyTitle();

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

		String surveyTitle = getSurveyTitle(defaultLocale);

		if (Validator.isNull(surveyTitle)) {
			setSurveyTitle(getSurveyTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setSurveyTitle(getSurveyTitle(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public Survey toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Survey)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SurveyImpl surveyImpl = new SurveyImpl();

		surveyImpl.setSurveySeqNo(getSurveySeqNo());
		surveyImpl.setSurveyUseYn(getSurveyUseYn());
		surveyImpl.setSurveyTitle(getSurveyTitle());
		surveyImpl.setSurveyStartDate(getSurveyStartDate());
		surveyImpl.setSurveyEndDate(getSurveyEndDate());
		surveyImpl.setSurveyStatus(getSurveyStatus());
		surveyImpl.setSurveyCreateDate(getSurveyCreateDate());

		surveyImpl.resetOriginalValues();

		return surveyImpl;
	}

	@Override
	public int compareTo(Survey survey) {
		int value = 0;

		value = DateUtil.compareTo(getSurveyCreateDate(),
				survey.getSurveyCreateDate());

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

		if (!(obj instanceof Survey)) {
			return false;
		}

		Survey survey = (Survey)obj;

		long primaryKey = survey.getPrimaryKey();

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
	public CacheModel<Survey> toCacheModel() {
		SurveyCacheModel surveyCacheModel = new SurveyCacheModel();

		surveyCacheModel.surveySeqNo = getSurveySeqNo();

		surveyCacheModel.surveyUseYn = getSurveyUseYn();

		String surveyUseYn = surveyCacheModel.surveyUseYn;

		if ((surveyUseYn != null) && (surveyUseYn.length() == 0)) {
			surveyCacheModel.surveyUseYn = null;
		}

		surveyCacheModel.surveyTitle = getSurveyTitle();

		String surveyTitle = surveyCacheModel.surveyTitle;

		if ((surveyTitle != null) && (surveyTitle.length() == 0)) {
			surveyCacheModel.surveyTitle = null;
		}

		surveyCacheModel.surveyStartDate = getSurveyStartDate();

		String surveyStartDate = surveyCacheModel.surveyStartDate;

		if ((surveyStartDate != null) && (surveyStartDate.length() == 0)) {
			surveyCacheModel.surveyStartDate = null;
		}

		surveyCacheModel.surveyEndDate = getSurveyEndDate();

		String surveyEndDate = surveyCacheModel.surveyEndDate;

		if ((surveyEndDate != null) && (surveyEndDate.length() == 0)) {
			surveyCacheModel.surveyEndDate = null;
		}

		surveyCacheModel.surveyStatus = getSurveyStatus();

		String surveyStatus = surveyCacheModel.surveyStatus;

		if ((surveyStatus != null) && (surveyStatus.length() == 0)) {
			surveyCacheModel.surveyStatus = null;
		}

		Date surveyCreateDate = getSurveyCreateDate();

		if (surveyCreateDate != null) {
			surveyCacheModel.surveyCreateDate = surveyCreateDate.getTime();
		}
		else {
			surveyCacheModel.surveyCreateDate = Long.MIN_VALUE;
		}

		return surveyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{surveySeqNo=");
		sb.append(getSurveySeqNo());
		sb.append(", surveyUseYn=");
		sb.append(getSurveyUseYn());
		sb.append(", surveyTitle=");
		sb.append(getSurveyTitle());
		sb.append(", surveyStartDate=");
		sb.append(getSurveyStartDate());
		sb.append(", surveyEndDate=");
		sb.append(getSurveyEndDate());
		sb.append(", surveyStatus=");
		sb.append(getSurveyStatus());
		sb.append(", surveyCreateDate=");
		sb.append(getSurveyCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.virtuallaboratory.model.Survey");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveySeqNo</column-name><column-value><![CDATA[");
		sb.append(getSurveySeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyUseYn</column-name><column-value><![CDATA[");
		sb.append(getSurveyUseYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyTitle</column-name><column-value><![CDATA[");
		sb.append(getSurveyTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyStartDate</column-name><column-value><![CDATA[");
		sb.append(getSurveyStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyEndDate</column-name><column-value><![CDATA[");
		sb.append(getSurveyEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyStatus</column-name><column-value><![CDATA[");
		sb.append(getSurveyStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyCreateDate</column-name><column-value><![CDATA[");
		sb.append(getSurveyCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Survey.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Survey.class };
	private long _surveySeqNo;
	private String _surveyUseYn;
	private String _surveyTitle;
	private String _surveyTitleCurrentLanguageId;
	private String _surveyStartDate;
	private String _surveyEndDate;
	private String _surveyStatus;
	private Date _surveyCreateDate;
	private Survey _escapedModel;
}