
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty goodsShelfStockCount}">
<div class="col-xs-12 col-md-4 section">
	<b title="A GoodsShelfStockCount">${userContext.localeMap['goods_shelf_stock_count']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./goodsShelfStockCountManager/loadGoodsShelfStockCountDetail/${goodsShelfStockCount.id}/"> ${goodsShelfStockCount.id}</a></li>
<li><span>${userContext.localeMap['goods_shelf_stock_count.title']}</span> ${goodsShelfStockCount.title}</li>
<li><span>${userContext.localeMap['goods_shelf_stock_count.count_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${goodsShelfStockCount.countTime}" /></li>
<li><span>${userContext.localeMap['goods_shelf_stock_count.summary']}</span> ${goodsShelfStockCount.summary}</li>

	
	</ul>
	
	
	
</div>

</c:if>




