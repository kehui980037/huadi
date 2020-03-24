<%@ page import="Bean.StudentBean" %><%--
  Created by IntelliJ IDEA.
  User: binguner
  Date: 2019-01-15
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
    <script src="layui/layui.js"></script>
    <script>
        layui.use('form',function () {
            var form = layui.form;
            form.render();
        });
        
        $(document).ready(function () {
            $("#btn_submit").click(function () {
                var stu_id = document.getElementById("student_id").value;
                var stu_name = document.getElementById("student_name").value;
                var sex_radio = document.getElementsByName("sex");
                var stu_sex = "";
                for(var i = 0 ; i < sex_radio.length; i++){
                    if (sex_radio[i].checked){
                        stu_sex = sex_radio[i].value;
                    }
                }
                var stu_class = document.getElementById("student_class").value;
                var stu_major = document.getElementById("student_major").value;
                var stu_number = document.getElementById("student_number").value;
                var stu_build = document.getElementById("student_build").value;
                var stu_dorm = document.getElementById("student_dorm").value;
                // console.log(stu_id);
                // console.log(stu_name);
                // console.log(stu_sex);
                // console.log(stu_class);
                // console.log(stu_build);
                // console.log(stu_dorm);
                $.ajax({
                    type: "POST",
                    dataType: "text",
                    url: "/handledorm",
                    data: "type=2&stu_id="+stu_id+"&stu_number="+stu_number+"&stu_name="+stu_name+"&stu_sex="+stu_sex+"&stu_class="+stu_class+"&stu_build="+stu_build+"&stu_dorm="+stu_dorm+"&stu_major="+stu_major,
                    success: function (res) {
                        if (res == "0"){
                            layui.use('layer', function(){
                                var layer = layui.layer;
                                layer.open({
                                    title: '修改',
                                    content: '修改学生信息成功!'
                                })
                            });
                        }else {
                            layui.use('layer', function(){
                                var layer = layui.layer;
                                layer.open({
                                    title: '修改',
                                    content: '修改学生信息失败!'
                                })
                            });
                        }
                    },
                    error: function () {
                        layui.use('layer', function(){
                            var layer = layui.layer;
                            layer.open({
                                title: '修改',
                                content: '修改学生信息失败!'
                            })
                        });
                    }
                })
            })
        })
        
    </script>
    <title>编辑学生信息</title>
</head>
<body>
<%
    StudentBean studentBean = (StudentBean) request.getAttribute("bean");
%>
<div align="center" id="div_title" style="margin-top: 60px">
    <h1>修改</h1>
</div>
<br>
<br>
<div align="center" id="div_content">
    <form style="width: 500px" class="layui-form" action="">
        <input id="student_id" hidden type="text" value="<%=studentBean.getId()%>"/>
        <div  class="layui-form-item">
            <label class="layui-form-label">学号：</label>
            <div class="layui-input-block">
                <input disabled="true" id="student_number" type="text" name="student_number" required  lay-verify="required" autocomplete="off" class="layui-input" value="<%=studentBean.getStudentID()%>">
            </div>
        </div>

        <div  class="layui-form-item">
            <label class="layui-form-label">姓名：</label>
            <div class="layui-input-block">
                <input id="student_name" type="text" name="student_name" required  lay-verify="required" autocomplete="off" class="layui-input" value="<%=studentBean.getStudentName()%>">
            </div>
        </div>

        <div class="layui-form-item" align="left">
            <label class="layui-form-label">性别：</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男" checked>
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>

        <div  class="layui-form-item">
            <label class="layui-form-label">专业：</label>
            <div class="layui-input-block">
                <input id="student_major" type="text" name="student_major" required  lay-verify="required" autocomplete="off" class="layui-input" value="<%=studentBean.getMajorName()%>">
            </div>
        </div>

        <div  class="layui-form-item">
            <label class="layui-form-label">班级：</label>
            <div class="layui-input-block">
                <input id="student_class" type="text" name="student_class" required  lay-verify="required" autocomplete="off" class="layui-input" value="<%=studentBean.getClassNum()%>">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">楼号</label>
            <div class="layui-input-block">
                <select id="student_build" name="student_build" lay-verify="required">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                </select>
            </div>
        </div>
        <div  class="layui-form-item">
            <label class="layui-form-label">宿舍：</label>
            <div class="layui-input-block">
                <input id="student_dorm" type="text" name="student_dorm" required  lay-verify="required" autocomplete="off" class="layui-input" value="<%=studentBean.getDormNumber()%>">
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button id="btn_submit" type="button" class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
