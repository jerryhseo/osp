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

package org.kisti.edison.science.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;

/**
 * @author EDISON
 * @generated
 */
public abstract class ScienceAppActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ScienceAppActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ScienceAppLocalServiceUtil.getService());
		setClass(ScienceApp.class);

		setClassLoader(org.kisti.edison.science.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("scienceAppId");
	}
}