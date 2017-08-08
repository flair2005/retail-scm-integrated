
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty cityPartner}">
<div class="col-xs-12 col-md-4 section">
	<b title="A CityPartner">${userContext.localeMap['city_partner']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./cityPartnerManager/loadCityPartnerDetail/${cityPartner.id}/"> ${cityPartner.id}</a></li>
<li><span>${userContext.localeMap['city_partner.name']}</span> ${cityPartner.name}</li>
<li><span>${userContext.localeMap['city_partner.mobile']}</span> ${cityPartner.maskedMobile}</li>
<li><span>${userContext.localeMap['city_partner.description']}</span> ${cityPartner.description}</li>

	
	</ul>
	
	
	
</div>

</c:if>




