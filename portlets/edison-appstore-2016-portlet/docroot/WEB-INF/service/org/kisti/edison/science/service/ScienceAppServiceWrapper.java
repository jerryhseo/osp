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

package org.kisti.edison.science.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScienceAppService}.
 *
 * @author EDISON
 * @see ScienceAppService
 * @generated
 */
public class ScienceAppServiceWrapper implements ScienceAppService,
	ServiceWrapper<ScienceAppService> {
	public ScienceAppServiceWrapper(ScienceAppService scienceAppService) {
		_scienceAppService = scienceAppService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scienceAppService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scienceAppService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scienceAppService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String retrieveApiAppList() throws java.lang.Exception {
		return _scienceAppService.retrieveApiAppList();
	}

	@Override
	public java.lang.String retrieveApiCategory() throws java.lang.Exception {
		return _scienceAppService.retrieveApiCategory();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScienceAppService getWrappedScienceAppService() {
		return _scienceAppService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScienceAppService(ScienceAppService scienceAppService) {
		_scienceAppService = scienceAppService;
	}

	@Override
	public ScienceAppService getWrappedService() {
		return _scienceAppService;
	}

	@Override
	public void setWrappedService(ScienceAppService scienceAppService) {
		_scienceAppService = scienceAppService;
	}

	private ScienceAppService _scienceAppService;
}