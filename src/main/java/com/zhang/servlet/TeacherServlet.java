package com.zhang.servlet;

import com.zhang.entity.Teacher;
import com.zhang.service.TeacherService;

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
@WebServlet("/Teacher.do")
public class TeacherServlet extends HttpServlet{

    TeacherService teacherService = new TeacherService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> list = teacherService.selectAll();

    }
}
