<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="taskLikeList" value="${result.taskLikeList}"/>

<c:if test="${ empty taskLikeList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['task_like']}! 
		 <a href="./${ownerBeanName}Manager/addTaskLike/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.taskLikeList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("taskLikeList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['task_like']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTaskLike/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'taskLikeList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/taskLikeList;taskLikeListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='taskLikeListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['task_like.id']}</th>
</c:if>
<c:if test="${param.referName ne 'likeDate'}">
	<th>${userContext.localeMap['task_like.like_date']}</th>
</c:if>
<c:if test="${param.referName ne 'replier'}">
	<th>${userContext.localeMap['task_like.replier']}</th>
</c:if>
<c:if test="${param.referName ne 'task'}">
	<th>${userContext.localeMap['task_like.task']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.taskLikeList}">
				<tr currentVersion='${item.version}' id="taskLike-${item.id}" ><td><a class="link-action-removed" href="./taskLikeManager/loadTaskLikeDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'likeDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='likeDate' storedCellValue='${item.likeDate}' prefix='${ownerBeanName}Manager/updateTaskLike/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.likeDate}" /></td>
</c:if><c:if test="${param.referName ne 'replier'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.replier.id}/'>${item.replier.id}</a></td>
</c:if><c:if test="${param.referName ne 'task'}">	<td ><a href='./taskManager/loadTaskDetail/${item.task.id}/'>${item.task.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeTaskLike/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTaskLikeFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


