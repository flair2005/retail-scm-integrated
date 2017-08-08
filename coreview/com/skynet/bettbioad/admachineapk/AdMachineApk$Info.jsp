
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty adMachineApk}">
<div class="col-xs-12 col-md-4 section">
	<b title="A AdMachineApk">${userContext.localeMap['ad_machine_apk']}</b>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./adMachineApkManager/loadAdMachineApkDetail/${adMachineApk.id}/"> ${adMachineApk.id}</a></li>
<li><span>${userContext.localeMap['ad_machine_apk.release_build']}</span> ${adMachineApk.releaseBuild}</li>
<li><span>${userContext.localeMap['ad_machine_apk.release_date']}</span> ${adMachineApk.releaseDate}</li>
<li><span>${userContext.localeMap['ad_machine_apk.download_link']}</span> ${adMachineApk.downloadLink}</li>

	
	</ul>
	
	
	
</div>

</c:if>




