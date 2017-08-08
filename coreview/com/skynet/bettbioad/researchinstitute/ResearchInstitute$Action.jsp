
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty researchInstitute}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A ResearchInstitute" style="color: green">${userContext.localeMap['research_institute']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['research_institute.id']}</span> ${researchInstitute.id}</li>
<li><span>${userContext.localeMap['research_institute.name']}</span> ${researchInstitute.name}</li>
<li><span>${userContext.localeMap['research_institute.address']}</span> ${researchInstitute.address}</li>
<li><span>${userContext.localeMap['research_institute.post_code']}</span> ${researchInstitute.postCode}</li>
<li><span>${userContext.localeMap['research_institute.description']}</span> ${researchInstitute.description}</li>

	
	</ul>
</div>



</c:if>


