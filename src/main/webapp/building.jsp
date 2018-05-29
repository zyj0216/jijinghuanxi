<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/23
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>楼宇管理</title>
</head>
<body>
<div id="building_content_top">
    <label>功能导航：</label>
    <a href="#" style="color: red" onclick="add_building()">添加楼宇</a>
    <script>
        //添加楼宇
        function add_building() {
            $.ajax({
               type:"post",
                url:"building_add.jsp",
                success:function (jsp) {
                    $("#right_content").empty();
                    $("#right_content").append(jsp);
                }
            });
        }
    </script>
    <label>名称：</label>
    <input type="text" name="option_values"/>
    <input type="button" value="点击查询" onclick="selectBuildingByOption()"/>
    <script>
        function selectBuildingByOption() {
            var option_values=$("input[name='option_values']");
            $.ajax({
                type:"post",
                url:"/building.do",
                data:"method=selectByOption&option_values="+option_values,
                success:function (data) {
                    var jsonobj_building=JSON.parse(data);
                    $("#table_content").empty();
                    $.each(jsonobj_building,function (n,val) {
                        var $tr=$("<tr></tr>");
                        $tr.append("<td>"+val.building_name+"</td>");
                        $tr.append("<td>"+val.building_introduction+"</td>");
                        $tr.append("<td>"+
                            "<a href='#' onclick='update_building("+val.building_id+")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                            "<a href='#' onclick='delete_building("+val.building_id+")'>删除</a>"+
                            "</td>");
                        $("#table_content").append($tr);
                    })
                }
            });
        }
    </script>
</div>
<div id="building_content_table">
    <table width="60%" style="text-align: center">
        <thead style="background-color: #3f96ff">
        <tr>
            <td>名称</td>
            <td>简介</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody id="table_content"></tbody>
        <script>
            $.ajax({
               type:"post",
                url:"/building.do",
                success:function (data) {
                    var jsonobj_building=JSON.parse(data);
                    $("#table_content").empty();
                    $.each(jsonobj_building,function (n,val) {
                        var $tr=$("<tr></tr>");
                        $tr.append("<td>"+val.building_name+"</td>");
                        $tr.append("<td>"+val.building_introduction+"</td>");
                        $tr.append("<td>"+
                            "<a href='#' onclick='update_building("+val.building_id+")'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"+
                            "<a href='#' onclick='delete_building("+val.building_id+")'>删除</a>"+
                            "</td>");
                        $("#table_content").append($tr);
                    })
                }
            });

            //修改
            function update_building(building_id) {
                //1.跳转到修改页面
                $.ajax({
                   url:"building_update.jsp",
                    success:function (jsp) {
                        $("#table_content").empty();
                        $("#table_content").append(jsp);
                    }
                });

                //2.想servlet请求数据
                $.ajax({
                    type:"post",
                    url:"/building.do",
                    data:"method=selectByID&building_id="+building_id,
                    success:function (data) {
                        var jsonobj_building=JSON.parse(data);
                        //配置input里的值
                        $("input[name='building_id']").val(jsonobj_building.building_id);//attr() 方法设置或返回被选元素的属性值
                        $("input[name='building_id']").attr("readonly","readonly");

                        $("input[name='building_name']").val(jsonobj_building.building_name);
                        $("input[name='building_type']").val(jsonobj_building.building_type);
                        $("input[name='building_introduction']").val(jsonobj_building.building_introduction);
                    }
                });
            }


            //删除
            function delete_building(building_id) {
                $.ajax({
                    type:"post",
                    url:"/building.do",
                    data:"method=delete&building_id="+building_id,
                    success:function () {
                        Building();
                    }
                });
            }
        </script>
    </table>
</div>
</body>
</html>
