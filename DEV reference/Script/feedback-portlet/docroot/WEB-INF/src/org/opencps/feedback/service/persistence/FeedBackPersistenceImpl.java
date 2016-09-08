/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.feedback.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.opencps.feedback.NoSuchFeedBackException;
import org.opencps.feedback.model.FeedBack;
import org.opencps.feedback.model.impl.FeedBackImpl;
import org.opencps.feedback.model.impl.FeedBackModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the feed back service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see FeedBackPersistence
 * @see FeedBackUtil
 * @generated
 */
public class FeedBackPersistenceImpl extends BasePersistenceImpl<FeedBack>
	implements FeedBackPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FeedBackUtil} to access the feed back persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FeedBackImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
			FeedBackModelImpl.FINDER_CACHE_ENABLED, FeedBackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
			FeedBackModelImpl.FINDER_CACHE_ENABLED, FeedBackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
			FeedBackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAIL = new FinderPath(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
			FeedBackModelImpl.FINDER_CACHE_ENABLED, FeedBackImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] { String.class.getName() },
			FeedBackModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
			FeedBackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns the feed back where email = &#63; or throws a {@link org.opencps.feedback.NoSuchFeedBackException} if it could not be found.
	 *
	 * @param email the email
	 * @return the matching feed back
	 * @throws org.opencps.feedback.NoSuchFeedBackException if a matching feed back could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack findByEmail(String email)
		throws NoSuchFeedBackException, SystemException {
		FeedBack feedBack = fetchByEmail(email);

		if (feedBack == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFeedBackException(msg.toString());
		}

		return feedBack;
	}

	/**
	 * Returns the feed back where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching feed back, or <code>null</code> if a matching feed back could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack fetchByEmail(String email) throws SystemException {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the feed back where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching feed back, or <code>null</code> if a matching feed back could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack fetchByEmail(String email, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { email };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs, this);
		}

		if (result instanceof FeedBack) {
			FeedBack feedBack = (FeedBack)result;

			if (!Validator.equals(email, feedBack.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				List<FeedBack> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FeedBackPersistenceImpl.fetchByEmail(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					FeedBack feedBack = list.get(0);

					result = feedBack;

					cacheResult(feedBack);

					if ((feedBack.getEmail() == null) ||
							!feedBack.getEmail().equals(email)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
							finderArgs, feedBack);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (FeedBack)result;
		}
	}

	/**
	 * Removes the feed back where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the feed back that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack removeByEmail(String email)
		throws NoSuchFeedBackException, SystemException {
		FeedBack feedBack = findByEmail(email);

		return remove(feedBack);
	}

	/**
	 * Returns the number of feed backs where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching feed backs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmail(String email) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { email };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "feedBack.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "feedBack.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(feedBack.email IS NULL OR feedBack.email = '')";

	public FeedBackPersistenceImpl() {
		setModelClass(FeedBack.class);
	}

	/**
	 * Caches the feed back in the entity cache if it is enabled.
	 *
	 * @param feedBack the feed back
	 */
	@Override
	public void cacheResult(FeedBack feedBack) {
		EntityCacheUtil.putResult(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
			FeedBackImpl.class, feedBack.getPrimaryKey(), feedBack);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { feedBack.getEmail() }, feedBack);

		feedBack.resetOriginalValues();
	}

	/**
	 * Caches the feed backs in the entity cache if it is enabled.
	 *
	 * @param feedBacks the feed backs
	 */
	@Override
	public void cacheResult(List<FeedBack> feedBacks) {
		for (FeedBack feedBack : feedBacks) {
			if (EntityCacheUtil.getResult(
						FeedBackModelImpl.ENTITY_CACHE_ENABLED,
						FeedBackImpl.class, feedBack.getPrimaryKey()) == null) {
				cacheResult(feedBack);
			}
			else {
				feedBack.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all feed backs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FeedBackImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FeedBackImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the feed back.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FeedBack feedBack) {
		EntityCacheUtil.removeResult(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
			FeedBackImpl.class, feedBack.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(feedBack);
	}

	@Override
	public void clearCache(List<FeedBack> feedBacks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FeedBack feedBack : feedBacks) {
			EntityCacheUtil.removeResult(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
				FeedBackImpl.class, feedBack.getPrimaryKey());

			clearUniqueFindersCache(feedBack);
		}
	}

	protected void cacheUniqueFindersCache(FeedBack feedBack) {
		if (feedBack.isNew()) {
			Object[] args = new Object[] { feedBack.getEmail() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL, args, feedBack);
		}
		else {
			FeedBackModelImpl feedBackModelImpl = (FeedBackModelImpl)feedBack;

			if ((feedBackModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { feedBack.getEmail() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
					feedBack);
			}
		}
	}

	protected void clearUniqueFindersCache(FeedBack feedBack) {
		FeedBackModelImpl feedBackModelImpl = (FeedBackModelImpl)feedBack;

		Object[] args = new Object[] { feedBack.getEmail() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);

		if ((feedBackModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
			args = new Object[] { feedBackModelImpl.getOriginalEmail() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);
		}
	}

	/**
	 * Creates a new feed back with the primary key. Does not add the feed back to the database.
	 *
	 * @param feedbackId the primary key for the new feed back
	 * @return the new feed back
	 */
	@Override
	public FeedBack create(long feedbackId) {
		FeedBack feedBack = new FeedBackImpl();

		feedBack.setNew(true);
		feedBack.setPrimaryKey(feedbackId);

		return feedBack;
	}

	/**
	 * Removes the feed back with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedbackId the primary key of the feed back
	 * @return the feed back that was removed
	 * @throws org.opencps.feedback.NoSuchFeedBackException if a feed back with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack remove(long feedbackId)
		throws NoSuchFeedBackException, SystemException {
		return remove((Serializable)feedbackId);
	}

	/**
	 * Removes the feed back with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feed back
	 * @return the feed back that was removed
	 * @throws org.opencps.feedback.NoSuchFeedBackException if a feed back with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack remove(Serializable primaryKey)
		throws NoSuchFeedBackException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FeedBack feedBack = (FeedBack)session.get(FeedBackImpl.class,
					primaryKey);

			if (feedBack == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeedBackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(feedBack);
		}
		catch (NoSuchFeedBackException nsee) {
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
	protected FeedBack removeImpl(FeedBack feedBack) throws SystemException {
		feedBack = toUnwrappedModel(feedBack);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feedBack)) {
				feedBack = (FeedBack)session.get(FeedBackImpl.class,
						feedBack.getPrimaryKeyObj());
			}

			if (feedBack != null) {
				session.delete(feedBack);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (feedBack != null) {
			clearCache(feedBack);
		}

		return feedBack;
	}

	@Override
	public FeedBack updateImpl(org.opencps.feedback.model.FeedBack feedBack)
		throws SystemException {
		feedBack = toUnwrappedModel(feedBack);

		boolean isNew = feedBack.isNew();

		Session session = null;

		try {
			session = openSession();

			if (feedBack.isNew()) {
				session.save(feedBack);

				feedBack.setNew(false);
			}
			else {
				session.merge(feedBack);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FeedBackModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
			FeedBackImpl.class, feedBack.getPrimaryKey(), feedBack);

		clearUniqueFindersCache(feedBack);
		cacheUniqueFindersCache(feedBack);

		return feedBack;
	}

	protected FeedBack toUnwrappedModel(FeedBack feedBack) {
		if (feedBack instanceof FeedBackImpl) {
			return feedBack;
		}

		FeedBackImpl feedBackImpl = new FeedBackImpl();

		feedBackImpl.setNew(feedBack.isNew());
		feedBackImpl.setPrimaryKey(feedBack.getPrimaryKey());

		feedBackImpl.setFeedbackId(feedBack.getFeedbackId());
		feedBackImpl.setGroupId(feedBack.getGroupId());
		feedBackImpl.setCompanyId(feedBack.getCompanyId());
		feedBackImpl.setUserId(feedBack.getUserId());
		feedBackImpl.setUserName(feedBack.getUserName());
		feedBackImpl.setCreateDate(feedBack.getCreateDate());
		feedBackImpl.setModifiedDate(feedBack.getModifiedDate());
		feedBackImpl.setFullName(feedBack.getFullName());
		feedBackImpl.setEmail(feedBack.getEmail());
		feedBackImpl.setFeedBack(feedBack.getFeedBack());

		return feedBackImpl;
	}

	/**
	 * Returns the feed back with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the feed back
	 * @return the feed back
	 * @throws org.opencps.feedback.NoSuchFeedBackException if a feed back with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeedBackException, SystemException {
		FeedBack feedBack = fetchByPrimaryKey(primaryKey);

		if (feedBack == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeedBackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return feedBack;
	}

	/**
	 * Returns the feed back with the primary key or throws a {@link org.opencps.feedback.NoSuchFeedBackException} if it could not be found.
	 *
	 * @param feedbackId the primary key of the feed back
	 * @return the feed back
	 * @throws org.opencps.feedback.NoSuchFeedBackException if a feed back with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack findByPrimaryKey(long feedbackId)
		throws NoSuchFeedBackException, SystemException {
		return findByPrimaryKey((Serializable)feedbackId);
	}

	/**
	 * Returns the feed back with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feed back
	 * @return the feed back, or <code>null</code> if a feed back with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FeedBack feedBack = (FeedBack)EntityCacheUtil.getResult(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
				FeedBackImpl.class, primaryKey);

		if (feedBack == _nullFeedBack) {
			return null;
		}

		if (feedBack == null) {
			Session session = null;

			try {
				session = openSession();

				feedBack = (FeedBack)session.get(FeedBackImpl.class, primaryKey);

				if (feedBack != null) {
					cacheResult(feedBack);
				}
				else {
					EntityCacheUtil.putResult(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
						FeedBackImpl.class, primaryKey, _nullFeedBack);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FeedBackModelImpl.ENTITY_CACHE_ENABLED,
					FeedBackImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return feedBack;
	}

	/**
	 * Returns the feed back with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param feedbackId the primary key of the feed back
	 * @return the feed back, or <code>null</code> if a feed back with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FeedBack fetchByPrimaryKey(long feedbackId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)feedbackId);
	}

	/**
	 * Returns all the feed backs.
	 *
	 * @return the feed backs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeedBack> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feed backs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.feedback.model.impl.FeedBackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feed backs
	 * @param end the upper bound of the range of feed backs (not inclusive)
	 * @return the range of feed backs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeedBack> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the feed backs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.feedback.model.impl.FeedBackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feed backs
	 * @param end the upper bound of the range of feed backs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feed backs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FeedBack> findAll(int start, int end,
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

		List<FeedBack> list = (List<FeedBack>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FEEDBACK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FEEDBACK;

				if (pagination) {
					sql = sql.concat(FeedBackModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FeedBack>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FeedBack>(list);
				}
				else {
					list = (List<FeedBack>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the feed backs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FeedBack feedBack : findAll()) {
			remove(feedBack);
		}
	}

	/**
	 * Returns the number of feed backs.
	 *
	 * @return the number of feed backs
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

				Query q = session.createQuery(_SQL_COUNT_FEEDBACK);

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
	 * Initializes the feed back persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.opencps.feedback.model.FeedBack")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FeedBack>> listenersList = new ArrayList<ModelListener<FeedBack>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FeedBack>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FeedBackImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FEEDBACK = "SELECT feedBack FROM FeedBack feedBack";
	private static final String _SQL_SELECT_FEEDBACK_WHERE = "SELECT feedBack FROM FeedBack feedBack WHERE ";
	private static final String _SQL_COUNT_FEEDBACK = "SELECT COUNT(feedBack) FROM FeedBack feedBack";
	private static final String _SQL_COUNT_FEEDBACK_WHERE = "SELECT COUNT(feedBack) FROM FeedBack feedBack WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feedBack.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FeedBack exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FeedBack exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FeedBackPersistenceImpl.class);
	private static FeedBack _nullFeedBack = new FeedBackImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FeedBack> toCacheModel() {
				return _nullFeedBackCacheModel;
			}
		};

	private static CacheModel<FeedBack> _nullFeedBackCacheModel = new CacheModel<FeedBack>() {
			@Override
			public FeedBack toEntityModel() {
				return _nullFeedBack;
			}
		};
}