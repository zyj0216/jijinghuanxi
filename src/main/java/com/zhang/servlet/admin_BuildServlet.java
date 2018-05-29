package com.zhang.servlet;

import com.google.gson.Gson;
import com.zhang.entity.Building;
import com.zhang.service.BuildingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2018/5/23.
 */
@WebServlet(name = "admin_BuildServlet",urlPatterns = "/building.do")
public class admin_BuildServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BuildingService buildingService = new BuildingService();
        Building building = new Building();
        String isquery = null;

        String method = request.getParameter("method");
        String building_id=request.getParameter("building_id");
        String building_name=request.getParameter("building_name");
        String building_type=request.getParameter("building_type");
        String building_introduction=request.getParameter("building_introduction");

        if (method==null||method.equals("selectAll")){
            List<Building> list=buildingService.selectAll();
            PrintWriter out = response.getWriter();//out对象用于输出字符流数据
            Gson gson = new Gson();
            gson.toJson(list,out);//out对象用于JSP向客户端浏览器发送文本数据
            out.close();
            return;
        }else if (method.equals("add")){
            building.setBuilding_name(building_name);
            building.setBuilding_type(building_type);
            building.setBuilding_introduction(building_introduction);
            buildingService.addBuilding(building);

            isquery = "building";
            request.setAttribute("isquery",isquery);
            request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
            return;
        }else if (method.equals("selectByOption")){
            String option_values = request.getParameter("option_values");
            building=buildingService.selectByOptionValues(option_values);
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            gson.toJson(building,out);
            out.close();
            return;
        }else if (method.equals("delete")){
            buildingService.deleteByBuildingID(Integer.parseInt(building_id));

            isquery = "building";
            request.setAttribute("isquery",isquery);
            request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
            return;
        }else if (method.equals("selectByID")){
           building=buildingService.selectByID(Integer.parseInt(building_id));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            gson.toJson(building,out);
            out.close();
            return;
        }else if (method.equals("update")){
            building.setBuilding_id(Integer.parseInt(building_id));
            building.setBuilding_name(building_name);
            building.setBuilding_type(building_type);
            building.setBuilding_introduction(building_introduction);
            buildingService.update(building);

            isquery = "building";
            request.setAttribute("isquery",isquery);
            request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

}
