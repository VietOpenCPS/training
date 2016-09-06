<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.meera.dbservice.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.meera.dbservice.service.StudentLocalServiceUtil"%>
<%@ include file="init.jsp"%>
<a href="<portlet:renderURL />">&laquo;Home</a>
<div class="separator"></div>

<h2>The following method return only one Student Object
</h2><br/>
<b>StudentLocalServiceUtil.usingUniqueAttributeforFindertag(1)</b><br/>

<h2>The following method is example for Arrayble Operator and method take array of values</h2><br/><br/>
<%
int[] ageArray = {29,34,23};
%>
<b>int[] ageArray = {29,34,23};</b><br/>
<b>StudentLocalServiceUtil.usingArrableOperatorOnFindeCoumn(ageArray)</b><br/>
<%="Number studenr"+StudentLocalServiceUtil.usingArrableOperatorOnFindeCoumn(ageArray) +"<br/>"%><br/>
<h2>The following method is example for Like  Operator</h2><br/><br/>
<b>StudentLocalServiceUtil.usingLikeOperatorOnFinderColumn("meera")</b><br/>
<%="Number of Students using Like Operator:"+StudentLocalServiceUtil.usingLikeOperatorOnFinderColumn("meera")+"<br/>"%>
<h2>The following method is example for Greater then Operator</h2><br/>
<b>StudentLocalServiceUtil.usingGreaterThanOnFinderCoulumn(23)</b><br/>
<%="Number of Students greater then Age 23:"+StudentLocalServiceUtil.usingGreaterThanOnFinderCoulumn(23)+"<br/>"%><br/>

<h2>The following method is example for Less then Operator</h2><br/>
<b>StudentLocalServiceUtil.usingLessThanOnFinderCoulumn(30)</b><br/>
<%="Number of Students Less then Age 23:"+StudentLocalServiceUtil.usingLessThanOnFinderCoulumn(30)+"<br/>"%>
<h2>The following method is example for using Where attribute in Finder tag and it always fetch Female Students</h2><br/><br/>
<b>StudentLocalServiceUtil.usingWhereAttrobuteInFinderTag(27)</b><br/>
<%="Number of Female:"+StudentLocalServiceUtil.usingWhereAttrobuteInFinderTag(27)+"<br/>"%><br/>