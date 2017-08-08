
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty userMessage}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A UserMessage" style="color: green">${userContext.localeMap['user_message']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['user_message.id']}</span> ${userMessage.id}</li>
<li><span>${userContext.localeMap['user_message.title']}</span> ${userMessage.title}</li>
<li><span>${userContext.localeMap['user_message.content']}</span> ${userMessage.content}</li>
<li><span>${userContext.localeMap['user_message.message_date']}</span> ${userMessage.messageDate}</li>

	
	</ul>
</div>



</c:if>


