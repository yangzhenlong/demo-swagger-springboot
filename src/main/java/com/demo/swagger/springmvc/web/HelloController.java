package com.demo.swagger.springmvc.web;


import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController类描述:
 *
 * @author yangzhenlong
 * @since 2016/11/29
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    @ApiOperation(value = "添加用户",httpMethod ="POST", response = User.class,notes = "HelloWorld")
    public User hello(@ApiParam(required = true,name = "paramData",value = "用户信息 json 数据") String paramData){
        User userBean = new User();
        userBean.setName("测试用户");
        userBean.setOtherInfo("其他信息");
        return userBean;
    }
}
