
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty refrigeratorInOrgnizationList}">
<div class="col-xs-12 col-md-12 section">
	<b title="A RefrigeratorInOrgnizationList"> 
		${userContext.localeMap['refrigerator_in_orgnization_list']}${userContext.localeMap['@word_space']}${userContext.localeMap['@summary']}
		</b>
		<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
		
		</div>
		
	
	
	<hr/>
	<div>
	
	
	<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator_in_orgnization_list.id']}</span>
<span >${result.id}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator_in_orgnization_list.title']}</span>
<span >${result.title}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator_in_orgnization_list.research_institute_id']}</span>
<span >${result.researchInstituteId}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator_in_orgnization_list.research_group_id']}</span>
<span >${result.researchGroupId}</span>
</div>
<div class="col-xs-12 col-md-3 summary-section">
<span class="summary-label">${userContext.localeMap['refrigerator_in_orgnization_list.laboratory_id']}</span>
<span >${result.laboratoryId}</span>
</div>

	</div>
	
</div>

</c:if>







<c:if test="false">
<div class="col-xs-12 col-md-12">
	<b title="A Order">Summary</b>
	<hr/>
	<div>
		<div class="col-xs-12 col-md-3 summary-section">
		<span class="summary-lable">Order ID</span> <span ></span>
		</div>
		<div class="col-xs-12 col-md-3 summary-section">
		<span class="summary-lable">Order Title</span> <span ></span>
		</div>
		<div class="col-xs-12 col-md-3 summary-section">
		<span class="summary-lable">Order Type</span> <span ></span>
		</div>
		<div class="col-xs-12 col-md-3 summary-section">
		<span class="summary-lable">Order Amount</span> <span ></span>
		</div>
	</div>
	<hr/>
</div>



</c:if>










