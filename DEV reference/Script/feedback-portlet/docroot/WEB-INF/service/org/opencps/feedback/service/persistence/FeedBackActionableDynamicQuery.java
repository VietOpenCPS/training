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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.opencps.feedback.model.FeedBack;
import org.opencps.feedback.service.FeedBackLocalServiceUtil;

/**
 * @author khoavd
 * @generated
 */
public abstract class FeedBackActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public FeedBackActionableDynamicQuery() throws SystemException {
		setBaseLocalService(FeedBackLocalServiceUtil.getService());
		setClass(FeedBack.class);

		setClassLoader(org.opencps.feedback.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("feedbackId");
	}
}