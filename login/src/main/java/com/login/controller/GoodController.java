package com.login.controller;

import com.google.gson.Gson;
import com.login.dao.IGoodsDao;
import com.login.model.Good;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hzl on 2017/4/25.
 */
@Controller
public class GoodController {

    private static ApplicationContext ac;

    static {
        ac=new ClassPathXmlApplicationContext("spring-mybatis");
    }

    @RequestMapping(value = "qwe")
    public String qwe(Model model) {
        Gson gson=new Gson();
        IGoodsDao mapper= (IGoodsDao) ac.getBean("IGoodsDao");
        List<Good> goods = mapper.select_all_goods();
        gson.toJson(goods);
        model.addAttribute("gods",goods);
        for (Good god:goods) {
            System.out.println(god.getGoods_name());
        }
        return "jsp/good.jsp";
    }
}
