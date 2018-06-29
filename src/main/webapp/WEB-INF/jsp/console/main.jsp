<%@page import="org.springframework.security.authentication.AuthenticationServiceException"%>
<%@page import="org.springframework.security.authentication.AccountExpiredException"%>
<%@page import="org.springframework.security.authentication.DisabledException"%>
<%@page import="org.springframework.security.authentication.LockedException"%>
<%@page import="org.springframework.security.authentication.BadCredentialsException"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.kedacom.core.utils.ApplicationUtil"%>
<%@page import="java.util.Properties"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="org.springframework.security.web.WebAttributes"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="科达科技" />
<meta name="description" content="" />
<title>日报系统首页</title>
<%@include file="/commons/include/get.jsp" %>
<script type="text/javascript">
    if(top!=this){//当这个窗口出现在iframe里，表示其目前已经timeout，需要把外面的框架窗口也重定向登录页面
        top.location='<%=request.getContextPath()%>/platform/console/main.do';
    }
	//布局 
    $(document).ready(function () {
		$("#layout1").ligerLayout({
			leftWidth : 200,
			allowTopResize : false,
			topHeight : 55
		});
	    $("#navigation").kdAccordionTree({url:"${ctx}/platform/console/getSysRolResTreeData.do?id=${currentUser.userId}"});

	});
</script>
</head>

<body class="kd-property">
	<div id="layout1">
		<!--头部-->
		<div position="top">
			<div class="kd-property-header rel ovh">
				<div class="keda-logo abs">
					<a href="#" target="_blank" title="科达科技日报管理系统"> <img
						width="176" height="14" src="${ctx}/images/kd-property-logo.png"
						alt="科达科技日报管理系统" /></a>
				</div>
                <!--提示：系统将于今天15:00进行维护升级，预计17:00恢复运营，届时给您带来不便还请谅解!-->
				<div class="tip abs"><marquee width="400" scrollamount=3></marquee></div>
				<div class="user-setting abs">
					<ul class="setting-list">
						<li><p class="user-msg" >${currentUser.fullname}</p></li>
                        <sec:authorize ifAllGranted="ROLE_SUPER">
                            <li>
                                <a class="settings" href="#" onclick="switchUser()">切换用户</a>
                                <div id="switchUserDiv" style="display: none;">
                                    <div>
                                        请输入要切换的账户：<input type="text" id="switchUserAccount" style="width: 200px" class="form-control"/>
                                    </div>
                                </div>
                            </li>
                            <script type="text/javascript">
                                function switchUser() {
                                    $.ligerDialog.open({
                                        title: '切换用户：',
                                        target: $("#switchUserDiv"),
                                        height: 120,
                                        width: 400,
                                        buttons: [{
                                            text: '切换',
                                            onclick: function (item, dialog) {
                                                top.location='<%=request.getContextPath()%>/j_spring_security_switch_user?j_username=' + $('#switchUserAccount').val();
                                                dialog.close();
                                            }
                                        }], isResize: true,
                                        onLoaded: function () {

                                        }
                                    });
                                }
                            </script>
                        </sec:authorize>
                        <sec:authorize ifAllGranted="ROLE_PREVIOUS_ADMINISTRATOR">
                            <li>
                                <a class="settings" href="<%=request.getContextPath()%>/j_spring_security_exit_user" >退出切换</a>
                            </li>
                        </sec:authorize>
						<li><a class="quit" href="${ctx}/logout">退出</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<!--主体-->
		<div position="left" id="navigation" class="kd-property-nav"></div>
		<div position="center">
			<div id="kdPageLoading" class="kd-Loading">loading...</div>
			<iframe id="kdUIFrameWindow" src="${ctx}/dailyReport/report/initMyWeekReport.do" frameborder="0" width="100%" height="100%"></iframe>
		</div>
		<!--<div position="right"></div>-->
		
		<!--底部-->
		<!--<div position="bottom"></div>-->
	</div>
</body>
</html>
