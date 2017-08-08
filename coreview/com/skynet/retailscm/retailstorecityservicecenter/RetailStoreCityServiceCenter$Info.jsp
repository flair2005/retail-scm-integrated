
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreCityServiceCenter}">
<div class="col-xs-12 col-md-4 section">
	<b title="A RetailStoreCityServiceCenter">${userContext.localeMap['retail_store_city_service_center']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./retailStoreCityServiceCenterManager/loadRetailStoreCityServiceCenterDetail/${retailStoreCityServiceCenter.id}/"> ${retailStoreCityServiceCenter.id}</a></li>
<li><span>${userContext.localeMap['retail_store_city_service_center.name']}</span> ${retailStoreCityServiceCenter.name}</li>
<li><span>${userContext.localeMap['retail_store_city_service_center.founded']}</span> ${retailStoreCityServiceCenter.founded}</li>

	
	</ul>
	
	
	
</div>

</c:if>




