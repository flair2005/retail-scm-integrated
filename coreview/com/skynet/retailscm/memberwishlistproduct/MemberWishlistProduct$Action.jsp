
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty memberWishlistProduct}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A MemberWishlistProduct" style="color: green">${userContext.localeMap['member_wishlist_product']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['member_wishlist_product.id']}</span> ${memberWishlistProduct.id}</li>
<li><span>${userContext.localeMap['member_wishlist_product.name']}</span> ${memberWishlistProduct.name}</li>

	
	</ul>
</div>



</c:if>


