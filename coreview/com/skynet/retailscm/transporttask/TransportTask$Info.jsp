
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty transportTask}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TransportTask">${userContext.localeMap['transport_task']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./transportTaskManager/loadTransportTaskDetail/${transportTask.id}/"> ${transportTask.id}</a></li>
<li><span>${userContext.localeMap['transport_task.name']}</span> ${transportTask.name}</li>
<li><span>${userContext.localeMap['transport_task.start']}</span> ${transportTask.start}</li>
<li><span>${userContext.localeMap['transport_task.begin_time']}</span> ${transportTask.beginTime}</li>
<li><span>${userContext.localeMap['transport_task.latitude']}</span> ${transportTask.latitude}</li>
<li><span>${userContext.localeMap['transport_task.longitude']}</span> ${transportTask.longitude}</li>

	
	</ul>
	
	
	
</div>

</c:if>




