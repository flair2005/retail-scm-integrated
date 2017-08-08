
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty threadFavorite}">
<div class="col-xs-12 col-md-4 section">
	<b title="A ThreadFavorite">${userContext.localeMap['thread_favorite']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./threadFavoriteManager/loadThreadFavoriteDetail/${threadFavorite.id}/"> ${threadFavorite.id}</a></li>
<li><span>${userContext.localeMap['thread_favorite.favorite_date']}</span> ${threadFavorite.favoriteDate}</li>

	
	</ul>
	
	
	
</div>

</c:if>




