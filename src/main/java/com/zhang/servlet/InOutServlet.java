package com.zhang.servlet;


import com.google.gson.Gson;
import com.zhang.entity.Domitory;
import com.zhang.entity.LogOut;
import com.zhang.entity.Student;
import com.zhang.service.DomitoryService;
import com.zhang.service.InOutService;
import com.zhang.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.GarbageCollectorMXBean;
import java.util.List;

/**
 * Created by Administrator on 2018/5/24.
 */
@WebServlet(name = "InOutServlet",urlPatterns = "/InOut.do")
public class InOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentService();
        InOutService inOutService = new InOutService();
        DomitoryService domitoryService = new DomitoryService();
        Domitory domitory = new Domitory();
        Student student=new Student();
        LogOut logOut = new LogOut();
        String method=request.getParameter("method");
        String isquery=null;


        String student_id=request.getParameter("student_id");
        String building_id=request.getParameter("building_id");
        String domitory_number=request.getParameter("domitory_number");
        String LogOut_type=request.getParameter("LogOut_type");


        if (method.equals("addInOut")){
             //迁入迁出表增加一条迁入信息
            inOutService.In_add(Integer.parseInt(student_id),LoginServlet.id);

            //迁入的宿舍人数+1
            domitory=domitoryService.selectBy(Integer.parseInt(building_id),Integer.parseInt(domitory_number));//查出原宿舍人数
            int person=domitory.getDomitory_person();
            if (person>domitory.getDomitory_type()){
                request.setAttribute("message","此宿舍人数已经达到上限，请换另一个宿舍");
                request.getRequestDispatcher("IN.jsp").forward(request,response);
            }else {
                domitoryService.updatePersonadd(Integer.parseInt(domitory_number), person);
                //学生信息修改，状态改为入住，并且添上楼宇号和宿舍号
                studentService.updataByIn(Integer.parseInt(domitory_number), Integer.parseInt(building_id), Integer.parseInt(student_id));
                request.setAttribute("message","恭喜您，迁入成功~~~~~~~");
                request.setAttribute("isquery","null");
                request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
            }
            }else if (method.equals("out_shanchu")){
                //迁入迁出表增加一条迁出信息
                inOutService.Out_add(Integer.parseInt(student_id),LoginServlet.id);

                //宿舍人数-1
                 student=studentService.selectStudentBy_ID(Integer.parseInt(student_id));
                 domitory=domitoryService.selectBy(student.getBuilding_id(),student.getDomitory_number());
                 int person=domitory.getDomitory_person();
                 domitoryService.updatePersonMinus(student.getDomitory_number(), person);

                 //将迁出宿舍的学生删除
                 studentService.deleteStudentBy_ID(Integer.parseInt(student_id));

                 request.setAttribute("message","哦吼吼，迁出成功，毕业啦！！！！！！！！！！！");
                 request.setAttribute("isquery","null");
                 request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
                 return;
            }else if (method.equals("selectStudentById")){
                //先将要迁出宿舍的学生的信息查出来
                student=studentService.selectStudentBy_ID(Integer.parseInt(student_id));
                request.setAttribute("student",student);
                request.getRequestDispatcher("outStudentMsg.jsp").forward(request,response);
        }else if (method.equals("sure_out")){
            request.setAttribute("message","我后悔了，我不迁出~~~~~~~~~~~");
            request.setAttribute("isquery","null");
            request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
        }else if (method.equals("selectAll_OutMsg")){//查询迁出信息
            List<LogOut> list=inOutService.selectAll_outMsg(Integer.parseInt(LogOut_type));
            PrintWriter out = response.getWriter();
            Gson gson=new Gson();
            gson.toJson(list,out);
            out.close();
            return;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
