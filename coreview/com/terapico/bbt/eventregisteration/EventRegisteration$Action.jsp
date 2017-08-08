
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty eventRegisteration}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A EventRegisteration" style="color: green">${userContext.localeMap['event_registeration']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['event_registeration.id']}</span> ${eventRegisteration.id}</li>
<li><span>${userContext.localeMap['event_registeration.register_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${eventRegisteration.registerDate}" /></li>
<li><span>${userContext.localeMap['event_registeration.comments']}</span> ${eventRegisteration.comments}</li>

	
	</ul>
</div>



</c:if>


