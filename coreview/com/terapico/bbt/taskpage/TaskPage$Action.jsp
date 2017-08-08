
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty taskPage}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A TaskPage" style="color: green">${userContext.localeMap['task_page']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['task_page.id']}</span> ${taskPage.id}</li>
<li><span>${userContext.localeMap['task_page.title']}</span> ${taskPage.title}</li>
<li><span>${userContext.localeMap['task_page.current_key']}</span> ${taskPage.currentKey}</li>

	
	</ul>
</div>



</c:if>


