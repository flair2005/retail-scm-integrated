
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty levelTwoDepartment}">
<div class="col-xs-12 col-md-4 section">
	<b title="A LevelTwoDepartment">${userContext.localeMap['level_two_department']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./levelTwoDepartmentManager/loadLevelTwoDepartmentDetail/${levelTwoDepartment.id}/"> ${levelTwoDepartment.id}</a></li>
<li><span>${userContext.localeMap['level_two_department.name']}</span> ${levelTwoDepartment.name}</li>
<li><span>${userContext.localeMap['level_two_department.description']}</span> ${levelTwoDepartment.description}</li>
<li><span>${userContext.localeMap['level_two_department.founded']}</span> ${levelTwoDepartment.founded}</li>

	
	</ul>
	
	
	
</div>

</c:if>




