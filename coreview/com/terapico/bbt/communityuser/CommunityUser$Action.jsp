
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty communityUser}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A CommunityUser" style="color: green">${userContext.localeMap['community_user']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['community_user.id']}</span> ${communityUser.id}</li>
<li><span>${userContext.localeMap['community_user.mobile']}</span> ${communityUser.maskedMobile}</li>
<li><span>${userContext.localeMap['community_user.name']}</span> ${communityUser.name}</li>
<li><span>${userContext.localeMap['community_user.nick_name']}</span> ${communityUser.nickName}</li>
<li><span>${userContext.localeMap['community_user.gender']}</span> ${communityUser.gender}</li>
<li><span>${userContext.localeMap['community_user.user_type']}</span> ${communityUser.userType}</li>
<li><span>${userContext.localeMap['community_user.avatar']}</span> ${communityUser.avatar}</li>
<li><span>${userContext.localeMap['community_user.birthday']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${communityUser.birthday}" /></li>
<li><span>${userContext.localeMap['community_user.task_count']}</span> ${communityUser.taskCount}</li>
<li><span>${userContext.localeMap['community_user.topic_count']}</span> ${communityUser.topicCount}</li>
<li><span>${userContext.localeMap['community_user.experience_point']}</span> ${communityUser.experiencePoint}</li>
<li><span>${userContext.localeMap['community_user.bonus_point']}</span> ${communityUser.bonusPoint}</li>
<li><span>${userContext.localeMap['community_user.fans_count']}</span> ${communityUser.fansCount}</li>
<li><span>${userContext.localeMap['community_user.city']}</span> ${communityUser.city}</li>
<li><span>${userContext.localeMap['community_user.status']}</span> ${communityUser.status}</li>

	
	</ul>
</div>



</c:if>


