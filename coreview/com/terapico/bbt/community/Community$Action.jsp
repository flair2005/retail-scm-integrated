
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty community}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A Community" style="color: green">${userContext.localeMap['community']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['community.id']}</span> ${community.id}</li>
<li><span>${userContext.localeMap['community.name']}</span> ${community.name}</li>
<li><span>${userContext.localeMap['community.description']}</span> ${community.description}</li>

	
	</ul>
</div>



</c:if>


