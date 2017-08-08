<%@ page import='java.util.*,com.terapico.bbt.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="patientInfoList" value="${result.patientInfoList}"/>

<c:if test="${ empty patientInfoList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['patient_info']}! 
		 <a href="./${ownerBeanName}Manager/addPatientInfo/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.patientInfoList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("patientInfoList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['patient_info']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addPatientInfo/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'patientInfoList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/patientInfoList;patientInfoListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='patientInfoListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['patient_info.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['patient_info.name']}</th>
</c:if>
<c:if test="${param.referName ne 'nickName'}">
	<th>${userContext.localeMap['patient_info.nick_name']}</th>
</c:if>
<c:if test="${param.referName ne 'wearDeviceType'}">
	<th>${userContext.localeMap['patient_info.wear_device_type']}</th>
</c:if>
<c:if test="${param.referName ne 'wearStartDate'}">
	<th>${userContext.localeMap['patient_info.wear_start_date']}</th>
</c:if>
<c:if test="${param.referName ne 'recoverPlan'}">
	<th>${userContext.localeMap['patient_info.recover_plan']}</th>
</c:if>
<c:if test="${param.referName ne 'recoverStartDate'}">
	<th>${userContext.localeMap['patient_info.recover_start_date']}</th>
</c:if>
<c:if test="${param.referName ne 'user'}">
	<th>${userContext.localeMap['patient_info.user']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.patientInfoList}">
				<tr currentVersion='${item.version}' id="patientInfo-${item.id}" ><td><a class="link-action-removed" href="./patientInfoManager/loadPatientInfoDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updatePatientInfo/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'nickName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='nickName' storedCellValue='${item.nickName}' prefix='${ownerBeanName}Manager/updatePatientInfo/${result.id}/${item.id}/'>${item.nickName}</td>
</c:if><c:if test="${param.referName ne 'wearDeviceType'}">	<td contenteditable='true' class='edit-value'  propertyToChange='wearDeviceType' storedCellValue='${item.wearDeviceType}' prefix='${ownerBeanName}Manager/updatePatientInfo/${result.id}/${item.id}/'>${item.wearDeviceType}</td>
</c:if><c:if test="${param.referName ne 'wearStartDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='wearStartDate' storedCellValue='${item.wearStartDate}' prefix='${ownerBeanName}Manager/updatePatientInfo/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.wearStartDate}" /></td>
</c:if><c:if test="${param.referName ne 'recoverPlan'}">	<td contenteditable='true' class='edit-value'  propertyToChange='recoverPlan' storedCellValue='${item.recoverPlan}' prefix='${ownerBeanName}Manager/updatePatientInfo/${result.id}/${item.id}/'>${item.recoverPlan}</td>
</c:if><c:if test="${param.referName ne 'recoverStartDate'}">	<td contenteditable='true' class='edit-value'  propertyToChange='recoverStartDate' storedCellValue='${item.recoverStartDate}' prefix='${ownerBeanName}Manager/updatePatientInfo/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd" value="${item.recoverStartDate}" /></td>
</c:if><c:if test="${param.referName ne 'user'}">	<td ><a href='./communityUserManager/loadCommunityUserDetail/${item.user.id}/'>${item.user.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removePatientInfo/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyPatientInfoFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


