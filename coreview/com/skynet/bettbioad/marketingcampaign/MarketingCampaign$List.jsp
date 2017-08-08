<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="marketingCampaignList" value="${result.marketingCampaignList}"/>

<c:if test="${ empty marketingCampaignList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['marketing_campaign']}! 
		 <a href="./${ownerBeanName}Manager/addMarketingCampaign/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.marketingCampaignList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("marketingCampaignList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['marketing_campaign']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addMarketingCampaign/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/marketingCampaignList;marketingCampaignListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='marketingCampaignListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['marketing_campaign.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['marketing_campaign.title']}</th>
</c:if>
<c:if test="${param.referName ne 'playDuration'}">
	<th>${userContext.localeMap['marketing_campaign.play_duration']}</th>
</c:if>
<c:if test="${param.referName ne 'image'}">
	<th>${userContext.localeMap['marketing_campaign.image']}</th>
</c:if>
<c:if test="${param.referName ne 'pageLink'}">
	<th>${userContext.localeMap['marketing_campaign.page_link']}</th>
</c:if>
<c:if test="${param.referName ne 'belongsTo'}">
	<th>${userContext.localeMap['marketing_campaign.belongs_to']}</th>
</c:if>
<c:if test="${param.referName ne 'company'}">
	<th>${userContext.localeMap['marketing_campaign.company']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.marketingCampaignList}">
				<tr currentVersion='${item.version}' id="marketingCampaign-${item.id}" ><td><a class="link-action-removed" href="./marketingCampaignManager/loadMarketingCampaignDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateMarketingCampaign/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'playDuration'}">	<td contenteditable='true' class='edit-value'  propertyToChange='playDuration' storedCellValue='${item.playDuration}' prefix='${ownerBeanName}Manager/updateMarketingCampaign/${result.id}/${item.id}/'>${item.playDuration}</td>
</c:if><c:if test="${param.referName ne 'image'}">	<td contenteditable='true' class='edit-value'  propertyToChange='image' storedCellValue='${item.image}' prefix='${ownerBeanName}Manager/updateMarketingCampaign/${result.id}/${item.id}/'>${item.image}</td>
</c:if><c:if test="${param.referName ne 'pageLink'}">	<td contenteditable='true' class='edit-value'  propertyToChange='pageLink' storedCellValue='${item.pageLink}' prefix='${ownerBeanName}Manager/updateMarketingCampaign/${result.id}/${item.id}/'>${item.pageLink}</td>
</c:if><c:if test="${param.referName ne 'belongsTo'}">	<td ><a href='./contentRepositoryManager/loadContentRepositoryDetail/${item.belongsTo.id}/'>${item.belongsTo.id}</a></td>
</c:if><c:if test="${param.referName ne 'company'}">	<td ><a href='./customerCompanyManager/loadCustomerCompanyDetail/${item.company.id}/'>${item.company.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeMarketingCampaign/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyMarketingCampaignFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


