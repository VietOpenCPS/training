<%@page import="com.meera.dbservice.model.Student"%>
<%@page import="com.meera.liferaymvc.StudentNameComparator"%>
<%@page import="com.meera.dbservice.service.StudentLocalServiceUtil"%>
<%@ include file="init.jsp" %>
<a href="<portlet:renderURL />">&laquo;Home</a>
<div class="separator"></div>
<liferay-portlet:renderURL varImpl="studentSearchURL">
<portlet:param name="mvcPath" value="/html/jsps/student_search_container.jsp" />
</liferay-portlet:renderURL>
<aui:form action="<%=studentSearchURL %>" method="get" name="studentForm">
	<liferay-portlet:renderURLParams varImpl="studentSearchURL" />
	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="firstName" value="<%= firstName %>" />
		<portlet:param name="lastName" value="<%= lastName %>" />
		<portlet:param name="studentAge" value="<%= String.valueOf(studentAge) %>" />
		<portlet:param name="studentGender" value="<%= String.valueOf(studentGender) %>" />
		<portlet:param name="studentAddress" value="<%= String.valueOf(studentAddress) %>" />
		<portlet:param name="mvcPath" value="/html/jsps/student_search_container.jsp" />
	</liferay-portlet:renderURL>
	<liferay-ui:search-container
		displayTerms="<%= new DisplayTerms(renderRequest) %>"
		emptyResultsMessage="there-are-no-students"
		headerNames="firstName,lastName,studentAge,studentGender,studentAddress"
		iteratorURL="<%= iteratorURL %>"
	>
		<liferay-ui:search-form
			page="/html/jsps/student_search.jsp"
			servletContext="<%= application %>"
		/>
<liferay-ui:search-container-results>
		<%
			DisplayTerms displayTerms =searchContainer.getDisplayTerms();
				if (displayTerms.isAdvancedSearch()) {
			total = StudentLocalServiceUtil.getSearchStudentsCount(firstName, lastName, studentAge, studentGender, studentAddress,displayTerms.isAndOperator());
			searchContainer.setTotal(total);
			searchContainer.setResults(StudentLocalServiceUtil.getSerachStudents(firstName,lastName,studentAge,studentGender,studentAddress,displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), new StudentNameComparator()));
				}else {
			String searchkeywords = displayTerms.getKeywords();
			String numbesearchkeywords = Validator.isNumber(searchkeywords) ? searchkeywords : String.valueOf(0);
			total = StudentLocalServiceUtil.getSearchStudentsCount(firstName,lastName, studentAge, studentGender, studentAddress,displayTerms.isAndOperator());
			searchContainer.setResults(StudentLocalServiceUtil.getSerachStudents(searchkeywords,searchkeywords,Integer.parseInt(numbesearchkeywords),Integer.parseInt(numbesearchkeywords), searchkeywords,false, searchContainer.getStart(), searchContainer.getEnd(), new StudentNameComparator()));
				}
				
		%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="Student"
			keyProperty="studentId"
			modelVar="currentStudent">
			<liferay-portlet:renderURL varImpl="rowURL">
				<portlet:param name="backURL" value="<%= currentURL %>" />
				<portlet:param name="mvcPath" value="/html/jsps/display_student.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="studentId" value="<%= String.valueOf(currentStudent.getStudentId()) %>" />
			</liferay-portlet:renderURL>
<liferay-ui:search-container-column-text
	href="<%= rowURL %>"
	name="firstName"
	property="firstName"
/>

<liferay-ui:search-container-column-text
	href="<%= rowURL %>"
	name="lastName"
	property="lastName"
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

<liferay-ui:search-container-column-text
	href="<%= rowURL %>"
	name="studentAddress"
	property="studentAddress"/>	
	</liferay-ui:search-container-row>	
<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
	</liferay-ui:search-container>
</aui:form>
