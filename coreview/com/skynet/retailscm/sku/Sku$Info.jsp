
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty sku}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Sku">${userContext.localeMap['sku']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./skuManager/loadSkuDetail/${sku.id}/"> ${sku.id}</a></li>
<li><span>${userContext.localeMap['sku.display_name']}</span> ${sku.displayName}</li>
<li><span>${userContext.localeMap['sku.size']}</span> ${sku.size}</li>
<li><span>${userContext.localeMap['sku.barcode']}</span> ${sku.barcode}</li>
<li><span>${userContext.localeMap['sku.package_type']}</span> ${sku.packageType}</li>
<li><span>${userContext.localeMap['sku.net_content']}</span> ${sku.netContent}</li>
<li><span>${userContext.localeMap['sku.price']}</span> <fmt:formatNumber type="currency"  value="${sku.price}" /></li>
<li><span>${userContext.localeMap['sku.picture']}</span> ${sku.picture}</li>

	
	</ul>
	
	
	
</div>

</c:if>




