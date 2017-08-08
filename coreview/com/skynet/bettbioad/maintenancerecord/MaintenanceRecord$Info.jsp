
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty maintenanceRecord}">
<div class="col-xs-12 col-md-4 section">
	<b title="A MaintenanceRecord">${userContext.localeMap['maintenance_record']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./maintenanceRecordManager/loadMaintenanceRecordDetail/${maintenanceRecord.id}/"> ${maintenanceRecord.id}</a></li>
<li><span>${userContext.localeMap['maintenance_record.record_type']}</span> ${maintenanceRecord.recordType}</li>
<li><span>${userContext.localeMap['maintenance_record.count_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${maintenanceRecord.countTime}" /></li>
<li><span>${userContext.localeMap['maintenance_record.summary']}</span> ${maintenanceRecord.summary}</li>

	
	</ul>
	
	
	
</div>

</c:if>




