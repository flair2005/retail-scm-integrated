
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty offerAcceptance}">
<div class="col-xs-12 col-md-4 section">
	<b title="A OfferAcceptance">${userContext.localeMap['offer_acceptance']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./offerAcceptanceManager/loadOfferAcceptanceDetail/${offerAcceptance.id}/"> ${offerAcceptance.id}</a></li>
<li><span>${userContext.localeMap['offer_acceptance.who']}</span> ${offerAcceptance.who}</li>
<li><span>${userContext.localeMap['offer_acceptance.accept_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${offerAcceptance.acceptTime}" /></li>
<li><span>${userContext.localeMap['offer_acceptance.comments']}</span> ${offerAcceptance.comments}</li>

	
	</ul>
	
	
	
</div>

</c:if>




