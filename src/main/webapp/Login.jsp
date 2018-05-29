<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/17
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body style="background-image: url(./img/b6d78f86a1a9977d93e51ecab0514c92.jpg); background-repeat: no-repeat; background-size: cover;">
<h1>${message}</h1>
<form action="/logining.do" method="post" name="form1">
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <div class="jumbotron" style="opacity: 0.6; margin-top: 200px">
                <div class="page-header">
                    <h2 style="text-align: center;" class="text-primary">我的校园我的家</h2>
                    <h4 style="text-align: center;" class="text-primary">My School,My Home</h4>
                </div>
                <div class="form">
                    <form role="form">
                        <div class="form-group">
                            <div class="form-group" style="border: none; background-color: transparent; font-size: 18px;">
                                <select name="select01">
                                    <option value="1">系统管理员</option>
                                    <option value="2">楼宇管理员</option>
                                    <option value="3">学生</option>
                                </select>
                            </div>
                            <input type="text" class="form-control" style="border: none; background-color: transparent; font-size: 18px;" placeholder="登录账号/手机号/邮箱" name="uname"/>
                        </div>
                        <div class="form-group divider"></div>
                        <div class="form-group">
                            <input type="password" class="form-control" style="border: none; background-color: transparent; font-size: 18px;" placeholder="用户密码" name="pwd"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" style="border: none; background-color: transparent; font-size: 18px;" placeholder="验证码" name="code"/>
                            <%--<img src="check_code.jpg" id="img1" onclick="this.src='http://localhost:8888/check_code.jpg?'+Math.random()" alt="title">--%>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-4 col-sm-10">
                                <button type="button" class="btn btn-success">注册</button>
                                <button type="submit" class="btn btn-success">登录</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>
