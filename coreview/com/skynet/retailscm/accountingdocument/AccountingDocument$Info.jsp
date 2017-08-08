
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingDocument}">
<div class="col-xs-12 col-md-4 section">
	<b title="A AccountingDocument">${userContext.localeMap['accounting_document']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./accountingDocumentManager/loadAccountingDocumentDetail/${accountingDocument.id}/"> ${accountingDocument.id}</a></li>
<li><span>${userContext.localeMap['accounting_document.name']}</span> ${accountingDocument.name}</li>
<li><span>${userContext.localeMap['accounting_document.accounting_document_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountingDocument.accountingDocumentDate}" /></li>
<li><span>${userContext.localeMap['accounting_document.current_status']}</span> ${accountingDocument.currentStatus}</li>

	
	</ul>
	
	
	
</div>

</c:if>




