
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty researchGroup}">
<div class="col-xs-12 col-md-4 section">
	<b title="A ResearchGroup">${userContext.localeMap['research_group']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./researchGroupManager/loadResearchGroupDetail/${researchGroup.id}/"> ${researchGroup.id}</a></li>
<li><span>${userContext.localeMap['research_group.name']}</span> ${researchGroup.name}</li>
<li><span>${userContext.localeMap['research_group.research_area']}</span> ${researchGroup.researchArea}</li>

	
	</ul>
	
	
	
</div>

</c:if>




