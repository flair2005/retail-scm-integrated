<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="supplyOrderList" value="${result.supplyOrderList}"/>

<c:if test="${ empty supplyOrderList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['supply_order']}! 
		 <a href="./${ownerBeanName}Manager/addSupplyOrder/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.supplyOrderList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("supplyOrderList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['supply_order']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addSupplyOrder/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'supplyOrderList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/supplyOrderList;supplyOrderListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='supplyOrderListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['supply_order.id']}</th>
</c:if>
<c:if test="${param.referName ne 'buyer'}">
	<th>${userContext.localeMap['supply_order.buyer']}</th>
</c:if>
<c:if test="${param.referName ne 'seller'}">
	<th>${userContext.localeMap['supply_order.seller']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['supply_order.title']}</th>
</c:if>
<c:if test="${param.referName ne 'totalAmount'}">
	<th>${userContext.localeMap['supply_order.total_amount']}</th>
</c:if>
<c:if test="${param.referName ne 'confirmation'}">
	<th>${userContext.localeMap['supply_order.confirmation']}</th>
</c:if>
<c:if test="${param.referName ne 'approval'}">
	<th>${userContext.localeMap['supply_order.approval']}</th>
</c:if>
<c:if test="${param.referName ne 'processing'}">
	<th>${userContext.localeMap['supply_order.processing']}</th>
</c:if>
<c:if test="${param.referName ne 'picking'}">
	<th>${userContext.localeMap['supply_order.picking']}</th>
</c:if>
<c:if test="${param.referName ne 'shipment'}">
	<th>${userContext.localeMap['supply_order.shipment']}</th>
</c:if>
<c:if test="${param.referName ne 'delivery'}">
	<th>${userContext.localeMap['supply_order.delivery']}</th>
</c:if>
<c:if test="${param.referName ne 'currentStatus'}">
	<th>${userContext.localeMap['supply_order.current_status']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.supplyOrderList}">
				<tr currentVersion='${item.version}' id="supplyOrder-${item.id}" ><td><a class="link-action-removed" href="./supplyOrderManager/loadSupplyOrderDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'buyer'}">	<td ><a href='./retailStoreCountryCenterManager/loadRetailStoreCountryCenterDetail/${item.buyer.id}/'>${item.buyer.id}</a></td>
</c:if><c:if test="${param.referName ne 'seller'}">	<td ><a href='./goodsSupplierManager/loadGoodsSupplierDetail/${item.seller.id}/'>${item.seller.id}</a></td>
</c:if><c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateSupplyOrder/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'totalAmount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='totalAmount' storedCellValue='${item.totalAmount}' prefix='${ownerBeanName}Manager/updateSupplyOrder/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.totalAmount}" /></td>
</c:if><c:if test="${param.referName ne 'confirmation'}">	<td ><a href='./supplyOrderConfirmationManager/loadSupplyOrderConfirmationDetail/${item.confirmation.id}/'>${item.confirmation.id}</a></td>
</c:if><c:if test="${param.referName ne 'approval'}">	<td ><a href='./supplyOrderApprovalManager/loadSupplyOrderApprovalDetail/${item.approval.id}/'>${item.approval.id}</a></td>
</c:if><c:if test="${param.referName ne 'processing'}">	<td ><a href='./supplyOrderProcessingManager/loadSupplyOrderProcessingDetail/${item.processing.id}/'>${item.processing.id}</a></td>
</c:if><c:if test="${param.referName ne 'picking'}">	<td ><a href='./supplyOrderPickingManager/loadSupplyOrderPickingDetail/${item.picking.id}/'>${item.picking.id}</a></td>
</c:if><c:if test="${param.referName ne 'shipment'}">	<td ><a href='./supplyOrderShipmentManager/loadSupplyOrderShipmentDetail/${item.shipment.id}/'>${item.shipment.id}</a></td>
</c:if><c:if test="${param.referName ne 'delivery'}">	<td ><a href='./supplyOrderDeliveryManager/loadSupplyOrderDeliveryDetail/${item.delivery.id}/'>${item.delivery.id}</a></td>
</c:if><c:if test="${param.referName ne 'currentStatus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='currentStatus' storedCellValue='${item.currentStatus}' prefix='${ownerBeanName}Manager/updateSupplyOrder/${result.id}/${item.id}/'>${item.currentStatus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeSupplyOrder/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copySupplyOrderFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


