<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/25
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生寝室调换</title>
</head>
<body>
<h1>${message}</h1>
<div id="domitory_out_form">
    <form action="/changeDomitory.do" method="post">
        <input type="hidden" name="method" value="selectStudentById"/>
        <table style="margin:auto;margin-top: 100px;width: 562px;height: 350px;">
            <tr>
                <td>请输入要调换寝室的学生号：</td>
                <td>
                    <input type="text" name="student_id"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="确定"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
