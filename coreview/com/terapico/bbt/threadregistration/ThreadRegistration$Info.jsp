
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty threadRegistration}">
<div class="col-xs-12 col-md-4 section">
	<b title="A ThreadRegistration">${userContext.localeMap['thread_registration']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./threadRegistrationManager/loadThreadRegistrationDetail/${threadRegistration.id}/"> ${threadRegistration.id}</a></li>
<li><span>${userContext.localeMap['thread_registration.register_date']}</span> ${threadRegistration.registerDate}</li>
<li><span>${userContext.localeMap['thread_registration.comments']}</span> ${threadRegistration.comments}</li>
<li><span>${userContext.localeMap['thread_registration.participant_nickname']}</span> ${threadRegistration.participantNickname}</li>
<li><span>${userContext.localeMap['thread_registration.participant_avarta']}</span> ${threadRegistration.participantAvarta}</li>

	
	</ul>
	
	
	
</div>

</c:if>




