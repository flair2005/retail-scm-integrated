
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty event}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A Event" style="color: green">${userContext.localeMap['event']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['event.id']}</span> ${event.id}</li>
<li><span>${userContext.localeMap['event.title']}</span> ${event.title}</li>
<li><span>${userContext.localeMap['event.publish_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${event.publishDate}" /></li>
<li><span>${userContext.localeMap['event.registration_start_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${event.registrationStartDate}" /></li>
<li><span>${userContext.localeMap['event.registration_stop_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${event.registrationStopDate}" /></li>
<li><span>${userContext.localeMap['event.event_location']}</span> ${event.eventLocation}</li>
<li><span>${userContext.localeMap['event.city']}</span> ${event.city}</li>
<li><span>${userContext.localeMap['event.cover_image_path']}</span> ${event.coverImagePath}</li>
<li><span>${userContext.localeMap['event.image_path1']}</span> ${event.imagePath1}</li>
<li><span>${userContext.localeMap['event.image_path2']}</span> ${event.imagePath2}</li>
<li><span>${userContext.localeMap['event.image_path3']}</span> ${event.imagePath3}</li>
<li><span>${userContext.localeMap['event.image_path4']}</span> ${event.imagePath4}</li>
<li><span>${userContext.localeMap['event.image_path5']}</span> ${event.imagePath5}</li>
<li><span>${userContext.localeMap['event.image_path6']}</span> ${event.imagePath6}</li>
<li><span>${userContext.localeMap['event.image_path7']}</span> ${event.imagePath7}</li>
<li><span>${userContext.localeMap['event.image_path8']}</span> ${event.imagePath8}</li>
<li><span>${userContext.localeMap['event.image_path9']}</span> ${event.imagePath9}</li>
<li><span>${userContext.localeMap['event.read_count']}</span> ${event.readCount}</li>
<li><span>${userContext.localeMap['event.reply_count']}</span> ${event.replyCount}</li>
<li><span>${userContext.localeMap['event.favor_count']}</span> ${event.favorCount}</li>
<li><span>${userContext.localeMap['event.like_count']}</span> ${event.likeCount}</li>
<li><span>${userContext.localeMap['event.content']}</span> ${event.content}</li>
<li><span>${userContext.localeMap['event.current_status']}</span> ${event.currentStatus}</li>

	
	</ul>
</div>



</c:if>


