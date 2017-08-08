
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topicPage}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A TopicPage" style="color: green">${userContext.localeMap['topic_page']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['topic_page.id']}</span> ${topicPage.id}</li>
<li><span>${userContext.localeMap['topic_page.title']}</span> ${topicPage.title}</li>
<li><span>${userContext.localeMap['topic_page.current_key']}</span> ${topicPage.currentKey}</li>

	
	</ul>
</div>



</c:if>


