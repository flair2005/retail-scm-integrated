<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="contractList" value="${result.contractList}"/>

<c:if test="${ empty contractList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['contract']}! 
		 <a href="./${ownerBeanName}Manager/addContract/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.contractList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("contractList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['contract']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addContract/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/contractList;contractListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='contractListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['contract.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['contract.title']}</th>
</c:if>
<c:if test="${param.referName ne 'summary'}">
	<th>${userContext.localeMap['contract.summary']}</th>
</c:if>
<c:if test="${param.referName ne 'company'}">
	<th>${userContext.localeMap['contract.company']}</th>
</c:if>
<c:if test="${param.referName ne 'attachment'}">
	<th>${userContext.localeMap['contract.attachment']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.contractList}">
				<tr currentVersion='${item.version}' id="contract-${item.id}" ><td><a class="link-action-removed" href="./contractManager/loadContractDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateContract/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'summary'}">	<td contenteditable='true' class='edit-value'  propertyToChange='summary' storedCellValue='${item.summary}' prefix='${ownerBeanName}Manager/updateContract/${result.id}/${item.id}/'>${item.summary}</td>
</c:if><c:if test="${param.referName ne 'company'}">	<td ><a href='./customerCompanyManager/loadCustomerCompanyDetail/${item.company.id}/'>${item.company.id}</a></td>
</c:if><c:if test="${param.referName ne 'attachment'}">	<td contenteditable='true' class='edit-value'  propertyToChange='attachment' storedCellValue='${item.attachment}' prefix='${ownerBeanName}Manager/updateContract/${result.id}/${item.id}/'>${item.attachment}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeContract/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyContractFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


