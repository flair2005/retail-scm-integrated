
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty threadReply}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A ThreadReply" style="color: green">${userContext.localeMap['thread_reply']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['thread_reply.id']}</span> ${threadReply.id}</li>
<li><span>${userContext.localeMap['thread_reply.title']}</span> ${threadReply.title}</li>
<li><span>${userContext.localeMap['thread_reply.publish_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${threadReply.publishDate}" /></li>
<li><span>${userContext.localeMap['thread_reply.content']}</span> ${threadReply.content}</li>

	
	</ul>
</div>



</c:if>


