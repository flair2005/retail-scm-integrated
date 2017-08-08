
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty contract}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A Contract" style="color: green">${userContext.localeMap['contract']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['contract.id']}</span> ${contract.id}</li>
<li><span>${userContext.localeMap['contract.title']}</span> ${contract.title}</li>
<li><span>${userContext.localeMap['contract.summary']}</span> ${contract.summary}</li>
<li><span>${userContext.localeMap['contract.attachment']}</span> ${contract.attachment}</li>

	
	</ul>
</div>



</c:if>


