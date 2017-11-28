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

import edison.challenge.service.builder.model.ChallengeMember;

/**
 * The persistence interface for the challenge member service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kyj
 * @see ChallengeMemberPersistenceImpl
 * @see ChallengeMemberUtil
 * @generated
 */
public interface ChallengeMemberPersistence extends BasePersistence<ChallengeMember> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChallengeMemberUtil} to access the challenge member persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the challenge members where chTeamid = &#63;.
	*
	* @param chTeamid the ch teamid
	* @return the matching challenge members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.ChallengeMember> findByteamCollect(
		long chTeamid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the challenge members where chTeamid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.ChallengeMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chTeamid the ch teamid
	* @param start the lower bound of the range of challenge members
	* @param end the upper bound of the range of challenge members (not inclusive)
	* @return the range of matching challenge members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.ChallengeMember> findByteamCollect(
		long chTeamid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the challenge members where chTeamid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.ChallengeMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param chTeamid the ch teamid
	* @param start the lower bound of the range of challenge members
	* @param end the upper bound of the range of challenge members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching challenge members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.ChallengeMember> findByteamCollect(
		long chTeamid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first challenge member in the ordered set where chTeamid = &#63;.
	*
	* @param chTeamid the ch teamid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching challenge member
	* @throws edison.challenge.service.builder.NoSuchChallengeMemberException if a matching challenge member could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.ChallengeMember findByteamCollect_First(
		long chTeamid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchChallengeMemberException;

	/**
	* Returns the first challenge member in the ordered set where chTeamid = &#63;.
	*
	* @param chTeamid the ch teamid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching challenge member, or <code>null</code> if a matching challenge member could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.ChallengeMember fetchByteamCollect_First(
		long chTeamid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last challenge member in the ordered set where chTeamid = &#63;.
	*
	* @param chTeamid the ch teamid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching challenge member
	* @throws edison.challenge.service.builder.NoSuchChallengeMemberException if a matching challenge member could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.ChallengeMember findByteamCollect_Last(
		long chTeamid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchChallengeMemberException;

	/**
	* Returns the last challenge member in the ordered set where chTeamid = &#63;.
	*
	* @param chTeamid the ch teamid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching challenge member, or <code>null</code> if a matching challenge member could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.ChallengeMember fetchByteamCollect_Last(
		long chTeamid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the challenge members before and after the current challenge member in the ordered set where chTeamid = &#63;.
	*
	* @param chMemberid the primary key of the current challenge member
	* @param chTeamid the ch teamid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next challenge member
	* @throws edison.challenge.service.builder.NoSuchChallengeMemberException if a challenge member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.ChallengeMember[] findByteamCollect_PrevAndNext(
		long chMemberid, long chTeamid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchChallengeMemberException;

	/**
	* Removes all the challenge members where chTeamid = &#63; from the database.
	*
	* @param chTeamid the ch teamid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByteamCollect(long chTeamid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of challenge members where chTeamid = &#63;.
	*
	* @param chTeamid the ch teamid
	* @return the number of matching challenge members
	* @throws SystemException if a system exception occurred
	*/
	public int countByteamCollect(long chTeamid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the challenge member in the entity cache if it is enabled.
	*
	* @param challengeMember the challenge member
	*/
	public void cacheResult(
		edison.challenge.service.builder.model.ChallengeMember challengeMember);

	/**
	* Caches the challenge members in the entity cache if it is enabled.
	*
	* @param challengeMembers the challenge members
	*/
	public void cacheResult(
		java.util.List<edison.challenge.service.builder.model.ChallengeMember> challengeMembers);

	/**
	* Creates a new challenge member with the primary key. Does not add the challenge member to the database.
	*
	* @param chMemberid the primary key for the new challenge member
	* @return the new challenge member
	*/
	public edison.challenge.service.builder.model.ChallengeMember create(
		long chMemberid);

	/**
	* Removes the challenge member with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param chMemberid the primary key of the challenge member
	* @return the challenge member that was removed
	* @throws edison.challenge.service.builder.NoSuchChallengeMemberException if a challenge member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.ChallengeMember remove(
		long chMemberid)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchChallengeMemberException;

	public edison.challenge.service.builder.model.ChallengeMember updateImpl(
		edison.challenge.service.builder.model.ChallengeMember challengeMember)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the challenge member with the primary key or throws a {@link edison.challenge.service.builder.NoSuchChallengeMemberException} if it could not be found.
	*
	* @param chMemberid the primary key of the challenge member
	* @return the challenge member
	* @throws edison.challenge.service.builder.NoSuchChallengeMemberException if a challenge member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.ChallengeMember findByPrimaryKey(
		long chMemberid)
		throws com.liferay.portal.kernel.exception.SystemException,
			edison.challenge.service.builder.NoSuchChallengeMemberException;

	/**
	* Returns the challenge member with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param chMemberid the primary key of the challenge member
	* @return the challenge member, or <code>null</code> if a challenge member with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public edison.challenge.service.builder.model.ChallengeMember fetchByPrimaryKey(
		long chMemberid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the challenge members.
	*
	* @return the challenge members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.ChallengeMember> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the challenge members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.ChallengeMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of challenge members
	* @param end the upper bound of the range of challenge members (not inclusive)
	* @return the range of challenge members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.ChallengeMember> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the challenge members.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.ChallengeMemberModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of challenge members
	* @param end the upper bound of the range of challenge members (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of challenge members
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<edison.challenge.service.builder.model.ChallengeMember> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the challenge members from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of challenge members.
	*
	* @return the number of challenge members
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}