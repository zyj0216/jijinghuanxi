<%@ page import="com.zhang.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/25
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生寝室调换</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<% Student student= (Student) request.getAttribute("student");%>
<div id="student_content_table">
    <table width="60%" style="text-align: center">
        <thead>
        <tr><td>学号:<%=student.getStudent_id()%></td></tr>
        <tr><td>姓名:<%=student.getStudent_name() %></td></tr>
        <tr><td>班级:<%=student.getStudent_class() %></td></tr>
        <tr><td>调换到楼宇:<input type="text" name="domitory_number"></td></tr>
        <tr><td>调换到寝室:<input type="text" name="building_id"></td></tr>
        <tr><td><a href="changeDomitory.do?domitory_number=${"input:text[name='domitory_number']"}&building_id=${"input:text[name='building_id']"}&method=sure_change">确定调换</a>&nbsp;&nbsp;<a href="changeDomitory.do?method=fanhuishangye">返回上页</a></td></tr>
        </thead>
    </table>
</div>
</body>
