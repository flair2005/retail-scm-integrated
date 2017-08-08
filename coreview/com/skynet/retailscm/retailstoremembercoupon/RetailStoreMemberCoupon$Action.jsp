
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreMemberCoupon}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A RetailStoreMemberCoupon" style="color: green">${userContext.localeMap['retail_store_member_coupon']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['retail_store_member_coupon.id']}</span> ${retailStoreMemberCoupon.id}</li>
<li><span>${userContext.localeMap['retail_store_member_coupon.name']}</span> ${retailStoreMemberCoupon.name}</li>
<li><span>${userContext.localeMap['retail_store_member_coupon.number']}</span> ${retailStoreMemberCoupon.number}</li>

	
	</ul>
</div>



</c:if>


