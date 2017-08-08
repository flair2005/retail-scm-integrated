
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty refrigerator}">
<div class="col-xs-12 col-md-12 section">
	<b title="A Refrigerator"> 
		${userContext.localeMap['refrigerator']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
		
		</div>
		
	
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.title']}</span>
<span >${result.title}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.refrigerator_manufacturer']}</span>
<span >${result.refrigeratorManufacturer}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.refrigerator_model']}</span>
<span >${result.refrigeratorModel}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.refrigerator_serial_number']}</span>
<span >${result.refrigeratorSerialNumber}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.refrigerator_capacity']}</span>
<span >${result.refrigeratorCapacity}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.refrigerator_up_time']}</span>
<span >${result.refrigeratorUpTime}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.ad_machine_model']}</span>
<span >${result.adMachineModel}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.ad_machine_serial_number']}</span>
<span >${result.adMachineSerialNumber}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.ad_machine_up_time']}</span>
<span >${result.adMachineUpTime}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.rfid_reader_id']}</span>
<span >${result.rfidReaderId}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.longitude']}</span>
<span >${result.longitude}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.latitude']}</span>
<span >${result.latitude}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator.last_report_time']}</span>
<span >${result.lastReportTime}</span>
</div>

	</div>
	
</div>

</c:if>




