<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.meera.dbservice.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.meera.dbservice.service.StudentLocalServiceUtil"%>
<%@ include file="init.jsp"%>
<a href="<portlet:renderURL />">&laquo;Home</a>
<div class="separator"></div>
<liferay-portlet:renderURL varImpl="getStudentsByAgeAndGender">
<portlet:param name="mvcPath" value="/html/jsps/get_students_by_gender_age.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="studentAge" value="<%= String.valueOf(studentAge) %>" />
		<portlet:param name="studentGender" value="<%= String.valueOf(studentGender) %>" />
		<portlet:param name="mvcPath" value="/html/jsps/get_students_by_gender_age.jsp" />
	</liferay-portlet:renderURL>
<h2>Search Students</h2><br/>
<form action="<%=getStudentsByAgeAndGender%>" name="studentForm"  method="POST">
<b>Age</b><br/>
<input type="text" name="<portlet:namespace/>studentAge" id="<portlet:namespace/>studentAge" value="<%=String.valueOf(studentAge)%>"/><br/>
<b>Gender</b><br/>
<input type="radio" name="<portlet:namespace/>studentGender" value="1" <%=studentGender==1?"checked":""%>>Male<br>
<input type="radio" name="<portlet:namespace/>studentGender" value="0" <%=studentGender==0?"checked":""%>>Female<br/>
<input type="submit" name="addStudent" id="addStudent" value="Search"/>
</form>
<liferay-ui:search-container
		displayTerms="<%= new DisplayTerms(renderRequest) %>"
		emptyResultsMessage="there-are-no-students"
		headerNames="firstName,studentAge,studentGender"
		iteratorURL="<%= iteratorURL %>"
		delta="5"
	>
<liferay-ui:search-container-results>
		<%
		
			List<Student> studentList=StudentLocalServiceUtil.findByGenderAndAge(studentGender, studentAge);
			searchContainer.setTotal(studentList.size());
			studentList = ListUtil.subList(studentList,searchContainer.getStart(),searchContainer.getEnd());
			searchContainer.setResults(studentList);		
		%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="Student"
			keyProperty="studentId"
			modelVar="currentStudent">
			<liferay-portlet:renderURL varImpl="rowURL">
				<portlet:param name="backURL" value="<%= currentURL %>" />
				<portlet:param name="mvcPath" value="/html/jsps/display_student.jsp" />
				<portlet:param name="studentId" value="<%= String.valueOf(currentStudent.getStudentId()) %>" />
			</liferay-portlet:renderURL>
<liferay-ui:search-container-column-text
	href="<%= rowURL %>"
	name="firstName"
	property="firstName"
/>
<liferay-ui:search-container-column-text
	href="<%= rowURL %>"
	name="studentAge"
	property="studentAge"
/>
<liferay-ui:search-container-column-text
	href="<%= rowURL %>"
	name="studentGender"
	value='<%=currentStudent.getStudentGender()==1?"Male":"Female"%>'
/>
</liferay-ui:search-container-row>	
<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
	</liferay-ui:search-container>


