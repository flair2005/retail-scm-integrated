
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty retailStoreMember}">
<div class="col-xs-12 col-md-4 section">
	<b title="A RetailStoreMember">${userContext.localeMap['retail_store_member']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./retailStoreMemberManager/loadRetailStoreMemberDetail/${retailStoreMember.id}/"> ${retailStoreMember.id}</a></li>
<li><span>${userContext.localeMap['retail_store_member.name']}</span> ${retailStoreMember.name}</li>
<li><span>${userContext.localeMap['retail_store_member.mobile_phone']}</span> ${retailStoreMember.maskedMobilePhone}</li>

	
	</ul>
	
	
	
</div>

</c:if>




