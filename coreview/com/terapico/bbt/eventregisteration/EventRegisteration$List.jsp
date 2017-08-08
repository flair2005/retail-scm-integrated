<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="eventRegisterationList" value="${result.eventRegisterationList}"/>

<c:if test="${ empty eventRegisterationList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['event_registeration']}! 
		 <a href="./${ownerBeanName}Manager/addEventRegisteration/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.eventRegisterationList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("eventRegisterationList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['event_registeration']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addEventRegisteration/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/eventRegisterationList;eventRegisterationListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='eventRegisterationListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['event_registeration.id']}</th>
</c:if>
<c:if test="${param.referName ne 'registerDate'}">
	<th>${userContext.localeMap['event_registeration.register_date']}</th>
</c:if>
<c:if test="${param.referName ne 'comments'}">
	<th>${userContext.localeMap['event_registeration.comments']}</th>
</c:if>
<c:if test="${param.referName ne 'event'}">
	<th>${userContext.localeMap['event_registeration.event']}</th>
</c:if>
<c:if test="${param.referName ne 'participant'}">
	<th>${userContext.localeMap['event_registeration.participant']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.eventRegisterationList}">
				<tr currentVersion='${item.version}' id="eventRegisteration-${item.id}" ><td><a class="link-action-removed" href="./eventRegisterationManager/loadEventRegisterationDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'registerDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='registerDate' storedCellValue='<fmt:formatDate pattern="yyyy-MM-dd" value="${item.registerDate}" />' prefix='${ownerBeanName}Manager/updateEventRegisteration/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.registerDate}" /></td>
</c:if><c:if test="${param.referName ne 'comments'}">	<td contenteditable='true' class='edit-value'  propertyToChange='comments' storedCellValue='${item.comments}' prefix='${ownerBeanName}Manager/updateEventRegisteration/${result.id}/${item.id}/'>${item.comments}</td>
</c:if><c:if test="${param.referName ne 'event'}">	<td ><a href='./eventManager/loadEventDetail/${item.event.id}/'>${item.event.id}</a></td>
</c:if><c:if test="${param.referName ne 'participant'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.participant.id}/'>${item.participant.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeEventRegisteration/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyEventRegisterationFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


