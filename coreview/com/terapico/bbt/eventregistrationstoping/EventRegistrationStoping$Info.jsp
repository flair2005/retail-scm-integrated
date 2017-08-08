
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty eventRegistrationStoping}">
<div class="col-xs-12 col-md-4 section">
	<b title="A EventRegistrationStoping">${userContext.localeMap['event_registration_stoping']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./eventRegistrationStopingManager/loadEventRegistrationStopingDetail/${eventRegistrationStoping.id}/"> ${eventRegistrationStoping.id}</a></li>
<li><span>${userContext.localeMap['event_registration_stoping.who']}</span> ${eventRegistrationStoping.who}</li>
<li><span>${userContext.localeMap['event_registration_stoping.confirm_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${eventRegistrationStoping.confirmDate}" /></li>
<li><span>${userContext.localeMap['event_registration_stoping.comment']}</span> ${eventRegistrationStoping.comment}</li>

	
	</ul>
	
	
	
</div>

</c:if>




