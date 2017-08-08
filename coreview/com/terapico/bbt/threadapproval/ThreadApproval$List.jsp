<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="threadApprovalList" value="${result.threadApprovalList}"/>

<c:if test="${ empty threadApprovalList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['thread_approval']}! 
		 <a href="./${ownerBeanName}Manager/addThreadApproval/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.threadApprovalList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("threadApprovalList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['thread_approval']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addThreadApproval/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'threadApprovalList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/threadApprovalList;threadApprovalListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='threadApprovalListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['thread_approval.id']}</th>
</c:if>
<c:if test="${param.referName ne 'who'}">
	<th>${userContext.localeMap['thread_approval.who']}</th>
</c:if>
<c:if test="${param.referName ne 'confirmDate'}">
	<th>${userContext.localeMap['thread_approval.confirm_date']}</th>
</c:if>
<c:if test="${param.referName ne 'comment'}">
	<th>${userContext.localeMap['thread_approval.comment']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.threadApprovalList}">
				<tr currentVersion='${item.version}' id="threadApproval-${item.id}" ><td><a class="link-action-removed" href="./threadApprovalManager/loadThreadApprovalDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'who'}">	<td contenteditable='true' class='edit-value'  propertyToChange='who' storedCellValue='${item.who}' prefix='${ownerBeanName}Manager/updateThreadApproval/${result.id}/${item.id}/'>${item.who}</td>
</c:if><c:if test="${param.referName ne 'confirmDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='confirmDate' storedCellValue='${item.confirmDate}' prefix='${ownerBeanName}Manager/updateThreadApproval/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.confirmDate}" /></td>
</c:if><c:if test="${param.referName ne 'comment'}">	<td contenteditable='true' class='edit-value'  propertyToChange='comment' storedCellValue='${item.comment}' prefix='${ownerBeanName}Manager/updateThreadApproval/${result.id}/${item.id}/'>${item.comment}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeThreadApproval/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyThreadApprovalFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


