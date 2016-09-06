/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.meera.dbservice.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.meera.dbservice.model.Student;
import com.meera.dbservice.service.StudentLocalServiceUtil;
import com.meera.dbservice.service.base.StudentLocalServiceBaseImpl;
import com.meera.dbservice.service.persistence.StudentUtil;

public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	public List getSerachStudents(String firstName, String lastName,
			int studentAge, int studentGender, String studentAddress,
			boolean andSearch, int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		DynamicQuery dynamicQuery = buildStudentDynamicQuery(firstName,
				lastName, studentAge, studentGender, studentAddress, andSearch);
		return StudentLocalServiceUtil.dynamicQuery(dynamicQuery, start, end,
				orderByComparator);
	}

	public int getSearchStudentsCount(String firstName, String lastName,
			int studentAge, int studentGender, String studentAddress,
			boolean andSearch) throws SystemException {
		DynamicQuery dynamicQuery = buildStudentDynamicQuery(firstName,
				lastName, studentAge, studentGender, studentAddress, andSearch);
		return (int) StudentLocalServiceUtil.dynamicQueryCount(dynamicQuery);
	}

	protected DynamicQuery buildStudentDynamicQuery(String firstName,
			String lastName, int studentAge, int studentGender,
			String studentAddress, boolean andSearch) {
		Junction junction = null;
		if (andSearch)
			junction = RestrictionsFactoryUtil.conjunction();
		else
			junction = RestrictionsFactoryUtil.disjunction();

		if (Validator.isNotNull(firstName)) {
			Property property = PropertyFactoryUtil.forName("firstName");
			String value = (new StringBuilder("%")).append(firstName)
					.append("%").toString();
			junction.add(property.like(value));
		}
		if (Validator.isNotNull(lastName)) {
			Property property = PropertyFactoryUtil.forName("lastName");
			String value = (new StringBuilder("%")).append(lastName)
					.append("%").toString();
			junction.add(property.like(value));
		}
		if (studentAge > 0) {
			Property property = PropertyFactoryUtil.forName("studentAge");
			junction.add(property.eq(Integer.valueOf(studentAge)));
		}
		if (studentGender > 0) {
			Property property = PropertyFactoryUtil.forName("studentGender");
			junction.add(property.eq(Integer.valueOf(studentGender)));
		}
		if (Validator.isNotNull(studentAddress)) {
			Property property = PropertyFactoryUtil.forName("studentAddress");
			String value = (new StringBuilder("%")).append(studentAddress)
					.append("%").toString();
			junction.add(property.like(value));
		}
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
				Student.class, getClassLoader());
		return dynamicQuery.add(junction);
	}

	public java.util.List<com.meera.dbservice.model.Student> findByGenderAndAge(
			int studentGender, int studentAge)
			throws com.liferay.portal.kernel.exception.SystemException {
		return StudentUtil.findByGender_Age(studentGender, studentAge);
	}

	public java.util.List<com.meera.dbservice.model.Student> usingArrableOperatorOnFindeCoumn(
			int[] studentAges)
			throws com.liferay.portal.kernel.exception.SystemException {
		return StudentUtil.findBymulipleAges(studentAges);
	}

	public com.meera.dbservice.model.Student usingUniqueAttributeforFindertag(
			long studentId)
			throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return StudentUtil.findBybyStudentId(studentId);
	}

	public java.util.List<com.meera.dbservice.model.Student> usingWhereAttrobuteInFinderTag(
			int studentAge)
			throws com.liferay.portal.kernel.exception.SystemException {
		return StudentUtil.findByfemaleStudents(studentAge);
	}

	public java.util.List<com.meera.dbservice.model.Student> usingLikeOperatorOnFinderColumn(
			java.lang.String firstName)
			throws com.liferay.portal.kernel.exception.SystemException {
		return StudentUtil.findByfirstNameLike(firstName);
	}

	public java.util.List<com.meera.dbservice.model.Student> usingGreaterThanOnFinderCoulumn(
			int studentAge)
			throws com.liferay.portal.kernel.exception.SystemException {
		return StudentUtil.findBymajorStudentGreaterThan(studentAge);
	}

	public java.util.List<com.meera.dbservice.model.Student> usingLessThanOnFinderCoulumn(
			int studentAge)
			throws com.liferay.portal.kernel.exception.SystemException {
		return StudentUtil.findByminorStudentLessThan(studentAge);
	}
}