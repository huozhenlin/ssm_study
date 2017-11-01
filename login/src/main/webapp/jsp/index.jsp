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
</head>
<body>
<!--顶部导航栏-->
<div id="nav_top">
    <div id="nav_top_right">
        <img id="user_image" src="../img/1440221163863.jpeg" >

    </div>
</div>

<!--悬浮窗，用于修改个人资料-->
<div id="about" style="display: none">
    <ul>
        <li class="profile">我的资料</li>
        <li>我的好友</li>
        <li>我的收藏</li>
    </ul>
    <button class="exit">退出登录</button>
</div>
<div>
    <iframe id="goods" style="width: 100%"height="500px" src="./qwe"></iframe>
</div>
<div id="changpro" style="display: none; width:800px;height:500px;margin: 0 auto">
    <iframe id="ResultShowFrame" style="width:800px;height: 500px;margin: 0 auto" src="./jsp/changprofile.html"></iframe>
</div>


</body>
<script>
    //退出按钮被点击

    var x=true;
    var z=true;
    var s="<%=request.getSession().getAttribute("user")%>";
    <%
        ApplicationContext ac;
        ac=new ClassPathXmlApplicationContext("spring-mybatis");
        IUserDao mapper= (IUserDao) ac.getBean("IUserDao");
    %>
    changImg(s)

    $('.exit').click(function () {
        window.location.href='/logout'
    });
    $('#user_image').click(function () {
        if(x){
            $('#about').css('display','block');
            x=false
        }else {
            $('#about').css('display','none');
            x=true
        }

    });

    $('.profile').click(function () {
        $('#about').css('display','none');
        x=true;
        if(z){

            $('#changpro').css('display','block');
            ExecuteSql();
            z=false
        }else {
            $('#changpro').css('display','none');
            z=true
        }
    });
    function ExecuteSql()
    {
        <% String b=(String) request.getSession().getAttribute("user");%>
        <% User user=mapper.selectByName(b);%>
        var FormObj = document.getElementById("ResultShowFrame").contentWindow;
        FormObj.document.getElementById("txtUserName").value=s;
        FormObj.document.getElementById("email").value="<%=user.getEmail()%>";

    }



</script>
</html>