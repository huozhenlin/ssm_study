<%@ page import="com.login.model.User" %>
<%@ page import="java.io.PrintWriter" %><%--
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


<html>
<head>
    <title>Title</title>
</head>
<body>
操作成功
<%=request.getSession().getAttribute("user")
%>
<a href="/logout">退出登录</a>

</body>
</html>
