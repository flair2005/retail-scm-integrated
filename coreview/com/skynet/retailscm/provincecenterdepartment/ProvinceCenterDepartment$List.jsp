<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="provinceCenterDepartmentList" value="${result.provinceCenterDepartmentList}"/>

<c:if test="${ empty provinceCenterDepartmentList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['province_center_department']}! 
		 <a href="./${ownerBeanName}Manager/addProvinceCenterDepartment/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.provinceCenterDepartmentList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("provinceCenterDepartmentList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['province_center_department']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addProvinceCenterDepartment/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'provinceCenterDepartmentList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/provinceCenterDepartmentList;provinceCenterDepartmentListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='provinceCenterDepartmentListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['province_center_department.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['province_center_department.name']}</th>
</c:if>
<c:if test="${param.referName ne 'founded'}">
	<th>${userContext.localeMap['province_center_department.founded']}</th>
</c:if>
<c:if test="${param.referName ne 'provinceCenter'}">
	<th>${userContext.localeMap['province_center_department.province_center']}</th>
</c:if>
<c:if test="${param.referName ne 'manager'}">
	<th>${userContext.localeMap['province_center_department.manager']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.provinceCenterDepartmentList}">
				<tr currentVersion='${item.version}' id="provinceCenterDepartment-${item.id}" ><td><a class="link-action-removed" href="./provinceCenterDepartmentManager/loadProvinceCenterDepartmentDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateProvinceCenterDepartment/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'founded'}">	<td contenteditable='true' class='edit-value'  propertyToChange='founded' storedCellValue='${item.founded}' prefix='${ownerBeanName}Manager/updateProvinceCenterDepartment/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.founded}" /></td>
</c:if><c:if test="${param.referName ne 'provinceCenter'}">	<td ><a href='./retailStoreProvinceCenterManager/loadRetailStoreProvinceCenterDetail/${item.provinceCenter.id}/'>${item.provinceCenter.id}</a></td>
</c:if><c:if test="${param.referName ne 'manager'}">	<td contenteditable='true' class='edit-value'  propertyToChange='manager' storedCellValue='${item.manager}' prefix='${ownerBeanName}Manager/updateProvinceCenterDepartment/${result.id}/${item.id}/'>${item.manager}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeProvinceCenterDepartment/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyProvinceCenterDepartmentFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


