<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="supplierSpaceList" value="${result.supplierSpaceList}"/>

<c:if test="${ empty supplierSpaceList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['supplier_space']}! 
		 <a href="./${ownerBeanName}Manager/addSupplierSpace/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.supplierSpaceList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("supplierSpaceList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['supplier_space']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addSupplierSpace/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'supplierSpaceList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/supplierSpaceList;supplierSpaceListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='supplierSpaceListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['supplier_space.id']}</th>
</c:if>
<c:if test="${param.referName ne 'location'}">
	<th>${userContext.localeMap['supplier_space.location']}</th>
</c:if>
<c:if test="${param.referName ne 'contactNumber'}">
	<th>${userContext.localeMap['supplier_space.contact_number']}</th>
</c:if>
<c:if test="${param.referName ne 'totalArea'}">
	<th>${userContext.localeMap['supplier_space.total_area']}</th>
</c:if>
<c:if test="${param.referName ne 'warehouse'}">
	<th>${userContext.localeMap['supplier_space.warehouse']}</th>
</c:if>
<c:if test="${param.referName ne 'latitude'}">
	<th>${userContext.localeMap['supplier_space.latitude']}</th>
</c:if>
<c:if test="${param.referName ne 'longitude'}">
	<th>${userContext.localeMap['supplier_space.longitude']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.supplierSpaceList}">
				<tr currentVersion='${item.version}' id="supplierSpace-${item.id}" ><td><a class="link-action-removed" href="./supplierSpaceManager/loadSupplierSpaceDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'location'}">	<td contenteditable='true' class='edit-value'  propertyToChange='location' storedCellValue='${item.location}' prefix='${ownerBeanName}Manager/updateSupplierSpace/${result.id}/${item.id}/'>${item.location}</td>
</c:if><c:if test="${param.referName ne 'contactNumber'}">	<td contenteditable='true' class='edit-value'  propertyToChange='contactNumber' storedCellValue='${item.contactNumber}' prefix='${ownerBeanName}Manager/updateSupplierSpace/${result.id}/${item.id}/'>${item.contactNumber}</td>
</c:if><c:if test="${param.referName ne 'totalArea'}">	<td contenteditable='true' class='edit-value'  propertyToChange='totalArea' storedCellValue='${item.totalArea}' prefix='${ownerBeanName}Manager/updateSupplierSpace/${result.id}/${item.id}/'>${item.totalArea}</td>
</c:if><c:if test="${param.referName ne 'warehouse'}">	<td ><a href='./warehouseManager/loadWarehouseDetail/${item.warehouse.id}/'>${item.warehouse.id}</a></td>
</c:if><c:if test="${param.referName ne 'latitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='latitude' storedCellValue='${item.latitude}' prefix='${ownerBeanName}Manager/updateSupplierSpace/${result.id}/${item.id}/'>${item.latitude}</td>
</c:if><c:if test="${param.referName ne 'longitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='longitude' storedCellValue='${item.longitude}' prefix='${ownerBeanName}Manager/updateSupplierSpace/${result.id}/${item.id}/'>${item.longitude}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeSupplierSpace/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copySupplierSpaceFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


