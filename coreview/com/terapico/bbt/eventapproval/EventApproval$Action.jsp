
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty eventApproval}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A EventApproval" style="color: green">${userContext.localeMap['event_approval']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['event_approval.id']}</span> ${eventApproval.id}</li>
<li><span>${userContext.localeMap['event_approval.who']}</span> ${eventApproval.who}</li>
<li><span>${userContext.localeMap['event_approval.confirm_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${eventApproval.confirmDate}" /></li>
<li><span>${userContext.localeMap['event_approval.comment']}</span> ${eventApproval.comment}</li>

	
	</ul>
</div>



</c:if>


