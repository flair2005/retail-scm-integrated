<%@ page import='java.util.*,com.terapico.bbt.*'%>

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

<c:set var="ownerBeanName" value="communityUser" scope="request"/>
<c:set var="ownerClassName" value="CommunityUser" scope="request"/>

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
	 
	<c:if test='${(not empty userContext.accessTokens["patientInfoList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#patientInfoList" class="disabled"> ${userContext.localeMap['patient_info']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["userSkillList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#userSkillList" class="disabled"> ${userContext.localeMap['user_skill']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["messageFilterList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#messageFilterList" class="disabled"> ${userContext.localeMap['message_filter']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["userMessageList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#userMessageList" class="disabled"> ${userContext.localeMap['user_message']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["taskList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#taskList" class="disabled"> ${userContext.localeMap['task']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["taskLikeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#taskLikeList" class="disabled"> ${userContext.localeMap['task_like']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["taskFavoriteList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#taskFavoriteList" class="disabled"> ${userContext.localeMap['task_favorite']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["taskReplyList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#taskReplyList" class="disabled"> ${userContext.localeMap['task_reply']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["taskReplyLikeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#taskReplyLikeList" class="disabled"> ${userContext.localeMap['task_reply_like']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["threadList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#threadList" class="disabled"> ${userContext.localeMap['thread']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["threadReplyList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#threadReplyList" class="disabled"> ${userContext.localeMap['thread_reply']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["threadRegistrationList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#threadRegistrationList" class="disabled"> ${userContext.localeMap['thread_registration']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["threadLikeList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#threadLikeList" class="disabled"> ${userContext.localeMap['thread_like']}</a></li>
	</c:if>
	<c:if test='${(not empty userContext.accessTokens["threadFavoriteList"]) or ignoreListAccessControl}'>
			<li><a data-toggle="tab" href="#threadFavoriteList" class="disabled"> ${userContext.localeMap['thread_favorite']}</a></li>
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
	
	   
	<c:set var="communityUser" value="${ result}" scope="request" />
<jsp:include page="/coreview/com/terapico/bbt/communityuser/CommunityUser$Summary.jsp" />

	
</div>

	
	

	<div class="row">
<c:set var="community" value="${ result.community}" scope="request" />
<jsp:include page="/coreview/com/terapico/bbt/community/Community$Info.jsp" />

</div>








	





	</div><!-- end of <div id="summary" class="tab-pane fade in active">-->

	

		<c:if test='${not empty userContext.accessTokens["patientInfoList"] or ignoreListAccessControl}'>
		<div id="patientInfoList" class="tab-pane fade sublist" refer-name="user">
			<jsp:include page="/coreview/com/terapico/bbt/patientinfo/PatientInfo$List.jsp" >
				<jsp:param name="referName" value="user"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["userSkillList"] or ignoreListAccessControl}'>
		<div id="userSkillList" class="tab-pane fade sublist" refer-name="user">
			<jsp:include page="/coreview/com/terapico/bbt/userskill/UserSkill$List.jsp" >
				<jsp:param name="referName" value="user"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["messageFilterList"] or ignoreListAccessControl}'>
		<div id="messageFilterList" class="tab-pane fade sublist" refer-name="user">
			<jsp:include page="/coreview/com/terapico/bbt/messagefilter/MessageFilter$List.jsp" >
				<jsp:param name="referName" value="user"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["userMessageList"] or ignoreListAccessControl}'>
		<div id="userMessageList" class="tab-pane fade sublist" refer-name="receiver">
			<jsp:include page="/coreview/com/terapico/bbt/usermessage/UserMessage$List.jsp" >
				<jsp:param name="referName" value="receiver"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["taskList"] or ignoreListAccessControl}'>
		<div id="taskList" class="tab-pane fade sublist" refer-name="creator">
			<jsp:include page="/coreview/com/terapico/bbt/task/Task$List.jsp" >
				<jsp:param name="referName" value="creator"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["taskLikeList"] or ignoreListAccessControl}'>
		<div id="taskLikeList" class="tab-pane fade sublist" refer-name="replier">
			<jsp:include page="/coreview/com/terapico/bbt/tasklike/TaskLike$List.jsp" >
				<jsp:param name="referName" value="replier"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["taskFavoriteList"] or ignoreListAccessControl}'>
		<div id="taskFavoriteList" class="tab-pane fade sublist" refer-name="favorite_user">
			<jsp:include page="/coreview/com/terapico/bbt/taskfavorite/TaskFavorite$List.jsp" >
				<jsp:param name="referName" value="favoriteUser"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["taskReplyList"] or ignoreListAccessControl}'>
		<div id="taskReplyList" class="tab-pane fade sublist" refer-name="replier">
			<jsp:include page="/coreview/com/terapico/bbt/taskreply/TaskReply$List.jsp" >
				<jsp:param name="referName" value="replier"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["taskReplyLikeList"] or ignoreListAccessControl}'>
		<div id="taskReplyLikeList" class="tab-pane fade sublist" refer-name="replier">
			<jsp:include page="/coreview/com/terapico/bbt/taskreplylike/TaskReplyLike$List.jsp" >
				<jsp:param name="referName" value="replier"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["threadList"] or ignoreListAccessControl}'>
		<div id="threadList" class="tab-pane fade sublist" refer-name="creator">
			<jsp:include page="/coreview/com/terapico/bbt/thread/Thread$List.jsp" >
				<jsp:param name="referName" value="creator"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["threadReplyList"] or ignoreListAccessControl}'>
		<div id="threadReplyList" class="tab-pane fade sublist" refer-name="replier">
			<jsp:include page="/coreview/com/terapico/bbt/threadreply/ThreadReply$List.jsp" >
				<jsp:param name="referName" value="replier"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["threadRegistrationList"] or ignoreListAccessControl}'>
		<div id="threadRegistrationList" class="tab-pane fade sublist" refer-name="participant">
			<jsp:include page="/coreview/com/terapico/bbt/threadregistration/ThreadRegistration$List.jsp" >
				<jsp:param name="referName" value="participant"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["threadLikeList"] or ignoreListAccessControl}'>
		<div id="threadLikeList" class="tab-pane fade sublist" refer-name="replier">
			<jsp:include page="/coreview/com/terapico/bbt/threadlike/ThreadLike$List.jsp" >
				<jsp:param name="referName" value="replier"/>
			</jsp:include>
		</div>
	</c:if>
	<c:if test='${not empty userContext.accessTokens["threadFavoriteList"] or ignoreListAccessControl}'>
		<div id="threadFavoriteList" class="tab-pane fade sublist" refer-name="favorite_user">
			<jsp:include page="/coreview/com/terapico/bbt/threadfavorite/ThreadFavorite$List.jsp" >
				<jsp:param name="referName" value="favoriteUser"/>
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


