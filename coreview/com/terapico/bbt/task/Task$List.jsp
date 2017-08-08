<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="taskList" value="${result.taskList}"/>

<c:if test="${ empty taskList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['task']}! 
		 <a href="./${ownerBeanName}Manager/addTask/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.taskList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("taskList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['task']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTask/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'taskList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/taskList;taskListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='taskListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['task.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['task.title']}</th>
</c:if>
<c:if test="${param.referName ne 'publishDate'}">
	<th>${userContext.localeMap['task.publish_date']}</th>
</c:if>
<c:if test="${param.referName ne 'content'}">
	<th>${userContext.localeMap['task.content']}</th>
</c:if>
<c:if test="${param.referName ne 'creator'}">
	<th>${userContext.localeMap['task.creator']}</th>
</c:if>
<c:if test="${param.referName ne 'community'}">
	<th>${userContext.localeMap['task.community']}</th>
</c:if>
<c:if test="${param.referName ne 'homePage'}">
	<th>${userContext.localeMap['task.home_page']}</th>
</c:if>
<c:if test="${param.referName ne 'taskPage'}">
	<th>${userContext.localeMap['task.task_page']}</th>
</c:if>
<c:if test="${param.referName ne 'coverImagePath'}">
	<th>${userContext.localeMap['task.cover_image_path']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath1'}">
	<th>${userContext.localeMap['task.image_path1']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath2'}">
	<th>${userContext.localeMap['task.image_path2']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath3'}">
	<th>${userContext.localeMap['task.image_path3']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath4'}">
	<th>${userContext.localeMap['task.image_path4']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath5'}">
	<th>${userContext.localeMap['task.image_path5']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath6'}">
	<th>${userContext.localeMap['task.image_path6']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath7'}">
	<th>${userContext.localeMap['task.image_path7']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath8'}">
	<th>${userContext.localeMap['task.image_path8']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath9'}">
	<th>${userContext.localeMap['task.image_path9']}</th>
</c:if>
<c:if test="${param.referName ne 'readCount'}">
	<th>${userContext.localeMap['task.read_count']}</th>
</c:if>
<c:if test="${param.referName ne 'replyCount'}">
	<th>${userContext.localeMap['task.reply_count']}</th>
</c:if>
<c:if test="${param.referName ne 'favorCount'}">
	<th>${userContext.localeMap['task.favor_count']}</th>
</c:if>
<c:if test="${param.referName ne 'likeCount'}">
	<th>${userContext.localeMap['task.like_count']}</th>
</c:if>
<c:if test="${param.referName ne 'creatorBonus'}">
	<th>${userContext.localeMap['task.creator_bonus']}</th>
</c:if>
<c:if test="${param.referName ne 'additionalBonus'}">
	<th>${userContext.localeMap['task.additional_bonus']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.taskList}">
				<tr currentVersion='${item.version}' id="task-${item.id}" ><td><a class="link-action-removed" href="./taskManager/loadTaskDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'publishDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='publishDate' storedCellValue='${item.publishDate}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.publishDate}" /></td>
</c:if><c:if test="${param.referName ne 'content'}">	<td contenteditable='true' class='edit-value'  propertyToChange='content' storedCellValue='${item.content}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.content}</td>
</c:if><c:if test="${param.referName ne 'creator'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.creator.id}/'>${item.creator.id}</a></td>
</c:if><c:if test="${param.referName ne 'community'}">	<td ><a href='./communityManager/loadCommunityDetail/${item.community.id}/'>${item.community.id}</a></td>
</c:if><c:if test="${param.referName ne 'homePage'}">	<td ><a href='./homePageManager/loadHomePageDetail/${item.homePage.id}/'>${item.homePage.id}</a></td>
</c:if><c:if test="${param.referName ne 'taskPage'}">	<td ><a href='./taskPageManager/loadTaskPageDetail/${item.taskPage.id}/'>${item.taskPage.id}</a></td>
</c:if><c:if test="${param.referName ne 'coverImagePath'}">	<td contenteditable='true' class='edit-value'  propertyToChange='coverImagePath' storedCellValue='${item.coverImagePath}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.coverImagePath}</td>
</c:if><c:if test="${param.referName ne 'imagePath1'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath1' storedCellValue='${item.imagePath1}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.imagePath1}</td>
</c:if><c:if test="${param.referName ne 'imagePath2'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath2' storedCellValue='${item.imagePath2}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.imagePath2}</td>
</c:if><c:if test="${param.referName ne 'imagePath3'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath3' storedCellValue='${item.imagePath3}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.imagePath3}</td>
</c:if><c:if test="${param.referName ne 'imagePath4'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath4' storedCellValue='${item.imagePath4}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.imagePath4}</td>
</c:if><c:if test="${param.referName ne 'imagePath5'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath5' storedCellValue='${item.imagePath5}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.imagePath5}</td>
</c:if><c:if test="${param.referName ne 'imagePath6'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath6' storedCellValue='${item.imagePath6}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.imagePath6}</td>
</c:if><c:if test="${param.referName ne 'imagePath7'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath7' storedCellValue='${item.imagePath7}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.imagePath7}</td>
</c:if><c:if test="${param.referName ne 'imagePath8'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath8' storedCellValue='${item.imagePath8}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.imagePath8}</td>
</c:if><c:if test="${param.referName ne 'imagePath9'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath9' storedCellValue='${item.imagePath9}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.imagePath9}</td>
</c:if><c:if test="${param.referName ne 'readCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='readCount' storedCellValue='${item.readCount}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.readCount}</td>
</c:if><c:if test="${param.referName ne 'replyCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='replyCount' storedCellValue='${item.replyCount}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.replyCount}</td>
</c:if><c:if test="${param.referName ne 'favorCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='favorCount' storedCellValue='${item.favorCount}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.favorCount}</td>
</c:if><c:if test="${param.referName ne 'likeCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='likeCount' storedCellValue='${item.likeCount}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.likeCount}</td>
</c:if><c:if test="${param.referName ne 'creatorBonus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='creatorBonus' storedCellValue='${item.creatorBonus}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.creatorBonus}</td>
</c:if><c:if test="${param.referName ne 'additionalBonus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='additionalBonus' storedCellValue='${item.additionalBonus}' prefix='${ownerBeanName}Manager/updateTask/${result.id}/${item.id}/'>${item.additionalBonus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeTask/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTaskFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


