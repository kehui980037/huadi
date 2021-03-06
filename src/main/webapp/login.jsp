
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script src="layui/layui.js"></script>
    <title>公寓管理系统注册界面</title>
    <style type="text/css">
        #div{
            width:1200px;
            height:550px;
            margin:5px auto;
        }
        #header{
            font-family:"楷体";
            font-size: 55px;
            color:#9F5000;
        }
        #button{
            color:white;
            font-size: 20px;
        }
        table{
            align:center;
            border-collapse:separate;
            border-spacing:0px 10px;
        }
        body{
            background-image:url(pictures/login_bg.jpg);
            background-size:cover;
        }
    </style>
    <script type="text/javascript" language="JavaScript">
        function doLogin() {
            var xmlHttp;
            var username = document.getElementById("id_username").value;
            var password = document.getElementById("id_password").value;
            if(window.XMLHttpRequest){
                xmlHttp = new XMLHttpRequest();
            }else {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            // 1 0
            xmlHttp.open("POST","/login",true);
            xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=UTF-8');
            xmlHttp.onreadystatechange=function () {
                if (xmlHttp.readyState==4 && xmlHttp.status == 200){
                    if (xmlHttp.responseText == "1"){
                        alert("用户名或密码出错，请重试或注册！");
                    }else {
                        window.location.href="/index.jsp";
                    }
                }
            };
            xmlHttp.send("username="+username+"&password="+password);
        }
    </script>
</head>

<!--背景图片-->
<body style="background-image:url(pictures/login_bg.jpg)">

<!--标题-->
<%--<%
    boolean answer = (boolean) request.getAttribute("answer");
    if ( answer == false){
    //System.out.println("answer is : " + answer);
%>
<script type="text/javascript" language="JavaScript">
    alert("用户名或密码错误，请重试；")
</script>
<%
    }
%>--%>
<br><br><br><br>
<div align="center" id="header"><b>公寓管理系统登录界面</b>
</div>
<!--登陆输入框-->
<div id="div" align="center">

    <br><br><br><br><br>
    <br><br><br><br><br>
    <%--<form name="my_form" method="post">--%>
        <%--<table align="center";style="border-collapse:separate;border-spacing:0px 10px;">--%>
            <%--<tr></tr>--%>
            <%--<tr></tr>--%>
            <%--<tr></tr>--%>
            <%--<tr align=center>--%>
                <%--<th style="font-family: KaiTi;font-size: 25px;color:#3C3C3C;">账号: &nbsp</th>--%>
                <%--<td>--%>
                    <%--<input type="text" style="height:30px" name="username" id="id_username" placeholder="请输入您的学号" size="35">--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--<tr align=center></tr>--%>
            <%--<tr align=center>--%>
                <%--<th style="font-family: KaiTi;font-size: 25px;color:#3C3C3C">密码: &nbsp</th>--%>
                <%--<td>--%>
                    <%--<input type="text" style="height:30px" name="password" id="id_password" placeholder="请输入您的密码" size="35">--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</table>--%>
        <%--<br>--%>
        <%--<center>--%>
            <%--<input type="submit"  style="height:30px;width:60px" name="submit" onclick="doLogin()" value="登陆" >&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp--%>
            <%--<input type="reset" style="height:30px;width:60px" name=“reset” value="重置">--%>
        <%--</center>--%>


    <form class="layui-form layui-form-pane " style="width: 400px;padding: 30px">


        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-block">
                <input id="id_username" type="text" name="title" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" id="id_password" name="password" required lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
            </div>
        </div>





        <div class="layui-form-item">
            <div class="layui-input-block">
                <button onclick="doLogin()" type="button" class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                <a href="regist.jsp" name="注册"><button type="button" class="layui-btn" lay-submit lay-filter="formDemo">注册</button></a>
            </div>
        </div>
    </form>



    <%--</form>--%>
</div>

<!--页尾文本-->
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div align="center" class="" id="button">©太原理工大学公寓管理中心</div>

</body>
</html>