package com.bootjdbc.demo.config;/**
 * @Auther:haha
 * @Date:2021/4/23 - 04 - 23 23:10
 * @Description:com.hyy.config
 * @Version: 1.0
 */


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * MyLocalResolver
 * <功能详细描述>
 *
 * @author 国际化解析器
 * @version [版本号, 2021/4/23 23:10]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
public class MyLocalResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
       //获取请求中的语言参数
      String language=  httpServletRequest.getParameter("lang");
        System.out.println("debug===================="+language);

        Locale  locale= Locale.getDefault();//如果没有就是用默认的
        //如果请求的链接携带了地区化的参数 就通过取值
        if(!StringUtils.isEmpty(language)){
          String[] split=  language.split("_");
          //国家  地区
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }

}
