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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.meera.dbservice.model.Student;
import com.meera.dbservice.model.impl.StudentImpl;
import com.meera.dbservice.service.StudentLocalServiceUtil;
public class StudentMVCPortletAction extends MVCPortlet {
	public void addStudent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			String firstName = ParamUtil.getString(actionRequest, "firstName");
			String lastName = ParamUtil.getString(actionRequest, "lastName");
			int studentAge = ParamUtil.getInteger(actionRequest, "studentAge");
			int studentGender = ParamUtil.getInteger(actionRequest, "sex", 1);
			String address = ParamUtil.getString(actionRequest, "address");
			// add student record
			// create primary key
			long studentId = CounterLocalServiceUtil.increment();
			// create student persistance object
			Student student = null;
			student = new StudentImpl();
			student = StudentLocalServiceUtil.createStudent(studentId);
			// fill the data in persistance object
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setStudentAge(studentAge);
			student.setStudentGender(studentGender);
			student.setStudentAddress(address);
			// Add student persistance object to database student table
			student = StudentLocalServiceUtil.addStudent(student);
			if (student != null) {
				// adding success message
				SessionMessages.add(actionRequest.getPortletSession(),
						"student-add-success");
				_log.info("Student have been added successfylly");
			} else {
				SessionErrors.add(actionRequest.getPortletSession(),
						"student-add-error");
				_log.error("There is an Erron in adding Student");
			}
			// navigate to add student jsp page
			actionResponse.setRenderParameter("mvcPath",
					"/html/jsps/add_student.jsp");
		} catch (Exception e) {
			SessionErrors.add(actionRequest.getPortletSession(),
					"student-add-error");
			e.printStackTrace();
		}
	}

	public void deleteStudent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			long studentId = ParamUtil.getLong(actionRequest, "studentId");
			Student student = StudentLocalServiceUtil.deleteStudent(studentId);
			if (student != null) {
				// adding success message
				SessionMessages.add(actionRequest.getPortletSession(),
						"student-delete-success");
				_log.info("Student have been deleted successfylly");
			} else {
				SessionErrors.add(actionRequest.getPortletSession(),
						"student-delete-error");
				_log.error("There is an Erron in delete Student");
			}
			// navigate to add student jsp page
			actionResponse.setRenderParameter("mvcPath",
					"/html/jsps/delete_student.jsp");
		} catch (Exception e) {
			SessionErrors.add(actionRequest.getPortletSession(),
					"student-add-error");
			e.printStackTrace();
		}
	}

	public void updateStudent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			long studentId = ParamUtil.getLong(actionRequest, "studentId");
			String firstName = ParamUtil.getString(actionRequest, "firstName");
			String lastName = ParamUtil.getString(actionRequest, "lastName");
			int studentAge = ParamUtil.getInteger(actionRequest, "studentAge");
			int studentGender = ParamUtil.getInteger(actionRequest, "sex", 1);
			String address = ParamUtil.getString(actionRequest, "address");
			Student student = StudentLocalServiceUtil.getStudent(studentId);
			if (student != null) {
				// fill update information
				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setStudentAge(studentAge);
				student.setStudentGender(studentGender);
				student.setStudentAddress(address);
				student = StudentLocalServiceUtil.updateStudent(student);
				if (student != null) {
					// adding success message
					SessionMessages.add(actionRequest.getPortletSession(),
							"student-update-success");
					_log.info("Student have been updated successfylly");
				} else {
					SessionErrors.add(actionRequest.getPortletSession(),
							"student-update-error");
					_log.error("There is an Erron in delete Student");
				}
			} else {
				SessionErrors.add(actionRequest.getPortletSession(),
						"student-update-error");
				_log.error("Could not find student.");
			}
			// navigate to add student jsp page
			actionResponse.setRenderParameter("mvcPath",
					"/html/jsps/update_student.jsp");
		} catch (Exception e) {
			SessionErrors.add(actionRequest.getPortletSession(),
					"student-update-error");
			e.printStackTrace();
		}
	}

	public void getStudent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			long studentId = ParamUtil.getLong(actionRequest, "studentId");
			String cmd = ParamUtil.getString(actionRequest, "cmd");
			Student student = StudentLocalServiceUtil.getStudent(studentId);
			if (student != null) {
				// adding success message
				actionRequest.setAttribute("studentObject", student);
				_log.info("Student have been found for specific primary key successfylly");
			} else {
				_log.error("Stundet not found");
			}
			if (cmd.equals("DELETE")) {
				// navigate to add student jsp page
				actionResponse.setRenderParameter("mvcPath",
						"/html/jsps/delete_student.jsp");
			}
			if (cmd.equals("UPDATE")) {
				// navigate to add student jsp page
				actionResponse.setRenderParameter("mvcPath",
						"/html/jsps/update_student.jsp");
			}
			if (cmd.equals("VIEW")) {
				// navigate to add student jsp page
				actionResponse.setRenderParameter("mvcPath",
						"/html/jsps/display_student.jsp");
			}

		} catch (Exception e) {
			SessionErrors.add(actionRequest.getPortletSession(),
					"student-add-error");
			e.printStackTrace();
		}
	}
	private static Log _log = LogFactoryUtil
			.getLog(StudentMVCPortletAction.class);
}
