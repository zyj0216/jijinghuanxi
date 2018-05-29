package com.zhang.servlet;

import com.google.gson.Gson;
import com.zhang.entity.Student;
import com.zhang.service.StudentService;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */
@WebServlet(urlPatterns = "/student.do")
public class admin_StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = new StudentService();
        List<Student> list = studentService.selectAll();//从后台数据库查出来的数据
        Student student = new Student();
        String isquery = "null";

        String method=req.getParameter("method");
        String student_id = req.getParameter("student_id");//form表单提交的数据,从前台输入的数据,用于添加、更新
        String domitory_number = req.getParameter("domitory_number");
        String teacher_id = req.getParameter("teacher_id");
        String building_id = req.getParameter("building_id");
        String student_username = req.getParameter("student_username");
        String student_password = req.getParameter("student_password");
        String student_name = req.getParameter("student_name");
        String student_tel = req.getParameter("student_tel");
        String student_class = req.getParameter("student_class");
        String student_state = req.getParameter("student_state");


        if (null==method||method.equals("selectAll")){
            PrintWriter out = resp.getWriter();//out对象用于输出字符流数据
            Gson gson = new Gson();
            gson.toJson(list,out);//out对象用于JSP向客户端浏览器发送文本数据
            out.close();
            return;
        }else if(method.equals("add")){
            student.setDomitory_number(Integer.parseInt(domitory_number));
            student.setTeacher_id(Integer.parseInt(teacher_id));
            student.setBuilding_id(Integer.parseInt(building_id));
            student.setStudent_username(student_username);
            student.setStudent_password(student_password);
            student.setStudent_name(student_name);
            student.setStudent_tel(student_tel);
            student.setStudent_class(student_class);
            student.setStudent_state(student_state);
            studentService.addStudent(student);

            isquery="student";
            req.setAttribute("isquery",isquery);
            req.getRequestDispatcher("AdminLogin.jsp").forward(req,resp);
            return;
        }else if(method.equals("selectByID")){
            student=studentService.selectStudentBy_ID(Integer.parseInt(student_id));
            PrintWriter out = resp.getWriter();
            Gson gson = new Gson();
            gson.toJson(student,out);
            out.close();
            return;
        }else if (method.equals("update")){
            student.setStudent_id(Integer.parseInt(student_id));
            student.setDomitory_number(Integer.parseInt(domitory_number));
            student.setTeacher_id(Integer.parseInt(teacher_id));
            student.setBuilding_id(Integer.parseInt(building_id));
            student.setStudent_username(student_username);
            student.setStudent_password(student_password);
            student.setStudent_name(student_name);
            student.setStudent_tel(student_tel);
            student.setStudent_class(student_class);
            student.setStudent_state(student_state);

            studentService.updateStudebtBy(student);

            isquery="student";
            req.setAttribute("isquery",isquery);
            req.getRequestDispatcher("AdminLogin.jsp").forward(req,resp);
            return;
        }else if (method.equals("delete")){
            studentService.deleteStudentBy_ID(Integer.parseInt(student_id));

            isquery="student";
            req.setAttribute("isquery",isquery);
            req.getRequestDispatcher("AdminLogin.jsp").forward(req,resp);
            return;
        }else if (method.equals("queryByHashome")){
            int hashome_select = Integer.parseInt(req.getParameter("hashome_select"));
            if (hashome_select!=2){
                list=studentService.selectStudentBy_state(hashome_select);//根据是否入住查询
                PrintWriter out = resp.getWriter();
                Gson gson = new Gson();
                gson.toJson(list,out);
                out.close();
                return;
            }else {
                isquery="student";
                req.setAttribute("isquery",isquery);
                req.getRequestDispatcher("AdminLogin.jsp").forward(req,resp);
                return;
            }
        }else if (method.equals("selectByOption")){
            String option = req.getParameter("student_option");
            String values = req.getParameter("option_values");
            if (option.equals("0")){
                list=studentService.selectAll();
                PrintWriter out = resp.getWriter();
                Gson gson = new Gson();
                gson.toJson(list,out);
                out.close();
                return;
            }else {
                list=studentService.selectStudentBy_Option(option,values);
                PrintWriter out = resp.getWriter();
                Gson gson = new Gson();
                gson.toJson(list,out);
                out.close();
                return;
            }
        }
    }
}
