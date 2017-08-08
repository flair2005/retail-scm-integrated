
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty provinceCenterEmployee}">
<div class="col-xs-12 col-md-4 section">
	<b title="A ProvinceCenterEmployee">${userContext.localeMap['province_center_employee']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./provinceCenterEmployeeManager/loadProvinceCenterEmployeeDetail/${provinceCenterEmployee.id}/"> ${provinceCenterEmployee.id}</a></li>
<li><span>${userContext.localeMap['province_center_employee.name']}</span> ${provinceCenterEmployee.name}</li>
<li><span>${userContext.localeMap['province_center_employee.mobile']}</span> ${provinceCenterEmployee.maskedMobile}</li>
<li><span>${userContext.localeMap['province_center_employee.email']}</span> ${provinceCenterEmployee.email}</li>
<li><span>${userContext.localeMap['province_center_employee.founded']}</span> ${provinceCenterEmployee.founded}</li>

	
	</ul>
	
	
	
</div>

</c:if>




