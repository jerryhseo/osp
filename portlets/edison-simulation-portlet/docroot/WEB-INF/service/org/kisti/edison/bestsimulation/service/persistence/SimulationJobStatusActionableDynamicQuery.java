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

package org.kisti.edison.bestsimulation.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.bestsimulation.model.SimulationJobStatus;
import org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalServiceUtil;

/**
 * @author EDISON
 * @generated
 */
public abstract class SimulationJobStatusActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public SimulationJobStatusActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(SimulationJobStatusLocalServiceUtil.getService());
		setClass(SimulationJobStatus.class);

		setClassLoader(org.kisti.edison.bestsimulation.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.statusSeq");

		setGroupIdPropertyName("primaryKey.groupId");
	}
}