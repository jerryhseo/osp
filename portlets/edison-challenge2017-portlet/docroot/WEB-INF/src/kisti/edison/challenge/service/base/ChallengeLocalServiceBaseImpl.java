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

package kisti.edison.challenge.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.asset.service.persistence.AssetLinkPersistence;

import kisti.edison.challenge.model.Challenge;
import kisti.edison.challenge.service.ChallengeLocalService;
import kisti.edison.challenge.service.persistence.ChallengeEvaluationManagementPersistence;
import kisti.edison.challenge.service.persistence.ChallengeEvaluationScorePersistence;
import kisti.edison.challenge.service.persistence.ChallengePersistence;
import kisti.edison.challenge.service.persistence.ChallengeTeamFinder;
import kisti.edison.challenge.service.persistence.ChallengeTeamMemberPersistence;
import kisti.edison.challenge.service.persistence.ChallengeTeamPersistence;
import kisti.edison.challenge.service.persistence.ChildChallengePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the challenge local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link kisti.edison.challenge.service.impl.ChallengeLocalServiceImpl}.
 * </p>
 *
 * @author KYJ
 * @see kisti.edison.challenge.service.impl.ChallengeLocalServiceImpl
 * @see kisti.edison.challenge.service.ChallengeLocalServiceUtil
 * @generated
 */
public abstract class ChallengeLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ChallengeLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link kisti.edison.challenge.service.ChallengeLocalServiceUtil} to access the challenge local service.
	 */

	/**
	 * Adds the challenge to the database. Also notifies the appropriate model listeners.
	 *
	 * @param challenge the challenge
	 * @return the challenge that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Challenge addChallenge(Challenge challenge)
		throws SystemException {
		challenge.setNew(true);

		return challengePersistence.update(challenge);
	}

	/**
	 * Creates a new challenge with the primary key. Does not add the challenge to the database.
	 *
	 * @param challengeId the primary key for the new challenge
	 * @return the new challenge
	 */
	@Override
	public Challenge createChallenge(long challengeId) {
		return challengePersistence.create(challengeId);
	}

	/**
	 * Deletes the challenge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge that was removed
	 * @throws PortalException if a challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Challenge deleteChallenge(long challengeId)
		throws PortalException, SystemException {
		return challengePersistence.remove(challengeId);
	}

	/**
	 * Deletes the challenge from the database. Also notifies the appropriate model listeners.
	 *
	 * @param challenge the challenge
	 * @return the challenge that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Challenge deleteChallenge(Challenge challenge)
		throws SystemException {
		return challengePersistence.remove(challenge);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Challenge.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return challengePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kisti.edison.challenge.model.impl.ChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return challengePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kisti.edison.challenge.model.impl.ChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return challengePersistence.findWithDynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return challengePersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return challengePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Challenge fetchChallenge(long challengeId) throws SystemException {
		return challengePersistence.fetchByPrimaryKey(challengeId);
	}

	/**
	 * Returns the challenge with the matching UUID and company.
	 *
	 * @param uuid the challenge's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching challenge, or <code>null</code> if a matching challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge fetchChallengeByUuidAndCompanyId(String uuid,
		long companyId) throws SystemException {
		return challengePersistence.fetchByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the challenge matching the UUID and group.
	 *
	 * @param uuid the challenge's UUID
	 * @param groupId the primary key of the group
	 * @return the matching challenge, or <code>null</code> if a matching challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge fetchChallengeByUuidAndGroupId(String uuid, long groupId)
		throws SystemException {
		return challengePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the challenge with the primary key.
	 *
	 * @param challengeId the primary key of the challenge
	 * @return the challenge
	 * @throws PortalException if a challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge getChallenge(long challengeId)
		throws PortalException, SystemException {
		return challengePersistence.findByPrimaryKey(challengeId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return challengePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the challenge with the matching UUID and company.
	 *
	 * @param uuid the challenge's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching challenge
	 * @throws PortalException if a matching challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge getChallengeByUuidAndCompanyId(String uuid, long companyId)
		throws PortalException, SystemException {
		return challengePersistence.findByUuid_C_First(uuid, companyId, null);
	}

	/**
	 * Returns the challenge matching the UUID and group.
	 *
	 * @param uuid the challenge's UUID
	 * @param groupId the primary key of the group
	 * @return the matching challenge
	 * @throws PortalException if a matching challenge could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge getChallengeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return challengePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the challenges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link kisti.edison.challenge.model.impl.ChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Challenge> getChallenges(int start, int end)
		throws SystemException {
		return challengePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of challenges.
	 *
	 * @return the number of challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getChallengesCount() throws SystemException {
		return challengePersistence.countAll();
	}

	/**
	 * Updates the challenge in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param challenge the challenge
	 * @return the challenge that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Challenge updateChallenge(Challenge challenge)
		throws SystemException {
		return challengePersistence.update(challenge);
	}

	/**
	 * Returns the challenge local service.
	 *
	 * @return the challenge local service
	 */
	public kisti.edison.challenge.service.ChallengeLocalService getChallengeLocalService() {
		return challengeLocalService;
	}

	/**
	 * Sets the challenge local service.
	 *
	 * @param challengeLocalService the challenge local service
	 */
	public void setChallengeLocalService(
		kisti.edison.challenge.service.ChallengeLocalService challengeLocalService) {
		this.challengeLocalService = challengeLocalService;
	}

	/**
	 * Returns the challenge remote service.
	 *
	 * @return the challenge remote service
	 */
	public kisti.edison.challenge.service.ChallengeService getChallengeService() {
		return challengeService;
	}

	/**
	 * Sets the challenge remote service.
	 *
	 * @param challengeService the challenge remote service
	 */
	public void setChallengeService(
		kisti.edison.challenge.service.ChallengeService challengeService) {
		this.challengeService = challengeService;
	}

	/**
	 * Returns the challenge persistence.
	 *
	 * @return the challenge persistence
	 */
	public ChallengePersistence getChallengePersistence() {
		return challengePersistence;
	}

	/**
	 * Sets the challenge persistence.
	 *
	 * @param challengePersistence the challenge persistence
	 */
	public void setChallengePersistence(
		ChallengePersistence challengePersistence) {
		this.challengePersistence = challengePersistence;
	}

	/**
	 * Returns the challenge evaluation management local service.
	 *
	 * @return the challenge evaluation management local service
	 */
	public kisti.edison.challenge.service.ChallengeEvaluationManagementLocalService getChallengeEvaluationManagementLocalService() {
		return challengeEvaluationManagementLocalService;
	}

	/**
	 * Sets the challenge evaluation management local service.
	 *
	 * @param challengeEvaluationManagementLocalService the challenge evaluation management local service
	 */
	public void setChallengeEvaluationManagementLocalService(
		kisti.edison.challenge.service.ChallengeEvaluationManagementLocalService challengeEvaluationManagementLocalService) {
		this.challengeEvaluationManagementLocalService = challengeEvaluationManagementLocalService;
	}

	/**
	 * Returns the challenge evaluation management remote service.
	 *
	 * @return the challenge evaluation management remote service
	 */
	public kisti.edison.challenge.service.ChallengeEvaluationManagementService getChallengeEvaluationManagementService() {
		return challengeEvaluationManagementService;
	}

	/**
	 * Sets the challenge evaluation management remote service.
	 *
	 * @param challengeEvaluationManagementService the challenge evaluation management remote service
	 */
	public void setChallengeEvaluationManagementService(
		kisti.edison.challenge.service.ChallengeEvaluationManagementService challengeEvaluationManagementService) {
		this.challengeEvaluationManagementService = challengeEvaluationManagementService;
	}

	/**
	 * Returns the challenge evaluation management persistence.
	 *
	 * @return the challenge evaluation management persistence
	 */
	public ChallengeEvaluationManagementPersistence getChallengeEvaluationManagementPersistence() {
		return challengeEvaluationManagementPersistence;
	}

	/**
	 * Sets the challenge evaluation management persistence.
	 *
	 * @param challengeEvaluationManagementPersistence the challenge evaluation management persistence
	 */
	public void setChallengeEvaluationManagementPersistence(
		ChallengeEvaluationManagementPersistence challengeEvaluationManagementPersistence) {
		this.challengeEvaluationManagementPersistence = challengeEvaluationManagementPersistence;
	}

	/**
	 * Returns the challenge evaluation score local service.
	 *
	 * @return the challenge evaluation score local service
	 */
	public kisti.edison.challenge.service.ChallengeEvaluationScoreLocalService getChallengeEvaluationScoreLocalService() {
		return challengeEvaluationScoreLocalService;
	}

	/**
	 * Sets the challenge evaluation score local service.
	 *
	 * @param challengeEvaluationScoreLocalService the challenge evaluation score local service
	 */
	public void setChallengeEvaluationScoreLocalService(
		kisti.edison.challenge.service.ChallengeEvaluationScoreLocalService challengeEvaluationScoreLocalService) {
		this.challengeEvaluationScoreLocalService = challengeEvaluationScoreLocalService;
	}

	/**
	 * Returns the challenge evaluation score remote service.
	 *
	 * @return the challenge evaluation score remote service
	 */
	public kisti.edison.challenge.service.ChallengeEvaluationScoreService getChallengeEvaluationScoreService() {
		return challengeEvaluationScoreService;
	}

	/**
	 * Sets the challenge evaluation score remote service.
	 *
	 * @param challengeEvaluationScoreService the challenge evaluation score remote service
	 */
	public void setChallengeEvaluationScoreService(
		kisti.edison.challenge.service.ChallengeEvaluationScoreService challengeEvaluationScoreService) {
		this.challengeEvaluationScoreService = challengeEvaluationScoreService;
	}

	/**
	 * Returns the challenge evaluation score persistence.
	 *
	 * @return the challenge evaluation score persistence
	 */
	public ChallengeEvaluationScorePersistence getChallengeEvaluationScorePersistence() {
		return challengeEvaluationScorePersistence;
	}

	/**
	 * Sets the challenge evaluation score persistence.
	 *
	 * @param challengeEvaluationScorePersistence the challenge evaluation score persistence
	 */
	public void setChallengeEvaluationScorePersistence(
		ChallengeEvaluationScorePersistence challengeEvaluationScorePersistence) {
		this.challengeEvaluationScorePersistence = challengeEvaluationScorePersistence;
	}

	/**
	 * Returns the challenge team local service.
	 *
	 * @return the challenge team local service
	 */
	public kisti.edison.challenge.service.ChallengeTeamLocalService getChallengeTeamLocalService() {
		return challengeTeamLocalService;
	}

	/**
	 * Sets the challenge team local service.
	 *
	 * @param challengeTeamLocalService the challenge team local service
	 */
	public void setChallengeTeamLocalService(
		kisti.edison.challenge.service.ChallengeTeamLocalService challengeTeamLocalService) {
		this.challengeTeamLocalService = challengeTeamLocalService;
	}

	/**
	 * Returns the challenge team remote service.
	 *
	 * @return the challenge team remote service
	 */
	public kisti.edison.challenge.service.ChallengeTeamService getChallengeTeamService() {
		return challengeTeamService;
	}

	/**
	 * Sets the challenge team remote service.
	 *
	 * @param challengeTeamService the challenge team remote service
	 */
	public void setChallengeTeamService(
		kisti.edison.challenge.service.ChallengeTeamService challengeTeamService) {
		this.challengeTeamService = challengeTeamService;
	}

	/**
	 * Returns the challenge team persistence.
	 *
	 * @return the challenge team persistence
	 */
	public ChallengeTeamPersistence getChallengeTeamPersistence() {
		return challengeTeamPersistence;
	}

	/**
	 * Sets the challenge team persistence.
	 *
	 * @param challengeTeamPersistence the challenge team persistence
	 */
	public void setChallengeTeamPersistence(
		ChallengeTeamPersistence challengeTeamPersistence) {
		this.challengeTeamPersistence = challengeTeamPersistence;
	}

	/**
	 * Returns the challenge team finder.
	 *
	 * @return the challenge team finder
	 */
	public ChallengeTeamFinder getChallengeTeamFinder() {
		return challengeTeamFinder;
	}

	/**
	 * Sets the challenge team finder.
	 *
	 * @param challengeTeamFinder the challenge team finder
	 */
	public void setChallengeTeamFinder(ChallengeTeamFinder challengeTeamFinder) {
		this.challengeTeamFinder = challengeTeamFinder;
	}

	/**
	 * Returns the challenge team member local service.
	 *
	 * @return the challenge team member local service
	 */
	public kisti.edison.challenge.service.ChallengeTeamMemberLocalService getChallengeTeamMemberLocalService() {
		return challengeTeamMemberLocalService;
	}

	/**
	 * Sets the challenge team member local service.
	 *
	 * @param challengeTeamMemberLocalService the challenge team member local service
	 */
	public void setChallengeTeamMemberLocalService(
		kisti.edison.challenge.service.ChallengeTeamMemberLocalService challengeTeamMemberLocalService) {
		this.challengeTeamMemberLocalService = challengeTeamMemberLocalService;
	}

	/**
	 * Returns the challenge team member remote service.
	 *
	 * @return the challenge team member remote service
	 */
	public kisti.edison.challenge.service.ChallengeTeamMemberService getChallengeTeamMemberService() {
		return challengeTeamMemberService;
	}

	/**
	 * Sets the challenge team member remote service.
	 *
	 * @param challengeTeamMemberService the challenge team member remote service
	 */
	public void setChallengeTeamMemberService(
		kisti.edison.challenge.service.ChallengeTeamMemberService challengeTeamMemberService) {
		this.challengeTeamMemberService = challengeTeamMemberService;
	}

	/**
	 * Returns the challenge team member persistence.
	 *
	 * @return the challenge team member persistence
	 */
	public ChallengeTeamMemberPersistence getChallengeTeamMemberPersistence() {
		return challengeTeamMemberPersistence;
	}

	/**
	 * Sets the challenge team member persistence.
	 *
	 * @param challengeTeamMemberPersistence the challenge team member persistence
	 */
	public void setChallengeTeamMemberPersistence(
		ChallengeTeamMemberPersistence challengeTeamMemberPersistence) {
		this.challengeTeamMemberPersistence = challengeTeamMemberPersistence;
	}

	/**
	 * Returns the child challenge local service.
	 *
	 * @return the child challenge local service
	 */
	public kisti.edison.challenge.service.ChildChallengeLocalService getChildChallengeLocalService() {
		return childChallengeLocalService;
	}

	/**
	 * Sets the child challenge local service.
	 *
	 * @param childChallengeLocalService the child challenge local service
	 */
	public void setChildChallengeLocalService(
		kisti.edison.challenge.service.ChildChallengeLocalService childChallengeLocalService) {
		this.childChallengeLocalService = childChallengeLocalService;
	}

	/**
	 * Returns the child challenge remote service.
	 *
	 * @return the child challenge remote service
	 */
	public kisti.edison.challenge.service.ChildChallengeService getChildChallengeService() {
		return childChallengeService;
	}

	/**
	 * Sets the child challenge remote service.
	 *
	 * @param childChallengeService the child challenge remote service
	 */
	public void setChildChallengeService(
		kisti.edison.challenge.service.ChildChallengeService childChallengeService) {
		this.childChallengeService = childChallengeService;
	}

	/**
	 * Returns the child challenge persistence.
	 *
	 * @return the child challenge persistence
	 */
	public ChildChallengePersistence getChildChallengePersistence() {
		return childChallengePersistence;
	}

	/**
	 * Sets the child challenge persistence.
	 *
	 * @param childChallengePersistence the child challenge persistence
	 */
	public void setChildChallengePersistence(
		ChildChallengePersistence childChallengePersistence) {
		this.childChallengePersistence = childChallengePersistence;
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

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.portlet.asset.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.portlet.asset.service.AssetEntryService getAssetEntryService() {
		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.portlet.asset.service.AssetEntryService assetEntryService) {
		this.assetEntryService = assetEntryService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.portlet.asset.service.AssetLinkLocalService getAssetLinkLocalService() {
		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService) {
		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {
		this.assetLinkPersistence = assetLinkPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("kisti.edison.challenge.model.Challenge",
			challengeLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"kisti.edison.challenge.model.Challenge");
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
		return Challenge.class;
	}

	protected String getModelClassName() {
		return Challenge.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = challengePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = kisti.edison.challenge.service.ChallengeLocalService.class)
	protected kisti.edison.challenge.service.ChallengeLocalService challengeLocalService;
	@BeanReference(type = kisti.edison.challenge.service.ChallengeService.class)
	protected kisti.edison.challenge.service.ChallengeService challengeService;
	@BeanReference(type = ChallengePersistence.class)
	protected ChallengePersistence challengePersistence;
	@BeanReference(type = kisti.edison.challenge.service.ChallengeEvaluationManagementLocalService.class)
	protected kisti.edison.challenge.service.ChallengeEvaluationManagementLocalService challengeEvaluationManagementLocalService;
	@BeanReference(type = kisti.edison.challenge.service.ChallengeEvaluationManagementService.class)
	protected kisti.edison.challenge.service.ChallengeEvaluationManagementService challengeEvaluationManagementService;
	@BeanReference(type = ChallengeEvaluationManagementPersistence.class)
	protected ChallengeEvaluationManagementPersistence challengeEvaluationManagementPersistence;
	@BeanReference(type = kisti.edison.challenge.service.ChallengeEvaluationScoreLocalService.class)
	protected kisti.edison.challenge.service.ChallengeEvaluationScoreLocalService challengeEvaluationScoreLocalService;
	@BeanReference(type = kisti.edison.challenge.service.ChallengeEvaluationScoreService.class)
	protected kisti.edison.challenge.service.ChallengeEvaluationScoreService challengeEvaluationScoreService;
	@BeanReference(type = ChallengeEvaluationScorePersistence.class)
	protected ChallengeEvaluationScorePersistence challengeEvaluationScorePersistence;
	@BeanReference(type = kisti.edison.challenge.service.ChallengeTeamLocalService.class)
	protected kisti.edison.challenge.service.ChallengeTeamLocalService challengeTeamLocalService;
	@BeanReference(type = kisti.edison.challenge.service.ChallengeTeamService.class)
	protected kisti.edison.challenge.service.ChallengeTeamService challengeTeamService;
	@BeanReference(type = ChallengeTeamPersistence.class)
	protected ChallengeTeamPersistence challengeTeamPersistence;
	@BeanReference(type = ChallengeTeamFinder.class)
	protected ChallengeTeamFinder challengeTeamFinder;
	@BeanReference(type = kisti.edison.challenge.service.ChallengeTeamMemberLocalService.class)
	protected kisti.edison.challenge.service.ChallengeTeamMemberLocalService challengeTeamMemberLocalService;
	@BeanReference(type = kisti.edison.challenge.service.ChallengeTeamMemberService.class)
	protected kisti.edison.challenge.service.ChallengeTeamMemberService challengeTeamMemberService;
	@BeanReference(type = ChallengeTeamMemberPersistence.class)
	protected ChallengeTeamMemberPersistence challengeTeamMemberPersistence;
	@BeanReference(type = kisti.edison.challenge.service.ChildChallengeLocalService.class)
	protected kisti.edison.challenge.service.ChildChallengeLocalService childChallengeLocalService;
	@BeanReference(type = kisti.edison.challenge.service.ChildChallengeService.class)
	protected kisti.edison.challenge.service.ChildChallengeService childChallengeService;
	@BeanReference(type = ChildChallengePersistence.class)
	protected ChildChallengePersistence childChallengePersistence;
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
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryLocalService.class)
	protected com.liferay.portlet.asset.service.AssetEntryLocalService assetEntryLocalService;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetEntryService.class)
	protected com.liferay.portlet.asset.service.AssetEntryService assetEntryService;
	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@BeanReference(type = com.liferay.portlet.asset.service.AssetLinkLocalService.class)
	protected com.liferay.portlet.asset.service.AssetLinkLocalService assetLinkLocalService;
	@BeanReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ChallengeLocalServiceClpInvoker _clpInvoker = new ChallengeLocalServiceClpInvoker();
}