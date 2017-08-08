
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty task}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Task">${userContext.localeMap['task']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./taskManager/loadTaskDetail/${task.id}/"> ${task.id}</a></li>
<li><span>${userContext.localeMap['task.title']}</span> ${task.title}</li>
<li><span>${userContext.localeMap['task.publish_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${task.publishDate}" /></li>
<li><span>${userContext.localeMap['task.content']}</span> ${task.content}</li>
<li><span>${userContext.localeMap['task.cover_image_path']}</span> ${task.coverImagePath}</li>
<li><span>${userContext.localeMap['task.image_path1']}</span> ${task.imagePath1}</li>
<li><span>${userContext.localeMap['task.image_path2']}</span> ${task.imagePath2}</li>
<li><span>${userContext.localeMap['task.image_path3']}</span> ${task.imagePath3}</li>
<li><span>${userContext.localeMap['task.image_path4']}</span> ${task.imagePath4}</li>
<li><span>${userContext.localeMap['task.image_path5']}</span> ${task.imagePath5}</li>
<li><span>${userContext.localeMap['task.image_path6']}</span> ${task.imagePath6}</li>
<li><span>${userContext.localeMap['task.image_path7']}</span> ${task.imagePath7}</li>
<li><span>${userContext.localeMap['task.image_path8']}</span> ${task.imagePath8}</li>
<li><span>${userContext.localeMap['task.image_path9']}</span> ${task.imagePath9}</li>
<li><span>${userContext.localeMap['task.read_count']}</span> ${task.readCount}</li>
<li><span>${userContext.localeMap['task.reply_count']}</span> ${task.replyCount}</li>
<li><span>${userContext.localeMap['task.favor_count']}</span> ${task.favorCount}</li>
<li><span>${userContext.localeMap['task.like_count']}</span> ${task.likeCount}</li>
<li><span>${userContext.localeMap['task.creator_bonus']}</span> ${task.creatorBonus}</li>
<li><span>${userContext.localeMap['task.additional_bonus']}</span> ${task.additionalBonus}</li>

	
	</ul>
	
	
	
</div>

</c:if>




