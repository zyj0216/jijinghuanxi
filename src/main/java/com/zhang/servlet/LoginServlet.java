package com.zhang.servlet;

import com.zhang.entity.Admin;
import com.zhang.entity.Student;
import com.zhang.entity.Teacher;
import com.zhang.service.AdminService;
import com.zhang.service.StudentService;
import com.zhang.service.TeacherService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/18.
 */
@WebServlet(urlPatterns = "/logining.do")
public class LoginServlet extends HttpServlet{

    public static int id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryID = Integer.parseInt(req.getParameter("select01"));
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        switch (categoryID){
            case 1 :
                AdminService adminService = new AdminService();
                Admin admin = adminService.CheckLogin(uname,pwd);
                if (admin==null){
                    req.setAttribute("message","用户名或密码输入错误");
                    req.getRequestDispatcher("Login.jsp").forward(req,resp);
                }else {
                    LoginServlet.id=admin.getAdmin_id();
                    req.setAttribute("isquery","null");
                    req.getRequestDispatcher("AdminLogin.jsp").forward(req,resp);

                    return;
                }
                break;
            case 2 :
                TeacherService teacherService = new TeacherService();
                Teacher teacher = teacherService.CheckLogin(uname,pwd);
                if (teacher==null){
                    req.setAttribute("message","用户名或密码输入错误");
                    req.getRequestDispatcher("Login.jsp").forward(req,resp);
                }else {
                    LoginServlet.id=teacher.getTeacher_id();
                    req.getRequestDispatcher("TeacherLogin.jsp").forward(req,resp);
                }
                break;
            case 3 :
                StudentService studentService = new StudentService();
                Student student = studentService.CheckLogin(uname,pwd);
                if (student==null){
                    req.setAttribute("message","用户名或密码输入错误");
                    req.getRequestDispatcher("Login.jsp").forward(req,resp);
                }else {
                    LoginServlet.id=student.getStudent_id();
                    req.getRequestDispatcher("TeacherLogin.jsp").forward(req,resp);
                }
                break;
            default:
                req.setAttribute("message","用户身份选择错误~~~~~");
                req.getRequestDispatcher("Login.jsp").forward(req,resp);
                    break;
        }
    }
}
