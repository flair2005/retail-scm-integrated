
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreClosing}">
<div class="col-xs-12 col-md-4 section">
	<b title="A RetailStoreClosing">${userContext.localeMap['retail_store_closing']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./retailStoreClosingManager/loadRetailStoreClosingDetail/${retailStoreClosing.id}/"> ${retailStoreClosing.id}</a></li>
<li><span>${userContext.localeMap['retail_store_closing.comment']}</span> ${retailStoreClosing.comment}</li>

	
	</ul>
	
	
	
</div>

</c:if>




