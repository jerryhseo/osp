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

package org.kisti.edison.bestsimulation.service.base;

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

import org.kisti.edison.bestsimulation.model.SimulationExeStsMigration;
import org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationLocalService;
import org.kisti.edison.bestsimulation.service.persistence.ScienceAppExecuteFinder;
import org.kisti.edison.bestsimulation.service.persistence.ScienceAppExecutePersistence;
import org.kisti.edison.bestsimulation.service.persistence.SimulationExeStsMigrationPK;
import org.kisti.edison.bestsimulation.service.persistence.SimulationExeStsMigrationPersistence;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobDataPersistence;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobFinder;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobPersistence;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPersistence;
import org.kisti.edison.bestsimulation.service.persistence.SimulationPersistence;
import org.kisti.edison.bestsimulation.service.persistence.UniversityExecuteFinder;
import org.kisti.edison.bestsimulation.service.persistence.UniversityExecutePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the simulation exe sts migration local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.kisti.edison.bestsimulation.service.impl.SimulationExeStsMigrationLocalServiceImpl}.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.bestsimulation.service.impl.SimulationExeStsMigrationLocalServiceImpl
 * @see org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationLocalServiceUtil
 * @generated
 */
public abstract class SimulationExeStsMigrationLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements SimulationExeStsMigrationLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationLocalServiceUtil} to access the simulation exe sts migration local service.
	 */

	/**
	 * Adds the simulation exe sts migration to the database. Also notifies the appropriate model listeners.
	 *
	 * @param simulationExeStsMigration the simulation exe sts migration
	 * @return the simulation exe sts migration that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SimulationExeStsMigration addSimulationExeStsMigration(
		SimulationExeStsMigration simulationExeStsMigration)
		throws SystemException {
		simulationExeStsMigration.setNew(true);

		return simulationExeStsMigrationPersistence.update(simulationExeStsMigration);
	}

	/**
	 * Creates a new simulation exe sts migration with the primary key. Does not add the simulation exe sts migration to the database.
	 *
	 * @param simulationExeStsMigrationPK the primary key for the new simulation exe sts migration
	 * @return the new simulation exe sts migration
	 */
	@Override
	public SimulationExeStsMigration createSimulationExeStsMigration(
		SimulationExeStsMigrationPK simulationExeStsMigrationPK) {
		return simulationExeStsMigrationPersistence.create(simulationExeStsMigrationPK);
	}

	/**
	 * Deletes the simulation exe sts migration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param simulationExeStsMigrationPK the primary key of the simulation exe sts migration
	 * @return the simulation exe sts migration that was removed
	 * @throws PortalException if a simulation exe sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SimulationExeStsMigration deleteSimulationExeStsMigration(
		SimulationExeStsMigrationPK simulationExeStsMigrationPK)
		throws PortalException, SystemException {
		return simulationExeStsMigrationPersistence.remove(simulationExeStsMigrationPK);
	}

	/**
	 * Deletes the simulation exe sts migration from the database. Also notifies the appropriate model listeners.
	 *
	 * @param simulationExeStsMigration the simulation exe sts migration
	 * @return the simulation exe sts migration that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SimulationExeStsMigration deleteSimulationExeStsMigration(
		SimulationExeStsMigration simulationExeStsMigration)
		throws SystemException {
		return simulationExeStsMigrationPersistence.remove(simulationExeStsMigration);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SimulationExeStsMigration.class,
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
		return simulationExeStsMigrationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationExeStsMigrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return simulationExeStsMigrationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationExeStsMigrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return simulationExeStsMigrationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return simulationExeStsMigrationPersistence.countWithDynamicQuery(dynamicQuery);
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
		return simulationExeStsMigrationPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SimulationExeStsMigration fetchSimulationExeStsMigration(
		SimulationExeStsMigrationPK simulationExeStsMigrationPK)
		throws SystemException {
		return simulationExeStsMigrationPersistence.fetchByPrimaryKey(simulationExeStsMigrationPK);
	}

	/**
	 * Returns the simulation exe sts migration with the primary key.
	 *
	 * @param simulationExeStsMigrationPK the primary key of the simulation exe sts migration
	 * @return the simulation exe sts migration
	 * @throws PortalException if a simulation exe sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationExeStsMigration getSimulationExeStsMigration(
		SimulationExeStsMigrationPK simulationExeStsMigrationPK)
		throws PortalException, SystemException {
		return simulationExeStsMigrationPersistence.findByPrimaryKey(simulationExeStsMigrationPK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return simulationExeStsMigrationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the simulation exe sts migrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationExeStsMigrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of simulation exe sts migrations
	 * @param end the upper bound of the range of simulation exe sts migrations (not inclusive)
	 * @return the range of simulation exe sts migrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SimulationExeStsMigration> getSimulationExeStsMigrations(
		int start, int end) throws SystemException {
		return simulationExeStsMigrationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of simulation exe sts migrations.
	 *
	 * @return the number of simulation exe sts migrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSimulationExeStsMigrationsCount() throws SystemException {
		return simulationExeStsMigrationPersistence.countAll();
	}

	/**
	 * Updates the simulation exe sts migration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param simulationExeStsMigration the simulation exe sts migration
	 * @return the simulation exe sts migration that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SimulationExeStsMigration updateSimulationExeStsMigration(
		SimulationExeStsMigration simulationExeStsMigration)
		throws SystemException {
		return simulationExeStsMigrationPersistence.update(simulationExeStsMigration);
	}

	/**
	 * Returns the science app execute local service.
	 *
	 * @return the science app execute local service
	 */
	public org.kisti.edison.bestsimulation.service.ScienceAppExecuteLocalService getScienceAppExecuteLocalService() {
		return scienceAppExecuteLocalService;
	}

	/**
	 * Sets the science app execute local service.
	 *
	 * @param scienceAppExecuteLocalService the science app execute local service
	 */
	public void setScienceAppExecuteLocalService(
		org.kisti.edison.bestsimulation.service.ScienceAppExecuteLocalService scienceAppExecuteLocalService) {
		this.scienceAppExecuteLocalService = scienceAppExecuteLocalService;
	}

	/**
	 * Returns the science app execute remote service.
	 *
	 * @return the science app execute remote service
	 */
	public org.kisti.edison.bestsimulation.service.ScienceAppExecuteService getScienceAppExecuteService() {
		return scienceAppExecuteService;
	}

	/**
	 * Sets the science app execute remote service.
	 *
	 * @param scienceAppExecuteService the science app execute remote service
	 */
	public void setScienceAppExecuteService(
		org.kisti.edison.bestsimulation.service.ScienceAppExecuteService scienceAppExecuteService) {
		this.scienceAppExecuteService = scienceAppExecuteService;
	}

	/**
	 * Returns the science app execute persistence.
	 *
	 * @return the science app execute persistence
	 */
	public ScienceAppExecutePersistence getScienceAppExecutePersistence() {
		return scienceAppExecutePersistence;
	}

	/**
	 * Sets the science app execute persistence.
	 *
	 * @param scienceAppExecutePersistence the science app execute persistence
	 */
	public void setScienceAppExecutePersistence(
		ScienceAppExecutePersistence scienceAppExecutePersistence) {
		this.scienceAppExecutePersistence = scienceAppExecutePersistence;
	}

	/**
	 * Returns the science app execute finder.
	 *
	 * @return the science app execute finder
	 */
	public ScienceAppExecuteFinder getScienceAppExecuteFinder() {
		return scienceAppExecuteFinder;
	}

	/**
	 * Sets the science app execute finder.
	 *
	 * @param scienceAppExecuteFinder the science app execute finder
	 */
	public void setScienceAppExecuteFinder(
		ScienceAppExecuteFinder scienceAppExecuteFinder) {
		this.scienceAppExecuteFinder = scienceAppExecuteFinder;
	}

	/**
	 * Returns the simulation local service.
	 *
	 * @return the simulation local service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationLocalService getSimulationLocalService() {
		return simulationLocalService;
	}

	/**
	 * Sets the simulation local service.
	 *
	 * @param simulationLocalService the simulation local service
	 */
	public void setSimulationLocalService(
		org.kisti.edison.bestsimulation.service.SimulationLocalService simulationLocalService) {
		this.simulationLocalService = simulationLocalService;
	}

	/**
	 * Returns the simulation remote service.
	 *
	 * @return the simulation remote service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationService getSimulationService() {
		return simulationService;
	}

	/**
	 * Sets the simulation remote service.
	 *
	 * @param simulationService the simulation remote service
	 */
	public void setSimulationService(
		org.kisti.edison.bestsimulation.service.SimulationService simulationService) {
		this.simulationService = simulationService;
	}

	/**
	 * Returns the simulation persistence.
	 *
	 * @return the simulation persistence
	 */
	public SimulationPersistence getSimulationPersistence() {
		return simulationPersistence;
	}

	/**
	 * Sets the simulation persistence.
	 *
	 * @param simulationPersistence the simulation persistence
	 */
	public void setSimulationPersistence(
		SimulationPersistence simulationPersistence) {
		this.simulationPersistence = simulationPersistence;
	}

	/**
	 * Returns the simulation exe sts migration local service.
	 *
	 * @return the simulation exe sts migration local service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationLocalService getSimulationExeStsMigrationLocalService() {
		return simulationExeStsMigrationLocalService;
	}

	/**
	 * Sets the simulation exe sts migration local service.
	 *
	 * @param simulationExeStsMigrationLocalService the simulation exe sts migration local service
	 */
	public void setSimulationExeStsMigrationLocalService(
		org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationLocalService simulationExeStsMigrationLocalService) {
		this.simulationExeStsMigrationLocalService = simulationExeStsMigrationLocalService;
	}

	/**
	 * Returns the simulation exe sts migration remote service.
	 *
	 * @return the simulation exe sts migration remote service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationService getSimulationExeStsMigrationService() {
		return simulationExeStsMigrationService;
	}

	/**
	 * Sets the simulation exe sts migration remote service.
	 *
	 * @param simulationExeStsMigrationService the simulation exe sts migration remote service
	 */
	public void setSimulationExeStsMigrationService(
		org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationService simulationExeStsMigrationService) {
		this.simulationExeStsMigrationService = simulationExeStsMigrationService;
	}

	/**
	 * Returns the simulation exe sts migration persistence.
	 *
	 * @return the simulation exe sts migration persistence
	 */
	public SimulationExeStsMigrationPersistence getSimulationExeStsMigrationPersistence() {
		return simulationExeStsMigrationPersistence;
	}

	/**
	 * Sets the simulation exe sts migration persistence.
	 *
	 * @param simulationExeStsMigrationPersistence the simulation exe sts migration persistence
	 */
	public void setSimulationExeStsMigrationPersistence(
		SimulationExeStsMigrationPersistence simulationExeStsMigrationPersistence) {
		this.simulationExeStsMigrationPersistence = simulationExeStsMigrationPersistence;
	}

	/**
	 * Returns the simulation job local service.
	 *
	 * @return the simulation job local service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobLocalService getSimulationJobLocalService() {
		return simulationJobLocalService;
	}

	/**
	 * Sets the simulation job local service.
	 *
	 * @param simulationJobLocalService the simulation job local service
	 */
	public void setSimulationJobLocalService(
		org.kisti.edison.bestsimulation.service.SimulationJobLocalService simulationJobLocalService) {
		this.simulationJobLocalService = simulationJobLocalService;
	}

	/**
	 * Returns the simulation job remote service.
	 *
	 * @return the simulation job remote service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobService getSimulationJobService() {
		return simulationJobService;
	}

	/**
	 * Sets the simulation job remote service.
	 *
	 * @param simulationJobService the simulation job remote service
	 */
	public void setSimulationJobService(
		org.kisti.edison.bestsimulation.service.SimulationJobService simulationJobService) {
		this.simulationJobService = simulationJobService;
	}

	/**
	 * Returns the simulation job persistence.
	 *
	 * @return the simulation job persistence
	 */
	public SimulationJobPersistence getSimulationJobPersistence() {
		return simulationJobPersistence;
	}

	/**
	 * Sets the simulation job persistence.
	 *
	 * @param simulationJobPersistence the simulation job persistence
	 */
	public void setSimulationJobPersistence(
		SimulationJobPersistence simulationJobPersistence) {
		this.simulationJobPersistence = simulationJobPersistence;
	}

	/**
	 * Returns the simulation job finder.
	 *
	 * @return the simulation job finder
	 */
	public SimulationJobFinder getSimulationJobFinder() {
		return simulationJobFinder;
	}

	/**
	 * Sets the simulation job finder.
	 *
	 * @param simulationJobFinder the simulation job finder
	 */
	public void setSimulationJobFinder(SimulationJobFinder simulationJobFinder) {
		this.simulationJobFinder = simulationJobFinder;
	}

	/**
	 * Returns the simulation job data local service.
	 *
	 * @return the simulation job data local service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobDataLocalService getSimulationJobDataLocalService() {
		return simulationJobDataLocalService;
	}

	/**
	 * Sets the simulation job data local service.
	 *
	 * @param simulationJobDataLocalService the simulation job data local service
	 */
	public void setSimulationJobDataLocalService(
		org.kisti.edison.bestsimulation.service.SimulationJobDataLocalService simulationJobDataLocalService) {
		this.simulationJobDataLocalService = simulationJobDataLocalService;
	}

	/**
	 * Returns the simulation job data remote service.
	 *
	 * @return the simulation job data remote service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobDataService getSimulationJobDataService() {
		return simulationJobDataService;
	}

	/**
	 * Sets the simulation job data remote service.
	 *
	 * @param simulationJobDataService the simulation job data remote service
	 */
	public void setSimulationJobDataService(
		org.kisti.edison.bestsimulation.service.SimulationJobDataService simulationJobDataService) {
		this.simulationJobDataService = simulationJobDataService;
	}

	/**
	 * Returns the simulation job data persistence.
	 *
	 * @return the simulation job data persistence
	 */
	public SimulationJobDataPersistence getSimulationJobDataPersistence() {
		return simulationJobDataPersistence;
	}

	/**
	 * Sets the simulation job data persistence.
	 *
	 * @param simulationJobDataPersistence the simulation job data persistence
	 */
	public void setSimulationJobDataPersistence(
		SimulationJobDataPersistence simulationJobDataPersistence) {
		this.simulationJobDataPersistence = simulationJobDataPersistence;
	}

	/**
	 * Returns the simulation job status local service.
	 *
	 * @return the simulation job status local service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalService getSimulationJobStatusLocalService() {
		return simulationJobStatusLocalService;
	}

	/**
	 * Sets the simulation job status local service.
	 *
	 * @param simulationJobStatusLocalService the simulation job status local service
	 */
	public void setSimulationJobStatusLocalService(
		org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalService simulationJobStatusLocalService) {
		this.simulationJobStatusLocalService = simulationJobStatusLocalService;
	}

	/**
	 * Returns the simulation job status remote service.
	 *
	 * @return the simulation job status remote service
	 */
	public org.kisti.edison.bestsimulation.service.SimulationJobStatusService getSimulationJobStatusService() {
		return simulationJobStatusService;
	}

	/**
	 * Sets the simulation job status remote service.
	 *
	 * @param simulationJobStatusService the simulation job status remote service
	 */
	public void setSimulationJobStatusService(
		org.kisti.edison.bestsimulation.service.SimulationJobStatusService simulationJobStatusService) {
		this.simulationJobStatusService = simulationJobStatusService;
	}

	/**
	 * Returns the simulation job status persistence.
	 *
	 * @return the simulation job status persistence
	 */
	public SimulationJobStatusPersistence getSimulationJobStatusPersistence() {
		return simulationJobStatusPersistence;
	}

	/**
	 * Sets the simulation job status persistence.
	 *
	 * @param simulationJobStatusPersistence the simulation job status persistence
	 */
	public void setSimulationJobStatusPersistence(
		SimulationJobStatusPersistence simulationJobStatusPersistence) {
		this.simulationJobStatusPersistence = simulationJobStatusPersistence;
	}

	/**
	 * Returns the university execute local service.
	 *
	 * @return the university execute local service
	 */
	public org.kisti.edison.bestsimulation.service.UniversityExecuteLocalService getUniversityExecuteLocalService() {
		return universityExecuteLocalService;
	}

	/**
	 * Sets the university execute local service.
	 *
	 * @param universityExecuteLocalService the university execute local service
	 */
	public void setUniversityExecuteLocalService(
		org.kisti.edison.bestsimulation.service.UniversityExecuteLocalService universityExecuteLocalService) {
		this.universityExecuteLocalService = universityExecuteLocalService;
	}

	/**
	 * Returns the university execute remote service.
	 *
	 * @return the university execute remote service
	 */
	public org.kisti.edison.bestsimulation.service.UniversityExecuteService getUniversityExecuteService() {
		return universityExecuteService;
	}

	/**
	 * Sets the university execute remote service.
	 *
	 * @param universityExecuteService the university execute remote service
	 */
	public void setUniversityExecuteService(
		org.kisti.edison.bestsimulation.service.UniversityExecuteService universityExecuteService) {
		this.universityExecuteService = universityExecuteService;
	}

	/**
	 * Returns the university execute persistence.
	 *
	 * @return the university execute persistence
	 */
	public UniversityExecutePersistence getUniversityExecutePersistence() {
		return universityExecutePersistence;
	}

	/**
	 * Sets the university execute persistence.
	 *
	 * @param universityExecutePersistence the university execute persistence
	 */
	public void setUniversityExecutePersistence(
		UniversityExecutePersistence universityExecutePersistence) {
		this.universityExecutePersistence = universityExecutePersistence;
	}

	/**
	 * Returns the university execute finder.
	 *
	 * @return the university execute finder
	 */
	public UniversityExecuteFinder getUniversityExecuteFinder() {
		return universityExecuteFinder;
	}

	/**
	 * Sets the university execute finder.
	 *
	 * @param universityExecuteFinder the university execute finder
	 */
	public void setUniversityExecuteFinder(
		UniversityExecuteFinder universityExecuteFinder) {
		this.universityExecuteFinder = universityExecuteFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("org.kisti.edison.bestsimulation.model.SimulationExeStsMigration",
			simulationExeStsMigrationLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.kisti.edison.bestsimulation.model.SimulationExeStsMigration");
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
		return SimulationExeStsMigration.class;
	}

	protected String getModelClassName() {
		return SimulationExeStsMigration.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = simulationExeStsMigrationPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.kisti.edison.bestsimulation.service.ScienceAppExecuteLocalService.class)
	protected org.kisti.edison.bestsimulation.service.ScienceAppExecuteLocalService scienceAppExecuteLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.ScienceAppExecuteService.class)
	protected org.kisti.edison.bestsimulation.service.ScienceAppExecuteService scienceAppExecuteService;
	@BeanReference(type = ScienceAppExecutePersistence.class)
	protected ScienceAppExecutePersistence scienceAppExecutePersistence;
	@BeanReference(type = ScienceAppExecuteFinder.class)
	protected ScienceAppExecuteFinder scienceAppExecuteFinder;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationLocalService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationLocalService simulationLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationService simulationService;
	@BeanReference(type = SimulationPersistence.class)
	protected SimulationPersistence simulationPersistence;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationLocalService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationLocalService simulationExeStsMigrationLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationExeStsMigrationService simulationExeStsMigrationService;
	@BeanReference(type = SimulationExeStsMigrationPersistence.class)
	protected SimulationExeStsMigrationPersistence simulationExeStsMigrationPersistence;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobLocalService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobLocalService simulationJobLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobService simulationJobService;
	@BeanReference(type = SimulationJobPersistence.class)
	protected SimulationJobPersistence simulationJobPersistence;
	@BeanReference(type = SimulationJobFinder.class)
	protected SimulationJobFinder simulationJobFinder;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobDataLocalService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobDataLocalService simulationJobDataLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobDataService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobDataService simulationJobDataService;
	@BeanReference(type = SimulationJobDataPersistence.class)
	protected SimulationJobDataPersistence simulationJobDataPersistence;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalService simulationJobStatusLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.SimulationJobStatusService.class)
	protected org.kisti.edison.bestsimulation.service.SimulationJobStatusService simulationJobStatusService;
	@BeanReference(type = SimulationJobStatusPersistence.class)
	protected SimulationJobStatusPersistence simulationJobStatusPersistence;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.UniversityExecuteLocalService.class)
	protected org.kisti.edison.bestsimulation.service.UniversityExecuteLocalService universityExecuteLocalService;
	@BeanReference(type = org.kisti.edison.bestsimulation.service.UniversityExecuteService.class)
	protected org.kisti.edison.bestsimulation.service.UniversityExecuteService universityExecuteService;
	@BeanReference(type = UniversityExecutePersistence.class)
	protected UniversityExecutePersistence universityExecutePersistence;
	@BeanReference(type = UniversityExecuteFinder.class)
	protected UniversityExecuteFinder universityExecuteFinder;
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
	private SimulationExeStsMigrationLocalServiceClpInvoker _clpInvoker = new SimulationExeStsMigrationLocalServiceClpInvoker();
}