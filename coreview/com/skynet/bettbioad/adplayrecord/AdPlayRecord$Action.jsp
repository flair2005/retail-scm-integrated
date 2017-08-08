
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty adPlayRecord}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A AdPlayRecord" style="color: green">${userContext.localeMap['ad_play_record']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['ad_play_record.id']}</span> ${adPlayRecord.id}</li>
<li><span>${userContext.localeMap['ad_play_record.count_time']}</span> ${adPlayRecord.countTime}</li>

	
	</ul>
</div>



</c:if>


