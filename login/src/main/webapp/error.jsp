<%@ page import="com.login.model.User" %><%--
  Created by IntelliJ IDEA.
  User: hzl
  Date: 2017/3/29
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<% String s= (String) request.getAttribute("message");
System.out.println(s);
%>
操作失败
<a href="<%=path%>/login2.html">返回</a>

</body>
</html>
