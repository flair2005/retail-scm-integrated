
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty taskReply}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TaskReply">${userContext.localeMap['task_reply']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./taskReplyManager/loadTaskReplyDetail/${taskReply.id}/"> ${taskReply.id}</a></li>
<li><span>${userContext.localeMap['task_reply.title']}</span> ${taskReply.title}</li>
<li><span>${userContext.localeMap['task_reply.reply_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${taskReply.replyDate}" /></li>
<li><span>${userContext.localeMap['task_reply.content']}</span> ${taskReply.content}</li>
<li><span>${userContext.localeMap['task_reply.like_count']}</span> ${taskReply.likeCount}</li>

	
	</ul>
	
	
	
</div>

</c:if>




