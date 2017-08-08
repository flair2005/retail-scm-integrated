
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty adInPageList}">
<div class="col-xs-12 col-md-4 section">
	<b title="A AdInPageList">${userContext.localeMap['ad_in_page_list']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./adInPageListManager/loadAdInPageListDetail/${adInPageList.id}/"> ${adInPageList.id}</a></li>
<li><span>${userContext.localeMap['ad_in_page_list.sequence_number']}</span> ${adInPageList.sequenceNumber}</li>

	
	</ul>
	
	
	
</div>

</c:if>




