
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty researchArea}">
<div class="col-xs-12 col-md-4 section">
	<b title="A ResearchArea">${userContext.localeMap['research_area']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./researchAreaManager/loadResearchAreaDetail/${researchArea.id}/"> ${researchArea.id}</a></li>
<li><span>${userContext.localeMap['research_area.summary']}</span> ${researchArea.summary}</li>
<li><span>${userContext.localeMap['research_area.keyswords']}</span> ${researchArea.keyswords}</li>

	
	</ul>
	
	
	
</div>

</c:if>




