
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty companyTraining}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A CompanyTraining" style="color: green">${userContext.localeMap['company_training']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['company_training.id']}</span> ${companyTraining.id}</li>
<li><span>${userContext.localeMap['company_training.title']}</span> ${companyTraining.title}</li>
<li><span>${userContext.localeMap['company_training.time_start']}</span> ${companyTraining.timeStart}</li>
<li><span>${userContext.localeMap['company_training.duration_hours']}</span> ${companyTraining.durationHours}</li>

	
	</ul>
</div>



</c:if>


