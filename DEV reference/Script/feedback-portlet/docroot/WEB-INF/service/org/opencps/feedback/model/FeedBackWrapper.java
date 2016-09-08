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

package org.opencps.feedback.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FeedBack}.
 * </p>
 *
 * @author khoavd
 * @see FeedBack
 * @generated
 */
public class FeedBackWrapper implements FeedBack, ModelWrapper<FeedBack> {
	public FeedBackWrapper(FeedBack feedBack) {
		_feedBack = feedBack;
	}

	@Override
	public Class<?> getModelClass() {
		return FeedBack.class;
	}

	@Override
	public String getModelClassName() {
		return FeedBack.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedbackId", getFeedbackId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fullName", getFullName());
		attributes.put("email", getEmail());
		attributes.put("feedBack", getFeedBack());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String feedBack = (String)attributes.get("feedBack");

		if (feedBack != null) {
			setFeedBack(feedBack);
		}
	}

	/**
	* Returns the primary key of this feed back.
	*
	* @return the primary key of this feed back
	*/
	@Override
	public long getPrimaryKey() {
		return _feedBack.getPrimaryKey();
	}

	/**
	* Sets the primary key of this feed back.
	*
	* @param primaryKey the primary key of this feed back
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_feedBack.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the feedback ID of this feed back.
	*
	* @return the feedback ID of this feed back
	*/
	@Override
	public long getFeedbackId() {
		return _feedBack.getFeedbackId();
	}

	/**
	* Sets the feedback ID of this feed back.
	*
	* @param feedbackId the feedback ID of this feed back
	*/
	@Override
	public void setFeedbackId(long feedbackId) {
		_feedBack.setFeedbackId(feedbackId);
	}

	/**
	* Returns the group ID of this feed back.
	*
	* @return the group ID of this feed back
	*/
	@Override
	public long getGroupId() {
		return _feedBack.getGroupId();
	}

	/**
	* Sets the group ID of this feed back.
	*
	* @param groupId the group ID of this feed back
	*/
	@Override
	public void setGroupId(long groupId) {
		_feedBack.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this feed back.
	*
	* @return the company ID of this feed back
	*/
	@Override
	public long getCompanyId() {
		return _feedBack.getCompanyId();
	}

	/**
	* Sets the company ID of this feed back.
	*
	* @param companyId the company ID of this feed back
	*/
	@Override
	public void setCompanyId(long companyId) {
		_feedBack.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this feed back.
	*
	* @return the user ID of this feed back
	*/
	@Override
	public long getUserId() {
		return _feedBack.getUserId();
	}

	/**
	* Sets the user ID of this feed back.
	*
	* @param userId the user ID of this feed back
	*/
	@Override
	public void setUserId(long userId) {
		_feedBack.setUserId(userId);
	}

	/**
	* Returns the user uuid of this feed back.
	*
	* @return the user uuid of this feed back
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _feedBack.getUserUuid();
	}

	/**
	* Sets the user uuid of this feed back.
	*
	* @param userUuid the user uuid of this feed back
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_feedBack.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this feed back.
	*
	* @return the user name of this feed back
	*/
	@Override
	public java.lang.String getUserName() {
		return _feedBack.getUserName();
	}

	/**
	* Sets the user name of this feed back.
	*
	* @param userName the user name of this feed back
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_feedBack.setUserName(userName);
	}

	/**
	* Returns the create date of this feed back.
	*
	* @return the create date of this feed back
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _feedBack.getCreateDate();
	}

	/**
	* Sets the create date of this feed back.
	*
	* @param createDate the create date of this feed back
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_feedBack.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this feed back.
	*
	* @return the modified date of this feed back
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _feedBack.getModifiedDate();
	}

	/**
	* Sets the modified date of this feed back.
	*
	* @param modifiedDate the modified date of this feed back
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_feedBack.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the full name of this feed back.
	*
	* @return the full name of this feed back
	*/
	@Override
	public java.lang.String getFullName() {
		return _feedBack.getFullName();
	}

	/**
	* Sets the full name of this feed back.
	*
	* @param fullName the full name of this feed back
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_feedBack.setFullName(fullName);
	}

	/**
	* Returns the email of this feed back.
	*
	* @return the email of this feed back
	*/
	@Override
	public java.lang.String getEmail() {
		return _feedBack.getEmail();
	}

	/**
	* Sets the email of this feed back.
	*
	* @param email the email of this feed back
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_feedBack.setEmail(email);
	}

	/**
	* Returns the feed back of this feed back.
	*
	* @return the feed back of this feed back
	*/
	@Override
	public java.lang.String getFeedBack() {
		return _feedBack.getFeedBack();
	}

	/**
	* Sets the feed back of this feed back.
	*
	* @param feedBack the feed back of this feed back
	*/
	@Override
	public void setFeedBack(java.lang.String feedBack) {
		_feedBack.setFeedBack(feedBack);
	}

	@Override
	public boolean isNew() {
		return _feedBack.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_feedBack.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _feedBack.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feedBack.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _feedBack.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _feedBack.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_feedBack.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _feedBack.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_feedBack.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_feedBack.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_feedBack.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FeedBackWrapper((FeedBack)_feedBack.clone());
	}

	@Override
	public int compareTo(org.opencps.feedback.model.FeedBack feedBack) {
		return _feedBack.compareTo(feedBack);
	}

	@Override
	public int hashCode() {
		return _feedBack.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.feedback.model.FeedBack> toCacheModel() {
		return _feedBack.toCacheModel();
	}

	@Override
	public org.opencps.feedback.model.FeedBack toEscapedModel() {
		return new FeedBackWrapper(_feedBack.toEscapedModel());
	}

	@Override
	public org.opencps.feedback.model.FeedBack toUnescapedModel() {
		return new FeedBackWrapper(_feedBack.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _feedBack.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _feedBack.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_feedBack.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedBackWrapper)) {
			return false;
		}

		FeedBackWrapper feedBackWrapper = (FeedBackWrapper)obj;

		if (Validator.equals(_feedBack, feedBackWrapper._feedBack)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FeedBack getWrappedFeedBack() {
		return _feedBack;
	}

	@Override
	public FeedBack getWrappedModel() {
		return _feedBack;
	}

	@Override
	public void resetOriginalValues() {
		_feedBack.resetOriginalValues();
	}

	private FeedBack _feedBack;
}