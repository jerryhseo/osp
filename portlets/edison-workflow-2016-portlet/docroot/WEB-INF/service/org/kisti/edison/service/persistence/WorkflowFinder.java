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

package org.kisti.edison.service.persistence;

/**
 * @author EDISON
 */
public interface WorkflowFinder {
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveWorkflows(
		java.util.Map<java.lang.String, java.lang.Object> searchParam,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long countWorkflowSimulationJobs(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveWorkflowSimulationJobs(
		java.util.Map<java.lang.String, java.lang.Object> searchParam,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getWorkflowMonitoringList(
		java.util.Map<java.lang.String, java.lang.Object> searchParams)
		throws com.liferay.portal.kernel.exception.SystemException;
}