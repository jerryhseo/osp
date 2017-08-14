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

package org.kisti.edison.content.model;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import org.kisti.edison.content.service.persistence.GeneralContentPK;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the GeneralContent service. Represents a row in the &quot;EDMED_GeneralContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.content.model.impl.GeneralContentImpl}.
 * </p>
 *
 * @author EDISON
 * @see GeneralContent
 * @see org.kisti.edison.content.model.impl.GeneralContentImpl
 * @see org.kisti.edison.content.model.impl.GeneralContentModelImpl
 * @generated
 */
public interface GeneralContentModel extends BaseModel<GeneralContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a general content model instance should use the {@link GeneralContent} interface instead.
	 */

	/**
	 * Returns the primary key of this general content.
	 *
	 * @return the primary key of this general content
	 */
	public GeneralContentPK getPrimaryKey();

	/**
	 * Sets the primary key of this general content.
	 *
	 * @param primaryKey the primary key of this general content
	 */
	public void setPrimaryKey(GeneralContentPK primaryKey);

	/**
	 * Returns the content seq of this general content.
	 *
	 * @return the content seq of this general content
	 */
	public long getContentSeq();

	/**
	 * Sets the content seq of this general content.
	 *
	 * @param contentSeq the content seq of this general content
	 */
	public void setContentSeq(long contentSeq);

	/**
	 * Returns the group ID of this general content.
	 *
	 * @return the group ID of this general content
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this general content.
	 *
	 * @param groupId the group ID of this general content
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the content div of this general content.
	 *
	 * @return the content div of this general content
	 */
	public long getContentDiv();

	/**
	 * Sets the content div of this general content.
	 *
	 * @param contentDiv the content div of this general content
	 */
	public void setContentDiv(long contentDiv);

	/**
	 * Returns the title of this general content.
	 *
	 * @return the title of this general content
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this general content in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this general content
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this general content in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this general content. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this general content in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this general content
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this general content in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this general content
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this general content.
	 *
	 * @return the locales and localized titles of this general content
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this general content.
	 *
	 * @param title the title of this general content
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this general content in the language.
	 *
	 * @param title the localized title of this general content
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this general content in the language, and sets the default locale.
	 *
	 * @param title the localized title of this general content
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this general content from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this general content
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this general content from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this general content
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the download cnt of this general content.
	 *
	 * @return the download cnt of this general content
	 */
	public long getDownloadCnt();

	/**
	 * Sets the download cnt of this general content.
	 *
	 * @param downloadCnt the download cnt of this general content
	 */
	public void setDownloadCnt(long downloadCnt);

	/**
	 * Returns the service language of this general content.
	 *
	 * @return the service language of this general content
	 */
	@AutoEscape
	public String getServiceLanguage();

	/**
	 * Sets the service language of this general content.
	 *
	 * @param serviceLanguage the service language of this general content
	 */
	public void setServiceLanguage(String serviceLanguage);

	/**
	 * Returns the project yn of this general content.
	 *
	 * @return the project yn of this general content
	 */
	@AutoEscape
	public String getProjectYn();

	/**
	 * Sets the project yn of this general content.
	 *
	 * @param projectYn the project yn of this general content
	 */
	public void setProjectYn(String projectYn);

	/**
	 * Returns the project ID of this general content.
	 *
	 * @return the project ID of this general content
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this general content.
	 *
	 * @param projectId the project ID of this general content
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the insert ID of this general content.
	 *
	 * @return the insert ID of this general content
	 */
	public long getInsertId();

	/**
	 * Sets the insert ID of this general content.
	 *
	 * @param insertId the insert ID of this general content
	 */
	public void setInsertId(long insertId);

	/**
	 * Returns the insert date of this general content.
	 *
	 * @return the insert date of this general content
	 */
	public Date getInsertDate();

	/**
	 * Sets the insert date of this general content.
	 *
	 * @param insertDate the insert date of this general content
	 */
	public void setInsertDate(Date insertDate);

	/**
	 * Returns the update ID of this general content.
	 *
	 * @return the update ID of this general content
	 */
	public long getUpdateId();

	/**
	 * Sets the update ID of this general content.
	 *
	 * @param updateId the update ID of this general content
	 */
	public void setUpdateId(long updateId);

	/**
	 * Returns the update date of this general content.
	 *
	 * @return the update date of this general content
	 */
	public Date getUpdateDate();

	/**
	 * Sets the update date of this general content.
	 *
	 * @param updateDate the update date of this general content
	 */
	public void setUpdateDate(Date updateDate);

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
		org.kisti.edison.content.model.GeneralContent generalContent);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.content.model.GeneralContent> toCacheModel();

	@Override
	public org.kisti.edison.content.model.GeneralContent toEscapedModel();

	@Override
	public org.kisti.edison.content.model.GeneralContent toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}