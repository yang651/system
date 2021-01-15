<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<html>
<head>
    <title>统一权限管理</title>
    <link rel="icon" href="${path}/static/images/favicon.ico">
    <link rel="stylesheet" href="${path}/static/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${path}/static/css/public.css" media="all">
    <style>

        .layui-form-checkbox[lay-skin=primary] {
            height: 18px;
            margin-top: 5px;
        }

        .layui-form-checkbox[lay-skin=primary] {
            height: 18px;
        }

        /*检测项目对齐*/
        #jueSeDiv .layui-form-checkbox span {
            min-width: 90px;
            font-size: 10px;
        }

        /*检测项目对齐*/
        #quanXianDiv .layui-form-checkbox span {
            min-width: 90px;
            font-size: 10px;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <div class="layui-row layui-col-space10">
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md6">
                <fieldset class="table-search-fieldset">
                    <legend style="color: #2D93CA;font-size: 20px">用户角色分配</legend>
                    <blockquote class="layui-elem-quote layui-quote-nm">
                        <form class="layui-form" id="form_yongHu" lay-filter="form_yongHu">
                            <div class="layui-form-item">
                                <div class="layui-input-inline">
                                    <select name="yongHu" id="select_yongHu" lay-filter="select_yongHu">
                                        <option value="-1">请选择用户</option>
                                    </select>
                                </div>
                                <div class="layui-btn-group">
                                    <button type="button" class="layui-btn" style="background-color:#2D93CA "
                                            id="jsfptj">
                                        <i class="layui-icon">&#xe642;</i>提交修改
                                    </button>
                                </div>
                            </div>
                        </form>
                    </blockquote>
                    <fieldset class="table-search-fieldset">
                        <form class="layui-form" lay-filter="form_jueSeFenPei" id="form_jueSeFenPei">
                            <div class="layui-input-block" id="jueSeDiv" style="margin-left: 10px">
                            </div>
                        </form>
                    </fieldset>
                </fieldset>
            </div>
            <div class="layui-col-xs12 layui-col-sm12 layui-col-md6">
                <fieldset class="table-search-fieldset">
                    <legend style="color: #c7bb00;font-size: 20px">角色权限分配</legend>
                    <blockquote class="layui-elem-quote layui-quote-nm">
                        <form class="layui-form" id="form_JueSe" lay-filter="form_JueSe">
                            <div class="layui-form-item">
                                <div class="layui-input-inline">
                                    <select name="jueSe" id="select_jueSe" lay-filter="select_jueSe">
                                        <option value="-1">请选择角色</option>
                                    </select>
                                </div>
                                <div class="layui-btn-group">
                                    <button type="button" class="layui-btn" style="background-color: #c7bb00"
                                            id="qxfptj">
                                        <i class="layui-icon">&#xe642;</i>提交修改
                                    </button>
                                </div>
                            </div>
                        </form>
                    </blockquote>
                    <fieldset class="table-search-fieldset">
                        <form class="layui-form" lay-filter="form_quanXianFenPei" id="form_quanXianFenPei">
                            <div class="layui-input-block" id="quanXianDiv" style="margin-left: 10px">
                            </div>
                        </form>
                    </fieldset>
                </fieldset>
            </div>
        </div>
    </div>
</div>
<script src="${path}/static/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'jquery', 'layer', 'tree', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            tree = layui.tree,
            table = layui.table,
            layer = layui.layer;


        //给用户分配角色提交
        $("#jsfptj").click(function () {
            if ($("#select_yongHu").val() == -1) {
                return layer.msg('请先选择用户', {offset: '100px'});
            }
            //用户数据
            var userData = form.val('form_yongHu');
            var index = layer.load(0, {offset: '100px'});
            //角色列表
            var jueSeArray = [];
            $.each(form.val('form_jueSeFenPei'), function (i) {
                jueSeArray.push(i.substring(5, i.length - 1));
            });
            userData.jueSeList = jueSeArray;
            $.ajax({
                type: 'POST',
                data: JSON.stringify(userData),
                contentType: 'application/json;charset=utf8',
                url: '${path}/tongYiQuanXianGuanLi/fenPeiGroup.do',
                success: function (res) {
                    var code = res.code;
                    layer.close(index);
                    if (code == 0) {
                        layer.msg(res.msg, {offset: '100px'});
                    } else {
                        layer.msg(res.msg, {offset: '100px', anim: 6});
                    }
                },
                error: function (error) {
                    layer.close(index);
                    console.log(error);
                }
            });
            return false;
        })

        //给角色分配权限提交
        $("#qxfptj").click(function () {
            if ($("#select_jueSe").val() == -1) {
                return layer.msg('请先选择用户', {offset: '100px'});
            }
            //用户数据
            var userData = form.val('form_JueSe');
            var index = layer.load(0, {offset: '100px'});
            //角色列表
            var quanXianArray = [];
            $.each(form.val('form_quanXianFenPei'), function (i) {
                quanXianArray.push(i.substring(5, i.length - 1));
            });
            userData.quanXianList = quanXianArray;
            $.ajax({
                type: 'POST',
                data: JSON.stringify(userData),
                contentType: 'application/json;charset=utf8',
                url: '${path}/tongYiQuanXianGuanLi/fenPeiQuanXian.do',
                success: function (res) {
                    var code = res.code;
                    layer.close(index);
                    if (code == 0) {
                        layer.msg(res.msg, {offset: '100px'});
                    } else {
                        layer.msg(res.msg, {offset: '100px', anim: 6});
                    }
                },
                error: function (error) {
                    layer.close(index);
                    console.log(error);
                }
            });
            return false;

        })

        form.on('select(select_yongHu)', function (data) {
            formRest('#form_jueSeFenPei');
            $.ajax({
                type: 'POST',
                url: '${path}/tongYiQuanXianGuanLi/getGroupByUserId.do',
                data: {"userId": data.value},
                success: function (res) {
                    $.each(res.list, function (i, val) {
                        $('input[name="jsck[' + val.groupId + ']"]').prop("checked", true);
                    });
                    form.render();
                },
                error: function (error) {
                    console.log(error);
                }
            });
        });


        form.on('select(select_jueSe)', function (data) {
            formRest('#form_quanXianFenPei');
            $.ajax({
                type: 'POST',
                url: '${path}/tongYiQuanXianGuanLi/getQuanXianByGroupId.do',
                data: {"groupId": data.value},
                success: function (res) {
                    $.each(res.list, function (i, val) {
                        $('input[name="qxck[' + val.quanXianId + ']"]').prop("checked", true);
                    });
                    form.render();
                },
                error: function (error) {
                    console.log(error);
                }
            });
        });

        $(function () {
            //渲染界面所有下拉数据及检测项目集合
            select_reload("getAllData.do");
        });

        //下拉菜单渲染。dom对象；遍历对象
        function select_reload(requestName) {
            var index = layer.load(0, {offset: '100xp'});
            $.ajax({
                type: 'POST',
                url: '${path}/tongYiQuanXianGuanLi/' + requestName,
                success: function (res) {
                    reload_select_yongHu(res.userList);
                    reload_select_jueSe(res.groupSeList);
                    reload_jueSe(res.groupSeList);
                    reload_quanXian(res.quanXianList)
                    form.render();
                    layer.close(index);
                },
                error: function (error) {
                    console.log(error);
                    layer.close(index);
                }
            });
        }

        function reload_select_yongHu(data) {
            $.each(data, function () {
                $('#select_yongHu').append('<option value="' + this.userId + '">' + this.username + '</option>');
            });
        }

        function reload_select_jueSe(data) {
            $.each(data, function () {
                $('#select_jueSe').append('<option value="' + this.groupId + '">' + this.groupName + '</option>');
            });
        }

        //渲染角色div
        function reload_jueSe(data) {
            $.each(data, function () {
                $('#jueSeDiv').append('<input type="checkbox" style="min-width: 70px" lay-skin="primary" name="jsck[' + this.groupId + ']" title="' + this.groupName + '">');
            });
        }

        //渲染权限div
        function reload_quanXian(data) {
            $.each(data, function () {
                $('#quanXianDiv').append('<input type="checkbox" style="min-width: 70px" lay-skin="primary" name="qxck[' + this.quanXianId + ']" title="' + this.quanXianName + '">');
            });
        }

        //表单数据清空
        function formRest(element) {
            $(element)[0].reset();
        }


    })
</script>
</body>
</html>
