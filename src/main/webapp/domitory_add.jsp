<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/24
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加宿舍</title>
</head>
<body>
<div id="domitory_add_form">
    <form action="/domitory.do" method="post">
        <input type="hidden" name="method" value="add"/>
        <table style="margin:auto;margin-top: 100px;width: 562px;height: 350px;">
            <tr>
                <td>楼宇号：</td>
                <td>
                    <input type="text" name="building_id"/>
                </td>
            </tr>
            <tr>
                <td>房间号：</td>
                <td>
                    <input type="text" name="domitory_number"/>
                </td>
            </tr>
            <tr>
                <td>房间类型（4/6人）：</td>
                <td>
                    <input type="text" name="domitory_type"/>
                </td>
            </tr>
            <tr>
                <td>宿舍电话：</td>
                <td>
                    <input type="text" name="domitory_tel"/>
                </td>
            </tr>
            <tr>
                <td>宿舍入住人数：</td>
                <td>
                    <input type="text" name="domitory_person"/>
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
