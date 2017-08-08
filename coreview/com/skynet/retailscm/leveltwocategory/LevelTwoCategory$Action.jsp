
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty levelTwoCategory}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A LevelTwoCategory" style="color: green">${userContext.localeMap['level_two_category']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['level_two_category.id']}</span> ${levelTwoCategory.id}</li>
<li><span>${userContext.localeMap['level_two_category.display_name']}</span> ${levelTwoCategory.displayName}</li>

	
	</ul>
</div>



</c:if>


