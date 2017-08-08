
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty laboratoryResearchArea}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A LaboratoryResearchArea" style="color: green">${userContext.localeMap['laboratory_research_area']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['laboratory_research_area.id']}</span> ${laboratoryResearchArea.id}</li>
<li><span>${userContext.localeMap['laboratory_research_area.summary']}</span> ${laboratoryResearchArea.summary}</li>

	
	</ul>
</div>



</c:if>


