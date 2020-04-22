<%@ page import="example.model.Homework" %><%--
  Created by IntelliJ IDEA.
  User: 刘美娇
  Date: 2020/3/9
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
    <style type="text/css">
    body
    {
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
<h2 align="center" style="margin: 50px">提交作业</h2>
<div align="center">
    <form method="post" action="/JavaEE08_war_exploded/list/submithomework">
        <table border="0" width="960" class="hovertable">
            <%
                Homework homework = (Homework) request.getAttribute("homework");
            %>
            <tr>
                <th width="15%">作业标题:</th>
                <td width="50%"><%=homework.getTitle()%></td>
            </tr>
            <tr>
                <th width="15%">作业内容:</th>
                <td width="50%"><%=homework.getContent()%></td>
            </tr>
            <tr>
                <th width="15%">学号:</th>
                <td width="50%"><input type="number" name="studentId"
                                       maxlength="20" style="font-family: Arial;  width: 100%" required>
                </td>
            </tr>
            <input type="hidden" name="title" value="<%=homework.getTitle()%>">
            <input type="hidden" name="homeworkId" value="<%=homework.getId()%>">
            <tr>
                <th width="15%">作业内容</th>
                <td width="50%"><textarea name="content"  style="font-family: Arial; width: 100%" rows="10" required></textarea></td>
            </tr>
            <tr style="border: none">
                <td align="center"><input type="reset" value="清空"></td>
                <td align="center"><input type="submit" value="提交"></td>
            </tr>
        </table>


    </form>
</div>
</body>
</html>
