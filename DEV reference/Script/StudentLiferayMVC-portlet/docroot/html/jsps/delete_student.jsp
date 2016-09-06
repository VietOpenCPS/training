<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.meera.dbservice.service.StudentLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.meera.dbservice.model.Student"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<portlet:renderURL var="homeURL"></portlet:renderURL>
<portlet:actionURL var="deleteStudentActionURL" windowState="normal" name="deleteStudent">
</portlet:actionURL>
<portlet:actionURL var="getStudentActionURL" windowState="normal" name="getStudent">
<portlet:param name="cmd" value="DELETE"/>
</portlet:actionURL>
<h2>Delete Student</h2>
<a href="<%=homeURL.toString() %>">Home</a><br/><br/>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"student-delete-success")){%>
<liferay-ui:success key="student-delete-success" message="Selected Student information have been deleted successfully." />
<%} %>
<% if(SessionErrors.contains(renderRequest.getPortletSession(),"student-delete-error")){%>
<liferay-ui:error key="student-delete-error" message="There is an Error occured while deleting student please try again" />
<%} %>
<%
List<Student> studentList=StudentLocalServiceUtil.getStudents(0,StudentLocalServiceUtil.getStudentsCount());
Student selecteStudentObject=(Student)renderRequest.getAttribute("studentObject");
%>
<form action="<%=getStudentActionURL.toString()%>" name="studentForm"  method="POST">
<b>Select Student ID</b><br>
<select name="<portlet:namespace/>studentId" onchange="submitform(this.value);">
<option value="-1">--select--</option>
<%for(Student student:studentList){%>
  <option value="<%=student.getStudentId()%>" <%=selecteStudentObject!=null&&selecteStudentObject.getStudentId()==student.getStudentId()?"selected":""%>><%=student.getStudentId()%></option>
  <%} %>
</select><br>
<%if(selecteStudentObject!=null){%>
Student Name:<%=selecteStudentObject.getFirstName()+"&nbsp;"+selecteStudentObject.getLastName()%><br/>
Student Age: <%=selecteStudentObject.getStudentAge() %><br/>
Student Gender: <%=selecteStudentObject.getStudentGender()==1?"Male":"Famale"%><br/>
Address: <%=selecteStudentObject.getStudentAddress()%><br/>
<input type="button" name="deleteStudent" id="addStudent" value="Delete Student" onclick="deleteStudentRecord();"/>
<%}%>
</form>
<script>
function submitform(selectedValue)
{
  if(selectedValue!="-1"){
	  document.studentForm.submit();  
  }
	
}
function deleteStudentRecord()
{ 
	document.studentForm.action="<%=deleteStudentActionURL.toString()%>"
    document.studentForm.submit();
}
</script>
