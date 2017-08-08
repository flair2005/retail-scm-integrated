
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty employeeInterview}">

<div class="col-xs-12 col-md-3 action-section" >
	<b title="A EmployeeInterview" style="color: green">${userContext.localeMap['employee_interview']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['employee_interview.id']}</span> ${employeeInterview.id}</li>
<li><span>${userContext.localeMap['employee_interview.remark']}</span> ${employeeInterview.remark}</li>

	
	</ul>
</div>



</c:if>


