<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="productList" value="${result.productList}"/>

<c:if test="${ empty productList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['product']}! 
		 <a href="./${ownerBeanName}Manager/addProduct/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.productList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("productList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['product']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addProduct/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'productList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/productList;productListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='productListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['product.id']}</th>
</c:if>
<c:if test="${param.referName ne 'displayName'}">
	<th>${userContext.localeMap['product.display_name']}</th>
</c:if>
<c:if test="${param.referName ne 'parentCategory'}">
	<th>${userContext.localeMap['product.parent_category']}</th>
</c:if>
<c:if test="${param.referName ne 'origin'}">
	<th>${userContext.localeMap['product.origin']}</th>
</c:if>
<c:if test="${param.referName ne 'remark'}">
	<th>${userContext.localeMap['product.remark']}</th>
</c:if>
<c:if test="${param.referName ne 'brand'}">
	<th>${userContext.localeMap['product.brand']}</th>
</c:if>
<c:if test="${param.referName ne 'picture'}">
	<th>${userContext.localeMap['product.picture']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.productList}">
				<tr currentVersion='${item.version}' id="product-${item.id}" ><td><a class="link-action-removed" href="./productManager/loadProductDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'displayName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='displayName' storedCellValue='${item.displayName}' prefix='${ownerBeanName}Manager/updateProduct/${result.id}/${item.id}/'>${item.displayName}</td>
</c:if><c:if test="${param.referName ne 'parentCategory'}">	<td ><a href='./levelThreeCategoryManager/loadLevelThreeCategoryDetail/${item.parentCategory.id}/'>${item.parentCategory.id}</a></td>
</c:if><c:if test="${param.referName ne 'origin'}">	<td contenteditable='true' class='edit-value'  propertyToChange='origin' storedCellValue='${item.origin}' prefix='${ownerBeanName}Manager/updateProduct/${result.id}/${item.id}/'>${item.origin}</td>
</c:if><c:if test="${param.referName ne 'remark'}">	<td contenteditable='true' class='edit-value'  propertyToChange='remark' storedCellValue='${item.remark}' prefix='${ownerBeanName}Manager/updateProduct/${result.id}/${item.id}/'>${item.remark}</td>
</c:if><c:if test="${param.referName ne 'brand'}">	<td contenteditable='true' class='edit-value'  propertyToChange='brand' storedCellValue='${item.brand}' prefix='${ownerBeanName}Manager/updateProduct/${result.id}/${item.id}/'>${item.brand}</td>
</c:if><c:if test="${param.referName ne 'picture'}">	<td contenteditable='true' class='edit-value'  propertyToChange='picture' storedCellValue='${item.picture}' prefix='${ownerBeanName}Manager/updateProduct/${result.id}/${item.id}/'>${item.picture}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeProduct/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyProductFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


