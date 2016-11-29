package com.demo.swagger.springmvc.web;


import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * IndexController类描述:
 *
 * @author yangzhenlong
 * @since 2016/11/16
 */
@EnableSwagger
@SpringBootApplication
@EnableAutoConfiguration
public class IndexController {

    public static void main(String[] args) {
        SpringApplication.run(IndexController.class,args);
    }


    private SpringSwaggerConfig springSwaggerConfig;

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }


    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
     * framework - allowing for multiple swagger groups i.e. same code base
     * multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?");
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "测试接口文档(标题)", // App Service API
                "这是一个描述信息。。。",
                "termsOfServiceUrl",
                "younaame@yourmail.com",
                "2222222222222222222222222222",
                "3333333333333333333333333333");
        return apiInfo;
    }

   /* public ApiInfo(String title, String description, String termsOfServiceUrl, String contact, String license, String licenseUrl) {
        this.title = title;
        this.description = description;
        this.termsOfServiceUrl = termsOfServiceUrl;
        this.contact = contact;
        this.license = license;
        this.licenseUrl = licenseUrl;
    }*/
}
