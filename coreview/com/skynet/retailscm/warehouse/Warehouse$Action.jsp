
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty warehouse}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A Warehouse" style="color: green">${userContext.localeMap['warehouse']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['warehouse.id']}</span> ${warehouse.id}</li>
<li><span>${userContext.localeMap['warehouse.location']}</span> ${warehouse.location}</li>
<li><span>${userContext.localeMap['warehouse.contact_number']}</span> ${warehouse.contactNumber}</li>
<li><span>${userContext.localeMap['warehouse.total_area']}</span> ${warehouse.totalArea}</li>
<li><span>${userContext.localeMap['warehouse.latitude']}</span> ${warehouse.latitude}</li>
<li><span>${userContext.localeMap['warehouse.longitude']}</span> ${warehouse.longitude}</li>

	
	</ul>
</div>



</c:if>


