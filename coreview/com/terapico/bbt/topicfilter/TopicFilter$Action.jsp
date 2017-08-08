
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topicFilter}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A TopicFilter" style="color: green">${userContext.localeMap['topic_filter']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['topic_filter.id']}</span> ${topicFilter.id}</li>
<li><span>${userContext.localeMap['topic_filter.title']}</span> ${topicFilter.title}</li>
<li><span>${userContext.localeMap['topic_filter.current_key']}</span> ${topicFilter.currentKey}</li>

	
	</ul>
</div>



</c:if>


