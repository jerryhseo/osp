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

package edison.challenge.service.builder.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import edison.challenge.service.builder.model.Award;

/**
 * The persistence interface for the award service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kyj
 * @see AwardPersistenceImpl
 * @see AwardUtil
 * @generated
 */
public interface AwardPersistence extends BasePersistence<Award> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AwardUtil} to access the award persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the awards where childid = &#63;.
	*
	* @param childid the childid
	* @return the matching awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.Award> findBychildCollect(
		long childid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the awards where childid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param childid the childid
	* @param start the lower bound of the range of awards
	* @param end the upper bound of the range of awards (not inclusive)
	* @return the range of matching awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.Award> findBychildCollect(
		long childid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the awards where childid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param childid the childid
	* @param start the lower bound of the range of awards
	* @param end the upper bound of the range of awards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.Award> findBychildCollect(
		long childid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first award in the ordered set where childid = &#63;.
	*
	* @param childid the childid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching award
	* @throws edison.challenge.service.builder.NoSuchAwardException if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.Award findBychildCollect_First(
		long childid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchAwardException;

	/**
	* Returns the first award in the ordered set where childid = &#63;.
	*
	* @param childid the childid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching award, or <code>null</code> if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.Award fetchBychildCollect_First(
		long childid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last award in the ordered set where childid = &#63;.
	*
	* @param childid the childid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching award
	* @throws edison.challenge.service.builder.NoSuchAwardException if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.Award findBychildCollect_Last(
		long childid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchAwardException;

	/**
	* Returns the last award in the ordered set where childid = &#63;.
	*
	* @param childid the childid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching award, or <code>null</code> if a matching award could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.Award fetchBychildCollect_Last(
		long childid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the awards before and after the current award in the ordered set where childid = &#63;.
	*
	* @param awardid the primary key of the current award
	* @param childid the childid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next award
	* @throws edison.challenge.service.builder.NoSuchAwardException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.Award[] findBychildCollect_PrevAndNext(
		long awardid, long childid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchAwardException;

	/**
	* Removes all the awards where childid = &#63; from the database.
	*
	* @param childid the childid
	* @throws SystemException if a system exception occurred
	*/
	public void removeBychildCollect(long childid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of awards where childid = &#63;.
	*
	* @param childid the childid
	* @return the number of matching awards
	* @throws SystemException if a system exception occurred
	*/
	public int countBychildCollect(long childid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the award in the entity cache if it is enabled.
	*
	* @param award the award
	*/
	public void cacheResult(edison.challenge.service.builder.model.Award award);

	/**
	* Caches the awards in the entity cache if it is enabled.
	*
	* @param awards the awards
	*/
	public void cacheResult(
		java.util.List<edison.challenge.service.builder.model.Award> awards);

	/**
	* Creates a new award with the primary key. Does not add the award to the database.
	*
	* @param awardid the primary key for the new award
	* @return the new award
	*/
	public edison.challenge.service.builder.model.Award create(long awardid);

	/**
	* Removes the award with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param awardid the primary key of the award
	* @return the award that was removed
	* @throws edison.challenge.service.builder.NoSuchAwardException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.Award remove(long awardid)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchAwardException;

	public edison.challenge.service.builder.model.Award updateImpl(
		edison.challenge.service.builder.model.Award award)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the award with the primary key or throws a {@link edison.challenge.service.builder.NoSuchAwardException} if it could not be found.
	*
	* @param awardid the primary key of the award
	* @return the award
	* @throws edison.challenge.service.builder.NoSuchAwardException if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.Award findByPrimaryKey(
		long awardid)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchAwardException;

	/**
	* Returns the award with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param awardid the primary key of the award
	* @return the award, or <code>null</code> if a award with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.Award fetchByPrimaryKey(
		long awardid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the awards.
	*
	* @return the awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.Award> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the awards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of awards
	* @param end the upper bound of the range of awards (not inclusive)
	* @return the range of awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.Award> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the awards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.AwardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of awards
	* @param end the upper bound of the range of awards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of awards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.Award> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the awards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of awards.
	*
	* @return the number of awards
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}