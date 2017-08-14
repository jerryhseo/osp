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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for DataTypeAnalyzer. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Young-K. Suh and Jerry H. Seo
 * @see DataTypeAnalyzerLocalServiceUtil
 * @see com.kisti.osp.icecap.service.base.DataTypeAnalyzerLocalServiceBaseImpl
 * @see com.kisti.osp.icecap.service.impl.DataTypeAnalyzerLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DataTypeAnalyzerLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataTypeAnalyzerLocalServiceUtil} to access the data type analyzer local service. Add custom service methods to {@link com.kisti.osp.icecap.service.impl.DataTypeAnalyzerLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the data type analyzer to the database. Also notifies the appropriate model listeners.
	*
	* @param dataTypeAnalyzer the data type analyzer
	* @return the data type analyzer that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.kisti.osp.icecap.model.DataTypeAnalyzer addDataTypeAnalyzer(
		com.kisti.osp.icecap.model.DataTypeAnalyzer dataTypeAnalyzer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new data type analyzer with the primary key. Does not add the data type analyzer to the database.
	*
	* @param dataTypeAnalyzerPK the primary key for the new data type analyzer
	* @return the new data type analyzer
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer createDataTypeAnalyzer(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK);

	/**
	* Deletes the data type analyzer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dataTypeAnalyzerPK the primary key of the data type analyzer
	* @return the data type analyzer that was removed
	* @throws PortalException if a data type analyzer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.kisti.osp.icecap.model.DataTypeAnalyzer deleteDataTypeAnalyzer(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the data type analyzer from the database. Also notifies the appropriate model listeners.
	*
	* @param dataTypeAnalyzer the data type analyzer
	* @return the data type analyzer that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.kisti.osp.icecap.model.DataTypeAnalyzer deleteDataTypeAnalyzer(
		com.kisti.osp.icecap.model.DataTypeAnalyzer dataTypeAnalyzer)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataTypeAnalyzerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataTypeAnalyzerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.kisti.osp.icecap.model.DataTypeAnalyzer fetchDataTypeAnalyzer(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data type analyzer with the primary key.
	*
	* @param dataTypeAnalyzerPK the primary key of the data type analyzer
	* @return the data type analyzer
	* @throws PortalException if a data type analyzer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.kisti.osp.icecap.model.DataTypeAnalyzer getDataTypeAnalyzer(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the data type analyzers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataTypeAnalyzerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of data type analyzers
	* @param end the upper bound of the range of data type analyzers (not inclusive)
	* @return the range of data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> getDataTypeAnalyzers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data type analyzers.
	*
	* @return the number of data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataTypeAnalyzersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the data type analyzer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dataTypeAnalyzer the data type analyzer
	* @return the data type analyzer that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.kisti.osp.icecap.model.DataTypeAnalyzer updateDataTypeAnalyzer(
		com.kisti.osp.icecap.model.DataTypeAnalyzer dataTypeAnalyzer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public boolean createDataTypeAnalyzerObject(java.lang.Long dataTypeId,
		boolean isDefault, java.lang.Long dataTypeAnalyzerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Retrieve a matching DataTypeAnalyzer with typeId and servicePK
	*
	* @param typeId a given DataType typeId
	* @param servicePK analyzerId
	* @return A DataTypeAnalyzer object
	* @throws SystemException
	*/
	public java.util.Map<java.lang.String, java.lang.Object> retrieveDataTypeAnalyzerPK(
		long typeId, long servicePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Retrieve a list of DataTypeAnalyzer objects
	*
	* @param typeId typeid
	* @return a list of DataTypeAnalyzer objects
	* @throws SystemException
	*/
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveDataTypeAnalyzerList(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Remove a DataTypeAnalyzer object associated with a given typeId and a given servicePK
	*
	* @param typeId typeId
	* @param servicePK analyerId
	* @throws SystemException
	* @throws NoSuchDataTypeAnalyzerException
	*/
	public void removeDataTypeAnalyzerByPK(long typeId, long servicePK)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Remove DataTypeAnalyzer by typeId
	*
	* @param typeId typeId
	* @throws SystemException
	* @throws NoSuchDataTypeAnalyzerException
	*/
	public void removeDataTypeAnalyzerByTypeId(long typeId)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;
}