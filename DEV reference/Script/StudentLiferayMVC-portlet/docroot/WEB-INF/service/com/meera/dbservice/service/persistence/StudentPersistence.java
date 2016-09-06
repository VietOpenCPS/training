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

import com.liferay.portal.service.persistence.BasePersistence;

import com.meera.dbservice.model.Student;

/**
 * The persistence interface for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LiferaySavvy
 * @see StudentPersistenceImpl
 * @see StudentUtil
 * @generated
 */
public interface StudentPersistence extends BasePersistence<Student> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the students where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByGender(
		int studentGender)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where studentGender = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentGender the student gender
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByGender(
		int studentGender, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where studentGender = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentGender the student gender
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByGender(
		int studentGender, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByGender_First(
		int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByGender_First(
		int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByGender_Last(
		int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByGender_Last(
		int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where studentGender = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param studentGender the student gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student[] findByGender_PrevAndNext(
		long studentId, int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Removes all the students where studentGender = &#63; from the database.
	*
	* @param studentGender the student gender
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGender(int studentGender)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByGender(int studentGender)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByGender_Age(
		int studentGender, int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where studentGender = &#63; and studentAge = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByGender_Age(
		int studentGender, int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where studentGender = &#63; and studentAge = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByGender_Age(
		int studentGender, int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByGender_Age_First(
		int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByGender_Age_First(
		int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByGender_Age_Last(
		int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByGender_Age_Last(
		int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param studentGender the student gender
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student[] findByGender_Age_PrevAndNext(
		long studentId, int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Removes all the students where studentGender = &#63; and studentAge = &#63; from the database.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGender_Age(int studentGender, int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByGender_Age(int studentGender, int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student where studentId = &#63; or throws a {@link com.meera.dbservice.NoSuchStudentException} if it could not be found.
	*
	* @param studentId the student ID
	* @return the matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findBybyStudentId(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param studentId the student ID
	* @return the matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchBybyStudentId(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param studentId the student ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchBybyStudentId(
		long studentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the student where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	* @return the student that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student removeBybyStudentId(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the number of students where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countBybyStudentId(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByfemaleStudents(
		int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where studentAge = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByfemaleStudents(
		int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where studentAge = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByfemaleStudents(
		int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByfemaleStudents_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByfemaleStudents_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByfemaleStudents_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByfemaleStudents_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where studentAge = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student[] findByfemaleStudents_PrevAndNext(
		long studentId, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Removes all the students where studentAge = &#63; from the database.
	*
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfemaleStudents(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByfemaleStudents(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByfirstNameLike(
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where firstName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByfirstNameLike(
		java.lang.String firstName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where firstName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param firstName the first name
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByfirstNameLike(
		java.lang.String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByfirstNameLike_First(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByfirstNameLike_First(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByfirstNameLike_Last(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByfirstNameLike_Last(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where firstName LIKE &#63;.
	*
	* @param studentId the primary key of the current student
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student[] findByfirstNameLike_PrevAndNext(
		long studentId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Removes all the students where firstName LIKE &#63; from the database.
	*
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByfirstNameLike(java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByfirstNameLike(java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findBymajorStudentGreaterThan(
		int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where studentAge &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findBymajorStudentGreaterThan(
		int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where studentAge &gt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findBymajorStudentGreaterThan(
		int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findBymajorStudentGreaterThan_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchBymajorStudentGreaterThan_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findBymajorStudentGreaterThan_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchBymajorStudentGreaterThan_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where studentAge &gt; &#63;.
	*
	* @param studentId the primary key of the current student
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student[] findBymajorStudentGreaterThan_PrevAndNext(
		long studentId, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Removes all the students where studentAge &gt; &#63; from the database.
	*
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymajorStudentGreaterThan(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countBymajorStudentGreaterThan(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByminorStudentLessThan(
		int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where studentAge &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByminorStudentLessThan(
		int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where studentAge &lt; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findByminorStudentLessThan(
		int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByminorStudentLessThan_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByminorStudentLessThan_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByminorStudentLessThan_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByminorStudentLessThan_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where studentAge &lt; &#63;.
	*
	* @param studentId the primary key of the current student
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student[] findByminorStudentLessThan_PrevAndNext(
		long studentId, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Removes all the students where studentAge &lt; &#63; from the database.
	*
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public void removeByminorStudentLessThan(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countByminorStudentLessThan(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where studentAge = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where studentAge = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAge the student age
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findBymulipleAges_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the first student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchBymulipleAges_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findBymulipleAges_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the last student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchBymulipleAges_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the students before and after the current student in the ordered set where studentAge = &#63;.
	*
	* @param studentId the primary key of the current student
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student[] findBymulipleAges_PrevAndNext(
		long studentId, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns all the students where studentAge = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAges the student ages
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int[] studentAges)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students where studentAge = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAges the student ages
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int[] studentAges, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students where studentAge = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param studentAges the student ages
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int[] studentAges, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students where studentAge = &#63; from the database.
	*
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymulipleAges(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countBymulipleAges(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students where studentAge = any &#63;.
	*
	* @param studentAges the student ages
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public int countBymulipleAges(int[] studentAges)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the student in the entity cache if it is enabled.
	*
	* @param student the student
	*/
	public void cacheResult(com.meera.dbservice.model.Student student);

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students
	*/
	public void cacheResult(
		java.util.List<com.meera.dbservice.model.Student> students);

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public com.meera.dbservice.model.Student create(long studentId);

	/**
	* Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student remove(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	public com.meera.dbservice.model.Student updateImpl(
		com.meera.dbservice.model.Student student)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the student with the primary key or throws a {@link com.meera.dbservice.NoSuchStudentException} if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student findByPrimaryKey(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException;

	/**
	* Returns the student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student, or <code>null</code> if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.meera.dbservice.model.Student fetchByPrimaryKey(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the students.
	*
	* @return the students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.meera.dbservice.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of students
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.meera.dbservice.model.Student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of students.
	*
	* @return the number of students
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}