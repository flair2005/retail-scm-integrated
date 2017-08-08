
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty adMachineApk}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A AdMachineApk" style="color: green">${userContext.localeMap['ad_machine_apk']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['ad_machine_apk.id']}</span> ${adMachineApk.id}</li>
<li><span>${userContext.localeMap['ad_machine_apk.release_build']}</span> ${adMachineApk.releaseBuild}</li>
<li><span>${userContext.localeMap['ad_machine_apk.release_date']}</span> ${adMachineApk.releaseDate}</li>
<li><span>${userContext.localeMap['ad_machine_apk.download_link']}</span> ${adMachineApk.downloadLink}</li>

	
	</ul>
</div>



</c:if>


