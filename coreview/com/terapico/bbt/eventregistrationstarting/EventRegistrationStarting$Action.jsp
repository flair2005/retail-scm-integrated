
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty eventRegistrationStarting}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A EventRegistrationStarting" style="color: green">${userContext.localeMap['event_registration_starting']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['event_registration_starting.id']}</span> ${eventRegistrationStarting.id}</li>
<li><span>${userContext.localeMap['event_registration_starting.who']}</span> ${eventRegistrationStarting.who}</li>
<li><span>${userContext.localeMap['event_registration_starting.confirm_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${eventRegistrationStarting.confirmDate}" /></li>
<li><span>${userContext.localeMap['event_registration_starting.comment']}</span> ${eventRegistrationStarting.comment}</li>

	
	</ul>
</div>



</c:if>


