
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty slide}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Slide">${userContext.localeMap['slide']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./slideManager/loadSlideDetail/${slide.id}/"> ${slide.id}</a></li>
<li><span>${userContext.localeMap['slide.title']}</span> ${slide.title}</li>
<li><span>${userContext.localeMap['slide.image_url']}</span> ${slide.imageUrl}</li>
<li><span>${userContext.localeMap['slide.link_url']}</span> ${slide.linkUrl}</li>

	
	</ul>
	
	
	
</div>

</c:if>




