package com.bootjdbc.demo.config;/**
 * @Auther:haha
 * @Date:2021/4/25 - 04 - 25 22:30
 * @Description:com.hyy.config
 * @Version: 1.0
 */

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginHandlerInterceptor
 * <功能详细描述>
 *
 * @author  拦截器 判断是否登入成功 进入首页 没登入成功是无法直接访问首页
 * @version [版本号, 2021/4/25 22:30]
 * @see  [相关类/方法]
 * @since [产品/模块版本]
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后 应该有用户的session
        Object loginUser =  request.getSession().getAttribute("loginUser");
        if (loginUser==null){
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            return true;
        }

    }
}
