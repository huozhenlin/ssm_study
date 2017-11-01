package com.login.controller;

import com.login.dao.IUserDao;
import com.login.model.User;
import com.login.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by hzl on 2017/3/29.
 */


@Controller   //注解用于表示本类为web控制组件
@Scope("prototype")   //默认情况下springmvc都是单例模式，用scope标注表示每次都创建一个实例
public class UserController {
    //自动注入业务层userservice类
    @Autowired
    UserService userService;
    private static ApplicationContext ac;

    static {
        ac = new ClassPathXmlApplicationContext("spring-mybatis");
    }

    //login业务访问的位置为/user/login
    //登录验证的方法
    @RequestMapping("/login")
    public String login(User user, HttpSession session, HttpServletRequest request) {
        //调用login方法验证是否是注册用户
        boolean loginType = userService.login(user.getUsername(), user.getPassword());
        //忽略大小写
        if (!(user.getCode().equalsIgnoreCase(session.getAttribute("code").toString()))) {

//            验证码错误直接回到错误页面
            System.out.println(user.getCode());
            return "error.jsp";
        } else if (loginType) {
            //如果通过，则将用户信息传到前台
            request.getSession().setAttribute("user", user.getUsername());
            //并跳转到success.jsp页面
            //return "success.jsp";
            return "jsp/index.jsp";
        } else {
            //如果不对
            //则将错误信息显示到错误页面
            request.getSession().setAttribute("message", "用户名或密码错误");
            return "error.jsp";
        }
    }


    //注销登录
    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //判断session是否为空
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("/login2.html");
            return;
        }
        session.removeAttribute("user");
        response.sendRedirect("/login2.html");
    }

    /**
     * 修改个人信息
     */
    @RequestMapping("alterUser")
    public String alterUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.print(request.getParameter("username"));
        System.out.print(request.getParameter("password"));
        IUserDao mapper = (IUserDao) ac.getBean("IUserDao");
        mapper.alter(username, password);
        return "login2.html";
    }


    /**
     * @param user
     * @param session
     * @param request
     * @return 注册成功后跳转
     */
    @RequestMapping("/addUser")
    public String addUser(User user, HttpSession session, HttpServletRequest request,
                          @RequestParam(value = "file", required = false) MultipartFile file) {
        //忽略大小写
        if (!(user.getCode().equalsIgnoreCase(session.getAttribute("code").toString()))) {

//            验证码错误直接回到错误页面
            System.out.println(user.getCode());
            return "error.jsp";
        } else {
            try {
//                如果邮件不为空就执行带三个参数的方法
                System.out.println("-----------");
                System.out.println(user.getPassword() + " " + user.getUsername() + " " + user.getEmail());
                System.out.println("---------**");
                //获得物理路径webapp所在路径
                System.out.println("---------**-----------");
                String names = request.getParameter("email");
                System.out.println("获取到的用户名是" + names);
                String pathRoot = request.getSession().getServletContext().getRealPath("");
                String path = "";
                if (!file.isEmpty()) {
                    //生成uuid作为文件名称
                    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                    //获得文件类型（可以判断如果不是图片，禁止上传）
                    String contentType = file.getContentType();
                    //获得文件后缀名称
                    String imageName = contentType.substring(contentType.indexOf("/") + 1);
                    path = uuid + "." + imageName;
                    file.transferTo(new File("D:\\bfp\\" + path));
                }
                System.out.println(path);
                request.setAttribute("imagesPath", path);
                IUserDao mapper = (IUserDao) ac.getBean("IUserDao");

                mapper.addUsers(user.getUsername(), user.getPassword(), user.getEmail(), path);
//                userService.addUser(user.getUsername(),
//                        user.getPassword(),
//                        user.getEmail(),
//
                return "login2.html";

            } catch (Exception e) {

//                错误的话会到错误页码
                return "error.jsp";
            }


        }
    }

}