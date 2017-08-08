
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty threadApproval}">
<div class="col-xs-12 col-md-4 section">
	<b title="A ThreadApproval">${userContext.localeMap['thread_approval']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./threadApprovalManager/loadThreadApprovalDetail/${threadApproval.id}/"> ${threadApproval.id}</a></li>
<li><span>${userContext.localeMap['thread_approval.who']}</span> ${threadApproval.who}</li>
<li><span>${userContext.localeMap['thread_approval.confirm_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${threadApproval.confirmDate}" /></li>
<li><span>${userContext.localeMap['thread_approval.comment']}</span> ${threadApproval.comment}</li>

	
	</ul>
	
	
	
</div>

</c:if>




