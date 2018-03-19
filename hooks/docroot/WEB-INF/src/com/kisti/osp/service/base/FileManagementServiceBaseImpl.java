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

package com.kisti.osp.service.base;

import com.kisti.osp.model.FileManagement;
import com.kisti.osp.service.FileManagementService;
import com.kisti.osp.service.persistence.FileManagementPersistence;
import com.kisti.osp.service.persistence.SystemPropertiesPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the file management remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.kisti.osp.service.impl.FileManagementServiceImpl}.
 * </p>
 *
 * @author Jerry h. Seo
 * @see com.kisti.osp.service.impl.FileManagementServiceImpl
 * @see com.kisti.osp.service.FileManagementServiceUtil
 * @generated
 */
public abstract class FileManagementServiceBaseImpl extends BaseServiceImpl
	implements FileManagementService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.kisti.osp.service.FileManagementServiceUtil} to access the file management remote service.
	 */

	/**
	 * Returns the file management local service.
	 *
	 * @return the file management local service
	 */
	public com.kisti.osp.service.FileManagementLocalService getFileManagementLocalService() {
		return fileManagementLocalService;
	}

	/**
	 * Sets the file management local service.
	 *
	 * @param fileManagementLocalService the file management local service
	 */
	public void setFileManagementLocalService(
		com.kisti.osp.service.FileManagementLocalService fileManagementLocalService) {
		this.fileManagementLocalService = fileManagementLocalService;
	}

	/**
	 * Returns the file management remote service.
	 *
	 * @return the file management remote service
	 */
	public com.kisti.osp.service.FileManagementService getFileManagementService() {
		return fileManagementService;
	}

	/**
	 * Sets the file management remote service.
	 *
	 * @param fileManagementService the file management remote service
	 */
	public void setFileManagementService(
		com.kisti.osp.service.FileManagementService fileManagementService) {
		this.fileManagementService = fileManagementService;
	}

	/**
	 * Returns the file management persistence.
	 *
	 * @return the file management persistence
	 */
	public FileManagementPersistence getFileManagementPersistence() {
		return fileManagementPersistence;
	}

	/**
	 * Sets the file management persistence.
	 *
	 * @param fileManagementPersistence the file management persistence
	 */
	public void setFileManagementPersistence(
		FileManagementPersistence fileManagementPersistence) {
		this.fileManagementPersistence = fileManagementPersistence;
	}

	/**
	 * Returns the system properties local service.
	 *
	 * @return the system properties local service
	 */
	public com.kisti.osp.service.SystemPropertiesLocalService getSystemPropertiesLocalService() {
		return systemPropertiesLocalService;
	}

	/**
	 * Sets the system properties local service.
	 *
	 * @param systemPropertiesLocalService the system properties local service
	 */
	public void setSystemPropertiesLocalService(
		com.kisti.osp.service.SystemPropertiesLocalService systemPropertiesLocalService) {
		this.systemPropertiesLocalService = systemPropertiesLocalService;
	}

	/**
	 * Returns the system properties remote service.
	 *
	 * @return the system properties remote service
	 */
	public com.kisti.osp.service.SystemPropertiesService getSystemPropertiesService() {
		return systemPropertiesService;
	}

	/**
	 * Sets the system properties remote service.
	 *
	 * @param systemPropertiesService the system properties remote service
	 */
	public void setSystemPropertiesService(
		com.kisti.osp.service.SystemPropertiesService systemPropertiesService) {
		this.systemPropertiesService = systemPropertiesService;
	}

	/**
	 * Returns the system properties persistence.
	 *
	 * @return the system properties persistence
	 */
	public SystemPropertiesPersistence getSystemPropertiesPersistence() {
		return systemPropertiesPersistence;
	}

	/**
	 * Sets the system properties persistence.
	 *
	 * @param systemPropertiesPersistence the system properties persistence
	 */
	public void setSystemPropertiesPersistence(
		SystemPropertiesPersistence systemPropertiesPersistence) {
		this.systemPropertiesPersistence = systemPropertiesPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return FileManagement.class;
	}

	protected String getModelClassName() {
		return FileManagement.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = fileManagementPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.kisti.osp.service.FileManagementLocalService.class)
	protected com.kisti.osp.service.FileManagementLocalService fileManagementLocalService;
	@BeanReference(type = com.kisti.osp.service.FileManagementService.class)
	protected com.kisti.osp.service.FileManagementService fileManagementService;
	@BeanReference(type = FileManagementPersistence.class)
	protected FileManagementPersistence fileManagementPersistence;
	@BeanReference(type = com.kisti.osp.service.SystemPropertiesLocalService.class)
	protected com.kisti.osp.service.SystemPropertiesLocalService systemPropertiesLocalService;
	@BeanReference(type = com.kisti.osp.service.SystemPropertiesService.class)
	protected com.kisti.osp.service.SystemPropertiesService systemPropertiesService;
	@BeanReference(type = SystemPropertiesPersistence.class)
	protected SystemPropertiesPersistence systemPropertiesPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private FileManagementServiceClpInvoker _clpInvoker = new FileManagementServiceClpInvoker();
}