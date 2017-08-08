
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty transportTaskTrack}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TransportTaskTrack">${userContext.localeMap['transport_task_track']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./transportTaskTrackManager/loadTransportTaskTrackDetail/${transportTaskTrack.id}/"> ${transportTaskTrack.id}</a></li>
<li><span>${userContext.localeMap['transport_task_track.track_time']}</span> ${transportTaskTrack.trackTime}</li>
<li><span>${userContext.localeMap['transport_task_track.latitude']}</span> ${transportTaskTrack.latitude}</li>
<li><span>${userContext.localeMap['transport_task_track.longitude']}</span> ${transportTaskTrack.longitude}</li>

	
	</ul>
	
	
	
</div>

</c:if>




