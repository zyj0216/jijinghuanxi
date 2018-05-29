<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/23
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加楼宇管理员</title>
</head>
<body>
<div id=teacher_add_form">
    <form action="/teacher.do" method="post">
        <input type="hidden" name="method" value="add"/>
        <table style="margin:auto;margin-top: 100px;width: 562px;height: 350px;">
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" name="teacher_uname"/>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <input type="text" name="teacher_password"/>
                </td>
            </tr>
            <tr>
                <td>姓名：</td>
                <td>
                    <input type="text" name="teacher_name"/>
                </td>
            </tr>
            <tr>
                <td>性别：</td>
                <td>
                    <input type="text" name="teacher_sex"/>
                </td>
            </tr>
            <tr>
                <td>电话：</td>
                <td>
                    <input type="text" name="teacher_tel"/>
                </td>
            </tr>
            <tr>
                <td>所负责的楼宇号：</td>
                <td>
                    <input type="text" name="building_id"/>
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
