<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/include/get.jsp" %>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox-content">
                <form class="form-horizontal m-t" id="signupForm">
                    <input id="userId" name="userId" type="hidden"> <input
                        id="menuIds" name="menuIds" type="hidden">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">角色名：</label>
                        <div class="col-sm-8">
                            <input id="roleName" name="roleName" class="form-control"
                                   type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">备注：</label>
                        <div class="col-sm-8">
                            <input id="remark" name="remark" class="form-control"
                                   type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8 col-sm-offset-3">
                            <button type="submit" class="btn btn-primary">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

