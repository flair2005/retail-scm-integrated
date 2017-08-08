
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty marketingCampaign}">
<div class="col-xs-12 col-md-4 section">
	<b title="A MarketingCampaign">${userContext.localeMap['marketing_campaign']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./marketingCampaignManager/loadMarketingCampaignDetail/${marketingCampaign.id}/"> ${marketingCampaign.id}</a></li>
<li><span>${userContext.localeMap['marketing_campaign.title']}</span> ${marketingCampaign.title}</li>
<li><span>${userContext.localeMap['marketing_campaign.play_duration']}</span> ${marketingCampaign.playDuration}</li>
<li><span>${userContext.localeMap['marketing_campaign.image']}</span> ${marketingCampaign.image}</li>
<li><span>${userContext.localeMap['marketing_campaign.page_link']}</span> ${marketingCampaign.pageLink}</li>

	
	</ul>
	
	
	
</div>

</c:if>




