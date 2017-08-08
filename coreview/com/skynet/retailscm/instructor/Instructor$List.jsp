<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="instructorList" value="${result.instructorList}"/>

<c:if test="${ empty instructorList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['instructor']}! 
		 <a href="./${ownerBeanName}Manager/addInstructor/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.instructorList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("instructorList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['instructor']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addInstructor/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'instructorList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/instructorList;instructorListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='instructorListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['instructor.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['instructor.title']}</th>
</c:if>
<c:if test="${param.referName ne 'familyName'}">
	<th>${userContext.localeMap['instructor.family_name']}</th>
</c:if>
<c:if test="${param.referName ne 'givenName'}">
	<th>${userContext.localeMap['instructor.given_name']}</th>
</c:if>
<c:if test="${param.referName ne 'cellPhone'}">
	<th>${userContext.localeMap['instructor.cell_phone']}</th>
</c:if>
<c:if test="${param.referName ne 'email'}">
	<th>${userContext.localeMap['instructor.email']}</th>
</c:if>
<c:if test="${param.referName ne 'company'}">
	<th>${userContext.localeMap['instructor.company']}</th>
</c:if>
<c:if test="${param.referName ne 'introduction'}">
	<th>${userContext.localeMap['instructor.introduction']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.instructorList}">
				<tr currentVersion='${item.version}' id="instructor-${item.id}" ><td><a class="link-action-removed" href="./instructorManager/loadInstructorDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'familyName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='familyName' storedCellValue='${item.familyName}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.familyName}</td>
</c:if><c:if test="${param.referName ne 'givenName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='givenName' storedCellValue='${item.givenName}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.givenName}</td>
</c:if><c:if test="${param.referName ne 'cellPhone'}">	<td contenteditable='true' class='edit-value'  propertyToChange='cellPhone' storedCellValue='${item.maskedCellPhone}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.maskedCellPhone}</td>
</c:if><c:if test="${param.referName ne 'email'}">	<td contenteditable='true' class='edit-value'  propertyToChange='email' storedCellValue='${item.email}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.email}</td>
</c:if><c:if test="${param.referName ne 'company'}">	<td ><a href='./retailStoreCountryCenterManager/loadRetailStoreCountryCenterDetail/${item.company.id}/'>${item.company.id}</a></td>
</c:if><c:if test="${param.referName ne 'introduction'}">	<td contenteditable='true' class='edit-value'  propertyToChange='introduction' storedCellValue='${item.introduction}' prefix='${ownerBeanName}Manager/updateInstructor/${result.id}/${item.id}/'>${item.introduction}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeInstructor/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyInstructorFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


