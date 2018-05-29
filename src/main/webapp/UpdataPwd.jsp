<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/24
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码页面</title>
    <script src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="updatePwd">
    <form action="/admin.do" method="post">
        <input type="hidden" name="method" value="updatepassword"/>
        <table style="margin:auto;margin-top: 100px;width: 562px;height: 350px;">
            <tr>
                <td>请输入原密码：</td>
                <td>
                    <input type="text" name="oldPassword"/>
                </td>
            </tr>
            <tr>
                <td>请输入新密码：</td>
                <td>
                    <input type="text" name="newPassword"/>
                </td>
            </tr>
            <tr>
                <td>请重复新密码：</td>
                <td>
                    <input type="text" name="repeatPassword" onchange="checkpwd()"/>
                </td>
            <tr>
            <script>
                function checkpwd() {
                    var newPassword=$("input[name='newPassword']").val();
                    var repeatPassword=$("input[name='repeatPassword']").val();
                    if (newPassword!=repeatPassword){
                        $("#btn").attr("disabled",true);
                    }else {
                        $("#btn").attr("disabled",false);
                    }
                }
            </script>
                <td></td>
                <td>
                    <input id="btn" type="submit" value="修改密码"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
