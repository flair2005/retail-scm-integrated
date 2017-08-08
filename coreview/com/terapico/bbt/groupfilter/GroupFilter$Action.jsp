
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty groupFilter}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A GroupFilter" style="color: green">${userContext.localeMap['group_filter']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['group_filter.id']}</span> ${groupFilter.id}</li>
<li><span>${userContext.localeMap['group_filter.title']}</span> ${groupFilter.title}</li>
<li><span>${userContext.localeMap['group_filter.current_key']}</span> ${groupFilter.currentKey}</li>

	
	</ul>
</div>



</c:if>


