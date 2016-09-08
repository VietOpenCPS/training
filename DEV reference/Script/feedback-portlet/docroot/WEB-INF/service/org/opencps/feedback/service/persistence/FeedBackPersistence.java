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

import com.liferay.portal.service.persistence.BasePersistence;

import org.opencps.feedback.model.FeedBack;

/**
 * The persistence interface for the feed back service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author khoavd
 * @see FeedBackPersistenceImpl
 * @see FeedBackUtil
 * @generated
 */
public interface FeedBackPersistence extends BasePersistence<FeedBack> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FeedBackUtil} to access the feed back persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the feed back where email = &#63; or throws a {@link org.opencps.feedback.NoSuchFeedBackException} if it could not be found.
	*
	* @param email the email
	* @return the matching feed back
	* @throws org.opencps.feedback.NoSuchFeedBackException if a matching feed back could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.feedback.model.FeedBack findByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.feedback.NoSuchFeedBackException;

	/**
	* Returns the feed back where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param email the email
	* @return the matching feed back, or <code>null</code> if a matching feed back could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.feedback.model.FeedBack fetchByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the feed back where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param email the email
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching feed back, or <code>null</code> if a matching feed back could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.feedback.model.FeedBack fetchByEmail(
		java.lang.String email, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the feed back where email = &#63; from the database.
	*
	* @param email the email
	* @return the feed back that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.feedback.model.FeedBack removeByEmail(
		java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.feedback.NoSuchFeedBackException;

	/**
	* Returns the number of feed backs where email = &#63;.
	*
	* @param email the email
	* @return the number of matching feed backs
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmail(java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the feed back in the entity cache if it is enabled.
	*
	* @param feedBack the feed back
	*/
	public void cacheResult(org.opencps.feedback.model.FeedBack feedBack);

	/**
	* Caches the feed backs in the entity cache if it is enabled.
	*
	* @param feedBacks the feed backs
	*/
	public void cacheResult(
		java.util.List<org.opencps.feedback.model.FeedBack> feedBacks);

	/**
	* Creates a new feed back with the primary key. Does not add the feed back to the database.
	*
	* @param feedbackId the primary key for the new feed back
	* @return the new feed back
	*/
	public org.opencps.feedback.model.FeedBack create(long feedbackId);

	/**
	* Removes the feed back with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackId the primary key of the feed back
	* @return the feed back that was removed
	* @throws org.opencps.feedback.NoSuchFeedBackException if a feed back with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.feedback.model.FeedBack remove(long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.feedback.NoSuchFeedBackException;

	public org.opencps.feedback.model.FeedBack updateImpl(
		org.opencps.feedback.model.FeedBack feedBack)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the feed back with the primary key or throws a {@link org.opencps.feedback.NoSuchFeedBackException} if it could not be found.
	*
	* @param feedbackId the primary key of the feed back
	* @return the feed back
	* @throws org.opencps.feedback.NoSuchFeedBackException if a feed back with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.feedback.model.FeedBack findByPrimaryKey(long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.opencps.feedback.NoSuchFeedBackException;

	/**
	* Returns the feed back with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param feedbackId the primary key of the feed back
	* @return the feed back, or <code>null</code> if a feed back with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.opencps.feedback.model.FeedBack fetchByPrimaryKey(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the feed backs.
	*
	* @return the feed backs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.opencps.feedback.model.FeedBack> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.feedback.model.FeedBack> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.opencps.feedback.model.FeedBack> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the feed backs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of feed backs.
	*
	* @return the number of feed backs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}