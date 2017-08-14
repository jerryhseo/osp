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

package com.kisti.osp.icecap.model;

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
 * The base model interface for the DataType service. Represents a row in the &quot;icecap_DataType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.kisti.osp.icecap.model.impl.DataTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.kisti.osp.icecap.model.impl.DataTypeImpl}.
 * </p>
 *
 * @author Young-K. Suh and Jerry H. Seo
 * @see DataType
 * @see com.kisti.osp.icecap.model.impl.DataTypeImpl
 * @see com.kisti.osp.icecap.model.impl.DataTypeModelImpl
 * @generated
 */
public interface DataTypeModel extends BaseModel<DataType>, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a data type model instance should use the {@link DataType} interface instead.
	 */

	/**
	 * Returns the primary key of this data type.
	 *
	 * @return the primary key of this data type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this data type.
	 *
	 * @param primaryKey the primary key of this data type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this data type.
	 *
	 * @return the uuid of this data type
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this data type.
	 *
	 * @param uuid the uuid of this data type
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the type ID of this data type.
	 *
	 * @return the type ID of this data type
	 */
	public long getTypeId();

	/**
	 * Sets the type ID of this data type.
	 *
	 * @param typeId the type ID of this data type
	 */
	public void setTypeId(long typeId);

	/**
	 * Returns the name of this data type.
	 *
	 * @return the name of this data type
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this data type.
	 *
	 * @param name the name of this data type
	 */
	public void setName(String name);

	/**
	 * Returns the version of this data type.
	 *
	 * @return the version of this data type
	 */
	@AutoEscape
	public String getVersion();

	/**
	 * Sets the version of this data type.
	 *
	 * @param version the version of this data type
	 */
	public void setVersion(String version);

	/**
	 * Returns the company ID of this data type.
	 *
	 * @return the company ID of this data type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this data type.
	 *
	 * @param companyId the company ID of this data type
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this data type.
	 *
	 * @return the user ID of this data type
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this data type.
	 *
	 * @param userId the user ID of this data type
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this data type.
	 *
	 * @return the user uuid of this data type
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this data type.
	 *
	 * @param userUuid the user uuid of this data type
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this data type.
	 *
	 * @return the create date of this data type
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this data type.
	 *
	 * @param createDate the create date of this data type
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this data type.
	 *
	 * @return the modified date of this data type
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this data type.
	 *
	 * @param modifiedDate the modified date of this data type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sample path of this data type.
	 *
	 * @return the sample path of this data type
	 */
	@AutoEscape
	public String getSamplePath();

	/**
	 * Sets the sample path of this data type.
	 *
	 * @param samplePath the sample path of this data type
	 */
	public void setSamplePath(String samplePath);

	/**
	 * Returns the status of this data type.
	 *
	 * @return the status of this data type
	 */
	public int getStatus();

	/**
	 * Sets the status of this data type.
	 *
	 * @param status the status of this data type
	 */
	public void setStatus(int status);

	/**
	 * Returns the description of this data type.
	 *
	 * @return the description of this data type
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this data type
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this data type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this data type in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this data type
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this data type in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this data type
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this data type.
	 *
	 * @return the locales and localized descriptions of this data type
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this data type.
	 *
	 * @param description the description of this data type
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this data type in the language.
	 *
	 * @param description the localized description of this data type
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this data type in the language, and sets the default locale.
	 *
	 * @param description the localized description of this data type
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this data type from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this data type
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this data type from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this data type
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the group ID of this data type.
	 *
	 * @return the group ID of this data type
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this data type.
	 *
	 * @param groupId the group ID of this data type
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the is favorite of this data type.
	 *
	 * @return the is favorite of this data type
	 */
	public boolean getIsFavorite();

	/**
	 * Returns <code>true</code> if this data type is is favorite.
	 *
	 * @return <code>true</code> if this data type is is favorite; <code>false</code> otherwise
	 */
	public boolean isIsFavorite();

	/**
	 * Sets whether this data type is is favorite.
	 *
	 * @param isFavorite the is favorite of this data type
	 */
	public void setIsFavorite(boolean isFavorite);

	/**
	 * Returns the owner ID of this data type.
	 *
	 * @return the owner ID of this data type
	 */
	public long getOwnerId();

	/**
	 * Sets the owner ID of this data type.
	 *
	 * @param ownerId the owner ID of this data type
	 */
	public void setOwnerId(long ownerId);

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
	public int compareTo(com.kisti.osp.icecap.model.DataType dataType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.kisti.osp.icecap.model.DataType> toCacheModel();

	@Override
	public com.kisti.osp.icecap.model.DataType toEscapedModel();

	@Override
	public com.kisti.osp.icecap.model.DataType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}