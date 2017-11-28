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

package org.kisti.edison.science.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScienceAppManagerService}.
 *
 * @author EDISON
 * @see ScienceAppManagerService
 * @generated
 */
public class ScienceAppManagerServiceWrapper implements ScienceAppManagerService,
	ServiceWrapper<ScienceAppManagerService> {
	public ScienceAppManagerServiceWrapper(
		ScienceAppManagerService scienceAppManagerService) {
		_scienceAppManagerService = scienceAppManagerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scienceAppManagerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scienceAppManagerService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scienceAppManagerService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScienceAppManagerService getWrappedScienceAppManagerService() {
		return _scienceAppManagerService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScienceAppManagerService(
		ScienceAppManagerService scienceAppManagerService) {
		_scienceAppManagerService = scienceAppManagerService;
	}

	@Override
	public ScienceAppManagerService getWrappedService() {
		return _scienceAppManagerService;
	}

	@Override
	public void setWrappedService(
		ScienceAppManagerService scienceAppManagerService) {
		_scienceAppManagerService = scienceAppManagerService;
	}

	private ScienceAppManagerService _scienceAppManagerService;
}