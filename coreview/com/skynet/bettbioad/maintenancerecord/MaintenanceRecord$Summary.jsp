
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty maintenanceRecord}">
<div class="col-xs-12 col-md-12 section">
	<b title="A MaintenanceRecord"> 
		${userContext.localeMap['maintenance_record']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
		
		</div>
		
	
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['maintenance_record.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['maintenance_record.record_type']}</span>
<span >${result.recordType}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['maintenance_record.count_time']}</span>
<span ><fmt:formatDate pattern="yyyy-MM-dd" value="${result.countTime}" /></span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['maintenance_record.summary']}</span>
<span >${result.summary}</span>
</div>

	</div>
	
</div>

</c:if>




