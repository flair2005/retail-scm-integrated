
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty goods}">
<div class="col-xs-12 col-md-4 section">
	<b title="A Goods">${userContext.localeMap['goods']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./goodsManager/loadGoodsDetail/${goods.id}/"> ${goods.id}</a></li>
<li><span>${userContext.localeMap['goods.name']}</span> ${goods.name}</li>
<li><span>${userContext.localeMap['goods.rfid']}</span> ${goods.rfid}</li>
<li><span>${userContext.localeMap['goods.uom']}</span> ${goods.uom}</li>
<li><span>${userContext.localeMap['goods.max_package']}</span> ${goods.maxPackage}</li>
<li><span>${userContext.localeMap['goods.expire_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${goods.expireTime}" /></li>
<li><span>${userContext.localeMap['goods.current_status']}</span> ${goods.currentStatus}</li>

	
	</ul>
	
	
	
</div>

</c:if>




