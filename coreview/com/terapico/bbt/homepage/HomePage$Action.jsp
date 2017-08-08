
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty homePage}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A HomePage" style="color: green">${userContext.localeMap['home_page']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['home_page.id']}</span> ${homePage.id}</li>
<li><span>${userContext.localeMap['home_page.title']}</span> ${homePage.title}</li>

	
	</ul>
</div>



</c:if>


