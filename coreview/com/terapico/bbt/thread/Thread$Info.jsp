
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty thread}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Thread">${userContext.localeMap['thread']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./threadManager/loadThreadDetail/${thread.id}/"> ${thread.id}</a></li>
<li><span>${userContext.localeMap['thread.title']}</span> ${thread.title}</li>
<li><span>${userContext.localeMap['thread.publish_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${thread.publishDate}" /></li>
<li><span>${userContext.localeMap['thread.registration_start_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${thread.registrationStartDate}" /></li>
<li><span>${userContext.localeMap['thread.registration_stop_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${thread.registrationStopDate}" /></li>
<li><span>${userContext.localeMap['thread.thread_location']}</span> ${thread.threadLocation}</li>
<li><span>${userContext.localeMap['thread.city']}</span> ${thread.city}</li>
<li><span>${userContext.localeMap['thread.thread_type']}</span> ${thread.threadType}</li>
<li><span>${userContext.localeMap['thread.cover_image_path']}</span> ${thread.coverImagePath}</li>
<li><span>${userContext.localeMap['thread.image_path1']}</span> ${thread.imagePath1}</li>
<li><span>${userContext.localeMap['thread.image_path2']}</span> ${thread.imagePath2}</li>
<li><span>${userContext.localeMap['thread.image_path3']}</span> ${thread.imagePath3}</li>
<li><span>${userContext.localeMap['thread.image_path4']}</span> ${thread.imagePath4}</li>
<li><span>${userContext.localeMap['thread.image_path5']}</span> ${thread.imagePath5}</li>
<li><span>${userContext.localeMap['thread.image_path6']}</span> ${thread.imagePath6}</li>
<li><span>${userContext.localeMap['thread.image_path7']}</span> ${thread.imagePath7}</li>
<li><span>${userContext.localeMap['thread.image_path8']}</span> ${thread.imagePath8}</li>
<li><span>${userContext.localeMap['thread.image_path9']}</span> ${thread.imagePath9}</li>
<li><span>${userContext.localeMap['thread.read_count']}</span> ${thread.readCount}</li>
<li><span>${userContext.localeMap['thread.reply_count']}</span> ${thread.replyCount}</li>
<li><span>${userContext.localeMap['thread.favor_count']}</span> ${thread.favorCount}</li>
<li><span>${userContext.localeMap['thread.like_count']}</span> ${thread.likeCount}</li>
<li><span>${userContext.localeMap['thread.content']}</span> ${thread.content}</li>
<li><span>${userContext.localeMap['thread.current_status']}</span> ${thread.currentStatus}</li>

	
	</ul>
	
	
	
</div>

</c:if>




