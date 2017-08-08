
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStore}">
<div class="col-xs-12 col-md-4 section">
	<b title="A RetailStore">${userContext.localeMap['retail_store']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./retailStoreManager/loadRetailStoreDetail/${retailStore.id}/"> ${retailStore.id}</a></li>
<li><span>${userContext.localeMap['retail_store.name']}</span> ${retailStore.name}</li>
<li><span>${userContext.localeMap['retail_store.telephone']}</span> ${retailStore.telephone}</li>
<li><span>${userContext.localeMap['retail_store.owner']}</span> ${retailStore.owner}</li>
<li><span>${userContext.localeMap['retail_store.founded']}</span> ${retailStore.founded}</li>
<li><span>${userContext.localeMap['retail_store.latitude']}</span> ${retailStore.latitude}</li>
<li><span>${userContext.localeMap['retail_store.longitude']}</span> ${retailStore.longitude}</li>
<li><span>${userContext.localeMap['retail_store.description']}</span> ${retailStore.description}</li>
<li><span>${userContext.localeMap['retail_store.current_status']}</span> ${retailStore.currentStatus}</li>

	
	</ul>
	
	
	
</div>

</c:if>




