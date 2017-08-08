<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="refrigeratorList" value="${result.refrigeratorList}"/>

<c:if test="${ empty refrigeratorList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['refrigerator']}! 
		 <a href="./${ownerBeanName}Manager/addRefrigerator/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.refrigeratorList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("refrigeratorList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['refrigerator']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addRefrigerator/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/refrigeratorList;refrigeratorListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='refrigeratorListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['refrigerator.id']}</th>
</c:if>
<c:if test="${param.referName ne 'title'}">
	<th>${userContext.localeMap['refrigerator.title']}</th>
</c:if>
<c:if test="${param.referName ne 'laboratory'}">
	<th>${userContext.localeMap['refrigerator.laboratory']}</th>
</c:if>
<c:if test="${param.referName ne 'refrigeratorManufacturer'}">
	<th>${userContext.localeMap['refrigerator.refrigerator_manufacturer']}</th>
</c:if>
<c:if test="${param.referName ne 'refrigeratorModel'}">
	<th>${userContext.localeMap['refrigerator.refrigerator_model']}</th>
</c:if>
<c:if test="${param.referName ne 'refrigeratorSerialNumber'}">
	<th>${userContext.localeMap['refrigerator.refrigerator_serial_number']}</th>
</c:if>
<c:if test="${param.referName ne 'refrigeratorCapacity'}">
	<th>${userContext.localeMap['refrigerator.refrigerator_capacity']}</th>
</c:if>
<c:if test="${param.referName ne 'refrigeratorUpTime'}">
	<th>${userContext.localeMap['refrigerator.refrigerator_up_time']}</th>
</c:if>
<c:if test="${param.referName ne 'adMachineModel'}">
	<th>${userContext.localeMap['refrigerator.ad_machine_model']}</th>
</c:if>
<c:if test="${param.referName ne 'adMachineSerialNumber'}">
	<th>${userContext.localeMap['refrigerator.ad_machine_serial_number']}</th>
</c:if>
<c:if test="${param.referName ne 'adMachineUpTime'}">
	<th>${userContext.localeMap['refrigerator.ad_machine_up_time']}</th>
</c:if>
<c:if test="${param.referName ne 'rfidReaderId'}">
	<th>${userContext.localeMap['refrigerator.rfid_reader_id']}</th>
</c:if>
<c:if test="${param.referName ne 'longitude'}">
	<th>${userContext.localeMap['refrigerator.longitude']}</th>
</c:if>
<c:if test="${param.referName ne 'latitude'}">
	<th>${userContext.localeMap['refrigerator.latitude']}</th>
</c:if>
<c:if test="${param.referName ne 'belongsTo'}">
	<th>${userContext.localeMap['refrigerator.belongs_to']}</th>
</c:if>
<c:if test="${param.referName ne 'lastReportTime'}">
	<th>${userContext.localeMap['refrigerator.last_report_time']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.refrigeratorList}">
				<tr currentVersion='${item.version}' id="refrigerator-${item.id}" ><td><a class="link-action-removed" href="./refrigeratorManager/loadRefrigeratorDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'title'}">	<td contenteditable='true' class='edit-value'  propertyToChange='title' storedCellValue='${item.title}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.title}</td>
</c:if><c:if test="${param.referName ne 'laboratory'}">	<td ><a href='./laboratoryManager/loadLaboratoryDetail/${item.laboratory.id}/'>${item.laboratory.id}</a></td>
</c:if><c:if test="${param.referName ne 'refrigeratorManufacturer'}">	<td contenteditable='true' class='edit-value'  propertyToChange='refrigeratorManufacturer' storedCellValue='${item.refrigeratorManufacturer}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.refrigeratorManufacturer}</td>
</c:if><c:if test="${param.referName ne 'refrigeratorModel'}">	<td contenteditable='true' class='edit-value'  propertyToChange='refrigeratorModel' storedCellValue='${item.refrigeratorModel}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.refrigeratorModel}</td>
</c:if><c:if test="${param.referName ne 'refrigeratorSerialNumber'}">	<td contenteditable='true' class='edit-value'  propertyToChange='refrigeratorSerialNumber' storedCellValue='${item.refrigeratorSerialNumber}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.refrigeratorSerialNumber}</td>
</c:if><c:if test="${param.referName ne 'refrigeratorCapacity'}">	<td contenteditable='true' class='edit-value'  propertyToChange='refrigeratorCapacity' storedCellValue='${item.refrigeratorCapacity}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.refrigeratorCapacity}</td>
</c:if><c:if test="${param.referName ne 'refrigeratorUpTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='refrigeratorUpTime' storedCellValue='<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.refrigeratorUpTime}" />' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.refrigeratorUpTime}" /></td>
</c:if><c:if test="${param.referName ne 'adMachineModel'}">	<td contenteditable='true' class='edit-value'  propertyToChange='adMachineModel' storedCellValue='${item.adMachineModel}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.adMachineModel}</td>
</c:if><c:if test="${param.referName ne 'adMachineSerialNumber'}">	<td contenteditable='true' class='edit-value'  propertyToChange='adMachineSerialNumber' storedCellValue='${item.adMachineSerialNumber}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.adMachineSerialNumber}</td>
</c:if><c:if test="${param.referName ne 'adMachineUpTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='adMachineUpTime' storedCellValue='<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.adMachineUpTime}" />' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.adMachineUpTime}" /></td>
</c:if><c:if test="${param.referName ne 'rfidReaderId'}">	<td contenteditable='true' class='edit-value'  propertyToChange='rfidReaderId' storedCellValue='${item.rfidReaderId}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.rfidReaderId}</td>
</c:if><c:if test="${param.referName ne 'longitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='longitude' storedCellValue='${item.longitude}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.longitude}</td>
</c:if><c:if test="${param.referName ne 'latitude'}">	<td contenteditable='true' class='edit-value'  propertyToChange='latitude' storedCellValue='${item.latitude}' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'>${item.latitude}</td>
</c:if><c:if test="${param.referName ne 'belongsTo'}">	<td ><a href='./bettbioCompanyManager/loadBettbioCompanyDetail/${item.belongsTo.id}/'>${item.belongsTo.id}</a></td>
</c:if><c:if test="${param.referName ne 'lastReportTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='lastReportTime' storedCellValue='<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastReportTime}" />' prefix='${ownerBeanName}Manager/updateRefrigerator/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.lastReportTime}" /></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeRefrigerator/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyRefrigeratorFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


