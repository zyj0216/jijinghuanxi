<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>楼宇管理员管理</title>
</head>
<body>
<div id="teacher_content_top">
    <label>功能导航：</label>
    <a href="#" style="color: red" onclick="add_teacher()">添加楼宇管理员</a>
    <script>
        //添加楼宇管理员
        function add_teacher() {
            $.ajax({
               type:"post",
                url:"teacher_add.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    <label>查询：</label>
    <select name="teacher_option">
        <option value="0">请选择</option>
        <option value="teacher_name">姓名</option>
        <option value="teacher_uname">用户名</option>
    </select>
    <input type="text" name="option_values"/>
    <input type="button" value="点击查询" onclick="selectTeacherByOption()"/>
    <script>
        function selectTeacherByOption() {
            var option=$("select[name='teacher_option']").val();
            var option_values=$("input[name='option_values']").val();
            $.ajax({
               type:"post",
                url:"/teacher.do",
                data:"method=seleectByOption&teacher_option="+option+
                "&option_values="+option_values,
                success:function (data) {
                    var json_obj=JSON.parse(data);
                    $("#table_content").empty();
                    $.each(json_obj,function (n,val) {
                       var $tr= $("<tr></tr>");
                        $tr.append("<td>"+val.teacher_name+"</td>");
                        $tr.append("<td>"+val.teacher_sex+"</td>");
                        $tr.append("<td>"+val.teacher_tel+"</td>");
                        $tr.append("<td>"+val.teacher_uname+"</td>");
                        $tr.append("<td>"+
                            "<a href='#' onclick='update_teacher("+val.teacher_id+")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                            "<a href='#' onclick='delete_teacher("+val.teacher_id+")'>删除</a>"+
                            "</td>");
                       $("#table_content").append($tr);
                    });
                }
            });
        }
    </script>
</div>
<div id="teacher_content_table">
    <table width="60%" style="text-align: center">
        <thead style="background-color: #3f96ff">
        <tr>
            <td>姓名</td>
            <td>性别</td>
            <td>电话</td>
            <td>用户名</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody id="table_content"></tbody>
        <script>
            $.ajax({
                type:"post",
                url:"/teacher.do",
                success:function (data) {
                    var jsonobj_teacher=JSON.parse(data);
                    $("#table_content").empty();
                    $.each(jsonobj_teacher,function (n,val) {
                        var $tr=$("<tr></tr>");
                        $tr.append("<td>"+val.teacher_name+"</td>");
                        $tr.append("<td>"+val.teacher_sex+"</td>");
                        $tr.append("<td>"+val.teacher_tel+"</td>");
                        $tr.append("<td>"+val.teacher_uname+"</td>");
                        $tr.append("<td>"+
                            "<a href='#' onclick='update_teacher("+val.teacher_id+")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                            "<a href='#' onclick='delete_teacher("+val.teacher_id+")'>删除</a>"+
                            "</td>");
                        $("#table_content").append($tr);
                    })
                }
            });

            //修改
            function update_teacher(teacher_id) {
                $.ajax({
                    url:"teacher_updata.jsp",
                    success:function (jsp) {
                        $("#right_content").empty();
                        $("#right_content").append(jsp);
                    }
                });

                $.ajax({
                   type:"post",
                    url:"/teacher.do",
                    data:"method=selectById&teacher_id="+teacher_id,
                    success:function (data) {
                        var jsonobj_teacher=JSON.parse(data);
                        $("input[name='teacher_id']").val(jsonobj_teacher.teacher_id);
                        $("input[name='teacher_id']").attr("readonly","readonly");

                        $("input[name='teacher_uname']").val(jsonobj_teacher.teacher_uname);
                        $("input[name='teacher_password']").val(jsonobj_teacher.teacher_password);
                        $("input[name='teacher_name']").val(jsonobj_teacher.teacher_name);
                        $("input[name='teacher_sex']").val(jsonobj_teacher.teacher_sex);
                        $("input[name='teacher_tel']").val(jsonobj_teacher.teacher_tel);
                        $("input[name='building_id']").val(jsonobj_teacher.building_id);
                    }
                });
            }



            //删除楼宇管理员信息
            function delete_teacher(teacher_id) {
                    $.ajax({
                       type:"post",
                        url:"/teacher.do",
                        data:"method=delete&teacher_id="+teacher_id,
                        success:function () {
                            Teacher();
                        }
                    });
            }

        </script>
    </table>
</div>
</body>
</html>
