
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty eventAttendance}">
<div class="col-xs-12 col-md-4 section">
	<b title="A EventAttendance">${userContext.localeMap['event_attendance']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./eventAttendanceManager/loadEventAttendanceDetail/${eventAttendance.id}/"> ${eventAttendance.id}</a></li>
<li><span>${userContext.localeMap['event_attendance.name']}</span> ${eventAttendance.name}</li>
<li><span>${userContext.localeMap['event_attendance.description']}</span> ${eventAttendance.description}</li>

	
	</ul>
	
	
	
</div>

</c:if>




