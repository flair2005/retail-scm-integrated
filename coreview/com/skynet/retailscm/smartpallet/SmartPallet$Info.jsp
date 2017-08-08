
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty smartPallet}">
<div class="col-xs-12 col-md-4 section">
	<b title="A SmartPallet">${userContext.localeMap['smart_pallet']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./smartPalletManager/loadSmartPalletDetail/${smartPallet.id}/"> ${smartPallet.id}</a></li>
<li><span>${userContext.localeMap['smart_pallet.location']}</span> ${smartPallet.location}</li>
<li><span>${userContext.localeMap['smart_pallet.contact_number']}</span> ${smartPallet.contactNumber}</li>
<li><span>${userContext.localeMap['smart_pallet.total_area']}</span> ${smartPallet.totalArea}</li>
<li><span>${userContext.localeMap['smart_pallet.latitude']}</span> ${smartPallet.latitude}</li>
<li><span>${userContext.localeMap['smart_pallet.longitude']}</span> ${smartPallet.longitude}</li>

	
	</ul>
	
	
	
</div>

</c:if>




