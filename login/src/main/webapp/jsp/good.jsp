<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.login.model.User" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.login.dao.IUserDao" %><%--
  Created by IntelliJ IDEA.
  User: hzl
  Date: 2017/3/29
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--获取上下文路径--%>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../CSS/page_index.css" type="text/css">
    <script type="text/javascript" src="../js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="../js/page_index.js"></script>
    <script type="text/javascript" src="../js/selectuser.js"></script>
    <title>主页</title>
    <style type="text/css">
        h1{
            text-align:center;
        }
        table{
            margin: 0px auto;
            margin-top: 30px;
        }
        td{
            padding: 10px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>商品表</h1>
<table style="border: 1px solid black">
    <td>型号</td><td>链接</td><td>价格</td>

<c:forEach items="${gods}" var="gods" >
    <tr style="border: 1px solid black">
        <td>${gods.goods_name}</td>
        <td>${gods.goods_link}</td>
        <td>${gods.goods_price}</td>
   </tr>
</c:forEach>
</table>
</body>
</html>