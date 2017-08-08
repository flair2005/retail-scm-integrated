
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty contractIssueTrack}">
<div class="col-xs-12 col-md-12 section">
	<b title="A ContractIssueTrack"> 
		${userContext.localeMap['contract_issue_track']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
		
		</div>
		
	
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['contract_issue_track.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['contract_issue_track.title']}</span>
<span >${result.title}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['contract_issue_track.count_time']}</span>
<span ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.countTime}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['contract_issue_track.summary']}</span>
<span >${result.summary}</span>
</div>

	</div>
	
</div>

</c:if>




