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
    <title>人员管理添加界面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${path}/static/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${path}/static/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }


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
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="xingMing" placeholder="请输入姓名"
                   value="" class="layui-input" id="xingMing" lay-verify="required">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="xingBie" value="男" title="男">
            <input type="radio" name="xingBie" value="女" title="女">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">年龄</label>
        <div class="layui-input-block">
            <input type="text" name="nianLing" id="nianLing" placeholder="请输入年龄"
                   value=""
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">入职日期</label>
        <div class="layui-input-block">
            <input type="text" id="ruZhiRiQi" name="ruZhiRiQi" placeholder="请选择时间" readonly
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">称号</label>
        <div class="layui-input-block">
            <select name="chengHao" id="chengHao">
                <option value="-1">请选择一个称号</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系电话</label>
        <div class="layui-input-block">
            <input type="text" name="lianXiDianHua" placeholder="请输入联系电话" lay-verify="phone"
                   value=""
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" style="margin-top: 10px">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="${path}/static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table','laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$,
            laydate = layui.laydate,
            table = layui.table;

        laydate.render({
            elem: '#ruZhiRiQi' //指定元素
        });


        $(function () {
            select_reload_chengHao();
            laydate_default_time();
        });

        function laydate_default_time() {
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            if(month < 10){
                month = "0" + month;
            }
            $("#ruZhiRiQi").val(year + '-' + month + '-' + day);
        }

        function select_reload_chengHao() {
            var index = layer.load();
            $.ajax({
                type: 'POST',
                url: '${path}/renYuan/getChengHaoList.do',
                success: function (res) {
                    if (res.code == 0) {
                        $.each(res.list, function (i, val) {
                            $('#chengHao').append('<option value="' + val.chengHao + '">' + val.chengHao + '</option>');
                        })
                        layer.close(index);
                    } else {
                        layer.close(index);
                        layer.msg(res.msg);
                    }
                    form.render();
                }
            })
        }

        function isInteger(obj) {
            return /^\d+$/.test(obj);
        }


        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var nianLing = $("#nianLing").val();
            if(!isInteger(nianLing)){
                layer.msg('请正确的填写年龄哦!');
                return false;
            }
            if($("#chengHao").val() == -1){
                layer.msg('请选择一个初始称号!');
                return false;
            }
            var index = layer.load();
            $.ajax({
                type: 'POST',
                url: '${path}/renYuan/add.do',
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
                    } else {
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
