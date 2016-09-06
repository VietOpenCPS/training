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

package com.meera.dbservice.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.meera.dbservice.model.Student;
import com.meera.dbservice.service.StudentLocalServiceUtil;

/**
 * @author LiferaySavvy
 * @generated
 */
public abstract class StudentActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public StudentActionableDynamicQuery() throws SystemException {
		setBaseLocalService(StudentLocalServiceUtil.getService());
		setClass(Student.class);

		setClassLoader(com.meera.dbservice.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("studentId");
	}
}