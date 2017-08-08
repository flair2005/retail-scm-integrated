<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="refrigeratorInOrgnizationListList" value="${result.refrigeratorInOrgnizationListList}"/>

<c:if test="${ empty refrigeratorInOrgnizationListList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['refrigerator_in_orgnization_list']}! 
		 <a href="./${ownerBeanName}Manager/addRefrigeratorInOrgnizationList/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.refrigeratorInOrgnizationListList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("refrigeratorInOrgnizationListList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['refrigerator_in_orgnization_list']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addRefrigeratorInOrgnizationList/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/refrigeratorInOrgnizationListList;refrigeratorInOrgnizationListListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='refrigeratorInOrgnizationListListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['refrigerator_in_orgnization_list.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['refrigerator_in_orgnization_list.title']}</th>
</c:if>
<c:if test="${param.referName ne 'belongsTo'}">
	<th>${userContext.localeMap['refrigerator_in_orgnization_list.belongs_to']}</th>
</c:if>
<c:if test="${param.referName ne 'researchInstituteId'}">
	<th>${userContext.localeMap['refrigerator_in_orgnization_list.research_institute_id']}</th>
</c:if>
<c:if test="${param.referName ne 'researchGroupId'}">
	<th>${userContext.localeMap['refrigerator_in_orgnization_list.research_group_id']}</th>
</c:if>
<c:if test="${param.referName ne 'laboratoryId'}">
	<th>${userContext.localeMap['refrigerator_in_orgnization_list.laboratory_id']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.refrigeratorInOrgnizationListList}">
				<tr currentVersion='${item.version}' id="refrigeratorInOrgnizationList-${item.id}" ><td><a class="link-action-removed" href="./refrigeratorInOrgnizationListManager/loadRefrigeratorInOrgnizationListDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateRefrigeratorInOrgnizationList/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'belongsTo'}">	<td ><a href='./bettbioCompanyManager/loadBettbioCompanyDetail/${item.belongsTo.id}/'>${item.belongsTo.id}</a></td>
</c:if><c:if test="${param.referName ne 'researchInstituteId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='researchInstituteId' storedCellValue='${item.researchInstituteId}' prefix='${ownerBeanName}Manager/updateRefrigeratorInOrgnizationList/${result.id}/${item.id}/'>${item.researchInstituteId}</td>
</c:if><c:if test="${param.referName ne 'researchGroupId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='researchGroupId' storedCellValue='${item.researchGroupId}' prefix='${ownerBeanName}Manager/updateRefrigeratorInOrgnizationList/${result.id}/${item.id}/'>${item.researchGroupId}</td>
</c:if><c:if test="${param.referName ne 'laboratoryId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='laboratoryId' storedCellValue='${item.laboratoryId}' prefix='${ownerBeanName}Manager/updateRefrigeratorInOrgnizationList/${result.id}/${item.id}/'>${item.laboratoryId}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeRefrigeratorInOrgnizationList/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyRefrigeratorInOrgnizationListFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>










