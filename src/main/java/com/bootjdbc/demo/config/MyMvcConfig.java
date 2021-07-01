package com.bootjdbc.demo.config;/**
 * @Auther:haha
 * @Date:2021/4/23 - 04 - 23 16:40
 * @Description:com.hyy.config
 * @Version: 1.0
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * MyMvcConfig
 * <功能详细描述>
 *
 * @author
 * @version [版本号, 2021/4/23 16:40]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //urlPathOrPattern是自己定义的请求地址 setViewname是实际的页面名称
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }


    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }

    }
    //自定义的国际化组件生效了
    @Bean
    public LocaleResolver localeResolver1(){
        return new com.bootjdbc.demo.config.MyLocalResolver();
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new com.bootjdbc.demo.config.LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/css/*","/img/*","/js/*");
    }
}
