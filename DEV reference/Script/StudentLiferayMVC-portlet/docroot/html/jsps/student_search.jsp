<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the applicable 
 * Liferay software end user license agreement ("License Agreement")
 * found on www.liferay.com/legal/eulas. You may also contact Liferay, Inc.
 * for a copy of the License Agreement. You may not use this file except in
 * compliance with the License Agreement. 
 * See the License Agreement for the specific language governing
 * permissions and limitations under the License Agreement, including 
 * but not limited to distribution rights of the Software.
 *
 */
--%>

<%@ include file="init.jsp" %>
<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");
DisplayTerms displayTerms = searchContainer.getDisplayTerms();
%>
<liferay-ui:search-toggle
	buttonLabel="Student Search"
	displayTerms="<%= displayTerms %>"
	id="toggle_id_student_search">
	<aui:input label="First Name" name="firstName" value="<%=firstName %>" />
	<aui:input label="Last Name" name="lastName" value="<%=lastName %>" />
	<aui:input label="studentAge" name="studentAge" value="<%= studentAge %>" />
	<aui:select name="studentGender">
	<aui:option label="Male" value="1"></aui:option>
	<aui:option label="Female" value="0"></aui:option>
	</aui:select>
	<aui:input label="studentAddress" name="studentAddress" value="<%= studentAddress %>" />
</liferay-ui:search-toggle>