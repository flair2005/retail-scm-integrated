<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="communityUserList" value="${result.communityUserList}"/>

<c:if test="${ empty communityUserList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['community_user']}! 
		 <a href="./${ownerBeanName}Manager/addCommunityUser/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.communityUserList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("communityUserList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['community_user']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addCommunityUser/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'communityUserList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/communityUserList;communityUserListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='communityUserListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['community_user.id']}</th>
</c:if>
<c:if test="${param.referName ne 'mobile'}">
	<th>${userContext.localeMap['community_user.mobile']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['community_user.name']}</th>
</c:if>
<c:if test="${param.referName ne 'nickName'}">
	<th>${userContext.localeMap['community_user.nick_name']}</th>
</c:if>
<c:if test="${param.referName ne 'gender'}">
	<th>${userContext.localeMap['community_user.gender']}</th>
</c:if>
<c:if test="${param.referName ne 'userType'}">
	<th>${userContext.localeMap['community_user.user_type']}</th>
</c:if>
<c:if test="${param.referName ne 'avatar'}">
	<th>${userContext.localeMap['community_user.avatar']}</th>
</c:if>
<c:if test="${param.referName ne 'birthday'}">
	<th>${userContext.localeMap['community_user.birthday']}</th>
</c:if>
<c:if test="${param.referName ne 'taskCount'}">
	<th>${userContext.localeMap['community_user.task_count']}</th>
</c:if>
<c:if test="${param.referName ne 'topicCount'}">
	<th>${userContext.localeMap['community_user.topic_count']}</th>
</c:if>
<c:if test="${param.referName ne 'experiencePoint'}">
	<th>${userContext.localeMap['community_user.experience_point']}</th>
</c:if>
<c:if test="${param.referName ne 'bonusPoint'}">
	<th>${userContext.localeMap['community_user.bonus_point']}</th>
</c:if>
<c:if test="${param.referName ne 'fansCount'}">
	<th>${userContext.localeMap['community_user.fans_count']}</th>
</c:if>
<c:if test="${param.referName ne 'city'}">
	<th>${userContext.localeMap['community_user.city']}</th>
</c:if>
<c:if test="${param.referName ne 'status'}">
	<th>${userContext.localeMap['community_user.status']}</th>
</c:if>
<c:if test="${param.referName ne 'community'}">
	<th>${userContext.localeMap['community_user.community']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.communityUserList}">
				<tr currentVersion='${item.version}' id="communityUser-${item.id}" ><td><a class="link-action-removed" href="./communityUserManager/loadCommunityUserDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'mobile'}">	<td contenteditable='true' class='edit-value'  propertyToChange='mobile' storedCellValue='${item.maskedMobile}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.maskedMobile}</td>
</c:if><c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'nickName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='nickName' storedCellValue='${item.nickName}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.nickName}</td>
</c:if><c:if test="${param.referName ne 'gender'}">	<td contenteditable='true' class='edit-value'  propertyToChange='gender' storedCellValue='${item.gender}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.gender}</td>
</c:if><c:if test="${param.referName ne 'userType'}">	<td contenteditable='true' class='edit-value'  propertyToChange='userType' storedCellValue='${item.userType}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.userType}</td>
</c:if><c:if test="${param.referName ne 'avatar'}">	<td contenteditable='true' class='edit-value'  propertyToChange='avatar' storedCellValue='${item.avatar}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.avatar}</td>
</c:if><c:if test="${param.referName ne 'birthday'}">	<td contenteditable='true' class='edit-value'  propertyToChange='birthday' storedCellValue='${item.birthday}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.birthday}" /></td>
</c:if><c:if test="${param.referName ne 'taskCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='taskCount' storedCellValue='${item.taskCount}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.taskCount}</td>
</c:if><c:if test="${param.referName ne 'topicCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='topicCount' storedCellValue='${item.topicCount}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.topicCount}</td>
</c:if><c:if test="${param.referName ne 'experiencePoint'}">	<td contenteditable='true' class='edit-value'  propertyToChange='experiencePoint' storedCellValue='${item.experiencePoint}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.experiencePoint}</td>
</c:if><c:if test="${param.referName ne 'bonusPoint'}">	<td contenteditable='true' class='edit-value'  propertyToChange='bonusPoint' storedCellValue='${item.bonusPoint}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.bonusPoint}</td>
</c:if><c:if test="${param.referName ne 'fansCount'}">	<td contenteditable='true' class='edit-value'  propertyToChange='fansCount' storedCellValue='${item.fansCount}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.fansCount}</td>
</c:if><c:if test="${param.referName ne 'city'}">	<td contenteditable='true' class='edit-value'  propertyToChange='city' storedCellValue='${item.city}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.city}</td>
</c:if><c:if test="${param.referName ne 'status'}">	<td contenteditable='true' class='edit-value'  propertyToChange='status' storedCellValue='${item.status}' prefix='${ownerBeanName}Manager/updateCommunityUser/${result.id}/${item.id}/'>${item.status}</td>
</c:if><c:if test="${param.referName ne 'community'}">	<td ><a href='./communityManager/loadCommunityDetail/${item.community.id}/'>${item.community.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeCommunityUser/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyCommunityUserFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


