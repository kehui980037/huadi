<%@ page import="Bean.StudentBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: binguner
  Date: 2019-01-11
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询学生信息</title><link rel="stylesheet" href="layui/css/layui.css">
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
        /*#div_query{*/
            /*text-align: center;*/
        /*}*/
        /*#input_query{*/
            /*width: 200px;*/
            /*height: 50px;*/
        /*}*/
        /*#input_search{*/
            /*background-color: aliceblue;*/
            /*height: 50px;*/
        /*}*/
        /*#div_contnet{*/
            /*position: relative;*/
            /*text-align: center;*/
            /*top: 50px;*/
        /*}*/
        /*#table_content{*/
            /*width: 600px;*/
        /*}*/

    </style>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script type="text/javascript" language="JavaScript">
        function edit(stuId){
            console.log('edit!' + stuId);
            window.location.href = "/editstudent?id="+stuId;
        }


        $(document).ready(function () {


            $("#build_numebr").click(function () {
                $("#table_content tbody").html("");
                $("#table_content").hide()
            });

            $("#input_search").click(function () {
                var studentID = document.getElementById("input_query").value;
                var classNum = document.getElementById("build_numebr").value;
                $("#table_content tbody").html("");
                if (studentID.trim() != ""){
                    $.ajax({
                        type: "POST",
                        url: "/getStudentInfo",
                        dataType: "json",
                        data: "studentID="+studentID,
                        success: function (jsonStr) {
                            $("#table_content").show();
                            $.each(jsonStr,function (index,content) {
                                console.log(index +" : " + content);
                                $("#table_content tbody").append("" +
                                    "    <tr> <td>"+content['studentID']+"</td>\n" +
                                    "        <td>"+content['studentName']+"</td>\n" +
                                    "        <td>"+content['sex']+"</td>\n" +
                                    "        <td>"+content['majorName']+"</td>\n" +
                                    "        <td>"+content['grade']+"</td>\n" +
                                    "        <td>"+content['classNum']+"</td>\n" +
                                    "        <td>"+content['buildNumber']+"</td>\n" +
                                    "        <td>"+content['dormNumber']+"</td>\n" +
                                    "            <td><button onclick='edit("+content['studentID']+")' class=\"layui-btn\">\n" +
                                    "        <i class=\"layui-icon\">&#xe642;</i>编辑" +
                                    "    </button></td>\n" +
                                    "</tr>");
                            });
                        },
                        error: function () {
                            alert("查询失败，请重试！");
                        }
                    });
                }
                if(studentID.trim() == ""){
                    $.ajax({
                        type: "POST",
                        url: "/handledorm",
                        dataType: "json",
                        data: "type=5&classNum="+classNum,
                        success: function (jsonStr) {
                            $("#table_content").show();
                            $.each(jsonStr,function (index,content) {
                                console.log(index +" : " + content);
                                $("#table_content tbody").append("" +
                                    "    <tr> <td>"+content['studentID']+"</td>\n" +
                                    "        <td>"+content['studentName']+"</td>\n" +
                                    "        <td>"+content['sex']+"</td>\n" +
                                    "        <td>"+content['majorName']+"</td>\n" +
                                    "        <td>"+content['grade']+"</td>\n" +
                                    "        <td>"+content['classNum']+"</td>\n" +
                                    "        <td>"+content['buildNumber']+"</td>\n" +
                                    "        <td>"+content['dormNumber']+"</td>\n" +
                                    "            <td><button onclick='edit("+content['studentID']+")' class=\"layui-btn\">\n" +
                                    "        <i class=\"layui-icon\">&#xe642;</i>编辑" +
                                    "    </button></td>\n" +
                                    "</tr>");
                            });
                        },
                        error: function () {
                            alert("查询失败，请重试！");
                        }
                    });
                }

            });

        });

    </script>
</head>
<body>
<%
    List<String> list = (List<String>) request.getAttribute("list");
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

    <div class="layui-body" align="center" style="padding: 15px;">
        <div id="div_query" align="center">
            <%--<input id="input_query" type="text" placeholder="请输入学生学号" />--%>
            <%--<input id="input_search" type="submit" value="搜索">--%>
            <select style="width: 95px;" class="layui-btn layui-bg-gray" id="build_numebr" name="build_numebr">

                <%
                    if (null != list){
                        for (String str : list){
                %>
                <option value="<%=str%>"><%=str%></option>
                <%      }
                }
                %>

            </select>
            <div class="layui-input-inline">
                <input id="input_query" style="width: 300px" type="text" name="input_query" required lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input">
            </div>
            <button id="input_search" class="layui-btn">
                <i class="layui-icon">&#xe608;</i> 查询
            </button>
        </div>
        <div id="div_contnet" align="center">

            <table hidden style="width: 900px" id="table_content" class="layui-table">
                <colgroup>
                    <col>
                    <col width="100">
                    <col width="100">
                    <col width="120">
                    <col width="100">
                    <col width="120">
                    <col>
                    <col>
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>系别</th>
                    <th>年级</th>
                    <th>班级</th>
                    <th>楼号</th>
                    <th>寝室号</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>


                </tbody>
            </table>


            <table hidden id="table_conten33t" align="center" border="1">
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>系别</th>
                    <th>年级</th>
                    <th>班级</th>
                    <th>楼号</th>
                    <th>寝室号</th>
                    <th>操作</th>
                </tr>
                <%--<%--%>
                <%--if (null != list) {--%>
                <%--for (StudentBean studentBean : list) {--%>
                <%--%><tr>--%>
                <%--<td><%=studentBean.getStudentID()%></td>--%>
                <%--<td><%=studentBean.getStudentName()%></td>--%>
                <%--<td><%=studentBean.getSex()%></td>--%>
                <%--<td><%=studentBean.getMajorName()%></td>--%>
                <%--<td><%=studentBean.getGrade()%></td>--%>
                <%--<td><%=studentBean.getClassNum()%></td>--%>
                <%--<td><%=studentBean.getBuildNumber()%></td>--%>
                <%--<td><%=studentBean.getDormNumber()%></td>--%>
                <%--<td>编辑</td>--%>
                <%--</tr>--%>
                <%--<%      }--%>
                <%--}%>--%>

            </table>
        </div>
    </div>

    <div align="center" class="layui-footer">©️太原理工大学公寓管理中心</div>


</div>

</body>
</html>
