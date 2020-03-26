
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <title>公寓管理系统主界面</title>
    <style type="text/css">
    </style>
    <script type="text/javascript" language="JavaScript">
        layui.use('form',function () {
            var form = layui.form;
            form.render();
        });
        function addStudent() {
            console.log("Here");
            var studentID = document.getElementById("studentID").value;
            var studentName = document.getElementById("studentName").value;
            var mradio = document.getElementsByName("sex");
            var sex = "";
            for(var i = 0 ; i < mradio.length; i++){
                if (mradio[i].checked){
                    sex = mradio[i].value;
                }
            }
            var majorName = document.getElementById("majorName").value;
            var grade = document.getElementById("grade").value;
            var classNum = document.getElementById("classNum").value;
            // console.log(studentID);
            // console.log(studentName);
            // console.log(sex);
            // console.log(majorName);
            // console.log(grade);
            // console.log(classNum);
            var xmlHTTP;
            if (window.XMLHttpRequest){
                xmlHTTP = new XMLHttpRequest();
            }else {
                xmlHTTP = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlHTTP.onreadystatechange=function () {
                if (xmlHTTP.status == 200 && xmlHTTP.readyState == 4){
                    if (xmlHTTP.responseText == "0"){
                        alert("添加学生信息成功！");
                        window.location.href = "/addStudent"
                    }else {
                        alert("添加学生信息失败，请重试！")
                    }
                }
            };
            xmlHTTP.open("POST","/addStudentServlet",true);
            xmlHTTP.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=UTF-8');
            xmlHTTP.send("studentID="+studentID+"&studentName="+studentName+"&sex="+sex+"&majorName="+majorName+"&grade="+grade+"&classNum="+classNum);
        }
    </script>
</head>
<%--style="background-image:url(/pictures/login_bg.jpg)"--%>
<body >
<%--<a href="index.jsp">返回</a>--%>
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
    <div class="layui-body" align="center" style="padding: 15px;">

    <form style="width: 400px; margin-top: 110px" class="layui-form layui-form-pane" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">学号：</label>
            <div class="layui-input-block">
                <input id="studentID" type="text" name="studentID" required  lay-verify="required|number" placeholder="请输入学号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-block">
                <input id="studentName" type="text" name="studentName" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别：</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked>
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">系别：</label>
            <div class="layui-input-block">
                <input id="majorName" type="text" name="majorName" required  lay-verify="required" placeholder="请输入专业" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">年级：</label>
            <div class="layui-input-block">
                <select id="grade" name="grade" lay-verify="required">
                    <option value=""></option>
                    <option value="15">15 级</option>
                    <option value="16">16 级</option>
                    <option value="17">17 级</option>
                    <option value="18">18 级</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">班级：</label>
            <div class="layui-input-block">
                <input id="classNum" type="text" name="classNum" required  lay-verify="required" placeholder="请输入班级" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" onclick="addStudent()">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>

</div>
    <div align="center" class="layui-footer">©️太原理工大学公寓管理中心</div>
</div>
</body>
</html>
