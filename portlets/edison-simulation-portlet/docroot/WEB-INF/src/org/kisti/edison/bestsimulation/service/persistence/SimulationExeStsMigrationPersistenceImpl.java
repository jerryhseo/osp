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

package org.kisti.edison.bestsimulation.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException;
import org.kisti.edison.bestsimulation.model.SimulationExeStsMigration;
import org.kisti.edison.bestsimulation.model.impl.SimulationExeStsMigrationImpl;
import org.kisti.edison.bestsimulation.model.impl.SimulationExeStsMigrationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the simulation exe sts migration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SimulationExeStsMigrationPersistence
 * @see SimulationExeStsMigrationUtil
 * @generated
 */
public class SimulationExeStsMigrationPersistenceImpl
	extends BasePersistenceImpl<SimulationExeStsMigration>
	implements SimulationExeStsMigrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SimulationExeStsMigrationUtil} to access the simulation exe sts migration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SimulationExeStsMigrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationExeStsMigrationModelImpl.FINDER_CACHE_ENABLED,
			SimulationExeStsMigrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationExeStsMigrationModelImpl.FINDER_CACHE_ENABLED,
			SimulationExeStsMigrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationExeStsMigrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public SimulationExeStsMigrationPersistenceImpl() {
		setModelClass(SimulationExeStsMigration.class);
	}

	/**
	 * Caches the simulation exe sts migration in the entity cache if it is enabled.
	 *
	 * @param simulationExeStsMigration the simulation exe sts migration
	 */
	@Override
	public void cacheResult(SimulationExeStsMigration simulationExeStsMigration) {
		EntityCacheUtil.putResult(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationExeStsMigrationImpl.class,
			simulationExeStsMigration.getPrimaryKey(), simulationExeStsMigration);

		simulationExeStsMigration.resetOriginalValues();
	}

	/**
	 * Caches the simulation exe sts migrations in the entity cache if it is enabled.
	 *
	 * @param simulationExeStsMigrations the simulation exe sts migrations
	 */
	@Override
	public void cacheResult(
		List<SimulationExeStsMigration> simulationExeStsMigrations) {
		for (SimulationExeStsMigration simulationExeStsMigration : simulationExeStsMigrations) {
			if (EntityCacheUtil.getResult(
						SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
						SimulationExeStsMigrationImpl.class,
						simulationExeStsMigration.getPrimaryKey()) == null) {
				cacheResult(simulationExeStsMigration);
			}
			else {
				simulationExeStsMigration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all simulation exe sts migrations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SimulationExeStsMigrationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SimulationExeStsMigrationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the simulation exe sts migration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SimulationExeStsMigration simulationExeStsMigration) {
		EntityCacheUtil.removeResult(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationExeStsMigrationImpl.class,
			simulationExeStsMigration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<SimulationExeStsMigration> simulationExeStsMigrations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SimulationExeStsMigration simulationExeStsMigration : simulationExeStsMigrations) {
			EntityCacheUtil.removeResult(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
				SimulationExeStsMigrationImpl.class,
				simulationExeStsMigration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new simulation exe sts migration with the primary key. Does not add the simulation exe sts migration to the database.
	 *
	 * @param simulationExeStsMigrationPK the primary key for the new simulation exe sts migration
	 * @return the new simulation exe sts migration
	 */
	@Override
	public SimulationExeStsMigration create(
		SimulationExeStsMigrationPK simulationExeStsMigrationPK) {
		SimulationExeStsMigration simulationExeStsMigration = new SimulationExeStsMigrationImpl();

		simulationExeStsMigration.setNew(true);
		simulationExeStsMigration.setPrimaryKey(simulationExeStsMigrationPK);

		return simulationExeStsMigration;
	}

	/**
	 * Removes the simulation exe sts migration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param simulationExeStsMigrationPK the primary key of the simulation exe sts migration
	 * @return the simulation exe sts migration that was removed
	 * @throws org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException if a simulation exe sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationExeStsMigration remove(
		SimulationExeStsMigrationPK simulationExeStsMigrationPK)
		throws NoSuchSimulationExeStsMigrationException, SystemException {
		return remove((Serializable)simulationExeStsMigrationPK);
	}

	/**
	 * Removes the simulation exe sts migration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the simulation exe sts migration
	 * @return the simulation exe sts migration that was removed
	 * @throws org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException if a simulation exe sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationExeStsMigration remove(Serializable primaryKey)
		throws NoSuchSimulationExeStsMigrationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SimulationExeStsMigration simulationExeStsMigration = (SimulationExeStsMigration)session.get(SimulationExeStsMigrationImpl.class,
					primaryKey);

			if (simulationExeStsMigration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSimulationExeStsMigrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(simulationExeStsMigration);
		}
		catch (NoSuchSimulationExeStsMigrationException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SimulationExeStsMigration removeImpl(
		SimulationExeStsMigration simulationExeStsMigration)
		throws SystemException {
		simulationExeStsMigration = toUnwrappedModel(simulationExeStsMigration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(simulationExeStsMigration)) {
				simulationExeStsMigration = (SimulationExeStsMigration)session.get(SimulationExeStsMigrationImpl.class,
						simulationExeStsMigration.getPrimaryKeyObj());
			}

			if (simulationExeStsMigration != null) {
				session.delete(simulationExeStsMigration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (simulationExeStsMigration != null) {
			clearCache(simulationExeStsMigration);
		}

		return simulationExeStsMigration;
	}

	@Override
	public SimulationExeStsMigration updateImpl(
		org.kisti.edison.bestsimulation.model.SimulationExeStsMigration simulationExeStsMigration)
		throws SystemException {
		simulationExeStsMigration = toUnwrappedModel(simulationExeStsMigration);

		boolean isNew = simulationExeStsMigration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (simulationExeStsMigration.isNew()) {
				session.save(simulationExeStsMigration);

				simulationExeStsMigration.setNew(false);
			}
			else {
				session.merge(simulationExeStsMigration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			SimulationExeStsMigrationImpl.class,
			simulationExeStsMigration.getPrimaryKey(), simulationExeStsMigration);

		return simulationExeStsMigration;
	}

	protected SimulationExeStsMigration toUnwrappedModel(
		SimulationExeStsMigration simulationExeStsMigration) {
		if (simulationExeStsMigration instanceof SimulationExeStsMigrationImpl) {
			return simulationExeStsMigration;
		}

		SimulationExeStsMigrationImpl simulationExeStsMigrationImpl = new SimulationExeStsMigrationImpl();

		simulationExeStsMigrationImpl.setNew(simulationExeStsMigration.isNew());
		simulationExeStsMigrationImpl.setPrimaryKey(simulationExeStsMigration.getPrimaryKey());

		simulationExeStsMigrationImpl.setScienceAppId(simulationExeStsMigration.getScienceAppId());
		simulationExeStsMigrationImpl.setGroupId(simulationExeStsMigration.getGroupId());
		simulationExeStsMigrationImpl.setSubmitDate(simulationExeStsMigration.getSubmitDate());
		simulationExeStsMigrationImpl.setUserCnt(simulationExeStsMigration.getUserCnt());
		simulationExeStsMigrationImpl.setJobCnt(simulationExeStsMigration.getJobCnt());
		simulationExeStsMigrationImpl.setRuntime(simulationExeStsMigration.getRuntime());

		return simulationExeStsMigrationImpl;
	}

	/**
	 * Returns the simulation exe sts migration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the simulation exe sts migration
	 * @return the simulation exe sts migration
	 * @throws org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException if a simulation exe sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationExeStsMigration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSimulationExeStsMigrationException, SystemException {
		SimulationExeStsMigration simulationExeStsMigration = fetchByPrimaryKey(primaryKey);

		if (simulationExeStsMigration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSimulationExeStsMigrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return simulationExeStsMigration;
	}

	/**
	 * Returns the simulation exe sts migration with the primary key or throws a {@link org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException} if it could not be found.
	 *
	 * @param simulationExeStsMigrationPK the primary key of the simulation exe sts migration
	 * @return the simulation exe sts migration
	 * @throws org.kisti.edison.bestsimulation.NoSuchSimulationExeStsMigrationException if a simulation exe sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationExeStsMigration findByPrimaryKey(
		SimulationExeStsMigrationPK simulationExeStsMigrationPK)
		throws NoSuchSimulationExeStsMigrationException, SystemException {
		return findByPrimaryKey((Serializable)simulationExeStsMigrationPK);
	}

	/**
	 * Returns the simulation exe sts migration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the simulation exe sts migration
	 * @return the simulation exe sts migration, or <code>null</code> if a simulation exe sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationExeStsMigration fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SimulationExeStsMigration simulationExeStsMigration = (SimulationExeStsMigration)EntityCacheUtil.getResult(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
				SimulationExeStsMigrationImpl.class, primaryKey);

		if (simulationExeStsMigration == _nullSimulationExeStsMigration) {
			return null;
		}

		if (simulationExeStsMigration == null) {
			Session session = null;

			try {
				session = openSession();

				simulationExeStsMigration = (SimulationExeStsMigration)session.get(SimulationExeStsMigrationImpl.class,
						primaryKey);

				if (simulationExeStsMigration != null) {
					cacheResult(simulationExeStsMigration);
				}
				else {
					EntityCacheUtil.putResult(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
						SimulationExeStsMigrationImpl.class, primaryKey,
						_nullSimulationExeStsMigration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SimulationExeStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
					SimulationExeStsMigrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return simulationExeStsMigration;
	}

	/**
	 * Returns the simulation exe sts migration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param simulationExeStsMigrationPK the primary key of the simulation exe sts migration
	 * @return the simulation exe sts migration, or <code>null</code> if a simulation exe sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationExeStsMigration fetchByPrimaryKey(
		SimulationExeStsMigrationPK simulationExeStsMigrationPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)simulationExeStsMigrationPK);
	}

	/**
	 * Returns all the simulation exe sts migrations.
	 *
	 * @return the simulation exe sts migrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SimulationExeStsMigration> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SimulationExeStsMigration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<SimulationExeStsMigration> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SimulationExeStsMigration> list = (List<SimulationExeStsMigration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SIMULATIONEXESTSMIGRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SIMULATIONEXESTSMIGRATION;

				if (pagination) {
					sql = sql.concat(SimulationExeStsMigrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SimulationExeStsMigration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SimulationExeStsMigration>(list);
				}
				else {
					list = (List<SimulationExeStsMigration>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the simulation exe sts migrations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SimulationExeStsMigration simulationExeStsMigration : findAll()) {
			remove(simulationExeStsMigration);
		}
	}

	/**
	 * Returns the number of simulation exe sts migrations.
	 *
	 * @return the number of simulation exe sts migrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SIMULATIONEXESTSMIGRATION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the simulation exe sts migration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.bestsimulation.model.SimulationExeStsMigration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SimulationExeStsMigration>> listenersList = new ArrayList<ModelListener<SimulationExeStsMigration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SimulationExeStsMigration>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SimulationExeStsMigrationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SIMULATIONEXESTSMIGRATION = "SELECT simulationExeStsMigration FROM SimulationExeStsMigration simulationExeStsMigration";
	private static final String _SQL_COUNT_SIMULATIONEXESTSMIGRATION = "SELECT COUNT(simulationExeStsMigration) FROM SimulationExeStsMigration simulationExeStsMigration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "simulationExeStsMigration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SimulationExeStsMigration exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SimulationExeStsMigrationPersistenceImpl.class);
	private static SimulationExeStsMigration _nullSimulationExeStsMigration = new SimulationExeStsMigrationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SimulationExeStsMigration> toCacheModel() {
				return _nullSimulationExeStsMigrationCacheModel;
			}
		};

	private static CacheModel<SimulationExeStsMigration> _nullSimulationExeStsMigrationCacheModel =
		new CacheModel<SimulationExeStsMigration>() {
			@Override
			public SimulationExeStsMigration toEntityModel() {
				return _nullSimulationExeStsMigration;
			}
		};
}