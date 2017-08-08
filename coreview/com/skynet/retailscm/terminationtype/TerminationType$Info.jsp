
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty terminationType}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TerminationType">${userContext.localeMap['termination_type']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./terminationTypeManager/loadTerminationTypeDetail/${terminationType.id}/"> ${terminationType.id}</a></li>
<li><span>${userContext.localeMap['termination_type.code']}</span> ${terminationType.code}</li>
<li><span>${userContext.localeMap['termination_type.base_description']}</span> ${terminationType.baseDescription}</li>
<li><span>${userContext.localeMap['termination_type.detail_description']}</span> ${terminationType.detailDescription}</li>

	
	</ul>
	
	
	
</div>

</c:if>




