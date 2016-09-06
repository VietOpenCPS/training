<%@page import="com.meera.dbservice.service.StudentLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp"%>
<liferay-portlet:actionURL varImpl="iteratorURL" >
	<portlet:param name="mvcPath" value="/html/jsps/view_all_students.jsp" />
</liferay-portlet:actionURL>
<a href="<portlet:renderURL />">&laquo;Home</a>
<div class="separator"></div>
<liferay-ui:search-container emptyResultsMessage="there-are-no-students"
	headerNames="firstName,lastName,studentAge,studentGender,studentAddress"
	iteratorURL="<%=iteratorURL %>"
	delta="5"
	deltaConfigurable="true"
	>
	<liferay-ui:search-container-results>
		<%
			total = StudentLocalServiceUtil.getStudentsCount();
		    results=StudentLocalServiceUtil.getStudents(searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setTotal(total);
			searchContainer.setResults(results);
		%>
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="com.meera.dbservice.model.Student"
		keyProperty="studentId" modelVar="currentStudent">
		<liferay-portlet:renderURL varImpl="rowURL">
			<portlet:param name="backURL" value="<%= currentURL %>" />
			<portlet:param name="mvcPath" value="/html/jsps/display_student.jsp" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="studentId"
				value="<%= String.valueOf(currentStudent.getStudentId()) %>" />
		</liferay-portlet:renderURL>
		<liferay-ui:search-container-row-parameter
			name="rowURL"
			value="<%= rowURL.toString() %>"/>
		<liferay-ui:search-container-column-text href="<%= rowURL %>"
			name="firstName" property="firstName" />

		<liferay-ui:search-container-column-text href="<%= rowURL %>"
			name="lastName" property="lastName" />

		<liferay-ui:search-container-column-text href="<%= rowURL %>"
			name="studentAge" property="studentAge" />

		<liferay-ui:search-container-column-text href="<%= rowURL %>"
			name="studentGender"
			value='<%=currentStudent.getStudentGender()==1?"Male":"Female"%>' />
	<liferay-ui:search-container-column-jsp
			align="left"
			name="Student Address"
			path="/html/jsps/student_address_details.jsp"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
</liferay-ui:search-container>
