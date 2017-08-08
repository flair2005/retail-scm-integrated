
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty interviewType}">
<div class="col-xs-12 col-md-4 section">
	<b title="A InterviewType">${userContext.localeMap['interview_type']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./interviewTypeManager/loadInterviewTypeDetail/${interviewType.id}/"> ${interviewType.id}</a></li>
<li><span>${userContext.localeMap['interview_type.code']}</span> ${interviewType.code}</li>
<li><span>${userContext.localeMap['interview_type.description']}</span> ${interviewType.description}</li>
<li><span>${userContext.localeMap['interview_type.detail_description']}</span> ${interviewType.detailDescription}</li>

	
	</ul>
	
	
	
</div>

</c:if>




