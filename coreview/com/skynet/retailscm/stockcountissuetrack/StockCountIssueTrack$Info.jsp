
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty stockCountIssueTrack}">
<div class="col-xs-12 col-md-4 section">
	<b title="A StockCountIssueTrack">${userContext.localeMap['stock_count_issue_track']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./stockCountIssueTrackManager/loadStockCountIssueTrackDetail/${stockCountIssueTrack.id}/"> ${stockCountIssueTrack.id}</a></li>
<li><span>${userContext.localeMap['stock_count_issue_track.title']}</span> ${stockCountIssueTrack.title}</li>
<li><span>${userContext.localeMap['stock_count_issue_track.count_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${stockCountIssueTrack.countTime}" /></li>
<li><span>${userContext.localeMap['stock_count_issue_track.summary']}</span> ${stockCountIssueTrack.summary}</li>

	
	</ul>
	
	
	
</div>

</c:if>




