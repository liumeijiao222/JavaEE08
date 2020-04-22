
<%@ page import="java.util.List" %>
<%@ page import="example.model.Student" %>
<%@ page import="example.jdbc.TestJdbc" %><%--
  Created by IntelliJ IDEA.
  User: 刘美娇
  Date: 2020/3/10
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生</title>

    <style type="text/css">
        body {
            background-image: url("image/timg.jpg");
        }
        table.hovertable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #999999;
            border-collapse: collapse;
            line-height:5;
            background: cadetblue;
        }
    </style>
</head>
<body>
<table align="center"   class="hovertable"  border="1"  width="650">
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>创建时间</th>
            </tr>

            <%

                List<Student> list = (List<Student>)request.getAttribute("list");
                if (list == null || list.size() <= 0){
                    System.out.println("None data");
                }else {
                    for (Student s : list) {
            %>
            <tr>
                <td width="10%"><%=s.getId()%></td>
                <td width="20%" style="word-break: break-all;word-wrap: break-word"><%=s.getName()%></td>
                <td width="60%" style="word-break: break-all;word-wrap: break-word"><%=s.getCreateTime()%></td>

            </tr>

            <%
                    }
                }
            %>

        </table>


</body>
</html>