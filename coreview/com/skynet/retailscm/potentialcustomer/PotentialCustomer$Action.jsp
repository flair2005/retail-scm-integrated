
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty potentialCustomer}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A PotentialCustomer" style="color: green">${userContext.localeMap['potential_customer']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['potential_customer.id']}</span> ${potentialCustomer.id}</li>
<li><span>${userContext.localeMap['potential_customer.name']}</span> ${potentialCustomer.name}</li>
<li><span>${userContext.localeMap['potential_customer.mobile']}</span> ${potentialCustomer.maskedMobile}</li>
<li><span>${userContext.localeMap['potential_customer.description']}</span> ${potentialCustomer.description}</li>

	
	</ul>
</div>



</c:if>


