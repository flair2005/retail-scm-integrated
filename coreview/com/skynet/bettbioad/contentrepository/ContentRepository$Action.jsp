
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty contentRepository}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A ContentRepository" style="color: green">${userContext.localeMap['content_repository']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['content_repository.id']}</span> ${contentRepository.id}</li>
<li><span>${userContext.localeMap['content_repository.title']}</span> ${contentRepository.title}</li>

	
	</ul>
</div>



</c:if>


