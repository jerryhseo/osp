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

package org.kisti.edison.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExecuteUserLocalService}.
 *
 * @author edison
 * @see ExecuteUserLocalService
 * @generated
 */
public class ExecuteUserLocalServiceWrapper implements ExecuteUserLocalService,
	ServiceWrapper<ExecuteUserLocalService> {
	public ExecuteUserLocalServiceWrapper(
		ExecuteUserLocalService executeUserLocalService) {
		_executeUserLocalService = executeUserLocalService;
	}

	/**
	* Adds the execute user to the database. Also notifies the appropriate model listeners.
	*
	* @param executeUser the execute user
	* @return the execute user that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.ExecuteUser addExecuteUser(
		org.kisti.edison.model.ExecuteUser executeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _executeUserLocalService.addExecuteUser(executeUser);
	}

	/**
	* Creates a new execute user with the primary key. Does not add the execute user to the database.
	*
	* @param createDate the primary key for the new execute user
	* @return the new execute user
	*/
	@Override
	public org.kisti.edison.model.ExecuteUser createExecuteUser(
		java.lang.String createDate) {
		return _executeUserLocalService.createExecuteUser(createDate);
	}

	/**
	* Deletes the execute user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param createDate the primary key of the execute user
	* @return the execute user that was removed
	* @throws PortalException if a execute user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.ExecuteUser deleteExecuteUser(
		java.lang.String createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _executeUserLocalService.deleteExecuteUser(createDate);
	}

	/**
	* Deletes the execute user from the database. Also notifies the appropriate model listeners.
	*
	* @param executeUser the execute user
	* @return the execute user that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.ExecuteUser deleteExecuteUser(
		org.kisti.edison.model.ExecuteUser executeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _executeUserLocalService.deleteExecuteUser(executeUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _executeUserLocalService.dynamicQuery();
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
		return _executeUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.ExecuteUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _executeUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.ExecuteUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _executeUserLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _executeUserLocalService.dynamicQueryCount(dynamicQuery);
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
		return _executeUserLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.model.ExecuteUser fetchExecuteUser(
		java.lang.String createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _executeUserLocalService.fetchExecuteUser(createDate);
	}

	/**
	* Returns the execute user with the primary key.
	*
	* @param createDate the primary key of the execute user
	* @return the execute user
	* @throws PortalException if a execute user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.ExecuteUser getExecuteUser(
		java.lang.String createDate)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _executeUserLocalService.getExecuteUser(createDate);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _executeUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the execute users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.ExecuteUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of execute users
	* @param end the upper bound of the range of execute users (not inclusive)
	* @return the range of execute users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.model.ExecuteUser> getExecuteUsers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _executeUserLocalService.getExecuteUsers(start, end);
	}

	/**
	* Returns the number of execute users.
	*
	* @return the number of execute users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getExecuteUsersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _executeUserLocalService.getExecuteUsersCount();
	}

	/**
	* Updates the execute user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param executeUser the execute user
	* @return the execute user that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.ExecuteUser updateExecuteUser(
		org.kisti.edison.model.ExecuteUser executeUser)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _executeUserLocalService.updateExecuteUser(executeUser);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _executeUserLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_executeUserLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _executeUserLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public boolean updateExecuteUserStatistics() {
		return _executeUserLocalService.updateExecuteUserStatistics();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ExecuteUserLocalService getWrappedExecuteUserLocalService() {
		return _executeUserLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedExecuteUserLocalService(
		ExecuteUserLocalService executeUserLocalService) {
		_executeUserLocalService = executeUserLocalService;
	}

	@Override
	public ExecuteUserLocalService getWrappedService() {
		return _executeUserLocalService;
	}

	@Override
	public void setWrappedService(
		ExecuteUserLocalService executeUserLocalService) {
		_executeUserLocalService = executeUserLocalService;
	}

	private ExecuteUserLocalService _executeUserLocalService;
}