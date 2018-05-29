<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/25
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生缺寝记录</title>
</head>
<body>
<div id="student_content_top">
    <label>功能导航：</label>
    <a href="#" style="color: red">学生缺寝记录查询</a>
    <table style="margin:auto;margin-top: 50px;width: 562px;height: 150px;">
        <tr>
            <td>楼宇号：</td>
            <td>
                <input type="text" name="building_id"/>
            </td>
        </tr>
        <tr>
            <td>宿舍号：</td>
            <td>
                <input type="text" name="domitory_number"/>
            </td>
        </tr>
        <tr>
            <td>学生号：</td>
            <td>
                <input type="text" name="student_id"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="button" value="开始查询" onclick="select_tbStudent()"/>
            </td>
        </tr>
    </table>
    <script>
        function select_tbStudent() {
            var building_id=$("input[name='building_id']").val();
            var domitory_number=$("input[name='domitory_number']").val();
            var student_id=$("input[name='student_id']").val();
            $.ajax({
                type:"post",
                url:"/tb.do",
                data:"method=selectByinput"+"&building_id="+building_id+
                    "&domitory_number="+domitory_number+
                    "&student_id="+student_id,
                success:function (data) {
                    var json_tb=JSON.parse(data);
                    $("#table_content").empty();
                        var $tr=$("<tr></tr>");//用append追加tr到table中
                        $tr.append("<td>"+json_tb.domitory_no+"</td>");
                        $tr.append("<td>"+json_tb.name+"</td>");
                        $tr.append("<td>"+json_tb.stuclass+"</td>");
                        $tr.append("<td>"+json_tb.data_tb+"</td>");
                        $("#table_content").append($tr);
                }
            });
        }
    </script>
</div>
<div id="student_content_table">
    <table width="60%" style="text-align: center">
        <thead style="background-color: #3f96ff">
        <tr>
            <td>寝室号</td>
            <td>姓名</td>
            <td>班级</td>
            <td>日期</td>
        </tr>
        </thead>
        <tbody id="table_content"></tbody>
        <script>
            $.ajax({
                type:"post",
                url:"/tb.do",//发送请求的地址
                success:function (data) {//success请求成功后调用的回调函数,data为接收到的servlet返回来的数据，名字自定义；
                    var jsonobj_TB=JSON.parse(data);//parse用于从一个字符串中解析出json对象
                    $("#table_content").empty();
                    $.each(jsonobj_TB,function (n,val) {
                        var $tr=$("<tr></tr>");//用append追加tr到table中
                        $tr.append("<td>"+val.domitory_no+"</td>");
                        $tr.append("<td>"+val.name+"</td>");
                        $tr.append("<td>"+val.stuclass+"</td>");
                        $tr.append("<td>"+val.data_tb+"</td>");
                        $("#table_content").append($tr);
                    })
                }
            });
        </script>
    </table>
</div>
</body>
</html>
