
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty eventPublishing}">
<div class="col-xs-12 col-md-4 section">
	<b title="A EventPublishing">${userContext.localeMap['event_publishing']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./eventPublishingManager/loadEventPublishingDetail/${eventPublishing.id}/"> ${eventPublishing.id}</a></li>
<li><span>${userContext.localeMap['event_publishing.who']}</span> ${eventPublishing.who}</li>
<li><span>${userContext.localeMap['event_publishing.confirm_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${eventPublishing.confirmDate}" /></li>
<li><span>${userContext.localeMap['event_publishing.comment']}</span> ${eventPublishing.comment}</li>

	
	</ul>
	
	
	
</div>

</c:if>




