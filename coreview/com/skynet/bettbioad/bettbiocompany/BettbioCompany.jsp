<%@ page import='java.util.*,com.skynet.bettbioad.*'%>

<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<!DOCTYPE html>
<html lang="en" slick-uniqueid="3"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
    
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

<c:set var="ownerBeanName" value="bettbioCompany" scope="request"/>
<c:set var="ownerClassName" value="BettbioCompany" scope="request"/>

<div id="msg"></div>

<div class="row">
	<ul class="nav nav-tabs" id="navi-tabs">
	  <li class="active"><a data-toggle="tab" href="#summary" class="disabled"><i class="fa  fa-home"></i> ${userContext.localeMap['@summary']}</a></li>
	 
	<c:if test='${(not empty userContext.accessTokens["adEventList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#adEventList" class="disabled"> ${userContext.localeMap['ad_event']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["productClassList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#productClassList" class="disabled"> ${userContext.localeMap['product_class']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["researchAreaList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#researchAreaList" class="disabled"> ${userContext.localeMap['research_area']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["customerCompanyList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#customerCompanyList" class="disabled"> ${userContext.localeMap['customer_company']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["contentRepositoryList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#contentRepositoryList" class="disabled"> ${userContext.localeMap['content_repository']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["researchInstituteList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#researchInstituteList" class="disabled"> ${userContext.localeMap['research_institute']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["refrigeratorList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#refrigeratorList" class="disabled"> ${userContext.localeMap['refrigerator']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["adMachineApkList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#adMachineApkList" class="disabled"> ${userContext.localeMap['ad_machine_apk']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["refrigeratorInOrgnizationListList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#refrigeratorInOrgnizationListList" class="disabled"> ${userContext.localeMap['refrigerator_in_orgnization_list']}</a></li>
	</c:if>
 
	</ul>

</div>
<div class="tab-content" style="padding-top: 10px" id='tab-content'>
<div id="summary" class="tab-pane fade in active">
<div class="row">
	
	<div class="col-xs-12 col-md-12">
	
	</div>
</div>

<div class="row" desc="show parent objects">
	
	   
	<c:set var="bettbioCompany" value="${ result}" scope="request" />
<jsp:include page="/coreview/com/skynet/bettbioad/bettbiocompany/BettbioCompany$Summary.jsp" />

	
</div>

	
	

	







	

<div class="row" desc="action list">
	
	<div class="col-xs-12 col-md-12 btn-toolbar">
	
	
	

	</div>
</div> <!--<div class="row" desc="action list">-->



	</div><!-- end of <div id="summary" class="tab-pane fade in active">-->

	

		<c:if test='${not empty userContext.accessTokens["adEventList"] or ignoreListAccessControl}'>
		<div id="adEventList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/bettbioad/adevent/AdEvent$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["productClassList"] or ignoreListAccessControl}'>
		<div id="productClassList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/bettbioad/productclass/ProductClass$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["researchAreaList"] or ignoreListAccessControl}'>
		<div id="researchAreaList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/bettbioad/researcharea/ResearchArea$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["customerCompanyList"] or ignoreListAccessControl}'>
		<div id="customerCompanyList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/bettbioad/customercompany/CustomerCompany$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["contentRepositoryList"] or ignoreListAccessControl}'>
		<div id="contentRepositoryList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/bettbioad/contentrepository/ContentRepository$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["researchInstituteList"] or ignoreListAccessControl}'>
		<div id="researchInstituteList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/bettbioad/researchinstitute/ResearchInstitute$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["refrigeratorList"] or ignoreListAccessControl}'>
		<div id="refrigeratorList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/bettbioad/refrigerator/Refrigerator$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["adMachineApkList"] or ignoreListAccessControl}'>
		<div id="adMachineApkList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/bettbioad/admachineapk/AdMachineApk$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["refrigeratorInOrgnizationListList"] or ignoreListAccessControl}'>
		<div id="refrigeratorInOrgnizationListList" class="tab-pane fade sublist" refer-name="belongs_to">
			<jsp:include page="/coreview/com/skynet/bettbioad/refrigeratorinorgnizationlist/RefrigeratorInOrgnizationList$List.jsp" >
				<jsp:param name="referName" value="belongsTo"/>
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
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-home"></i><br/>主页</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>消息</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./secUserManager/home/"><i class="glyphicon glyphicon-envelope"></i><br>消息</a>
    </div>
    <div class="col-xs-3 text-center">
    	<a href="./navi/index/secUserManager/home/">
    	<i class="glyphicon glyphicon-user"></i><br>我</a>
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


