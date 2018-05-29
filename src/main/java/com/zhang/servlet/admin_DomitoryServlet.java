package com.zhang.servlet;

import com.google.gson.Gson;
import com.zhang.entity.Domitory;
import com.zhang.service.DomitoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */
@WebServlet(name = "admin_DomitoryServlet",urlPatterns = "/domitory.do")
public class admin_DomitoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DomitoryService domitoryService = new DomitoryService();
        Domitory domitory = new Domitory();
        String isquery=null;
        String method=request.getParameter("method");

        String building_id=request.getParameter("building_id");
        String domitory_number=request.getParameter("domitory_number");
        String domitory_type=request.getParameter("domitory_type");
        String domitory_tel=request.getParameter("domitory_tel");
        String domitory_person=request.getParameter("domitory_person");

        if (null==method||method.equals("selectAll")){
            List<Domitory> list=domitoryService.selectAll();
            PrintWriter out = response.getWriter();//out对象用于输出字符流数据
            Gson gson = new Gson();
            gson.toJson(list,out);//out对象用于JSP向客户端浏览器发送文本数据
            out.close();
            return;
        }else if (method.equals("add")){
            domitory.setBuilding_id(Integer.parseInt(building_id));
            domitory.setDomitory_number(Integer.parseInt(domitory_number));
            domitory.setDomitory_type(Integer.parseInt(domitory_type));
            domitory.setDomitory_tel(Integer.parseInt(domitory_tel));
            domitory.setDomitory_person(Integer.parseInt(domitory_person));
            domitoryService.addDomitory(domitory);

            isquery="domitory";
            request.setAttribute("isquery",isquery);
            request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
            return;
        }else if (method.equals("delete")){
            domitoryService.delete(Integer.parseInt(building_id),Integer.parseInt(domitory_number));

            isquery="domitory";
            request.setAttribute("isquery",isquery);
            request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
            return;
        }else if (method.equals("selectByID")){
            domitory=domitoryService.selectBy(Integer.parseInt(building_id),Integer.parseInt(domitory_number));
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            gson.toJson(domitory,out);
            out.close();
            return;
        }else if (method.equals("update")){
            domitory.setBuilding_id(Integer.parseInt(building_id));
            domitory.setDomitory_number(Integer.parseInt(domitory_number));
            domitory.setDomitory_type(Integer.parseInt(domitory_type));
            domitory.setDomitory_tel(Integer.parseInt(domitory_tel));
            domitory.setDomitory_person(Integer.parseInt(domitory_person));
            domitoryService.updata(domitory);

            isquery="domitory";
            request.setAttribute("isquery",isquery);
            request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
