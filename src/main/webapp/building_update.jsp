<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/23
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改楼宇信息</title>
</head>
<body>
<div id="student_update_form">
    <form action="/building.do" method="post">
        <input type="hidden" name="method" value="update"/>
        <table style="margin:auto;margin-top: 100px;width: 562px;height: 350px;">
            <tr>
                <td>楼宇编号：</td>
                <td>
                    <input type="text" name="building_id"/>
                </td>
            </tr>
            <tr>
                <td>楼宇名称：</td>
                <td>
                    <input type="text" name="building_name"/>
                </td>
            </tr>
            <tr>
                <td>楼宇类型（男/女）：</td>
                <td>
                    <input type="text" name="building_type"/>
                </td>
            </tr>
            <tr>
                <td>楼宇介绍：</td>
                <td>
                    <input type="text" name="building_introduction"/>
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
