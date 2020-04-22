
<%@ page import="java.util.List" %>
<%@ page import="example.model.Homework" %><%--
  Created by IntelliJ IDEA.
  User: 刘美娇
  Date: 2020/3/10
  Time: 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看作业</title>
    <style type="text/css">
        body
        {
            background-image: url("image/timg.jpg");
        }
    </style>

    <%--    将作业id传到/query--%>
    <script>
        function show(id) {
            let homework = document.getElementById('homeworkId')
            homework.setAttribute("value",id)
            let sub = document.getElementById('sub')
            sub.submit()
        }
    </script>
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
        </style>

</head>
<body>
<form id="sub" method="get" action="/JavaEE08_war_exploded/list/findhomework">

    <input id="homeworkId" name="id" type="hidden">
    <table align="center" width="960" border="1" class="hovertable">
        <tr>
            <th width="10%">作业编号</th>
            <th width="80%" style="word-break: break-all;word-wrap: break-word">作业标题</th>
            <th width="10%">提交情况</th>
        </tr>

        <%
            List<Homework> list = (List<Homework>)request.getAttribute("list");
            if (list == null || list.size() <= 0){
               out.print("None data");
            }else {
                for (Homework homework : list) {
        %>
        <tr>
            <td><%=homework.getId()%></td>
            <td><%=homework.getTitle()%></td>
            <td><input type="button" value="提交情况" onclick="show(<%=homework.getId()%>)"> </td>
        </tr>

        <%
                }
            }
        %>

    </table>
</form>
</body>
</html>