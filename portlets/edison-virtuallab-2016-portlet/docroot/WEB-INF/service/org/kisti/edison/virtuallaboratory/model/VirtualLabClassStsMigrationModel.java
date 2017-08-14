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

package org.kisti.edison.virtuallaboratory.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabClassStsMigrationPK;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the VirtualLabClassStsMigration service. Represents a row in the &quot;EDVIR_VirtualLabClassStsMigration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassStsMigrationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassStsMigrationImpl}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLabClassStsMigration
 * @see org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassStsMigrationImpl
 * @see org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassStsMigrationModelImpl
 * @generated
 */
public interface VirtualLabClassStsMigrationModel extends BaseModel<VirtualLabClassStsMigration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a virtual lab class sts migration model instance should use the {@link VirtualLabClassStsMigration} interface instead.
	 */

	/**
	 * Returns the primary key of this virtual lab class sts migration.
	 *
	 * @return the primary key of this virtual lab class sts migration
	 */
	public VirtualLabClassStsMigrationPK getPrimaryKey();

	/**
	 * Sets the primary key of this virtual lab class sts migration.
	 *
	 * @param primaryKey the primary key of this virtual lab class sts migration
	 */
	public void setPrimaryKey(VirtualLabClassStsMigrationPK primaryKey);

	/**
	 * Returns the group ID of this virtual lab class sts migration.
	 *
	 * @return the group ID of this virtual lab class sts migration
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this virtual lab class sts migration.
	 *
	 * @param groupId the group ID of this virtual lab class sts migration
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the virtual lab ID of this virtual lab class sts migration.
	 *
	 * @return the virtual lab ID of this virtual lab class sts migration
	 */
	public long getVirtualLabId();

	/**
	 * Sets the virtual lab ID of this virtual lab class sts migration.
	 *
	 * @param virtualLabId the virtual lab ID of this virtual lab class sts migration
	 */
	public void setVirtualLabId(long virtualLabId);

	/**
	 * Returns the class ID of this virtual lab class sts migration.
	 *
	 * @return the class ID of this virtual lab class sts migration
	 */
	public long getClassId();

	/**
	 * Sets the class ID of this virtual lab class sts migration.
	 *
	 * @param classId the class ID of this virtual lab class sts migration
	 */
	public void setClassId(long classId);

	/**
	 * Returns the university field of this virtual lab class sts migration.
	 *
	 * @return the university field of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getUniversityField();

	/**
	 * Sets the university field of this virtual lab class sts migration.
	 *
	 * @param universityField the university field of this virtual lab class sts migration
	 */
	public void setUniversityField(String universityField);

	/**
	 * Returns the virtual lab title of this virtual lab class sts migration.
	 *
	 * @return the virtual lab title of this virtual lab class sts migration
	 */
	public String getVirtualLabTitle();

	/**
	 * Returns the localized virtual lab title of this virtual lab class sts migration in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized virtual lab title of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getVirtualLabTitle(Locale locale);

	/**
	 * Returns the localized virtual lab title of this virtual lab class sts migration in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized virtual lab title of this virtual lab class sts migration. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getVirtualLabTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized virtual lab title of this virtual lab class sts migration in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized virtual lab title of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getVirtualLabTitle(String languageId);

	/**
	 * Returns the localized virtual lab title of this virtual lab class sts migration in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized virtual lab title of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getVirtualLabTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getVirtualLabTitleCurrentLanguageId();

	@AutoEscape
	public String getVirtualLabTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized virtual lab titles of this virtual lab class sts migration.
	 *
	 * @return the locales and localized virtual lab titles of this virtual lab class sts migration
	 */
	public Map<Locale, String> getVirtualLabTitleMap();

	/**
	 * Sets the virtual lab title of this virtual lab class sts migration.
	 *
	 * @param virtualLabTitle the virtual lab title of this virtual lab class sts migration
	 */
	public void setVirtualLabTitle(String virtualLabTitle);

	/**
	 * Sets the localized virtual lab title of this virtual lab class sts migration in the language.
	 *
	 * @param virtualLabTitle the localized virtual lab title of this virtual lab class sts migration
	 * @param locale the locale of the language
	 */
	public void setVirtualLabTitle(String virtualLabTitle, Locale locale);

	/**
	 * Sets the localized virtual lab title of this virtual lab class sts migration in the language, and sets the default locale.
	 *
	 * @param virtualLabTitle the localized virtual lab title of this virtual lab class sts migration
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setVirtualLabTitle(String virtualLabTitle, Locale locale,
		Locale defaultLocale);

	public void setVirtualLabTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized virtual lab titles of this virtual lab class sts migration from the map of locales and localized virtual lab titles.
	 *
	 * @param virtualLabTitleMap the locales and localized virtual lab titles of this virtual lab class sts migration
	 */
	public void setVirtualLabTitleMap(Map<Locale, String> virtualLabTitleMap);

	/**
	 * Sets the localized virtual lab titles of this virtual lab class sts migration from the map of locales and localized virtual lab titles, and sets the default locale.
	 *
	 * @param virtualLabTitleMap the locales and localized virtual lab titles of this virtual lab class sts migration
	 * @param defaultLocale the default locale
	 */
	public void setVirtualLabTitleMap(Map<Locale, String> virtualLabTitleMap,
		Locale defaultLocale);

	/**
	 * Returns the virtual lab person name of this virtual lab class sts migration.
	 *
	 * @return the virtual lab person name of this virtual lab class sts migration
	 */
	public String getVirtualLabPersonName();

	/**
	 * Returns the localized virtual lab person name of this virtual lab class sts migration in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized virtual lab person name of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getVirtualLabPersonName(Locale locale);

	/**
	 * Returns the localized virtual lab person name of this virtual lab class sts migration in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized virtual lab person name of this virtual lab class sts migration. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getVirtualLabPersonName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized virtual lab person name of this virtual lab class sts migration in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized virtual lab person name of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getVirtualLabPersonName(String languageId);

	/**
	 * Returns the localized virtual lab person name of this virtual lab class sts migration in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized virtual lab person name of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getVirtualLabPersonName(String languageId, boolean useDefault);

	@AutoEscape
	public String getVirtualLabPersonNameCurrentLanguageId();

	@AutoEscape
	public String getVirtualLabPersonNameCurrentValue();

	/**
	 * Returns a map of the locales and localized virtual lab person names of this virtual lab class sts migration.
	 *
	 * @return the locales and localized virtual lab person names of this virtual lab class sts migration
	 */
	public Map<Locale, String> getVirtualLabPersonNameMap();

	/**
	 * Sets the virtual lab person name of this virtual lab class sts migration.
	 *
	 * @param virtualLabPersonName the virtual lab person name of this virtual lab class sts migration
	 */
	public void setVirtualLabPersonName(String virtualLabPersonName);

	/**
	 * Sets the localized virtual lab person name of this virtual lab class sts migration in the language.
	 *
	 * @param virtualLabPersonName the localized virtual lab person name of this virtual lab class sts migration
	 * @param locale the locale of the language
	 */
	public void setVirtualLabPersonName(String virtualLabPersonName,
		Locale locale);

	/**
	 * Sets the localized virtual lab person name of this virtual lab class sts migration in the language, and sets the default locale.
	 *
	 * @param virtualLabPersonName the localized virtual lab person name of this virtual lab class sts migration
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setVirtualLabPersonName(String virtualLabPersonName,
		Locale locale, Locale defaultLocale);

	public void setVirtualLabPersonNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized virtual lab person names of this virtual lab class sts migration from the map of locales and localized virtual lab person names.
	 *
	 * @param virtualLabPersonNameMap the locales and localized virtual lab person names of this virtual lab class sts migration
	 */
	public void setVirtualLabPersonNameMap(
		Map<Locale, String> virtualLabPersonNameMap);

	/**
	 * Sets the localized virtual lab person names of this virtual lab class sts migration from the map of locales and localized virtual lab person names, and sets the default locale.
	 *
	 * @param virtualLabPersonNameMap the locales and localized virtual lab person names of this virtual lab class sts migration
	 * @param defaultLocale the default locale
	 */
	public void setVirtualLabPersonNameMap(
		Map<Locale, String> virtualLabPersonNameMap, Locale defaultLocale);

	/**
	 * Returns the class title of this virtual lab class sts migration.
	 *
	 * @return the class title of this virtual lab class sts migration
	 */
	public String getClassTitle();

	/**
	 * Returns the localized class title of this virtual lab class sts migration in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized class title of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getClassTitle(Locale locale);

	/**
	 * Returns the localized class title of this virtual lab class sts migration in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized class title of this virtual lab class sts migration. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getClassTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized class title of this virtual lab class sts migration in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized class title of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getClassTitle(String languageId);

	/**
	 * Returns the localized class title of this virtual lab class sts migration in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized class title of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getClassTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getClassTitleCurrentLanguageId();

	@AutoEscape
	public String getClassTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized class titles of this virtual lab class sts migration.
	 *
	 * @return the locales and localized class titles of this virtual lab class sts migration
	 */
	public Map<Locale, String> getClassTitleMap();

	/**
	 * Sets the class title of this virtual lab class sts migration.
	 *
	 * @param classTitle the class title of this virtual lab class sts migration
	 */
	public void setClassTitle(String classTitle);

	/**
	 * Sets the localized class title of this virtual lab class sts migration in the language.
	 *
	 * @param classTitle the localized class title of this virtual lab class sts migration
	 * @param locale the locale of the language
	 */
	public void setClassTitle(String classTitle, Locale locale);

	/**
	 * Sets the localized class title of this virtual lab class sts migration in the language, and sets the default locale.
	 *
	 * @param classTitle the localized class title of this virtual lab class sts migration
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setClassTitle(String classTitle, Locale locale,
		Locale defaultLocale);

	public void setClassTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized class titles of this virtual lab class sts migration from the map of locales and localized class titles.
	 *
	 * @param classTitleMap the locales and localized class titles of this virtual lab class sts migration
	 */
	public void setClassTitleMap(Map<Locale, String> classTitleMap);

	/**
	 * Sets the localized class titles of this virtual lab class sts migration from the map of locales and localized class titles, and sets the default locale.
	 *
	 * @param classTitleMap the locales and localized class titles of this virtual lab class sts migration
	 * @param defaultLocale the default locale
	 */
	public void setClassTitleMap(Map<Locale, String> classTitleMap,
		Locale defaultLocale);

	/**
	 * Returns the virtual class cd of this virtual lab class sts migration.
	 *
	 * @return the virtual class cd of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getVirtualClassCd();

	/**
	 * Sets the virtual class cd of this virtual lab class sts migration.
	 *
	 * @param virtualClassCd the virtual class cd of this virtual lab class sts migration
	 */
	public void setVirtualClassCd(String virtualClassCd);

	/**
	 * Returns the class create dt of this virtual lab class sts migration.
	 *
	 * @return the class create dt of this virtual lab class sts migration
	 */
	public Date getClassCreateDt();

	/**
	 * Sets the class create dt of this virtual lab class sts migration.
	 *
	 * @param classCreateDt the class create dt of this virtual lab class sts migration
	 */
	public void setClassCreateDt(Date classCreateDt);

	/**
	 * Returns the science app ID of this virtual lab class sts migration.
	 *
	 * @return the science app ID of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getScienceAppId();

	/**
	 * Sets the science app ID of this virtual lab class sts migration.
	 *
	 * @param scienceAppId the science app ID of this virtual lab class sts migration
	 */
	public void setScienceAppId(String scienceAppId);

	/**
	 * Returns the science app name of this virtual lab class sts migration.
	 *
	 * @return the science app name of this virtual lab class sts migration
	 */
	@AutoEscape
	public String getScienceAppName();

	/**
	 * Sets the science app name of this virtual lab class sts migration.
	 *
	 * @param scienceAppName the science app name of this virtual lab class sts migration
	 */
	public void setScienceAppName(String scienceAppName);

	/**
	 * Returns the register student cnt of this virtual lab class sts migration.
	 *
	 * @return the register student cnt of this virtual lab class sts migration
	 */
	public long getRegisterStudentCnt();

	/**
	 * Sets the register student cnt of this virtual lab class sts migration.
	 *
	 * @param registerStudentCnt the register student cnt of this virtual lab class sts migration
	 */
	public void setRegisterStudentCnt(long registerStudentCnt);

	/**
	 * Returns the execute count of this virtual lab class sts migration.
	 *
	 * @return the execute count of this virtual lab class sts migration
	 */
	public long getExecuteCount();

	/**
	 * Sets the execute count of this virtual lab class sts migration.
	 *
	 * @param executeCount the execute count of this virtual lab class sts migration
	 */
	public void setExecuteCount(long executeCount);

	/**
	 * Returns the execute studentcount of this virtual lab class sts migration.
	 *
	 * @return the execute studentcount of this virtual lab class sts migration
	 */
	public long getExecuteStudentcount();

	/**
	 * Sets the execute studentcount of this virtual lab class sts migration.
	 *
	 * @param executeStudentcount the execute studentcount of this virtual lab class sts migration
	 */
	public void setExecuteStudentcount(long executeStudentcount);

	/**
	 * Returns the avgerage runtime of this virtual lab class sts migration.
	 *
	 * @return the avgerage runtime of this virtual lab class sts migration
	 */
	public long getAvgerageRuntime();

	/**
	 * Sets the avgerage runtime of this virtual lab class sts migration.
	 *
	 * @param avgerageRuntime the avgerage runtime of this virtual lab class sts migration
	 */
	public void setAvgerageRuntime(long avgerageRuntime);

	/**
	 * Returns the cputime of this virtual lab class sts migration.
	 *
	 * @return the cputime of this virtual lab class sts migration
	 */
	public long getCputime();

	/**
	 * Sets the cputime of this virtual lab class sts migration.
	 *
	 * @param cputime the cputime of this virtual lab class sts migration
	 */
	public void setCputime(long cputime);

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
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassStsMigration virtualLabClassStsMigration);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.virtuallaboratory.model.VirtualLabClassStsMigration> toCacheModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassStsMigration toEscapedModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassStsMigration toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}