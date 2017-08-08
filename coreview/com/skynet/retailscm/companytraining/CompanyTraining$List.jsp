<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="companyTrainingList" value="${result.companyTrainingList}"/>

<c:if test="${ empty companyTrainingList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['company_training']}! 
		 <a href="./${ownerBeanName}Manager/addCompanyTraining/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.companyTrainingList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("companyTrainingList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['company_training']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addCompanyTraining/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'companyTrainingList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/companyTrainingList;companyTrainingListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='companyTrainingListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['company_training.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['company_training.title']}</th>
</c:if>
<c:if test="${param.referName ne 'company'}">
	<th>${userContext.localeMap['company_training.company']}</th>
</c:if>
<c:if test="${param.referName ne 'instructor'}">
	<th>${userContext.localeMap['company_training.instructor']}</th>
</c:if>
<c:if test="${param.referName ne 'trainingCourseType'}">
	<th>${userContext.localeMap['company_training.training_course_type']}</th>
</c:if>
<c:if test="${param.referName ne 'timeStart'}">
	<th>${userContext.localeMap['company_training.time_start']}</th>
</c:if>
<c:if test="${param.referName ne 'durationHours'}">
	<th>${userContext.localeMap['company_training.duration_hours']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.companyTrainingList}">
				<tr currentVersion='${item.version}' id="companyTraining-${item.id}" ><td><a class="link-action-removed" href="./companyTrainingManager/loadCompanyTrainingDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateCompanyTraining/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'company'}">	<td ><a href='./retailStoreCountryCenterManager/loadRetailStoreCountryCenterDetail/${item.company.id}/'>${item.company.id}</a></td>
</c:if><c:if test="${param.referName ne 'instructor'}">	<td ><a href='./instructorManager/loadInstructorDetail/${item.instructor.id}/'>${item.instructor.id}</a></td>
</c:if><c:if test="${param.referName ne 'trainingCourseType'}">	<td ><a href='./trainingCourseTypeManager/loadTrainingCourseTypeDetail/${item.trainingCourseType.id}/'>${item.trainingCourseType.id}</a></td>
</c:if><c:if test="${param.referName ne 'timeStart'}">	<td contenteditable='true' class='edit-value'  propertyToChange='timeStart' storedCellValue='${item.timeStart}' prefix='${ownerBeanName}Manager/updateCompanyTraining/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.timeStart}" /></td>
</c:if><c:if test="${param.referName ne 'durationHours'}">	<td contenteditable='true' class='edit-value'  propertyToChange='durationHours' storedCellValue='${item.durationHours}' prefix='${ownerBeanName}Manager/updateCompanyTraining/${result.id}/${item.id}/'>${item.durationHours}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeCompanyTraining/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyCompanyTrainingFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


