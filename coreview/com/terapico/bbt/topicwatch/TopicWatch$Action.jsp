
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topicWatch}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A TopicWatch" style="color: green">${userContext.localeMap['topic_watch']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['topic_watch.id']}</span> ${topicWatch.id}</li>
<li><span>${userContext.localeMap['topic_watch.watch_date']}</span> ${topicWatch.watchDate}</li>

	
	</ul>
</div>



</c:if>


