
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty contractIssueTrack}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A ContractIssueTrack" style="color: green">${userContext.localeMap['contract_issue_track']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['contract_issue_track.id']}</span> ${contractIssueTrack.id}</li>
<li><span>${userContext.localeMap['contract_issue_track.title']}</span> ${contractIssueTrack.title}</li>
<li><span>${userContext.localeMap['contract_issue_track.count_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${contractIssueTrack.countTime}" /></li>
<li><span>${userContext.localeMap['contract_issue_track.summary']}</span> ${contractIssueTrack.summary}</li>

	
	</ul>
</div>



</c:if>


