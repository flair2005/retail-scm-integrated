
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty productClassUsage}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A ProductClassUsage" style="color: green">${userContext.localeMap['product_class_usage']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['product_class_usage.id']}</span> ${productClassUsage.id}</li>
<li><span>${userContext.localeMap['product_class_usage.annual_consumption']}</span> ${productClassUsage.annualConsumption}</li>

	
	</ul>
</div>



</c:if>


