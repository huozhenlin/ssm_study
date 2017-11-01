package com.login.controller;

import com.login.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hzl on 2017/4/3.
 */

@Controller
public class MailController {
    //自动注入业务层userservice类
    @Autowired
    UserService userService;


    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public String sendMail(HttpServletRequest request){
        String password=request.getParameter("email");
        System.out.println(password);
        boolean ok =userService.findUser(password);
        String message = "";
        if(ok){
            message="status:ok";
        }else {
            message="staus:fail";
        }
        return message;
    }

    @RequestMapping(value = "checkmail",method = RequestMethod.GET)
    @ResponseBody
    public String checkMail(HttpServletRequest request){
        String mail=request.getParameter("email");
        System.out.println("执行检查邮箱是否被注册"+mail);
        boolean ok=userService.checkMail(mail);
        String message="";
        if(ok){
            message="status:ok";

        }else {
            message="status:fail";
        }
        return message;
    }
}
