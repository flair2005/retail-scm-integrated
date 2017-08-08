<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="consumerOrderShippingGroupList" value="${result.consumerOrderShippingGroupList}"/>

<c:if test="${ empty consumerOrderShippingGroupList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['consumer_order_shipping_group']}! 
		 <a href="./${ownerBeanName}Manager/addConsumerOrderShippingGroup/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.consumerOrderShippingGroupList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("consumerOrderShippingGroupList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['consumer_order_shipping_group']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addConsumerOrderShippingGroup/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'consumerOrderShippingGroupList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/consumerOrderShippingGroupList;consumerOrderShippingGroupListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='consumerOrderShippingGroupListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['consumer_order_shipping_group.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['consumer_order_shipping_group.name']}</th>
</c:if>
<c:if test="${param.referName ne 'bizOrder'}">
	<th>${userContext.localeMap['consumer_order_shipping_group.biz_order']}</th>
</c:if>
<c:if test="${param.referName ne 'amount'}">
	<th>${userContext.localeMap['consumer_order_shipping_group.amount']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.consumerOrderShippingGroupList}">
				<tr currentVersion='${item.version}' id="consumerOrderShippingGroup-${item.id}" ><td><a class="link-action-removed" href="./consumerOrderShippingGroupManager/loadConsumerOrderShippingGroupDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateConsumerOrderShippingGroup/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'bizOrder'}">	<td ><a href='./consumerOrderManager/loadConsumerOrderDetail/${item.bizOrder.id}/'>${item.bizOrder.id}</a></td>
</c:if><c:if test="${param.referName ne 'amount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='amount' storedCellValue='${item.amount}' prefix='${ownerBeanName}Manager/updateConsumerOrderShippingGroup/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.amount}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeConsumerOrderShippingGroup/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyConsumerOrderShippingGroupFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


