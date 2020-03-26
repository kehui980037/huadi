<%@ page import="java.util.List" %>
<%@ page import="Bean.GoodsBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>货物搬出登记</title>
    <link rel="stylesheet" href="layui/css/layui.css">
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

        function deleteThisData(dataId,button) {
            console.log("here");
            $.ajax({
                type: "POST",
                dataType: "text",
                url: "/handleGoods",
                data: "type=1&dataId="+dataId,
                success: function (res) {
                    if (res == "0"){
                        //console.log("delete success")
                        var index = $(button).parent().parent().prevAll().length+1;
                        $("#table_content tr:eq("+index+")").remove();
                    }
                },
                error: function () {
                }
            })
        }

        function clearDatas(){
            document.getElementById("buildNumber").value="";
            document.getElementById("goodsName").value="";
            document.getElementById("goodsDate").value="";
            document.getElementById("goodsDetail").value="";
        }

        $(document).ready(function () {
            $("#goods_commit").click(function () {
                var buildNumber = document.getElementById("buildNumber").value;
                var goodsName = document.getElementById("goodsName").value;
                var goodsDate = document.getElementById("goodsDate").value;
                var goodsDetail = document.getElementById("goodsDetail").value;
                // console.log(buildNumber);
                // console.log(goodsName);
                // console.log(goodsDate);
                // console.log(goodsDetail);
                $.ajax({
                    type: "POST",
                    url: "/handleGoods",
                    dadaType: "text",
                    data: "type=0&buildNumber="+buildNumber+"&goodsName="+goodsName+"&goodsDate="+goodsDate+"&goodsDetail="+goodsDetail,
                    success: function (restext) {
                        console.log(restext);
                        if (restext == "0"){
                            clearDatas();
                            alert("数据添加成功！");
                            $("#table_content tbody").append(
                                " <tr>\n" +
                                "         <td>"+buildNumber+"</td>\n" +
                                "         <td>"+goodsName+"</td>\n" +
                                "         <td>"+goodsDate+"</td>\n" +
                                "         <td>"+goodsDetail+"</td>\n" +
                                "         <td><button>删除</button></td>\n"+
                                "</tr>"
                            );
                        } else {
                            alert("数据添加失败！")
                        }
                    },
                    error: function () {
                        alert("数据添加失败！")
                    }
                })
            })
        })
    </script>
</head>
<body>
<%
    List<GoodsBean> list = (List<GoodsBean>) request.getAttribute("list");
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
        <div id="div_add_record" align="center">

            <%--<table id="table_add_record" align="center">--%>
            <%--<tr>--%>
            <%--<td>楼号：</td>--%>
            <%--<td><input type="text" id="buildNumber"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>物品名称：</td>--%>
            <%--<td><input type="text" id="goodsName"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>借出日期：</td>--%>
            <%--<td><input type="date" id="goodsDate"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td>详情：</td>--%>
            <%--<td><input type="text" id="goodsDetail"></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
            <%--<td><button id="goods_commit">提交</button></td>--%>
            <%--<td><button id="goods_reset">重置</button></td>--%>
            <%--</tr>--%>
            <%--</table>--%>

            <form class="layui-form" action="" style="width: 500px">
                <div class="layui-form-item">
                    <label class="layui-form-label">楼号</label>
                    <div class="layui-input-block">
                        <input id="buildNumber" type="text" name="title" required  lay-verify="required" placeholder="请输入楼号" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">物品名称</label>
                    <div class="layui-input-block">
                        <input id="goodsName" type="text" name="title" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                    </div>
                </div>


                <div class="layui-form-item">
                    <label class="layui-form-label">借出日期</label>
                    <div class="layui-input-block">
                        <input id="goodsDate" type="text" name="title" required  lay-verify="required" placeholder="请输入时间" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">详情</label>
                    <div class="layui-input-block">
                        <input id="goodsDetail" type="text" name="title" required  lay-verify="required" placeholder="请输入详情" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button id="goods_commit" type="button" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button id="goods_reset" type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>


        </div>
        <div id="div_content" align="center">
            <%--<table align="center" id="table_content" border="1">--%>
            <%--<tr>--%>
            <%--<td>楼号</td>--%>
            <%--<td>物品名称</td>--%>
            <%--<td>借出日期</td>--%>
            <%--<td>详情</td>--%>
            <%--<td>操作</td>--%>
            <%--</tr>--%>
            <%--<%--%>
            <%--if (null != list){--%>
            <%--for (GoodsBean goodsBean:list){--%>
            <%--%>--%>
            <%--<tr>--%>
            <%--<td><%=goodsBean.getBuildNumber()%></td>--%>
            <%--<td><%=goodsBean.getGoodsName()%></td>--%>
            <%--<td><%=goodsBean.getGoodsDate()%></td>--%>
            <%--<td><%=goodsBean.getGoodsDetail()%></td>--%>
            <%--<td><button onclick="deleteThisData(<%=goodsBean.getId()%>,this)">删除</button></td>--%>
            <%--</tr>--%>

            <%--<%        }--%>
            <%--}--%>
            <%--%>--%>
            <%--</table>--%>


            <table id="table_content" class="layui-table" style="width: 800px">
                <colgroup>
                    <col>
                    <col>
                    <col>
                    <col>
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>楼号</th>
                    <th>物品名称</th>
                    <th>借出日期</th>
                    <th>详情</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (null!=list){
                        for(GoodsBean goodsBean : list){
                %>
                <tr>
                    <td><%=goodsBean.getBuildNumber()%></td>
                    <td><%=goodsBean.getGoodsName()%></td>
                    <td><%=goodsBean.getGoodsDate()%></td>
                    <td><%=goodsBean.getGoodsDetail()%></td>
                    <td><button onclick="deleteThisData(<%=goodsBean.getId()%>,this)">删除</button></td>
                </tr>
                <%}
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
