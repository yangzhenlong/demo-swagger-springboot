# demo-swagger-springboot
springboot中swaggerUI的使用
#1.pom文件中添加swagger依赖
#2.从github项目中下载<a href="https://github.com/swagger-api/swagger-ui">swaggerUI</a>
  然后把dist目录下的所有文件复制到springboot项目的webapp下面，修改index.html中的：
  url = "http://petstore.swagger.io/v2/swagger.json";为--------->
  url="http://localhost:8080/api-docs";
#3.spring boot启动类
    public static void main(String[] args) {
        SpringApplication.run(IndexController.class,args);
    }

    /** 配置 swagger开始*/
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
    /** 配置 swagger结束*/

#4. 添加测试rest接口类：
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
#5 访问http://localhost:8080/api-docs，返回：
    {
    "apiVersion": "1.0",
    "apis": [
      {
        "description": "Basic Error Controller",
        "path": "/default/basic-error-controller",
        "position": 0
      },
      {
        "description": "Hello Controller",
        "path": "/default/hello-controller",
        "position": 0
      }
    ],
    "authorizations": {

    },
    "info": {
      "contact": "younaame@yourmail.com",
      "description": "这是一个描述信息。。。",
      "license": "2222222222222222222222222222",
      "licenseUrl": "3333333333333333333333333333",
      "termsOfServiceUrl": "termsOfServiceUrl",
      "title": "测试接口文档(标题)"
    },
    "swaggerVersion": "1.2"
  }
  说明配置正确。
  然后再访问：http://localhost:8080/swagger/index.html，查看restful风格接口信息和效果。
