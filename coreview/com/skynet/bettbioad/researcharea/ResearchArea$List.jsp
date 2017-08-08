<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="researchAreaList" value="${result.researchAreaList}"/>

<c:if test="${ empty researchAreaList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['research_area']}! 
		 <a href="./${ownerBeanName}Manager/addResearchArea/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.researchAreaList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("researchAreaList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['research_area']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addResearchArea/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/researchAreaList;researchAreaListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='researchAreaListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['research_area.id']}</th>
</c:if>
<c:if test="${param.referName ne 'summary'}">
	<th>${userContext.localeMap['research_area.summary']}</th>
</c:if>
<c:if test="${param.referName ne 'keyswords'}">
	<th>${userContext.localeMap['research_area.keyswords']}</th>
</c:if>
<c:if test="${param.referName ne 'belongsTo'}">
	<th>${userContext.localeMap['research_area.belongs_to']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.researchAreaList}">
				<tr currentVersion='${item.version}' id="researchArea-${item.id}" ><td><a class="link-action-removed" href="./researchAreaManager/loadResearchAreaDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'summary'}">	<td contenteditable='true' class='edit-value'  propertyToChange='summary' storedCellValue='${item.summary}' prefix='${ownerBeanName}Manager/updateResearchArea/${result.id}/${item.id}/'>${item.summary}</td>
</c:if><c:if test="${param.referName ne 'keyswords'}">	<td contenteditable='true' class='edit-value'  propertyToChange='keyswords' storedCellValue='${item.keyswords}' prefix='${ownerBeanName}Manager/updateResearchArea/${result.id}/${item.id}/'>${item.keyswords}</td>
</c:if><c:if test="${param.referName ne 'belongsTo'}">	<td ><a href='./bettbioCompanyManager/loadBettbioCompanyDetail/${item.belongsTo.id}/'>${item.belongsTo.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeResearchArea/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyResearchAreaFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


