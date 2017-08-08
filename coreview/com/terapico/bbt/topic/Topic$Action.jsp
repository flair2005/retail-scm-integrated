
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topic}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A Topic" style="color: green">${userContext.localeMap['topic']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['topic.id']}</span> ${topic.id}</li>
<li><span>${userContext.localeMap['topic.title']}</span> ${topic.title}</li>
<li><span>${userContext.localeMap['topic.publish_date']}</span> ${topic.publishDate}</li>
<li><span>${userContext.localeMap['topic.content']}</span> ${topic.content}</li>
<li><span>${userContext.localeMap['topic.cover_image_path']}</span> ${topic.coverImagePath}</li>
<li><span>${userContext.localeMap['topic.image_path1']}</span> ${topic.imagePath1}</li>
<li><span>${userContext.localeMap['topic.image_path2']}</span> ${topic.imagePath2}</li>
<li><span>${userContext.localeMap['topic.image_path3']}</span> ${topic.imagePath3}</li>
<li><span>${userContext.localeMap['topic.image_path4']}</span> ${topic.imagePath4}</li>
<li><span>${userContext.localeMap['topic.image_path5']}</span> ${topic.imagePath5}</li>
<li><span>${userContext.localeMap['topic.image_path6']}</span> ${topic.imagePath6}</li>
<li><span>${userContext.localeMap['topic.image_path7']}</span> ${topic.imagePath7}</li>
<li><span>${userContext.localeMap['topic.image_path8']}</span> ${topic.imagePath8}</li>
<li><span>${userContext.localeMap['topic.image_path9']}</span> ${topic.imagePath9}</li>
<li><span>${userContext.localeMap['topic.read_count']}</span> ${topic.readCount}</li>
<li><span>${userContext.localeMap['topic.reply_count']}</span> ${topic.replyCount}</li>
<li><span>${userContext.localeMap['topic.favor_count']}</span> ${topic.favorCount}</li>
<li><span>${userContext.localeMap['topic.like_count']}</span> ${topic.likeCount}</li>

	
	</ul>
</div>



</c:if>


