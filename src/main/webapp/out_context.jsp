<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/24
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>迁出记录</title>
</head>
<body>
<div id="building_content_table">
    <table width="60%" style="text-align: center">
        <thead style="background-color: #3f96ff">
        <tr>
            <td>日期</td>
            <td>姓名</td>
            <td>性别</td>
            <td>班级</td>
            <td>备注</td>
        </tr>
        </thead>
        <tbody id="table_content"></tbody>
        <script>
            $.ajax({
               type:"post",
                url:"/InOut.do",
                data:"method=selectAll_OutMsg&LogOut_type=0",
                success:function (data) {
                   var jsonobj_out=JSON.parse(data);
                   $("#table_content").empty();
                    $.each(jsonobj_out,function (n,val) {
                        var $tr=$("<tr></tr>");//用append追加tr到table中
                        $tr.append("<td>"+val.out_date+"</td>");
                        $tr.append("<td>"+val.student_name+"</td>");
                        $tr.append("<td>"+val.student_class+"</td>");
                        $tr.append("<td>"+val.log_remark+"</td>");
                        $("#table_content").append($tr);
                    })
                }
            });
        </script>
    </table>
</div>
</body>
</html>
