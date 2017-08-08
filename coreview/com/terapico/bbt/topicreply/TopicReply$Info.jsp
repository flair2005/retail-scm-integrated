
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topicReply}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TopicReply">${userContext.localeMap['topic_reply']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./topicReplyManager/loadTopicReplyDetail/${topicReply.id}/"> ${topicReply.id}</a></li>
<li><span>${userContext.localeMap['topic_reply.title']}</span> ${topicReply.title}</li>
<li><span>${userContext.localeMap['topic_reply.publish_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${topicReply.publishDate}" /></li>
<li><span>${userContext.localeMap['topic_reply.content']}</span> ${topicReply.content}</li>

	
	</ul>
	
	
	
</div>

</c:if>




