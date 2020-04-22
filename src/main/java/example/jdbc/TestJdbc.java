package example.jdbc;

import example.model.Homework;
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
public class TestJdbc {

    public  List<Student> showStudent(){

        String sqlString = "SELECT * FROM s_student";
        List<Student> list = new ArrayList<>();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            //Statement创建对象用来执行sql语句
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        Student student=new Student();
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

    /**
     * 读取指定id的学生作业记录
     */

    public List<StudentHomework> selectAll(String id){

        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id=" + id;
        List<StudentHomework> list = new ArrayList<>();
        //连接数据库
        try(Connection connection = DatabasePool.getHikariDataSource().getConnection()){
            //创建statement对象
            try(Statement statement = connection.createStatement()) {
                //执行sql语句并将结果集存入result类
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    // 获取执行结果
                    while (resultSet.next()) {
                        StudentHomework studenthomework=new StudentHomework();
                        studenthomework.setId(resultSet.getLong("id"));
                        studenthomework.setStudentId(resultSet.getLong("student_id"));
                        studenthomework.setHomeworkId(resultSet.getLong("homework_id"));
                        studenthomework.setHomeworkTitle(resultSet.getString("homework_title"));
                        studenthomework.setHomeworkContent(resultSet.getString("homework_content"));
                        studenthomework.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(studenthomework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    /**
     * 添加作业记录
     */
    public boolean addHomework(example.model.Homework homework){


        String sqlString = "insert into s_homework (title,content,create_time) values(?,?,?)";

        int resultSet = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setString(1,homework.getTitle());
                ps.setString(2,homework.getContent());
                ps.setTimestamp(3,new Timestamp(homework.getCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }


    /**
     * 添加学生
     */
    public boolean addStudent(Student student){

        String sqlString = "insert into s_student (id,name,create_time) values(?,?,?)";
        int resultSet = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setString(1,student.getId());
                ps.setString(2,student.getName());
                ps.setTimestamp(3,new Timestamp(student.getCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }








    /**
     *读取所有老师布置的作业记录，此处用于提交作业使用
     */
    public List<example.model.Homework> showHomework(){

        String sqlString = "SELECT * FROM s_homework";

        List<example.model.Homework> list = new ArrayList<>();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            //Statement创建对象用来执行sql语句
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {
                        Homework homework=new Homework();
                        homework.setId(resultSet.getLong("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(homework);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回list
        return list;
    }




    /**
     * 向s_student_homework表提交作业
     */
    public boolean addStudentHomework(StudentHomework studentHomework){
        String sqlString = "insert into s_student_homework (student_id,homework_id," +
                "homework_title,homework_content,create_time) values(?,?,?,?,?)";

        int resultSet = 0;
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sqlString)) {
                ps.setLong(1,studentHomework.getStudentId());
                ps.setLong(2,studentHomework.getHomeworkId());
                ps.setString(3,studentHomework.getHomeworkTitle());
                ps.setString(4,studentHomework.getHomeworkContent());
                ps.setTimestamp(5,new Timestamp(studentHomework.getCreateTime().getTime()));
                resultSet = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet > 0;
    }

    /**
     * 从s_homework表读取指定id的作业
     读取指定id内容无须add（）
     */
    public example.model.Homework showHomeworkDetails(String id){
        String sqlString = "SELECT * FROM s_homework WHERE id=" + id;
        Homework homework=new Homework();
        try (Connection connection = DatabasePool.getHikariDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sqlString)) {
                    //获取执行结果
                    while (resultSet.next()) {

                        homework.setId(resultSet.getLong("id"));
                        homework.setTitle(resultSet.getString("title"));
                        homework.setContent(resultSet.getString("content"));
                        homework.setCreateTime(resultSet.getTimestamp("create_time"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return homework;
    }



}



