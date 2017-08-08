
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty message}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Message">${userContext.localeMap['message']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="/naf/messageManager/loadMessageDetail/${message.id}/"> ${message.id}</a></li>
<li><span>${userContext.localeMap['message.title']}</span> ${message.title}</li>
<li><span>${userContext.localeMap['message.content']}</span> ${message.content}</li>
<li><span>${userContext.localeMap['message.message_date']}</span> ${message.messageDate}</li>

	
	</ul>
	
	
	
</div>

</c:if>




