<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.meera.dbservice.service.StudentLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.meera.dbservice.model.Student"%>
<%@ include file="init.jsp" %>
<portlet:defineObjects />
<h2>Display Student Information</h2>
<%
String redirect = ParamUtil.getString(request, "backURL");
long studentId = ParamUtil.getLong(request, "studentId");
Student selecteStudentObject = null;
if (studentId > 0) {
	selecteStudentObject = StudentLocalServiceUtil.getStudent(studentId);
}
%>
<a href="<%=redirect %>">Back</a><br/><br/>
<%if(selecteStudentObject!=null){%>
<h3>The following are the selected Student Information</h3><br/>
Student Name:<%=selecteStudentObject.getFirstName()+"&nbsp;"+selecteStudentObject.getLastName()%><br/>
Student Age: <%=selecteStudentObject.getStudentAge() %><br/>
Student Gender: <%=selecteStudentObject.getStudentGender()==1?"Male":"Famale"%><br/>
Address: <%=selecteStudentObject.getStudentAddress()%><br/>
<%}%>
