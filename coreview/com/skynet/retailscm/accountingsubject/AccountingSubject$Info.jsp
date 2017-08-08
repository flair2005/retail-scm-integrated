
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty accountingSubject}">
<div class="col-xs-12 col-md-4 section">
	<b title="A AccountingSubject">${userContext.localeMap['accounting_subject']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./accountingSubjectManager/loadAccountingSubjectDetail/${accountingSubject.id}/"> ${accountingSubject.id}</a></li>
<li><span>${userContext.localeMap['accounting_subject.accounting_subject_code']}</span> ${accountingSubject.accountingSubjectCode}</li>
<li><span>${userContext.localeMap['accounting_subject.accounting_subject_name']}</span> ${accountingSubject.accountingSubjectName}</li>
<li><span>${userContext.localeMap['accounting_subject.accounting_subject_class_code']}</span> ${accountingSubject.accountingSubjectClassCode}</li>
<li><span>${userContext.localeMap['accounting_subject.accounting_subject_class_name']}</span> ${accountingSubject.accountingSubjectClassName}</li>

	
	</ul>
	
	
	
</div>

</c:if>




