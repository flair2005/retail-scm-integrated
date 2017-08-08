
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty supplierProduct}">
<div class="col-xs-12 col-md-4 section">
	<b title="A SupplierProduct">${userContext.localeMap['supplier_product']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./supplierProductManager/loadSupplierProductDetail/${supplierProduct.id}/"> ${supplierProduct.id}</a></li>
<li><span>${userContext.localeMap['supplier_product.product_name']}</span> ${supplierProduct.productName}</li>
<li><span>${userContext.localeMap['supplier_product.product_description']}</span> ${supplierProduct.productDescription}</li>
<li><span>${userContext.localeMap['supplier_product.product_unit']}</span> ${supplierProduct.productUnit}</li>

	
	</ul>
	
	
	
</div>

</c:if>




