
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplyOrder}">
<div class="col-xs-12 col-md-4 section">
	<b title="A SupplyOrder">${userContext.localeMap['supply_order']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./supplyOrderManager/loadSupplyOrderDetail/${supplyOrder.id}/"> ${supplyOrder.id}</a></li>
<li><span>${userContext.localeMap['supply_order.title']}</span> ${supplyOrder.title}</li>
<li><span>${userContext.localeMap['supply_order.total_amount']}</span> <fmt:formatNumber type="currency"  value="${supplyOrder.totalAmount}" /></li>
<li><span>${userContext.localeMap['supply_order.current_status']}</span> ${supplyOrder.currentStatus}</li>

	
	</ul>
	
	
	
</div>

</c:if>




