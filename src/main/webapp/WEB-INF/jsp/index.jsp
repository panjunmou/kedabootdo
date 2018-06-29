<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../../variable.jsp" %>

<jsp:include page="../../webjars/include/ext/extjs5.jsp">
	<jsp:param name="viewName" value="KeDaExt.framework.view.main.MainV" />
</jsp:include>

<script type="text/javascript">
	var _USER_NAME = "<%="科达"%>";
</script>

<script type="text/javascript" src="${js}/jquery-1.11.2.js"></script>
<script type="text/javascript" src="${js}/KeDaStatics.js"></script>
<script type="text/javascript" src="${js}/KeDaDate.js"></script>
<script type="text/javascript" src="${js}/KeDaDateUtil.js"></script>
<script type="text/javascript" src="${js}/KeDaCanvas.js"></script>
<script type="text/javascript" src="${js}/KeDaGantt.js"></script>