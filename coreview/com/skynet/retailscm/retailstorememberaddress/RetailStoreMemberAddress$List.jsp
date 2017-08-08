<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="retailStoreMemberAddressList" value="${result.retailStoreMemberAddressList}"/>

<c:if test="${ empty retailStoreMemberAddressList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['retail_store_member_address']}! 
		 <a href="./${ownerBeanName}Manager/addRetailStoreMemberAddress/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.retailStoreMemberAddressList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("retailStoreMemberAddressList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['retail_store_member_address']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addRetailStoreMemberAddress/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'retailStoreMemberAddressList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/retailStoreMemberAddressList;retailStoreMemberAddressListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='retailStoreMemberAddressListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['retail_store_member_address.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['retail_store_member_address.name']}</th>
</c:if>
<c:if test="${param.referName ne 'owner'}">
	<th>${userContext.localeMap['retail_store_member_address.owner']}</th>
</c:if>
<c:if test="${param.referName ne 'mobilePhone'}">
	<th>${userContext.localeMap['retail_store_member_address.mobile_phone']}</th>
</c:if>
<c:if test="${param.referName ne 'address'}">
	<th>${userContext.localeMap['retail_store_member_address.address']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.retailStoreMemberAddressList}">
				<tr currentVersion='${item.version}' id="retailStoreMemberAddress-${item.id}" ><td><a class="link-action-removed" href="./retailStoreMemberAddressManager/loadRetailStoreMemberAddressDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateRetailStoreMemberAddress/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'owner'}">	<td ><a href='./retailStoreMemberManager/loadRetailStoreMemberDetail/${item.owner.id}/'>${item.owner.id}</a></td>
</c:if><c:if test="${param.referName ne 'mobilePhone'}">	<td contenteditable='true' class='edit-value'  propertyToChange='mobilePhone' storedCellValue='${item.maskedMobilePhone}' prefix='${ownerBeanName}Manager/updateRetailStoreMemberAddress/${result.id}/${item.id}/'>${item.maskedMobilePhone}</td>
</c:if><c:if test="${param.referName ne 'address'}">	<td contenteditable='true' class='edit-value'  propertyToChange='address' storedCellValue='${item.address}' prefix='${ownerBeanName}Manager/updateRetailStoreMemberAddress/${result.id}/${item.id}/'>${item.address}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeRetailStoreMemberAddress/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyRetailStoreMemberAddressFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


