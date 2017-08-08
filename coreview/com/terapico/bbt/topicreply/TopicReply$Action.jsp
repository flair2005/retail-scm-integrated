
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topicReply}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A TopicReply" style="color: green">${userContext.localeMap['topic_reply']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['topic_reply.id']}</span> ${topicReply.id}</li>
<li><span>${userContext.localeMap['topic_reply.title']}</span> ${topicReply.title}</li>
<li><span>${userContext.localeMap['topic_reply.publish_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${topicReply.publishDate}" /></li>
<li><span>${userContext.localeMap['topic_reply.content']}</span> ${topicReply.content}</li>

	
	</ul>
</div>



</c:if>


