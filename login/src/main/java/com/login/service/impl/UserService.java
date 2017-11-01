package com.login.service.impl;

import com.login.model.User;

/**
 * Created by hzl on 2017/3/29.
 */


//登陆接口
public interface UserService {


    public boolean login(String username,String password);//是否登录成功

    public boolean addUser(String username,String password);//增加用户，两个参数

    public boolean addUser(String username,String password,String email,String file);//增加用户，三个参数

    public boolean isExist(String username);//检测用户是否已存在

    public boolean findUser(String email);//通过邮件找回密码

    public boolean checkMail(String email);//检测邮箱是否被占用
}
