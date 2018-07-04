<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<c:set var="ctx" value='<%=basePath%>' />
<c:set var="adp" value='${ctx}${path}' />
<script type="text/javascript">
	var ctx = '${ctx}';
	var path = '${path}';
	var adp = ctx + path;

	function to(url) {
		location.href = url;
	}
</script>

