
<%@ page import="java.util.List" %>
<%@ page import="example.model.StudentHomework" %><%--
  Created by IntelliJ IDEA.
  User: 刘美娇
  Date: 2020/3/10
  Time: 1:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业提交情况</title>
    <style type="text/css">
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
        body
        {
            background-image: url("image/timg.jpg");
        }
    </style>

</head>

<body>
<h2 align="center" style="margin: 50px">作业提交情况</h2>
<table align="center" width="960" border="1" class="hovertable">

    <tr bgcolor="#bc8f8f">
        <th width="10%">学号</th>
        <th width="10%">作业编号</th>
        <th width="20%">作业标题</th>
        <th width="40%">作业内容</th>
        <th width="20%">创建时间</th>
    </tr>
    <%
        List<StudentHomework> list = (List<StudentHomework>)request.getAttribute("list");
        if (list == null || list.size() <= 0){
       //     out.print("None data");
        }else {
            for (StudentHomework sh : list) {
    %>
    <tr>
        <td width="10%"><%=sh.getStudentId()%></td>
        <td width="10%"><%=sh.getHomeworkId()%></td>
        <td width="20%" style="word-break: break-all;word-wrap: break-word"><%=sh.getHomeworkTitle()%></td>
        <td width="40%" style="word-break: break-all;word-wrap: break-word"><%=sh.getHomeworkContent()%></td>
        <td width="20%"><%=sh.getCreateTime()%></td>
    </tr>
    <%
            }
        }
    %>

</table>
</body>
</html>



