<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="taskFavoriteList" value="${result.taskFavoriteList}"/>

<c:if test="${ empty taskFavoriteList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['task_favorite']}! 
		 <a href="./${ownerBeanName}Manager/addTaskFavorite/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.taskFavoriteList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("taskFavoriteList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['task_favorite']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTaskFavorite/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'taskFavoriteList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/taskFavoriteList;taskFavoriteListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='taskFavoriteListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['task_favorite.id']}</th>
</c:if>
<c:if test="${param.referName ne 'favoriteDate'}">
	<th>${userContext.localeMap['task_favorite.favorite_date']}</th>
</c:if>
<c:if test="${param.referName ne 'favoriteUser'}">
	<th>${userContext.localeMap['task_favorite.favorite_user']}</th>
</c:if>
<c:if test="${param.referName ne 'task'}">
	<th>${userContext.localeMap['task_favorite.task']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.taskFavoriteList}">
				<tr currentVersion='${item.version}' id="taskFavorite-${item.id}" ><td><a class="link-action-removed" href="./taskFavoriteManager/loadTaskFavoriteDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'favoriteDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='favoriteDate' storedCellValue='${item.favoriteDate}' prefix='${ownerBeanName}Manager/updateTaskFavorite/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.favoriteDate}" /></td>
</c:if><c:if test="${param.referName ne 'favoriteUser'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.favoriteUser.id}/'>${item.favoriteUser.id}</a></td>
</c:if><c:if test="${param.referName ne 'task'}">	<td ><a href='./taskManager/loadTaskDetail/${item.task.id}/'>${item.task.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeTaskFavorite/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTaskFavoriteFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


