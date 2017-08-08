<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="messageList" value="${result.messageList}"/>

<c:if test="${ empty messageList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		
		
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['message']}!
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.messageList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("messageList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['message']}(${totalCount})
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/messageList;messageListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='messageListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<th>${userContext.localeMap['message.id']}</th><th>${userContext.localeMap['message.title']}</th><th>${userContext.localeMap['message.content']}</th><th>${userContext.localeMap['message.message_date']}</th><th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.messageList}">
				<tr currentVersion='${item.version}' id="message-${item.id}" ><td><a class="link-action-removed" href="/naf/messageManager/loadMessageDetail/${item.id}/"> ${item.id}</a></td>
<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateMessage/${result.id}/${item.id}/'>${item.title}</td>
<td contenteditable='true' class='edit-value'  propertyToChange='content' storedCellValue='${item.content}' prefix='${ownerBeanName}Manager/updateMessage/${result.id}/${item.id}/'>${item.content}</td>
<td contenteditable='true' class='edit-value'  propertyToChange='messageDate' storedCellValue='<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.messageDate}" />' prefix='${ownerBeanName}Manager/updateMessage/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.messageDate}" /></td>

				<td>
				
				
				<a href='#${ownerBeanName}Manager/removeMessage/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyMessageFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>
				
				
				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


