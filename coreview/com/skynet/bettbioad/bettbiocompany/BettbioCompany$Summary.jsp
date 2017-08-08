
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty bettbioCompany}">
<div class="col-xs-12 col-md-12 section">
	<b title="A BettbioCompany"> 
		${userContext.localeMap['bettbio_company']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
		
		</div>
		
	
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['bettbio_company.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['bettbio_company.name']}</span>
<span >${result.name}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['bettbio_company.address']}</span>
<span >${result.address}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['bettbio_company.email']}</span>
<span >${result.email}</span>
</div>

	</div>
	
</div>

</c:if>




