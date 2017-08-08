
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty refrigeratorInOrgnizationList}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A RefrigeratorInOrgnizationList" style="color: green">${userContext.localeMap['refrigerator_in_orgnization_list']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['refrigerator_in_orgnization_list.id']}</span> ${refrigeratorInOrgnizationList.id}</li>
<li><span>${userContext.localeMap['refrigerator_in_orgnization_list.title']}</span> ${refrigeratorInOrgnizationList.title}</li>
<li><span>${userContext.localeMap['refrigerator_in_orgnization_list.research_institute_id']}</span> ${refrigeratorInOrgnizationList.researchInstituteId}</li>
<li><span>${userContext.localeMap['refrigerator_in_orgnization_list.research_group_id']}</span> ${refrigeratorInOrgnizationList.researchGroupId}</li>
<li><span>${userContext.localeMap['refrigerator_in_orgnization_list.laboratory_id']}</span> ${refrigeratorInOrgnizationList.laboratoryId}</li>

	
	</ul>
</div>



</c:if>









