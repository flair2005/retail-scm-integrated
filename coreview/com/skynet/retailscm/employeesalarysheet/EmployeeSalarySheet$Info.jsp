
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeSalarySheet}">
<div class="col-xs-12 col-md-4 section">
	<b title="A EmployeeSalarySheet">${userContext.localeMap['employee_salary_sheet']} </b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./employeeSalarySheetManager/loadEmployeeSalarySheetDetail/${employeeSalarySheet.id}/"> ${employeeSalarySheet.id}</a></li>
<li><span>${userContext.localeMap['employee_salary_sheet.base_salary']}</span> <fmt:formatNumber type="currency"  value="${employeeSalarySheet.baseSalary}" /></li>
<li><span>${userContext.localeMap['employee_salary_sheet.bonus']}</span> <fmt:formatNumber type="currency"  value="${employeeSalarySheet.bonus}" /></li>
<li><span>${userContext.localeMap['employee_salary_sheet.reward']}</span> <fmt:formatNumber type="currency"  value="${employeeSalarySheet.reward}" /></li>
<li><span>${userContext.localeMap['employee_salary_sheet.personal_tax']}</span> <fmt:formatNumber type="currency"  value="${employeeSalarySheet.personalTax}" /></li>
<li><span>${userContext.localeMap['employee_salary_sheet.social_security']}</span> <fmt:formatNumber type="currency"  value="${employeeSalarySheet.socialSecurity}" /></li>
<li><span>${userContext.localeMap['employee_salary_sheet.housing_found']}</span> <fmt:formatNumber type="currency"  value="${employeeSalarySheet.housingFound}" /></li>
<li><span>${userContext.localeMap['employee_salary_sheet.job_insurance']}</span> <fmt:formatNumber type="currency"  value="${employeeSalarySheet.jobInsurance}" /></li>
<li><span>${userContext.localeMap['employee_salary_sheet.current_status']}</span> ${employeeSalarySheet.currentStatus}</li>

	
	</ul>
	
	
	
</div>

</c:if>




