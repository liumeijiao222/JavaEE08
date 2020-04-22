package example.controller;

import example.jdbc.TestJdbc;
import example.model.Homework;
import example.model.Student;
import example.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DemoController {

    @Autowired
    private TestJdbc testJdbc;


    @RequestMapping(method = RequestMethod.GET, value = "/h")
    public String homework(HttpServletRequest request, HttpServletResponse response) {

        List<Homework> list = testJdbc.showHomework();
        request.setAttribute("list",list);
        //request.getRequestDispatcher("showstudent.jsp").forward(request, response);
        return "homework";

    }
}
