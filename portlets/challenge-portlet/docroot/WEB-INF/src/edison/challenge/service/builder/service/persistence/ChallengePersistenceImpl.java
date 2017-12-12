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

import edison.challenge.service.builder.NoSuchChallengeException;
import edison.challenge.service.builder.model.Challenge;
import edison.challenge.service.builder.model.impl.ChallengeImpl;
import edison.challenge.service.builder.model.impl.ChallengeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the challenge service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kyj
 * @see ChallengePersistence
 * @see ChallengeUtil
 * @generated
 */
public class ChallengePersistenceImpl extends BasePersistenceImpl<Challenge>
	implements ChallengePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChallengeUtil} to access the challenge persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChallengeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
			ChallengeModelImpl.FINDER_CACHE_ENABLED, ChallengeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
			ChallengeModelImpl.FINDER_CACHE_ENABLED, ChallengeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
			ChallengeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ChallengePersistenceImpl() {
		setModelClass(Challenge.class);
	}

	/**
	 * Caches the challenge in the entity cache if it is enabled.
	 *
	 * @param challenge the challenge
	 */
	@Override
	public void cacheResult(Challenge challenge) {
		EntityCacheUtil.putResult(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
			ChallengeImpl.class, challenge.getPrimaryKey(), challenge);

		challenge.resetOriginalValues();
	}

	/**
	 * Caches the challenges in the entity cache if it is enabled.
	 *
	 * @param challenges the challenges
	 */
	@Override
	public void cacheResult(List<Challenge> challenges) {
		for (Challenge challenge : challenges) {
			if (EntityCacheUtil.getResult(
						ChallengeModelImpl.ENTITY_CACHE_ENABLED,
						ChallengeImpl.class, challenge.getPrimaryKey()) == null) {
				cacheResult(challenge);
			}
			else {
				challenge.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all challenges.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChallengeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChallengeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the challenge.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Challenge challenge) {
		EntityCacheUtil.removeResult(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
			ChallengeImpl.class, challenge.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Challenge> challenges) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Challenge challenge : challenges) {
			EntityCacheUtil.removeResult(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
				ChallengeImpl.class, challenge.getPrimaryKey());
		}
	}

	/**
	 * Creates a new challenge with the primary key. Does not add the challenge to the database.
	 *
	 * @param challengeid the primary key for the new challenge
	 * @return the new challenge
	 */
	@Override
	public Challenge create(long challengeid) {
		Challenge challenge = new ChallengeImpl();

		challenge.setNew(true);
		challenge.setPrimaryKey(challengeid);

		return challenge;
	}

	/**
	 * Removes the challenge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param challengeid the primary key of the challenge
	 * @return the challenge that was removed
	 * @throws edison.challenge.service.builder.NoSuchChallengeException if a challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge remove(long challengeid)
		throws NoSuchChallengeException, SystemException {
		return remove((Serializable)challengeid);
	}

	/**
	 * Removes the challenge with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the challenge
	 * @return the challenge that was removed
	 * @throws edison.challenge.service.builder.NoSuchChallengeException if a challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge remove(Serializable primaryKey)
		throws NoSuchChallengeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Challenge challenge = (Challenge)session.get(ChallengeImpl.class,
					primaryKey);

			if (challenge == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChallengeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(challenge);
		}
		catch (NoSuchChallengeException nsee) {
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
	protected Challenge removeImpl(Challenge challenge)
		throws SystemException {
		challenge = toUnwrappedModel(challenge);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(challenge)) {
				challenge = (Challenge)session.get(ChallengeImpl.class,
						challenge.getPrimaryKeyObj());
			}

			if (challenge != null) {
				session.delete(challenge);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (challenge != null) {
			clearCache(challenge);
		}

		return challenge;
	}

	@Override
	public Challenge updateImpl(
		edison.challenge.service.builder.model.Challenge challenge)
		throws SystemException {
		challenge = toUnwrappedModel(challenge);

		boolean isNew = challenge.isNew();

		Session session = null;

		try {
			session = openSession();

			if (challenge.isNew()) {
				session.save(challenge);

				challenge.setNew(false);
			}
			else {
				session.merge(challenge);
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

		EntityCacheUtil.putResult(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
			ChallengeImpl.class, challenge.getPrimaryKey(), challenge);

		return challenge;
	}

	protected Challenge toUnwrappedModel(Challenge challenge) {
		if (challenge instanceof ChallengeImpl) {
			return challenge;
		}

		ChallengeImpl challengeImpl = new ChallengeImpl();

		challengeImpl.setNew(challenge.isNew());
		challengeImpl.setPrimaryKey(challenge.getPrimaryKey());

		challengeImpl.setChallengeid(challenge.getChallengeid());
		challengeImpl.setName(challenge.getName());
		challengeImpl.setDescription(challenge.getDescription());

		return challengeImpl;
	}

	/**
	 * Returns the challenge with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the challenge
	 * @return the challenge
	 * @throws edison.challenge.service.builder.NoSuchChallengeException if a challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChallengeException, SystemException {
		Challenge challenge = fetchByPrimaryKey(primaryKey);

		if (challenge == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChallengeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return challenge;
	}

	/**
	 * Returns the challenge with the primary key or throws a {@link edison.challenge.service.builder.NoSuchChallengeException} if it could not be found.
	 *
	 * @param challengeid the primary key of the challenge
	 * @return the challenge
	 * @throws edison.challenge.service.builder.NoSuchChallengeException if a challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge findByPrimaryKey(long challengeid)
		throws NoSuchChallengeException, SystemException {
		return findByPrimaryKey((Serializable)challengeid);
	}

	/**
	 * Returns the challenge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the challenge
	 * @return the challenge, or <code>null</code> if a challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Challenge challenge = (Challenge)EntityCacheUtil.getResult(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
				ChallengeImpl.class, primaryKey);

		if (challenge == _nullChallenge) {
			return null;
		}

		if (challenge == null) {
			Session session = null;

			try {
				session = openSession();

				challenge = (Challenge)session.get(ChallengeImpl.class,
						primaryKey);

				if (challenge != null) {
					cacheResult(challenge);
				}
				else {
					EntityCacheUtil.putResult(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
						ChallengeImpl.class, primaryKey, _nullChallenge);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ChallengeModelImpl.ENTITY_CACHE_ENABLED,
					ChallengeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return challenge;
	}

	/**
	 * Returns the challenge with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param challengeid the primary key of the challenge
	 * @return the challenge, or <code>null</code> if a challenge with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Challenge fetchByPrimaryKey(long challengeid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)challengeid);
	}

	/**
	 * Returns all the challenges.
	 *
	 * @return the challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Challenge> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the challenges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.ChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @return the range of challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Challenge> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the challenges.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link edison.challenge.service.builder.model.impl.ChallengeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of challenges
	 * @param end the upper bound of the range of challenges (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of challenges
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Challenge> findAll(int start, int end,
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

		List<Challenge> list = (List<Challenge>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHALLENGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHALLENGE;

				if (pagination) {
					sql = sql.concat(ChallengeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Challenge>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Challenge>(list);
				}
				else {
					list = (List<Challenge>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the challenges from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Challenge challenge : findAll()) {
			remove(challenge);
		}
	}

	/**
	 * Returns the number of challenges.
	 *
	 * @return the number of challenges
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

				Query q = session.createQuery(_SQL_COUNT_CHALLENGE);

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
	 * Initializes the challenge persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.edison.challenge.service.builder.model.Challenge")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Challenge>> listenersList = new ArrayList<ModelListener<Challenge>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Challenge>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChallengeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CHALLENGE = "SELECT challenge FROM Challenge challenge";
	private static final String _SQL_COUNT_CHALLENGE = "SELECT COUNT(challenge) FROM Challenge challenge";
	private static final String _ORDER_BY_ENTITY_ALIAS = "challenge.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Challenge exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChallengePersistenceImpl.class);
	private static Challenge _nullChallenge = new ChallengeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Challenge> toCacheModel() {
				return _nullChallengeCacheModel;
			}
		};

	private static CacheModel<Challenge> _nullChallengeCacheModel = new CacheModel<Challenge>() {
			@Override
			public Challenge toEntityModel() {
				return _nullChallenge;
			}
		};
}