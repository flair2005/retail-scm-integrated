<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="laboratoryResearchAreaList" value="${result.laboratoryResearchAreaList}"/>

<c:if test="${ empty laboratoryResearchAreaList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['laboratory_research_area']}! 
		 <a href="./${ownerBeanName}Manager/addLaboratoryResearchArea/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.laboratoryResearchAreaList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("laboratoryResearchAreaList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['laboratory_research_area']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addLaboratoryResearchArea/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/laboratoryResearchAreaList;laboratoryResearchAreaListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='laboratoryResearchAreaListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['laboratory_research_area.id']}</th>
</c:if>
<c:if test="${param.referName ne 'summary'}">
	<th>${userContext.localeMap['laboratory_research_area.summary']}</th>
</c:if>
<c:if test="${param.referName ne 'researchArea'}">
	<th>${userContext.localeMap['laboratory_research_area.research_area']}</th>
</c:if>
<c:if test="${param.referName ne 'laboratory'}">
	<th>${userContext.localeMap['laboratory_research_area.laboratory']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.laboratoryResearchAreaList}">
				<tr currentVersion='${item.version}' id="laboratoryResearchArea-${item.id}" ><td><a class="link-action-removed" href="./laboratoryResearchAreaManager/loadLaboratoryResearchAreaDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'summary'}">	<td contenteditable='true' class='edit-value'  propertyToChange='summary' storedCellValue='${item.summary}' prefix='${ownerBeanName}Manager/updateLaboratoryResearchArea/${result.id}/${item.id}/'>${item.summary}</td>
</c:if><c:if test="${param.referName ne 'researchArea'}">	<td ><a href='./researchAreaManager/loadResearchAreaDetail/${item.researchArea.id}/'>${item.researchArea.id}</a></td>
</c:if><c:if test="${param.referName ne 'laboratory'}">	<td ><a href='./laboratoryManager/loadLaboratoryDetail/${item.laboratory.id}/'>${item.laboratory.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeLaboratoryResearchArea/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyLaboratoryResearchAreaFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


