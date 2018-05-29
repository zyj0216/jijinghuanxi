<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/21
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <style>
        #top{
            background-color: #b9def0;
            height: 50px;
        }
        #top h3{
            color:blue;
        }
        #top1{
           background-color: ghostwhite;
            width: 100%;
            height: 18px;
        }
        #top2{
            background-color: #0f0f0f;
            width: 100%;
            height: 1px;
        }
        #left{
            width: 12%;
            height: 835px;
           background-color: #c7ddef;
            float: left;
            padding-right: 20px;
        }
       #left ul li{
             list-style: none;
             color: #0f0f0f;
             background-image:url("img/left2.jpg") ;
             text-align: center;
       }
        #left ul li h4{
            text-align: left;
            size: 15px;
            color: #0f0f0f;
        }
        #right{
            float: right;
            width: 83%;
        }
    </style>
</head>
<body>
<div id="top">
<h3 style="text-align: left">校园宿舍管理系统</h3>
</div>
<div id="top1"></div>
<div id="top2"></div>


<div id="left">
    <div style="background-image: url('img/left1.jpg')" ><h5 style="text-align: center">系统选项</h5></div>
    <ul>
    <li><h6>后台首页</h6></li>
    <li><a href="#" onclick="Teacher()"><h5>楼宇管理员管理</h5>
        <script>
            <%
        String isquery=(String) request.getAttribute("isquery");
        if (isquery.equals("teacher")){%>
            Teacher();
            <%}%>

            function Teacher() {
                $("#right_top_title").empty();
                $("#right_top_title").append("楼宇管理员管理");
                $.ajax({
                   url:"Teacher.jsp",
                    success:function (jsp) {
                        $("#right_content").empty();
                        $("#right_content").append(jsp);
                    }
                });
            }
        </script>
    </a></li>
    <li><a href="#" onclick="Student()"><h5>学生管理</h5>
    <script>
        <%
        if (isquery.equals("student")){%>
        Student();
        <%}%>
        function Student() {
           $("#right_top_title").empty();
           $("#right_top_title").append("学生管理");
           $.ajax({
              url:"Student.jsp",//发送请求的地址
               success:function (jsp) {//success请求成功后调用的回调函数,success是指请求成功并返回信息，jsp是返回的信息
                   $("#right_content").empty();
                   $("#right_content").append(jsp);
               }
           });
        }
    </script>
    </a></li>
    <li><a href="#" onclick="Building()"><h5>楼宇管理</h5>
    <script>
        <%
       if (isquery.equals("building")){%>
        Building();
        <%}%>

        function Building() {
            $("#right_top_title").empty();
            $("#right_top_title").append("楼宇管理");
            $.ajax({
                url:"building.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    </a></li>
    <li><a href="#" onclick="Domitory()"><h5>宿舍管理</h5>
    <script>
        <%
      if (isquery.equals("domitory")){%>
        Domitory();
        <%}%>

        function Domitory() {
            $("#right_top_title").empty();
            $("#right_top_title").append("宿舍管理");
            $.ajax({
                url:"domitory.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    </a></li>
    <li><a href="#" onclick="In()"><h5>学生入住登记</h5>
    <script>
        function In() {
            $("#right_top_title").empty();
            $("#right_top_title").append("学生入住登记");
            $.ajax({
                url:"IN.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    </a></li>
    <li><a href="#" onclick="ChangeDomitory()"><h6>学生寝室调换</h6>
    <script>
        function ChangeDomitory() {
            $("#right_top_title").empty();
            $("#right_top_title").append("学生寝室调换");
            $.ajax({
                url:"change.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }

    </script>
    </a></li>
    <li><a href="#" onclick="Out()"><h5>学生迁出登记</h5>
    <script>
        function Out() {
            $("#right_top_title").empty();
            $("#right_top_title").append("学生迁出登记");
            $.ajax({
                url:"Out.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    </a></li>
    <li><a href="#" onclick="Lack()"><h5>学生缺寝记录</h5>
    <script>
        function Lack() {
            $("#right_top_title").empty();
            $("#right_top_title").append("学生缺寝记录");
            $.ajax({
                url:"admin_tb.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    </a></li>
    <li><a href="#" onclick="OutMessage()"><h5>迁出记录</h5>
    <script>
        function OutMessage() {
            $("#right_top_title").empty();
            $("#right_top_title").append("迁出记录");
            $.ajax({
                url:"out_context.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    </a></li>
    <li><a href="#" onclick="CheckPassword()"><h5>修改密码</h5>
    <script>
        function CheckPassword() {
            $("#right_top_title").empty();
            $("#right_top_title").append("修改密码");
            $.ajax({
                url:"UpdataPwd.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    </a></li>
    <li><a href="#" onclick="LoginOut()"><h5>退出系统</h5></a></li>
    </ul>
</div>
<div id="right">
    <div id="right_do" style="padding-left: 245px">
        <label id="right_top_title"></label>
    </div>
    <hr/>
    <div id="right_content" name="right_content">
        <h3>${message}</h3>
    </div>
</div>
</body>
</html>
