
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty report}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Report">${userContext.localeMap['report']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./reportManager/loadReportDetail/${report.id}/"> ${report.id}</a></li>
<li><span>${userContext.localeMap['report.name']}</span> ${report.name}</li>
<li><span>${userContext.localeMap['report.created_by']}</span> ${report.createdBy}</li>

	
	</ul>
	
	
	
</div>

</c:if>




