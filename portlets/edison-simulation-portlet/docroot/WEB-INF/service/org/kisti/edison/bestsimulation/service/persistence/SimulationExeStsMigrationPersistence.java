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

package org.kisti.edison.bestsimulation.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.bestsimulation.model.SimulationExeStsMigration;

/**
 * The persistence interface for the simulation exe sts migration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SimulationExeStsMigrationPersistenceImpl
 * @see SimulationExeStsMigrationUtil
 * @generated
 */
public interface SimulationExeStsMigrationPersistence extends BasePersistence<SimulationExeStsMigration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SimulationExeStsMigrationUtil} to access the simulation exe sts migration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the simulation exe sts migration in the entity cache if it is enabled.
	*
	* @param simulationExeStsMigration the simulation exe sts migration
	*/
	public void cacheResult(
		org.kisti.edison.bestsimulation.model.SimulationExeStsMigration simulationExeStsMigration);

	/**
	* Caches the simulation exe sts migrations in the entity cache if it is enabled.
	*
	* @param simulationExeStsMigrations the simulation exe sts migrations
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.bestsimulation.model.SimulationExeStsMigration> simulationExeStsMigrations);

	/**
	* Creates a new simulation exe sts migration with the primary key. Does not add the simulation exe sts migration to the database.
	*
	* @param simulationExeStsMigrationPK the primary key for the new simulation exe sts migration
	* @return the new simulation exe sts migration
	*/
	public org.kisti.edison.bestsimulation.model.SimulationExeStsMigration create(
		org.kisti.edison.bestsimulation.service.persistence.SimulationExeStsMigrationPK simulationExeStsMigrationPK);

	/**
	* Removes the simulation exe sts migration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationExeStsMigrationPK the primary key of the simulation exe sts migration
	* @return the simulation exe sts migration that was removed
	* @throws org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException if a simulation exe sts migration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationExeStsMigration remove(
		org.kisti.edison.bestsimulation.service.persistence.SimulationExeStsMigrationPK simulationExeStsMigrationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException;

	public org.kisti.edison.bestsimulation.model.SimulationExeStsMigration updateImpl(
		org.kisti.edison.bestsimulation.model.SimulationExeStsMigration simulationExeStsMigration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the simulation exe sts migration with the primary key or throws a {@link org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException} if it could not be found.
	*
	* @param simulationExeStsMigrationPK the primary key of the simulation exe sts migration
	* @return the simulation exe sts migration
	* @throws org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException if a simulation exe sts migration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationExeStsMigration findByPrimaryKey(
		org.kisti.edison.bestsimulation.service.persistence.SimulationExeStsMigrationPK simulationExeStsMigrationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException;

	/**
	* Returns the simulation exe sts migration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param simulationExeStsMigrationPK the primary key of the simulation exe sts migration
	* @return the simulation exe sts migration, or <code>null</code> if a simulation exe sts migration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationExeStsMigration fetchByPrimaryKey(
		org.kisti.edison.bestsimulation.service.persistence.SimulationExeStsMigrationPK simulationExeStsMigrationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the simulation exe sts migrations.
	*
	* @return the simulation exe sts migrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationExeStsMigration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationExeStsMigration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the simulation exe sts migrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationExeStsMigrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulation exe sts migrations
	* @param end the upper bound of the range of simulation exe sts migrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of simulation exe sts migrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationExeStsMigration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the simulation exe sts migrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of simulation exe sts migrations.
	*
	* @return the number of simulation exe sts migrations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}