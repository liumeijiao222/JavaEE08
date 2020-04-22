/*package example.jdbc;

import example.model.Student;
import example.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Configuration
public class Homework {

    @Autowired
    Student student;

    public List<Student> showStudent() {

        String sqlString = "SELECT * FROM s_student";
        List<Student> list = new ArrayList<>();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            //Statement创建对象用来执行sql语句
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        //ApplicationContext ctx=new AnnotationConfigApplicationContext(Student.class);
                        // Student s=(Student) ctx.getBean("student");
                        //Student s = new Student();
                        student.setId(resultSet.getString("id"));
                        student.setName(resultSet.getString("name"));
                        student.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(student);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回list
        return list;
    }
}


 */