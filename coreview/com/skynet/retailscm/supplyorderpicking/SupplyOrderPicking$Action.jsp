
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplyOrderPicking}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A SupplyOrderPicking" style="color: green">${userContext.localeMap['supply_order_picking']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['supply_order_picking.id']}</span> ${supplyOrderPicking.id}</li>
<li><span>${userContext.localeMap['supply_order_picking.who']}</span> ${supplyOrderPicking.who}</li>
<li><span>${userContext.localeMap['supply_order_picking.process_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${supplyOrderPicking.processTime}" /></li>

	
	</ul>
</div>



</c:if>


