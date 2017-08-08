<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="threadRegistrationList" value="${result.threadRegistrationList}"/>

<c:if test="${ empty threadRegistrationList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['thread_registration']}! 
		 <a href="./${ownerBeanName}Manager/addThreadRegistration/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.threadRegistrationList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("threadRegistrationList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['thread_registration']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addThreadRegistration/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'threadRegistrationList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/threadRegistrationList;threadRegistrationListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='threadRegistrationListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['thread_registration.id']}</th>
</c:if>
<c:if test="${param.referName ne 'registerDate'}">
	<th>${userContext.localeMap['thread_registration.register_date']}</th>
</c:if>
<c:if test="${param.referName ne 'comments'}">
	<th>${userContext.localeMap['thread_registration.comments']}</th>
</c:if>
<c:if test="${param.referName ne 'thread'}">
	<th>${userContext.localeMap['thread_registration.thread']}</th>
</c:if>
<c:if test="${param.referName ne 'participant'}">
	<th>${userContext.localeMap['thread_registration.participant']}</th>
</c:if>
<c:if test="${param.referName ne 'participantNickname'}">
	<th>${userContext.localeMap['thread_registration.participant_nickname']}</th>
</c:if>
<c:if test="${param.referName ne 'participantAvarta'}">
	<th>${userContext.localeMap['thread_registration.participant_avarta']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.threadRegistrationList}">
				<tr currentVersion='${item.version}' id="threadRegistration-${item.id}" ><td><a class="link-action-removed" href="./threadRegistrationManager/loadThreadRegistrationDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'registerDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='registerDate' storedCellValue='${item.registerDate}' prefix='${ownerBeanName}Manager/updateThreadRegistration/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.registerDate}" /></td>
</c:if><c:if test="${param.referName ne 'comments'}">	<td contenteditable='true' class='edit-value'  propertyToChange='comments' storedCellValue='${item.comments}' prefix='${ownerBeanName}Manager/updateThreadRegistration/${result.id}/${item.id}/'>${item.comments}</td>
</c:if><c:if test="${param.referName ne 'thread'}">	<td ><a href='./threadManager/loadThreadDetail/${item.thread.id}/'>${item.thread.id}</a></td>
</c:if><c:if test="${param.referName ne 'participant'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.participant.id}/'>${item.participant.id}</a></td>
</c:if><c:if test="${param.referName ne 'participantNickname'}">	<td contenteditable='true' class='edit-value'  propertyToChange='participantNickname' storedCellValue='${item.participantNickname}' prefix='${ownerBeanName}Manager/updateThreadRegistration/${result.id}/${item.id}/'>${item.participantNickname}</td>
</c:if><c:if test="${param.referName ne 'participantAvarta'}">	<td contenteditable='true' class='edit-value'  propertyToChange='participantAvarta' storedCellValue='${item.participantAvarta}' prefix='${ownerBeanName}Manager/updateThreadRegistration/${result.id}/${item.id}/'>${item.participantAvarta}</td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeThreadRegistration/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyThreadRegistrationFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


