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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.meera.dbservice.NoSuchStudentException;
import com.meera.dbservice.model.Student;
import com.meera.dbservice.model.impl.StudentImpl;
import com.meera.dbservice.model.impl.StudentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LiferaySavvy
 * @see StudentPersistence
 * @see StudentUtil
 * @generated
 */
public class StudentPersistenceImpl extends BasePersistenceImpl<Student>
	implements StudentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GENDER = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGender",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGender",
			new String[] { Integer.class.getName() },
			StudentModelImpl.STUDENTGENDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GENDER = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGender",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the students where studentGender = &#63;.
	 *
	 * @param studentGender the student gender
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findByGender(int studentGender)
		throws SystemException {
		return findByGender(studentGender, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findByGender(int studentGender, int start, int end)
		throws SystemException {
		return findByGender(studentGender, start, end, null);
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
	@Override
	public List<Student> findByGender(int studentGender, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER;
			finderArgs = new Object[] { studentGender };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GENDER;
			finderArgs = new Object[] {
					studentGender,
					
					start, end, orderByComparator
				};
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if ((studentGender != student.getStudentGender())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_GENDER_STUDENTGENDER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentGender);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Student findByGender_First(int studentGender,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByGender_First(studentGender, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentGender=");
		msg.append(studentGender);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where studentGender = &#63;.
	 *
	 * @param studentGender the student gender
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByGender_First(int studentGender,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findByGender(studentGender, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student findByGender_Last(int studentGender,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByGender_Last(studentGender, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentGender=");
		msg.append(studentGender);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where studentGender = &#63;.
	 *
	 * @param studentGender the student gender
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByGender_Last(int studentGender,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGender(studentGender);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByGender(studentGender, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student[] findByGender_PrevAndNext(long studentId,
		int studentGender, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByGender_PrevAndNext(session, student, studentGender,
					orderByComparator, true);

			array[1] = student;

			array[2] = getByGender_PrevAndNext(session, student, studentGender,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByGender_PrevAndNext(Session session, Student student,
		int studentGender, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		query.append(_FINDER_COLUMN_GENDER_STUDENTGENDER_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentGender);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where studentGender = &#63; from the database.
	 *
	 * @param studentGender the student gender
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGender(int studentGender) throws SystemException {
		for (Student student : findByGender(studentGender, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where studentGender = &#63;.
	 *
	 * @param studentGender the student gender
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGender(int studentGender) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GENDER;

		Object[] finderArgs = new Object[] { studentGender };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_GENDER_STUDENTGENDER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentGender);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GENDER_STUDENTGENDER_2 = "student.studentGender = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GENDER_AGE =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGender_Age",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER_AGE =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGender_Age",
			new String[] { Integer.class.getName(), Integer.class.getName() },
			StudentModelImpl.STUDENTGENDER_COLUMN_BITMASK |
			StudentModelImpl.STUDENTAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GENDER_AGE = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGender_Age",
			new String[] { Integer.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the students where studentGender = &#63; and studentAge = &#63;.
	 *
	 * @param studentGender the student gender
	 * @param studentAge the student age
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findByGender_Age(int studentGender, int studentAge)
		throws SystemException {
		return findByGender_Age(studentGender, studentAge, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findByGender_Age(int studentGender, int studentAge,
		int start, int end) throws SystemException {
		return findByGender_Age(studentGender, studentAge, start, end, null);
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
	@Override
	public List<Student> findByGender_Age(int studentGender, int studentAge,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER_AGE;
			finderArgs = new Object[] { studentGender, studentAge };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GENDER_AGE;
			finderArgs = new Object[] {
					studentGender, studentAge,
					
					start, end, orderByComparator
				};
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if ((studentGender != student.getStudentGender()) ||
						(studentAge != student.getStudentAge())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_GENDER_AGE_STUDENTGENDER_2);

			query.append(_FINDER_COLUMN_GENDER_AGE_STUDENTAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentGender);

				qPos.add(studentAge);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Student findByGender_Age_First(int studentGender, int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByGender_Age_First(studentGender, studentAge,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentGender=");
		msg.append(studentGender);

		msg.append(", studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
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
	@Override
	public Student fetchByGender_Age_First(int studentGender, int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findByGender_Age(studentGender, studentAge, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student findByGender_Age_Last(int studentGender, int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByGender_Age_Last(studentGender, studentAge,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentGender=");
		msg.append(studentGender);

		msg.append(", studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
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
	@Override
	public Student fetchByGender_Age_Last(int studentGender, int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGender_Age(studentGender, studentAge);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByGender_Age(studentGender, studentAge,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student[] findByGender_Age_PrevAndNext(long studentId,
		int studentGender, int studentAge, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByGender_Age_PrevAndNext(session, student,
					studentGender, studentAge, orderByComparator, true);

			array[1] = student;

			array[2] = getByGender_Age_PrevAndNext(session, student,
					studentGender, studentAge, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByGender_Age_PrevAndNext(Session session,
		Student student, int studentGender, int studentAge,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		query.append(_FINDER_COLUMN_GENDER_AGE_STUDENTGENDER_2);

		query.append(_FINDER_COLUMN_GENDER_AGE_STUDENTAGE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentGender);

		qPos.add(studentAge);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where studentGender = &#63; and studentAge = &#63; from the database.
	 *
	 * @param studentGender the student gender
	 * @param studentAge the student age
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGender_Age(int studentGender, int studentAge)
		throws SystemException {
		for (Student student : findByGender_Age(studentGender, studentAge,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where studentGender = &#63; and studentAge = &#63;.
	 *
	 * @param studentGender the student gender
	 * @param studentAge the student age
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGender_Age(int studentGender, int studentAge)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GENDER_AGE;

		Object[] finderArgs = new Object[] { studentGender, studentAge };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_GENDER_AGE_STUDENTGENDER_2);

			query.append(_FINDER_COLUMN_GENDER_AGE_STUDENTAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentGender);

				qPos.add(studentAge);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GENDER_AGE_STUDENTGENDER_2 = "student.studentGender = ? AND ";
	private static final String _FINDER_COLUMN_GENDER_AGE_STUDENTAGE_2 = "student.studentAge = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BYSTUDENTID = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybyStudentId",
			new String[] { Long.class.getName() },
			StudentModelImpl.STUDENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BYSTUDENTID = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyStudentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the student where studentId = &#63; or throws a {@link com.meera.dbservice.NoSuchStudentException} if it could not be found.
	 *
	 * @param studentId the student ID
	 * @return the matching student
	 * @throws com.meera.dbservice.NoSuchStudentException if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student findBybyStudentId(long studentId)
		throws NoSuchStudentException, SystemException {
		Student student = fetchBybyStudentId(studentId);

		if (student == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studentId=");
			msg.append(studentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStudentException(msg.toString());
		}

		return student;
	}

	/**
	 * Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param studentId the student ID
	 * @return the matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchBybyStudentId(long studentId) throws SystemException {
		return fetchBybyStudentId(studentId, true);
	}

	/**
	 * Returns the student where studentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param studentId the student ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchBybyStudentId(long studentId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { studentId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BYSTUDENTID,
					finderArgs, this);
		}

		if (result instanceof Student) {
			Student student = (Student)result;

			if ((studentId != student.getStudentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_BYSTUDENTID_STUDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				List<Student> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYSTUDENTID,
						finderArgs, list);
				}
				else {
					Student student = list.get(0);

					result = student;

					cacheResult(student);

					if ((student.getStudentId() != studentId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYSTUDENTID,
							finderArgs, student);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYSTUDENTID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Student)result;
		}
	}

	/**
	 * Removes the student where studentId = &#63; from the database.
	 *
	 * @param studentId the student ID
	 * @return the student that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student removeBybyStudentId(long studentId)
		throws NoSuchStudentException, SystemException {
		Student student = findBybyStudentId(studentId);

		return remove(student);
	}

	/**
	 * Returns the number of students where studentId = &#63;.
	 *
	 * @param studentId the student ID
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybyStudentId(long studentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BYSTUDENTID;

		Object[] finderArgs = new Object[] { studentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_BYSTUDENTID_STUDENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYSTUDENTID_STUDENTID_2 = "student.studentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FEMALESTUDENTS =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfemaleStudents",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEMALESTUDENTS =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByfemaleStudents",
			new String[] { Integer.class.getName() },
			StudentModelImpl.STUDENTAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FEMALESTUDENTS = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByfemaleStudents",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the students where studentAge = &#63;.
	 *
	 * @param studentAge the student age
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findByfemaleStudents(int studentAge)
		throws SystemException {
		return findByfemaleStudents(studentAge, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findByfemaleStudents(int studentAge, int start, int end)
		throws SystemException {
		return findByfemaleStudents(studentAge, start, end, null);
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
	@Override
	public List<Student> findByfemaleStudents(int studentAge, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEMALESTUDENTS;
			finderArgs = new Object[] { studentAge };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FEMALESTUDENTS;
			finderArgs = new Object[] { studentAge, start, end, orderByComparator };
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if ((studentAge != student.getStudentAge())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_FEMALESTUDENTS_STUDENTAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentAge);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Student findByfemaleStudents_First(int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByfemaleStudents_First(studentAge,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where studentAge = &#63;.
	 *
	 * @param studentAge the student age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByfemaleStudents_First(int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findByfemaleStudents(studentAge, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student findByfemaleStudents_Last(int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByfemaleStudents_Last(studentAge,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where studentAge = &#63;.
	 *
	 * @param studentAge the student age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByfemaleStudents_Last(int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByfemaleStudents(studentAge);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByfemaleStudents(studentAge, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student[] findByfemaleStudents_PrevAndNext(long studentId,
		int studentAge, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByfemaleStudents_PrevAndNext(session, student,
					studentAge, orderByComparator, true);

			array[1] = student;

			array[2] = getByfemaleStudents_PrevAndNext(session, student,
					studentAge, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByfemaleStudents_PrevAndNext(Session session,
		Student student, int studentAge, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		query.append(_FINDER_COLUMN_FEMALESTUDENTS_STUDENTAGE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentAge);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where studentAge = &#63; from the database.
	 *
	 * @param studentAge the student age
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByfemaleStudents(int studentAge)
		throws SystemException {
		for (Student student : findByfemaleStudents(studentAge,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where studentAge = &#63;.
	 *
	 * @param studentAge the student age
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfemaleStudents(int studentAge) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FEMALESTUDENTS;

		Object[] finderArgs = new Object[] { studentAge };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_FEMALESTUDENTS_STUDENTAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentAge);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FEMALESTUDENTS_STUDENTAGE_2 = "student.studentAge = ? AND student.studentGender!=1";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAMELIKE =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByfirstNameLike",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_FIRSTNAMELIKE =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByfirstNameLike",
			new String[] { String.class.getName() });

	/**
	 * Returns all the students where firstName LIKE &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findByfirstNameLike(String firstName)
		throws SystemException {
		return findByfirstNameLike(firstName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findByfirstNameLike(String firstName, int start,
		int end) throws SystemException {
		return findByfirstNameLike(firstName, start, end, null);
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
	@Override
	public List<Student> findByfirstNameLike(String firstName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIRSTNAMELIKE;
		finderArgs = new Object[] { firstName, start, end, orderByComparator };

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if (!StringUtil.wildcardMatches(student.getFirstName(),
							firstName, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Student findByfirstNameLike_First(String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByfirstNameLike_First(firstName,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where firstName LIKE &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByfirstNameLike_First(String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findByfirstNameLike(firstName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student findByfirstNameLike_Last(String firstName,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByfirstNameLike_Last(firstName, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("firstName=");
		msg.append(firstName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where firstName LIKE &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByfirstNameLike_Last(String firstName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByfirstNameLike(firstName);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByfirstNameLike(firstName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student[] findByfirstNameLike_PrevAndNext(long studentId,
		String firstName, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByfirstNameLike_PrevAndNext(session, student,
					firstName, orderByComparator, true);

			array[1] = student;

			array[2] = getByfirstNameLike_PrevAndNext(session, student,
					firstName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByfirstNameLike_PrevAndNext(Session session,
		Student student, String firstName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		boolean bindFirstName = false;

		if (firstName == null) {
			query.append(_FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_1);
		}
		else if (firstName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			query.append(_FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFirstName) {
			qPos.add(firstName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where firstName LIKE &#63; from the database.
	 *
	 * @param firstName the first name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByfirstNameLike(String firstName)
		throws SystemException {
		for (Student student : findByfirstNameLike(firstName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where firstName LIKE &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByfirstNameLike(String firstName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_FIRSTNAMELIKE;

		Object[] finderArgs = new Object[] { firstName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			boolean bindFirstName = false;

			if (firstName == null) {
				query.append(_FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_1);
			}
			else if (firstName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				query.append(_FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstName) {
					qPos.add(firstName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_1 = "student.firstName LIKE NULL";
	private static final String _FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_2 = "student.firstName LIKE ?";
	private static final String _FINDER_COLUMN_FIRSTNAMELIKE_FIRSTNAME_3 = "(student.firstName IS NULL OR student.firstName LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MAJORSTUDENTGREATERTHAN =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBymajorStudentGreaterThan",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_MAJORSTUDENTGREATERTHAN =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countBymajorStudentGreaterThan",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the students where studentAge &gt; &#63;.
	 *
	 * @param studentAge the student age
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findBymajorStudentGreaterThan(int studentAge)
		throws SystemException {
		return findBymajorStudentGreaterThan(studentAge, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findBymajorStudentGreaterThan(int studentAge,
		int start, int end) throws SystemException {
		return findBymajorStudentGreaterThan(studentAge, start, end, null);
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
	@Override
	public List<Student> findBymajorStudentGreaterThan(int studentAge,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MAJORSTUDENTGREATERTHAN;
		finderArgs = new Object[] { studentAge, start, end, orderByComparator };

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if ((studentAge >= student.getStudentAge())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_MAJORSTUDENTGREATERTHAN_STUDENTAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentAge);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Student findBymajorStudentGreaterThan_First(int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchBymajorStudentGreaterThan_First(studentAge,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where studentAge &gt; &#63;.
	 *
	 * @param studentAge the student age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchBymajorStudentGreaterThan_First(int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findBymajorStudentGreaterThan(studentAge, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student findBymajorStudentGreaterThan_Last(int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchBymajorStudentGreaterThan_Last(studentAge,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where studentAge &gt; &#63;.
	 *
	 * @param studentAge the student age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchBymajorStudentGreaterThan_Last(int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBymajorStudentGreaterThan(studentAge);

		if (count == 0) {
			return null;
		}

		List<Student> list = findBymajorStudentGreaterThan(studentAge,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student[] findBymajorStudentGreaterThan_PrevAndNext(long studentId,
		int studentAge, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getBymajorStudentGreaterThan_PrevAndNext(session,
					student, studentAge, orderByComparator, true);

			array[1] = student;

			array[2] = getBymajorStudentGreaterThan_PrevAndNext(session,
					student, studentAge, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getBymajorStudentGreaterThan_PrevAndNext(
		Session session, Student student, int studentAge,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		query.append(_FINDER_COLUMN_MAJORSTUDENTGREATERTHAN_STUDENTAGE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentAge);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where studentAge &gt; &#63; from the database.
	 *
	 * @param studentAge the student age
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymajorStudentGreaterThan(int studentAge)
		throws SystemException {
		for (Student student : findBymajorStudentGreaterThan(studentAge,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where studentAge &gt; &#63;.
	 *
	 * @param studentAge the student age
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymajorStudentGreaterThan(int studentAge)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_MAJORSTUDENTGREATERTHAN;

		Object[] finderArgs = new Object[] { studentAge };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_MAJORSTUDENTGREATERTHAN_STUDENTAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentAge);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MAJORSTUDENTGREATERTHAN_STUDENTAGE_2 =
		"student.studentAge > ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MINORSTUDENTLESSTHAN =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByminorStudentLessThan",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_MINORSTUDENTLESSTHAN =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByminorStudentLessThan",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the students where studentAge &lt; &#63;.
	 *
	 * @param studentAge the student age
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findByminorStudentLessThan(int studentAge)
		throws SystemException {
		return findByminorStudentLessThan(studentAge, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findByminorStudentLessThan(int studentAge, int start,
		int end) throws SystemException {
		return findByminorStudentLessThan(studentAge, start, end, null);
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
	@Override
	public List<Student> findByminorStudentLessThan(int studentAge, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MINORSTUDENTLESSTHAN;
		finderArgs = new Object[] { studentAge, start, end, orderByComparator };

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if ((studentAge <= student.getStudentAge())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_MINORSTUDENTLESSTHAN_STUDENTAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentAge);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Student findByminorStudentLessThan_First(int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByminorStudentLessThan_First(studentAge,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where studentAge &lt; &#63;.
	 *
	 * @param studentAge the student age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByminorStudentLessThan_First(int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findByminorStudentLessThan(studentAge, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student findByminorStudentLessThan_Last(int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByminorStudentLessThan_Last(studentAge,
				orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where studentAge &lt; &#63;.
	 *
	 * @param studentAge the student age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByminorStudentLessThan_Last(int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByminorStudentLessThan(studentAge);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByminorStudentLessThan(studentAge, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student[] findByminorStudentLessThan_PrevAndNext(long studentId,
		int studentAge, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByminorStudentLessThan_PrevAndNext(session, student,
					studentAge, orderByComparator, true);

			array[1] = student;

			array[2] = getByminorStudentLessThan_PrevAndNext(session, student,
					studentAge, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByminorStudentLessThan_PrevAndNext(Session session,
		Student student, int studentAge, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		query.append(_FINDER_COLUMN_MINORSTUDENTLESSTHAN_STUDENTAGE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentAge);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where studentAge &lt; &#63; from the database.
	 *
	 * @param studentAge the student age
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByminorStudentLessThan(int studentAge)
		throws SystemException {
		for (Student student : findByminorStudentLessThan(studentAge,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where studentAge &lt; &#63;.
	 *
	 * @param studentAge the student age
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByminorStudentLessThan(int studentAge)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_MINORSTUDENTLESSTHAN;

		Object[] finderArgs = new Object[] { studentAge };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_MINORSTUDENTLESSTHAN_STUDENTAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentAge);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MINORSTUDENTLESSTHAN_STUDENTAGE_2 =
		"student.studentAge < ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MULIPLEAGES =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymulipleAges",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULIPLEAGES =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymulipleAges",
			new String[] { Integer.class.getName() },
			StudentModelImpl.STUDENTAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MULIPLEAGES = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymulipleAges",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_MULIPLEAGES =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBymulipleAges",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the students where studentAge = &#63;.
	 *
	 * @param studentAge the student age
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findBymulipleAges(int studentAge)
		throws SystemException {
		return findBymulipleAges(studentAge, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findBymulipleAges(int studentAge, int start, int end)
		throws SystemException {
		return findBymulipleAges(studentAge, start, end, null);
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
	@Override
	public List<Student> findBymulipleAges(int studentAge, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULIPLEAGES;
			finderArgs = new Object[] { studentAge };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MULIPLEAGES;
			finderArgs = new Object[] { studentAge, start, end, orderByComparator };
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if ((studentAge != student.getStudentAge())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_MULIPLEAGES_STUDENTAGE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentAge);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Student findBymulipleAges_First(int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchBymulipleAges_First(studentAge, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where studentAge = &#63;.
	 *
	 * @param studentAge the student age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchBymulipleAges_First(int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findBymulipleAges(studentAge, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student findBymulipleAges_Last(int studentAge,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchBymulipleAges_Last(studentAge, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("studentAge=");
		msg.append(studentAge);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where studentAge = &#63;.
	 *
	 * @param studentAge the student age
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchBymulipleAges_Last(int studentAge,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBymulipleAges(studentAge);

		if (count == 0) {
			return null;
		}

		List<Student> list = findBymulipleAges(studentAge, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student[] findBymulipleAges_PrevAndNext(long studentId,
		int studentAge, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getBymulipleAges_PrevAndNext(session, student,
					studentAge, orderByComparator, true);

			array[1] = student;

			array[2] = getBymulipleAges_PrevAndNext(session, student,
					studentAge, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getBymulipleAges_PrevAndNext(Session session,
		Student student, int studentAge, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		query.append(_FINDER_COLUMN_MULIPLEAGES_STUDENTAGE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(studentAge);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	@Override
	public List<Student> findBymulipleAges(int[] studentAges)
		throws SystemException {
		return findBymulipleAges(studentAges, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findBymulipleAges(int[] studentAges, int start, int end)
		throws SystemException {
		return findBymulipleAges(studentAges, start, end, null);
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
	@Override
	public List<Student> findBymulipleAges(int[] studentAges, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		if ((studentAges != null) && (studentAges.length == 1)) {
			return findBymulipleAges(studentAges[0], start, end,
				orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] { StringUtil.merge(studentAges) };
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(studentAges),
					
					start, end, orderByComparator
				};
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_MULIPLEAGES,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if (!ArrayUtil.contains(studentAges, student.getStudentAge())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_STUDENT_WHERE);

			boolean conjunctionable = false;

			if ((studentAges == null) || (studentAges.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < studentAges.length; i++) {
					query.append(_FINDER_COLUMN_MULIPLEAGES_STUDENTAGE_5);

					if ((i + 1) < studentAges.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (studentAges != null) {
					qPos.add(studentAges);
				}

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_MULIPLEAGES,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_MULIPLEAGES,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the students where studentAge = &#63; from the database.
	 *
	 * @param studentAge the student age
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymulipleAges(int studentAge) throws SystemException {
		for (Student student : findBymulipleAges(studentAge, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where studentAge = &#63;.
	 *
	 * @param studentAge the student age
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymulipleAges(int studentAge) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MULIPLEAGES;

		Object[] finderArgs = new Object[] { studentAge };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			query.append(_FINDER_COLUMN_MULIPLEAGES_STUDENTAGE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studentAge);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of students where studentAge = any &#63;.
	 *
	 * @param studentAges the student ages
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymulipleAges(int[] studentAges) throws SystemException {
		Object[] finderArgs = new Object[] { StringUtil.merge(studentAges) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_MULIPLEAGES,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_STUDENT_WHERE);

			boolean conjunctionable = false;

			if ((studentAges == null) || (studentAges.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < studentAges.length; i++) {
					query.append(_FINDER_COLUMN_MULIPLEAGES_STUDENTAGE_5);

					if ((i + 1) < studentAges.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (studentAges != null) {
					qPos.add(studentAges);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_MULIPLEAGES,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_MULIPLEAGES,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MULIPLEAGES_STUDENTAGE_2 = "student.studentAge = ?";
	private static final String _FINDER_COLUMN_MULIPLEAGES_STUDENTAGE_5 = "(" +
		removeConjunction(_FINDER_COLUMN_MULIPLEAGES_STUDENTAGE_2) + ")";

	public StudentPersistenceImpl() {
		setModelClass(Student.class);
	}

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	@Override
	public void cacheResult(Student student) {
		EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYSTUDENTID,
			new Object[] { student.getStudentId() }, student);

		student.resetOriginalValues();
	}

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	@Override
	public void cacheResult(List<Student> students) {
		for (Student student : students) {
			if (EntityCacheUtil.getResult(
						StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, student.getPrimaryKey()) == null) {
				cacheResult(student);
			}
			else {
				student.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all students.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Student student) {
		EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(student);
	}

	@Override
	public void clearCache(List<Student> students) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Student student : students) {
			EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
				StudentImpl.class, student.getPrimaryKey());

			clearUniqueFindersCache(student);
		}
	}

	protected void cacheUniqueFindersCache(Student student) {
		if (student.isNew()) {
			Object[] args = new Object[] { student.getStudentId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYSTUDENTID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYSTUDENTID, args,
				student);
		}
		else {
			StudentModelImpl studentModelImpl = (StudentModelImpl)student;

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BYSTUDENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { student.getStudentId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BYSTUDENTID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BYSTUDENTID,
					args, student);
			}
		}
	}

	protected void clearUniqueFindersCache(Student student) {
		StudentModelImpl studentModelImpl = (StudentModelImpl)student;

		Object[] args = new Object[] { student.getStudentId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSTUDENTID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYSTUDENTID, args);

		if ((studentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BYSTUDENTID.getColumnBitmask()) != 0) {
			args = new Object[] { studentModelImpl.getOriginalStudentId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BYSTUDENTID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BYSTUDENTID, args);
		}
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	@Override
	public Student create(long studentId) {
		Student student = new StudentImpl();

		student.setNew(true);
		student.setPrimaryKey(studentId);

		return student;
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student remove(long studentId)
		throws NoSuchStudentException, SystemException {
		return remove((Serializable)studentId);
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student that was removed
	 * @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student remove(Serializable primaryKey)
		throws NoSuchStudentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Student student = (Student)session.get(StudentImpl.class, primaryKey);

			if (student == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(student);
		}
		catch (NoSuchStudentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Student removeImpl(Student student) throws SystemException {
		student = toUnwrappedModel(student);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(student)) {
				student = (Student)session.get(StudentImpl.class,
						student.getPrimaryKeyObj());
			}

			if (student != null) {
				session.delete(student);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (student != null) {
			clearCache(student);
		}

		return student;
	}

	@Override
	public Student updateImpl(com.meera.dbservice.model.Student student)
		throws SystemException {
		student = toUnwrappedModel(student);

		boolean isNew = student.isNew();

		StudentModelImpl studentModelImpl = (StudentModelImpl)student;

		Session session = null;

		try {
			session = openSession();

			if (student.isNew()) {
				session.save(student);

				student.setNew(false);
			}
			else {
				session.merge(student);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getOriginalStudentGender()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GENDER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER,
					args);

				args = new Object[] { studentModelImpl.getStudentGender() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GENDER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER,
					args);
			}

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER_AGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getOriginalStudentGender(),
						studentModelImpl.getOriginalStudentAge()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GENDER_AGE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER_AGE,
					args);

				args = new Object[] {
						studentModelImpl.getStudentGender(),
						studentModelImpl.getStudentAge()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GENDER_AGE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GENDER_AGE,
					args);
			}

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEMALESTUDENTS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getOriginalStudentAge()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEMALESTUDENTS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEMALESTUDENTS,
					args);

				args = new Object[] { studentModelImpl.getStudentAge() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FEMALESTUDENTS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FEMALESTUDENTS,
					args);
			}

			if ((studentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULIPLEAGES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						studentModelImpl.getOriginalStudentAge()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MULIPLEAGES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULIPLEAGES,
					args);

				args = new Object[] { studentModelImpl.getStudentAge() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MULIPLEAGES,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULIPLEAGES,
					args);
			}
		}

		EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student);

		clearUniqueFindersCache(student);
		cacheUniqueFindersCache(student);

		return student;
	}

	protected Student toUnwrappedModel(Student student) {
		if (student instanceof StudentImpl) {
			return student;
		}

		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setNew(student.isNew());
		studentImpl.setPrimaryKey(student.getPrimaryKey());

		studentImpl.setStudentId(student.getStudentId());
		studentImpl.setFirstName(student.getFirstName());
		studentImpl.setLastName(student.getLastName());
		studentImpl.setStudentAge(student.getStudentAge());
		studentImpl.setStudentGender(student.getStudentGender());
		studentImpl.setStudentAddress(student.getStudentAddress());

		return studentImpl;
	}

	/**
	 * Returns the student with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student
	 * @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByPrimaryKey(primaryKey);

		if (student == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or throws a {@link com.meera.dbservice.NoSuchStudentException} if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws com.meera.dbservice.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student findByPrimaryKey(long studentId)
		throws NoSuchStudentException, SystemException {
		return findByPrimaryKey((Serializable)studentId);
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Student student = (Student)EntityCacheUtil.getResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
				StudentImpl.class, primaryKey);

		if (student == _nullStudent) {
			return null;
		}

		if (student == null) {
			Session session = null;

			try {
				session = openSession();

				student = (Student)session.get(StudentImpl.class, primaryKey);

				if (student != null) {
					cacheResult(student);
				}
				else {
					EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, primaryKey, _nullStudent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
					StudentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByPrimaryKey(long studentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)studentId);
	}

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Student> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENT;

				if (pagination) {
					sql = sql.concat(StudentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the students from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Student student : findAll()) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the student persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.meera.dbservice.model.Student")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Student>> listenersList = new ArrayList<ModelListener<Student>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Student>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(StudentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STUDENT = "SELECT student FROM Student student";
	private static final String _SQL_SELECT_STUDENT_WHERE = "SELECT student FROM Student student WHERE ";
	private static final String _SQL_COUNT_STUDENT = "SELECT COUNT(student) FROM Student student";
	private static final String _SQL_COUNT_STUDENT_WHERE = "SELECT COUNT(student) FROM Student student WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "student.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Student exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Student exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudentPersistenceImpl.class);
	private static Student _nullStudent = new StudentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Student> toCacheModel() {
				return _nullStudentCacheModel;
			}
		};

	private static CacheModel<Student> _nullStudentCacheModel = new CacheModel<Student>() {
			@Override
			public Student toEntityModel() {
				return _nullStudent;
			}
		};
}