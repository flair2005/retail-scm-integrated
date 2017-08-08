<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="accountingSubjectList" value="${result.accountingSubjectList}"/>

<c:if test="${ empty accountingSubjectList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['accounting_subject']}! 
		 <a href="./${ownerBeanName}Manager/addAccountingSubject/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.accountingSubjectList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("accountingSubjectList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['accounting_subject']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addAccountingSubject/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'accountingSubjectList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/accountingSubjectList;accountingSubjectListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='accountingSubjectListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['accounting_subject.id']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingSubjectCode'}">
	<th>${userContext.localeMap['accounting_subject.accounting_subject_code']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingSubjectName'}">
	<th>${userContext.localeMap['accounting_subject.accounting_subject_name']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingSubjectClassCode'}">
	<th>${userContext.localeMap['accounting_subject.accounting_subject_class_code']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingSubjectClassName'}">
	<th>${userContext.localeMap['accounting_subject.accounting_subject_class_name']}</th>
</c:if>
<c:if test="${param.referName ne 'accountSet'}">
	<th>${userContext.localeMap['accounting_subject.account_set']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.accountingSubjectList}">
				<tr currentVersion='${item.version}' id="accountingSubject-${item.id}" ><td><a class="link-action-removed" href="./accountingSubjectManager/loadAccountingSubjectDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'accountingSubjectCode'}">	<td contenteditable='true' class='edit-value'  propertyToChange='accountingSubjectCode' storedCellValue='${item.accountingSubjectCode}' prefix='${ownerBeanName}Manager/updateAccountingSubject/${result.id}/${item.id}/'>${item.accountingSubjectCode}</td>
</c:if><c:if test="${param.referName ne 'accountingSubjectName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='accountingSubjectName' storedCellValue='${item.accountingSubjectName}' prefix='${ownerBeanName}Manager/updateAccountingSubject/${result.id}/${item.id}/'>${item.accountingSubjectName}</td>
</c:if><c:if test="${param.referName ne 'accountingSubjectClassCode'}">	<td contenteditable='true' class='edit-value'  propertyToChange='accountingSubjectClassCode' storedCellValue='${item.accountingSubjectClassCode}' prefix='${ownerBeanName}Manager/updateAccountingSubject/${result.id}/${item.id}/'>${item.accountingSubjectClassCode}</td>
</c:if><c:if test="${param.referName ne 'accountingSubjectClassName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='accountingSubjectClassName' storedCellValue='${item.accountingSubjectClassName}' prefix='${ownerBeanName}Manager/updateAccountingSubject/${result.id}/${item.id}/'>${item.accountingSubjectClassName}</td>
</c:if><c:if test="${param.referName ne 'accountSet'}">	<td ><a href='./accountSetManager/loadAccountSetDetail/${item.accountSet.id}/'>${item.accountSet.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeAccountingSubject/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyAccountingSubjectFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


