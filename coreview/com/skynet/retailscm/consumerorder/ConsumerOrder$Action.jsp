
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty consumerOrder}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A ConsumerOrder" style="color: green">${userContext.localeMap['consumer_order']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['consumer_order.id']}</span> ${consumerOrder.id}</li>
<li><span>${userContext.localeMap['consumer_order.title']}</span> ${consumerOrder.title}</li>
<li><span>${userContext.localeMap['consumer_order.current_status']}</span> ${consumerOrder.currentStatus}</li>

	
	</ul>
</div>



</c:if>


