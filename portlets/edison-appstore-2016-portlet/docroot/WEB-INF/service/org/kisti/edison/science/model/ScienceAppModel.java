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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the ScienceApp service. Represents a row in the &quot;EDAPP_ScienceApp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.science.model.impl.ScienceAppImpl}.
 * </p>
 *
 * @author EDISON
 * @see ScienceApp
 * @see org.kisti.edison.science.model.impl.ScienceAppImpl
 * @see org.kisti.edison.science.model.impl.ScienceAppModelImpl
 * @generated
 */
public interface ScienceAppModel extends BaseModel<ScienceApp>, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a science app model instance should use the {@link ScienceApp} interface instead.
	 */

	/**
	 * Returns the primary key of this science app.
	 *
	 * @return the primary key of this science app
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this science app.
	 *
	 * @param primaryKey the primary key of this science app
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this science app.
	 *
	 * @return the uuid of this science app
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this science app.
	 *
	 * @param uuid the uuid of this science app
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the science app ID of this science app.
	 *
	 * @return the science app ID of this science app
	 */
	public long getScienceAppId();

	/**
	 * Sets the science app ID of this science app.
	 *
	 * @param scienceAppId the science app ID of this science app
	 */
	public void setScienceAppId(long scienceAppId);

	/**
	 * Returns the group ID of this science app.
	 *
	 * @return the group ID of this science app
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this science app.
	 *
	 * @param groupId the group ID of this science app
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this science app.
	 *
	 * @return the company ID of this science app
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this science app.
	 *
	 * @param companyId the company ID of this science app
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this science app.
	 *
	 * @return the user ID of this science app
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this science app.
	 *
	 * @param userId the user ID of this science app
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this science app.
	 *
	 * @return the user uuid of this science app
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this science app.
	 *
	 * @param userUuid the user uuid of this science app
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this science app.
	 *
	 * @return the create date of this science app
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this science app.
	 *
	 * @param createDate the create date of this science app
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this science app.
	 *
	 * @return the modified date of this science app
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this science app.
	 *
	 * @param modifiedDate the modified date of this science app
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this science app.
	 *
	 * @return the name of this science app
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this science app.
	 *
	 * @param name the name of this science app
	 */
	public void setName(String name);

	/**
	 * Returns the version of this science app.
	 *
	 * @return the version of this science app
	 */
	@AutoEscape
	public String getVersion();

	/**
	 * Sets the version of this science app.
	 *
	 * @param version the version of this science app
	 */
	public void setVersion(String version);

	/**
	 * Returns the title of this science app.
	 *
	 * @return the title of this science app
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this science app in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this science app
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this science app in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this science app. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this science app in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this science app
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this science app in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this science app
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this science app.
	 *
	 * @return the locales and localized titles of this science app
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this science app.
	 *
	 * @param title the title of this science app
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this science app in the language.
	 *
	 * @param title the localized title of this science app
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this science app in the language, and sets the default locale.
	 *
	 * @param title the localized title of this science app
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this science app from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this science app
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this science app from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this science app
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description ID of this science app.
	 *
	 * @return the description ID of this science app
	 */
	public long getDescriptionId();

	/**
	 * Sets the description ID of this science app.
	 *
	 * @param descriptionId the description ID of this science app
	 */
	public void setDescriptionId(long descriptionId);

	/**
	 * Returns the previous version ID of this science app.
	 *
	 * @return the previous version ID of this science app
	 */
	public long getPreviousVersionId();

	/**
	 * Sets the previous version ID of this science app.
	 *
	 * @param previousVersionId the previous version ID of this science app
	 */
	public void setPreviousVersionId(long previousVersionId);

	/**
	 * Returns the icon ID of this science app.
	 *
	 * @return the icon ID of this science app
	 */
	public long getIconId();

	/**
	 * Sets the icon ID of this science app.
	 *
	 * @param iconId the icon ID of this science app
	 */
	public void setIconId(long iconId);

	/**
	 * Returns the manual ID of this science app.
	 *
	 * @return the manual ID of this science app
	 */
	public String getManualId();

	/**
	 * Returns the localized manual ID of this science app in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized manual ID of this science app
	 */
	@AutoEscape
	public String getManualId(Locale locale);

	/**
	 * Returns the localized manual ID of this science app in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized manual ID of this science app. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getManualId(Locale locale, boolean useDefault);

	/**
	 * Returns the localized manual ID of this science app in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized manual ID of this science app
	 */
	@AutoEscape
	public String getManualId(String languageId);

	/**
	 * Returns the localized manual ID of this science app in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized manual ID of this science app
	 */
	@AutoEscape
	public String getManualId(String languageId, boolean useDefault);

	@AutoEscape
	public String getManualIdCurrentLanguageId();

	@AutoEscape
	public String getManualIdCurrentValue();

	/**
	 * Returns a map of the locales and localized manual IDs of this science app.
	 *
	 * @return the locales and localized manual IDs of this science app
	 */
	public Map<Locale, String> getManualIdMap();

	/**
	 * Sets the manual ID of this science app.
	 *
	 * @param manualId the manual ID of this science app
	 */
	public void setManualId(String manualId);

	/**
	 * Sets the localized manual ID of this science app in the language.
	 *
	 * @param manualId the localized manual ID of this science app
	 * @param locale the locale of the language
	 */
	public void setManualId(String manualId, Locale locale);

	/**
	 * Sets the localized manual ID of this science app in the language, and sets the default locale.
	 *
	 * @param manualId the localized manual ID of this science app
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setManualId(String manualId, Locale locale, Locale defaultLocale);

	public void setManualIdCurrentLanguageId(String languageId);

	/**
	 * Sets the localized manual IDs of this science app from the map of locales and localized manual IDs.
	 *
	 * @param manualIdMap the locales and localized manual IDs of this science app
	 */
	public void setManualIdMap(Map<Locale, String> manualIdMap);

	/**
	 * Sets the localized manual IDs of this science app from the map of locales and localized manual IDs, and sets the default locale.
	 *
	 * @param manualIdMap the locales and localized manual IDs of this science app
	 * @param defaultLocale the default locale
	 */
	public void setManualIdMap(Map<Locale, String> manualIdMap,
		Locale defaultLocale);

	/**
	 * Returns the exe file name of this science app.
	 *
	 * @return the exe file name of this science app
	 */
	@AutoEscape
	public String getExeFileName();

	/**
	 * Sets the exe file name of this science app.
	 *
	 * @param exeFileName the exe file name of this science app
	 */
	public void setExeFileName(String exeFileName);

	/**
	 * Returns the app type of this science app.
	 *
	 * @return the app type of this science app
	 */
	@AutoEscape
	public String getAppType();

	/**
	 * Sets the app type of this science app.
	 *
	 * @param appType the app type of this science app
	 */
	public void setAppType(String appType);

	/**
	 * Returns the run type of this science app.
	 *
	 * @return the run type of this science app
	 */
	@AutoEscape
	public String getRunType();

	/**
	 * Sets the run type of this science app.
	 *
	 * @param runType the run type of this science app
	 */
	public void setRunType(String runType);

	/**
	 * Returns the author ID of this science app.
	 *
	 * @return the author ID of this science app
	 */
	public long getAuthorId();

	/**
	 * Sets the author ID of this science app.
	 *
	 * @param authorId the author ID of this science app
	 */
	public void setAuthorId(long authorId);

	/**
	 * Returns the stage of this science app.
	 *
	 * @return the stage of this science app
	 */
	@AutoEscape
	public String getStage();

	/**
	 * Sets the stage of this science app.
	 *
	 * @param stage the stage of this science app
	 */
	public void setStage(String stage);

	/**
	 * Returns the status of this science app.
	 *
	 * @return the status of this science app
	 */
	public int getStatus();

	/**
	 * Sets the status of this science app.
	 *
	 * @param status the status of this science app
	 */
	public void setStatus(int status);

	/**
	 * Returns the recent modifier ID of this science app.
	 *
	 * @return the recent modifier ID of this science app
	 */
	public long getRecentModifierId();

	/**
	 * Sets the recent modifier ID of this science app.
	 *
	 * @param recentModifierId the recent modifier ID of this science app
	 */
	public void setRecentModifierId(long recentModifierId);

	/**
	 * Returns the parallel module of this science app.
	 *
	 * @return the parallel module of this science app
	 */
	@AutoEscape
	public String getParallelModule();

	/**
	 * Sets the parallel module of this science app.
	 *
	 * @param parallelModule the parallel module of this science app
	 */
	public void setParallelModule(String parallelModule);

	/**
	 * Returns the min cpus of this science app.
	 *
	 * @return the min cpus of this science app
	 */
	public int getMinCpus();

	/**
	 * Sets the min cpus of this science app.
	 *
	 * @param minCpus the min cpus of this science app
	 */
	public void setMinCpus(int minCpus);

	/**
	 * Returns the max cpus of this science app.
	 *
	 * @return the max cpus of this science app
	 */
	public int getMaxCpus();

	/**
	 * Sets the max cpus of this science app.
	 *
	 * @param maxCpus the max cpus of this science app
	 */
	public void setMaxCpus(int maxCpus);

	/**
	 * Returns the default cpus of this science app.
	 *
	 * @return the default cpus of this science app
	 */
	public int getDefaultCpus();

	/**
	 * Sets the default cpus of this science app.
	 *
	 * @param defaultCpus the default cpus of this science app
	 */
	public void setDefaultCpus(int defaultCpus);

	/**
	 * Returns the status date of this science app.
	 *
	 * @return the status date of this science app
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this science app.
	 *
	 * @param statusDate the status date of this science app
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the open level of this science app.
	 *
	 * @return the open level of this science app
	 */
	@AutoEscape
	public String getOpenLevel();

	/**
	 * Sets the open level of this science app.
	 *
	 * @param openLevel the open level of this science app
	 */
	public void setOpenLevel(String openLevel);

	/**
	 * Returns the license of this science app.
	 *
	 * @return the license of this science app
	 */
	@AutoEscape
	public String getLicense();

	/**
	 * Sets the license of this science app.
	 *
	 * @param license the license of this science app
	 */
	public void setLicense(String license);

	/**
	 * Returns the src file name of this science app.
	 *
	 * @return the src file name of this science app
	 */
	@AutoEscape
	public String getSrcFileName();

	/**
	 * Sets the src file name of this science app.
	 *
	 * @param srcFileName the src file name of this science app
	 */
	public void setSrcFileName(String srcFileName);

	/**
	 * Returns the target language of this science app.
	 *
	 * @return the target language of this science app
	 */
	@AutoEscape
	public String getTargetLanguage();

	/**
	 * Sets the target language of this science app.
	 *
	 * @param targetLanguage the target language of this science app
	 */
	public void setTargetLanguage(String targetLanguage);

	/**
	 * Returns the templet ID of this science app.
	 *
	 * @return the templet ID of this science app
	 */
	@AutoEscape
	public String getTempletId();

	/**
	 * Sets the templet ID of this science app.
	 *
	 * @param templetId the templet ID of this science app
	 */
	public void setTempletId(String templetId);

	/**
	 * Returns the layout of this science app.
	 *
	 * @return the layout of this science app
	 */
	@AutoEscape
	public String getLayout();

	/**
	 * Sets the layout of this science app.
	 *
	 * @param layout the layout of this science app
	 */
	public void setLayout(String layout);

	/**
	 * Returns the developers of this science app.
	 *
	 * @return the developers of this science app
	 */
	public String getDevelopers();

	/**
	 * Returns the localized developers of this science app in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized developers of this science app
	 */
	@AutoEscape
	public String getDevelopers(Locale locale);

	/**
	 * Returns the localized developers of this science app in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized developers of this science app. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDevelopers(Locale locale, boolean useDefault);

	/**
	 * Returns the localized developers of this science app in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized developers of this science app
	 */
	@AutoEscape
	public String getDevelopers(String languageId);

	/**
	 * Returns the localized developers of this science app in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized developers of this science app
	 */
	@AutoEscape
	public String getDevelopers(String languageId, boolean useDefault);

	@AutoEscape
	public String getDevelopersCurrentLanguageId();

	@AutoEscape
	public String getDevelopersCurrentValue();

	/**
	 * Returns a map of the locales and localized developerses of this science app.
	 *
	 * @return the locales and localized developerses of this science app
	 */
	public Map<Locale, String> getDevelopersMap();

	/**
	 * Sets the developers of this science app.
	 *
	 * @param developers the developers of this science app
	 */
	public void setDevelopers(String developers);

	/**
	 * Sets the localized developers of this science app in the language.
	 *
	 * @param developers the localized developers of this science app
	 * @param locale the locale of the language
	 */
	public void setDevelopers(String developers, Locale locale);

	/**
	 * Sets the localized developers of this science app in the language, and sets the default locale.
	 *
	 * @param developers the localized developers of this science app
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDevelopers(String developers, Locale locale,
		Locale defaultLocale);

	public void setDevelopersCurrentLanguageId(String languageId);

	/**
	 * Sets the localized developerses of this science app from the map of locales and localized developerses.
	 *
	 * @param developersMap the locales and localized developerses of this science app
	 */
	public void setDevelopersMap(Map<Locale, String> developersMap);

	/**
	 * Sets the localized developerses of this science app from the map of locales and localized developerses, and sets the default locale.
	 *
	 * @param developersMap the locales and localized developerses of this science app
	 * @param defaultLocale the default locale
	 */
	public void setDevelopersMap(Map<Locale, String> developersMap,
		Locale defaultLocale);

	/**
	 * Returns the editor type of this science app.
	 *
	 * @return the editor type of this science app
	 */
	@AutoEscape
	public String getEditorType();

	/**
	 * Sets the editor type of this science app.
	 *
	 * @param editorType the editor type of this science app
	 */
	public void setEditorType(String editorType);

	/**
	 * Returns the is port of this science app.
	 *
	 * @return the is port of this science app
	 */
	public boolean getIsPort();

	/**
	 * Returns <code>true</code> if this science app is is port.
	 *
	 * @return <code>true</code> if this science app is is port; <code>false</code> otherwise
	 */
	public boolean isIsPort();

	/**
	 * Sets whether this science app is is port.
	 *
	 * @param isPort the is port of this science app
	 */
	public void setIsPort(boolean isPort);

	/**
	 * Returns the is compile of this science app.
	 *
	 * @return the is compile of this science app
	 */
	public boolean getIsCompile();

	/**
	 * Returns <code>true</code> if this science app is is compile.
	 *
	 * @return <code>true</code> if this science app is is compile; <code>false</code> otherwise
	 */
	public boolean isIsCompile();

	/**
	 * Sets whether this science app is is compile.
	 *
	 * @param isCompile the is compile of this science app
	 */
	public void setIsCompile(boolean isCompile);

	/**
	 * Returns the project category ID of this science app.
	 *
	 * @return the project category ID of this science app
	 */
	public long getProjectCategoryId();

	/**
	 * Sets the project category ID of this science app.
	 *
	 * @param projectCategoryId the project category ID of this science app
	 */
	public void setProjectCategoryId(long projectCategoryId);

	/**
	 * Returns the execute of this science app.
	 *
	 * @return the execute of this science app
	 */
	public long getExecute();

	/**
	 * Sets the execute of this science app.
	 *
	 * @param execute the execute of this science app
	 */
	public void setExecute(long execute);

	/**
	 * Returns the cluster of this science app.
	 *
	 * @return the cluster of this science app
	 */
	@AutoEscape
	public String getCluster();

	/**
	 * Sets the cluster of this science app.
	 *
	 * @param cluster the cluster of this science app
	 */
	public void setCluster(String cluster);

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

	public String[] getAvailableLanguageIds();

	public String getDefaultLanguageId();

	public void prepareLocalizedFieldsForImport() throws LocaleException;

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(org.kisti.edison.science.model.ScienceApp scienceApp);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.science.model.ScienceApp> toCacheModel();

	@Override
	public org.kisti.edison.science.model.ScienceApp toEscapedModel();

	@Override
	public org.kisti.edison.science.model.ScienceApp toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}