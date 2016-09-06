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

package com.meera.dbservice.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.meera.dbservice.service.ClpSerializer;
import com.meera.dbservice.service.StudentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiferaySavvy
 */
public class StudentClp extends BaseModelImpl<Student> implements Student {
	public StudentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Student.class;
	}

	@Override
	public String getModelClassName() {
		return Student.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _studentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStudentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _studentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentId", getStudentId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("studentAge", getStudentAge());
		attributes.put("studentGender", getStudentGender());
		attributes.put("studentAddress", getStudentAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Integer studentAge = (Integer)attributes.get("studentAge");

		if (studentAge != null) {
			setStudentAge(studentAge);
		}

		Integer studentGender = (Integer)attributes.get("studentGender");

		if (studentGender != null) {
			setStudentGender(studentGender);
		}

		String studentAddress = (String)attributes.get("studentAddress");

		if (studentAddress != null) {
			setStudentAddress(studentAddress);
		}
	}

	@Override
	public long getStudentId() {
		return _studentId;
	}

	@Override
	public void setStudentId(long studentId) {
		_studentId = studentId;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setStudentId", long.class);

				method.invoke(_studentRemoteModel, studentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_studentRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_studentRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStudentAge() {
		return _studentAge;
	}

	@Override
	public void setStudentAge(int studentAge) {
		_studentAge = studentAge;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setStudentAge", int.class);

				method.invoke(_studentRemoteModel, studentAge);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStudentGender() {
		return _studentGender;
	}

	@Override
	public void setStudentGender(int studentGender) {
		_studentGender = studentGender;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setStudentGender", int.class);

				method.invoke(_studentRemoteModel, studentGender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStudentAddress() {
		return _studentAddress;
	}

	@Override
	public void setStudentAddress(String studentAddress) {
		_studentAddress = studentAddress;

		if (_studentRemoteModel != null) {
			try {
				Class<?> clazz = _studentRemoteModel.getClass();

				Method method = clazz.getMethod("setStudentAddress",
						String.class);

				method.invoke(_studentRemoteModel, studentAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStudentRemoteModel() {
		return _studentRemoteModel;
	}

	public void setStudentRemoteModel(BaseModel<?> studentRemoteModel) {
		_studentRemoteModel = studentRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _studentRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_studentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StudentLocalServiceUtil.addStudent(this);
		}
		else {
			StudentLocalServiceUtil.updateStudent(this);
		}
	}

	@Override
	public Student toEscapedModel() {
		return (Student)ProxyUtil.newProxyInstance(Student.class.getClassLoader(),
			new Class[] { Student.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudentClp clone = new StudentClp();

		clone.setStudentId(getStudentId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setStudentAge(getStudentAge());
		clone.setStudentGender(getStudentGender());
		clone.setStudentAddress(getStudentAddress());

		return clone;
	}

	@Override
	public int compareTo(Student student) {
		int value = 0;

		if (getStudentId() < student.getStudentId()) {
			value = -1;
		}
		else if (getStudentId() > student.getStudentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentClp)) {
			return false;
		}

		StudentClp student = (StudentClp)obj;

		long primaryKey = student.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{studentId=");
		sb.append(getStudentId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", studentAge=");
		sb.append(getStudentAge());
		sb.append(", studentGender=");
		sb.append(getStudentGender());
		sb.append(", studentAddress=");
		sb.append(getStudentAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.meera.dbservice.model.Student");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentAge</column-name><column-value><![CDATA[");
		sb.append(getStudentAge());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentGender</column-name><column-value><![CDATA[");
		sb.append(getStudentGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studentAddress</column-name><column-value><![CDATA[");
		sb.append(getStudentAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _studentId;
	private String _firstName;
	private String _lastName;
	private int _studentAge;
	private int _studentGender;
	private String _studentAddress;
	private BaseModel<?> _studentRemoteModel;
	private Class<?> _clpSerializerClass = com.meera.dbservice.service.ClpSerializer.class;
}