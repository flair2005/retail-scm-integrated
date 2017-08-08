<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="employeeInterviewList" value="${result.employeeInterviewList}"/>

<c:if test="${ empty employeeInterviewList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['employee_interview']}! 
		 <a href="./${ownerBeanName}Manager/addEmployeeInterview/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.employeeInterviewList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("employeeInterviewList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['employee_interview']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEmployeeInterview/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'employeeInterviewList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/employeeInterviewList;employeeInterviewListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='employeeInterviewListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['employee_interview.id']}</th>
</c:if>
<c:if test="${param.referName ne 'employee'}">
	<th>${userContext.localeMap['employee_interview.employee']}</th>
</c:if>
<c:if test="${param.referName ne 'interviewType'}">
	<th>${userContext.localeMap['employee_interview.interview_type']}</th>
</c:if>
<c:if test="${param.referName ne 'remark'}">
	<th>${userContext.localeMap['employee_interview.remark']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.employeeInterviewList}">
				<tr currentVersion='${item.version}' id="employeeInterview-${item.id}" ><td><a class="link-action-removed" href="./employeeInterviewManager/loadEmployeeInterviewDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'employee'}">	<td ><a href='./employeeManager/loadEmployeeDetail/${item.employee.id}/'>${item.employee.id}</a></td>
</c:if><c:if test="${param.referName ne 'interviewType'}">	<td ><a href='./interviewTypeManager/loadInterviewTypeDetail/${item.interviewType.id}/'>${item.interviewType.id}</a></td>
</c:if><c:if test="${param.referName ne 'remark'}">	<td contenteditable='true' class='edit-value'  propertyToChange='remark' storedCellValue='${item.remark}' prefix='${ownerBeanName}Manager/updateEmployeeInterview/${result.id}/${item.id}/'>${item.remark}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeEmployeeInterview/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEmployeeInterviewFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


