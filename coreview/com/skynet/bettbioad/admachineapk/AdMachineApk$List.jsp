<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="adMachineApkList" value="${result.adMachineApkList}"/>

<c:if test="${ empty adMachineApkList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['ad_machine_apk']}! 
		 <a href="./${ownerBeanName}Manager/addAdMachineApk/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.adMachineApkList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("adMachineApkList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['ad_machine_apk']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addAdMachineApk/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/adMachineApkList;adMachineApkListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='adMachineApkListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['ad_machine_apk.id']}</th>
</c:if>
<c:if test="${param.referName ne 'releaseBuild'}">
	<th>${userContext.localeMap['ad_machine_apk.release_build']}</th>
</c:if>
<c:if test="${param.referName ne 'releaseDate'}">
	<th>${userContext.localeMap['ad_machine_apk.release_date']}</th>
</c:if>
<c:if test="${param.referName ne 'downloadLink'}">
	<th>${userContext.localeMap['ad_machine_apk.download_link']}</th>
</c:if>
<c:if test="${param.referName ne 'belongsTo'}">
	<th>${userContext.localeMap['ad_machine_apk.belongs_to']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.adMachineApkList}">
				<tr currentVersion='${item.version}' id="adMachineApk-${item.id}" ><td><a class="link-action-removed" href="./adMachineApkManager/loadAdMachineApkDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'releaseBuild'}">	<td contenteditable='true' class='edit-value'  propertyToChange='releaseBuild' storedCellValue='${item.releaseBuild}' prefix='${ownerBeanName}Manager/updateAdMachineApk/${result.id}/${item.id}/'>${item.releaseBuild}</td>
</c:if><c:if test="${param.referName ne 'releaseDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='releaseDate' storedCellValue='<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.releaseDate}" />' prefix='${ownerBeanName}Manager/updateAdMachineApk/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.releaseDate}" /></td>
</c:if><c:if test="${param.referName ne 'downloadLink'}">	<td contenteditable='true' class='edit-value'  propertyToChange='downloadLink' storedCellValue='${item.downloadLink}' prefix='${ownerBeanName}Manager/updateAdMachineApk/${result.id}/${item.id}/'>${item.downloadLink}</td>
</c:if><c:if test="${param.referName ne 'belongsTo'}">	<td ><a href='./bettbioCompanyManager/loadBettbioCompanyDetail/${item.belongsTo.id}/'>${item.belongsTo.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeAdMachineApk/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyAdMachineApkFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


