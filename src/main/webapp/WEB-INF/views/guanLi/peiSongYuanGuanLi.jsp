<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>角色管理</title>
    <link rel="icon" href="${path}/static/images/favicon.ico">
    <link rel="stylesheet" href="${path}/static/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${path}/static/css/public.css" media="all">
    <style>
        /*检测项目对齐*/
        #xiangMuDiv .layui-form-checkbox span {
            min-width: 90px;
            font-size: 10px;
        }

        /*检测项目上下间距*/
        .layui-form-checkbox[lay-skin=primary] {
            height: 18px;
            margin-top: 5px;
        }

        .layui-form-checkbox[lay-skin=primary] {
            height: 18px;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">姓 名</label>
                            <div class="layui-input-inline">
                                <input type="text" name="peiSongYuanName" id="peiSongYuanName" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">称号</label>
                            <div class="layui-input-inline">
                                <input type="text" name="chengHao" id="chengHao" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">负责区域</label>
                            <div class="layui-input-inline">
                                <input type="text" name="fuZeQuYu" id="fuZeQuYu" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button type="submit" class="layui-btn" lay-submit
                                    lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加</button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

    </div>
</div>

<script src="${path}/static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>

<script>
    layui.use(['form', 'jquery', 'layer', 'tree','table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            tree = layui.tree,
            table = layui.table,
            layer = layui.layer;

        table.render({
            elem: '#currentTableId',
            url: '${path}/peiSongYuan/getList.do',
            method: 'POST',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print'],
            parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.msg, //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.list //解析数据列表
                };
            }, cols: [[
                {type: 'numbers',title: '序号',width: 50,align: "center"},
                {field: 'xingMing', minWidth: 100, title: '姓名',align: "center"},
                {field: 'xingBie', minWidth: 100, title: '性别',align: "center"},
                {field: 'nianLing', minWidth: 100, title: '年龄',align: "center"},
                {field: 'ruZhiRiQi', minWidth: 100, title: '入职日期',align: "center"},
                {field: 'jiLuRiQi', minWidth: 100, title: '记录日期',align: "center"},
                {field: 'chengHao', minWidth: 100, title: '称号',align: "center"},
                {field: 'lianXiDianHua', minWidth: 100, title: '联系电话',align: "center"},
                {field: 'zhuangTai', minWidth: 100, title: '状态',align: "center"},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', fixed: 'right', align: "center"}
            ]], limits: [10, 15, 20, 25, 50, 100, 500],
            limit: 15,
            page: true,
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var data = data.field;
            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    'xingMing': data.peiSongYuanName,
                    'chengHao': data.chengHao,
                    'fuZeQuYu': data.fuZeQuYu
                }
            }, 'data');
            return false;
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加参数',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['80%', '80%'],
                    offset: 't',
                    content: '${path}/to_jueSeSheZhi_add.do',
                    success: function () {
                        // layer.full(index);
                    }
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                var itemNames = [];
                $.each(data, function (i, d) {
                    itemNames[i] = d.groupName;
                });
                if(itemNames.length == 0){
                    layer.msg('请先选择至少一个！');
                    return false;
                }
            }
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {
                var index = layer.open({
                    title: '编辑角色',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['80%', '80%'],
                    offset: 't',
                    content: '${path}/to_jueSeSheZhi_edit.do',
                    success: function (lyero, index) {
                        // layer.full(index);
                        // 获取子页面的iframe
                        var iframe = window['layui-layer-iframe' + index];
                        // 向子页面的全局函数child传参
                        iframe.child(data);
                    },
                });
                return false;
            } else if (obj.event === 'delete') {
                layer.confirm('确定删除此角色吗？', {offset: '100px', anim: 6, title: '提示'}, function (index) {
                    $.ajax({
                        type: 'POST',
                        url: '${path}/jueSeSheZhi/delete.do',
                        contentType: 'application/json;charset=utf8',
                        data: JSON.stringify(data),
                        success: function (res) {
                            if (res.code == 0) {
                                layer.msg(res.msg);
                                obj.del();
                                layer.close(index);
                            }else{
                                // 关闭加载框
                                layer.close(index);
                                layer.msg(res.msg);
                            }
                        }
                    });
                });
            }
        });

    });
</script>
</body>
</html>
