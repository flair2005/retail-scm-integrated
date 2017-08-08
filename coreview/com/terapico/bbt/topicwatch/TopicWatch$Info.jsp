
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topicWatch}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TopicWatch">${userContext.localeMap['topic_watch']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./topicWatchManager/loadTopicWatchDetail/${topicWatch.id}/"> ${topicWatch.id}</a></li>
<li><span>${userContext.localeMap['topic_watch.watch_date']}</span> ${topicWatch.watchDate}</li>

	
	</ul>
	
	
	
</div>

</c:if>




