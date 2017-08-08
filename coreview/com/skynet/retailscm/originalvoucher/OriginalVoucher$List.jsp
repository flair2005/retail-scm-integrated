<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="originalVoucherList" value="${result.originalVoucherList}"/>

<c:if test="${ empty originalVoucherList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['original_voucher']}! 
		 <a href="./${ownerBeanName}Manager/addOriginalVoucher/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.originalVoucherList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("originalVoucherList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['original_voucher']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addOriginalVoucher/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'originalVoucherList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/originalVoucherList;originalVoucherListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='originalVoucherListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['original_voucher.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['original_voucher.title']}</th>
</c:if>
<c:if test="${param.referName ne 'madeBy'}">
	<th>${userContext.localeMap['original_voucher.made_by']}</th>
</c:if>
<c:if test="${param.referName ne 'receivedBy'}">
	<th>${userContext.localeMap['original_voucher.received_by']}</th>
</c:if>
<c:if test="${param.referName ne 'voucherType'}">
	<th>${userContext.localeMap['original_voucher.voucher_type']}</th>
</c:if>
<c:if test="${param.referName ne 'voucherImage'}">
	<th>${userContext.localeMap['original_voucher.voucher_image']}</th>
</c:if>
<c:if test="${param.referName ne 'belongsTo'}">
	<th>${userContext.localeMap['original_voucher.belongs_to']}</th>
</c:if>
<c:if test="${param.referName ne 'creation'}">
	<th>${userContext.localeMap['original_voucher.creation']}</th>
</c:if>
<c:if test="${param.referName ne 'confirmation'}">
	<th>${userContext.localeMap['original_voucher.confirmation']}</th>
</c:if>
<c:if test="${param.referName ne 'auditing'}">
	<th>${userContext.localeMap['original_voucher.auditing']}</th>
</c:if>
<c:if test="${param.referName ne 'currentStatus'}">
	<th>${userContext.localeMap['original_voucher.current_status']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.originalVoucherList}">
				<tr currentVersion='${item.version}' id="originalVoucher-${item.id}" ><td><a class="link-action-removed" href="./originalVoucherManager/loadOriginalVoucherDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateOriginalVoucher/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'madeBy'}">	<td contenteditable='true' class='edit-value'  propertyToChange='madeBy' storedCellValue='${item.madeBy}' prefix='${ownerBeanName}Manager/updateOriginalVoucher/${result.id}/${item.id}/'>${item.madeBy}</td>
</c:if><c:if test="${param.referName ne 'receivedBy'}">	<td contenteditable='true' class='edit-value'  propertyToChange='receivedBy' storedCellValue='${item.receivedBy}' prefix='${ownerBeanName}Manager/updateOriginalVoucher/${result.id}/${item.id}/'>${item.receivedBy}</td>
</c:if><c:if test="${param.referName ne 'voucherType'}">	<td contenteditable='true' class='edit-value'  propertyToChange='voucherType' storedCellValue='${item.voucherType}' prefix='${ownerBeanName}Manager/updateOriginalVoucher/${result.id}/${item.id}/'>${item.voucherType}</td>
</c:if><c:if test="${param.referName ne 'voucherImage'}">	<td contenteditable='true' class='edit-value'  propertyToChange='voucherImage' storedCellValue='${item.voucherImage}' prefix='${ownerBeanName}Manager/updateOriginalVoucher/${result.id}/${item.id}/'>${item.voucherImage}</td>
</c:if><c:if test="${param.referName ne 'belongsTo'}">	<td ><a href='./accountingDocumentManager/loadAccountingDocumentDetail/${item.belongsTo.id}/'>${item.belongsTo.id}</a></td>
</c:if><c:if test="${param.referName ne 'creation'}">	<td ><a href='./originalVoucherCreationManager/loadOriginalVoucherCreationDetail/${item.creation.id}/'>${item.creation.id}</a></td>
</c:if><c:if test="${param.referName ne 'confirmation'}">	<td ><a href='./originalVoucherConfirmationManager/loadOriginalVoucherConfirmationDetail/${item.confirmation.id}/'>${item.confirmation.id}</a></td>
</c:if><c:if test="${param.referName ne 'auditing'}">	<td ><a href='./originalVoucherAuditingManager/loadOriginalVoucherAuditingDetail/${item.auditing.id}/'>${item.auditing.id}</a></td>
</c:if><c:if test="${param.referName ne 'currentStatus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='currentStatus' storedCellValue='${item.currentStatus}' prefix='${ownerBeanName}Manager/updateOriginalVoucher/${result.id}/${item.id}/'>${item.currentStatus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeOriginalVoucher/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyOriginalVoucherFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


