<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<h1>Liferay Service Builder/ Student CRUD Operations</h1>
<portlet:renderURL var="addStudent">
<portlet:param name="mvcPath" value="/html/jsps/add_student.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="updateStudent">
<portlet:param name="mvcPath" value="/html/jsps/update_student.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="studentSearch">
<portlet:param name="mvcPath" value="/html/jsps/student_search_container.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="deleteStudent">
<portlet:param name="mvcPath" value="/html/jsps/delete_student.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="viewAllStudents">
<portlet:param name="mvcPath" value="/html/jsps/view_all_students.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="getStudentByGenderAndAge">
<portlet:param name="mvcPath" value="/html/jsps/get_students_by_gender_age.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="finderExampleURL">
<portlet:param name="mvcPath" value="/html/jsps/finder_methods_usage.jsp"/>
</portlet:renderURL>
<br/>
<a href="<%=addStudent.toString()%>">Add Student</a><br/>
<a href="<%=updateStudent.toString()%>">Update Student</a><br/>
<a href="<%=deleteStudent.toString()%>">Delete Student</a><br/>
<a href="<%=studentSearch.toString()%>">Student Search</a><br/>
<a href="<%=viewAllStudents.toString()%>">View All Students</a><br/>
<a href="<%=getStudentByGenderAndAge.toString()%>">Get Student By Gender And Age</a><br/>
<a href="<%=finderExampleURL.toString()%>">Service Builder Finder Examples </a><br/>


