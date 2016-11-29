package com.demo.swagger.springmvc;


import com.demo.swagger.springmvc.web.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TestSpring类描述:
 *
 * @author yangzhenlong
 * @since 2016/11/16
 */
public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        User user = context.getBean(User.class);
        user.setName("123");
        System.out.println(user.getName());
    }
}
