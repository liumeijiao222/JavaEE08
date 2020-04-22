package example.controller;

import example.jdbc.TestJdbc;
import example.model.Homework;
import example.model.Student;
import example.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;



@Controller

@RequestMapping("/list")
public class TeacherController {
    @Autowired
    TestJdbc testJdbc;


    @RequestMapping(method = RequestMethod.GET, value = "/showstudent")
    public String showstudent(HttpServletRequest request, HttpServletResponse response) {

        //从数据库读取所有作业记录
        List<Student> list = testJdbc.showStudent();
        request.setAttribute("list",list);
        return "showstudent";

    }


    @RequestMapping(method = RequestMethod.GET, value = "/homework")
    public String homework(HttpServletRequest request, HttpServletResponse response) {

        List<Homework> list = testJdbc.showHomework();
        request.setAttribute("list",list);
        //request.getRequestDispatcher("showstudent.jsp").forward(request, response);
        return "homework";

    }
    @RequestMapping(value = "/addHomework")
    public String addhomework(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码
        Homework homework = new Homework();
        homework.setTitle(request.getParameter("title"));
        homework.setContent(request.getParameter("content"));
        Date date = new Date();
        homework.setCreateTime(date);
        boolean result = testJdbc.addHomework(homework);
        request.setAttribute("isOK", result);    //用来判断是否添加作业成功
        request.setAttribute("type","addHomework");
       // request.getRequestDispatcher("result.jsp").forward(request,response);
        return "addHomework";

    }
    @RequestMapping(value = "/addStudent")
    public String addstudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        Student student = new Student();
        student.setId(request.getParameter("id"));
        student.setName(request.getParameter("name"));
        Date date = new Date();
        student.setCreateTime(date);

        return "addStudent";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/showstudenthomework")
    public String showstudenthomework(HttpServletRequest request, HttpServletResponse response) {
        //从数据库读取所有作业记录
        List<Homework> list = testJdbc.showHomework();
        request.setAttribute("list",list);
        return "showstudenthomework";
    }




    @RequestMapping(method = RequestMethod.GET, value = "/findhomework")
    public String findhomework(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        //从数据库读取指定作业id的所有记录
        List<StudentHomework> list = testJdbc.selectAll(id);//访问数据库
        request.setAttribute("list",list);
        return "findhomework";
    }


}
