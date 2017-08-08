
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty customerCompany}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A CustomerCompany" style="color: green">${userContext.localeMap['customer_company']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['customer_company.id']}</span> ${customerCompany.id}</li>
<li><span>${userContext.localeMap['customer_company.name']}</span> ${customerCompany.name}</li>
<li><span>${userContext.localeMap['customer_company.address']}</span> ${customerCompany.address}</li>
<li><span>${userContext.localeMap['customer_company.email']}</span> ${customerCompany.email}</li>
<li><span>${userContext.localeMap['customer_company.phone']}</span> ${customerCompany.phone}</li>
<li><span>${userContext.localeMap['customer_company.home_page']}</span> ${customerCompany.homePage}</li>
<li><span>${userContext.localeMap['customer_company.company_profile']}</span> ${customerCompany.companyProfile}</li>

	
	</ul>
</div>



</c:if>


