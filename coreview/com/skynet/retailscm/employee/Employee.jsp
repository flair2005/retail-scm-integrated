<%@ page import='java.util.*,com.skynet.retailscm.*'%>

<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<!DOCTYPE html>
<html lang="en" slick-uniqueid="3"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="${baseURL}/" />    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>  ${userContext.localeMap['@system_name']} </title>

    <!-- Bootstrap core CSS -->
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="./bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">
 	<link href="./bootstrap/jquery-ui.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./bootstrap/dashboard.css" rel="stylesheet">
    <link href="./bootstrap/font-awesome.min.css" rel="stylesheet">
   
   

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./bootstrap/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 <style type="text/css">* {
 text-shadow: transparent 0px 0px 0px, rgba(0,0,0,0.68) 0px 0px 0px !important; 
}

</style>


</head>

  <body >


    <div class="container-fluid">
      <div class="row">
      
        <div class="col-xs-12 col-sm-12  col-md-12  main">
          
          <div class="table-responsive" id="content">
          <!-- real content -->

<c:set var="ownerBeanName" value="employee" scope="request"/>
<c:set var="ownerClassName" value="Employee" scope="request"/>

<div id="msg"></div>

<div class="row">

	<div class="col-xs-12 col-md-12">
			    <c:if test="${not empty result.errorMessageList}" >
    <ul>
    	<c:forEach var="item" items="${result.errorMessageList}">
    		
    		<div class="alert alert-success">
   ${item.sourcePosition} ${item.body}
</div>
    	</c:forEach>
    	</ul>
    </c:if>
	</div>



</div> <!--<div class="row">-->

<div class="row">
	
</div>

<div class="row">
	
	<div class="col-xs-12 col-md-12">

	<ul class="nav nav-tabs" id="navi-tabs">
	  <li class="active"><a data-toggle="tab" href="#summary" class="disabled"><i class="fa  fa-home"></i> ${userContext.localeMap['@summary']}</a></li>
	 
	<c:if test='${(not empty userContext.accessTokens["employeeCompanyTrainingList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeCompanyTrainingList" class="disabled"> ${userContext.localeMap['employee_company_training']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeSkillList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeSkillList" class="disabled"> ${userContext.localeMap['employee_skill']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeePerformanceList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeePerformanceList" class="disabled"> ${userContext.localeMap['employee_performance']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeWorkExperienceList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeWorkExperienceList" class="disabled"> ${userContext.localeMap['employee_work_experience']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeLeaveList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeLeaveList" class="disabled"> ${userContext.localeMap['employee_leave']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeInterviewList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeInterviewList" class="disabled"> ${userContext.localeMap['employee_interview']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeAttendanceList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeAttendanceList" class="disabled"> ${userContext.localeMap['employee_attendance']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeQualifierList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeQualifierList" class="disabled"> ${userContext.localeMap['employee_qualifier']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeEducationList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeEducationList" class="disabled"> ${userContext.localeMap['employee_education']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeAwardList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeAwardList" class="disabled"> ${userContext.localeMap['employee_award']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeSalarySheetList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeSalarySheetList" class="disabled"> ${userContext.localeMap['employee_salary_sheet']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["payingOffList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#payingOffList" class="disabled"> ${userContext.localeMap['paying_off']}</a></li>
	</c:if>
 
	</ul>
	</div>
</div>
<div class="tab-content" style="padding-top: 10px" id='tab-content'>
<div id="summary" class="tab-pane fade in active">
<div class="row">
	
	<div class="col-xs-12 col-md-12">
	
	</div>
</div>

<div class="row" desc="show parent objects">
	
	   
	<c:set var="employee" value="${ result}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/employee/Employee$Summary.jsp" />

	
</div>

	
	

	<div class="row">
<c:set var="retailStoreCountryCenter" value="${ result.company}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/retailstorecountrycenter/RetailStoreCountryCenter$Info.jsp" />

<c:set var="levelThreeDepartment" value="${ result.department}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/levelthreedepartment/LevelThreeDepartment$Info.jsp" />

<c:set var="occupationType" value="${ result.occupation}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/occupationtype/OccupationType$Info.jsp" />

<c:set var="responsibilityType" value="${ result.responsibleFor}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/responsibilitytype/ResponsibilityType$Info.jsp" />

<c:set var="salaryGrade" value="${ result.currentSalaryGrade}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/salarygrade/SalaryGrade$Info.jsp" />

</div>








	<hr/><div class="row">
<c:set var="jobApplication" value="${ result.jobApplication}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/jobapplication/JobApplication$Action.jsp" />

<c:set var="professionInterview" value="${ result.professionInterview}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/professioninterview/ProfessionInterview$Action.jsp" />

<c:set var="hrInterview" value="${ result.hrInterview}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/hrinterview/HrInterview$Action.jsp" />

<c:set var="offerApproval" value="${ result.offerApproval}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/offerapproval/OfferApproval$Action.jsp" />

<c:set var="offerAcceptance" value="${ result.offerAcceptance}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/offeracceptance/OfferAcceptance$Action.jsp" />

<c:set var="employeeBoarding" value="${ result.employeeBoarding}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/employeeboarding/EmployeeBoarding$Action.jsp" />

<c:set var="termination" value="${ result.termination}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/termination/Termination$Action.jsp" />

</div>






	</div><!-- end of <div id="summary" class="tab-pane fade in active">-->

	

		<c:if test='${not empty userContext.accessTokens["employeeCompanyTrainingList"] or ignoreListAccessControl}'>
		<div id="employeeCompanyTrainingList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeecompanytraining/EmployeeCompanyTraining$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeSkillList"] or ignoreListAccessControl}'>
		<div id="employeeSkillList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeeskill/EmployeeSkill$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeePerformanceList"] or ignoreListAccessControl}'>
		<div id="employeePerformanceList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeeperformance/EmployeePerformance$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeWorkExperienceList"] or ignoreListAccessControl}'>
		<div id="employeeWorkExperienceList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeeworkexperience/EmployeeWorkExperience$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeLeaveList"] or ignoreListAccessControl}'>
		<div id="employeeLeaveList" class="tab-pane fade sublist" refer-name="who">
			<jsp:include page="/coreview/com/skynet/retailscm/employeeleave/EmployeeLeave$List.jsp" >
				<jsp:param name="referName" value="who"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeInterviewList"] or ignoreListAccessControl}'>
		<div id="employeeInterviewList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeeinterview/EmployeeInterview$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeAttendanceList"] or ignoreListAccessControl}'>
		<div id="employeeAttendanceList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeeattendance/EmployeeAttendance$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeQualifierList"] or ignoreListAccessControl}'>
		<div id="employeeQualifierList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeequalifier/EmployeeQualifier$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeEducationList"] or ignoreListAccessControl}'>
		<div id="employeeEducationList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeeeducation/EmployeeEducation$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeAwardList"] or ignoreListAccessControl}'>
		<div id="employeeAwardList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeeaward/EmployeeAward$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeSalarySheetList"] or ignoreListAccessControl}'>
		<div id="employeeSalarySheetList" class="tab-pane fade sublist" refer-name="employee">
			<jsp:include page="/coreview/com/skynet/retailscm/employeesalarysheet/EmployeeSalarySheet$List.jsp" >
				<jsp:param name="referName" value="employee"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["payingOffList"] or ignoreListAccessControl}'>
		<div id="payingOffList" class="tab-pane fade sublist" refer-name="paid_for">
			<jsp:include page="/coreview/com/skynet/retailscm/payingoff/PayingOff$List.jsp" >
				<jsp:param name="referName" value="paidFor"/>
			</jsp:include>
		</div>
	</c:if>

	

</div><!--<div class="tab-content" style="padding-top: 10px">-->




 <!-- /real content -->
          
          
          </div>
        </div><!--  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
        </div><!-- <div class="row"> -->
        </div>
        
  
<div id="footer">
  <div class="col-xs-12 navbar-inverse navbar-fixed-bottom">
  <div class="row" id="bottomNav">
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-home"></i><br/>${userContext.localeMap['@home_page']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>${userContext.localeMap['@message']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>${userContext.localeMap['@message']}</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/showlogin/">
    	<i class="glyphicon glyphicon-user"></i><br>${userContext.localeMap['@log_out']}</a>
    </div>
  </div>
  </div>
</div>   <!-- --><!-- /.footer -->
        
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./bootstrap/jquery.min.js"></script>
    <script src="./bootstrap/jquery-ui.min.js"></script>
    
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="./bootstrap/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./bootstrap/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./bootstrap/ie10-viewport-bug-workaround.js"></script>
    <script src="./scripts/qrcode.js" type="text/javascript"></script>    
    <script>

 	var qrLocaleLabel = "${userContext.localeMap['@qr_code']}";
 	var scanQRTips = "${userContext.localeMap['@qr_scan_to_continue']}";
 	$("a[data-toggle='tab']").removeClass("disabled");
 	
	
</script>
     <script src="./scripts/common.js" type="text/javascript"></script>
   


</body></html>


