<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="accountingDocumentList" value="${result.accountingDocumentList}"/>

<c:if test="${ empty accountingDocumentList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['accounting_document']}! 
		 <a href="./${ownerBeanName}Manager/addAccountingDocument/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.accountingDocumentList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("accountingDocumentList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['accounting_document']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addAccountingDocument/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'accountingDocumentList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/accountingDocumentList;accountingDocumentListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='accountingDocumentListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['accounting_document.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['accounting_document.name']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingDocumentDate'}">
	<th>${userContext.localeMap['accounting_document.accounting_document_date']}</th>
</c:if>
<c:if test="${param.referName ne 'accountingPeriod'}">
	<th>${userContext.localeMap['accounting_document.accounting_period']}</th>
</c:if>
<c:if test="${param.referName ne 'documentType'}">
	<th>${userContext.localeMap['accounting_document.document_type']}</th>
</c:if>
<c:if test="${param.referName ne 'creation'}">
	<th>${userContext.localeMap['accounting_document.creation']}</th>
</c:if>
<c:if test="${param.referName ne 'confirmation'}">
	<th>${userContext.localeMap['accounting_document.confirmation']}</th>
</c:if>
<c:if test="${param.referName ne 'auditing'}">
	<th>${userContext.localeMap['accounting_document.auditing']}</th>
</c:if>
<c:if test="${param.referName ne 'posting'}">
	<th>${userContext.localeMap['accounting_document.posting']}</th>
</c:if>
<c:if test="${param.referName ne 'currentStatus'}">
	<th>${userContext.localeMap['accounting_document.current_status']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.accountingDocumentList}">
				<tr currentVersion='${item.version}' id="accountingDocument-${item.id}" ><td><a class="link-action-removed" href="./accountingDocumentManager/loadAccountingDocumentDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateAccountingDocument/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'accountingDocumentDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='accountingDocumentDate' storedCellValue='${item.accountingDocumentDate}' prefix='${ownerBeanName}Manager/updateAccountingDocument/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.accountingDocumentDate}" /></td>
</c:if><c:if test="${param.referName ne 'accountingPeriod'}">	<td ><a href='./accountingPeriodManager/loadAccountingPeriodDetail/${item.accountingPeriod.id}/'>${item.accountingPeriod.id}</a></td>
</c:if><c:if test="${param.referName ne 'documentType'}">	<td ><a href='./accountingDocumentTypeManager/loadAccountingDocumentTypeDetail/${item.documentType.id}/'>${item.documentType.id}</a></td>
</c:if><c:if test="${param.referName ne 'creation'}">	<td ><a href='./accountingDocumentCreationManager/loadAccountingDocumentCreationDetail/${item.creation.id}/'>${item.creation.id}</a></td>
</c:if><c:if test="${param.referName ne 'confirmation'}">	<td ><a href='./accountingDocumentConfirmationManager/loadAccountingDocumentConfirmationDetail/${item.confirmation.id}/'>${item.confirmation.id}</a></td>
</c:if><c:if test="${param.referName ne 'auditing'}">	<td ><a href='./accountingDocumentAuditingManager/loadAccountingDocumentAuditingDetail/${item.auditing.id}/'>${item.auditing.id}</a></td>
</c:if><c:if test="${param.referName ne 'posting'}">	<td ><a href='./accountingDocumentPostingManager/loadAccountingDocumentPostingDetail/${item.posting.id}/'>${item.posting.id}</a></td>
</c:if><c:if test="${param.referName ne 'currentStatus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='currentStatus' storedCellValue='${item.currentStatus}' prefix='${ownerBeanName}Manager/updateAccountingDocument/${result.id}/${item.id}/'>${item.currentStatus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeAccountingDocument/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyAccountingDocumentFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


