package com.zhang.servlet;

import com.zhang.entity.Admin;
import com.zhang.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */
@WebServlet(urlPatterns = "/admin.do")
public class AdminServlet extends HttpServlet {
    AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminService adminService = new AdminService();
        Admin admin = new Admin();
        String isquery = "null";

        String method=req.getParameter("method");
        String oldPassword=req.getParameter("oldPassword");
        String newPassword=req.getParameter("newPassword");
        String repeatPassword=req.getParameter("repeatPassword");

        if (method.equals("updatepassword")){
            admin=adminService.getpwdByID(LoginServlet.id);
            if (admin.getAdmin_password().equals(oldPassword)){
                adminService.update(newPassword,LoginServlet.id);
                req.getRequestDispatcher("Login.jsp").forward(req,resp);
            }else {
                req.setAttribute("isquery","null");
                req.getRequestDispatcher("AdminLogin.jsp").forward(req,resp);
            }
        }
    }
}
