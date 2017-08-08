<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="encyclopediaItemList" value="${result.encyclopediaItemList}"/>

<c:if test="${ empty encyclopediaItemList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['encyclopedia_item']}! 
		 <a href="./${ownerBeanName}Manager/addEncyclopediaItem/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.encyclopediaItemList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("encyclopediaItemList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['encyclopedia_item']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEncyclopediaItem/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'encyclopediaItemList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/encyclopediaItemList;encyclopediaItemListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='encyclopediaItemListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['encyclopedia_item.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['encyclopedia_item.title']}</th>
</c:if>
<c:if test="${param.referName ne 'publishDate'}">
	<th>${userContext.localeMap['encyclopedia_item.publish_date']}</th>
</c:if>
<c:if test="${param.referName ne 'content'}">
	<th>${userContext.localeMap['encyclopedia_item.content']}</th>
</c:if>
<c:if test="${param.referName ne 'community'}">
	<th>${userContext.localeMap['encyclopedia_item.community']}</th>
</c:if>
<c:if test="${param.referName ne 'homePage'}">
	<th>${userContext.localeMap['encyclopedia_item.home_page']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.encyclopediaItemList}">
				<tr currentVersion='${item.version}' id="encyclopediaItem-${item.id}" ><td><a class="link-action-removed" href="./encyclopediaItemManager/loadEncyclopediaItemDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateEncyclopediaItem/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'publishDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='publishDate' storedCellValue='${item.publishDate}' prefix='${ownerBeanName}Manager/updateEncyclopediaItem/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.publishDate}" /></td>
</c:if><c:if test="${param.referName ne 'content'}">	<td contenteditable='true' class='edit-value'  propertyToChange='content' storedCellValue='${item.content}' prefix='${ownerBeanName}Manager/updateEncyclopediaItem/${result.id}/${item.id}/'>${item.content}</td>
</c:if><c:if test="${param.referName ne 'community'}">	<td ><a href='./communityManager/loadCommunityDetail/${item.community.id}/'>${item.community.id}</a></td>
</c:if><c:if test="${param.referName ne 'homePage'}">	<td ><a href='./homePageManager/loadHomePageDetail/${item.homePage.id}/'>${item.homePage.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeEncyclopediaItem/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEncyclopediaItemFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


