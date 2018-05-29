<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/24
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宿舍管理</title>
</head>
<body>
<div id="domitory_content_top">
    <label>功能导航：</label>
    <a href="#" style="color: red" onclick="add_domitory()">添加学生</a>
    <script>
        function add_domitory() {
            $.ajax({
                url:"domitory_add.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    <label>查询：</label>
    <select name="hasome_select" onchange="hasome_change()">
        <option value="0">全部楼宇</option>
        <option value="1">楼宇号</option>
    </select>
    <select name="domitory_option">
        <option value="0">请选择</option>
        <option value="domitory_number">宿舍号</option>
        <option value="domitory_type">宿舍类型</option>
        <option value="domitory_tel">宿舍电话</option>
    </select>
    <input type="text" name="option_values"/>
    <input type="button" value="点击查询" onclick="selectDomitoryByOption()"/>
</div>
<div id="domitory_content_table">
    <table width="60%" style="text-align: center">
        <thead style="background-color: #3f96ff">
        <tr>
            <td>楼宇号</td>
            <td>寝室号</td>
            <td>寝室类型</td>
            <td>人数</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody id="table_content"></tbody>
        <script>
            $.ajax({
               type:"post" ,
                url:"/domitory.do",
                success:function (data) {
                    var isonobj_domitory=JSON.parse(data);
                    $("#table_content").empty();
                    $.each(isonobj_domitory,function (n,val) {
                        var $tr=$("<tr></tr>");//用append追加tr到table中
                        $tr.append("<td>"+val.building_id+"</td>");
                        $tr.append("<td>"+val.domitory_number+"</td>");
                        $tr.append("<td>"+val.domitory_type+"</td>");
                        $tr.append("<td>"+val.domitory_person+"</td>");
                        $tr.append("<td>"+val.domitory_tel+"</td>");
                        $tr.append("<td>"+"<a href='#' onclick='update_domitory("+val.domitory_number+","+val.building_id+")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                            "<a href='#' onclick='delete_domitory("+val.domitory_number+","+val.building_id+")'>删除</a>"+"</td>");
                        $("#table_content").append($tr);
                    })
                }
            });

            //修改宿舍
            function update_domitory(domitory_number,building_id) {
                //跳转到修改页面
                $.ajax({
                    url:"domitory_update.jsp",
                    success:function (jsp) {
                        $("#right_content").empty();
                        $("#right_content").append(jsp);
                    }
                });

                //2.向servlet请求数据
                $.ajax({
                    type:"post",
                    url:"/domitory.do",
                    data:"method=selectByID" +
                    "&building_id="+building_id +
                    "&domitory_number="+domitory_number,
                    success:function (data) {
                        var jsonobj_student=JSON.parse(data);
                        //配置input里的值
                        $("input[name='building_id']").val(jsonobj_student.student_id);//attr() 方法设置或返回被选元素的属性值
                        $("input[name='domitory_number']").val(jsonobj_student.domitory_number);
                        $("input[name='domitory_type']").val(jsonobj_student.teacher_id);
                        $("input[name='domitory_tel']").val(jsonobj_student.building_id);
                        $("input[name='domitory_person']").val(jsonobj_student.student_username);
                    }
                });
            }

            //删除学生
            function delete_domitory(domitory_number,building_id) {
                $.ajax({
                    type:"post",
                    url:"/domitory.do",
                    data:"method=delete" +
                    "&building_id="+building_id +
                    "&domitory_number="+domitory_number,
                    success:function () {
                        Domitory();
                    }
                });
            }
        </script>
    </table>
</div>
</body>
</html>
