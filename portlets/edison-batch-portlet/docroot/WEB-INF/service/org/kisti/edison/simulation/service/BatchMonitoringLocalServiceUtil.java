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

package org.kisti.edison.simulation.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BatchMonitoring. This utility wraps
 * {@link org.kisti.edison.simulation.service.impl.BatchMonitoringLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author edison
 * @see BatchMonitoringLocalService
 * @see org.kisti.edison.simulation.service.base.BatchMonitoringLocalServiceBaseImpl
 * @see org.kisti.edison.simulation.service.impl.BatchMonitoringLocalServiceImpl
 * @generated
 */
public class BatchMonitoringLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.simulation.service.impl.BatchMonitoringLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the batch monitoring to the database. Also notifies the appropriate model listeners.
	*
	* @param batchMonitoring the batch monitoring
	* @return the batch monitoring that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.simulation.model.BatchMonitoring addBatchMonitoring(
		org.kisti.edison.simulation.model.BatchMonitoring batchMonitoring)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBatchMonitoring(batchMonitoring);
	}

	/**
	* Creates a new batch monitoring with the primary key. Does not add the batch monitoring to the database.
	*
	* @param batSeqNo the primary key for the new batch monitoring
	* @return the new batch monitoring
	*/
	public static org.kisti.edison.simulation.model.BatchMonitoring createBatchMonitoring(
		long batSeqNo) {
		return getService().createBatchMonitoring(batSeqNo);
	}

	/**
	* Deletes the batch monitoring with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param batSeqNo the primary key of the batch monitoring
	* @return the batch monitoring that was removed
	* @throws PortalException if a batch monitoring with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.simulation.model.BatchMonitoring deleteBatchMonitoring(
		long batSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBatchMonitoring(batSeqNo);
	}

	/**
	* Deletes the batch monitoring from the database. Also notifies the appropriate model listeners.
	*
	* @param batchMonitoring the batch monitoring
	* @return the batch monitoring that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.simulation.model.BatchMonitoring deleteBatchMonitoring(
		org.kisti.edison.simulation.model.BatchMonitoring batchMonitoring)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBatchMonitoring(batchMonitoring);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.simulation.model.impl.BatchMonitoringModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.simulation.model.impl.BatchMonitoringModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.kisti.edison.simulation.model.BatchMonitoring fetchBatchMonitoring(
		long batSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBatchMonitoring(batSeqNo);
	}

	/**
	* Returns the batch monitoring with the primary key.
	*
	* @param batSeqNo the primary key of the batch monitoring
	* @return the batch monitoring
	* @throws PortalException if a batch monitoring with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.simulation.model.BatchMonitoring getBatchMonitoring(
		long batSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBatchMonitoring(batSeqNo);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the batch monitorings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.simulation.model.impl.BatchMonitoringModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of batch monitorings
	* @param end the upper bound of the range of batch monitorings (not inclusive)
	* @return the range of batch monitorings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.simulation.model.BatchMonitoring> getBatchMonitorings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBatchMonitorings(start, end);
	}

	/**
	* Returns the number of batch monitorings.
	*
	* @return the number of batch monitorings
	* @throws SystemException if a system exception occurred
	*/
	public static int getBatchMonitoringsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBatchMonitoringsCount();
	}

	/**
	* Updates the batch monitoring in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param batchMonitoring the batch monitoring
	* @return the batch monitoring that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.simulation.model.BatchMonitoring updateBatchMonitoring(
		org.kisti.edison.simulation.model.BatchMonitoring batchMonitoring)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBatchMonitoring(batchMonitoring);
	}

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

	/**
	* 獄쏄퀣��野껉퀗��筌롫뗄苑�쭪占�    *
	*
	* @param exeDate - 獄쏄퀣��占썬끋六�占쎌뮄而�     * @param startDt -占쎌뮇��占쎌쥙彛�     * @param endDt - �ル굝利�占쎌쥙彛�     * @param batchSuccess - 獄쏄퀣��占쎄퉫��占싼됵옙
	* @return
	*/
	public static java.lang.String getBatchResultMassege(
		java.util.Date exeDate, java.lang.String startDt,
		java.lang.String endDt, boolean batchSuccess) {
		return getService()
				   .getBatchResultMassege(exeDate, startDt, endDt, batchSuccess);
	}

	/**
	* 獄쏄퀣��占썬끋六�占쎈���占쏙옙��     *
	* @param batDiv - 獄쏄퀣���브쑬履�     * @param manualYN - 占쎌꼶猷욑옙�쎈뻬 占싼됵옙
	* @param status - 占썬끋六�占쎄낱源�(SUCCESS, FAIL)
	* @param message - 占썬끋六�占쎈베��     * @param insertId - 獄쏄퀣�귨옙�쎈뻬 占쎄쑴�좑옙占�占썬끉占썰펺��쑎嚥∽옙占썬끋六억옙�뺣뮉 占쎄쑴�좑옙占쏙옙�곸벉)
	* @param exeDate - 占썬끋六�占쎌뮄而�     */
	public static org.kisti.edison.simulation.model.BatchMonitoring insertCustomBatchMonitoring(
		java.lang.String batDiv, java.lang.String manualYN,
		java.lang.String status, java.lang.String message,
		java.lang.Long insertId, java.util.Date exeDate)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return getService()
				   .insertCustomBatchMonitoring(batDiv, manualYN, status,
			message, insertId, exeDate);
	}

	/**
	* 獄쏄퀣��占썬끋六�占쎈����귐딅뮞占쏙옙     *
	*
	* @param begin
	* @param end
	* @return 占썬끋六�占쎈���     */
	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getCustomBatchMonitoringList(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService().getCustomBatchMonitoringList(begin, end);
	}

	/**
	* 獄쏄퀣��占썬끋六�占쎈���燁삳똻�ワ옙占�    *
	*
	* @return 占썬끋六�占쎈���燁삳똻�ワ옙占�     */
	public static int getCustomBatchMonitoringCount()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService().getCustomBatchMonitoringCount();
	}

	public static void clearService() {
		_service = null;
	}

	public static BatchMonitoringLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BatchMonitoringLocalService.class.getName());

			if (invokableLocalService instanceof BatchMonitoringLocalService) {
				_service = (BatchMonitoringLocalService)invokableLocalService;
			}
			else {
				_service = new BatchMonitoringLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BatchMonitoringLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BatchMonitoringLocalService service) {
	}

	private static BatchMonitoringLocalService _service;
}