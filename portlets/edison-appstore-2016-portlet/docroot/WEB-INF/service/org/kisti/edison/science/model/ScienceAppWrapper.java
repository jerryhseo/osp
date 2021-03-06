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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ScienceApp}.
 * </p>
 *
 * @author EDISON
 * @see ScienceApp
 * @generated
 */
public class ScienceAppWrapper implements ScienceApp, ModelWrapper<ScienceApp> {
	public ScienceAppWrapper(ScienceApp scienceApp) {
		_scienceApp = scienceApp;
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceApp.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceApp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("version", getVersion());
		attributes.put("title", getTitle());
		attributes.put("descriptionId", getDescriptionId());
		attributes.put("previousVersionId", getPreviousVersionId());
		attributes.put("iconId", getIconId());
		attributes.put("manualId", getManualId());
		attributes.put("manualUrl", getManualUrl());
		attributes.put("exeFileName", getExeFileName());
		attributes.put("appType", getAppType());
		attributes.put("runType", getRunType());
		attributes.put("authorId", getAuthorId());
		attributes.put("stage", getStage());
		attributes.put("status", getStatus());
		attributes.put("recentModifierId", getRecentModifierId());
		attributes.put("parallelModule", getParallelModule());
		attributes.put("minCpus", getMinCpus());
		attributes.put("maxCpus", getMaxCpus());
		attributes.put("defaultCpus", getDefaultCpus());
		attributes.put("statusDate", getStatusDate());
		attributes.put("openLevel", getOpenLevel());
		attributes.put("license", getLicense());
		attributes.put("srcFileName", getSrcFileName());
		attributes.put("targetLanguage", getTargetLanguage());
		attributes.put("isStepLayout", getIsStepLayout());
		attributes.put("layout", getLayout());
		attributes.put("developers", getDevelopers());
		attributes.put("editorType", getEditorType());
		attributes.put("isPort", getIsPort());
		attributes.put("isCompile", getIsCompile());
		attributes.put("projectCategoryId", getProjectCategoryId());
		attributes.put("execute", getExecute());
		attributes.put("cluster", getCluster());
		attributes.put("workflowId", getWorkflowId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long descriptionId = (Long)attributes.get("descriptionId");

		if (descriptionId != null) {
			setDescriptionId(descriptionId);
		}

		Long previousVersionId = (Long)attributes.get("previousVersionId");

		if (previousVersionId != null) {
			setPreviousVersionId(previousVersionId);
		}

		Long iconId = (Long)attributes.get("iconId");

		if (iconId != null) {
			setIconId(iconId);
		}

		String manualId = (String)attributes.get("manualId");

		if (manualId != null) {
			setManualId(manualId);
		}

		String manualUrl = (String)attributes.get("manualUrl");

		if (manualUrl != null) {
			setManualUrl(manualUrl);
		}

		String exeFileName = (String)attributes.get("exeFileName");

		if (exeFileName != null) {
			setExeFileName(exeFileName);
		}

		String appType = (String)attributes.get("appType");

		if (appType != null) {
			setAppType(appType);
		}

		String runType = (String)attributes.get("runType");

		if (runType != null) {
			setRunType(runType);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		String stage = (String)attributes.get("stage");

		if (stage != null) {
			setStage(stage);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long recentModifierId = (Long)attributes.get("recentModifierId");

		if (recentModifierId != null) {
			setRecentModifierId(recentModifierId);
		}

		String parallelModule = (String)attributes.get("parallelModule");

		if (parallelModule != null) {
			setParallelModule(parallelModule);
		}

		Integer minCpus = (Integer)attributes.get("minCpus");

		if (minCpus != null) {
			setMinCpus(minCpus);
		}

		Integer maxCpus = (Integer)attributes.get("maxCpus");

		if (maxCpus != null) {
			setMaxCpus(maxCpus);
		}

		Integer defaultCpus = (Integer)attributes.get("defaultCpus");

		if (defaultCpus != null) {
			setDefaultCpus(defaultCpus);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String openLevel = (String)attributes.get("openLevel");

		if (openLevel != null) {
			setOpenLevel(openLevel);
		}

		String license = (String)attributes.get("license");

		if (license != null) {
			setLicense(license);
		}

		String srcFileName = (String)attributes.get("srcFileName");

		if (srcFileName != null) {
			setSrcFileName(srcFileName);
		}

		String targetLanguage = (String)attributes.get("targetLanguage");

		if (targetLanguage != null) {
			setTargetLanguage(targetLanguage);
		}

		Boolean isStepLayout = (Boolean)attributes.get("isStepLayout");

		if (isStepLayout != null) {
			setIsStepLayout(isStepLayout);
		}

		String layout = (String)attributes.get("layout");

		if (layout != null) {
			setLayout(layout);
		}

		String developers = (String)attributes.get("developers");

		if (developers != null) {
			setDevelopers(developers);
		}

		String editorType = (String)attributes.get("editorType");

		if (editorType != null) {
			setEditorType(editorType);
		}

		Boolean isPort = (Boolean)attributes.get("isPort");

		if (isPort != null) {
			setIsPort(isPort);
		}

		Boolean isCompile = (Boolean)attributes.get("isCompile");

		if (isCompile != null) {
			setIsCompile(isCompile);
		}

		Long projectCategoryId = (Long)attributes.get("projectCategoryId");

		if (projectCategoryId != null) {
			setProjectCategoryId(projectCategoryId);
		}

		Long execute = (Long)attributes.get("execute");

		if (execute != null) {
			setExecute(execute);
		}

		String cluster = (String)attributes.get("cluster");

		if (cluster != null) {
			setCluster(cluster);
		}

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}
	}

	/**
	* Returns the primary key of this science app.
	*
	* @return the primary key of this science app
	*/
	@Override
	public long getPrimaryKey() {
		return _scienceApp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this science app.
	*
	* @param primaryKey the primary key of this science app
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scienceApp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this science app.
	*
	* @return the uuid of this science app
	*/
	@Override
	public java.lang.String getUuid() {
		return _scienceApp.getUuid();
	}

	/**
	* Sets the uuid of this science app.
	*
	* @param uuid the uuid of this science app
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_scienceApp.setUuid(uuid);
	}

	/**
	* Returns the science app ID of this science app.
	*
	* @return the science app ID of this science app
	*/
	@Override
	public long getScienceAppId() {
		return _scienceApp.getScienceAppId();
	}

	/**
	* Sets the science app ID of this science app.
	*
	* @param scienceAppId the science app ID of this science app
	*/
	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceApp.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the group ID of this science app.
	*
	* @return the group ID of this science app
	*/
	@Override
	public long getGroupId() {
		return _scienceApp.getGroupId();
	}

	/**
	* Sets the group ID of this science app.
	*
	* @param groupId the group ID of this science app
	*/
	@Override
	public void setGroupId(long groupId) {
		_scienceApp.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this science app.
	*
	* @return the company ID of this science app
	*/
	@Override
	public long getCompanyId() {
		return _scienceApp.getCompanyId();
	}

	/**
	* Sets the company ID of this science app.
	*
	* @param companyId the company ID of this science app
	*/
	@Override
	public void setCompanyId(long companyId) {
		_scienceApp.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this science app.
	*
	* @return the user ID of this science app
	*/
	@Override
	public long getUserId() {
		return _scienceApp.getUserId();
	}

	/**
	* Sets the user ID of this science app.
	*
	* @param userId the user ID of this science app
	*/
	@Override
	public void setUserId(long userId) {
		_scienceApp.setUserId(userId);
	}

	/**
	* Returns the user uuid of this science app.
	*
	* @return the user uuid of this science app
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceApp.getUserUuid();
	}

	/**
	* Sets the user uuid of this science app.
	*
	* @param userUuid the user uuid of this science app
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_scienceApp.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this science app.
	*
	* @return the create date of this science app
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _scienceApp.getCreateDate();
	}

	/**
	* Sets the create date of this science app.
	*
	* @param createDate the create date of this science app
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_scienceApp.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this science app.
	*
	* @return the modified date of this science app
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _scienceApp.getModifiedDate();
	}

	/**
	* Sets the modified date of this science app.
	*
	* @param modifiedDate the modified date of this science app
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_scienceApp.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this science app.
	*
	* @return the name of this science app
	*/
	@Override
	public java.lang.String getName() {
		return _scienceApp.getName();
	}

	/**
	* Sets the name of this science app.
	*
	* @param name the name of this science app
	*/
	@Override
	public void setName(java.lang.String name) {
		_scienceApp.setName(name);
	}

	/**
	* Returns the version of this science app.
	*
	* @return the version of this science app
	*/
	@Override
	public java.lang.String getVersion() {
		return _scienceApp.getVersion();
	}

	/**
	* Sets the version of this science app.
	*
	* @param version the version of this science app
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_scienceApp.setVersion(version);
	}

	/**
	* Returns the title of this science app.
	*
	* @return the title of this science app
	*/
	@Override
	public java.lang.String getTitle() {
		return _scienceApp.getTitle();
	}

	/**
	* Returns the localized title of this science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this science app
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _scienceApp.getTitle(locale);
	}

	/**
	* Returns the localized title of this science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this science app. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _scienceApp.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this science app
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _scienceApp.getTitle(languageId);
	}

	/**
	* Returns the localized title of this science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this science app
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _scienceApp.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _scienceApp.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _scienceApp.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this science app.
	*
	* @return the locales and localized titles of this science app
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _scienceApp.getTitleMap();
	}

	/**
	* Sets the title of this science app.
	*
	* @param title the title of this science app
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_scienceApp.setTitle(title);
	}

	/**
	* Sets the localized title of this science app in the language.
	*
	* @param title the localized title of this science app
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_scienceApp.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this science app in the language, and sets the default locale.
	*
	* @param title the localized title of this science app
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_scienceApp.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_scienceApp.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this science app from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this science app
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_scienceApp.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this science app from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this science app
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_scienceApp.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the description ID of this science app.
	*
	* @return the description ID of this science app
	*/
	@Override
	public long getDescriptionId() {
		return _scienceApp.getDescriptionId();
	}

	/**
	* Sets the description ID of this science app.
	*
	* @param descriptionId the description ID of this science app
	*/
	@Override
	public void setDescriptionId(long descriptionId) {
		_scienceApp.setDescriptionId(descriptionId);
	}

	/**
	* Returns the previous version ID of this science app.
	*
	* @return the previous version ID of this science app
	*/
	@Override
	public long getPreviousVersionId() {
		return _scienceApp.getPreviousVersionId();
	}

	/**
	* Sets the previous version ID of this science app.
	*
	* @param previousVersionId the previous version ID of this science app
	*/
	@Override
	public void setPreviousVersionId(long previousVersionId) {
		_scienceApp.setPreviousVersionId(previousVersionId);
	}

	/**
	* Returns the icon ID of this science app.
	*
	* @return the icon ID of this science app
	*/
	@Override
	public long getIconId() {
		return _scienceApp.getIconId();
	}

	/**
	* Sets the icon ID of this science app.
	*
	* @param iconId the icon ID of this science app
	*/
	@Override
	public void setIconId(long iconId) {
		_scienceApp.setIconId(iconId);
	}

	/**
	* Returns the manual ID of this science app.
	*
	* @return the manual ID of this science app
	*/
	@Override
	public java.lang.String getManualId() {
		return _scienceApp.getManualId();
	}

	/**
	* Returns the localized manual ID of this science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized manual ID of this science app
	*/
	@Override
	public java.lang.String getManualId(java.util.Locale locale) {
		return _scienceApp.getManualId(locale);
	}

	/**
	* Returns the localized manual ID of this science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized manual ID of this science app. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getManualId(java.util.Locale locale,
		boolean useDefault) {
		return _scienceApp.getManualId(locale, useDefault);
	}

	/**
	* Returns the localized manual ID of this science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized manual ID of this science app
	*/
	@Override
	public java.lang.String getManualId(java.lang.String languageId) {
		return _scienceApp.getManualId(languageId);
	}

	/**
	* Returns the localized manual ID of this science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized manual ID of this science app
	*/
	@Override
	public java.lang.String getManualId(java.lang.String languageId,
		boolean useDefault) {
		return _scienceApp.getManualId(languageId, useDefault);
	}

	@Override
	public java.lang.String getManualIdCurrentLanguageId() {
		return _scienceApp.getManualIdCurrentLanguageId();
	}

	@Override
	public java.lang.String getManualIdCurrentValue() {
		return _scienceApp.getManualIdCurrentValue();
	}

	/**
	* Returns a map of the locales and localized manual IDs of this science app.
	*
	* @return the locales and localized manual IDs of this science app
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getManualIdMap() {
		return _scienceApp.getManualIdMap();
	}

	/**
	* Sets the manual ID of this science app.
	*
	* @param manualId the manual ID of this science app
	*/
	@Override
	public void setManualId(java.lang.String manualId) {
		_scienceApp.setManualId(manualId);
	}

	/**
	* Sets the localized manual ID of this science app in the language.
	*
	* @param manualId the localized manual ID of this science app
	* @param locale the locale of the language
	*/
	@Override
	public void setManualId(java.lang.String manualId, java.util.Locale locale) {
		_scienceApp.setManualId(manualId, locale);
	}

	/**
	* Sets the localized manual ID of this science app in the language, and sets the default locale.
	*
	* @param manualId the localized manual ID of this science app
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setManualId(java.lang.String manualId, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_scienceApp.setManualId(manualId, locale, defaultLocale);
	}

	@Override
	public void setManualIdCurrentLanguageId(java.lang.String languageId) {
		_scienceApp.setManualIdCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized manual IDs of this science app from the map of locales and localized manual IDs.
	*
	* @param manualIdMap the locales and localized manual IDs of this science app
	*/
	@Override
	public void setManualIdMap(
		java.util.Map<java.util.Locale, java.lang.String> manualIdMap) {
		_scienceApp.setManualIdMap(manualIdMap);
	}

	/**
	* Sets the localized manual IDs of this science app from the map of locales and localized manual IDs, and sets the default locale.
	*
	* @param manualIdMap the locales and localized manual IDs of this science app
	* @param defaultLocale the default locale
	*/
	@Override
	public void setManualIdMap(
		java.util.Map<java.util.Locale, java.lang.String> manualIdMap,
		java.util.Locale defaultLocale) {
		_scienceApp.setManualIdMap(manualIdMap, defaultLocale);
	}

	/**
	* Returns the manual url of this science app.
	*
	* @return the manual url of this science app
	*/
	@Override
	public java.lang.String getManualUrl() {
		return _scienceApp.getManualUrl();
	}

	/**
	* Returns the localized manual url of this science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized manual url of this science app
	*/
	@Override
	public java.lang.String getManualUrl(java.util.Locale locale) {
		return _scienceApp.getManualUrl(locale);
	}

	/**
	* Returns the localized manual url of this science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized manual url of this science app. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getManualUrl(java.util.Locale locale,
		boolean useDefault) {
		return _scienceApp.getManualUrl(locale, useDefault);
	}

	/**
	* Returns the localized manual url of this science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized manual url of this science app
	*/
	@Override
	public java.lang.String getManualUrl(java.lang.String languageId) {
		return _scienceApp.getManualUrl(languageId);
	}

	/**
	* Returns the localized manual url of this science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized manual url of this science app
	*/
	@Override
	public java.lang.String getManualUrl(java.lang.String languageId,
		boolean useDefault) {
		return _scienceApp.getManualUrl(languageId, useDefault);
	}

	@Override
	public java.lang.String getManualUrlCurrentLanguageId() {
		return _scienceApp.getManualUrlCurrentLanguageId();
	}

	@Override
	public java.lang.String getManualUrlCurrentValue() {
		return _scienceApp.getManualUrlCurrentValue();
	}

	/**
	* Returns a map of the locales and localized manual urls of this science app.
	*
	* @return the locales and localized manual urls of this science app
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getManualUrlMap() {
		return _scienceApp.getManualUrlMap();
	}

	/**
	* Sets the manual url of this science app.
	*
	* @param manualUrl the manual url of this science app
	*/
	@Override
	public void setManualUrl(java.lang.String manualUrl) {
		_scienceApp.setManualUrl(manualUrl);
	}

	/**
	* Sets the localized manual url of this science app in the language.
	*
	* @param manualUrl the localized manual url of this science app
	* @param locale the locale of the language
	*/
	@Override
	public void setManualUrl(java.lang.String manualUrl, java.util.Locale locale) {
		_scienceApp.setManualUrl(manualUrl, locale);
	}

	/**
	* Sets the localized manual url of this science app in the language, and sets the default locale.
	*
	* @param manualUrl the localized manual url of this science app
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setManualUrl(java.lang.String manualUrl,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_scienceApp.setManualUrl(manualUrl, locale, defaultLocale);
	}

	@Override
	public void setManualUrlCurrentLanguageId(java.lang.String languageId) {
		_scienceApp.setManualUrlCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized manual urls of this science app from the map of locales and localized manual urls.
	*
	* @param manualUrlMap the locales and localized manual urls of this science app
	*/
	@Override
	public void setManualUrlMap(
		java.util.Map<java.util.Locale, java.lang.String> manualUrlMap) {
		_scienceApp.setManualUrlMap(manualUrlMap);
	}

	/**
	* Sets the localized manual urls of this science app from the map of locales and localized manual urls, and sets the default locale.
	*
	* @param manualUrlMap the locales and localized manual urls of this science app
	* @param defaultLocale the default locale
	*/
	@Override
	public void setManualUrlMap(
		java.util.Map<java.util.Locale, java.lang.String> manualUrlMap,
		java.util.Locale defaultLocale) {
		_scienceApp.setManualUrlMap(manualUrlMap, defaultLocale);
	}

	/**
	* Returns the exe file name of this science app.
	*
	* @return the exe file name of this science app
	*/
	@Override
	public java.lang.String getExeFileName() {
		return _scienceApp.getExeFileName();
	}

	/**
	* Sets the exe file name of this science app.
	*
	* @param exeFileName the exe file name of this science app
	*/
	@Override
	public void setExeFileName(java.lang.String exeFileName) {
		_scienceApp.setExeFileName(exeFileName);
	}

	/**
	* Returns the app type of this science app.
	*
	* @return the app type of this science app
	*/
	@Override
	public java.lang.String getAppType() {
		return _scienceApp.getAppType();
	}

	/**
	* Sets the app type of this science app.
	*
	* @param appType the app type of this science app
	*/
	@Override
	public void setAppType(java.lang.String appType) {
		_scienceApp.setAppType(appType);
	}

	/**
	* Returns the run type of this science app.
	*
	* @return the run type of this science app
	*/
	@Override
	public java.lang.String getRunType() {
		return _scienceApp.getRunType();
	}

	/**
	* Sets the run type of this science app.
	*
	* @param runType the run type of this science app
	*/
	@Override
	public void setRunType(java.lang.String runType) {
		_scienceApp.setRunType(runType);
	}

	/**
	* Returns the author ID of this science app.
	*
	* @return the author ID of this science app
	*/
	@Override
	public long getAuthorId() {
		return _scienceApp.getAuthorId();
	}

	/**
	* Sets the author ID of this science app.
	*
	* @param authorId the author ID of this science app
	*/
	@Override
	public void setAuthorId(long authorId) {
		_scienceApp.setAuthorId(authorId);
	}

	/**
	* Returns the stage of this science app.
	*
	* @return the stage of this science app
	*/
	@Override
	public java.lang.String getStage() {
		return _scienceApp.getStage();
	}

	/**
	* Sets the stage of this science app.
	*
	* @param stage the stage of this science app
	*/
	@Override
	public void setStage(java.lang.String stage) {
		_scienceApp.setStage(stage);
	}

	/**
	* Returns the status of this science app.
	*
	* @return the status of this science app
	*/
	@Override
	public int getStatus() {
		return _scienceApp.getStatus();
	}

	/**
	* Sets the status of this science app.
	*
	* @param status the status of this science app
	*/
	@Override
	public void setStatus(int status) {
		_scienceApp.setStatus(status);
	}

	/**
	* Returns the recent modifier ID of this science app.
	*
	* @return the recent modifier ID of this science app
	*/
	@Override
	public long getRecentModifierId() {
		return _scienceApp.getRecentModifierId();
	}

	/**
	* Sets the recent modifier ID of this science app.
	*
	* @param recentModifierId the recent modifier ID of this science app
	*/
	@Override
	public void setRecentModifierId(long recentModifierId) {
		_scienceApp.setRecentModifierId(recentModifierId);
	}

	/**
	* Returns the parallel module of this science app.
	*
	* @return the parallel module of this science app
	*/
	@Override
	public java.lang.String getParallelModule() {
		return _scienceApp.getParallelModule();
	}

	/**
	* Sets the parallel module of this science app.
	*
	* @param parallelModule the parallel module of this science app
	*/
	@Override
	public void setParallelModule(java.lang.String parallelModule) {
		_scienceApp.setParallelModule(parallelModule);
	}

	/**
	* Returns the min cpus of this science app.
	*
	* @return the min cpus of this science app
	*/
	@Override
	public int getMinCpus() {
		return _scienceApp.getMinCpus();
	}

	/**
	* Sets the min cpus of this science app.
	*
	* @param minCpus the min cpus of this science app
	*/
	@Override
	public void setMinCpus(int minCpus) {
		_scienceApp.setMinCpus(minCpus);
	}

	/**
	* Returns the max cpus of this science app.
	*
	* @return the max cpus of this science app
	*/
	@Override
	public int getMaxCpus() {
		return _scienceApp.getMaxCpus();
	}

	/**
	* Sets the max cpus of this science app.
	*
	* @param maxCpus the max cpus of this science app
	*/
	@Override
	public void setMaxCpus(int maxCpus) {
		_scienceApp.setMaxCpus(maxCpus);
	}

	/**
	* Returns the default cpus of this science app.
	*
	* @return the default cpus of this science app
	*/
	@Override
	public int getDefaultCpus() {
		return _scienceApp.getDefaultCpus();
	}

	/**
	* Sets the default cpus of this science app.
	*
	* @param defaultCpus the default cpus of this science app
	*/
	@Override
	public void setDefaultCpus(int defaultCpus) {
		_scienceApp.setDefaultCpus(defaultCpus);
	}

	/**
	* Returns the status date of this science app.
	*
	* @return the status date of this science app
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _scienceApp.getStatusDate();
	}

	/**
	* Sets the status date of this science app.
	*
	* @param statusDate the status date of this science app
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_scienceApp.setStatusDate(statusDate);
	}

	/**
	* Returns the open level of this science app.
	*
	* @return the open level of this science app
	*/
	@Override
	public java.lang.String getOpenLevel() {
		return _scienceApp.getOpenLevel();
	}

	/**
	* Sets the open level of this science app.
	*
	* @param openLevel the open level of this science app
	*/
	@Override
	public void setOpenLevel(java.lang.String openLevel) {
		_scienceApp.setOpenLevel(openLevel);
	}

	/**
	* Returns the license of this science app.
	*
	* @return the license of this science app
	*/
	@Override
	public java.lang.String getLicense() {
		return _scienceApp.getLicense();
	}

	/**
	* Sets the license of this science app.
	*
	* @param license the license of this science app
	*/
	@Override
	public void setLicense(java.lang.String license) {
		_scienceApp.setLicense(license);
	}

	/**
	* Returns the src file name of this science app.
	*
	* @return the src file name of this science app
	*/
	@Override
	public java.lang.String getSrcFileName() {
		return _scienceApp.getSrcFileName();
	}

	/**
	* Sets the src file name of this science app.
	*
	* @param srcFileName the src file name of this science app
	*/
	@Override
	public void setSrcFileName(java.lang.String srcFileName) {
		_scienceApp.setSrcFileName(srcFileName);
	}

	/**
	* Returns the target language of this science app.
	*
	* @return the target language of this science app
	*/
	@Override
	public java.lang.String getTargetLanguage() {
		return _scienceApp.getTargetLanguage();
	}

	/**
	* Sets the target language of this science app.
	*
	* @param targetLanguage the target language of this science app
	*/
	@Override
	public void setTargetLanguage(java.lang.String targetLanguage) {
		_scienceApp.setTargetLanguage(targetLanguage);
	}

	/**
	* Returns the is step layout of this science app.
	*
	* @return the is step layout of this science app
	*/
	@Override
	public java.lang.Boolean getIsStepLayout() {
		return _scienceApp.getIsStepLayout();
	}

	/**
	* Sets the is step layout of this science app.
	*
	* @param isStepLayout the is step layout of this science app
	*/
	@Override
	public void setIsStepLayout(java.lang.Boolean isStepLayout) {
		_scienceApp.setIsStepLayout(isStepLayout);
	}

	/**
	* Returns the layout of this science app.
	*
	* @return the layout of this science app
	*/
	@Override
	public java.lang.String getLayout() {
		return _scienceApp.getLayout();
	}

	/**
	* Sets the layout of this science app.
	*
	* @param layout the layout of this science app
	*/
	@Override
	public void setLayout(java.lang.String layout) {
		_scienceApp.setLayout(layout);
	}

	/**
	* Returns the developers of this science app.
	*
	* @return the developers of this science app
	*/
	@Override
	public java.lang.String getDevelopers() {
		return _scienceApp.getDevelopers();
	}

	/**
	* Returns the localized developers of this science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized developers of this science app
	*/
	@Override
	public java.lang.String getDevelopers(java.util.Locale locale) {
		return _scienceApp.getDevelopers(locale);
	}

	/**
	* Returns the localized developers of this science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized developers of this science app. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDevelopers(java.util.Locale locale,
		boolean useDefault) {
		return _scienceApp.getDevelopers(locale, useDefault);
	}

	/**
	* Returns the localized developers of this science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized developers of this science app
	*/
	@Override
	public java.lang.String getDevelopers(java.lang.String languageId) {
		return _scienceApp.getDevelopers(languageId);
	}

	/**
	* Returns the localized developers of this science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized developers of this science app
	*/
	@Override
	public java.lang.String getDevelopers(java.lang.String languageId,
		boolean useDefault) {
		return _scienceApp.getDevelopers(languageId, useDefault);
	}

	@Override
	public java.lang.String getDevelopersCurrentLanguageId() {
		return _scienceApp.getDevelopersCurrentLanguageId();
	}

	@Override
	public java.lang.String getDevelopersCurrentValue() {
		return _scienceApp.getDevelopersCurrentValue();
	}

	/**
	* Returns a map of the locales and localized developerses of this science app.
	*
	* @return the locales and localized developerses of this science app
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDevelopersMap() {
		return _scienceApp.getDevelopersMap();
	}

	/**
	* Sets the developers of this science app.
	*
	* @param developers the developers of this science app
	*/
	@Override
	public void setDevelopers(java.lang.String developers) {
		_scienceApp.setDevelopers(developers);
	}

	/**
	* Sets the localized developers of this science app in the language.
	*
	* @param developers the localized developers of this science app
	* @param locale the locale of the language
	*/
	@Override
	public void setDevelopers(java.lang.String developers,
		java.util.Locale locale) {
		_scienceApp.setDevelopers(developers, locale);
	}

	/**
	* Sets the localized developers of this science app in the language, and sets the default locale.
	*
	* @param developers the localized developers of this science app
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDevelopers(java.lang.String developers,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_scienceApp.setDevelopers(developers, locale, defaultLocale);
	}

	@Override
	public void setDevelopersCurrentLanguageId(java.lang.String languageId) {
		_scienceApp.setDevelopersCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized developerses of this science app from the map of locales and localized developerses.
	*
	* @param developersMap the locales and localized developerses of this science app
	*/
	@Override
	public void setDevelopersMap(
		java.util.Map<java.util.Locale, java.lang.String> developersMap) {
		_scienceApp.setDevelopersMap(developersMap);
	}

	/**
	* Sets the localized developerses of this science app from the map of locales and localized developerses, and sets the default locale.
	*
	* @param developersMap the locales and localized developerses of this science app
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDevelopersMap(
		java.util.Map<java.util.Locale, java.lang.String> developersMap,
		java.util.Locale defaultLocale) {
		_scienceApp.setDevelopersMap(developersMap, defaultLocale);
	}

	/**
	* Returns the editor type of this science app.
	*
	* @return the editor type of this science app
	*/
	@Override
	public java.lang.String getEditorType() {
		return _scienceApp.getEditorType();
	}

	/**
	* Sets the editor type of this science app.
	*
	* @param editorType the editor type of this science app
	*/
	@Override
	public void setEditorType(java.lang.String editorType) {
		_scienceApp.setEditorType(editorType);
	}

	/**
	* Returns the is port of this science app.
	*
	* @return the is port of this science app
	*/
	@Override
	public boolean getIsPort() {
		return _scienceApp.getIsPort();
	}

	/**
	* Returns <code>true</code> if this science app is is port.
	*
	* @return <code>true</code> if this science app is is port; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsPort() {
		return _scienceApp.isIsPort();
	}

	/**
	* Sets whether this science app is is port.
	*
	* @param isPort the is port of this science app
	*/
	@Override
	public void setIsPort(boolean isPort) {
		_scienceApp.setIsPort(isPort);
	}

	/**
	* Returns the is compile of this science app.
	*
	* @return the is compile of this science app
	*/
	@Override
	public boolean getIsCompile() {
		return _scienceApp.getIsCompile();
	}

	/**
	* Returns <code>true</code> if this science app is is compile.
	*
	* @return <code>true</code> if this science app is is compile; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsCompile() {
		return _scienceApp.isIsCompile();
	}

	/**
	* Sets whether this science app is is compile.
	*
	* @param isCompile the is compile of this science app
	*/
	@Override
	public void setIsCompile(boolean isCompile) {
		_scienceApp.setIsCompile(isCompile);
	}

	/**
	* Returns the project category ID of this science app.
	*
	* @return the project category ID of this science app
	*/
	@Override
	public long getProjectCategoryId() {
		return _scienceApp.getProjectCategoryId();
	}

	/**
	* Sets the project category ID of this science app.
	*
	* @param projectCategoryId the project category ID of this science app
	*/
	@Override
	public void setProjectCategoryId(long projectCategoryId) {
		_scienceApp.setProjectCategoryId(projectCategoryId);
	}

	/**
	* Returns the execute of this science app.
	*
	* @return the execute of this science app
	*/
	@Override
	public long getExecute() {
		return _scienceApp.getExecute();
	}

	/**
	* Sets the execute of this science app.
	*
	* @param execute the execute of this science app
	*/
	@Override
	public void setExecute(long execute) {
		_scienceApp.setExecute(execute);
	}

	/**
	* Returns the cluster of this science app.
	*
	* @return the cluster of this science app
	*/
	@Override
	public java.lang.String getCluster() {
		return _scienceApp.getCluster();
	}

	/**
	* Sets the cluster of this science app.
	*
	* @param cluster the cluster of this science app
	*/
	@Override
	public void setCluster(java.lang.String cluster) {
		_scienceApp.setCluster(cluster);
	}

	/**
	* Returns the workflow ID of this science app.
	*
	* @return the workflow ID of this science app
	*/
	@Override
	public long getWorkflowId() {
		return _scienceApp.getWorkflowId();
	}

	/**
	* Sets the workflow ID of this science app.
	*
	* @param workflowId the workflow ID of this science app
	*/
	@Override
	public void setWorkflowId(long workflowId) {
		_scienceApp.setWorkflowId(workflowId);
	}

	@Override
	public boolean isNew() {
		return _scienceApp.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scienceApp.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scienceApp.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scienceApp.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scienceApp.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scienceApp.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scienceApp.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scienceApp.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scienceApp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scienceApp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scienceApp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _scienceApp.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _scienceApp.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_scienceApp.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_scienceApp.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new ScienceAppWrapper((ScienceApp)_scienceApp.clone());
	}

	@Override
	public int compareTo(org.kisti.edison.science.model.ScienceApp scienceApp) {
		return _scienceApp.compareTo(scienceApp);
	}

	@Override
	public int hashCode() {
		return _scienceApp.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.ScienceApp> toCacheModel() {
		return _scienceApp.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.ScienceApp toEscapedModel() {
		return new ScienceAppWrapper(_scienceApp.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.ScienceApp toUnescapedModel() {
		return new ScienceAppWrapper(_scienceApp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scienceApp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scienceApp.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceApp.persist();
	}

	/**
	* Test if  a science app is being serviced,
	*
	* @return true if stage is ScienceAppConstant.IN_SERVICE.
	false, otherwise.
	* @see com.kisti.science.platform.model.ScienceApp#isApproved()
	*/
	@Override
	public boolean isApproved() {
		return _scienceApp.isApproved();
	}

	/**
	* Get the binary file path of the science app.
	*
	* @param scienceAppId
	* @return String - path to binary file
	*/
	@Override
	public java.lang.String getBinPath() {
		return _scienceApp.getBinPath();
	}

	/**
	* Get the source file path of the science app.
	*
	* @param scienceAppId
	* @return String - path to source file
	*/
	@Override
	public java.lang.String getSrcPath() {
		return _scienceApp.getSrcPath();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScienceAppWrapper)) {
			return false;
		}

		ScienceAppWrapper scienceAppWrapper = (ScienceAppWrapper)obj;

		if (Validator.equals(_scienceApp, scienceAppWrapper._scienceApp)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _scienceApp.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ScienceApp getWrappedScienceApp() {
		return _scienceApp;
	}

	@Override
	public ScienceApp getWrappedModel() {
		return _scienceApp;
	}

	@Override
	public void resetOriginalValues() {
		_scienceApp.resetOriginalValues();
	}

	private ScienceApp _scienceApp;
}