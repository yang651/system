<%--
  Created by IntelliJ IDEA.
  User: 19855
  Date: 2020/9/28
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <meta charset="utf-8">
    <title>用户管理添加界面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${path}/static/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${path}/static/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">

    <div class="layui-form-item">
        <label class="layui-form-label required">用户名</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="required" lay-reqtext="用户名不可为空" placeholder="请输入用户名"
                   value="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" lay-verify="required" lay-reqtext="用户密码不可为空" placeholder="请输入用户密码"
                   value=""
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="${path}/static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$,
            table = layui.table;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var index = layer.load();
            $.ajax({
                type: 'POST',
                url: '${path}/yongHuSheZhi/add.do',
                data: JSON.stringify(data.field),
                contentType: 'application/json;charset=utf8',
                success: function (res) {
                    if (res.code == 0) {
                        // 关闭加载框
                        layer.close(index);
                        layer.msg(res.msg);
                        setTimeout(function () {
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                            parent.location.reload();
                        }, 500);
                    } else{
                        // 关闭加载框
                        layer.close(index);
                        layer.msg(res.msg);
                    }
                },
                error: function (error) {
                    console.log(error);
                    layer.close(index);
                    layer.msg('系统繁忙');
                }
            });
            return false;
        });

    });
</script>
</body>
</html>
