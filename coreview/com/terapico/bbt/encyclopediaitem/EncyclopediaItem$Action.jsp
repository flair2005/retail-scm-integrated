
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty encyclopediaItem}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A EncyclopediaItem" style="color: green">${userContext.localeMap['encyclopedia_item']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['encyclopedia_item.id']}</span> ${encyclopediaItem.id}</li>
<li><span>${userContext.localeMap['encyclopedia_item.title']}</span> ${encyclopediaItem.title}</li>
<li><span>${userContext.localeMap['encyclopedia_item.publish_date']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${encyclopediaItem.publishDate}" /></li>
<li><span>${userContext.localeMap['encyclopedia_item.content']}</span> ${encyclopediaItem.content}</li>

	
	</ul>
</div>



</c:if>


