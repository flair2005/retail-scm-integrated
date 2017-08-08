
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty adEvent}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A AdEvent" style="color: green">${userContext.localeMap['ad_event']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['ad_event.id']}</span> ${adEvent.id}</li>
<li><span>${userContext.localeMap['ad_event.name']}</span> ${adEvent.name}</li>
<li><span>${userContext.localeMap['ad_event.mobile']}</span> ${adEvent.maskedMobile}</li>
<li><span>${userContext.localeMap['ad_event.description']}</span> ${adEvent.description}</li>

	
	</ul>
</div>



</c:if>


