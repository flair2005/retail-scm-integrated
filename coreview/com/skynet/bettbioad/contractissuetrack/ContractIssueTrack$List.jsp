<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="contractIssueTrackList" value="${result.contractIssueTrackList}"/>

<c:if test="${ empty contractIssueTrackList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['contract_issue_track']}! 
		 <a href="./${ownerBeanName}Manager/addContractIssueTrack/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.contractIssueTrackList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("contractIssueTrackList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['contract_issue_track']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addContractIssueTrack/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/contractIssueTrackList;contractIssueTrackListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='contractIssueTrackListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['contract_issue_track.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['contract_issue_track.title']}</th>
</c:if>
<c:if test="${param.referName ne 'countTime'}">
	<th>${userContext.localeMap['contract_issue_track.count_time']}</th>
</c:if>
<c:if test="${param.referName ne 'summary'}">
	<th>${userContext.localeMap['contract_issue_track.summary']}</th>
</c:if>
<c:if test="${param.referName ne 'contract'}">
	<th>${userContext.localeMap['contract_issue_track.contract']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.contractIssueTrackList}">
				<tr currentVersion='${item.version}' id="contractIssueTrack-${item.id}" ><td><a class="link-action-removed" href="./contractIssueTrackManager/loadContractIssueTrackDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateContractIssueTrack/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'countTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='countTime' storedCellValue='<fmt:formatDate pattern="yyyy-MM-dd" value="${item.countTime}" />' prefix='${ownerBeanName}Manager/updateContractIssueTrack/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.countTime}" /></td>
</c:if><c:if test="${param.referName ne 'summary'}">	<td contenteditable='true' class='edit-value'  propertyToChange='summary' storedCellValue='${item.summary}' prefix='${ownerBeanName}Manager/updateContractIssueTrack/${result.id}/${item.id}/'>${item.summary}</td>
</c:if><c:if test="${param.referName ne 'contract'}">	<td ><a href='./contractManager/loadContractDetail/${item.contract.id}/'>${item.contract.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeContractIssueTrack/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyContractIssueTrackFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


