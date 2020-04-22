package example.model;

import example.aspect.TestAspect;
import example.service.JdbcService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.jar.JarEntry;

@ComponentScan("example.*")
public class test {
    public static void main(String[] args){
       /*ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
       //文件方式路径复杂，还是这种方式简单
        Homework work=(Homework) ac.getBean("homework");
        System.out.println(work.getId()+" "+work.getTitle());

        Student stu=(Student)ac.getBean("student");
        System.out.println(stu.getId()+" "+stu.getName());

        StudentHomework stuwork=(StudentHomework)ac.getBean("studenthomework");
        System.out.println(stuwork.getStudentId()+" "+stuwork.getHomeworkId()+" "+stuwork.getHomeworkTitle()+" "+stuwork.getHomeworkContent());*/

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(test.class);

       // TestAspect  testAspect=context.getBean("testAspect",TestAspect.class);
        JdbcService jdbcService=context.getBean("jdbcService",JdbcService.class);
        jdbcService.getById(10L);




    }

}
