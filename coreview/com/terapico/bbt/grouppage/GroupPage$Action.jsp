
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty groupPage}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A GroupPage" style="color: green">${userContext.localeMap['group_page']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['group_page.id']}</span> ${groupPage.id}</li>
<li><span>${userContext.localeMap['group_page.title']}</span> ${groupPage.title}</li>
<li><span>${userContext.localeMap['group_page.current_key']}</span> ${groupPage.currentKey}</li>

	
	</ul>
</div>



</c:if>


