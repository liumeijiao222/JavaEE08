package example.controller;

import example.jdbc.TestJdbc;
import example.model.Homework;
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


@Controller
@RequestMapping("/list")
public class StudentController {




    @Autowired
    TestJdbc testJdbc;

    @RequestMapping(method = RequestMethod.GET,value = "/submithomework")
    public String submit(HttpServletRequest req, HttpServletResponse response) throws IOException{
        String id = req.getParameter("id");
        //读取指定id的作业内容详细信息
        Homework homework = testJdbc.showHomeworkDetails(id);//访问数据库
        req.setAttribute("homework",homework);
        //req.getRequestDispatcher("submithomework.jsp").forward(req,resp); //展示内容
        return "submithomework";
    }

    @RequestMapping(value = "/submithomework")
    public String add(HttpServletRequest req, HttpServletResponse response) throws IOException {
        req.setCharacterEncoding("utf-8");//设置编码，以防表单提交的内容乱码

        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId(Long.parseLong(req.getParameter("studentId")));
        studentHomework.setHomeworkId(Long.parseLong(req.getParameter("homeworkId")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        Date date = new Date();
        studentHomework.setCreateTime(date);

      //  boolean result = testJdbc.addStudentHomework(studentHomework);

      //  req.setAttribute("isOK", result);   //用于判断是否提交成功
      //  req.setAttribute("type","addStudentHomework");
       // req.getRequestDispatcher("result.jsp").forward(req,resp);
        return "redirect:homework";
    }
}