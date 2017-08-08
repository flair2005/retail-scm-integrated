
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty taskWatch}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A TaskWatch" style="color: green">${userContext.localeMap['task_watch']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['task_watch.id']}</span> ${taskWatch.id}</li>
<li><span>${userContext.localeMap['task_watch.watch_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${taskWatch.watchDate}" /></li>

	
	</ul>
</div>



</c:if>


