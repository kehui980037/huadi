<%@ page import="java.util.List" %>
<%@ page import="Bean.PropertyBean" %><%--
  Created by IntelliJ IDEA.
  User: binguner
  Date: 2019-01-13
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询财产信息</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script src="layui/layui.js"></script>
    <style type="text/css">
        /*#div_title{*/
            /*height: 150px;*/
        /*}*/
        /*#title{*/
            /*font-size: 30px;*/
            /*position: relative;*/
            /*top: 50%;*/
        /*}*/
    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script type="text/javascript" language="JavaScript">



        function deleteThisProperty(propertyID,button) {

            var index = $(button).parent().parent().prevAll().length+1;

            $.ajax({
                type: "POST",
                dataType: "text",
                url: "/handleProperty",
                data: "type=1&propertyID="+propertyID,
                success:function (res) {
                    if (res == "0") {
                        console.log("delete success")
                        $("#table_content tr:eq("+index+")").remove();
                    }else {
                        console.log("delete failed")
                    }
                },
                error:function () {
                    console.log("delete failed")
                }
            })
        }

        function clearData(){
            document.getElementById("input_buildNumber").value="";
            document.getElementById("input_goodName").value="";
            document.getElementById("input_price").value="";
        }

        $(document).ready(function () {
            $("#commit_value").click(function () {
                var buildNumber = document.getElementById("input_buildNumber").value;
                var goodName = document.getElementById("input_goodName").value;
                var price = document.getElementById("input_price").value;
                console.log(buildNumber);
                console.log(goodName);
                console.log(price);
                $.ajax({
                    type: "POST",
                    dataType: "text",
                    url: "/handleProperty",
                    data: "type="+0+"&buildNumber=" + buildNumber + "&goodName=" + goodName + "&price=" + price,
                    success: function (responseText) {
                        if (responseText == "0"){
                            alert("信息录入成功！");
                            clearData();
                            $("#table_content tbody").append(
                                " <tr>\n" +
                                "         <td>"+buildNumber+"</td>\n" +
                                "         <td>"+goodName+"</td>\n" +
                                "         <td>"+price+"</td>\n" +
                                "         <td><button>删除</button></td>\n"+
                                "</tr>"
                            );
                        } else {
                            alert("信息录入失败！")
                        }
                    },
                    error: function () {

                    }
                })
            })

        })

    </script>
</head>
<body>
<%
    List<PropertyBean> list = (List<PropertyBean>) request.getAttribute("list");
%>

<div class="layui-layout layui-layout-admin">

    <div id="div_title" class="layui-header layui-bg-cyan">

        <div class="layui-logo">
            <button onclick="javascript:history.back(-1);" class="layui-btn layui-btn-sm  layui-bg-cyan"  style="height: 100%; width: 100%">
                <i class="layui-icon layui-icon-return ">&nbsp返回主界面</i>
            </button>
        </div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="/logout">退出</a></li>
            <span class="layui-nav-bar" style="left: 135.891px; top: 55px; width: 0px; opacity: 0;"></span></ul>

    </div>
    <%--<div id=div1 class="layui-side layui-bg-black">--%>

        <%--<div class="layui-side-scroll layui-bg-cyan">--%>

            <%--<ul class="layui-nav layui-nav-tree" lay-filter="test">--%>
                <%--<li class="layui-nav-item layui-bg-cyan"><a href="/AddStudent">录入学生信息</a></li>--%>
                <%--<li class="layui-nav-item layui-bg-cyan "><a href="/dormdis">寝室分配</a></li>--%>
                <%--<li class="layui-nav-item layui-bg-cyan "><a href="/querystudent">查询学生信息</a></li>--%>
                <%--<li class="layui-nav-item layui-bg-cyan "><a href="/querydorm">查询寝室信息</a></li>--%>
                <%--<li class="layui-nav-item layui-bg-cyan"><a href="/property">查询财产信息</a></li>--%>
                <%--<li class="layui-nav-item layui-bg-cyan "> <a href="">登记信息</a></li>--%>
                <%--<li class="layui-nav-item layui-bg-cyan"><a href="/addvisitor">外来人员登记</a></li>--%>
                <%--<li class="layui-nav-item layui-bg-cyan" ><a href="/goods">退出系统</a></li>--%>
                <%--<span class="layui-nav-bar" style="top: 67.5px; height: 0px; opacity: 0;"></span>--%>
            <%--</ul>--%>

        <%--</div>--%>
    <%--</div>--%>
    <div id=div1 class="layui-side layui-bg-black">

        <div class="layui-side-scroll layui-bg-cyan">

            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-bg-cyan"><a href="/addStudent">录入学生信息</a></li>
                <li class="layui-nav-item layui-bg-cyan "><a href="/dorm">寝室分配</a></li>
                <li class="layui-nav-item layui-bg-cyan "><a href="/searchstudent">查询学生信息</a></li>
                <li class="layui-nav-item layui-bg-cyan "><a href="/querydorm">查询寝室信息</a></li>
                <li class="layui-nav-item layui-bg-cyan"><a href="/property">查询财产信息</a></li>
                <li class="layui-nav-item layui-bg-cyan "> <a href="/goods">货物搬出登记</a></li>
                <li class="layui-nav-item layui-bg-cyan"><a href="/addvisitor">外来人员登记</a></li>
                <li class="layui-nav-item layui-bg-cyan" ><a href="/logout">退出系统</a></li>
                <span class="layui-nav-bar" style="top: 67.5px; height: 0px; opacity: 0;"></span>
            </ul>

        </div>
    </div>


    <div class="layui-body" align="center" style="padding: 15px;">
        <div id="div_search" align="center">
            <%--<table align="center" border="1">--%>
            <%--<tr>--%>
            <%--<td align="right">楼号：</td>--%>
            <%--<td><input id="input_buildNumber" type="number" name="buildNumber"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td align="right">财产名称：</td>--%>
            <%--<td><input id="input_goodName" type="text" name="goodName"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td align="right">价值：</td>--%>
            <%--<td><input id="input_price" type="text" name="price"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>--%>
            <%--<button id="commit_value">提交</button>--%>
            <%--</td>--%>
            <%--<td align="right">--%>
            <%--<button id="reset_value">重置</button>--%>
            <%--</td>--%>
            <%--</tr>--%>
            <%--</table>--%>


            <form class="layui-form layui-form-pane" action="" style="width: 400px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">楼号</label>
                    <div class="layui-input-block">
                        <input id="input_buildNumber" type="text" name="title" required  lay-verify="required" placeholder="请输入楼号" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">财产名称</label>
                    <div class="layui-input-block">
                        <input id="input_goodName" type="text" name="title" required  lay-verify="required" placeholder="请输入财产名称" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">价值</label>
                    <div class="layui-input-block">
                        <input id="input_price" type="text" name="title" required  lay-verify="required" placeholder="请输入价值" autocomplete="off" class="layui-input">
                    </div>
                </div>


                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button id="commit_value" type="button" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button id="reset_value" type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
        <div id="div_content" align="center">
            <%--<table align="center" border="1" id="table_content">--%>
            <%--<tr>--%>
            <%--<th>楼号</th>--%>
            <%--<th>财产名称</th>--%>
            <%--<th>价值</th>--%>
            <%--<th>操作</th>--%>
            <%--</tr>--%>
            <%--<%--%>
            <%--if (null != list) {--%>
            <%--for (PropertyBean propertyBean : list) {--%>
            <%--%>--%>
            <%--<tr>--%>
            <%--<td><%=propertyBean.getBuildNumber()%></td>--%>
            <%--<td><%=propertyBean.getGoodName()%></td>--%>
            <%--<td><%=propertyBean.getPrice()%></td>--%>
            <%--<td><button onclick="deleteThisProperty(<%=propertyBean.getId()%>,this)">删除</button></td>--%>
            <%--</tr>--%>

            <%--<%       }--%>
            <%--}--%>
            <%--%>--%>
            <%--</table>--%>

            <table class="layui-table" id="table_content" style="width: 700px;" align="center">
                <colgroup>
                    <col>
                    <col>
                    <col>
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>楼号</th>
                    <th>财产名称</th>
                    <th>价值</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (null != list) {
                        for (PropertyBean propertyBean : list) {
                %>
                <tr>
                    <td><%=propertyBean.getBuildNumber()%></td>
                    <td><%=propertyBean.getGoodName()%></td>
                    <td><%=propertyBean.getPrice()%></td>
                    <td><button onclick="deleteThisProperty(<%=propertyBean.getId()%>,this)">删除</button></td>
                </tr>

                <%       }
                }
                %>
                </tbody>
            </table>

        </div>
    </div>

    <div align="center" class="layui-footer">©️太原理工大学公寓管理中心</div>


</div>



</body>
</html>
