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

import org.kisti.edison.science.model.PortTypeEditorLink;
import org.kisti.edison.science.service.PortTypeEditorLinkLocalServiceUtil;

/**
 * @author EDISON
 * @generated
 */
public abstract class PortTypeEditorLinkActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public PortTypeEditorLinkActionableDynamicQuery() throws SystemException {
		setBaseLocalService(PortTypeEditorLinkLocalServiceUtil.getService());
		setClass(PortTypeEditorLink.class);

		setClassLoader(org.kisti.edison.science.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("portTypeEditorLinkId");
	}
}