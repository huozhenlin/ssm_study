import com.google.gson.Gson;
import com.login.dao.IGoodsDao;
import com.login.dao.IUserDao;
import com.login.model.Good;
import com.login.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by hzl on 2017/3/29.
 */
public class Test {
    private static ApplicationContext ac;
    static {
        ac=new ClassPathXmlApplicationContext("spring-mybatis");
    }
    public static void main(String[] args){
//        IUserDao mapper= (IUserDao) ac.getBean("IUserDao");
//        System.out.println("获取alvin");
//        User user=mapper.selectByName("alvin");
//
//        System.out.println(user.getUsername());
        IGoodsDao mapper= (IGoodsDao) ac.getBean("IGoodsDao");
        IUserDao mapper2= (IUserDao) ac.getBean("IUserDao");
//        mapper.insert("mi6","www.xm.com",2499);
       // mapper.delete("mi5");
       // mapper.update("p10","www.huawei.com",3999);
//        List<Good>list=mapper.select_all_goods();
//        Gson gson=new Gson();
//        System.out.println(gson.toJson(list));
//        Good good=mapper.select_by_id();
//        List<Good> goods = mapper.select_all_goods();
//        for (Good god:goods) {
//            System.out.println(god.getGoods_name());
//        }
//        System.out.println(good.getGoods_link());
//        IGoodsDao mapper= (IGoodsDao) ac.getBean("IGoodsDao");
//        mapper.insert("sdf");
//         Good good=mapper.select_by_id(1);
//        System.out.println(good.getGoods_link());
//        System.out.println("password"+user.getPassword());
         //mapper.addUsers("huozhenl","1234","1@22.com","sdsafs");

//        User user1=mapper.selectById(1);
//        System.out.println(user1.getPassword());
//        User user2=mapper.selectByNameandPass("huo","1234");
//        System.out.println(user2.getPassword());
//        User user=mapper.selectByName("huozhenlin");
//        System.out.println(user.getUsername());
//        SendMail SendMail=new SendMail();
//        try {
//            SendMail.send("woaini","1031734796@qq.com");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        user=mapper.findPassword("1031734796@qq.com");
//        System.out.println(user.getPassword()+user.getUsername());
//        SendMail mail=new SendMail();
//        try {
//            mail.send("123","1031734796@qq.com");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        mapper.addUser("woaini","1234","132@qq.com");
//        mapper.checkmail("1031734796@qq.com");
        mapper2.alter("alvin","12346");
    }
}
