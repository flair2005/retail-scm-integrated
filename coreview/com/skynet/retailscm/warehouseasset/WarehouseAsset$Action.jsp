
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty warehouseAsset}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A WarehouseAsset" style="color: green">${userContext.localeMap['warehouse_asset']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['warehouse_asset.id']}</span> ${warehouseAsset.id}</li>
<li><span>${userContext.localeMap['warehouse_asset.name']}</span> ${warehouseAsset.name}</li>
<li><span>${userContext.localeMap['warehouse_asset.position']}</span> ${warehouseAsset.position}</li>

	
	</ul>
</div>



</c:if>


