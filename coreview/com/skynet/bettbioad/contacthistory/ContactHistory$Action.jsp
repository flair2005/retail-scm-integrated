
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty contactHistory}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A ContactHistory" style="color: green">${userContext.localeMap['contact_history']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['contact_history.id']}</span> ${contactHistory.id}</li>
<li><span>${userContext.localeMap['contact_history.name']}</span> ${contactHistory.name}</li>
<li><span>${userContext.localeMap['contact_history.contact_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${contactHistory.contactDate}" /></li>
<li><span>${userContext.localeMap['contact_history.contact_method']}</span> ${contactHistory.contactMethod}</li>
<li><span>${userContext.localeMap['contact_history.description']}</span> ${contactHistory.description}</li>

	
	</ul>
</div>



</c:if>


