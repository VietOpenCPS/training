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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FeedBack. This utility wraps
 * {@link org.opencps.feedback.service.impl.FeedBackLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author khoavd
 * @see FeedBackLocalService
 * @see org.opencps.feedback.service.base.FeedBackLocalServiceBaseImpl
 * @see org.opencps.feedback.service.impl.FeedBackLocalServiceImpl
 * @generated
 */
public class FeedBackLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.opencps.feedback.service.impl.FeedBackLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the feed back to the database. Also notifies the appropriate model listeners.
	*
	* @param feedBack the feed back
	* @return the feed back that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.feedback.model.FeedBack addFeedBack(
		org.opencps.feedback.model.FeedBack feedBack)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFeedBack(feedBack);
	}

	/**
	* Creates a new feed back with the primary key. Does not add the feed back to the database.
	*
	* @param feedbackId the primary key for the new feed back
	* @return the new feed back
	*/
	public static org.opencps.feedback.model.FeedBack createFeedBack(
		long feedbackId) {
		return getService().createFeedBack(feedbackId);
	}

	/**
	* Deletes the feed back with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackId the primary key of the feed back
	* @return the feed back that was removed
	* @throws PortalException if a feed back with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.feedback.model.FeedBack deleteFeedBack(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFeedBack(feedbackId);
	}

	/**
	* Deletes the feed back from the database. Also notifies the appropriate model listeners.
	*
	* @param feedBack the feed back
	* @return the feed back that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.feedback.model.FeedBack deleteFeedBack(
		org.opencps.feedback.model.FeedBack feedBack)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFeedBack(feedBack);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.opencps.feedback.model.FeedBack fetchFeedBack(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFeedBack(feedbackId);
	}

	/**
	* Returns the feed back with the primary key.
	*
	* @param feedbackId the primary key of the feed back
	* @return the feed back
	* @throws PortalException if a feed back with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.feedback.model.FeedBack getFeedBack(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFeedBack(feedbackId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.opencps.feedback.model.FeedBack> getFeedBacks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFeedBacks(start, end);
	}

	/**
	* Returns the number of feed backs.
	*
	* @return the number of feed backs
	* @throws SystemException if a system exception occurred
	*/
	public static int getFeedBacksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFeedBacksCount();
	}

	/**
	* Updates the feed back in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param feedBack the feed back
	* @return the feed back that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.opencps.feedback.model.FeedBack updateFeedBack(
		org.opencps.feedback.model.FeedBack feedBack)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFeedBack(feedBack);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<org.opencps.feedback.model.FeedBack> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	public static java.util.List<org.opencps.feedback.model.FeedBack> getAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll(start, end);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static org.opencps.feedback.model.FeedBack addFeedBack(
		java.lang.String fullName, java.lang.String email,
		java.lang.String feedBackContent,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFeedBack(fullName, email, feedBackContent, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static FeedBackLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FeedBackLocalService.class.getName());

			if (invokableLocalService instanceof FeedBackLocalService) {
				_service = (FeedBackLocalService)invokableLocalService;
			}
			else {
				_service = new FeedBackLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FeedBackLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FeedBackLocalService service) {
	}

	private static FeedBackLocalService _service;
}