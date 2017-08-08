
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty goodsPackaging}">
<div class="col-xs-12 col-md-4 section">
	<b title="A GoodsPackaging">${userContext.localeMap['goods_packaging']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./goodsPackagingManager/loadGoodsPackagingDetail/${goodsPackaging.id}/"> ${goodsPackaging.id}</a></li>
<li><span>${userContext.localeMap['goods_packaging.package_name']}</span> ${goodsPackaging.packageName}</li>
<li><span>${userContext.localeMap['goods_packaging.rfid']}</span> ${goodsPackaging.rfid}</li>
<li><span>${userContext.localeMap['goods_packaging.package_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${goodsPackaging.packageTime}" /></li>
<li><span>${userContext.localeMap['goods_packaging.description']}</span> ${goodsPackaging.description}</li>

	
	</ul>
	
	
	
</div>

</c:if>




