<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<spring:htmlEscape defaultHtmlEscape="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>

<link rel="icon" href="${ctx}/favicon.ico" type="image/x-icon"/>
<link rel="shortcut icon" href="${ctx}/favicon.ico" type="image/x-icon"/>
<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/main.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
    __ctx = '${ctx}';

    function back() {
        window.history.go(-1);
    }

    var Keybord = {
        ENTER: 13
    }

</script>
<style type="text/css">
    #gridRedForZxq {
        color: red;
    }

    .gridBlueZxq {
        color: blue;
        font-weight: bold
    }
</style>
