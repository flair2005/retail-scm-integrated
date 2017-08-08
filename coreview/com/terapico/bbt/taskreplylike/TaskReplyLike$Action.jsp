
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty taskReplyLike}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A TaskReplyLike" style="color: green">${userContext.localeMap['task_reply_like']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['task_reply_like.id']}</span> ${taskReplyLike.id}</li>
<li><span>${userContext.localeMap['task_reply_like.like_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${taskReplyLike.likeDate}" /></li>

	
	</ul>
</div>



</c:if>


