package com.zhang.servlet;

import com.google.gson.Gson;
import com.zhang.entity.Teacher;
import com.zhang.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2018/5/22.
 */
@WebServlet(urlPatterns = "/teacher.do")
public class admin_TeacherServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        List<Teacher> list = teacherService.selectAll();
        Teacher teacher = new Teacher();
        String isquery = "null";

        String method = req.getParameter("method");
        String teacher_id = req.getParameter("teacher_id");
        String teacher_uname = req.getParameter("teacher_uname");
        String teacher_password = req.getParameter("teacher_password");
        String teacher_name = req.getParameter("teacher_name");
        String teacher_sex = req.getParameter("teacher_sex");
        String teacher_tel = req.getParameter("teacher_tel");
        String building_id =req.getParameter("building_id");

        if (null==method||method.equals("selectAll")){
            PrintWriter out = resp.getWriter();
            Gson gson = new Gson();
            gson.toJson(list,out);
            out.close();
            return;
        }else if (method.equals("delete")){
            teacherService.deleteTeacherByID(Integer.parseInt(teacher_id));

            isquery="teacher";
            req.setAttribute("isquery",isquery);
            req.getRequestDispatcher("AdminLogin.jsp").forward(req,resp);
            return;
        }else if (method.equals("add")){
            teacher.setTeacher_uname(teacher_uname);
            teacher.setTeacher_password(teacher_password);
            teacher.setTeacher_name(teacher_name);
            teacher.setTeacher_sex(teacher_sex);
            teacher.setTeacher_tel(teacher_tel);
            teacher.setBuilding_id(Integer.parseInt(building_id));
            teacherService.add_teacher(teacher);

            isquery="teacher";
            req.setAttribute("isquery",isquery);
            req.getRequestDispatcher("AdminLogin.jsp").forward(req,resp);
            return;
        }else if (method.equals("seleectByOption")){
            String option = req.getParameter("teacher_option");
            String values = req.getParameter("option_values");
            if (option.equals("0")){
                list = teacherService.selectAll();
                PrintWriter out = resp.getWriter();
                Gson gson = new Gson();
                gson.toJson(list,out);
                out.close();
                return;
            }else {
                list = teacherService.selectBy_OptionVlues(option,values);
                PrintWriter out = resp.getWriter();
                Gson gson = new Gson();
                gson.toJson(list,out);
                out.close();
                return;
            }
        }else if (method.equals("selectById")){
           teacher= teacherService.selectByUname(teacher_id);
           PrintWriter out = resp.getWriter();
           Gson gson = new Gson();
           gson.toJson(teacher,out);
           out.close();
           return;
        }else if (method.equals("update")){
            teacher.setTeacher_id(Integer.parseInt(teacher_id));
            teacher.setTeacher_uname(teacher_uname);
            teacher.setTeacher_password(teacher_password);
            teacher.setTeacher_name(teacher_name);
            teacher.setTeacher_sex(teacher_sex);
            teacher.setTeacher_tel(teacher_tel);
            teacher.setBuilding_id(Integer.parseInt(building_id));
            teacherService.update(teacher);



            isquery="teacher";
            req.setAttribute("isquery",isquery);
            req.getRequestDispatcher("AdminLogin.jsp").forward(req,resp);
            return;
        }
    }
}
