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

package com.kisti.osp.icecap.service.persistence;

import com.kisti.osp.icecap.model.DataTypeAnalyzer;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the data type analyzer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Young-K. Suh and Jerry H. Seo
 * @see DataTypeAnalyzerPersistenceImpl
 * @see DataTypeAnalyzerUtil
 * @generated
 */
public interface DataTypeAnalyzerPersistence extends BasePersistence<DataTypeAnalyzer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataTypeAnalyzerUtil} to access the data type analyzer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the data type analyzers where analyzerId = &#63;.
	*
	* @param analyzerId the analyzer ID
	* @return the matching data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> findByAnalyzer(
		long analyzerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the data type analyzers where analyzerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataTypeAnalyzerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyzerId the analyzer ID
	* @param start the lower bound of the range of data type analyzers
	* @param end the upper bound of the range of data type analyzers (not inclusive)
	* @return the range of matching data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> findByAnalyzer(
		long analyzerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the data type analyzers where analyzerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataTypeAnalyzerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param analyzerId the analyzer ID
	* @param start the lower bound of the range of data type analyzers
	* @param end the upper bound of the range of data type analyzers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> findByAnalyzer(
		long analyzerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first data type analyzer in the ordered set where analyzerId = &#63;.
	*
	* @param analyzerId the analyzer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data type analyzer
	* @throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException if a matching data type analyzer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer findByAnalyzer_First(
		long analyzerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first data type analyzer in the ordered set where analyzerId = &#63;.
	*
	* @param analyzerId the analyzer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data type analyzer, or <code>null</code> if a matching data type analyzer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer fetchByAnalyzer_First(
		long analyzerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last data type analyzer in the ordered set where analyzerId = &#63;.
	*
	* @param analyzerId the analyzer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data type analyzer
	* @throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException if a matching data type analyzer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer findByAnalyzer_Last(
		long analyzerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last data type analyzer in the ordered set where analyzerId = &#63;.
	*
	* @param analyzerId the analyzer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data type analyzer, or <code>null</code> if a matching data type analyzer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer fetchByAnalyzer_Last(
		long analyzerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data type analyzers before and after the current data type analyzer in the ordered set where analyzerId = &#63;.
	*
	* @param dataTypeAnalyzerPK the primary key of the current data type analyzer
	* @param analyzerId the analyzer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next data type analyzer
	* @throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException if a data type analyzer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer[] findByAnalyzer_PrevAndNext(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK,
		long analyzerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the data type analyzers where analyzerId = &#63; from the database.
	*
	* @param analyzerId the analyzer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAnalyzer(long analyzerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data type analyzers where analyzerId = &#63;.
	*
	* @param analyzerId the analyzer ID
	* @return the number of matching data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public int countByAnalyzer(long analyzerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the data type analyzers where typeId = &#63;.
	*
	* @param typeId the type ID
	* @return the matching data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> findByTypeID(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the data type analyzers where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataTypeAnalyzerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeId the type ID
	* @param start the lower bound of the range of data type analyzers
	* @param end the upper bound of the range of data type analyzers (not inclusive)
	* @return the range of matching data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> findByTypeID(
		long typeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the data type analyzers where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataTypeAnalyzerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeId the type ID
	* @param start the lower bound of the range of data type analyzers
	* @param end the upper bound of the range of data type analyzers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> findByTypeID(
		long typeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first data type analyzer in the ordered set where typeId = &#63;.
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data type analyzer
	* @throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException if a matching data type analyzer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer findByTypeID_First(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first data type analyzer in the ordered set where typeId = &#63;.
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching data type analyzer, or <code>null</code> if a matching data type analyzer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer fetchByTypeID_First(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last data type analyzer in the ordered set where typeId = &#63;.
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data type analyzer
	* @throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException if a matching data type analyzer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer findByTypeID_Last(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last data type analyzer in the ordered set where typeId = &#63;.
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching data type analyzer, or <code>null</code> if a matching data type analyzer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer fetchByTypeID_Last(
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data type analyzers before and after the current data type analyzer in the ordered set where typeId = &#63;.
	*
	* @param dataTypeAnalyzerPK the primary key of the current data type analyzer
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next data type analyzer
	* @throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException if a data type analyzer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer[] findByTypeID_PrevAndNext(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK,
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the data type analyzers where typeId = &#63; from the database.
	*
	* @param typeId the type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeID(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data type analyzers where typeId = &#63;.
	*
	* @param typeId the type ID
	* @return the number of matching data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeID(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the data type analyzer in the entity cache if it is enabled.
	*
	* @param dataTypeAnalyzer the data type analyzer
	*/
	public void cacheResult(
		com.kisti.osp.icecap.model.DataTypeAnalyzer dataTypeAnalyzer);

	/**
	* Caches the data type analyzers in the entity cache if it is enabled.
	*
	* @param dataTypeAnalyzers the data type analyzers
	*/
	public void cacheResult(
		java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> dataTypeAnalyzers);

	/**
	* Creates a new data type analyzer with the primary key. Does not add the data type analyzer to the database.
	*
	* @param dataTypeAnalyzerPK the primary key for the new data type analyzer
	* @return the new data type analyzer
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer create(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK);

	/**
	* Removes the data type analyzer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dataTypeAnalyzerPK the primary key of the data type analyzer
	* @return the data type analyzer that was removed
	* @throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException if a data type analyzer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer remove(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kisti.osp.icecap.model.DataTypeAnalyzer updateImpl(
		com.kisti.osp.icecap.model.DataTypeAnalyzer dataTypeAnalyzer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data type analyzer with the primary key or throws a {@link com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException} if it could not be found.
	*
	* @param dataTypeAnalyzerPK the primary key of the data type analyzer
	* @return the data type analyzer
	* @throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException if a data type analyzer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer findByPrimaryKey(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK)
		throws com.kisti.osp.icecap.NoSuchDataTypeAnalyzerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the data type analyzer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dataTypeAnalyzerPK the primary key of the data type analyzer
	* @return the data type analyzer, or <code>null</code> if a data type analyzer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.osp.icecap.model.DataTypeAnalyzer fetchByPrimaryKey(
		com.kisti.osp.icecap.service.persistence.DataTypeAnalyzerPK dataTypeAnalyzerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the data type analyzers.
	*
	* @return the data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the data type analyzers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.osp.icecap.model.impl.DataTypeAnalyzerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of data type analyzers
	* @param end the upper bound of the range of data type analyzers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.osp.icecap.model.DataTypeAnalyzer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the data type analyzers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of data type analyzers.
	*
	* @return the number of data type analyzers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}