package com.zhang.servlet;

import com.zhang.entity.Domitory;
import com.zhang.entity.Student;
import com.zhang.service.DomitoryService;
import com.zhang.service.StudentService;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/25.
 */
@WebServlet(name = "changeDomitory_Servlet",urlPatterns = "/changeDomitory.do")
public class changeDomitory_Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentService studentService = new StudentService();
        DomitoryService domitoryService = new DomitoryService();
        Domitory domitory=new Domitory();
        Student student=new Student();
       String isquery=null;

       String method=request.getParameter("method");
       String student_id=request.getParameter("student_id");
       String domitory_number=request.getParameter("domitory_number");
       String building_id=request.getParameter("building_id");

       if (method.equals("selectStudentById")){//找到需要调寝的学生信息

           //先将要调寝的学生的信息查出来
           student=studentService.selectStudentBy_ID(Integer.parseInt(student_id));
           request.setAttribute("student",student);
           request.getRequestDispatcher("change_Msg.jsp").forward(request,response);

           //调入的寝室的人数，是否还有空位
           domitory=domitoryService.selectBy(Integer.parseInt(building_id),Integer.parseInt(domitory_number));
           int person=domitory.getDomitory_person();
           if (person==domitory.getDomitory_type()){
               //已经住满了
               request.setAttribute("message","此宿舍人数已经达到上限，请换另一个宿舍");
               request.getRequestDispatcher("change_Msg.jsp").forward(request,response);
           }else {
               //调入的宿舍人数+1
               domitoryService.updatePersonadd(domitory.getDomitory_number(),person);
               /**
                * 调出的宿舍人数-1
                */
               student=studentService.selectStudentBy_ID(Integer.parseInt(student_id));
               //调寝之前的宿舍人数
               domitory=domitoryService.selectBy(student.getBuilding_id(),student.getDomitory_number());
               int person01=domitory.getDomitory_person();
               domitoryService.updatePersonMinus(student.getDomitory_number(),person01);
               //调寝的学生楼宇号和宿舍号要同步修改
               studentService.change_domitoryAfter(student.getDomitory_number(),student.getBuilding_id(),Integer.parseInt(student_id));
               request.setAttribute("message","好开森，调寝成功了呢~~~~~~~");
               request.setAttribute("isquery","null");
               request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
           }
       }else if(method.equals("sure_change")){

       } else if (method.equals("fanhuishangye")){
           request.setAttribute("message","我还是喜欢我原来的宿舍，我不调寝了................");
           request.setAttribute("isquery","null");
           request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
