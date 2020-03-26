<%@ page import="java.util.List" %>
<%@ page import="Bean.DormBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公寓信息</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script src="layui/layui.js"></script>
    <script>


        $(document).ready(function () {

            $("#build_numebr").click(function () {
               $("#table_content tbody").html("");
               $("#table_content").hide();
               $("#table_content_show_name tbody").html("");
               $("#table_content_show_name").hide();
            }),

            $("#input_search").click(function () {
                $("#table_content tbody").html("")
                $("#table_content_show_name tbody").html("")
                var buildNumber = document.getElementById("build_numebr").value;
                var dormNumber = document.getElementById("input_query").value;
                if (dormNumber.trim() != ""){
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url: "/handledorm",
                        data: "type="+4+"&buildNumber="+buildNumber+"&dormNumber="+dormNumber,
                        success: function (resJson) {
                            $("#table_content").hide();
                            $("#table_content_show_name").show();
                            $.each(resJson,function (index,context) {
                                //console.log(index + " : " + context['studentName']);
                                $("#table_content_show_name").append("<tr><td>"+context['dormNumber']+"</td>\n" +
                                    "        <td>"+context['buildNumber']+"</td>\n" +
                                    "        <td>"+context['studentID']+"</td>\n" +
                                    "        <td>"+context['classNum']+"</td>\n" +
                                    "        <td>"+context['studentName']+"</td></tr>")
                            })
                        },
                        error: function () {

                        }
                    })
                }
                if(dormNumber.trim() == ""){
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url: "/handledorm",
                        data: "type="+3+"&buildNumber="+buildNumber,
                        success: function (resjson) {
                            $("#table_content_show_name").hide();
                            $("#table_content").show();
                            $.each(resjson,function (index,context) {
                                console.log(index+" : "+context['dormNumber'])
                                $("#table_content").append("<tr><td>"+context['dormNumber']+"</td>\n" +
                                    "            <td>"+context['buildNumber']+"</td>\n" +
                                    "            <td>"+context['floorNumber']+"</td>\n" +
                                    "            <td>"+context['peopleCount']+"</td></tr>");

                            })
                        },
                        error: function () {

                        }
                    })
                }

            })
        })
    </script>
    <style>

    </style>
</head>
<body>
<%
    //List<DormBean> list = (List<DormBean>) request.getAttribute("list");
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
        <div id="div_title_" style="margin-top: 50px;">
            <h1 id="title" align="center">寝室信息查询</h1>
        </div>
        <div id="div_query" align="center" >

            <select style="width: 80px;" class="layui-btn layui-bg-gray" id="build_numebr" name="build_numebr">
                <option value="1">1 号楼</option>
                <option value="2">2 号楼</option>
                <option value="3">3 号楼</option>
                <option value="4">4 号楼</option>
                <option value="5">5 号楼</option>
                <option value="6">6 号楼</option>
                <option value="7">7 号楼</option>
                <option value="8">8 号楼</option>
                <option value="9">9 号楼</option>
            </select>

            <div class="layui-input-inline">
                <input id="input_query" style="width: 300px" type="text" name="input_query" required lay-verify="required" placeholder="请输入寝室号" autocomplete="off" class="layui-input">
            </div>
            <button id="input_search" class="layui-btn">
                <i class="layui-icon">&#xe608;</i> 查询
            </button>
        </div>
        <div id="div_contnet" align="center">


            <table hidden style="width: 700px" id="table_content" class="layui-table">
                <colgroup>
                    <col>
                    <col>
                    <col>
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>寝室号</th>
                    <th>楼号</th>
                    <th>学号</th>
                    <th>人数</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>


            <table hidden style="width: 700px" id="table_content_show_name" class="layui-table">
                <colgroup>
                    <col>
                    <col>
                    <col>
                    <col>
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>寝室号</th>
                    <th>楼号</th>
                    <th>学号</th>
                    <th>班级</th>
                    <th>学生名单</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

        </div>
    </div>

    <div align="center" class="layui-footer">©️太原理工大学公寓管理中心</div>


</div>


</body>
</html>
