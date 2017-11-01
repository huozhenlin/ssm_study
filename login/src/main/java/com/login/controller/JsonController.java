package com.login.controller;

import com.google.gson.Gson;
import com.login.dao.IUserDao;
import com.login.model.User;
import com.login.service.impl.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hzl on 2017/4/2.
 */

@Controller
public class JsonController {

    //自动注入业务层userservice类
    @Autowired
    UserService userService;
    private static ApplicationContext ac;
    static {
        ac=new ClassPathXmlApplicationContext("spring-mybatis");
    }

    @RequestMapping(value = "/exist", method = RequestMethod.GET)
    @ResponseBody
    public String signin(HttpServletRequest request){
        IUserDao mapper= (IUserDao) ac.getBean("IUserDao");
        String username=request.getParameter("username");
        System.out.println(username);
        boolean loginType =userService.isExist(username);

        String message = "";
        if(loginType) {

            User user=mapper.selectByName(username);
            String pic_url=user.getPic();
            message = "code:true:"+pic_url;


        }else{
            message="code:false";

        }
        return message;
    }
}
