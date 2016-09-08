<%@page import="org.opencps.feedback.model.FeedBack"%>
<%@ include file="../../../init.jsp"%>

<portlet:actionURL name="addFeedback" var="addFeedbackURL">
	<portlet:param name="type" value="true"/>
</portlet:actionURL>

<%
	FeedBack feedBack = null;
	
	feedBack  = (FeedBack)request.getAttribute("FeedBackAttribute");
%>

<aui:form action="<%=addFeedbackURL %>" name="fm" method="post">
	<aui:model-context bean="<%=feedBack %>" model="<%=FeedBack.class %>"/>
	
	<aui:input name="fullName" type="text"></aui:input>
	
	<aui:input name="email" type="text"></aui:input>
	
	<aui:input name="feedBack" type="textarea"/>
	
	<aui:button type="submit" name="submit" value="submit"/>
</aui:form>