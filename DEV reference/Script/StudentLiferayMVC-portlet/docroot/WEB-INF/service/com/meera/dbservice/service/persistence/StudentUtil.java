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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.meera.dbservice.model.Student;

import java.util.List;

/**
 * The persistence utility for the student service. This utility wraps {@link StudentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LiferaySavvy
 * @see StudentPersistence
 * @see StudentPersistenceImpl
 * @generated
 */
public class StudentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Student student) {
		getPersistence().clearCache(student);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Student> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Student update(Student student) throws SystemException {
		return getPersistence().update(student);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Student update(Student student, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(student, serviceContext);
	}

	/**
	* Returns all the students where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.meera.dbservice.model.Student> findByGender(
		int studentGender)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGender(studentGender);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByGender(
		int studentGender, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGender(studentGender, start, end);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByGender(
		int studentGender, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGender(studentGender, start, end, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findByGender_First(
		int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByGender_First(studentGender, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByGender_First(
		int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGender_First(studentGender, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findByGender_Last(
		int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByGender_Last(studentGender, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByGender_Last(
		int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGender_Last(studentGender, orderByComparator);
	}

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
	public static com.meera.dbservice.model.Student[] findByGender_PrevAndNext(
		long studentId, int studentGender,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByGender_PrevAndNext(studentId, studentGender,
			orderByComparator);
	}

	/**
	* Removes all the students where studentGender = &#63; from the database.
	*
	* @param studentGender the student gender
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGender(int studentGender)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGender(studentGender);
	}

	/**
	* Returns the number of students where studentGender = &#63;.
	*
	* @param studentGender the student gender
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGender(int studentGender)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGender(studentGender);
	}

	/**
	* Returns all the students where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.meera.dbservice.model.Student> findByGender_Age(
		int studentGender, int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGender_Age(studentGender, studentAge);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByGender_Age(
		int studentGender, int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGender_Age(studentGender, studentAge, start, end);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByGender_Age(
		int studentGender, int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGender_Age(studentGender, studentAge, start, end,
			orderByComparator);
	}

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
	public static com.meera.dbservice.model.Student findByGender_Age_First(
		int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByGender_Age_First(studentGender, studentAge,
			orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByGender_Age_First(
		int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGender_Age_First(studentGender, studentAge,
			orderByComparator);
	}

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
	public static com.meera.dbservice.model.Student findByGender_Age_Last(
		int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByGender_Age_Last(studentGender, studentAge,
			orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByGender_Age_Last(
		int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGender_Age_Last(studentGender, studentAge,
			orderByComparator);
	}

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
	public static com.meera.dbservice.model.Student[] findByGender_Age_PrevAndNext(
		long studentId, int studentGender, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByGender_Age_PrevAndNext(studentId, studentGender,
			studentAge, orderByComparator);
	}

	/**
	* Removes all the students where studentGender = &#63; and studentAge = &#63; from the database.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGender_Age(int studentGender, int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGender_Age(studentGender, studentAge);
	}

	/**
	* Returns the number of students where studentGender = &#63; and studentAge = &#63;.
	*
	* @param studentGender the student gender
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGender_Age(int studentGender, int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGender_Age(studentGender, studentAge);
	}

	/**
	* Returns the student where studentId = &#63; or throws a {@link com.meera.dbservice.NoSuchStudentException} if it could not be found.
	*
	* @param studentId the student ID
	* @return the matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findBybyStudentId(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence().findBybyStudentId(studentId);
	}

	/**
	* Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param studentId the student ID
	* @return the matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchBybyStudentId(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyStudentId(studentId);
	}

	/**
	* Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param studentId the student ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchBybyStudentId(
		long studentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBybyStudentId(studentId, retrieveFromCache);
	}

	/**
	* Removes the student where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	* @return the student that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student removeBybyStudentId(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence().removeBybyStudentId(studentId);
	}

	/**
	* Returns the number of students where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countBybyStudentId(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBybyStudentId(studentId);
	}

	/**
	* Returns all the students where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.meera.dbservice.model.Student> findByfemaleStudents(
		int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfemaleStudents(studentAge);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByfemaleStudents(
		int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfemaleStudents(studentAge, start, end);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByfemaleStudents(
		int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfemaleStudents(studentAge, start, end,
			orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findByfemaleStudents_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByfemaleStudents_First(studentAge, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByfemaleStudents_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfemaleStudents_First(studentAge, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findByfemaleStudents_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByfemaleStudents_Last(studentAge, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByfemaleStudents_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfemaleStudents_Last(studentAge, orderByComparator);
	}

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
	public static com.meera.dbservice.model.Student[] findByfemaleStudents_PrevAndNext(
		long studentId, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByfemaleStudents_PrevAndNext(studentId, studentAge,
			orderByComparator);
	}

	/**
	* Removes all the students where studentAge = &#63; from the database.
	*
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfemaleStudents(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByfemaleStudents(studentAge);
	}

	/**
	* Returns the number of students where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfemaleStudents(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfemaleStudents(studentAge);
	}

	/**
	* Returns all the students where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.meera.dbservice.model.Student> findByfirstNameLike(
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfirstNameLike(firstName);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByfirstNameLike(
		java.lang.String firstName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByfirstNameLike(firstName, start, end);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByfirstNameLike(
		java.lang.String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByfirstNameLike(firstName, start, end, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findByfirstNameLike_First(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByfirstNameLike_First(firstName, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByfirstNameLike_First(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfirstNameLike_First(firstName, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findByfirstNameLike_Last(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByfirstNameLike_Last(firstName, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByfirstNameLike_Last(
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfirstNameLike_Last(firstName, orderByComparator);
	}

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
	public static com.meera.dbservice.model.Student[] findByfirstNameLike_PrevAndNext(
		long studentId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByfirstNameLike_PrevAndNext(studentId, firstName,
			orderByComparator);
	}

	/**
	* Removes all the students where firstName LIKE &#63; from the database.
	*
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByfirstNameLike(java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByfirstNameLike(firstName);
	}

	/**
	* Returns the number of students where firstName LIKE &#63;.
	*
	* @param firstName the first name
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfirstNameLike(java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByfirstNameLike(firstName);
	}

	/**
	* Returns all the students where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.meera.dbservice.model.Student> findBymajorStudentGreaterThan(
		int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymajorStudentGreaterThan(studentAge);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findBymajorStudentGreaterThan(
		int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymajorStudentGreaterThan(studentAge, start, end);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findBymajorStudentGreaterThan(
		int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymajorStudentGreaterThan(studentAge, start, end,
			orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findBymajorStudentGreaterThan_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findBymajorStudentGreaterThan_First(studentAge,
			orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchBymajorStudentGreaterThan_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymajorStudentGreaterThan_First(studentAge,
			orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findBymajorStudentGreaterThan_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findBymajorStudentGreaterThan_Last(studentAge,
			orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchBymajorStudentGreaterThan_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymajorStudentGreaterThan_Last(studentAge,
			orderByComparator);
	}

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
	public static com.meera.dbservice.model.Student[] findBymajorStudentGreaterThan_PrevAndNext(
		long studentId, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findBymajorStudentGreaterThan_PrevAndNext(studentId,
			studentAge, orderByComparator);
	}

	/**
	* Removes all the students where studentAge &gt; &#63; from the database.
	*
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymajorStudentGreaterThan(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymajorStudentGreaterThan(studentAge);
	}

	/**
	* Returns the number of students where studentAge &gt; &#63;.
	*
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymajorStudentGreaterThan(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymajorStudentGreaterThan(studentAge);
	}

	/**
	* Returns all the students where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.meera.dbservice.model.Student> findByminorStudentLessThan(
		int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByminorStudentLessThan(studentAge);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByminorStudentLessThan(
		int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByminorStudentLessThan(studentAge, start, end);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findByminorStudentLessThan(
		int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByminorStudentLessThan(studentAge, start, end,
			orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findByminorStudentLessThan_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByminorStudentLessThan_First(studentAge,
			orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByminorStudentLessThan_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByminorStudentLessThan_First(studentAge,
			orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findByminorStudentLessThan_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByminorStudentLessThan_Last(studentAge,
			orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByminorStudentLessThan_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByminorStudentLessThan_Last(studentAge,
			orderByComparator);
	}

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
	public static com.meera.dbservice.model.Student[] findByminorStudentLessThan_PrevAndNext(
		long studentId, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findByminorStudentLessThan_PrevAndNext(studentId,
			studentAge, orderByComparator);
	}

	/**
	* Removes all the students where studentAge &lt; &#63; from the database.
	*
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByminorStudentLessThan(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByminorStudentLessThan(studentAge);
	}

	/**
	* Returns the number of students where studentAge &lt; &#63;.
	*
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countByminorStudentLessThan(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByminorStudentLessThan(studentAge);
	}

	/**
	* Returns all the students where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymulipleAges(studentAge);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int studentAge, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymulipleAges(studentAge, start, end);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int studentAge, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymulipleAges(studentAge, start, end, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findBymulipleAges_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findBymulipleAges_First(studentAge, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchBymulipleAges_First(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymulipleAges_First(studentAge, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findBymulipleAges_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findBymulipleAges_Last(studentAge, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchBymulipleAges_Last(
		int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymulipleAges_Last(studentAge, orderByComparator);
	}

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
	public static com.meera.dbservice.model.Student[] findBymulipleAges_PrevAndNext(
		long studentId, int studentAge,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence()
				   .findBymulipleAges_PrevAndNext(studentId, studentAge,
			orderByComparator);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int[] studentAges)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymulipleAges(studentAges);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int[] studentAges, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymulipleAges(studentAges, start, end);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findBymulipleAges(
		int[] studentAges, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymulipleAges(studentAges, start, end, orderByComparator);
	}

	/**
	* Removes all the students where studentAge = &#63; from the database.
	*
	* @param studentAge the student age
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymulipleAges(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymulipleAges(studentAge);
	}

	/**
	* Returns the number of students where studentAge = &#63;.
	*
	* @param studentAge the student age
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymulipleAges(int studentAge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymulipleAges(studentAge);
	}

	/**
	* Returns the number of students where studentAge = any &#63;.
	*
	* @param studentAges the student ages
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymulipleAges(int[] studentAges)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymulipleAges(studentAges);
	}

	/**
	* Caches the student in the entity cache if it is enabled.
	*
	* @param student the student
	*/
	public static void cacheResult(com.meera.dbservice.model.Student student) {
		getPersistence().cacheResult(student);
	}

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students
	*/
	public static void cacheResult(
		java.util.List<com.meera.dbservice.model.Student> students) {
		getPersistence().cacheResult(students);
	}

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public static com.meera.dbservice.model.Student create(long studentId) {
		return getPersistence().create(studentId);
	}

	/**
	* Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student remove(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence().remove(studentId);
	}

	public static com.meera.dbservice.model.Student updateImpl(
		com.meera.dbservice.model.Student student)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(student);
	}

	/**
	* Returns the student with the primary key or throws a {@link com.meera.dbservice.NoSuchStudentException} if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student findByPrimaryKey(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.meera.dbservice.NoSuchStudentException {
		return getPersistence().findByPrimaryKey(studentId);
	}

	/**
	* Returns the student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student, or <code>null</code> if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.meera.dbservice.model.Student fetchByPrimaryKey(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(studentId);
	}

	/**
	* Returns all the students.
	*
	* @return the students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.meera.dbservice.model.Student> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.meera.dbservice.model.Student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of students.
	*
	* @return the number of students
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StudentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StudentPersistence)PortletBeanLocatorUtil.locate(com.meera.dbservice.service.ClpSerializer.getServletContextName(),
					StudentPersistence.class.getName());

			ReferenceRegistry.registerReference(StudentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StudentPersistence persistence) {
	}

	private static StudentPersistence _persistence;
}