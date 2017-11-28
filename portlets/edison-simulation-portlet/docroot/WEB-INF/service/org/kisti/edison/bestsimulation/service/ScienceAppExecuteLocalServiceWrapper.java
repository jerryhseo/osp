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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ScienceAppExecuteLocalService}.
 *
 * @author EDISON
 * @see ScienceAppExecuteLocalService
 * @generated
 */
public class ScienceAppExecuteLocalServiceWrapper
	implements ScienceAppExecuteLocalService,
		ServiceWrapper<ScienceAppExecuteLocalService> {
	public ScienceAppExecuteLocalServiceWrapper(
		ScienceAppExecuteLocalService scienceAppExecuteLocalService) {
		_scienceAppExecuteLocalService = scienceAppExecuteLocalService;
	}

	/**
	* Adds the science app execute to the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppExecute the science app execute
	* @return the science app execute that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.ScienceAppExecute addScienceAppExecute(
		org.kisti.edison.bestsimulation.model.ScienceAppExecute scienceAppExecute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.addScienceAppExecute(scienceAppExecute);
	}

	/**
	* Creates a new science app execute with the primary key. Does not add the science app execute to the database.
	*
	* @param scienceAppExecutePK the primary key for the new science app execute
	* @return the new science app execute
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.ScienceAppExecute createScienceAppExecute(
		org.kisti.edison.bestsimulation.service.persistence.ScienceAppExecutePK scienceAppExecutePK) {
		return _scienceAppExecuteLocalService.createScienceAppExecute(scienceAppExecutePK);
	}

	/**
	* Deletes the science app execute with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppExecutePK the primary key of the science app execute
	* @return the science app execute that was removed
	* @throws PortalException if a science app execute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.ScienceAppExecute deleteScienceAppExecute(
		org.kisti.edison.bestsimulation.service.persistence.ScienceAppExecutePK scienceAppExecutePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.deleteScienceAppExecute(scienceAppExecutePK);
	}

	/**
	* Deletes the science app execute from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppExecute the science app execute
	* @return the science app execute that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.ScienceAppExecute deleteScienceAppExecute(
		org.kisti.edison.bestsimulation.model.ScienceAppExecute scienceAppExecute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.deleteScienceAppExecute(scienceAppExecute);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scienceAppExecuteLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.ScienceAppExecuteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.ScienceAppExecuteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.bestsimulation.model.ScienceAppExecute fetchScienceAppExecute(
		org.kisti.edison.bestsimulation.service.persistence.ScienceAppExecutePK scienceAppExecutePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.fetchScienceAppExecute(scienceAppExecutePK);
	}

	/**
	* Returns the science app execute with the primary key.
	*
	* @param scienceAppExecutePK the primary key of the science app execute
	* @return the science app execute
	* @throws PortalException if a science app execute with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.ScienceAppExecute getScienceAppExecute(
		org.kisti.edison.bestsimulation.service.persistence.ScienceAppExecutePK scienceAppExecutePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.getScienceAppExecute(scienceAppExecutePK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the science app executes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.ScienceAppExecuteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app executes
	* @param end the upper bound of the range of science app executes (not inclusive)
	* @return the range of science app executes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.bestsimulation.model.ScienceAppExecute> getScienceAppExecutes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.getScienceAppExecutes(start, end);
	}

	/**
	* Returns the number of science app executes.
	*
	* @return the number of science app executes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getScienceAppExecutesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.getScienceAppExecutesCount();
	}

	/**
	* Updates the science app execute in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scienceAppExecute the science app execute
	* @return the science app execute that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.ScienceAppExecute updateScienceAppExecute(
		org.kisti.edison.bestsimulation.model.ScienceAppExecute scienceAppExecute)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.updateScienceAppExecute(scienceAppExecute);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scienceAppExecuteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scienceAppExecuteLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scienceAppExecuteLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<java.lang.Long> getSiteCategoryIdList(
		long globalGroupId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppExecuteLocalService.getSiteCategoryIdList(globalGroupId,
			groupId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsSwExeTableOrganigation(
		long companyGroupId, long groupId, java.util.Locale locale,
		long columnId, java.lang.String startDt, java.lang.String endDt,
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> scienceAppList,
		boolean categorySearch)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _scienceAppExecuteLocalService.getStatisticsSwExeTableOrganigation(companyGroupId,
			groupId, locale, columnId, startDt, endDt, scienceAppList,
			categorySearch);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getStatisticsSwExeBarChartDate(
		long companyGroupId, long groupId, long columnId,
		java.lang.String startDt, java.lang.String endDt,
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> scienceAppList,
		boolean categorySearch)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _scienceAppExecuteLocalService.getStatisticsSwExeBarChartDate(companyGroupId,
			groupId, columnId, startDt, endDt, scienceAppList, categorySearch);
	}

	@Override
	public int insertCustomScienceAppExecute(java.lang.String startDt,
		java.lang.String endDt)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return _scienceAppExecuteLocalService.insertCustomScienceAppExecute(startDt,
			endDt);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScienceAppExecuteLocalService getWrappedScienceAppExecuteLocalService() {
		return _scienceAppExecuteLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScienceAppExecuteLocalService(
		ScienceAppExecuteLocalService scienceAppExecuteLocalService) {
		_scienceAppExecuteLocalService = scienceAppExecuteLocalService;
	}

	@Override
	public ScienceAppExecuteLocalService getWrappedService() {
		return _scienceAppExecuteLocalService;
	}

	@Override
	public void setWrappedService(
		ScienceAppExecuteLocalService scienceAppExecuteLocalService) {
		_scienceAppExecuteLocalService = scienceAppExecuteLocalService;
	}

	private ScienceAppExecuteLocalService _scienceAppExecuteLocalService;
}