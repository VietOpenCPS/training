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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.feedback.service.http.FeedBackServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.feedback.service.http.FeedBackServiceSoap
 * @generated
 */
public class FeedBackSoap implements Serializable {
	public static FeedBackSoap toSoapModel(FeedBack model) {
		FeedBackSoap soapModel = new FeedBackSoap();

		soapModel.setFeedbackId(model.getFeedbackId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFullName(model.getFullName());
		soapModel.setEmail(model.getEmail());
		soapModel.setFeedBack(model.getFeedBack());

		return soapModel;
	}

	public static FeedBackSoap[] toSoapModels(FeedBack[] models) {
		FeedBackSoap[] soapModels = new FeedBackSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeedBackSoap[][] toSoapModels(FeedBack[][] models) {
		FeedBackSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeedBackSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeedBackSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeedBackSoap[] toSoapModels(List<FeedBack> models) {
		List<FeedBackSoap> soapModels = new ArrayList<FeedBackSoap>(models.size());

		for (FeedBack model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeedBackSoap[soapModels.size()]);
	}

	public FeedBackSoap() {
	}

	public long getPrimaryKey() {
		return _feedbackId;
	}

	public void setPrimaryKey(long pk) {
		setFeedbackId(pk);
	}

	public long getFeedbackId() {
		return _feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getFeedBack() {
		return _feedBack;
	}

	public void setFeedBack(String feedBack) {
		_feedBack = feedBack;
	}

	private long _feedbackId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _fullName;
	private String _email;
	private String _feedBack;
}