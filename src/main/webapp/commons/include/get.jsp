<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="basePath" value="${ctx}${__basePath}"/>
<spring:htmlEscape defaultHtmlEscape="true"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>

<link rel="icon" href="${ctx}/favicon.ico" type="image/x-icon"/>
<link rel="shortcut icon" href="${ctx}/favicon.ico" type="image/x-icon"/>
<link href="${ctx}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/main.css" rel="stylesheet" type="text/css"/>

<link href="${ctx}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${ctx}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="${ctx}/css/plugins/toastr/toastr.min.css" rel="stylesheet">
<link href="${ctx}/css/animate.css" rel="stylesheet">
<link href="${ctx}/css/style.css?v=4.1.0" rel="stylesheet">

<!-- 全局js -->
<script src="${ctx}/js/jquery-1.11.3.min.js"></script>
<script src="${ctx}/js/plugins/bootstrap/bootstrap.min.js"></script>
<script src="${ctx}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${ctx}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${ctx}/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="${ctx}/js/app.js"></script>
<script src="${ctx}/js/contabs.js"></script>
<!-- 第三方插件 -->
<script src="${ctx}/js/plugins/pace/pace.min.js"></script>
<!-- Toastr script -->
<script src="${ctx}/js/plugins/toastr/toastr.min.js"></script>

<script type="text/javascript">
    var __ctx = '${ctx}';
    var __basePath = '${basePath}';

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
