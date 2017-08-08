<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="adInPageListList" value="${result.adInPageListList}"/>

<c:if test="${ empty adInPageListList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['ad_in_page_list']}! 
		 <a href="./${ownerBeanName}Manager/addAdInPageList/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.adInPageListList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("adInPageListList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['ad_in_page_list']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addAdInPageList/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/adInPageListList;adInPageListListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='adInPageListListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['ad_in_page_list.id']}</th>
</c:if>
<c:if test="${param.referName ne 'sequenceNumber'}">
	<th>${userContext.localeMap['ad_in_page_list.sequence_number']}</th>
</c:if>
<c:if test="${param.referName ne 'playList'}">
	<th>${userContext.localeMap['ad_in_page_list.play_list']}</th>
</c:if>
<c:if test="${param.referName ne 'adPage'}">
	<th>${userContext.localeMap['ad_in_page_list.ad_page']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.adInPageListList}">
				<tr currentVersion='${item.version}' id="adInPageList-${item.id}" ><td><a class="link-action-removed" href="./adInPageListManager/loadAdInPageListDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'sequenceNumber'}">	<td contenteditable='true' class='edit-value'  propertyToChange='sequenceNumber' storedCellValue='${item.sequenceNumber}' prefix='${ownerBeanName}Manager/updateAdInPageList/${result.id}/${item.id}/'>${item.sequenceNumber}</td>
</c:if><c:if test="${param.referName ne 'playList'}">	<td ><a href='./playListManager/loadPlayListDetail/${item.playList.id}/'>${item.playList.id}</a></td>
</c:if><c:if test="${param.referName ne 'adPage'}">	<td ><a href='./marketingCampaignManager/loadMarketingCampaignDetail/${item.adPage.id}/'>${item.adPage.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeAdInPageList/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyAdInPageListFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


