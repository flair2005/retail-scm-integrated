
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty slide}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A Slide" style="color: green">${userContext.localeMap['slide']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['slide.id']}</span> ${slide.id}</li>
<li><span>${userContext.localeMap['slide.title']}</span> ${slide.title}</li>
<li><span>${userContext.localeMap['slide.image_url']}</span> ${slide.imageUrl}</li>
<li><span>${userContext.localeMap['slide.link_url']}</span> ${slide.linkUrl}</li>

	
	</ul>
</div>



</c:if>


