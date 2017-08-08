
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreCityServiceCenter}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A RetailStoreCityServiceCenter" style="color: green">${userContext.localeMap['retail_store_city_service_center']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store_city_service_center.id']}</span> ${retailStoreCityServiceCenter.id}</li>
<li><span>${userContext.localeMap['retail_store_city_service_center.name']}</span> ${retailStoreCityServiceCenter.name}</li>
<li><span>${userContext.localeMap['retail_store_city_service_center.founded']}</span> ${retailStoreCityServiceCenter.founded}</li>

	
	</ul>
</div>



</c:if>


