
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreOrderProcessing}">
<div class="col-xs-12 col-md-4 section">
	<b title="A RetailStoreOrderProcessing">${userContext.localeMap['retail_store_order_processing']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./retailStoreOrderProcessingManager/loadRetailStoreOrderProcessingDetail/${retailStoreOrderProcessing.id}/"> ${retailStoreOrderProcessing.id}</a></li>
<li><span>${userContext.localeMap['retail_store_order_processing.who']}</span> ${retailStoreOrderProcessing.who}</li>
<li><span>${userContext.localeMap['retail_store_order_processing.process_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${retailStoreOrderProcessing.processTime}" /></li>

	
	</ul>
	
	
	
</div>

</c:if>




