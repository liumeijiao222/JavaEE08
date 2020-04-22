<%--
  Created by IntelliJ IDEA.
  User: 刘美娇
  Date: 2020/3/9
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加新作业</title>
    <style type="text/css">
        body
        {
            background-image: url("image/timg.jpg");
        }
    </style>
</head>
<body>
<div align="center">
    <h2>布置作业</h2>
    <form action=/JavaEE08_war_exploded/list/addHomework method=post>
        <table style="line-height: 40px">
            <tr>
                <th>作业标题:</th>
                <td><input type="text" name="title" maxlength="15" size="40" style="font-family: arial" required></td>
            </tr>
            <tr>
                <th>作业内容:</th>
                <td><textarea name="content" rows="5" cols="42" style="font-family: arial" required></textarea></td>
            </tr>

            <tr align="center">
                <td><input type="submit" value="提交"> </td>
                <td><input type="reset" value="清空"></td>
                <td><a href="/JavaEE08_war_exploded/list/homework">返回主页</a></td>

            </tr>
        </table>
    </form>
</div>


</body>
</html>
