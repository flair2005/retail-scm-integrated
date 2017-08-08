
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty patientInfo}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A PatientInfo" style="color: green">${userContext.localeMap['patient_info']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['patient_info.id']}</span> ${patientInfo.id}</li>
<li><span>${userContext.localeMap['patient_info.name']}</span> ${patientInfo.name}</li>
<li><span>${userContext.localeMap['patient_info.nick_name']}</span> ${patientInfo.nickName}</li>
<li><span>${userContext.localeMap['patient_info.wear_device_type']}</span> ${patientInfo.wearDeviceType}</li>
<li><span>${userContext.localeMap['patient_info.wear_start_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${patientInfo.wearStartDate}" /></li>
<li><span>${userContext.localeMap['patient_info.recover_plan']}</span> ${patientInfo.recoverPlan}</li>
<li><span>${userContext.localeMap['patient_info.recover_start_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${patientInfo.recoverStartDate}" /></li>

	
	</ul>
</div>



</c:if>


