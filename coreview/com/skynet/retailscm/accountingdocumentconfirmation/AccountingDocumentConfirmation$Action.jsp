
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingDocumentConfirmation}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A AccountingDocumentConfirmation" style="color: green">${userContext.localeMap['accounting_document_confirmation']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['accounting_document_confirmation.id']}</span> ${accountingDocumentConfirmation.id}</li>
<li><span>${userContext.localeMap['accounting_document_confirmation.who']}</span> ${accountingDocumentConfirmation.who}</li>
<li><span>${userContext.localeMap['accounting_document_confirmation.comments']}</span> ${accountingDocumentConfirmation.comments}</li>
<li><span>${userContext.localeMap['accounting_document_confirmation.make_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountingDocumentConfirmation.makeDate}" /></li>

	
	</ul>
</div>



</c:if>


