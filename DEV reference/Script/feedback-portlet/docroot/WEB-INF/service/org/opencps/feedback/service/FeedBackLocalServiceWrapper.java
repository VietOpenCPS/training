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

package org.opencps.feedback.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FeedBackLocalService}.
 *
 * @author khoavd
 * @see FeedBackLocalService
 * @generated
 */
public class FeedBackLocalServiceWrapper implements FeedBackLocalService,
	ServiceWrapper<FeedBackLocalService> {
	public FeedBackLocalServiceWrapper(
		FeedBackLocalService feedBackLocalService) {
		_feedBackLocalService = feedBackLocalService;
	}

	/**
	* Adds the feed back to the database. Also notifies the appropriate model listeners.
	*
	* @param feedBack the feed back
	* @return the feed back that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.feedback.model.FeedBack addFeedBack(
		org.opencps.feedback.model.FeedBack feedBack)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.addFeedBack(feedBack);
	}

	/**
	* Creates a new feed back with the primary key. Does not add the feed back to the database.
	*
	* @param feedbackId the primary key for the new feed back
	* @return the new feed back
	*/
	@Override
	public org.opencps.feedback.model.FeedBack createFeedBack(long feedbackId) {
		return _feedBackLocalService.createFeedBack(feedbackId);
	}

	/**
	* Deletes the feed back with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackId the primary key of the feed back
	* @return the feed back that was removed
	* @throws PortalException if a feed back with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.feedback.model.FeedBack deleteFeedBack(long feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.deleteFeedBack(feedbackId);
	}

	/**
	* Deletes the feed back from the database. Also notifies the appropriate model listeners.
	*
	* @param feedBack the feed back
	* @return the feed back that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.feedback.model.FeedBack deleteFeedBack(
		org.opencps.feedback.model.FeedBack feedBack)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.deleteFeedBack(feedBack);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _feedBackLocalService.dynamicQuery();
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.feedback.model.impl.FeedBackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.opencps.feedback.model.impl.FeedBackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.dynamicQueryCount(dynamicQuery);
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
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.opencps.feedback.model.FeedBack fetchFeedBack(long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.fetchFeedBack(feedbackId);
	}

	/**
	* Returns the feed back with the primary key.
	*
	* @param feedbackId the primary key of the feed back
	* @return the feed back
	* @throws PortalException if a feed back with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.feedback.model.FeedBack getFeedBack(long feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.getFeedBack(feedbackId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<org.opencps.feedback.model.FeedBack> getFeedBacks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.getFeedBacks(start, end);
	}

	/**
	* Returns the number of feed backs.
	*
	* @return the number of feed backs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFeedBacksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.getFeedBacksCount();
	}

	/**
	* Updates the feed back in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param feedBack the feed back
	* @return the feed back that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.opencps.feedback.model.FeedBack updateFeedBack(
		org.opencps.feedback.model.FeedBack feedBack)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.updateFeedBack(feedBack);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _feedBackLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_feedBackLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _feedBackLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<org.opencps.feedback.model.FeedBack> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.getAll();
	}

	@Override
	public java.util.List<org.opencps.feedback.model.FeedBack> getAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.getAll(start, end);
	}

	@Override
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.countAll();
	}

	@Override
	public org.opencps.feedback.model.FeedBack addFeedBack(
		java.lang.String fullName, java.lang.String email,
		java.lang.String feedBackContent,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBackLocalService.addFeedBack(fullName, email,
			feedBackContent, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FeedBackLocalService getWrappedFeedBackLocalService() {
		return _feedBackLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFeedBackLocalService(
		FeedBackLocalService feedBackLocalService) {
		_feedBackLocalService = feedBackLocalService;
	}

	@Override
	public FeedBackLocalService getWrappedService() {
		return _feedBackLocalService;
	}

	@Override
	public void setWrappedService(FeedBackLocalService feedBackLocalService) {
		_feedBackLocalService = feedBackLocalService;
	}

	private FeedBackLocalService _feedBackLocalService;
}