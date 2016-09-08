/**
 * OpenCPS is the open source Core Public Services software Copyright (C)
 * 2016-present OpenCPS community This program is free software: you can
 * redistribute it and/or modify it under the terms of the GNU Affero General
 * Public License as published by the Free Software Foundation, either version 3
 * of the License, or any later version. This program is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Affero General Public License for more details. You should have received a
 * copy of the GNU Affero General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.feedback.service.impl;

import java.util.Date;
import java.util.List;

import org.opencps.feedback.model.FeedBack;
import org.opencps.feedback.model.impl.FeedBackImpl;
import org.opencps.feedback.service.base.FeedBackLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the feed back local service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link org.opencps.feedback.service.FeedBackLocalService} interface. <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM. </p>
 *
 * @author khoavd
 * @see org.opencps.feedback.service.base.FeedBackLocalServiceBaseImpl
 * @see org.opencps.feedback.service.FeedBackLocalServiceUtil
 */
public class FeedBackLocalServiceImpl extends FeedBackLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link org.opencps.feedback.service.FeedBackLocalServiceUtil} to access
	 * the feed back local service.
	 */
	
	public List<FeedBack> getAll() throws SystemException{
		return feedBackPersistence.findAll();
	}
	
	public List<FeedBack> getAll(int start, int end) throws SystemException{
		return feedBackPersistence.findAll(start, end);
	}
	
	public int countAll() throws SystemException{
		return feedBackPersistence.countAll();
	}

	public FeedBack addFeedBack(
	    String fullName, String email, String feedBackContent,
	    ServiceContext serviceContext)
	    throws SystemException {
		
		Date now  = new Date();

		long feedbackId =
		    counterLocalService.increment(FeedBack.class.getName());
		
		//FeedBack feedBack = new FeedBackImpl();
		FeedBack feedBack = feedBackPersistence.create(feedbackId);
		
		feedBack.setCompanyId(serviceContext.getCompanyId());
		feedBack.setCreateDate(now);
		feedBack.setModifiedDate(now);
		feedBack.setGroupId(serviceContext.getScopeGroupId());
		feedBack.setUserId(serviceContext.getUserId());
		
		feedBack.setEmail(email);
		feedBack.setFeedBack(feedBackContent);
		feedBack.setFullName(fullName);

		feedBack = feedBackPersistence.update(feedBack);
		
		return feedBack;
	}
}
