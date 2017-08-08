
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty levelTwoCategory}">
<div class="col-xs-12 col-md-4 section">
	<b title="A LevelTwoCategory">${userContext.localeMap['level_two_category']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./levelTwoCategoryManager/loadLevelTwoCategoryDetail/${levelTwoCategory.id}/"> ${levelTwoCategory.id}</a></li>
<li><span>${userContext.localeMap['level_two_category.display_name']}</span> ${levelTwoCategory.displayName}</li>

	
	</ul>
	
	
	
</div>

</c:if>




