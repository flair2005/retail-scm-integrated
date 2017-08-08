
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty encyclopediaItem}">
<div class="col-xs-12 col-md-4 section">
	<b title="A EncyclopediaItem">${userContext.localeMap['encyclopedia_item']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./encyclopediaItemManager/loadEncyclopediaItemDetail/${encyclopediaItem.id}/"> ${encyclopediaItem.id}</a></li>
<li><span>${userContext.localeMap['encyclopedia_item.title']}</span> ${encyclopediaItem.title}</li>
<li><span>${userContext.localeMap['encyclopedia_item.publish_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${encyclopediaItem.publishDate}" /></li>
<li><span>${userContext.localeMap['encyclopedia_item.content']}</span> ${encyclopediaItem.content}</li>

	
	</ul>
	
	
	
</div>

</c:if>




