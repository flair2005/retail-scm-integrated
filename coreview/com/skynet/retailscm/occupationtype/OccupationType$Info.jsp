
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty occupationType}">
<div class="col-xs-12 col-md-4 section">
	<b title="A OccupationType">${userContext.localeMap['occupation_type']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./occupationTypeManager/loadOccupationTypeDetail/${occupationType.id}/"> ${occupationType.id}</a></li>
<li><span>${userContext.localeMap['occupation_type.code']}</span> ${occupationType.code}</li>
<li><span>${userContext.localeMap['occupation_type.description']}</span> ${occupationType.description}</li>
<li><span>${userContext.localeMap['occupation_type.detail_description']}</span> ${occupationType.detailDescription}</li>

	
	</ul>
	
	
	
</div>

</c:if>




