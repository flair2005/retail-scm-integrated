
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty transportFleet}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A TransportFleet" style="color: green">${userContext.localeMap['transport_fleet']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['transport_fleet.id']}</span> ${transportFleet.id}</li>
<li><span>${userContext.localeMap['transport_fleet.name']}</span> ${transportFleet.name}</li>
<li><span>${userContext.localeMap['transport_fleet.contact_number']}</span> ${transportFleet.contactNumber}</li>

	
	</ul>
</div>



</c:if>


