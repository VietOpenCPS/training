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
<portlet:actionURL var="updateStudentActionURL" windowState="normal" name="updateStudent">
</portlet:actionURL>
<portlet:actionURL var="getStudentActionURL" windowState="normal" name="getStudent">
<portlet:param name="cmd" value="UPDATE"/>
</portlet:actionURL>
<h2>Update Student</h2>
<a href="<%=homeURL.toString() %>">Home</a><br/><br/>
<% if(SessionMessages.contains(renderRequest.getPortletSession(),"student-update-success")){%>
<liferay-ui:success key="student-update-success" message="Selected Student information have been updated successfully." />
<%} %>
<% if(SessionErrors.contains(renderRequest.getPortletSession(),"student-update-error")){%>
<liferay-ui:error key="student-update-error" message="There is an Error occured while updating student please try again" />
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
<b>First Name</b><br/>
<input  type="text" name="<portlet:namespace/>firstName" id="<portlet:namespace/>firstName" value="<%=selecteStudentObject.getFirstName()%>"/><br/>
<b>Last Name</b><br/>
<input type="text" name="<portlet:namespace/>lastName" id="<portlet:namespace/>lastName" value="<%=selecteStudentObject.getLastName()%>"/><br/>
<b>Age</b><br/>
<input type="text" name="<portlet:namespace/>studentAge" id="<portlet:namespace/>studentAge" value="<%=selecteStudentObject.getStudentAge()%>"/><br/>
<b>Gender</b><br/>
<input type="radio" name="<portlet:namespace/>sex" value="1" <%=selecteStudentObject.getStudentGender()==1?"checked":""%>>Male<br>
<input type="radio" name="<portlet:namespace/>sex" value="0" <%=selecteStudentObject.getStudentGender()==0?"checked":""%>>Female<br/>
<b>Address</b><br/>
<textarea rows="4" cols="50" name="<portlet:namespace/>address">
<%=selecteStudentObject.getStudentAddress()%>
</textarea><br/>
<input type="button" name="updateStudent" id="updateStudent" value="Update Student" onclick="updateStudentRecord();"/>
<%}%>
</form>
<script>
function submitform(selectedValue)
{
  if(selectedValue!="-1"){
	  document.studentForm.submit();  
  }
	
}
function updateStudentRecord()
{ 
	document.studentForm.action="<%=updateStudentActionURL.toString()%>"
    document.studentForm.submit();
}
</script>
