<%@ page import='java.util.*,com.skynet.retailscm.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="stockCountIssueTrackList" value="${result.stockCountIssueTrackList}"/>

<c:if test="${ empty stockCountIssueTrackList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['stock_count_issue_track']}! 
		 <a href="./${ownerBeanName}Manager/addStockCountIssueTrack/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.stockCountIssueTrackList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("stockCountIssueTrackList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['stock_count_issue_track']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addStockCountIssueTrack/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'stockCountIssueTrackList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/stockCountIssueTrackList;stockCountIssueTrackListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='stockCountIssueTrackListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['stock_count_issue_track.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['stock_count_issue_track.title']}</th>
</c:if>
<c:if test="${param.referName ne 'countTime'}">
	<th>${userContext.localeMap['stock_count_issue_track.count_time']}</th>
</c:if>
<c:if test="${param.referName ne 'summary'}">
	<th>${userContext.localeMap['stock_count_issue_track.summary']}</th>
</c:if>
<c:if test="${param.referName ne 'stockCount'}">
	<th>${userContext.localeMap['stock_count_issue_track.stock_count']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.stockCountIssueTrackList}">
				<tr currentVersion='${item.version}' id="stockCountIssueTrack-${item.id}" ><td><a class="link-action-removed" href="./stockCountIssueTrackManager/loadStockCountIssueTrackDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateStockCountIssueTrack/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'countTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='countTime' storedCellValue='${item.countTime}' prefix='${ownerBeanName}Manager/updateStockCountIssueTrack/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.countTime}" /></td>
</c:if><c:if test="${param.referName ne 'summary'}">	<td contenteditable='true' class='edit-value'  propertyToChange='summary' storedCellValue='${item.summary}' prefix='${ownerBeanName}Manager/updateStockCountIssueTrack/${result.id}/${item.id}/'>${item.summary}</td>
</c:if><c:if test="${param.referName ne 'stockCount'}">	<td ><a href='./goodsShelfStockCountManager/loadGoodsShelfStockCountDetail/${item.stockCount.id}/'>${item.stockCount.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeStockCountIssueTrack/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyStockCountIssueTrackFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


