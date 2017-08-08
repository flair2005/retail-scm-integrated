
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty message}">
<div class="col-xs-12 col-md-12 section">
	<b title="A Message"> 
		${userContext.localeMap['message']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
  <a href="/naf/messageManager/clone/${result.id}/" class="btn btn-secondary"><i class="fa fa-files-o" aria-hidden="true"></i></a>
  <a href="/naf/messageManager/clone/${result.id}/"  class="btn btn-secondary"><i class="fa fa-bar-chart" aria-hidden="true"></i></a>
		</div>
		
	
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['message.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['message.title']}</span>
<span >${result.title}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['message.content']}</span>
<span >${result.content}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['message.message_date']}</span>
<span >${result.messageDate}</span>
</div>

	</div>
	
</div>

</c:if>




