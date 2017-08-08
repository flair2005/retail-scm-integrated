
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty topicFavorite}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TopicFavorite">${userContext.localeMap['topic_favorite']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./topicFavoriteManager/loadTopicFavoriteDetail/${topicFavorite.id}/"> ${topicFavorite.id}</a></li>
<li><span>${userContext.localeMap['topic_favorite.favorite_date']}</span> ${topicFavorite.favoriteDate}</li>

	
	</ul>
	
	
	
</div>

</c:if>




