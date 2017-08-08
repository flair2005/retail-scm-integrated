
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty trainingCourseType}">
<div class="col-xs-12 col-md-4 section">
	<b title="A TrainingCourseType">${userContext.localeMap['training_course_type']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./trainingCourseTypeManager/loadTrainingCourseTypeDetail/${trainingCourseType.id}/"> ${trainingCourseType.id}</a></li>
<li><span>${userContext.localeMap['training_course_type.code']}</span> ${trainingCourseType.code}</li>
<li><span>${userContext.localeMap['training_course_type.name']}</span> ${trainingCourseType.name}</li>
<li><span>${userContext.localeMap['training_course_type.description']}</span> ${trainingCourseType.description}</li>

	
	</ul>
	
	
	
</div>

</c:if>




