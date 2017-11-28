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

package org.kisti.edison.bestsimulation.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SimulationJob. This utility wraps
 * {@link org.kisti.edison.bestsimulation.service.impl.SimulationJobServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author EDISON
 * @see SimulationJobService
 * @see org.kisti.edison.bestsimulation.service.base.SimulationJobServiceBaseImpl
 * @see org.kisti.edison.bestsimulation.service.impl.SimulationJobServiceImpl
 * @generated
 */
public class SimulationJobServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.bestsimulation.service.impl.SimulationJobServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static boolean updateSimulationJob(long gid,
		java.lang.String simulationUuid, long jobSeqNo,
		java.lang.String jobUuid, java.lang.String jobStatus,
		java.lang.String jobStartDt, java.lang.String jobEndDt) {
		return getService()
				   .updateSimulationJob(gid, simulationUuid, jobSeqNo, jobUuid,
			jobStatus, jobStartDt, jobEndDt);
	}

	public static void clearService() {
		_service = null;
	}

	public static SimulationJobService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SimulationJobService.class.getName());

			if (invokableService instanceof SimulationJobService) {
				_service = (SimulationJobService)invokableService;
			}
			else {
				_service = new SimulationJobServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SimulationJobServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SimulationJobService service) {
	}

	private static SimulationJobService _service;
}