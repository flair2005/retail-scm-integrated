<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="secUserList" value="${result.secUserList}"/>

<c:if test="${ empty secUserList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['sec_user']}! 
		 <a href="./${ownerBeanName}Manager/addSecUser/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.secUserList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("secUserList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['sec_user']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addSecUser/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/secUserList;secUserListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='secUserListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['sec_user.id']}</th>
</c:if>
<c:if test="${param.referName ne 'login'}">
	<th>${userContext.localeMap['sec_user.login']}</th>
</c:if>
<c:if test="${param.referName ne 'mobile'}">
	<th>${userContext.localeMap['sec_user.mobile']}</th>
</c:if>
<c:if test="${param.referName ne 'email'}">
	<th>${userContext.localeMap['sec_user.email']}</th>
</c:if>
<c:if test="${param.referName ne 'pwd'}">
	<th>${userContext.localeMap['sec_user.pwd']}</th>
</c:if>
<c:if test="${param.referName ne 'lastLogin'}">
	<th>${userContext.localeMap['sec_user.last_login']}</th>
</c:if>
<c:if test="${param.referName ne 'domain'}">
	<th>${userContext.localeMap['sec_user.domain']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.secUserList}">
				<tr currentVersion='${item.version}' id="secUser-${item.id}" ><td><a class="link-action-removed" href="./secUserManager/loadSecUserDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'login'}">	<td contenteditable='true' class='edit-value'  propertyToChange='login' storedCellValue='${item.login}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.login}</td>
</c:if><c:if test="${param.referName ne 'mobile'}">	<td contenteditable='true' class='edit-value'  propertyToChange='mobile' storedCellValue='${item.maskedMobile}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.maskedMobile}</td>
</c:if><c:if test="${param.referName ne 'email'}">	<td contenteditable='true' class='edit-value'  propertyToChange='email' storedCellValue='${item.email}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.email}</td>
</c:if><c:if test="${param.referName ne 'pwd'}">	<td contenteditable='true' class='edit-value'  propertyToChange='pwd' storedCellValue='${item.maskedPwd}' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'>${item.maskedPwd}</td>
</c:if><c:if test="${param.referName ne 'lastLogin'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastLogin' storedCellValue='<fmt:formatDate pattern="yyyy-MM-dd" value="${item.lastLogin}" />' prefix='${ownerBeanName}Manager/updateSecUser/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.lastLogin}" /></td>
</c:if><c:if test="${param.referName ne 'domain'}">	<td ><a href='./userDomainManager/loadUserDomainDetail/${item.domain.id}/'>${item.domain.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeSecUser/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copySecUserFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


