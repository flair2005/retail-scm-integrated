<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="taskFilterList" value="${result.taskFilterList}"/>

<c:if test="${ empty taskFilterList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['task_filter']}! 
		 <a href="./${ownerBeanName}Manager/addTaskFilter/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.taskFilterList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("taskFilterList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['task_filter']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTaskFilter/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'taskFilterList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/taskFilterList;taskFilterListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='taskFilterListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['task_filter.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['task_filter.name']}</th>
</c:if>
<c:if test="${param.referName ne 'filterKey'}">
	<th>${userContext.localeMap['task_filter.filter_key']}</th>
</c:if>
<c:if test="${param.referName ne 'linkUrl'}">
	<th>${userContext.localeMap['task_filter.link_url']}</th>
</c:if>
<c:if test="${param.referName ne 'taskPage'}">
	<th>${userContext.localeMap['task_filter.task_page']}</th>
</c:if>
<c:if test="${param.referName ne 'homePage'}">
	<th>${userContext.localeMap['task_filter.home_page']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.taskFilterList}">
				<tr currentVersion='${item.version}' id="taskFilter-${item.id}" ><td><a class="link-action-removed" href="./taskFilterManager/loadTaskFilterDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateTaskFilter/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'filterKey'}">	<td contenteditable='true' class='edit-value'  propertyToChange='filterKey' storedCellValue='${item.filterKey}' prefix='${ownerBeanName}Manager/updateTaskFilter/${result.id}/${item.id}/'>${item.filterKey}</td>
</c:if><c:if test="${param.referName ne 'linkUrl'}">	<td contenteditable='true' class='edit-value'  propertyToChange='linkUrl' storedCellValue='${item.linkUrl}' prefix='${ownerBeanName}Manager/updateTaskFilter/${result.id}/${item.id}/'>${item.linkUrl}</td>
</c:if><c:if test="${param.referName ne 'taskPage'}">	<td ><a href='./taskPageManager/loadTaskPageDetail/${item.taskPage.id}/'>${item.taskPage.id}</a></td>
</c:if><c:if test="${param.referName ne 'homePage'}">	<td ><a href='./homePageManager/loadHomePageDetail/${item.homePage.id}/'>${item.homePage.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeTaskFilter/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTaskFilterFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


