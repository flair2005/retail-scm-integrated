<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="topicLikeList" value="${result.topicLikeList}"/>

<c:if test="${ empty topicLikeList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['topic_like']}! 
		 <a href="./${ownerBeanName}Manager/addTopicLike/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.topicLikeList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("topicLikeList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['topic_like']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addTopicLike/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'topicLikeList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/topicLikeList;topicLikeListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='topicLikeListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['topic_like.id']}</th>
</c:if>
<c:if test="${param.referName ne 'likeDate'}">
	<th>${userContext.localeMap['topic_like.like_date']}</th>
</c:if>
<c:if test="${param.referName ne 'replier'}">
	<th>${userContext.localeMap['topic_like.replier']}</th>
</c:if>
<c:if test="${param.referName ne 'topic'}">
	<th>${userContext.localeMap['topic_like.topic']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.topicLikeList}">
				<tr currentVersion='${item.version}' id="topicLike-${item.id}" ><td><a class="link-action-removed" href="./topicLikeManager/loadTopicLikeDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'likeDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='likeDate' storedCellValue='${item.likeDate}' prefix='${ownerBeanName}Manager/updateTopicLike/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.likeDate}" /></td>
</c:if><c:if test="${param.referName ne 'replier'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.replier.id}/'>${item.replier.id}</a></td>
</c:if><c:if test="${param.referName ne 'topic'}">	<td ><a href='./topicManager/loadTopicDetail/${item.topic.id}/'>${item.topic.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeTopicLike/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyTopicLikeFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


