
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty refrigerator}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Refrigerator">${userContext.localeMap['refrigerator']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./refrigeratorManager/loadRefrigeratorDetail/${refrigerator.id}/"> ${refrigerator.id}</a></li>
<li><span>${userContext.localeMap['refrigerator.title']}</span> ${refrigerator.title}</li>
<li><span>${userContext.localeMap['refrigerator.refrigerator_manufacturer']}</span> ${refrigerator.refrigeratorManufacturer}</li>
<li><span>${userContext.localeMap['refrigerator.refrigerator_model']}</span> ${refrigerator.refrigeratorModel}</li>
<li><span>${userContext.localeMap['refrigerator.refrigerator_serial_number']}</span> ${refrigerator.refrigeratorSerialNumber}</li>
<li><span>${userContext.localeMap['refrigerator.refrigerator_capacity']}</span> ${refrigerator.refrigeratorCapacity}</li>
<li><span>${userContext.localeMap['refrigerator.refrigerator_up_time']}</span> ${refrigerator.refrigeratorUpTime}</li>
<li><span>${userContext.localeMap['refrigerator.ad_machine_model']}</span> ${refrigerator.adMachineModel}</li>
<li><span>${userContext.localeMap['refrigerator.ad_machine_serial_number']}</span> ${refrigerator.adMachineSerialNumber}</li>
<li><span>${userContext.localeMap['refrigerator.ad_machine_up_time']}</span> ${refrigerator.adMachineUpTime}</li>
<li><span>${userContext.localeMap['refrigerator.rfid_reader_id']}</span> ${refrigerator.rfidReaderId}</li>
<li><span>${userContext.localeMap['refrigerator.longitude']}</span> ${refrigerator.longitude}</li>
<li><span>${userContext.localeMap['refrigerator.latitude']}</span> ${refrigerator.latitude}</li>
<li><span>${userContext.localeMap['refrigerator.last_report_time']}</span> ${refrigerator.lastReportTime}</li>

	
	</ul>
	
	
	
</div>

</c:if>




