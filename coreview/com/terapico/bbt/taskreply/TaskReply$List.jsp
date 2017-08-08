<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="taskReplyList" value="${result.taskReplyList}"/>

<c:if test="${ empty taskReplyList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['task_reply']}! 
		 <a href="./${ownerBeanName}Manager/addTaskReply/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.taskReplyList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("taskReplyList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['task_reply']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTaskReply/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'taskReplyList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/taskReplyList;taskReplyListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='taskReplyListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['task_reply.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['task_reply.title']}</th>
</c:if>
<c:if test="${param.referName ne 'replyDate'}">
	<th>${userContext.localeMap['task_reply.reply_date']}</th>
</c:if>
<c:if test="${param.referName ne 'content'}">
	<th>${userContext.localeMap['task_reply.content']}</th>
</c:if>
<c:if test="${param.referName ne 'replier'}">
	<th>${userContext.localeMap['task_reply.replier']}</th>
</c:if>
<c:if test="${param.referName ne 'likeCount'}">
	<th>${userContext.localeMap['task_reply.like_count']}</th>
</c:if>
<c:if test="${param.referName ne 'task'}">
	<th>${userContext.localeMap['task_reply.task']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.taskReplyList}">
				<tr currentVersion='${item.version}' id="taskReply-${item.id}" ><td><a class="link-action-removed" href="./taskReplyManager/loadTaskReplyDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateTaskReply/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'replyDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='replyDate' storedCellValue='${item.replyDate}' prefix='${ownerBeanName}Manager/updateTaskReply/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.replyDate}" /></td>
</c:if><c:if test="${param.referName ne 'content'}">	<td contenteditable='true' class='edit-value'  propertyToChange='content' storedCellValue='${item.content}' prefix='${ownerBeanName}Manager/updateTaskReply/${result.id}/${item.id}/'>${item.content}</td>
</c:if><c:if test="${param.referName ne 'replier'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.replier.id}/'>${item.replier.id}</a></td>
</c:if><c:if test="${param.referName ne 'likeCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='likeCount' storedCellValue='${item.likeCount}' prefix='${ownerBeanName}Manager/updateTaskReply/${result.id}/${item.id}/'>${item.likeCount}</td>
</c:if><c:if test="${param.referName ne 'task'}">	<td ><a href='./taskManager/loadTaskDetail/${item.task.id}/'>${item.task.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeTaskReply/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTaskReplyFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


