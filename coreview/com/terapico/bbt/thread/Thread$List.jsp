<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="threadList" value="${result.threadList}"/>

<c:if test="${ empty threadList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['thread']}! 
		 <a href="./${ownerBeanName}Manager/addThread/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.threadList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("threadList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['thread']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addThread/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'threadList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/threadList;threadListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='threadListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['thread.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['thread.title']}</th>
</c:if>
<c:if test="${param.referName ne 'publishDate'}">
	<th>${userContext.localeMap['thread.publish_date']}</th>
</c:if>
<c:if test="${param.referName ne 'registrationStartDate'}">
	<th>${userContext.localeMap['thread.registration_start_date']}</th>
</c:if>
<c:if test="${param.referName ne 'registrationStopDate'}">
	<th>${userContext.localeMap['thread.registration_stop_date']}</th>
</c:if>
<c:if test="${param.referName ne 'threadLocation'}">
	<th>${userContext.localeMap['thread.thread_location']}</th>
</c:if>
<c:if test="${param.referName ne 'city'}">
	<th>${userContext.localeMap['thread.city']}</th>
</c:if>
<c:if test="${param.referName ne 'threadType'}">
	<th>${userContext.localeMap['thread.thread_type']}</th>
</c:if>
<c:if test="${param.referName ne 'community'}">
	<th>${userContext.localeMap['thread.community']}</th>
</c:if>
<c:if test="${param.referName ne 'creator'}">
	<th>${userContext.localeMap['thread.creator']}</th>
</c:if>
<c:if test="${param.referName ne 'homePage'}">
	<th>${userContext.localeMap['thread.home_page']}</th>
</c:if>
<c:if test="${param.referName ne 'groupPage'}">
	<th>${userContext.localeMap['thread.group_page']}</th>
</c:if>
<c:if test="${param.referName ne 'coverImagePath'}">
	<th>${userContext.localeMap['thread.cover_image_path']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath1'}">
	<th>${userContext.localeMap['thread.image_path1']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath2'}">
	<th>${userContext.localeMap['thread.image_path2']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath3'}">
	<th>${userContext.localeMap['thread.image_path3']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath4'}">
	<th>${userContext.localeMap['thread.image_path4']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath5'}">
	<th>${userContext.localeMap['thread.image_path5']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath6'}">
	<th>${userContext.localeMap['thread.image_path6']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath7'}">
	<th>${userContext.localeMap['thread.image_path7']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath8'}">
	<th>${userContext.localeMap['thread.image_path8']}</th>
</c:if>
<c:if test="${param.referName ne 'imagePath9'}">
	<th>${userContext.localeMap['thread.image_path9']}</th>
</c:if>
<c:if test="${param.referName ne 'readCount'}">
	<th>${userContext.localeMap['thread.read_count']}</th>
</c:if>
<c:if test="${param.referName ne 'replyCount'}">
	<th>${userContext.localeMap['thread.reply_count']}</th>
</c:if>
<c:if test="${param.referName ne 'favorCount'}">
	<th>${userContext.localeMap['thread.favor_count']}</th>
</c:if>
<c:if test="${param.referName ne 'likeCount'}">
	<th>${userContext.localeMap['thread.like_count']}</th>
</c:if>
<c:if test="${param.referName ne 'content'}">
	<th>${userContext.localeMap['thread.content']}</th>
</c:if>
<c:if test="${param.referName ne 'approval'}">
	<th>${userContext.localeMap['thread.approval']}</th>
</c:if>
<c:if test="${param.referName ne 'publishing'}">
	<th>${userContext.localeMap['thread.publishing']}</th>
</c:if>
<c:if test="${param.referName ne 'currentStatus'}">
	<th>${userContext.localeMap['thread.current_status']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.threadList}">
				<tr currentVersion='${item.version}' id="thread-${item.id}" ><td><a class="link-action-removed" href="./threadManager/loadThreadDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'publishDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='publishDate' storedCellValue='${item.publishDate}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.publishDate}" /></td>
</c:if><c:if test="${param.referName ne 'registrationStartDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='registrationStartDate' storedCellValue='${item.registrationStartDate}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.registrationStartDate}" /></td>
</c:if><c:if test="${param.referName ne 'registrationStopDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='registrationStopDate' storedCellValue='${item.registrationStopDate}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.registrationStopDate}" /></td>
</c:if><c:if test="${param.referName ne 'threadLocation'}">	<td contenteditable='true' class='edit-value'  propertyToChange='threadLocation' storedCellValue='${item.threadLocation}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.threadLocation}</td>
</c:if><c:if test="${param.referName ne 'city'}">	<td contenteditable='true' class='edit-value'  propertyToChange='city' storedCellValue='${item.city}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.city}</td>
</c:if><c:if test="${param.referName ne 'threadType'}">	<td contenteditable='true' class='edit-value'  propertyToChange='threadType' storedCellValue='${item.threadType}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.threadType}</td>
</c:if><c:if test="${param.referName ne 'community'}">	<td ><a href='./communityManager/loadCommunityDetail/${item.community.id}/'>${item.community.id}</a></td>
</c:if><c:if test="${param.referName ne 'creator'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.creator.id}/'>${item.creator.id}</a></td>
</c:if><c:if test="${param.referName ne 'homePage'}">	<td ><a href='./homePageManager/loadHomePageDetail/${item.homePage.id}/'>${item.homePage.id}</a></td>
</c:if><c:if test="${param.referName ne 'groupPage'}">	<td ><a href='./groupPageManager/loadGroupPageDetail/${item.groupPage.id}/'>${item.groupPage.id}</a></td>
</c:if><c:if test="${param.referName ne 'coverImagePath'}">	<td contenteditable='true' class='edit-value'  propertyToChange='coverImagePath' storedCellValue='${item.coverImagePath}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.coverImagePath}</td>
</c:if><c:if test="${param.referName ne 'imagePath1'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath1' storedCellValue='${item.imagePath1}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.imagePath1}</td>
</c:if><c:if test="${param.referName ne 'imagePath2'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath2' storedCellValue='${item.imagePath2}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.imagePath2}</td>
</c:if><c:if test="${param.referName ne 'imagePath3'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath3' storedCellValue='${item.imagePath3}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.imagePath3}</td>
</c:if><c:if test="${param.referName ne 'imagePath4'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath4' storedCellValue='${item.imagePath4}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.imagePath4}</td>
</c:if><c:if test="${param.referName ne 'imagePath5'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath5' storedCellValue='${item.imagePath5}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.imagePath5}</td>
</c:if><c:if test="${param.referName ne 'imagePath6'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath6' storedCellValue='${item.imagePath6}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.imagePath6}</td>
</c:if><c:if test="${param.referName ne 'imagePath7'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath7' storedCellValue='${item.imagePath7}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.imagePath7}</td>
</c:if><c:if test="${param.referName ne 'imagePath8'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath8' storedCellValue='${item.imagePath8}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.imagePath8}</td>
</c:if><c:if test="${param.referName ne 'imagePath9'}">	<td contenteditable='true' class='edit-value'  propertyToChange='imagePath9' storedCellValue='${item.imagePath9}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.imagePath9}</td>
</c:if><c:if test="${param.referName ne 'readCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='readCount' storedCellValue='${item.readCount}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.readCount}</td>
</c:if><c:if test="${param.referName ne 'replyCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='replyCount' storedCellValue='${item.replyCount}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.replyCount}</td>
</c:if><c:if test="${param.referName ne 'favorCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='favorCount' storedCellValue='${item.favorCount}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.favorCount}</td>
</c:if><c:if test="${param.referName ne 'likeCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='likeCount' storedCellValue='${item.likeCount}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.likeCount}</td>
</c:if><c:if test="${param.referName ne 'content'}">	<td contenteditable='true' class='edit-value'  propertyToChange='content' storedCellValue='${item.content}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.content}</td>
</c:if><c:if test="${param.referName ne 'approval'}">	<td ><a href='./threadApprovalManager/loadThreadApprovalDetail/${item.approval.id}/'>${item.approval.id}</a></td>
</c:if><c:if test="${param.referName ne 'publishing'}">	<td ><a href='./threadPublishingManager/loadThreadPublishingDetail/${item.publishing.id}/'>${item.publishing.id}</a></td>
</c:if><c:if test="${param.referName ne 'currentStatus'}">	<td contenteditable='true' class='edit-value'  propertyToChange='currentStatus' storedCellValue='${item.currentStatus}' prefix='${ownerBeanName}Manager/updateThread/${result.id}/${item.id}/'>${item.currentStatus}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeThread/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyThreadFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


