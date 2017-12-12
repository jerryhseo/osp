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

package edison.challenge.service.builder.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the Agency service. Represents a row in the &quot;edison_Agency&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link edison.challenge.service.builder.model.impl.AgencyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link edison.challenge.service.builder.model.impl.AgencyImpl}.
 * </p>
 *
 * @author kyj
 * @see Agency
 * @see edison.challenge.service.builder.model.impl.AgencyImpl
 * @see edison.challenge.service.builder.model.impl.AgencyModelImpl
 * @generated
 */
public interface AgencyModel extends BaseModel<Agency> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a agency model instance should use the {@link Agency} interface instead.
	 */

	/**
	 * Returns the primary key of this agency.
	 *
	 * @return the primary key of this agency
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this agency.
	 *
	 * @param primaryKey the primary key of this agency
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the agencyid of this agency.
	 *
	 * @return the agencyid of this agency
	 */
	public long getAgencyid();

	/**
	 * Sets the agencyid of this agency.
	 *
	 * @param agencyid the agencyid of this agency
	 */
	public void setAgencyid(long agencyid);

	/**
	 * Returns the name of this agency.
	 *
	 * @return the name of this agency
	 */
	public String getName();

	/**
	 * Returns the localized name of this agency in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this agency
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this agency in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this agency. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this agency in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this agency
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this agency in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this agency
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this agency.
	 *
	 * @return the locales and localized names of this agency
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this agency.
	 *
	 * @param name the name of this agency
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this agency in the language.
	 *
	 * @param name the localized name of this agency
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this agency in the language, and sets the default locale.
	 *
	 * @param name the localized name of this agency
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this agency from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this agency
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this agency from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this agency
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the level of this agency.
	 *
	 * @return the level of this agency
	 */
	@AutoEscape
	public String getLevel();

	/**
	 * Sets the level of this agency.
	 *
	 * @param level the level of this agency
	 */
	public void setLevel(String level);

	/**
	 * Returns the url of this agency.
	 *
	 * @return the url of this agency
	 */
	@AutoEscape
	public String getUrl();

	/**
	 * Sets the url of this agency.
	 *
	 * @param url the url of this agency
	 */
	public void setUrl(String url);

	/**
	 * Returns the childid of this agency.
	 *
	 * @return the childid of this agency
	 */
	public long getChildid();

	/**
	 * Sets the childid of this agency.
	 *
	 * @param childid the childid of this agency
	 */
	public void setChildid(long childid);

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
	public int compareTo(edison.challenge.service.builder.model.Agency agency);

	@Override
	public int hashCode();

	@Override
	public CacheModel<edison.challenge.service.builder.model.Agency> toCacheModel();

	@Override
	public edison.challenge.service.builder.model.Agency toEscapedModel();

	@Override
	public edison.challenge.service.builder.model.Agency toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}