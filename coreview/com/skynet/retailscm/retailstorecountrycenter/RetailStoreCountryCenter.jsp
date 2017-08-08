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

<c:set var="ownerBeanName" value="retailStoreCountryCenter" scope="request"/>
<c:set var="ownerClassName" value="RetailStoreCountryCenter" scope="request"/>

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
	 
	<c:if test='${(not empty userContext.accessTokens["reportList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#reportList" class="disabled"> ${userContext.localeMap['report']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["catalogList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#catalogList" class="disabled"> ${userContext.localeMap['catalog']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["retailStoreProvinceCenterList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#retailStoreProvinceCenterList" class="disabled"> ${userContext.localeMap['retail_store_province_center']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["retailStoreList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#retailStoreList" class="disabled"> ${userContext.localeMap['retail_store']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["retailStoreMemberList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#retailStoreMemberList" class="disabled"> ${userContext.localeMap['retail_store_member']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["goodsSupplierList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#goodsSupplierList" class="disabled"> ${userContext.localeMap['goods_supplier']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["supplyOrderList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#supplyOrderList" class="disabled"> ${userContext.localeMap['supply_order']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["retailStoreOrderList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#retailStoreOrderList" class="disabled"> ${userContext.localeMap['retail_store_order']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["warehouseList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#warehouseList" class="disabled"> ${userContext.localeMap['warehouse']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["transportFleetList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#transportFleetList" class="disabled"> ${userContext.localeMap['transport_fleet']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["accountSetList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#accountSetList" class="disabled"> ${userContext.localeMap['account_set']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["levelOneDepartmentList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#levelOneDepartmentList" class="disabled"> ${userContext.localeMap['level_one_department']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["skillTypeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#skillTypeList" class="disabled"> ${userContext.localeMap['skill_type']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["responsibilityTypeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#responsibilityTypeList" class="disabled"> ${userContext.localeMap['responsibility_type']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["terminationReasonList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#terminationReasonList" class="disabled"> ${userContext.localeMap['termination_reason']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["terminationTypeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#terminationTypeList" class="disabled"> ${userContext.localeMap['termination_type']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["occupationTypeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#occupationTypeList" class="disabled"> ${userContext.localeMap['occupation_type']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["leaveTypeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#leaveTypeList" class="disabled"> ${userContext.localeMap['leave_type']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["salaryGradeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#salaryGradeList" class="disabled"> ${userContext.localeMap['salary_grade']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["interviewTypeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#interviewTypeList" class="disabled"> ${userContext.localeMap['interview_type']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["trainingCourseTypeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#trainingCourseTypeList" class="disabled"> ${userContext.localeMap['training_course_type']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["publicHolidayList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#publicHolidayList" class="disabled"> ${userContext.localeMap['public_holiday']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["employeeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#employeeList" class="disabled"> ${userContext.localeMap['employee']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["instructorList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#instructorList" class="disabled"> ${userContext.localeMap['instructor']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["companyTrainingList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#companyTrainingList" class="disabled"> ${userContext.localeMap['company_training']}</a></li>
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
	
	   
	<c:set var="retailStoreCountryCenter" value="${ result}" scope="request" />
<jsp:include page="/coreview/com/skynet/retailscm/retailstorecountrycenter/RetailStoreCountryCenter$Summary.jsp" />

	
</div>

	
	

	







	





	</div><!-- end of <div id="summary" class="tab-pane fade in active">-->

	

		<c:if test='${not empty userContext.accessTokens["reportList"] or ignoreListAccessControl}'>
		<div id="reportList" class="tab-pane fade sublist" refer-name="owner">
			<jsp:include page="/coreview/com/skynet/retailscm/report/Report$List.jsp" >
				<jsp:param name="referName" value="owner"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["catalogList"] or ignoreListAccessControl}'>
		<div id="catalogList" class="tab-pane fade sublist" refer-name="owner">
			<jsp:include page="/coreview/com/skynet/retailscm/catalog/Catalog$List.jsp" >
				<jsp:param name="referName" value="owner"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["retailStoreProvinceCenterList"] or ignoreListAccessControl}'>
		<div id="retailStoreProvinceCenterList" class="tab-pane fade sublist" refer-name="country">
			<jsp:include page="/coreview/com/skynet/retailscm/retailstoreprovincecenter/RetailStoreProvinceCenter$List.jsp" >
				<jsp:param name="referName" value="country"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["retailStoreList"] or ignoreListAccessControl}'>
		<div id="retailStoreList" class="tab-pane fade sublist" refer-name="retail_store_country_center">
			<jsp:include page="/coreview/com/skynet/retailscm/retailstore/RetailStore$List.jsp" >
				<jsp:param name="referName" value="retailStoreCountryCenter"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["retailStoreMemberList"] or ignoreListAccessControl}'>
		<div id="retailStoreMemberList" class="tab-pane fade sublist" refer-name="owner">
			<jsp:include page="/coreview/com/skynet/retailscm/retailstoremember/RetailStoreMember$List.jsp" >
				<jsp:param name="referName" value="owner"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["goodsSupplierList"] or ignoreListAccessControl}'>
		<div id="goodsSupplierList" class="tab-pane fade sublist" refer-name="belong_to">
			<jsp:include page="/coreview/com/skynet/retailscm/goodssupplier/GoodsSupplier$List.jsp" >
				<jsp:param name="referName" value="belongTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["supplyOrderList"] or ignoreListAccessControl}'>
		<div id="supplyOrderList" class="tab-pane fade sublist" refer-name="buyer">
			<jsp:include page="/coreview/com/skynet/retailscm/supplyorder/SupplyOrder$List.jsp" >
				<jsp:param name="referName" value="buyer"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["retailStoreOrderList"] or ignoreListAccessControl}'>
		<div id="retailStoreOrderList" class="tab-pane fade sublist" refer-name="seller">
			<jsp:include page="/coreview/com/skynet/retailscm/retailstoreorder/RetailStoreOrder$List.jsp" >
				<jsp:param name="referName" value="seller"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["warehouseList"] or ignoreListAccessControl}'>
		<div id="warehouseList" class="tab-pane fade sublist" refer-name="owner">
			<jsp:include page="/coreview/com/skynet/retailscm/warehouse/Warehouse$List.jsp" >
				<jsp:param name="referName" value="owner"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["transportFleetList"] or ignoreListAccessControl}'>
		<div id="transportFleetList" class="tab-pane fade sublist" refer-name="owner">
			<jsp:include page="/coreview/com/skynet/retailscm/transportfleet/TransportFleet$List.jsp" >
				<jsp:param name="referName" value="owner"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["accountSetList"] or ignoreListAccessControl}'>
		<div id="accountSetList" class="tab-pane fade sublist" refer-name="country_center">
			<jsp:include page="/coreview/com/skynet/retailscm/accountset/AccountSet$List.jsp" >
				<jsp:param name="referName" value="countryCenter"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["levelOneDepartmentList"] or ignoreListAccessControl}'>
		<div id="levelOneDepartmentList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/retailscm/levelonedepartment/LevelOneDepartment$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["skillTypeList"] or ignoreListAccessControl}'>
		<div id="skillTypeList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/skilltype/SkillType$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["responsibilityTypeList"] or ignoreListAccessControl}'>
		<div id="responsibilityTypeList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/responsibilitytype/ResponsibilityType$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["terminationReasonList"] or ignoreListAccessControl}'>
		<div id="terminationReasonList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/terminationreason/TerminationReason$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["terminationTypeList"] or ignoreListAccessControl}'>
		<div id="terminationTypeList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/terminationtype/TerminationType$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["occupationTypeList"] or ignoreListAccessControl}'>
		<div id="occupationTypeList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/occupationtype/OccupationType$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["leaveTypeList"] or ignoreListAccessControl}'>
		<div id="leaveTypeList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/leavetype/LeaveType$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["salaryGradeList"] or ignoreListAccessControl}'>
		<div id="salaryGradeList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/salarygrade/SalaryGrade$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["interviewTypeList"] or ignoreListAccessControl}'>
		<div id="interviewTypeList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/interviewtype/InterviewType$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["trainingCourseTypeList"] or ignoreListAccessControl}'>
		<div id="trainingCourseTypeList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/trainingcoursetype/TrainingCourseType$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["publicHolidayList"] or ignoreListAccessControl}'>
		<div id="publicHolidayList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/publicholiday/PublicHoliday$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["employeeList"] or ignoreListAccessControl}'>
		<div id="employeeList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/employee/Employee$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["instructorList"] or ignoreListAccessControl}'>
		<div id="instructorList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/instructor/Instructor$List.jsp" >
				<jsp:param name="referName" value="company"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["companyTrainingList"] or ignoreListAccessControl}'>
		<div id="companyTrainingList" class="tab-pane fade sublist" refer-name="company">
			<jsp:include page="/coreview/com/skynet/retailscm/companytraining/CompanyTraining$List.jsp" >
				<jsp:param name="referName" value="company"/>
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


