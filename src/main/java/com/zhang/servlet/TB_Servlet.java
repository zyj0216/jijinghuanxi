package com.zhang.servlet;

import com.google.gson.Gson;
import com.zhang.entity.For_TB;
import com.zhang.entity.Student;
import com.zhang.entity.TB;
import com.zhang.service.For_tbService;
import com.zhang.service.StudentService;
import com.zhang.service.TB_service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2018/5/25.
 */
@WebServlet(name = "TB_Servlet",urlPatterns = "/tb.do")
public class TB_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TB_service tb_service = new TB_service();
        StudentService studentService=new StudentService();
        For_tbService for_tbService= new For_tbService();
        TB tb=new TB();
        For_TB for_tb=new For_TB();
        Student student=new Student();
        String isquery=null;

        String method=request.getParameter("method");
        String student_id=request.getParameter("student_id");
        String building_id=request.getParameter("building_id");
        String domitory_number=request.getParameter("domitory_number");

        if (null!=method&&method.equals("selectByinput")){
            tb=tb_service.select_Byadmin(Integer.parseInt(student_id),Integer.parseInt(building_id),Integer.parseInt(domitory_number));
            student=studentService.selectStudentBy_ID(Integer.parseInt(student_id));

            for_tb.setName(student.getStudent_name());
            for_tb.setStuclass(student.getStudent_class());
            for_tb.setDomitory_no(student.getDomitory_number());
            for_tb.setData_tb(tb.getTB_date());

            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            gson.toJson(for_tb,out);
            out.close();
            return;
        }else if (method==null){
            List<For_TB> list= for_tbService.select();
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();
            gson.toJson(list,out);
            out.close();
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
