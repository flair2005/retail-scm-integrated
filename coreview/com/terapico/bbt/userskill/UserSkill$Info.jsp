
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty userSkill}">
<div class="col-xs-12 col-md-4 section">
	<b title="A UserSkill">${userContext.localeMap['user_skill']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./userSkillManager/loadUserSkillDetail/${userSkill.id}/"> ${userSkill.id}</a></li>
<li><span>${userContext.localeMap['user_skill.skill_name']}</span> ${userSkill.skillName}</li>

	
	</ul>
	
	
	
</div>

</c:if>




