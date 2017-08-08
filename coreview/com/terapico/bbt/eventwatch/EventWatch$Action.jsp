
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty eventWatch}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A EventWatch" style="color: green">${userContext.localeMap['event_watch']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['event_watch.id']}</span> ${eventWatch.id}</li>
<li><span>${userContext.localeMap['event_watch.watch_date']}</span> ${eventWatch.watchDate}</li>

	
	</ul>
</div>



</c:if>


