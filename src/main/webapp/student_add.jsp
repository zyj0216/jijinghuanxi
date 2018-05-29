<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/23
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生用户添加</title>
</head>
<body>
<div id="student_add_form">
    <form action="/student.do" method="post">
        <input type="hidden" name="method" value="add"/>
        <table style="margin:auto;margin-top: 100px;width: 562px;height: 350px;">
            <tr>
                <td>宿舍号：</td>
                <td>
                    <input type="text" name="domitory_number"/>
                </td>
            </tr>
            <tr>
                <td>楼宇管理员编号：</td>
                <td>
                    <input type="text" name="teacher_id"/>
                </td>
            </tr>
            <tr>
                <td>楼宇号：</td>
                <td>
                    <input type="text" name="building_id"/>
                </td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" name="student_username"/>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="text" name="student_password"/>
                </td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td>
                    <input type="text" name="student_name"/>
                </td>
            </tr>
            <tr>
                <td>电话：</td>
                <td>
                    <input type="text" name="student_tel"/>
                </td>
            </tr>
            <tr>
                <td>班级：</td>
                <td>
                    <input type="text" name="student_class"/>
                </td>
            </tr>
            <tr>
                <td>状态（入住1/0未入住）：</td>
                <td>
                    <input type="radio" value="0" name="student_state" checked="checked"/>未入住
                    <input type="radio" value="1" name="student_state"/>入住
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="提交"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
