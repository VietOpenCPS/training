<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.service.persistence.PortletUtil"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="org.opencps.feedback.service.FeedBackLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.opencps.feedback.model.FeedBack"%>
<%@page import="java.util.List"%>
<%@ include file="../../../init.jsp"%>

<%
	List<FeedBack> feedBacks = new ArrayList<FeedBack>();

	feedBacks = FeedBackLocalServiceUtil.getAll();
	
	int totalCount = FeedBackLocalServiceUtil.countAll();
	
	PortletURL iteratorURL = renderResponse.createRenderURL();
	iteratorURL.setParameter("mvcPath", "/html/portlets/feedback_admin/view.jsp");
	
%>
	
	<liferay-ui:search-container
				emptyResultsMessage="no-feedback"
				iteratorURL="<%=iteratorURL  %>"
				total="<%= totalCount %>"
			>
				<liferay-ui:search-container-results
					results="<%= feedBacks %>"
				/>

				<liferay-ui:search-container-row
					className="org.opencps.feedback.model.FeedBack"
					escapedModel="<%= true %>"
					keyProperty="feedbackId"
					modelVar="feedBack"
				>
				
				<portlet:renderURL var="viewDetailURL" windowState="<%=LiferayWindowState.NORMAL.toString() %>">
					<portlet:param name="mvcPath" value="/html/portlets/feedback_admin/view_detail.jsp"/>
					<portlet:param name="feedbackId" value="<%=String.valueOf(feedBack.getFeedbackId()) %>"/>
				</portlet:renderURL>

					
					<liferay-ui:search-container-column-text 
						name="fullName" 
						value="<%=feedBack.getFullName() %>"
						href="<%=viewDetailURL %>"
					/>
					
					<liferay-ui:search-container-column-text 
						name="email" 
						value="<%=feedBack.getEmail() %>"
					/>
					
					<liferay-ui:search-container-column-text 
						name="createDate" 
						value="<%=String.valueOf(feedBack.getCreateDate()) %>"
					/>
				
				
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator paginate="<%= total > SearchContainer.DEFAULT_DELTA %>" />
	</liferay-ui:search-container>