
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty productClass}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A ProductClass" style="color: green">${userContext.localeMap['product_class']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['product_class.id']}</span> ${productClass.id}</li>
<li><span>${userContext.localeMap['product_class.name']}</span> ${productClass.name}</li>
<li><span>${userContext.localeMap['product_class.description']}</span> ${productClass.description}</li>

	
	</ul>
</div>



</c:if>


