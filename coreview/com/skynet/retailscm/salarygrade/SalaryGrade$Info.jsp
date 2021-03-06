
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty salaryGrade}">
<div class="col-xs-12 col-md-4 section">
	<b title="A SalaryGrade">${userContext.localeMap['salary_grade']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./salaryGradeManager/loadSalaryGradeDetail/${salaryGrade.id}/"> ${salaryGrade.id}</a></li>
<li><span>${userContext.localeMap['salary_grade.code']}</span> ${salaryGrade.code}</li>
<li><span>${userContext.localeMap['salary_grade.name']}</span> ${salaryGrade.name}</li>
<li><span>${userContext.localeMap['salary_grade.detail_description']}</span> ${salaryGrade.detailDescription}</li>

	
	</ul>
	
	
	
</div>

</c:if>




