package com.login.HandlerIntercetor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hzl on 2017/4/5.
 */
public class LoginIntercetor implements HandlerInterceptor {

//    任何请求先执行到这个方法
//    返回值，表示我们是否需要将当前的请求拦截下来
//    false表示请求被终止
//    true表示会继续执行
//    arg2表示被拦截的请求的目标地址
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("执行到preHandle方法--------");
        String session= (String) httpServletRequest.getSession().getAttribute("user");
        if(session!=null){
            System.out.println("session值是："+session);
            return true;
        }
        httpServletResponse.sendRedirect("/login2.html");
        return false;
    }

//    请求结束后才到这方法
//    修改视图
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("执行到postHandle方法--------");
    }

//    释放资源
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("执行到afterCompletion方法--------");
    }
}
