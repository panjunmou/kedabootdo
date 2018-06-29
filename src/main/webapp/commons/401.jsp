<%@page import="org.springframework.security.access.AccessDeniedException"  pageEncoding="UTF-8" isErrorPage="true" %>
<%
	String basePath=request.getContextPath();
	AccessDeniedException ex=(AccessDeniedException)request.getAttribute("ex");
	
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/main.css" rel="stylesheet" type="text/css"/>
</head>
<body class="s401">
    <div class="mtop">
    </div>
    <div class="mmid"></div>
    <div class="content">
        <div>您的账户在本系统中不存在，请隔天再试或联系管理员！
        </div>
        <div class="bline">
            <a href="javascript:" class="btn btn-warning">&nbsp;返&nbsp;&nbsp;回&nbsp;</a>

        </div>
        
    </div>
</body>
</html>