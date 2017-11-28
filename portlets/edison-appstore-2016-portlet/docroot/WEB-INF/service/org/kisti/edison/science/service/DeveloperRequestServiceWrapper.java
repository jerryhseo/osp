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
 * Provides a wrapper for {@link DeveloperRequestService}.
 *
 * @author EDISON
 * @see DeveloperRequestService
 * @generated
 */
public class DeveloperRequestServiceWrapper implements DeveloperRequestService,
	ServiceWrapper<DeveloperRequestService> {
	public DeveloperRequestServiceWrapper(
		DeveloperRequestService developerRequestService) {
		_developerRequestService = developerRequestService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _developerRequestService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_developerRequestService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _developerRequestService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DeveloperRequestService getWrappedDeveloperRequestService() {
		return _developerRequestService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDeveloperRequestService(
		DeveloperRequestService developerRequestService) {
		_developerRequestService = developerRequestService;
	}

	@Override
	public DeveloperRequestService getWrappedService() {
		return _developerRequestService;
	}

	@Override
	public void setWrappedService(
		DeveloperRequestService developerRequestService) {
		_developerRequestService = developerRequestService;
	}

	private DeveloperRequestService _developerRequestService;
}