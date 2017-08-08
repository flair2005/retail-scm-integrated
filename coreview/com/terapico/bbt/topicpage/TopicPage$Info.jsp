
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topicPage}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TopicPage">${userContext.localeMap['topic_page']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./topicPageManager/loadTopicPageDetail/${topicPage.id}/"> ${topicPage.id}</a></li>
<li><span>${userContext.localeMap['topic_page.title']}</span> ${topicPage.title}</li>
<li><span>${userContext.localeMap['topic_page.current_key']}</span> ${topicPage.currentKey}</li>

	
	</ul>
	
	
	
</div>

</c:if>




