<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="responsibilityTypeList" value="${result.responsibilityTypeList}"/>

<c:if test="${ empty responsibilityTypeList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['responsibility_type']}! 
		 <a href="./${ownerBeanName}Manager/addResponsibilityType/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.responsibilityTypeList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("responsibilityTypeList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['responsibility_type']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addResponsibilityType/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'responsibilityTypeList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/responsibilityTypeList;responsibilityTypeListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='responsibilityTypeListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['responsibility_type.id']}</th>
</c:if>
<c:if test="${param.referName ne 'code'}">
	<th>${userContext.localeMap['responsibility_type.code']}</th>
</c:if>
<c:if test="${param.referName ne 'company'}">
	<th>${userContext.localeMap['responsibility_type.company']}</th>
</c:if>
<c:if test="${param.referName ne 'baseDescription'}">
	<th>${userContext.localeMap['responsibility_type.base_description']}</th>
</c:if>
<c:if test="${param.referName ne 'detailDescription'}">
	<th>${userContext.localeMap['responsibility_type.detail_description']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.responsibilityTypeList}">
				<tr currentVersion='${item.version}' id="responsibilityType-${item.id}" ><td><a class="link-action-removed" href="./responsibilityTypeManager/loadResponsibilityTypeDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'code'}">	<td contenteditable='true' class='edit-value'  propertyToChange='code' storedCellValue='${item.code}' prefix='${ownerBeanName}Manager/updateResponsibilityType/${result.id}/${item.id}/'>${item.code}</td>
</c:if><c:if test="${param.referName ne 'company'}">	<td ><a href='./retailStoreCountryCenterManager/loadRetailStoreCountryCenterDetail/${item.company.id}/'>${item.company.id}</a></td>
</c:if><c:if test="${param.referName ne 'baseDescription'}">	<td contenteditable='true' class='edit-value'  propertyToChange='baseDescription' storedCellValue='${item.baseDescription}' prefix='${ownerBeanName}Manager/updateResponsibilityType/${result.id}/${item.id}/'>${item.baseDescription}</td>
</c:if><c:if test="${param.referName ne 'detailDescription'}">	<td contenteditable='true' class='edit-value'  propertyToChange='detailDescription' storedCellValue='${item.detailDescription}' prefix='${ownerBeanName}Manager/updateResponsibilityType/${result.id}/${item.id}/'>${item.detailDescription}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeResponsibilityType/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyResponsibilityTypeFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


