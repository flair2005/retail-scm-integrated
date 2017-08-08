
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty groupPage}">
<div class="col-xs-12 col-md-4 section">
	<b title="A GroupPage">${userContext.localeMap['group_page']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./groupPageManager/loadGroupPageDetail/${groupPage.id}/"> ${groupPage.id}</a></li>
<li><span>${userContext.localeMap['group_page.title']}</span> ${groupPage.title}</li>
<li><span>${userContext.localeMap['group_page.current_key']}</span> ${groupPage.currentKey}</li>

	
	</ul>
	
	
	
</div>

</c:if>




