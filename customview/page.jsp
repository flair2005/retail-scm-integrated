<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="row">
	
	<div class="col-xs-12 col-md-12">
	<c:set var="now" value="<%=new java.util.Date()%>" />

<p>Formatted Date (1): <fmt:formatDate pattern="yyyy-MM-dd" value="${now}" /></p>
	</div>
</div>