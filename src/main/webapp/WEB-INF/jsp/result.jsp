<%--
  Created by IntelliJ IDEA.
  User: 刘美娇
  Date: 2020/3/9
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作结果</title>
    <style type="text/css">
        body
        {
            background-image: url("image/timg.jpg");
        }
    </style>
</head>
<body>
<%
    String type = (String)request.getAttribute("type");
    boolean isOK = (boolean)request.getAttribute("isOK");
    if (type.equals("addHomework")){
        if (isOK){
%>

<p style="margin:300px; font-family: Arial; font-size: 25px; color: pink;align:center"><%="布置作业成功!"%></p>

<%
}else{
%>

<p style="margin:300px; font-family: Arial; font-size: 25px; color: pink;align:center"><%="布置作业失败!!!"%></p>

<%
    }
}else if (type.equals("addStudent")){
    if (isOK){
%>

<p style="margin: 300px; font-family: Arial; font-size: 25px; color: pink;align:center"><%="添加学生成功!"%></p>

<%
}else{
%>

<p style="margin: 300px; font-family: Arial; font-size: 25px; color: pink;align:center"><%="已有学生信息!无法添加！"%></p>

<%
    }
}else if (type.equals("addStudentHomework")){
    if (isOK){
%>

<p style="margin:300px; font-family: Arial; font-size: 25px; color: pink;align:center"><%="作业提交成功!"%></p>

<%
}else {
%>

<p style="margin:300px; font-family: Arial; font-size: 25px; color: pink;align:center"><%="作业提交失败!"%></p>

<%
        }
    }
%>
<a href="/mavenweb_war_exploded/homework" style="margin: 150px">返回主页</a>
</body>
</html>