
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingDocumentPosting}">
<div class="col-xs-12 col-md-4 section">
	<b title="A AccountingDocumentPosting">${userContext.localeMap['accounting_document_posting']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./accountingDocumentPostingManager/loadAccountingDocumentPostingDetail/${accountingDocumentPosting.id}/"> ${accountingDocumentPosting.id}</a></li>
<li><span>${userContext.localeMap['accounting_document_posting.who']}</span> ${accountingDocumentPosting.who}</li>
<li><span>${userContext.localeMap['accounting_document_posting.comments']}</span> ${accountingDocumentPosting.comments}</li>
<li><span>${userContext.localeMap['accounting_document_posting.make_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${accountingDocumentPosting.makeDate}" /></li>

	
	</ul>
	
	
	
</div>

</c:if>




