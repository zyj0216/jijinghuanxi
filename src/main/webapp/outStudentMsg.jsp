<%@ page import="com.zhang.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/24
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生迁出登记</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<% Student student= (Student) request.getAttribute("student");%>
<div id="student_content_table">
    <a style="color: red"><label>此功能只适用于毕业的学生迁出，迁出后将不可恢复！！！确定要迁出学生吗？？？？</label></a>
    <table width="60%" style="text-align: center">
        <thead>
        <tr><td>学号:<%=student.getStudent_id()%></td></tr>
        <tr><td>姓名:<%=student.getStudent_name() %></td></tr>
        <tr><td>班级:<%=student.getStudent_class() %></td></tr>
        <tr><td>目前楼宇:<%=student.getBuilding_id() %></td></tr>
        <tr><td>目前寝室:<%=student.getDomitory_number() %></td></tr>
        <tr><td>迁出备注<input type="text"></td></tr>
        <tr><td><a href="InOut.do?student_id=${student.student_id}&method=out_shanchu">确定迁出</a>&nbsp;&nbsp;<a href="InOut.do?method=sure_out">返回上页</a></td></tr>
        </thead>
    </table>
</div>
</body>
</html>
