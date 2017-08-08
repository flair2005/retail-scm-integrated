
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty bettbioCompany}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A BettbioCompany" style="color: green">${userContext.localeMap['bettbio_company']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['bettbio_company.id']}</span> ${bettbioCompany.id}</li>
<li><span>${userContext.localeMap['bettbio_company.name']}</span> ${bettbioCompany.name}</li>
<li><span>${userContext.localeMap['bettbio_company.address']}</span> ${bettbioCompany.address}</li>
<li><span>${userContext.localeMap['bettbio_company.email']}</span> ${bettbioCompany.email}</li>

	
	</ul>
</div>



</c:if>


