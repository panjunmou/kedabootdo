<%@ page import="com.kedacom.security.util.ContextUtil" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="科达科技"/>
    <meta name="description" content=""/>
    <title>总代管理系统首页</title>
    <%@include file="/commons/include/get.jsp" %>

</head>

<body class="fixed-sidebar full-height-layout gray-bg"
      style="overflow: hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close">
            <i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div>
                        <span><img alt="image" class="img-circle" height="60" width="60"
                                   src="${ctx}/images/kedacom_64X64.ico"/></span>
                        <h3 class="" style="color: #ffffff">
                            </i>总代管理系统
                        </h3>
                    </div>
                </li>
                <%--<li>
                    <a href="#">
                        <span class="nav-label">主页</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a id="index001" class="J_menuItem" href="index_v1.html"
                               data-index="0" th:href="@{/main}">了解BootDo
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">
                        <span class="nav-label">基础信息</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#">
                                <span class="nav-label">基础信息1</span>
                                <span class="fa arrow"></span>
                            </a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a class="J_menuItem" href="index_v1.html"
                                       data-index="0" th:href="@{/main}">了解BootDo
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>--%>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation"
                 style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-default "
                       href="#" title="收起菜单">
                        <i class="fa fa-bars"></i>
                    </a>
                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li class="hidden-xs">
                        <a href="javascript:void(0)" target="_Blank" class="">
                            你好,<%=ContextUtil.getCurrentUser().getFullname()%>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row content-tabs">
            <button class="roll-nav roll-left J_tabLeft">
                <i class="fa fa-backward"></i>
            </button>
            <nav class="page-tabs J_menuTabs">
                <div class="page-tabs-content">
                    <a href="javascript:;" class="active J_menuTab"
                       data-id="index_v1.html">首页</a>
                </div>
            </nav>
            <button class="roll-nav roll-right J_tabRight">
                <i class="fa fa-forward"></i>
            </button>
            <div class="btn-group roll-nav roll-right">
                <button class="dropdown J_tabClose" data-toggle="dropdown">
                    关闭操作<span class="caret"></span>
                </button>
                <ul role="menu" class="dropdown-menu dropdown-menu-right">
                    <li class="J_tabShowActive"><a>定位当前选项卡</a></li>
                    <li class="divider"></li>
                    <li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
                    <li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
                </ul>
            </div>
            <a href="/logout" class="roll-nav roll-right J_tabExit"><i
                    class="fa fa fa-sign-out"></i> 退出</a>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe class="J_iframe" name="iframe0" width="100%" height="100%"
                    src="" frameborder="0" data-id="index_v1.html"
                    seamless></iframe>
        </div>
        <div class="footer">
            <div class="pull-right">Footer</div>
        </div>
    </div>
    <!--右侧部分结束-->
</div>




</body>

</html>
