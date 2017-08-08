
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty receivingSpace}">
<div class="col-xs-12 col-md-4 section">
	<b title="A ReceivingSpace">${userContext.localeMap['receiving_space']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./receivingSpaceManager/loadReceivingSpaceDetail/${receivingSpace.id}/"> ${receivingSpace.id}</a></li>
<li><span>${userContext.localeMap['receiving_space.location']}</span> ${receivingSpace.location}</li>
<li><span>${userContext.localeMap['receiving_space.contact_number']}</span> ${receivingSpace.contactNumber}</li>
<li><span>${userContext.localeMap['receiving_space.description']}</span> ${receivingSpace.description}</li>
<li><span>${userContext.localeMap['receiving_space.total_area']}</span> ${receivingSpace.totalArea}</li>
<li><span>${userContext.localeMap['receiving_space.latitude']}</span> ${receivingSpace.latitude}</li>
<li><span>${userContext.localeMap['receiving_space.longitude']}</span> ${receivingSpace.longitude}</li>

	
	</ul>
	
	
	
</div>

</c:if>




