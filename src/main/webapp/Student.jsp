<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/21
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理</title>
</head>
<body>
<div id="student_content_top">
    <label>功能导航：</label>
    <a href="#" style="color: red" onclick="add_student()">添加学生</a>
    <script>
        //添加学生
        function add_student() {
            $.ajax({
               url:"student_add.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    <label>查询：</label>
    <select name="hasome_select" onchange="hasome_change()">
        <option value="2">请选择</option>
        <option value="1">入住</option>
        <option value="0">未入住</option>
    </select>
    <script>
        function hasome_change() {
            var val = $("select[name='hasome_select']").val();
            $.ajax({
               type:"post",
                url:"/student.do",
                data:"method=queryByHashome&hashome_select="+val,
                success:function (data) {
                    var jsonobj_student=JSON.parse(data);
                    $("#table_content").empty();
                    $.each(jsonobj_student,function (n,val) {
                        var $tr=$("<tr></tr>");
                        $tr.append("<td>"+val.student_id+"</td>");
                        $tr.append("<td>"+val.student_name+"</td>");
                        $tr.append("<td>"+val.student_class+"</td>");
                        $tr.append("<td>"+val.student_state+"</td>");
                        $tr.append("<td>"+"<a href='#' onclick='update_student("+val.student_id+")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                        "<a href='#' onclick='delete_student("+val.student_id+")'>删除</a>"+"</td>");
                        $("#table_content").append($tr);
                    })
                }
            });
        }
    </script>
    <select name="student_option">
        <option value="0">请选择</option>
        <option value="student_id">学号</option>
        <option value="student_name">姓名</option>
        <option value="student_class">班级</option>
    </select>
    <input type="text" name="option_values"/>
    <input type="button" value="点击查询" onclick="selectStudentByOption()"/>
    <script>
        function selectStudentByOption() {
            var option=$("select[name='student_option']").val();
            var option_values=$("input[name='option_values']").val();
            $.ajax({
               type:"post",
                url:"/student.do",
                data:"method=selectByOption" +
                "&student_option="+option +
                "&option_values="+option_values,
                success:function (data) {
                    var jsonobj_student=JSON.parse(data);
                    $("#table_content").empty();
                    $.each(jsonobj_student,function (n,val) {
                        alert(val.student_id);
                        var $tr=$("<tr></tr>");
                        $tr.append("<td>"+val.student_id+"</td>");
                        $tr.append("<td>"+val.student_name+"</td>");
                        $tr.append("<td>"+val.student_class+"</td>");
                        $tr.append("<td>"+val.student_state+"</td>");
                        $tr.append("<td>"+"<a href='#' onclick='update_student("+val.student_id+")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                            "<a href='#' onclick='delete_student("+val.student_id+")'>删除</a>"+"</td>");
                        $("#table_content").append($tr);
                    })
                }
            });
        }
    </script>
</div>
<div id="student_content_table">
    <table width="60%" style="text-align: center">
    <thead style="background-color: #3f96ff">
        <tr>
            <td>学号</td>
            <td>姓名</td>
            <td>班级</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
    </thead>
        <tbody id="table_content"></tbody>
        <script>
            $.ajax({
                type:"post",
                url:"/student.do",//发送请求的地址
                success:function (data) {//success请求成功后调用的回调函数,data为接收到的servlet返回来的数据，名字自定义；
                    var jsonobj_student=JSON.parse(data);//parse用于从一个字符串中解析出json对象
                    $("#table_content").empty();
                    $.each(jsonobj_student,function (n,val) {
                        var $tr=$("<tr></tr>");//用append追加tr到table中
                        $tr.append("<td>"+val.student_id+"</td>");
                        $tr.append("<td>"+val.student_name+"</td>");
                        $tr.append("<td>"+val.student_class+"</td>");
                        $tr.append("<td>"+val.student_state+"</td>");
                        $tr.append("<td>"+"<a href='#' onclick='update_student("+val.student_id+")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                            "<a href='#' onclick='delete_student("+val.student_id+")'>删除</a>"+"</td>");
                        $("#table_content").append($tr);
                    })
                }
            });
            
            //更新学生用户-修改
            function update_student(student_id) {
                //跳转到修改页面
                $.ajax({
                   url:"student_update.jsp",
                    success:function (jsp) {
                        $("#right_content").empty();
                        $("#right_content").append(jsp);
                    }
                });

                //2.向servlet请求数据
                $.ajax({
                   type:"post",
                    url:"/student.do",
                    data:"method=selectByID&student_id="+student_id,
                    success:function (data) {
                        var jsonobj_student=JSON.parse(data);
                        //配置input里的值
                        $("input[name='student_id']").val(jsonobj_student.student_id);//attr() 方法设置或返回被选元素的属性值
                        $("input[name='student_id']").attr("readonly","readonly");

                        $("input[name='domitory_number']").val(jsonobj_student.domitory_number);
                        $("input[name='teacher_id']").val(jsonobj_student.teacher_id);
                        $("input[name='building_id']").val(jsonobj_student.building_id);
                        $("input[name='student_username']").val(jsonobj_student.student_username);
                        $("input[name='student_password']").val(jsonobj_student.student_password);
                        $("input[name='student_name']").val(jsonobj_student.student_name);
                        $("input[name='student_tel']").val(jsonobj_student.student_tel);
                        $("input[name='student_class']").val(jsonobj_student.student_class);
                        if (jsonobj_student.student_state==0){
                            $("input[name='student_state']:eq(0)").attr("checked","checked");//checked 选择器选取所有选中的复选框或单选按钮
                        }else {
                            $("input[name='student_state']:eq(1)").attr("checked","checked");
                        }
                    }
                });
            }
            
            //删除学生
            function delete_student(student_id) {
                $.ajax({
                   type:"post",
                    url:"/student.do",
                    data:"method=delete&student_id="+student_id,
                    success:function () {
                        Student();
                    }
                });
            }
        </script>
    </table>
</div>
</body>
</html>
