package com.demo.swagger.springmvc.web;


import org.springframework.stereotype.Component;

/**
 * User类描述:
 *
 * @author yangzhenlong
 * @since 2016/11/16
 */
@Component
public class User {
    String name;
    String otherInfo;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
