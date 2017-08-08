<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="employeeCompanyTrainingList" value="${result.employeeCompanyTrainingList}"/>

<c:if test="${ empty employeeCompanyTrainingList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['employee_company_training']}! 
		 <a href="./${ownerBeanName}Manager/addEmployeeCompanyTraining/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.employeeCompanyTrainingList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("employeeCompanyTrainingList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['employee_company_training']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEmployeeCompanyTraining/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'employeeCompanyTrainingList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/employeeCompanyTrainingList;employeeCompanyTrainingListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='employeeCompanyTrainingListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['employee_company_training.id']}</th>
</c:if>
<c:if test="${param.referName ne 'employee'}">
	<th>${userContext.localeMap['employee_company_training.employee']}</th>
</c:if>
<c:if test="${param.referName ne 'training'}">
	<th>${userContext.localeMap['employee_company_training.training']}</th>
</c:if>
<c:if test="${param.referName ne 'scoring'}">
	<th>${userContext.localeMap['employee_company_training.scoring']}</th>
</c:if>
<c:if test="${param.referName ne 'currentStatus'}">
	<th>${userContext.localeMap['employee_company_training.current_status']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.employeeCompanyTrainingList}">
				<tr currentVersion='${item.version}' id="employeeCompanyTraining-${item.id}" ><td><a class="link-action-removed" href="./employeeCompanyTrainingManager/loadEmployeeCompanyTrainingDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'employee'}">	<td ><a href='./employeeManager/loadEmployeeDetail/${item.employee.id}/'>${item.employee.id}</a></td>
</c:if><c:if test="${param.referName ne 'training'}">	<td ><a href='./companyTrainingManager/loadCompanyTrainingDetail/${item.training.id}/'>${item.training.id}</a></td>
</c:if><c:if test="${param.referName ne 'scoring'}">	<td ><a href='./scoringManager/loadScoringDetail/${item.scoring.id}/'>${item.scoring.id}</a></td>
</c:if><c:if test="${param.referName ne 'currentStatus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='currentStatus' storedCellValue='${item.currentStatus}' prefix='${ownerBeanName}Manager/updateEmployeeCompanyTraining/${result.id}/${item.id}/'>${item.currentStatus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeEmployeeCompanyTraining/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEmployeeCompanyTrainingFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


