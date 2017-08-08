<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="loginHistoryList" value="${result.loginHistoryList}"/>

<c:if test="${ empty loginHistoryList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['login_history']}! 
		 <a href="./${ownerBeanName}Manager/addLoginHistory/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.loginHistoryList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("loginHistoryList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['login_history']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addLoginHistory/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'loginHistoryList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/loginHistoryList;loginHistoryListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='loginHistoryListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['login_history.id']}</th>
</c:if>
<c:if test="${param.referName ne 'loginTime'}">
	<th>${userContext.localeMap['login_history.login_time']}</th>
</c:if>
<c:if test="${param.referName ne 'fromIp'}">
	<th>${userContext.localeMap['login_history.from_ip']}</th>
</c:if>
<c:if test="${param.referName ne 'description'}">
	<th>${userContext.localeMap['login_history.description']}</th>
</c:if>
<c:if test="${param.referName ne 'secUser'}">
	<th>${userContext.localeMap['login_history.sec_user']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.loginHistoryList}">
				<tr currentVersion='${item.version}' id="loginHistory-${item.id}" ><td><a class="link-action-removed" href="./loginHistoryManager/loadLoginHistoryDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'loginTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='loginTime' storedCellValue='${item.loginTime}' prefix='${ownerBeanName}Manager/updateLoginHistory/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.loginTime}" /></td>
</c:if><c:if test="${param.referName ne 'fromIp'}">	<td contenteditable='true' class='edit-value'  propertyToChange='fromIp' storedCellValue='${item.fromIp}' prefix='${ownerBeanName}Manager/updateLoginHistory/${result.id}/${item.id}/'>${item.fromIp}</td>
</c:if><c:if test="${param.referName ne 'description'}">	<td contenteditable='true' class='edit-value'  propertyToChange='description' storedCellValue='${item.description}' prefix='${ownerBeanName}Manager/updateLoginHistory/${result.id}/${item.id}/'>${item.description}</td>
</c:if><c:if test="${param.referName ne 'secUser'}">	<td ><a href='./secUserManager/loadSecUserDetail/${item.secUser.id}/'>${item.secUser.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeLoginHistory/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyLoginHistoryFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>










