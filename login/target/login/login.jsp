<%--
  Created by IntelliJ IDEA.
  User: hzl
  Date: 2017/3/29
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--获取上下文路径--%>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form name="form1" action="/login.do" method="post">
        <table width="300" border="1px solid black" align="center">

            <tr>
                <td colspan="2">登入窗口</td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="submit" value="登录"/>
                    <span><a href="/register">没有账号？</a></span>
                </td>

            </tr>
        </table>

    </form>
</body>
</html>
