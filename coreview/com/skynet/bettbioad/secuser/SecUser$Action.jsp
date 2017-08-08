
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty secUser}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A SecUser" style="color: green">${userContext.localeMap['sec_user']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['sec_user.id']}</span> ${secUser.id}</li>
<li><span>${userContext.localeMap['sec_user.login']}</span> ${secUser.login}</li>
<li><span>${userContext.localeMap['sec_user.mobile']}</span> ${secUser.maskedMobile}</li>
<li><span>${userContext.localeMap['sec_user.email']}</span> ${secUser.email}</li>
<li><span>${userContext.localeMap['sec_user.pwd']}</span> ${secUser.maskedPwd}</li>
<li><span>${userContext.localeMap['sec_user.last_login']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${secUser.lastLogin}" /></li>

	
	</ul>
</div>



</c:if>


