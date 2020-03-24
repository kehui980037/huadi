<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

  <title>寝室管理系统</title>

  <link rel="stylesheet" href="layui/css/layui.css" media="all">
  <style type="text/css">

    body{
      background-image:url(pictures/index_bg.jpg);
      background-size:cover;
    }

    #header{
      height:200px;
      font-family:"¿¬Ìå";
      font-size: 50px;
      color:#9F5000;
    }

    #header2 {       height:50px;
      font-family:"楷体";
      font-size: 15px;
      color:#743A3A;
    }
    #div{
      width:1200px
    ;        height:600px;
      margin:5px auto;
    }

    #button{
      color:	white;
      font-size:20px;
    }

    table{
      align:center;
      border-collapse:separate;
      border-spacing:0px 10px;
    }

  </style>

  <script language="JavaScript" type="text/javascript">

    function addStudentPage(){
      window.location.href = "/addStudent";
    }

  </script>

</head>



<body style="background-image:url(pictures/index_bg.jpg)">
<div class="layui-layout layui-layout-admin">
  <div id="div_title" class="layui-header layui-bg-cyan">

    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item"><a href="/logout">退出</a></li>
      <span class="layui-nav-bar" style="left: 135.891px; top: 55px; width: 0px; opacity: 0;"></span></ul>

  </div>

  <div align="center" id="header">
    <br>
    <i class="layui-icon" style="font-size: 140px; color: #fff; color: rgba(255,255,255,.7);">&#xe609;</i>
    <br>
    <b>寝室管家</b>
  </div>

  <div align="center" id="header2">
<br>
<br>
<br>
<br>
    <p>管房无难度，居住有温度。寝室管理先行者，让管理更简单。</p>
  </div>

  <div id="div" align="center">

    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div class="layui-row">

      <div class="layui-col-md3">
        <a href="/addStudent" class="layui-btn layui-btn-lg layui-btn-lg layui-btn-normal layui-btn-radius ">
          <i class="layui-icon">&#xe654;</i>添加学生信息
        </a>
      </div>
      <div class="layui-col-md3">
        <a href="/property" class="layui-btn layui-btn-lg layui-btn-normal layui-btn-radius">
          <i class="layui-icon">&#xe698;</i>查询财产信息
        </a>
      </div>
      <div class="layui-col-md3">
        <a href="/searchstudent" class="layui-btn layui-btn-lg layui-btn-normal layui-btn-radius">
          <i class="layui-icon">&#xe615;</i>查询学生信息
        </a>
      </div>
      <div class="layui-col-md3">
        <a href="/querydorm" class="layui-btn layui-btn-lg layui-btn-normal layui-btn-radius">
          <i class="layui-icon">&#xe68e;</i>查询寝室信息
        </a>
      </div>
    </div>

    <br>
    <br>

    <div class="layui-row">
      <div class="layui-col-md3">
        <a href="/dorm" class="layui-btn layui-btn-lg layui-btn-normal layui-btn-radius">
          <i class="layui-icon">&#xe756;</i>寝室分配功能
        </a>
      </div>
      <div class="layui-col-md3">
        <a href="/goods" class="layui-btn layui-btn-lg layui-btn-normal layui-btn-radius">
          <i class="layui-icon">&#xe642;</i> 货物搬出登记
        </a>
      </div>
      <div class="layui-col-md3">
        <a href="/addvisitor" class="layui-btn layui-btn-lg layui-btn-normal layui-btn-radius">
          <i class="layui-icon">&#xe60e;</i> 外来人员登记
        </a>
      </div>
      <div class="layui-col-md3">
        <a href="/logout" class="layui-btn layui-btn-lg layui-btn-normal layui-btn-radius">
          <i class="layui-icon">&#x1006;</i> 退出管理系统
        </a>
      </div>
    </div>


    <%--<form>--%>
      <%--<table align="center";style="border-collapse:separate;border-spacing:0px 10px;">--%>

        <%--<tr></tr>--%>
        <%--<tr></tr>--%>
        <%--<tr></tr>--%>
        <%--<tr></tr>--%>

        <%--<tr>--%>

          <%--<td>--%>
            <%--<a href="/addStudent" class="layui-btn">--%>
                <%--<i class="layui-icon">&#xe654;</i>添加学生信息--%>
            <%--</a>--%>
          <%--</td>--%>

          <%--<td>--%>
            <%--<a href="/property" class="layui-btn">--%>
                <%--<i class="layui-icon">&#xe698;</i>查询财产信息--%>
            <%--</a>--%>
          <%--</td>--%>

          <%--<td>--%>
            <%--<a href="/searchstudent" class="layui-btn">--%>
                <%--<i class="layui-icon">&#xe615;</i>查询学生信息--%>
            <%--</a>--%>
          <%--</td>--%>

          <%--<td>--%>
            <%--<a href="/querydorm" class="layui-btn">--%>
                <%--<i class="layui-icon">&#xe68e;</i>查询寝室信息--%>
            <%--</a>--%>
          <%--</td>--%>

        <%--</tr>--%>

        <%--<tr>--%>

          <%--<td>--%>
            <%--<a href="/addStudent" class="layui-btn">--%>
              <%--<i class="layui-icon">&#xe756;</i>寝室分配功能--%>
            <%--</a>--%>
          <%--</td>--%>

          <%--<td>--%>
            <%--<a href="/goods" class="layui-btn">--%>
                <%--<i class="layui-icon">&#xe642;</i> 货物搬出登记--%>
            <%--</a>--%>

          <%--</td>--%>

          <%--<td>--%>
            <%--<a href="/addvisitor" class="layui-btn">--%>
                <%--<i class="layui-icon">&#xe60e;</i> 外来人员登记--%>
            <%--</a>--%>
          <%--</td>--%>

          <%--<td>--%>
            <%--<a href="/logout" class="layui-btn">--%>
              <%--<i class="layui-icon">&#x1006;</i> 退出管理系统--%>
            <%--</a>--%>
          <%--</td>--%>
        <%--</tr>--%>
      <%--</table>--%>

    <%--</form>--%>

  </div>



  <div align="center" style="margin-bottom: 0px" class="layui-bg-gray">©️太原理工大学公寓管理中心</div>

</div>


</div>

</body>

</html>