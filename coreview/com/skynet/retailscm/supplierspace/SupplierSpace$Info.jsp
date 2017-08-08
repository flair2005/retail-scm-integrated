
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplierSpace}">
<div class="col-xs-12 col-md-4 section">
	<b title="A SupplierSpace">${userContext.localeMap['supplier_space']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./supplierSpaceManager/loadSupplierSpaceDetail/${supplierSpace.id}/"> ${supplierSpace.id}</a></li>
<li><span>${userContext.localeMap['supplier_space.location']}</span> ${supplierSpace.location}</li>
<li><span>${userContext.localeMap['supplier_space.contact_number']}</span> ${supplierSpace.contactNumber}</li>
<li><span>${userContext.localeMap['supplier_space.total_area']}</span> ${supplierSpace.totalArea}</li>
<li><span>${userContext.localeMap['supplier_space.latitude']}</span> ${supplierSpace.latitude}</li>
<li><span>${userContext.localeMap['supplier_space.longitude']}</span> ${supplierSpace.longitude}</li>

	
	</ul>
	
	
	
</div>

</c:if>




