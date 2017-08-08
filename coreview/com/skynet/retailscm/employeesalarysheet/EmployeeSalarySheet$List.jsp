<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="employeeSalarySheetList" value="${result.employeeSalarySheetList}"/>

<c:if test="${ empty employeeSalarySheetList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['employee_salary_sheet']}! 
		 <a href="./${ownerBeanName}Manager/addEmployeeSalarySheet/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.employeeSalarySheetList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("employeeSalarySheetList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['employee_salary_sheet']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEmployeeSalarySheet/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'employeeSalarySheetList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/employeeSalarySheetList;employeeSalarySheetListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='employeeSalarySheetListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['employee_salary_sheet.id']}</th>
</c:if>
<c:if test="${param.referName ne 'employee'}">
	<th>${userContext.localeMap['employee_salary_sheet.employee']}</th>
</c:if>
<c:if test="${param.referName ne 'currentSalaryGrade'}">
	<th>${userContext.localeMap['employee_salary_sheet.current_salary_grade']}</th>
</c:if>
<c:if test="${param.referName ne 'baseSalary'}">
	<th>${userContext.localeMap['employee_salary_sheet.base_salary']}</th>
</c:if>
<c:if test="${param.referName ne 'bonus'}">
	<th>${userContext.localeMap['employee_salary_sheet.bonus']}</th>
</c:if>
<c:if test="${param.referName ne 'reward'}">
	<th>${userContext.localeMap['employee_salary_sheet.reward']}</th>
</c:if>
<c:if test="${param.referName ne 'personalTax'}">
	<th>${userContext.localeMap['employee_salary_sheet.personal_tax']}</th>
</c:if>
<c:if test="${param.referName ne 'socialSecurity'}">
	<th>${userContext.localeMap['employee_salary_sheet.social_security']}</th>
</c:if>
<c:if test="${param.referName ne 'housingFound'}">
	<th>${userContext.localeMap['employee_salary_sheet.housing_found']}</th>
</c:if>
<c:if test="${param.referName ne 'jobInsurance'}">
	<th>${userContext.localeMap['employee_salary_sheet.job_insurance']}</th>
</c:if>
<c:if test="${param.referName ne 'payingOff'}">
	<th>${userContext.localeMap['employee_salary_sheet.paying_off']}</th>
</c:if>
<c:if test="${param.referName ne 'currentStatus'}">
	<th>${userContext.localeMap['employee_salary_sheet.current_status']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.employeeSalarySheetList}">
				<tr currentVersion='${item.version}' id="employeeSalarySheet-${item.id}" ><td><a class="link-action-removed" href="./employeeSalarySheetManager/loadEmployeeSalarySheetDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'employee'}">	<td ><a href='./employeeManager/loadEmployeeDetail/${item.employee.id}/'>${item.employee.id}</a></td>
</c:if><c:if test="${param.referName ne 'currentSalaryGrade'}">	<td ><a href='./salaryGradeManager/loadSalaryGradeDetail/${item.currentSalaryGrade.id}/'>${item.currentSalaryGrade.id}</a></td>
</c:if><c:if test="${param.referName ne 'baseSalary'}">	<td contenteditable='true' class='edit-value'  propertyToChange='baseSalary' storedCellValue='${item.baseSalary}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.baseSalary}" /></td>
</c:if><c:if test="${param.referName ne 'bonus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='bonus' storedCellValue='${item.bonus}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.bonus}" /></td>
</c:if><c:if test="${param.referName ne 'reward'}">	<td contenteditable='true' class='edit-value'  propertyToChange='reward' storedCellValue='${item.reward}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.reward}" /></td>
</c:if><c:if test="${param.referName ne 'personalTax'}">	<td contenteditable='true' class='edit-value'  propertyToChange='personalTax' storedCellValue='${item.personalTax}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.personalTax}" /></td>
</c:if><c:if test="${param.referName ne 'socialSecurity'}">	<td contenteditable='true' class='edit-value'  propertyToChange='socialSecurity' storedCellValue='${item.socialSecurity}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.socialSecurity}" /></td>
</c:if><c:if test="${param.referName ne 'housingFound'}">	<td contenteditable='true' class='edit-value'  propertyToChange='housingFound' storedCellValue='${item.housingFound}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.housingFound}" /></td>
</c:if><c:if test="${param.referName ne 'jobInsurance'}">	<td contenteditable='true' class='edit-value'  propertyToChange='jobInsurance' storedCellValue='${item.jobInsurance}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'><fmt:formatNumber type="currency"  value="${item.jobInsurance}" /></td>
</c:if><c:if test="${param.referName ne 'payingOff'}">	<td ><a href='./payingOffManager/loadPayingOffDetail/${item.payingOff.id}/'>${item.payingOff.id}</a></td>
</c:if><c:if test="${param.referName ne 'currentStatus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='currentStatus' storedCellValue='${item.currentStatus}' prefix='${ownerBeanName}Manager/updateEmployeeSalarySheet/${result.id}/${item.id}/'>${item.currentStatus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeEmployeeSalarySheet/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEmployeeSalarySheetFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


