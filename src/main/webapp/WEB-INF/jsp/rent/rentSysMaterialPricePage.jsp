<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/commons/include/get.jsp" %>
<body class="gray-bg">
<div class="wrapper wrapper-content ">
    <div class="col-sm-12">
        <div class="ibox">
            <div class="ibox-body">
                <div id="exampleToolbar" role="group">
                    <button type="button" class="btn btn-primary" onclick="add()">
                        <i class="fa fa-plus" aria-hidden="true"></i>添加
                    </button>
                    <button type="button" class="btn btn-danger" onclick="batchRemove()">
                        <i class="fa fa-trash" aria-hidden="true"></i>删除
                    </button>
                </div>
                <table id="exampleTable" data-mobile-responsive="true">
                </table>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $('#exampleTable').bootstrapTable(
        {
            method: 'get',
            url: "${ctx}/rent/rentSysMaterialPrice/listData.do",
            // cache: false,
            // height: tableHeight,
            striped: true, // 设置为true会有隔行变色效果
            dataType: "json", // 服务器返回的数据类型
            pagination: true, // 设置为true会在底部显示分页条
            singleSelect: false, // 设置为true将禁止多选
            toolbar: '#exampleToolbar',
            pageSize: 10, // 如果设置了分页，每页数据条数
            pageNumber: 1, // 如果设置了分布，首页页码
            clickToSelect: true,
            queryParamsType: null,
            queryParams: function queryParams(params) {
                var param = $("#searchForm").serializeObject();
                param.pageNumber = params.pageNumber;
                param.pageSize = params.pageSize;
                return param;
            },
            sidePagination: "server",//设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置 服务器数据地址（url）或者重写ajax方法
            title: "商机列表",
            columns: [
                {
                    checkbox: true
                },
                {
                    field: 'id',
                    width: 50,
                    title: '序号',
                    align: 'center',
                    valign: 'middle',
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                },
                {
                    field: 'materialCode',
                    title: '物料编码',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '操作',
                    field: 'roleId',
                    align: 'center',
                    formatter: function (value, row, index) {
                        var e = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit(\'' + row.roleId
                            + '\')"><i class="fa fa-edit"></i></a> ';
                        var d = '<a class="btn btn-warning btn-sm " href="#" title="删除"  mce_href="#" onclick="remove(\'' + row.roleId
                            + '\')"><i class="fa fa-remove"></i></a> ';
                        return e + d;
                    }
                }
            ],
            onLoadSuccess: function (data) {
                data.total = data.totalElements;
                data.rows = data.content;
                $('#exampleTable').bootstrapTable('load', data);
            }
        }
    );
</script>
</body>