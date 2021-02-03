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
    <title>人员调整界面</title>
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
<div class="layui-form layuimini-form" lay-filter="itemEditForm">
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
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="${path}/static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>

    function child(editData) {
        layui.use(['form','laydate'], function () {
            var form = layui.form,
                layer = layui.layer,
                $ = layui.$,
                laydate = layui.laydate;

            laydate.render({
                elem: '#ruZhiRiQi', //指定元素
                trigger : 'click'
            });

            //避免laydate一点就没了
            $(this).removeAttr("lay-key");

            $(function () {
                laydate_default_time();
                select_reload_chengHao();
                console.log(editData);
            });

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
                            form_data_show();
                            layer.close(index);
                        } else {
                            layer.close(index);
                            layer.msg(res.msg);
                        }
                        form.render();
                    }
                })
            }

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

            //监听提交
            form.on('submit(saveBtn)', function (data) {
                var index = layer.load();
                data = data.field;
                data.id = editData.id;
                console.log(data);
                $.ajax({
                    type: 'POST',
                    url: '${path}/renYuan/edit.do',
                    data: JSON.stringify(data),
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
                        }else{
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


            //数据回显
            function form_data_show() {
                var xingBie =  editData.xingBie;
                xingBie = xingBie.trim();
                form.val("itemEditForm", {
                    "xingMing": editData.xingMing
                    , "xingBie": xingBie
                    , "nianLing": editData.nianLing
                    , "ruZhiRiQi": editData.ruZhiRiQi
                    , "chengHao": editData.chengHao
                    , "lianXiDianHua": editData.lianXiDianHua
                });
                return true;
            }

        });

    }

</script>
</body>
</html>
