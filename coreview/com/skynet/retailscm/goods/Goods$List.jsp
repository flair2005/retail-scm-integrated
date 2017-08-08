<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="goodsList" value="${result.goodsList}"/>

<c:if test="${ empty goodsList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['goods']}! 
		 <a href="./${ownerBeanName}Manager/addGoods/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.goodsList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("goodsList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['goods']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addGoods/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'goodsList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/goodsList;goodsListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='goodsListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['goods.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['goods.name']}</th>
</c:if>
<c:if test="${param.referName ne 'rfid'}">
	<th>${userContext.localeMap['goods.rfid']}</th>
</c:if>
<c:if test="${param.referName ne 'uom'}">
	<th>${userContext.localeMap['goods.uom']}</th>
</c:if>
<c:if test="${param.referName ne 'maxPackage'}">
	<th>${userContext.localeMap['goods.max_package']}</th>
</c:if>
<c:if test="${param.referName ne 'expireTime'}">
	<th>${userContext.localeMap['goods.expire_time']}</th>
</c:if>
<c:if test="${param.referName ne 'sku'}">
	<th>${userContext.localeMap['goods.sku']}</th>
</c:if>
<c:if test="${param.referName ne 'receivingSpace'}">
	<th>${userContext.localeMap['goods.receiving_space']}</th>
</c:if>
<c:if test="${param.referName ne 'goodsAllocation'}">
	<th>${userContext.localeMap['goods.goods_allocation']}</th>
</c:if>
<c:if test="${param.referName ne 'smartPallet'}">
	<th>${userContext.localeMap['goods.smart_pallet']}</th>
</c:if>
<c:if test="${param.referName ne 'shippingSpace'}">
	<th>${userContext.localeMap['goods.shipping_space']}</th>
</c:if>
<c:if test="${param.referName ne 'transportTask'}">
	<th>${userContext.localeMap['goods.transport_task']}</th>
</c:if>
<c:if test="${param.referName ne 'retailStore'}">
	<th>${userContext.localeMap['goods.retail_store']}</th>
</c:if>
<c:if test="${param.referName ne 'bizOrder'}">
	<th>${userContext.localeMap['goods.biz_order']}</th>
</c:if>
<c:if test="${param.referName ne 'retailStoreOrder'}">
	<th>${userContext.localeMap['goods.retail_store_order']}</th>
</c:if>
<c:if test="${param.referName ne 'packaging'}">
	<th>${userContext.localeMap['goods.packaging']}</th>
</c:if>
<c:if test="${param.referName ne 'currentStatus'}">
	<th>${userContext.localeMap['goods.current_status']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.goodsList}">
				<tr currentVersion='${item.version}' id="goods-${item.id}" ><td><a class="link-action-removed" href="./goodsManager/loadGoodsDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'rfid'}">	<td contenteditable='true' class='edit-value'  propertyToChange='rfid' storedCellValue='${item.rfid}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'>${item.rfid}</td>
</c:if><c:if test="${param.referName ne 'uom'}">	<td contenteditable='true' class='edit-value'  propertyToChange='uom' storedCellValue='${item.uom}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'>${item.uom}</td>
</c:if><c:if test="${param.referName ne 'maxPackage'}">	<td contenteditable='true' class='edit-value'  propertyToChange='maxPackage' storedCellValue='${item.maxPackage}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'>${item.maxPackage}</td>
</c:if><c:if test="${param.referName ne 'expireTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='expireTime' storedCellValue='${item.expireTime}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.expireTime}" /></td>
</c:if><c:if test="${param.referName ne 'sku'}">	<td ><a href='./skuManager/loadSkuDetail/${item.sku.id}/'>${item.sku.id}</a></td>
</c:if><c:if test="${param.referName ne 'receivingSpace'}">	<td ><a href='./receivingSpaceManager/loadReceivingSpaceDetail/${item.receivingSpace.id}/'>${item.receivingSpace.id}</a></td>
</c:if><c:if test="${param.referName ne 'goodsAllocation'}">	<td ><a href='./goodsAllocationManager/loadGoodsAllocationDetail/${item.goodsAllocation.id}/'>${item.goodsAllocation.id}</a></td>
</c:if><c:if test="${param.referName ne 'smartPallet'}">	<td ><a href='./smartPalletManager/loadSmartPalletDetail/${item.smartPallet.id}/'>${item.smartPallet.id}</a></td>
</c:if><c:if test="${param.referName ne 'shippingSpace'}">	<td ><a href='./shippingSpaceManager/loadShippingSpaceDetail/${item.shippingSpace.id}/'>${item.shippingSpace.id}</a></td>
</c:if><c:if test="${param.referName ne 'transportTask'}">	<td ><a href='./transportTaskManager/loadTransportTaskDetail/${item.transportTask.id}/'>${item.transportTask.id}</a></td>
</c:if><c:if test="${param.referName ne 'retailStore'}">	<td ><a href='./retailStoreManager/loadRetailStoreDetail/${item.retailStore.id}/'>${item.retailStore.id}</a></td>
</c:if><c:if test="${param.referName ne 'bizOrder'}">	<td ><a href='./supplyOrderManager/loadSupplyOrderDetail/${item.bizOrder.id}/'>${item.bizOrder.id}</a></td>
</c:if><c:if test="${param.referName ne 'retailStoreOrder'}">	<td ><a href='./retailStoreOrderManager/loadRetailStoreOrderDetail/${item.retailStoreOrder.id}/'>${item.retailStoreOrder.id}</a></td>
</c:if><c:if test="${param.referName ne 'packaging'}">	<td ><a href='./goodsPackagingManager/loadGoodsPackagingDetail/${item.packaging.id}/'>${item.packaging.id}</a></td>
</c:if><c:if test="${param.referName ne 'currentStatus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='currentStatus' storedCellValue='${item.currentStatus}' prefix='${ownerBeanName}Manager/updateGoods/${result.id}/${item.id}/'>${item.currentStatus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeGoods/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyGoodsFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


