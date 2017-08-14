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

package org.kisti.edison.virtuallaboratory.service.persistence;

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

import org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassStsMigrationException;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClassStsMigration;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassStsMigrationImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassStsMigrationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the virtual lab class sts migration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabClassStsMigrationPersistence
 * @see VirtualLabClassStsMigrationUtil
 * @generated
 */
public class VirtualLabClassStsMigrationPersistenceImpl
	extends BasePersistenceImpl<VirtualLabClassStsMigration>
	implements VirtualLabClassStsMigrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VirtualLabClassStsMigrationUtil} to access the virtual lab class sts migration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VirtualLabClassStsMigrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassStsMigrationModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabClassStsMigrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassStsMigrationModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabClassStsMigrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassStsMigrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public VirtualLabClassStsMigrationPersistenceImpl() {
		setModelClass(VirtualLabClassStsMigration.class);
	}

	/**
	 * Caches the virtual lab class sts migration in the entity cache if it is enabled.
	 *
	 * @param virtualLabClassStsMigration the virtual lab class sts migration
	 */
	@Override
	public void cacheResult(
		VirtualLabClassStsMigration virtualLabClassStsMigration) {
		EntityCacheUtil.putResult(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassStsMigrationImpl.class,
			virtualLabClassStsMigration.getPrimaryKey(),
			virtualLabClassStsMigration);

		virtualLabClassStsMigration.resetOriginalValues();
	}

	/**
	 * Caches the virtual lab class sts migrations in the entity cache if it is enabled.
	 *
	 * @param virtualLabClassStsMigrations the virtual lab class sts migrations
	 */
	@Override
	public void cacheResult(
		List<VirtualLabClassStsMigration> virtualLabClassStsMigrations) {
		for (VirtualLabClassStsMigration virtualLabClassStsMigration : virtualLabClassStsMigrations) {
			if (EntityCacheUtil.getResult(
						VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabClassStsMigrationImpl.class,
						virtualLabClassStsMigration.getPrimaryKey()) == null) {
				cacheResult(virtualLabClassStsMigration);
			}
			else {
				virtualLabClassStsMigration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all virtual lab class sts migrations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VirtualLabClassStsMigrationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VirtualLabClassStsMigrationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the virtual lab class sts migration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		VirtualLabClassStsMigration virtualLabClassStsMigration) {
		EntityCacheUtil.removeResult(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassStsMigrationImpl.class,
			virtualLabClassStsMigration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<VirtualLabClassStsMigration> virtualLabClassStsMigrations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VirtualLabClassStsMigration virtualLabClassStsMigration : virtualLabClassStsMigrations) {
			EntityCacheUtil.removeResult(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabClassStsMigrationImpl.class,
				virtualLabClassStsMigration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new virtual lab class sts migration with the primary key. Does not add the virtual lab class sts migration to the database.
	 *
	 * @param virtualLabClassStsMigrationPK the primary key for the new virtual lab class sts migration
	 * @return the new virtual lab class sts migration
	 */
	@Override
	public VirtualLabClassStsMigration create(
		VirtualLabClassStsMigrationPK virtualLabClassStsMigrationPK) {
		VirtualLabClassStsMigration virtualLabClassStsMigration = new VirtualLabClassStsMigrationImpl();

		virtualLabClassStsMigration.setNew(true);
		virtualLabClassStsMigration.setPrimaryKey(virtualLabClassStsMigrationPK);

		return virtualLabClassStsMigration;
	}

	/**
	 * Removes the virtual lab class sts migration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param virtualLabClassStsMigrationPK the primary key of the virtual lab class sts migration
	 * @return the virtual lab class sts migration that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassStsMigrationException if a virtual lab class sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassStsMigration remove(
		VirtualLabClassStsMigrationPK virtualLabClassStsMigrationPK)
		throws NoSuchVirtualLabClassStsMigrationException, SystemException {
		return remove((Serializable)virtualLabClassStsMigrationPK);
	}

	/**
	 * Removes the virtual lab class sts migration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the virtual lab class sts migration
	 * @return the virtual lab class sts migration that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassStsMigrationException if a virtual lab class sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassStsMigration remove(Serializable primaryKey)
		throws NoSuchVirtualLabClassStsMigrationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VirtualLabClassStsMigration virtualLabClassStsMigration = (VirtualLabClassStsMigration)session.get(VirtualLabClassStsMigrationImpl.class,
					primaryKey);

			if (virtualLabClassStsMigration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVirtualLabClassStsMigrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(virtualLabClassStsMigration);
		}
		catch (NoSuchVirtualLabClassStsMigrationException nsee) {
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
	protected VirtualLabClassStsMigration removeImpl(
		VirtualLabClassStsMigration virtualLabClassStsMigration)
		throws SystemException {
		virtualLabClassStsMigration = toUnwrappedModel(virtualLabClassStsMigration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(virtualLabClassStsMigration)) {
				virtualLabClassStsMigration = (VirtualLabClassStsMigration)session.get(VirtualLabClassStsMigrationImpl.class,
						virtualLabClassStsMigration.getPrimaryKeyObj());
			}

			if (virtualLabClassStsMigration != null) {
				session.delete(virtualLabClassStsMigration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (virtualLabClassStsMigration != null) {
			clearCache(virtualLabClassStsMigration);
		}

		return virtualLabClassStsMigration;
	}

	@Override
	public VirtualLabClassStsMigration updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassStsMigration virtualLabClassStsMigration)
		throws SystemException {
		virtualLabClassStsMigration = toUnwrappedModel(virtualLabClassStsMigration);

		boolean isNew = virtualLabClassStsMigration.isNew();

		Session session = null;

		try {
			session = openSession();

			if (virtualLabClassStsMigration.isNew()) {
				session.save(virtualLabClassStsMigration);

				virtualLabClassStsMigration.setNew(false);
			}
			else {
				session.merge(virtualLabClassStsMigration);
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

		EntityCacheUtil.putResult(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassStsMigrationImpl.class,
			virtualLabClassStsMigration.getPrimaryKey(),
			virtualLabClassStsMigration);

		return virtualLabClassStsMigration;
	}

	protected VirtualLabClassStsMigration toUnwrappedModel(
		VirtualLabClassStsMigration virtualLabClassStsMigration) {
		if (virtualLabClassStsMigration instanceof VirtualLabClassStsMigrationImpl) {
			return virtualLabClassStsMigration;
		}

		VirtualLabClassStsMigrationImpl virtualLabClassStsMigrationImpl = new VirtualLabClassStsMigrationImpl();

		virtualLabClassStsMigrationImpl.setNew(virtualLabClassStsMigration.isNew());
		virtualLabClassStsMigrationImpl.setPrimaryKey(virtualLabClassStsMigration.getPrimaryKey());

		virtualLabClassStsMigrationImpl.setGroupId(virtualLabClassStsMigration.getGroupId());
		virtualLabClassStsMigrationImpl.setVirtualLabId(virtualLabClassStsMigration.getVirtualLabId());
		virtualLabClassStsMigrationImpl.setClassId(virtualLabClassStsMigration.getClassId());
		virtualLabClassStsMigrationImpl.setUniversityField(virtualLabClassStsMigration.getUniversityField());
		virtualLabClassStsMigrationImpl.setVirtualLabTitle(virtualLabClassStsMigration.getVirtualLabTitle());
		virtualLabClassStsMigrationImpl.setVirtualLabPersonName(virtualLabClassStsMigration.getVirtualLabPersonName());
		virtualLabClassStsMigrationImpl.setClassTitle(virtualLabClassStsMigration.getClassTitle());
		virtualLabClassStsMigrationImpl.setVirtualClassCd(virtualLabClassStsMigration.getVirtualClassCd());
		virtualLabClassStsMigrationImpl.setClassCreateDt(virtualLabClassStsMigration.getClassCreateDt());
		virtualLabClassStsMigrationImpl.setScienceAppId(virtualLabClassStsMigration.getScienceAppId());
		virtualLabClassStsMigrationImpl.setScienceAppName(virtualLabClassStsMigration.getScienceAppName());
		virtualLabClassStsMigrationImpl.setRegisterStudentCnt(virtualLabClassStsMigration.getRegisterStudentCnt());
		virtualLabClassStsMigrationImpl.setExecuteCount(virtualLabClassStsMigration.getExecuteCount());
		virtualLabClassStsMigrationImpl.setExecuteStudentcount(virtualLabClassStsMigration.getExecuteStudentcount());
		virtualLabClassStsMigrationImpl.setAvgerageRuntime(virtualLabClassStsMigration.getAvgerageRuntime());
		virtualLabClassStsMigrationImpl.setCputime(virtualLabClassStsMigration.getCputime());

		return virtualLabClassStsMigrationImpl;
	}

	/**
	 * Returns the virtual lab class sts migration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab class sts migration
	 * @return the virtual lab class sts migration
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassStsMigrationException if a virtual lab class sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassStsMigration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVirtualLabClassStsMigrationException, SystemException {
		VirtualLabClassStsMigration virtualLabClassStsMigration = fetchByPrimaryKey(primaryKey);

		if (virtualLabClassStsMigration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVirtualLabClassStsMigrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return virtualLabClassStsMigration;
	}

	/**
	 * Returns the virtual lab class sts migration with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassStsMigrationException} if it could not be found.
	 *
	 * @param virtualLabClassStsMigrationPK the primary key of the virtual lab class sts migration
	 * @return the virtual lab class sts migration
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassStsMigrationException if a virtual lab class sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassStsMigration findByPrimaryKey(
		VirtualLabClassStsMigrationPK virtualLabClassStsMigrationPK)
		throws NoSuchVirtualLabClassStsMigrationException, SystemException {
		return findByPrimaryKey((Serializable)virtualLabClassStsMigrationPK);
	}

	/**
	 * Returns the virtual lab class sts migration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab class sts migration
	 * @return the virtual lab class sts migration, or <code>null</code> if a virtual lab class sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassStsMigration fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		VirtualLabClassStsMigration virtualLabClassStsMigration = (VirtualLabClassStsMigration)EntityCacheUtil.getResult(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabClassStsMigrationImpl.class, primaryKey);

		if (virtualLabClassStsMigration == _nullVirtualLabClassStsMigration) {
			return null;
		}

		if (virtualLabClassStsMigration == null) {
			Session session = null;

			try {
				session = openSession();

				virtualLabClassStsMigration = (VirtualLabClassStsMigration)session.get(VirtualLabClassStsMigrationImpl.class,
						primaryKey);

				if (virtualLabClassStsMigration != null) {
					cacheResult(virtualLabClassStsMigration);
				}
				else {
					EntityCacheUtil.putResult(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabClassStsMigrationImpl.class, primaryKey,
						_nullVirtualLabClassStsMigration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VirtualLabClassStsMigrationModelImpl.ENTITY_CACHE_ENABLED,
					VirtualLabClassStsMigrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return virtualLabClassStsMigration;
	}

	/**
	 * Returns the virtual lab class sts migration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param virtualLabClassStsMigrationPK the primary key of the virtual lab class sts migration
	 * @return the virtual lab class sts migration, or <code>null</code> if a virtual lab class sts migration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassStsMigration fetchByPrimaryKey(
		VirtualLabClassStsMigrationPK virtualLabClassStsMigrationPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)virtualLabClassStsMigrationPK);
	}

	/**
	 * Returns all the virtual lab class sts migrations.
	 *
	 * @return the virtual lab class sts migrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabClassStsMigration> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the virtual lab class sts migrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassStsMigrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab class sts migrations
	 * @param end the upper bound of the range of virtual lab class sts migrations (not inclusive)
	 * @return the range of virtual lab class sts migrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabClassStsMigration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab class sts migrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassStsMigrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab class sts migrations
	 * @param end the upper bound of the range of virtual lab class sts migrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab class sts migrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabClassStsMigration> findAll(int start, int end,
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

		List<VirtualLabClassStsMigration> list = (List<VirtualLabClassStsMigration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIRTUALLABCLASSSTSMIGRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIRTUALLABCLASSSTSMIGRATION;

				if (pagination) {
					sql = sql.concat(VirtualLabClassStsMigrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VirtualLabClassStsMigration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VirtualLabClassStsMigration>(list);
				}
				else {
					list = (List<VirtualLabClassStsMigration>)QueryUtil.list(q,
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
	 * Removes all the virtual lab class sts migrations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VirtualLabClassStsMigration virtualLabClassStsMigration : findAll()) {
			remove(virtualLabClassStsMigration);
		}
	}

	/**
	 * Returns the number of virtual lab class sts migrations.
	 *
	 * @return the number of virtual lab class sts migrations
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

				Query q = session.createQuery(_SQL_COUNT_VIRTUALLABCLASSSTSMIGRATION);

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
	 * Initializes the virtual lab class sts migration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.virtuallaboratory.model.VirtualLabClassStsMigration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VirtualLabClassStsMigration>> listenersList = new ArrayList<ModelListener<VirtualLabClassStsMigration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VirtualLabClassStsMigration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VirtualLabClassStsMigrationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIRTUALLABCLASSSTSMIGRATION = "SELECT virtualLabClassStsMigration FROM VirtualLabClassStsMigration virtualLabClassStsMigration";
	private static final String _SQL_COUNT_VIRTUALLABCLASSSTSMIGRATION = "SELECT COUNT(virtualLabClassStsMigration) FROM VirtualLabClassStsMigration virtualLabClassStsMigration";
	private static final String _ORDER_BY_ENTITY_ALIAS = "virtualLabClassStsMigration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VirtualLabClassStsMigration exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VirtualLabClassStsMigrationPersistenceImpl.class);
	private static VirtualLabClassStsMigration _nullVirtualLabClassStsMigration = new VirtualLabClassStsMigrationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VirtualLabClassStsMigration> toCacheModel() {
				return _nullVirtualLabClassStsMigrationCacheModel;
			}
		};

	private static CacheModel<VirtualLabClassStsMigration> _nullVirtualLabClassStsMigrationCacheModel =
		new CacheModel<VirtualLabClassStsMigration>() {
			@Override
			public VirtualLabClassStsMigration toEntityModel() {
				return _nullVirtualLabClassStsMigration;
			}
		};
}