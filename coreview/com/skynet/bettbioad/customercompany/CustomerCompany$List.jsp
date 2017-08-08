<%@ page import='java.util.*,com.skynet.bettbioad.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>

<c:set var="customerCompanyList" value="${result.customerCompanyList}"/>

<c:if test="${ empty customerCompanyList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['customer_company']}! 
		 <a href="./${ownerBeanName}Manager/addCustomerCompany/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty result.customerCompanyList}" >
    
    
<%

 	SmartList list=(SmartList)pageContext.getAttribute("customerCompanyList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-list-ol'></i> ${userContext.localeMap['customer_company']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addCustomerCompany/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/customerCompanyList;customerCompanyListCurrentPage=${page.pageNumber}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='customerCompanyListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['customer_company.id']}</th>
</c:if>
<c:if test="${param.referName ne 'name'}">
	<th>${userContext.localeMap['customer_company.name']}</th>
</c:if>
<c:if test="${param.referName ne 'address'}">
	<th>${userContext.localeMap['customer_company.address']}</th>
</c:if>
<c:if test="${param.referName ne 'email'}">
	<th>${userContext.localeMap['customer_company.email']}</th>
</c:if>
<c:if test="${param.referName ne 'phone'}">
	<th>${userContext.localeMap['customer_company.phone']}</th>
</c:if>
<c:if test="${param.referName ne 'homePage'}">
	<th>${userContext.localeMap['customer_company.home_page']}</th>
</c:if>
<c:if test="${param.referName ne 'companyProfile'}">
	<th>${userContext.localeMap['customer_company.company_profile']}</th>
</c:if>
<c:if test="${param.referName ne 'belongsTo'}">
	<th>${userContext.localeMap['customer_company.belongs_to']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${result.customerCompanyList}">
				<tr currentVersion='${item.version}' id="customerCompany-${item.id}" ><td><a class="link-action-removed" href="./customerCompanyManager/loadCustomerCompanyDetail/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'name'}">	<td contenteditable='true' class='edit-value'  propertyToChange='name' storedCellValue='${item.name}' prefix='${ownerBeanName}Manager/updateCustomerCompany/${result.id}/${item.id}/'>${item.name}</td>
</c:if><c:if test="${param.referName ne 'address'}">	<td contenteditable='true' class='edit-value'  propertyToChange='address' storedCellValue='${item.address}' prefix='${ownerBeanName}Manager/updateCustomerCompany/${result.id}/${item.id}/'>${item.address}</td>
</c:if><c:if test="${param.referName ne 'email'}">	<td contenteditable='true' class='edit-value'  propertyToChange='email' storedCellValue='${item.email}' prefix='${ownerBeanName}Manager/updateCustomerCompany/${result.id}/${item.id}/'>${item.email}</td>
</c:if><c:if test="${param.referName ne 'phone'}">	<td contenteditable='true' class='edit-value'  propertyToChange='phone' storedCellValue='${item.phone}' prefix='${ownerBeanName}Manager/updateCustomerCompany/${result.id}/${item.id}/'>${item.phone}</td>
</c:if><c:if test="${param.referName ne 'homePage'}">	<td contenteditable='true' class='edit-value'  propertyToChange='homePage' storedCellValue='${item.homePage}' prefix='${ownerBeanName}Manager/updateCustomerCompany/${result.id}/${item.id}/'>${item.homePage}</td>
</c:if><c:if test="${param.referName ne 'companyProfile'}">	<td contenteditable='true' class='edit-value'  propertyToChange='companyProfile' storedCellValue='${item.companyProfile}' prefix='${ownerBeanName}Manager/updateCustomerCompany/${result.id}/${item.id}/'>${item.companyProfile}</td>
</c:if><c:if test="${param.referName ne 'belongsTo'}">	<td ><a href='./bettbioCompanyManager/loadBettbioCompanyDetail/${item.belongsTo.id}/'>${item.belongsTo.id}</a></td>
</c:if>
				<td>

				<a href='#${ownerBeanName}Manager/removeCustomerCompany/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyCustomerCompanyFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


