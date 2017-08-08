
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty eventFavorite}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A EventFavorite" style="color: green">${userContext.localeMap['event_favorite']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['event_favorite.id']}</span> ${eventFavorite.id}</li>
<li><span>${userContext.localeMap['event_favorite.favorite_date']}</span> ${eventFavorite.favoriteDate}</li>

	
	</ul>
</div>



</c:if>


