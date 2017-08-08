
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty jobApplication}">
<div class="col-xs-12 col-md-4 section">
	<b title="A JobApplication">${userContext.localeMap['job_application']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./jobApplicationManager/loadJobApplicationDetail/${jobApplication.id}/"> ${jobApplication.id}</a></li>
<li><span>${userContext.localeMap['job_application.application_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${jobApplication.applicationTime}" /></li>
<li><span>${userContext.localeMap['job_application.who']}</span> ${jobApplication.who}</li>
<li><span>${userContext.localeMap['job_application.comments']}</span> ${jobApplication.comments}</li>

	
	</ul>
	
	
	
</div>

</c:if>




