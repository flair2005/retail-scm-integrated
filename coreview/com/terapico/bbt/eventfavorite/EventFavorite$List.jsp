<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="eventFavoriteList" value="${result.eventFavoriteList}"/>

<c:if test="${ empty eventFavoriteList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['event_favorite']}! 
		 <a href="./${ownerBeanName}Manager/addEventFavorite/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.eventFavoriteList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("eventFavoriteList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['event_favorite']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEventFavorite/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'eventFavoriteList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/eventFavoriteList;eventFavoriteListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='eventFavoriteListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['event_favorite.id']}</th>
</c:if>
<c:if test="${param.referName ne 'favoriteDate'}">
	<th>${userContext.localeMap['event_favorite.favorite_date']}</th>
</c:if>
<c:if test="${param.referName ne 'favoriteUser'}">
	<th>${userContext.localeMap['event_favorite.favorite_user']}</th>
</c:if>
<c:if test="${param.referName ne 'task'}">
	<th>${userContext.localeMap['event_favorite.task']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.eventFavoriteList}">
				<tr currentVersion='${item.version}' id="eventFavorite-${item.id}" ><td><a class="link-action-removed" href="./eventFavoriteManager/loadEventFavoriteDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'favoriteDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='favoriteDate' storedCellValue='${item.favoriteDate}' prefix='${ownerBeanName}Manager/updateEventFavorite/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.favoriteDate}" /></td>
</c:if><c:if test="${param.referName ne 'favoriteUser'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.favoriteUser.id}/'>${item.favoriteUser.id}</a></td>
</c:if><c:if test="${param.referName ne 'task'}">	<td ><a href='./eventManager/loadEventDetail/${item.task.id}/'>${item.task.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeEventFavorite/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEventFavoriteFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


