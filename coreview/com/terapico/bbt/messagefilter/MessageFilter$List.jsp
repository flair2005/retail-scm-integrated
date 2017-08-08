<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="messageFilterList" value="${result.messageFilterList}"/>

<c:if test="${ empty messageFilterList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['message_filter']}! 
		 <a href="./${ownerBeanName}Manager/addMessageFilter/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.messageFilterList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("messageFilterList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['message_filter']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addMessageFilter/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'messageFilterList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/messageFilterList;messageFilterListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='messageFilterListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['message_filter.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['message_filter.name']}</th>
</c:if>
<c:if test="${param.referName ne 'messageCount'}">
	<th>${userContext.localeMap['message_filter.message_count']}</th>
</c:if>
<c:if test="${param.referName ne 'filterKey'}">
	<th>${userContext.localeMap['message_filter.filter_key']}</th>
</c:if>
<c:if test="${param.referName ne 'linkUrl'}">
	<th>${userContext.localeMap['message_filter.link_url']}</th>
</c:if>
<c:if test="${param.referName ne 'user'}">
	<th>${userContext.localeMap['message_filter.user']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.messageFilterList}">
				<tr currentVersion='${item.version}' id="messageFilter-${item.id}" ><td><a class="link-action-removed" href="./messageFilterManager/loadMessageFilterDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateMessageFilter/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'messageCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='messageCount' storedCellValue='${item.messageCount}' prefix='${ownerBeanName}Manager/updateMessageFilter/${result.id}/${item.id}/'>${item.messageCount}</td>
</c:if><c:if test="${param.referName ne 'filterKey'}">	<td contenteditable='true' class='edit-value'  propertyToChange='filterKey' storedCellValue='${item.filterKey}' prefix='${ownerBeanName}Manager/updateMessageFilter/${result.id}/${item.id}/'>${item.filterKey}</td>
</c:if><c:if test="${param.referName ne 'linkUrl'}">	<td contenteditable='true' class='edit-value'  propertyToChange='linkUrl' storedCellValue='${item.linkUrl}' prefix='${ownerBeanName}Manager/updateMessageFilter/${result.id}/${item.id}/'>${item.linkUrl}</td>
</c:if><c:if test="${param.referName ne 'user'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.user.id}/'>${item.user.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeMessageFilter/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyMessageFilterFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


