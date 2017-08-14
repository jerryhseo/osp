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

package com.kisti.osp.icecap.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DataEntryProvenance. This utility wraps
 * {@link com.kisti.osp.icecap.service.impl.DataEntryProvenanceLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Young-K. Suh and Jerry H. Seo
 * @see DataEntryProvenanceLocalService
 * @see com.kisti.osp.icecap.service.base.DataEntryProvenanceLocalServiceBaseImpl
 * @see com.kisti.osp.icecap.service.impl.DataEntryProvenanceLocalServiceImpl
 * @generated
 */
public class DataEntryProvenanceLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kisti.osp.icecap.service.impl.DataEntryProvenanceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the data entry provenance to the database. Also notifies the appropriate model listeners.
	*
	* @param dataEntryProvenance the data entry provenance
	* @return the data entry provenance that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.osp.icecap.model.DataEntryProvenance addDataEntryProvenance(
		com.kisti.osp.icecap.model.DataEntryProvenance dataEntryProvenance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDataEntryProvenance(dataEntryProvenance);
	}

	/**
	* Creates a new data entry provenance with the primary key. Does not add the data entry provenance to the database.
	*
	* @param entryId the primary key for the new data entry provenance
	* @return the new data entry provenance
	*/
	public static com.kisti.osp.icecap.model.DataEntryProvenance createDataEntryProvenance(
		long entryId) {
		return getService().createDataEntryProvenance(entryId);
	}

	/**
	* Deletes the data entry provenance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param entryId the primary key of the data entry provenance
	* @return the data entry provenance that was removed
	* @throws PortalException if a data entry provenance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.osp.icecap.model.DataEntryProvenance deleteDataEntryProvenance(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDataEntryProvenance(entryId);
	}

	/**
	* Deletes the data entry provenance from the database. Also notifies the appropriate model listeners.
	*
	* @param dataEntryProvenance the data entry provenance
	* @return the data entry provenance that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.osp.icecap.model.DataEntryProvenance deleteDataEntryProvenance(
		com.kisti.osp.icecap.model.DataEntryProvenance dataEntryProvenance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDataEntryProvenance(dataEntryProvenance);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataEntryProvenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataEntryProvenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.kisti.osp.icecap.model.DataEntryProvenance fetchDataEntryProvenance(
		long entryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDataEntryProvenance(entryId);
	}

	/**
	* Returns the data entry provenance with the primary key.
	*
	* @param entryId the primary key of the data entry provenance
	* @return the data entry provenance
	* @throws PortalException if a data entry provenance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.osp.icecap.model.DataEntryProvenance getDataEntryProvenance(
		long entryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDataEntryProvenance(entryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the data entry provenances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataEntryProvenanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of data entry provenances
	* @param end the upper bound of the range of data entry provenances (not inclusive)
	* @return the range of data entry provenances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.osp.icecap.model.DataEntryProvenance> getDataEntryProvenances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDataEntryProvenances(start, end);
	}

	/**
	* Returns the number of data entry provenances.
	*
	* @return the number of data entry provenances
	* @throws SystemException if a system exception occurred
	*/
	public static int getDataEntryProvenancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDataEntryProvenancesCount();
	}

	/**
	* Updates the data entry provenance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dataEntryProvenance the data entry provenance
	* @return the data entry provenance that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.osp.icecap.model.DataEntryProvenance updateDataEntryProvenance(
		com.kisti.osp.icecap.model.DataEntryProvenance dataEntryProvenance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDataEntryProvenance(dataEntryProvenance);
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

	public static void clearService() {
		_service = null;
	}

	public static DataEntryProvenanceLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DataEntryProvenanceLocalService.class.getName());

			if (invokableLocalService instanceof DataEntryProvenanceLocalService) {
				_service = (DataEntryProvenanceLocalService)invokableLocalService;
			}
			else {
				_service = new DataEntryProvenanceLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DataEntryProvenanceLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DataEntryProvenanceLocalService service) {
	}

	private static DataEntryProvenanceLocalService _service;
}