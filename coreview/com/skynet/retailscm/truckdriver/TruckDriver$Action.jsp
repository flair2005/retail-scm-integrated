
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty truckDriver}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A TruckDriver" style="color: green">${userContext.localeMap['truck_driver']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['truck_driver.id']}</span> ${truckDriver.id}</li>
<li><span>${userContext.localeMap['truck_driver.name']}</span> ${truckDriver.name}</li>
<li><span>${userContext.localeMap['truck_driver.driver_license_number']}</span> ${truckDriver.driverLicenseNumber}</li>
<li><span>${userContext.localeMap['truck_driver.contact_number']}</span> ${truckDriver.maskedContactNumber}</li>

	
	</ul>
</div>



</c:if>


