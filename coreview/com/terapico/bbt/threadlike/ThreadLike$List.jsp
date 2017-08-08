<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="threadLikeList" value="${result.threadLikeList}"/>

<c:if test="${ empty threadLikeList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['thread_like']}! 
		 <a href="./${ownerBeanName}Manager/addThreadLike/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.threadLikeList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("threadLikeList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['thread_like']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addThreadLike/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'threadLikeList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/threadLikeList;threadLikeListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='threadLikeListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['thread_like.id']}</th>
</c:if>
<c:if test="${param.referName ne 'likeDate'}">
	<th>${userContext.localeMap['thread_like.like_date']}</th>
</c:if>
<c:if test="${param.referName ne 'replier'}">
	<th>${userContext.localeMap['thread_like.replier']}</th>
</c:if>
<c:if test="${param.referName ne 'thread'}">
	<th>${userContext.localeMap['thread_like.thread']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.threadLikeList}">
				<tr currentVersion='${item.version}' id="threadLike-${item.id}" ><td><a class="link-action-removed" href="./threadLikeManager/loadThreadLikeDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'likeDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='likeDate' storedCellValue='${item.likeDate}' prefix='${ownerBeanName}Manager/updateThreadLike/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.likeDate}" /></td>
</c:if><c:if test="${param.referName ne 'replier'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.replier.id}/'>${item.replier.id}</a></td>
</c:if><c:if test="${param.referName ne 'thread'}">	<td ><a href='./threadManager/loadThreadDetail/${item.thread.id}/'>${item.thread.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeThreadLike/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyThreadLikeFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


