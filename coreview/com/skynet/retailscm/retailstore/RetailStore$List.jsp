<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="retailStoreList" value="${result.retailStoreList}"/>

<c:if test="${ empty retailStoreList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['retail_store']}! 
		 <a href="./${ownerBeanName}Manager/addRetailStore/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.retailStoreList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("retailStoreList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['retail_store']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addRetailStore/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'retailStoreList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/retailStoreList;retailStoreListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='retailStoreListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['retail_store.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['retail_store.name']}</th>
</c:if>
<c:if test="${param.referName ne 'telephone'}">
	<th>${userContext.localeMap['retail_store.telephone']}</th>
</c:if>
<c:if test="${param.referName ne 'owner'}">
	<th>${userContext.localeMap['retail_store.owner']}</th>
</c:if>
<c:if test="${param.referName ne 'retailStoreCountryCenter'}">
	<th>${userContext.localeMap['retail_store.retail_store_country_center']}</th>
</c:if>
<c:if test="${param.referName ne 'cityServiceCenter'}">
	<th>${userContext.localeMap['retail_store.city_service_center']}</th>
</c:if>
<c:if test="${param.referName ne 'creation'}">
	<th>${userContext.localeMap['retail_store.creation']}</th>
</c:if>
<c:if test="${param.referName ne 'investmentInvitation'}">
	<th>${userContext.localeMap['retail_store.investment_invitation']}</th>
</c:if>
<c:if test="${param.referName ne 'franchising'}">
	<th>${userContext.localeMap['retail_store.franchising']}</th>
</c:if>
<c:if test="${param.referName ne 'decoration'}">
	<th>${userContext.localeMap['retail_store.decoration']}</th>
</c:if>
<c:if test="${param.referName ne 'opening'}">
	<th>${userContext.localeMap['retail_store.opening']}</th>
</c:if>
<c:if test="${param.referName ne 'closing'}">
	<th>${userContext.localeMap['retail_store.closing']}</th>
</c:if>
<c:if test="${param.referName ne 'founded'}">
	<th>${userContext.localeMap['retail_store.founded']}</th>
</c:if>
<c:if test="${param.referName ne 'latitude'}">
	<th>${userContext.localeMap['retail_store.latitude']}</th>
</c:if>
<c:if test="${param.referName ne 'longitude'}">
	<th>${userContext.localeMap['retail_store.longitude']}</th>
</c:if>
<c:if test="${param.referName ne 'description'}">
	<th>${userContext.localeMap['retail_store.description']}</th>
</c:if>
<c:if test="${param.referName ne 'currentStatus'}">
	<th>${userContext.localeMap['retail_store.current_status']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.retailStoreList}">
				<tr currentVersion='${item.version}' id="retailStore-${item.id}" ><td><a class="link-action-removed" href="./retailStoreManager/loadRetailStoreDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'telephone'}">	<td contenteditable='true' class='edit-value'  propertyToChange='telephone' storedCellValue='${item.telephone}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.telephone}</td>
</c:if><c:if test="${param.referName ne 'owner'}">	<td contenteditable='true' class='edit-value'  propertyToChange='owner' storedCellValue='${item.owner}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.owner}</td>
</c:if><c:if test="${param.referName ne 'retailStoreCountryCenter'}">	<td ><a href='./retailStoreCountryCenterManager/loadRetailStoreCountryCenterDetail/${item.retailStoreCountryCenter.id}/'>${item.retailStoreCountryCenter.id}</a></td>
</c:if><c:if test="${param.referName ne 'cityServiceCenter'}">	<td ><a href='./retailStoreCityServiceCenterManager/loadRetailStoreCityServiceCenterDetail/${item.cityServiceCenter.id}/'>${item.cityServiceCenter.id}</a></td>
</c:if><c:if test="${param.referName ne 'creation'}">	<td ><a href='./retailStoreCreationManager/loadRetailStoreCreationDetail/${item.creation.id}/'>${item.creation.id}</a></td>
</c:if><c:if test="${param.referName ne 'investmentInvitation'}">	<td ><a href='./retailStoreInvestmentInvitationManager/loadRetailStoreInvestmentInvitationDetail/${item.investmentInvitation.id}/'>${item.investmentInvitation.id}</a></td>
</c:if><c:if test="${param.referName ne 'franchising'}">	<td ><a href='./retailStoreFranchisingManager/loadRetailStoreFranchisingDetail/${item.franchising.id}/'>${item.franchising.id}</a></td>
</c:if><c:if test="${param.referName ne 'decoration'}">	<td ><a href='./retailStoreDecorationManager/loadRetailStoreDecorationDetail/${item.decoration.id}/'>${item.decoration.id}</a></td>
</c:if><c:if test="${param.referName ne 'opening'}">	<td ><a href='./retailStoreOpeningManager/loadRetailStoreOpeningDetail/${item.opening.id}/'>${item.opening.id}</a></td>
</c:if><c:if test="${param.referName ne 'closing'}">	<td ><a href='./retailStoreClosingManager/loadRetailStoreClosingDetail/${item.closing.id}/'>${item.closing.id}</a></td>
</c:if><c:if test="${param.referName ne 'founded'}">	<td contenteditable='true' class='edit-value'  propertyToChange='founded' storedCellValue='${item.founded}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.founded}" /></td>
</c:if><c:if test="${param.referName ne 'latitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='latitude' storedCellValue='${item.latitude}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.latitude}</td>
</c:if><c:if test="${param.referName ne 'longitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='longitude' storedCellValue='${item.longitude}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.longitude}</td>
</c:if><c:if test="${param.referName ne 'description'}">	<td contenteditable='true' class='edit-value'  propertyToChange='description' storedCellValue='${item.description}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.description}</td>
</c:if><c:if test="${param.referName ne 'currentStatus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='currentStatus' storedCellValue='${item.currentStatus}' prefix='${ownerBeanName}Manager/updateRetailStore/${result.id}/${item.id}/'>${item.currentStatus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeRetailStore/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyRetailStoreFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


