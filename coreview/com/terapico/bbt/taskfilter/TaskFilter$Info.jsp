
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty taskFilter}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TaskFilter">${userContext.localeMap['task_filter']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./taskFilterManager/loadTaskFilterDetail/${taskFilter.id}/"> ${taskFilter.id}</a></li>
<li><span>${userContext.localeMap['task_filter.name']}</span> ${taskFilter.name}</li>
<li><span>${userContext.localeMap['task_filter.filter_key']}</span> ${taskFilter.filterKey}</li>
<li><span>${userContext.localeMap['task_filter.link_url']}</span> ${taskFilter.linkUrl}</li>

	
	</ul>
	
	
	
</div>

</c:if>




