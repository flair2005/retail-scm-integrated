
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty threadLike}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A ThreadLike" style="color: green">${userContext.localeMap['thread_like']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['thread_like.id']}</span> ${threadLike.id}</li>
<li><span>${userContext.localeMap['thread_like.like_date']}</span> ${threadLike.likeDate}</li>

	
	</ul>
</div>



</c:if>


