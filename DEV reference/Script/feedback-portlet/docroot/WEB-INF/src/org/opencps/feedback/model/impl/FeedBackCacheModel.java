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

package org.opencps.feedback.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.feedback.model.FeedBack;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FeedBack in entity cache.
 *
 * @author khoavd
 * @see FeedBack
 * @generated
 */
public class FeedBackCacheModel implements CacheModel<FeedBack>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{feedbackId=");
		sb.append(feedbackId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", feedBack=");
		sb.append(feedBack);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FeedBack toEntityModel() {
		FeedBackImpl feedBackImpl = new FeedBackImpl();

		feedBackImpl.setFeedbackId(feedbackId);
		feedBackImpl.setGroupId(groupId);
		feedBackImpl.setCompanyId(companyId);
		feedBackImpl.setUserId(userId);

		if (userName == null) {
			feedBackImpl.setUserName(StringPool.BLANK);
		}
		else {
			feedBackImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			feedBackImpl.setCreateDate(null);
		}
		else {
			feedBackImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			feedBackImpl.setModifiedDate(null);
		}
		else {
			feedBackImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (fullName == null) {
			feedBackImpl.setFullName(StringPool.BLANK);
		}
		else {
			feedBackImpl.setFullName(fullName);
		}

		if (email == null) {
			feedBackImpl.setEmail(StringPool.BLANK);
		}
		else {
			feedBackImpl.setEmail(email);
		}

		if (feedBack == null) {
			feedBackImpl.setFeedBack(StringPool.BLANK);
		}
		else {
			feedBackImpl.setFeedBack(feedBack);
		}

		feedBackImpl.resetOriginalValues();

		return feedBackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		feedbackId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		fullName = objectInput.readUTF();
		email = objectInput.readUTF();
		feedBack = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(feedbackId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (feedBack == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(feedBack);
		}
	}

	public long feedbackId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String fullName;
	public String email;
	public String feedBack;
}