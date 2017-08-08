
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty contact}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Contact">${userContext.localeMap['contact']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./contactManager/loadContactDetail/${contact.id}/"> ${contact.id}</a></li>
<li><span>${userContext.localeMap['contact.name']}</span> ${contact.name}</li>
<li><span>${userContext.localeMap['contact.mobile']}</span> ${contact.maskedMobile}</li>
<li><span>${userContext.localeMap['contact.description']}</span> ${contact.description}</li>

	
	</ul>
	
	
	
</div>

</c:if>




