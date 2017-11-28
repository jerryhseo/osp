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

package edison.challenge.service.builder.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import edison.challenge.service.builder.model.ChallengeTeam;
import edison.challenge.service.builder.service.ChallengeTeamService;
import edison.challenge.service.builder.service.persistence.AgencyPersistence;
import edison.challenge.service.builder.service.persistence.AwardPersistence;
import edison.challenge.service.builder.service.persistence.AwardhistoryPersistence;
import edison.challenge.service.builder.service.persistence.ChallengeMemberPersistence;
import edison.challenge.service.builder.service.persistence.ChallengePersistence;
import edison.challenge.service.builder.service.persistence.ChallengeTeamFinder;
import edison.challenge.service.builder.service.persistence.ChallengeTeamPersistence;
import edison.challenge.service.builder.service.persistence.ChildChallengePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the challenge team remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link edison.challenge.service.builder.service.impl.ChallengeTeamServiceImpl}.
 * </p>
 *
 * @author kyj
 * @see edison.challenge.service.builder.service.impl.ChallengeTeamServiceImpl
 * @see edison.challenge.service.builder.service.ChallengeTeamServiceUtil
 * @generated
 */
public abstract class ChallengeTeamServiceBaseImpl extends BaseServiceImpl
	implements ChallengeTeamService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link edison.challenge.service.builder.service.ChallengeTeamServiceUtil} to access the challenge team remote service.
	 */

	/**
	 * Returns the agency local service.
	 *
	 * @return the agency local service
	 */
	public edison.challenge.service.builder.service.AgencyLocalService getAgencyLocalService() {
		return agencyLocalService;
	}

	/**
	 * Sets the agency local service.
	 *
	 * @param agencyLocalService the agency local service
	 */
	public void setAgencyLocalService(
		edison.challenge.service.builder.service.AgencyLocalService agencyLocalService) {
		this.agencyLocalService = agencyLocalService;
	}

	/**
	 * Returns the agency remote service.
	 *
	 * @return the agency remote service
	 */
	public edison.challenge.service.builder.service.AgencyService getAgencyService() {
		return agencyService;
	}

	/**
	 * Sets the agency remote service.
	 *
	 * @param agencyService the agency remote service
	 */
	public void setAgencyService(
		edison.challenge.service.builder.service.AgencyService agencyService) {
		this.agencyService = agencyService;
	}

	/**
	 * Returns the agency persistence.
	 *
	 * @return the agency persistence
	 */
	public AgencyPersistence getAgencyPersistence() {
		return agencyPersistence;
	}

	/**
	 * Sets the agency persistence.
	 *
	 * @param agencyPersistence the agency persistence
	 */
	public void setAgencyPersistence(AgencyPersistence agencyPersistence) {
		this.agencyPersistence = agencyPersistence;
	}

	/**
	 * Returns the award local service.
	 *
	 * @return the award local service
	 */
	public edison.challenge.service.builder.service.AwardLocalService getAwardLocalService() {
		return awardLocalService;
	}

	/**
	 * Sets the award local service.
	 *
	 * @param awardLocalService the award local service
	 */
	public void setAwardLocalService(
		edison.challenge.service.builder.service.AwardLocalService awardLocalService) {
		this.awardLocalService = awardLocalService;
	}

	/**
	 * Returns the award remote service.
	 *
	 * @return the award remote service
	 */
	public edison.challenge.service.builder.service.AwardService getAwardService() {
		return awardService;
	}

	/**
	 * Sets the award remote service.
	 *
	 * @param awardService the award remote service
	 */
	public void setAwardService(
		edison.challenge.service.builder.service.AwardService awardService) {
		this.awardService = awardService;
	}

	/**
	 * Returns the award persistence.
	 *
	 * @return the award persistence
	 */
	public AwardPersistence getAwardPersistence() {
		return awardPersistence;
	}

	/**
	 * Sets the award persistence.
	 *
	 * @param awardPersistence the award persistence
	 */
	public void setAwardPersistence(AwardPersistence awardPersistence) {
		this.awardPersistence = awardPersistence;
	}

	/**
	 * Returns the awardhistory local service.
	 *
	 * @return the awardhistory local service
	 */
	public edison.challenge.service.builder.service.AwardhistoryLocalService getAwardhistoryLocalService() {
		return awardhistoryLocalService;
	}

	/**
	 * Sets the awardhistory local service.
	 *
	 * @param awardhistoryLocalService the awardhistory local service
	 */
	public void setAwardhistoryLocalService(
		edison.challenge.service.builder.service.AwardhistoryLocalService awardhistoryLocalService) {
		this.awardhistoryLocalService = awardhistoryLocalService;
	}

	/**
	 * Returns the awardhistory remote service.
	 *
	 * @return the awardhistory remote service
	 */
	public edison.challenge.service.builder.service.AwardhistoryService getAwardhistoryService() {
		return awardhistoryService;
	}

	/**
	 * Sets the awardhistory remote service.
	 *
	 * @param awardhistoryService the awardhistory remote service
	 */
	public void setAwardhistoryService(
		edison.challenge.service.builder.service.AwardhistoryService awardhistoryService) {
		this.awardhistoryService = awardhistoryService;
	}

	/**
	 * Returns the awardhistory persistence.
	 *
	 * @return the awardhistory persistence
	 */
	public AwardhistoryPersistence getAwardhistoryPersistence() {
		return awardhistoryPersistence;
	}

	/**
	 * Sets the awardhistory persistence.
	 *
	 * @param awardhistoryPersistence the awardhistory persistence
	 */
	public void setAwardhistoryPersistence(
		AwardhistoryPersistence awardhistoryPersistence) {
		this.awardhistoryPersistence = awardhistoryPersistence;
	}

	/**
	 * Returns the challenge local service.
	 *
	 * @return the challenge local service
	 */
	public edison.challenge.service.builder.service.ChallengeLocalService getChallengeLocalService() {
		return challengeLocalService;
	}

	/**
	 * Sets the challenge local service.
	 *
	 * @param challengeLocalService the challenge local service
	 */
	public void setChallengeLocalService(
		edison.challenge.service.builder.service.ChallengeLocalService challengeLocalService) {
		this.challengeLocalService = challengeLocalService;
	}

	/**
	 * Returns the challenge remote service.
	 *
	 * @return the challenge remote service
	 */
	public edison.challenge.service.builder.service.ChallengeService getChallengeService() {
		return challengeService;
	}

	/**
	 * Sets the challenge remote service.
	 *
	 * @param challengeService the challenge remote service
	 */
	public void setChallengeService(
		edison.challenge.service.builder.service.ChallengeService challengeService) {
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
	 * Returns the challenge member local service.
	 *
	 * @return the challenge member local service
	 */
	public edison.challenge.service.builder.service.ChallengeMemberLocalService getChallengeMemberLocalService() {
		return challengeMemberLocalService;
	}

	/**
	 * Sets the challenge member local service.
	 *
	 * @param challengeMemberLocalService the challenge member local service
	 */
	public void setChallengeMemberLocalService(
		edison.challenge.service.builder.service.ChallengeMemberLocalService challengeMemberLocalService) {
		this.challengeMemberLocalService = challengeMemberLocalService;
	}

	/**
	 * Returns the challenge member remote service.
	 *
	 * @return the challenge member remote service
	 */
	public edison.challenge.service.builder.service.ChallengeMemberService getChallengeMemberService() {
		return challengeMemberService;
	}

	/**
	 * Sets the challenge member remote service.
	 *
	 * @param challengeMemberService the challenge member remote service
	 */
	public void setChallengeMemberService(
		edison.challenge.service.builder.service.ChallengeMemberService challengeMemberService) {
		this.challengeMemberService = challengeMemberService;
	}

	/**
	 * Returns the challenge member persistence.
	 *
	 * @return the challenge member persistence
	 */
	public ChallengeMemberPersistence getChallengeMemberPersistence() {
		return challengeMemberPersistence;
	}

	/**
	 * Sets the challenge member persistence.
	 *
	 * @param challengeMemberPersistence the challenge member persistence
	 */
	public void setChallengeMemberPersistence(
		ChallengeMemberPersistence challengeMemberPersistence) {
		this.challengeMemberPersistence = challengeMemberPersistence;
	}

	/**
	 * Returns the challenge team local service.
	 *
	 * @return the challenge team local service
	 */
	public edison.challenge.service.builder.service.ChallengeTeamLocalService getChallengeTeamLocalService() {
		return challengeTeamLocalService;
	}

	/**
	 * Sets the challenge team local service.
	 *
	 * @param challengeTeamLocalService the challenge team local service
	 */
	public void setChallengeTeamLocalService(
		edison.challenge.service.builder.service.ChallengeTeamLocalService challengeTeamLocalService) {
		this.challengeTeamLocalService = challengeTeamLocalService;
	}

	/**
	 * Returns the challenge team remote service.
	 *
	 * @return the challenge team remote service
	 */
	public edison.challenge.service.builder.service.ChallengeTeamService getChallengeTeamService() {
		return challengeTeamService;
	}

	/**
	 * Sets the challenge team remote service.
	 *
	 * @param challengeTeamService the challenge team remote service
	 */
	public void setChallengeTeamService(
		edison.challenge.service.builder.service.ChallengeTeamService challengeTeamService) {
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
	 * Returns the child challenge local service.
	 *
	 * @return the child challenge local service
	 */
	public edison.challenge.service.builder.service.ChildChallengeLocalService getChildChallengeLocalService() {
		return childChallengeLocalService;
	}

	/**
	 * Sets the child challenge local service.
	 *
	 * @param childChallengeLocalService the child challenge local service
	 */
	public void setChildChallengeLocalService(
		edison.challenge.service.builder.service.ChildChallengeLocalService childChallengeLocalService) {
		this.childChallengeLocalService = childChallengeLocalService;
	}

	/**
	 * Returns the child challenge remote service.
	 *
	 * @return the child challenge remote service
	 */
	public edison.challenge.service.builder.service.ChildChallengeService getChildChallengeService() {
		return childChallengeService;
	}

	/**
	 * Sets the child challenge remote service.
	 *
	 * @param childChallengeService the child challenge remote service
	 */
	public void setChildChallengeService(
		edison.challenge.service.builder.service.ChildChallengeService childChallengeService) {
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
		return ChallengeTeam.class;
	}

	protected String getModelClassName() {
		return ChallengeTeam.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = challengeTeamPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = edison.challenge.service.builder.service.AgencyLocalService.class)
	protected edison.challenge.service.builder.service.AgencyLocalService agencyLocalService;
	@BeanReference(type = edison.challenge.service.builder.service.AgencyService.class)
	protected edison.challenge.service.builder.service.AgencyService agencyService;
	@BeanReference(type = AgencyPersistence.class)
	protected AgencyPersistence agencyPersistence;
	@BeanReference(type = edison.challenge.service.builder.service.AwardLocalService.class)
	protected edison.challenge.service.builder.service.AwardLocalService awardLocalService;
	@BeanReference(type = edison.challenge.service.builder.service.AwardService.class)
	protected edison.challenge.service.builder.service.AwardService awardService;
	@BeanReference(type = AwardPersistence.class)
	protected AwardPersistence awardPersistence;
	@BeanReference(type = edison.challenge.service.builder.service.AwardhistoryLocalService.class)
	protected edison.challenge.service.builder.service.AwardhistoryLocalService awardhistoryLocalService;
	@BeanReference(type = edison.challenge.service.builder.service.AwardhistoryService.class)
	protected edison.challenge.service.builder.service.AwardhistoryService awardhistoryService;
	@BeanReference(type = AwardhistoryPersistence.class)
	protected AwardhistoryPersistence awardhistoryPersistence;
	@BeanReference(type = edison.challenge.service.builder.service.ChallengeLocalService.class)
	protected edison.challenge.service.builder.service.ChallengeLocalService challengeLocalService;
	@BeanReference(type = edison.challenge.service.builder.service.ChallengeService.class)
	protected edison.challenge.service.builder.service.ChallengeService challengeService;
	@BeanReference(type = ChallengePersistence.class)
	protected ChallengePersistence challengePersistence;
	@BeanReference(type = edison.challenge.service.builder.service.ChallengeMemberLocalService.class)
	protected edison.challenge.service.builder.service.ChallengeMemberLocalService challengeMemberLocalService;
	@BeanReference(type = edison.challenge.service.builder.service.ChallengeMemberService.class)
	protected edison.challenge.service.builder.service.ChallengeMemberService challengeMemberService;
	@BeanReference(type = ChallengeMemberPersistence.class)
	protected ChallengeMemberPersistence challengeMemberPersistence;
	@BeanReference(type = edison.challenge.service.builder.service.ChallengeTeamLocalService.class)
	protected edison.challenge.service.builder.service.ChallengeTeamLocalService challengeTeamLocalService;
	@BeanReference(type = edison.challenge.service.builder.service.ChallengeTeamService.class)
	protected edison.challenge.service.builder.service.ChallengeTeamService challengeTeamService;
	@BeanReference(type = ChallengeTeamPersistence.class)
	protected ChallengeTeamPersistence challengeTeamPersistence;
	@BeanReference(type = ChallengeTeamFinder.class)
	protected ChallengeTeamFinder challengeTeamFinder;
	@BeanReference(type = edison.challenge.service.builder.service.ChildChallengeLocalService.class)
	protected edison.challenge.service.builder.service.ChildChallengeLocalService childChallengeLocalService;
	@BeanReference(type = edison.challenge.service.builder.service.ChildChallengeService.class)
	protected edison.challenge.service.builder.service.ChildChallengeService childChallengeService;
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
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private ChallengeTeamServiceClpInvoker _clpInvoker = new ChallengeTeamServiceClpInvoker();
}