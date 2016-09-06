package com.meera.liferaymvc;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Role;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.meera.dbservice.model.Student;
import com.meera.dbservice.model.impl.StudentImpl;
import com.meera.dbservice.service.StudentLocalServiceUtil;
public class StudentNameComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "Student_.firstName ASC";

	public static final String ORDER_BY_DESC = "Student_.firstName DESC";

	public static final String[] ORDER_BY_FIELDS = {"firstName"};

	public StudentNameComparator() {
		this(false);
	}

	public StudentNameComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		Student student1 = (Student)obj1;
		Student student2 = (Student)obj2;

		String firstName1 = student1.getFirstName();
		String firstName2 =student2.getFirstName();

		int value = firstName1.compareTo(firstName2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}