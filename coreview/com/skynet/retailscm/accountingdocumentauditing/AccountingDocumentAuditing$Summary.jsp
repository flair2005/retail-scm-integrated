
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingDocumentAuditing}">
<div class="col-xs-12 col-md-12 section">
	<b title="A AccountingDocumentAuditing"> 
		${userContext.localeMap['accounting_document_auditing']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		
		
	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'main' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['accounting_document_auditing.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['accounting_document_auditing.who']}</span>
<span >${result.who}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['accounting_document_auditing.comments']}</span>
<span >${result.comments}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['accounting_document_auditing.make_date']}</span>
<span ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.makeDate}" /></span>
</div>

	</div>
	
</div>

</c:if>




