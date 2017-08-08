
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty laboratory}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Laboratory">${userContext.localeMap['laboratory']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./laboratoryManager/loadLaboratoryDetail/${laboratory.id}/"> ${laboratory.id}</a></li>
<li><span>${userContext.localeMap['laboratory.name']}</span> ${laboratory.name}</li>
<li><span>${userContext.localeMap['laboratory.room_number']}</span> ${laboratory.roomNumber}</li>

	
	</ul>
	
	
	
</div>

</c:if>




