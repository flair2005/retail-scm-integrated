<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="userAppList" value="${result.userAppList}"/>

<c:if test="${ empty userAppList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['user_app']}! 
		 <a href="./${ownerBeanName}Manager/addUserApp/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.userAppList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("userAppList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['user_app']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addUserApp/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/userAppList;userAppListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='userAppListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['user_app.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['user_app.title']}</th>
</c:if>
<c:if test="${param.referName ne 'secUser'}">
	<th>${userContext.localeMap['user_app.sec_user']}</th>
</c:if>
<c:if test="${param.referName ne 'appIcon'}">
	<th>${userContext.localeMap['user_app.app_icon']}</th>
</c:if>
<c:if test="${param.referName ne 'fullAccess'}">
	<th>${userContext.localeMap['user_app.full_access']}</th>
</c:if>
<c:if test="${param.referName ne 'permission'}">
	<th>${userContext.localeMap['user_app.permission']}</th>
</c:if>
<c:if test="${param.referName ne 'objectType'}">
	<th>${userContext.localeMap['user_app.object_type']}</th>
</c:if>
<c:if test="${param.referName ne 'objectId'}">
	<th>${userContext.localeMap['user_app.object_id']}</th>
</c:if>
<c:if test="${param.referName ne 'location'}">
	<th>${userContext.localeMap['user_app.location']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.userAppList}">
				<tr currentVersion='${item.version}' id="userApp-${item.id}" ><td><a class="link-action-removed" href="./userAppManager/loadUserAppDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'secUser'}">	<td ><a href='./secUserManager/loadSecUserDetail/${item.secUser.id}/'>${item.secUser.id}</a></td>
</c:if><c:if test="${param.referName ne 'appIcon'}">	<td contenteditable='true' class='edit-value'  propertyToChange='appIcon' storedCellValue='${item.appIcon}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.appIcon}</td>
</c:if><c:if test="${param.referName ne 'fullAccess'}">	<td contenteditable='true' class='edit-value'  propertyToChange='fullAccess' storedCellValue='${item.fullAccess}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.fullAccess}</td>
</c:if><c:if test="${param.referName ne 'permission'}">	<td contenteditable='true' class='edit-value'  propertyToChange='permission' storedCellValue='${item.permission}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.permission}</td>
</c:if><c:if test="${param.referName ne 'objectType'}">	<td contenteditable='true' class='edit-value'  propertyToChange='objectType' storedCellValue='${item.objectType}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.objectType}</td>
</c:if><c:if test="${param.referName ne 'objectId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='objectId' storedCellValue='${item.objectId}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.objectId}</td>
</c:if><c:if test="${param.referName ne 'location'}">	<td contenteditable='true' class='edit-value'  propertyToChange='location' storedCellValue='${item.location}' prefix='${ownerBeanName}Manager/updateUserApp/${result.id}/${item.id}/'>${item.location}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeUserApp/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyUserAppFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


